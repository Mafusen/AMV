package bacit.web.amv_web.admin_servlets;


import bacit.web.amv_DAO.CertificateDAO;
import bacit.web.amv_DAO.UserDAO;
import bacit.web.amv_DAO.UserRoleDAO;
import bacit.web.amv_models.CertificateModel;
import bacit.web.amv_models.RoleModel;
import bacit.web.amv_models.UserModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "admin/registerUser", value = "/admin/registerUser")
public class RegisterUserServlet extends HttpServlet {


        @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

            // Collect form data
            String userName = request.getParameter("userName");
            String passWord = request.getParameter("passWord");
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String phone = request.getParameter("phone");
            boolean administrator = request.getParameter("admin") != null;
            boolean unionMember = request.getParameter("unionMember") !=null;
            boolean lift = request.getParameter("lift") !=null;
            String endDate = request.getParameter("endDate");

            // Insert data in UserModel object
            UserModel uModel = new UserModel();

            uModel.setUserName(userName);
            uModel.setPassWord(passWord);
            uModel.setFirstName(firstName);
            uModel.setLastName(lastName);
            uModel.setPhone(phone);
            uModel.setActive(true);

            // Call DAO layer and save the user object to DB
            UserDAO uDao = new UserDAO();
            uDao.registerUser(uModel);

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

            // Get userID for created user
            UserModel user = uDao.getUser(userName);
            int userID = user.getUserID();

            int courseID = 1;

            // Get endDate ready for DB insert
            String dateReformat = endDate.replace( ".", "-");
            Date date = Date.valueOf(dateReformat);

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

            response.sendRedirect(request.getContextPath() + "/admin/Users");
        }
}
