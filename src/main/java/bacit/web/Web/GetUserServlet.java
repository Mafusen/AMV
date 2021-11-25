package bacit.web.Web;


import bacit.web.DAOs.UserDAO;
import bacit.web.Models.UserModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "minSide", value = "/minSide")
public class GetUserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getRemoteUser();

        UserDAO uDao = new UserDAO();

        UserModel user = uDao.getUser(username);

        request.setAttribute("user", user);
        request.getRequestDispatcher("myPage.jsp").forward(request, response);

    }
}
