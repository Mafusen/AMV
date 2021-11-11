package bacit.web.amv_web;

import bacit.web.amv_DAO.UserDAO;
import bacit.web.amv_models.UserModel;

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

@WebServlet(name = "admin/registerUser", value = "/admin/registerUser")
public class RegisterUserServlet extends HttpServlet {


        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

            // Collect form data
            String username = request.getParameter("userName");
            String password = request.getParameter("passWord");
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String phone = request.getParameter("phone");

            // Insert in constructor for UserModel
            UserModel model = new UserModel(1, username, password, firstName, lastName, phone, true);

            // Call DAO layer and save the user object to DB
            UserDAO uDao = new UserDAO();
            uDao.registerUser(model);

            response.sendRedirect("adminEmployees.jsp");
        }
}
