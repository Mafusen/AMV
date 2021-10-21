package Servlets;

import java.io.IOException;
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

        String html = "<html><h3>LOGIN</h3><html>";
        response.getWriter().write(html + "");

        // Dispatch the request to index.jsp
        RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
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
                response.sendRedirect("index.jsp"); //error page
        }


        catch (Throwable theException)
        {
            System.out.println(theException);
        }*/