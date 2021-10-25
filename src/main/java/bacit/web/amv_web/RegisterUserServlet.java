package bacit.web.amv_web;

import bacit.web.amv_DAO.UserDAO;
import bacit.web.amv_models.UserModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "registerUserServlet", value = "/registerUserServlet")
public class RegisterUserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        // Collect form data
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String firstName = request.getParameter("fname");
        String lastName = request.getParameter("lname");
        String phone = request.getParameter("phone");

        // Insert in constructor for UserModel
        UserModel user = new UserModel(username, password, firstName, lastName, password);

        // Call DAO layer and save the user object to DB
        UserDAO dao = new UserDAO();
        dao.registerUser(user);

        // Prepare information message for user about operation result

    }

}
