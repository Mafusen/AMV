package bacit.web.bacit_web;

import java.io.IOException;
import java.io.InputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet(name = "NewToolServlet", value = "/NewToolServlet")
@MultipartConfig(maxFileSize = 16177215)
// upload file's size up to 16MB
public class NewToolServlet extends HttpServlet {
    private static final int BUFFER_SIZE = 4096;
    // database connection settings
    private String dbURL = "jdbc:mariadb://172.17.0.1:3308/AMVDB";
    private String dbUser = "root";
    private String dbPass = "12345";

    //oppretter connection til databasen
    private Connection getConnection() {
        Connection conn = null;
        try {
            DriverManager.registerDriver(new org.mariadb.jdbc.Driver());
            conn = DriverManager.getConnection(dbURL, dbUser, dbPass);
        } catch (Exception e) {
            //wrapping any exception and rethrowing it
            //inside a RuntimeException
            //so the method is silent to exceptions
            throw new RuntimeException("Failed to obtain database connection.", e);
        }
        return conn;
    }

/*    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        doPost(request, response);
    }*/

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //get values of text fields
        String toolname = request.getParameter("toolName");
        String toolinfo = request.getParameter("toolInfo");
        String toolprice = request.getParameter("toolPrice");
        InputStream inputStream = null; // inputstreamen til bildet som blir lastet opp
        // obtains the upload file part in this multipart request
        Part filePart = request.getPart("picture");
        if (filePart != null) {
            // debugging
            System.out.println(filePart.getName());
            System.out.println(filePart.getSize());
            System.out.println(filePart.getContentType());

            //obtains input stream of the upload file
            //the InputStream will point to a stream that contains
            //the contents of the file
            inputStream = filePart.getInputStream();
        }

        Connection conn = null; // connection to the database
        String message = null; // message will be sent back to client
        try {
            // connects to the database
            conn = getConnection();
            // constructs SQL statement
            String sql = "INSERT INTO TOOL (Tool_Name, Tool_Info, Price, Picture) values (?, ?, ?, ?)";
            //Using a PreparedStatement to save the file
            PreparedStatement pstmtSave = conn.prepareStatement(sql);
            pstmtSave.setString(1, toolname);
            pstmtSave.setString(2, toolinfo);
            pstmtSave.setInt(3, Integer.parseInt(toolprice));

            if (inputStream != null) {
                //files are treated as BLOB objects in database
                //here we're letting the JDBC driver
                //create a blob object based on the
                //input stream that contains the data of the file
                pstmtSave.setBlob(4, inputStream);
            }
            //sends the statement to the database server
            int row = pstmtSave.executeUpdate();
            if (row > 0) {
                message = "File uploaded and saved into database";
            }

            String filepath = "C:/Users/msbak/Dropbox/IS-200/AMV/database/AMVDB";
            //Obtaining the file from database
            //Using a second statement
            String sql1 = "SELECT Picture FROM TOOL WHERE Tool_Name=? AND Tool_Info=? AND Price=?";
            PreparedStatement pstmtSelect = conn.prepareStatement(sql1);
            pstmtSelect.setString(1, toolname);
            pstmtSelect.setString(2, toolname);
            pstmtSelect.setInt(3, Integer.parseInt(toolprice));
            ResultSet result = pstmtSelect.executeQuery();
            if (result.next()) {
                Blob blob = result.getBlob("photo");
                InputStream inputStream1 = blob.getBinaryStream();
                OutputStream outputStream = new FileOutputStream(filepath);
                int bytesRead = -1;
                byte[] buffer = new byte[BUFFER_SIZE];
                while ((bytesRead = inputStream1.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                }
                inputStream1.close();
                outputStream.close();
                System.out.println("File saved");
            }
        } catch (SQLException ex) {
            message = "ERROR: " + ex.getMessage();
            ex.printStackTrace();
        } finally {
            if (conn != null) {
                // closes the database connection
                try {
                    conn.close();
                } catch (SQLException ex) {
                    //silent
                }
            }
            // sets the message in request scope
            request.setAttribute("message", message);

            // forwards to the message page
            getServletContext().getRequestDispatcher("/Message.jsp")
                    .include(request, response);
        }
    }
}
