package Servlets;

import Models.UserModel;
import Database.DBUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

@WebServlet(name = "allUsersServlet", value = "/allUsersServlet")
public class AllUsersServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        request.getRequestDispatcher("adminEmployees.jsp").forward(request, response);
        PrintWriter out = response.getWriter();
        UserModel model = null;

        String firstname = request.getParameter("Firstname");
        String lastname = request.getParameter("Lastname");
        String phone = request.getParameter("Phone");
        String username = request.getParameter("Username");

        getServletContext().getRequestDispatcher("/adminEmployees.jsp").forward(request, response);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        UserModel model = null;

        try {
            out.println("<table>");
            out.println("<tr>");
            out.println("<th>Fornavn</th>");
            out.println("<th>Etternavn</th>");
            out.println("<th>Tlf</th>");
            out.println("<th>Brukernavn</th>");
            out.println("</tr>");

            Collection<UserModel> users = getUsers(out);
            for (UserModel user : users) {
                out.println("<tr>");
                out.println("<td>" + user.getFirstName() + "</td>");
                out.println("<td>" + user.getLastName() + "</td>");
                out.println("<td>" + user.getPhone() + "</td>");
                out.println("<td>" + user.getUserName() + "</td>");
                out.println("</tr>");
            }
            out.println("</table>");
        } catch (SQLException | ClassNotFoundException ex) {
            out.println(ex.getMessage());
        }

        getServletContext().getRequestDispatcher("/adminEmployees.jsp").forward(request, response);
    }


    private Collection<UserModel> getUsers(PrintWriter out) throws SQLException, ClassNotFoundException {
        ArrayList<UserModel> result = new ArrayList<>();

        Connection db = DBUtils.getINSTANCE().getConnection(out);
        String query3 = "select * from USER";
        PreparedStatement statement = db.prepareStatement(query3);
        ResultSet rs = statement.executeQuery();

        while (rs.next()) {
            result.add(new UserModel(
                    rs.getInt("UserID"),
                    rs.getString("Fname"),
                    rs.getString("Lname"),
                    rs.getString("Phone"),
                    rs.getString("Username"),
                    rs.getString("Password")
            ));
        }
        return result;
    }
}