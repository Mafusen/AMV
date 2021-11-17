package bacit.web.Web.admin_servlets;


import bacit.web.DAOs.CertificateDAO;
import bacit.web.DAOs.UserDAO;
import bacit.web.DAOs.UserRoleDAO;
import bacit.web.Models.CertificateModel;
import bacit.web.Models.RoleModel;
import bacit.web.Models.UserModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "byttPassord", value = "/byttPassord")
public class ChangePasswordServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Collect form data
        // Gammel passord fra brukeren (Må krypteres)
        String oldPassUser = request.getParameter("oldPassword");
        String newPassword = request.getParameter("newPassWord");
        String confirmPassword = request.getParameter("confirmPassword");

        String username = request.getRemoteUser();
        UserDAO userDao = new UserDAO();
        UserModel user;
        user = userDao.getUser(username);
        //Passord fra databasen
        String oldPassDB = user.getPassword();

        //hvis gammel og ny passord og nypassord og confirm passord er like bytt passord.
        if (oldPassUser == oldPassBD && newPassword == confirmPassword) {
            // Insert new data in UserModel object
            UserModel uModel = new UserModel();
            uModel.setUserName(username);
            uModel.setPassWord(newPassword);

            // Call DAO layer and save the user object to DB
            UserDAO uDao = new UserDAO();
            uDao.changePassword(uModel);

            response.sendRedirect(request.getContextPath() + "/admin/Users");


        } else if (oldPass != oldPass) {
            //Send til error som sier gammel passord git er feil!
            response.sendRedirect(request.getContextPath() + "/error404");

        } else  {
            //Send til error som sier nypassord matcher ikke med bekreftpassord
            response.sendRedirect(request.getContextPath() + "/error403");

        }
    }
}
