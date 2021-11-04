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
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession(true);
        PrintWriter out = null;

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

                // Create cookie with name and value to store logged-in user's username
                // and add cookie object to response
                Cookie cookie = new Cookie ("Username", username);
                cookie.setMaxAge(60);
                response.addCookie(cookie);

                // Set userID as attribute to request and forward to productPage
                request.setAttribute("userID", userID);
                request.getRequestDispatcher("productPage.jsp").forward(request, response);

            }

            // Send client back to login-page if not valid
            else
                response.sendRedirect("index.jsp"); //error page
        }


        catch (Throwable theException)
        {
            System.out.println(theException);
        }

        // Dispatch the request to index.jsp
        // RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
        // dispatcher.include(request, response);

    }
}



/*    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, java.io.IOException {

        try
        {

            UserModel user = new UserModel();
            user.setUserName(request.getParameter("Username"));
            user.setPassWord(request.getParameter("Password"));

            user = UserDAO.login(user);

            if (user.isValid())
            {

                HttpSession session = request.getSession(true);
                session.setAttribute("currentSessionUser",user);
                response.sendRedirect("productPage.jsp"); //logged-in page
            }

            else
                response.sendRedirect("index.jsp"); //error page
        }


        catch (Throwable theException)
        {
            System.out.println(theException);
        }*/
