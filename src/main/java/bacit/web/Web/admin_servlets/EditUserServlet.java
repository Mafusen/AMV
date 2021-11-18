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
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "admin/gjorEndring", value = "/admin/gjorEndring")
public class EditUserServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String idString = request.getParameter("userID");
        int userID = Integer.parseInt(idString);

        // Collect form data
        String newPassWord = request.getParameter("passWord");
        String newPhone = request.getParameter("phone");
        boolean administrator = request.getParameter("admin") != null;
        boolean unionMember = request.getParameter("unionMember") != null;
        boolean lift = request.getParameter("lift") !=null;
        String endDate = request.getParameter("endDate");

        UserDAO uDao = new UserDAO();
        UserModel user = uDao.userByID(userID);
        user.setPhone(newPhone);
        uDao.editUser(user);

        if(!newPassWord.isEmpty()){
            try {
                uDao.changePassword(userID, newPassWord);
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        UserRoleDAO urDao = new UserRoleDAO();
        List<String> roles = new ArrayList<>();
        try {
            roles = urDao.getRoles(user.getUserName());
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        List<RoleModel> newRoles = new ArrayList<>();

        if(!roles.contains("administrator") && administrator){
            RoleModel role = new RoleModel(user.getUserName(), "administrator");
            newRoles.add(role);
        }if(roles.contains("administrator") && !administrator){
            try {
                urDao.deleteRole(user.getUserName(), "administrator");
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }

        }if (!roles.contains("union-member") && unionMember){
            RoleModel role = new RoleModel (user.getUserName(), "union-member");
            newRoles.add(role);
        }if (roles.contains("union-member") && ! unionMember){
            try {
                urDao.deleteRole(user.getUserName(), "union-member");
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        for (RoleModel newRole : newRoles){
            urDao.registerRole(newRole);
        }

        Date date = null;
        if(endDate != null) {
            String dateReformat = endDate.replace(".", "-");
            if(!dateReformat.isEmpty()) {
                date = Date.valueOf(dateReformat);
            }
        }

        CertificateDAO cDao = new CertificateDAO();
        List<Integer> certificates = new ArrayList<>();
        try {
            certificates = cDao.userCertificates(userID);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            if (certificates.contains(1) && lift && date!=cDao.expiryDate(1, userID)){
                CertificateModel certificate = cDao.getCertificate(1, userID);
                certificate.setDate(date);
                cDao.updateDate(certificate);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        if(!certificates.contains(1) && lift){
            CertificateModel model = new CertificateModel(userID, 1, date);
            cDao.registerCertificate(model);
        }


        if(certificates.contains(1) && !lift){
            try {
                cDao.deleteCertificate(1, userID);
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        response.sendRedirect(request.getContextPath() + "/admin/Users");
    }
}
