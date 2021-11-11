package bacit.web.amv_DAO;

import bacit.web.amv_models.CertificateModel;
import bacit.web.amv_utilities.DBUtils;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CertificateDAO {

    PrintWriter out;

    public void registerCertificate(CertificateModel certificate){

        try{

            // Get connection to database
            Connection db = DBUtils.getINSTANCE().getConnection(out);

            // Write  insertion query
            String query = "insert into CERTIFICATE (USER_ID, COURSE_ID, Expiry_Date) values (?, ?, ?)";

            // Set parameters with PreparedStatement
            PreparedStatement statement = db.prepareStatement(query);
            statement.setInt(1, certificate.getUserID());
            statement.setInt(2, certificate.getCourseID());
            statement.setDate(3, certificate.getDate());

            // Execute the statement
            statement.executeQuery();

        }catch (SQLException | ClassNotFoundException exception){
            exception.printStackTrace();
        }

    }

}
