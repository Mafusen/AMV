package bacit.web.Web.JSP_connecters;

import bacit.web.DAOs.FileDAO;
import bacit.web.DAOs.ToolDAO;
import bacit.web.DAOs.UserDAO;
import bacit.web.Models.FileModel;
import bacit.web.Models.ToolModel;
import bacit.web.Models.UserModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet (name = "admin/slettBruker", value = "/admin/slettBruker")
public class DeleteUser extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String IDString = request.getParameter("userID");
        int userID = Integer.parseInt(IDString);

        UserDAO uDao = new UserDAO();
        UserModel user = uDao.userByID(userID);

        request.setAttribute("user", user);

        request.getRequestDispatcher("/deleteUser.jsp").forward(request, response);
    }

}
