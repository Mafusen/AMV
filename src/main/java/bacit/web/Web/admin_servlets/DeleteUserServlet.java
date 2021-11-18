package bacit.web.Web.admin_servlets;

import bacit.web.DAOs.UserDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet (name = "admin/sletting", value = "/admin/sletting")
public class DeleteUserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String IDString = request.getParameter("userID");
        int userID = Integer.parseInt(IDString);

        UserDAO uDao = new UserDAO();
        try {
            uDao.deleteUser(userID);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        response.sendRedirect(request.getContextPath() + "/admin/Users");

    }
}
