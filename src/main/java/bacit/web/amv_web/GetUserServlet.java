package bacit.web.amv_web;

import bacit.web.amv_models.UserModel;

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "getUserServlet", value = "/getUserServlet")
public class GetUserServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1></h1>");
        out.println("<h1>Finn informasjon om bruker</h1>");
        out.println("<form method='post'>");
        out.println("  <label for='Username'>Brukernavn:</label>");
        out.println("  <input type='text' name='Username'/>");
        out.println("  <input type='submit' />");
        out.println("</form>");
        out.println("</body></html>");
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

        out.println("Brukernavn: " + model.getUserName());
        out.println("Fornavn: " + model.getfirstName());
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

        String query3 = "select * from USER where Username = ?";
        PreparedStatement statement = db.prepareStatement(query3);
        statement.setString(1, Username);
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



    public void destroy() {
    }
}
