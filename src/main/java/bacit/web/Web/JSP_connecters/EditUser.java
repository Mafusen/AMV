package bacit.web.Web.JSP_connecters;

import bacit.web.DAOs.CertificateDAO;
import bacit.web.DAOs.UserDAO;
import bacit.web.DAOs.UserRoleDAO;
import bacit.web.Models.RoleModel;
import bacit.web.Models.UserModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "admin/redigerBruker", value = "/admin/redigerBruker")
public class EditUser extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String IDString = request.getParameter("userID");
        int userID = Integer.parseInt(IDString);

        UserDAO uDao = new UserDAO();
        UserModel user = uDao.userByID(userID);

        UserRoleDAO urDao = new UserRoleDAO();
        List<String> roles = new ArrayList<>();
        try {
            roles = urDao.getRoles(user.getUserName());
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        CertificateDAO cDao = new CertificateDAO();
        List<Integer> certificates = new ArrayList<>();
        try {
            certificates = cDao.userCertificates(userID);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        request.setAttribute("certificates", certificates);
        request.setAttribute("roles", roles);
        request.setAttribute("user", user);
        request.getRequestDispatcher("/editUser.jsp").forward(request, response);

    }
}
