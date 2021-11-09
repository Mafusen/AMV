package bacit.web.amv_web;

import bacit.web.amv_DAO.UserDAO;
import bacit.web.amv_models.UserModel;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;


@WebServlet(name = "logInServlet", value = "/logInServlet")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try
        {
            // Create new instance of UserModel and set fields to parameter from request
            UserModel user = new UserModel();
            user.setUserName(request.getParameter("Username"));
            user.setPassWord(request.getParameter("Password"));

            // Log in user with method login in UserDAO
            UserDAO.login(user);

            // Check if user is a valid user
            if (user.isValid())
            {
                String username = request.getParameter("Username");

                // Call DAO layer and get specified user's attributes
                UserModel model;
                UserDAO dao = new UserDAO();
                model = dao.getUser(username);
                int userID = model.getUserID();

                // Create session object with name and value to store logged-in user's username
                // and add username as attribute in session to response
                HttpSession session = request.getSession(true);
                session.setAttribute("username", username);

                // Set userID as attribute to request and forward to productPage
                request.setAttribute("userID", userID);
                response.sendRedirect("frontpageServlet");

            }

            // Send client back to login-page if not valid
            else
                response.sendRedirect("index.jsp"); //error page
        }


        catch (Throwable theException)
        {
            System.out.println(theException);
        }

    }

    public void roleCheck(){
        HttpServletRequest request = null;
        if ( request.isUserInRole("root") ||
                (request.isUserInRole("privileged") &&
                        request.isUserInRole("merchandise")) ) {
        }
    }
}

