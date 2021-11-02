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
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "logInServlet", value = "/logInServlet")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession(true);
        PrintWriter out = null;

        try
        {

            UserModel user = new UserModel();
            user.setUserName(request.getParameter("Username"));
            user.setPassWord(request.getParameter("Password"));

            UserDAO.login(user);

            if (user.isValid())
            {
                String username = request.getParameter("Username");

                // Call DAO layer and get specified user's attributes
                UserModel model;
                UserDAO dao = new UserDAO();
                model = dao.getUser(username);
                int userID = model.getUserID();

                request.setAttribute("userID", userID);
                response.sendRedirect("productPage.jsp"); //logged-in page
            }

            else
                response.sendRedirect("login.jsp"); //error page
        }


        catch (Throwable theException)
        {
            System.out.println(theException);
        }

        // Dispatch the request to login.jsp
        RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
        dispatcher.include(request, response);

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
                response.sendRedirect("login.jsp"); //error page
        }


        catch (Throwable theException)
        {
            System.out.println(theException);
        }*/
