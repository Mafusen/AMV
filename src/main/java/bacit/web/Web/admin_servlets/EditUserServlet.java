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
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "admin/redigerBruker", value = "/admin/redigerBruker")
public class EditUserServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Collect form data
        String userName = request.getParameter("userName");
        String newPassWord = request.getParameter("passWord");
        String newPhone = request.getParameter("phone");
        boolean administrator = request.getParameter("admin") != null;
        boolean unionMember = request.getParameter("unionMember") != null;
        boolean lift = request.getParameter("lift") != null;
        String endDate = null;
        boolean notAdministrator = request.getParameter("notAdmin") != null;
        boolean notUnionMember = request.getParameter("notUnionMember") != null;
        boolean notLift = request.getParameter("notLift") != null;

        if(request.getParameter("endDate") != null) {
            endDate = request.getParameter("endDate");
        }

        // Insert new data in UserModel object
        UserModel uModel = new UserModel();

        uModel.setUserName(userName);
        uModel.setPassWord(newPassWord);
        uModel.setPhone(newPhone);
        uModel.setActive(true);

        // Call DAO layer and save the user object to DB
        UserDAO uDao = new UserDAO();
        uDao.editUser(uModel);

        // Create list of possible roles
        List<RoleModel> roles = new ArrayList<>();

        RoleModel defaultRole = new RoleModel(userName, "user");
        roles.add(defaultRole);

        if(administrator){
            RoleModel role = new RoleModel(userName, "administrator");
            roles.add(role);
        }

        if(unionMember){
            RoleModel role = new RoleModel(userName, "union-member");
            roles.add(role);
        }

        // Call DAO layer and save role object(s) to DB
        UserRoleDAO rDao = new UserRoleDAO();
        for(RoleModel role : roles){
            rDao.registerRole(role);
        }



//          DELETE ROLES
        List<RoleModel> deleteRoles = new ArrayList<>();

        if (notAdministrator){
            RoleModel Role = new RoleModel(userName, "administrator");
            deleteRoles.add(Role);
        }

        if (notUnionMember){
            RoleModel Role = new RoleModel(userName, "union-member");
            deleteRoles.add(Role);
        }

        // Call DAO layer and save delete role object(s) to DB
        UserRoleDAO rdDao = new UserRoleDAO();
        for (RoleModel Role : deleteRoles){
            //rdDao.deleteRole(Role);
        }




        // Get userID for created user
        UserModel user = uDao.getUser(userName);
        int userID = user.getUserID();

        int courseID = 1;

        // Get endDate ready for DB insert
        Date date = null;
        if(endDate != null) {
            String dateReformat = endDate.replace(".", "-");
            if(!dateReformat.isEmpty()) {
                date = Date.valueOf(dateReformat);
            }
        }

        // Create list of possible roles
        List<CertificateModel> certificates = new ArrayList<>();

        if(lift){
            CertificateModel certificate = new CertificateModel(userID, courseID, date);
            certificates.add(certificate);
        }

        // Call DAO layer and save certificate object(s) to DB
        CertificateDAO cDao = new CertificateDAO();
        for (CertificateModel certificate : certificates){
            cDao.registerCertificate(certificate);
        }

        // DELETE CERTIFICATE
        if (notLift){
            CertificateModel certificate = new CertificateModel(userID, courseID, date);
            //cDao.deleteCertificate(certificate);
        }

        response.sendRedirect(request.getContextPath() + "/admin/Users");
    }
}
