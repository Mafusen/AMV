package Servlets;

import DAOs.UserDAO;
import Models.UserModel;
import Database.DBUtils;

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "getUserServlet", value = "/getUserServlet")
public class GetUserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Collect search string from the form
        String searchString = request.getParameter("search");

        // Call DAO layer and get all products for search criteria
        UserDAO dao = new UserDAO();
        List<UserModel> model = null;
        try {
            model = dao.searchUsers(searchString);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        request.setAttribute("model", model);
        request.getRequestDispatcher("/adminEmployees.jsp").forward(request, response);

        // Write the products' data back to the client browser
        /*String page = getHTMLString(request.getServletContext().getRealPath("bacit/web/bacit_web/EXP.html"), model);
        response.getWriter().write(page);*/
    }

    public String getHTMLString(String filepath, List<UserModel> users) throws IOException{
        BufferedReader reader = new BufferedReader(new FileReader(filepath));
        String line = "";
        StringBuffer buffer = new StringBuffer();
        while((line=reader.readLine())!=null){
            buffer.append(line);
        }
        reader.close();
        String page = buffer.toString();

        page = MessageFormat.format(page, users.get(0).getUserID(), users.get(1).getUserID(),
                users.get(0).getFirstName(),users.get(1).getFirstName(),
                users.get(0).getLastName(), users.get(1).getLastName(),
                users.get(0).getPhone(), users.get(1).getPhone(),
                users.get(0).getUserName(), users.get(1).getUserName(),
                users.get(0).getPhone(), users.get(1).getPhone(),
                users.get(0).getPassword(), users.get(0).getPassword(), 0);
        return page;
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("Username");
        PrintWriter out = response.getWriter();

        UserModel model = null;
        try {
            model = getUser(username, out);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        assert model != null;
        out.println("Brukernavn: " + model.getUserName());
        out.println("Fornavn: " + model.getFirstName());
        out.println("Etternavn: " + model.getLastName());
        out.println("Telefon: " + model.getPhone());

    }

    private UserModel getUser(String Username, PrintWriter out) throws SQLException {
        Connection db = null;
        try {
            db = DBUtils.getINSTANCE().getConnection(out);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String query3 = "select * from user where Username = ?";
        PreparedStatement statement = db.prepareStatement(query3);
        statement.setString(1, Username);
        ResultSet rs = statement.executeQuery();
        UserModel model = null;
        while (rs.next()) {
            model =
                    new UserModel(rs.getInt("UserID"),
                            rs.getString("Fname"),
                            rs.getString("Lname"),
                            rs.getString("Phone"),
                            rs.getString("Username"),
                            rs.getString("Password"));
        }
        return model;
    }

    public void destroy() {
    }
}
