package bacit.web.Web;

import bacit.web.DAOs.UserDAO;
import bacit.web.Models.UserModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Objects;

@WebServlet(name = "minSide/byttPassord", value = "/minSide/byttPassord")
public class ChangePasswordServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String oldPassword = request.getParameter("oldPassword");
        String newPassword = request.getParameter("newPassword");
        String confirmPassword = request.getParameter("confirmPassword");

        String username = request.getRemoteUser();

        UserDAO uDao = new UserDAO();
        UserModel user = uDao.getUser(username);
        int userID = user.getUserID();

        int verified = 0;
        try {
            verified = uDao.verifyPassword(userID, oldPassword);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        if(Objects.equals(newPassword, confirmPassword) && verified!=0){
            try {
                uDao.changePassword(userID, newPassword);
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }
            response.sendRedirect(request.getContextPath() + "/minSide");
        }else{
            response.sendRedirect(request.getContextPath() + "/error");
        }

    }
}
