package bacit.web.bacit_web;

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet (name = "registerUserServlet", value = "/registerUserServlet")
public class RegisterUserServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<head>");
        out.println("<title>Registrer ny bruker</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h2>Registrer ny bruker</h2>");
        out.println("<form method='post'>");
        out.println("  <label for='Firstname'>Fornavn:</label>");
        out.println("  <input type='text' name='Firstname'/>");
        out.println("  <label for='Lastname'>Etternavn:</label>");
        out.println("  <input type='text' name='Lastname'/>");
        out.println("  <label for='Phone'>Telefon:</label>");
        out.println("  <input type='text' name='Phone'/>");
        out.println("  <label for='Username'>Brukernavn:</label>");
        out.println("  <input type='text' name='Username'/>");
        out.println("  <label for='Password'>Passord:</label>");
        out.println("  <input type='text' name='Password'/>");
        out.println("  <input type='submit' />");
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String firstname = request.getParameter("Firstname");
        String lastname = request.getParameter("Lastname");
        String phone = request.getParameter("Phone");
        String username = request.getParameter("Username");
        String password = request.getParameter("Password");

        UserModel model = null;
        try {
            model = createUser(firstname, lastname, phone, username, password, out);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        out.println("Bruker registrert: ");
        out.println("   Fornavn: " + firstname);
        out.println("   Etternavn: " + lastname);
        out.println("   Telefon: " + phone);
        out.println("   Brukernavn: " + username);


    }

    private UserModel createUser(String Fname, String Lname, String Phone, String Username, String Password, PrintWriter out) throws SQLException{

        Connection db = null;
        try {
            db = DBUtils.getINSTANCE().getConnection(out);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String query = "insert into USER (Fname, Lname, Phone, Username, Password) values (?, ?, ?, ?, ?)";
        PreparedStatement statement = db.prepareStatement(query);
        statement.setString(1, Fname);
        statement.setString(2, Lname);
        statement.setString(3, Phone);
        statement.setString(4, Username);
        statement.setString(5, Password);
        ResultSet rs = statement.executeQuery();
        UserModel model = null;
        while (rs.next()) {
            model =
                    new UserModel(rs.getString("Fname"), rs.getString("Lname"),
                            rs.getString("Phone"), rs.getString("Username"),
                            rs.getString("Password"));
        }
        return model;


    }
}
