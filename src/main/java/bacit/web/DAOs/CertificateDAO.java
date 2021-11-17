package bacit.web.DAOs;

import bacit.web.Models.CertificateModel;
import bacit.web.Utilities.DBUtils;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CertificateDAO {

    PrintWriter out;


    //Register certificate and if already found update the date!
    public void registerCertificate(CertificateModel certificate){

        try{

            // Get connection to database
            Connection db = DBUtils.getINSTANCE().getConnection(out);

            // Write  insertion query
            String query = "insert into CERTIFICATE (USER_ID, COURSE_ID, Expiry_Date) values (?, ?, ?) ON DUPLICATE KEY UPDATE Expiry_Date = ?";

            // Set parameters with PreparedStatement
            PreparedStatement statement = db.prepareStatement(query);
            statement.setInt(1, certificate.getUserID());
            statement.setInt(2, certificate.getCourseID());
            statement.setDate(3, certificate.getDate());
            statement.setDate(4, certificate.getDate());

            // Execute the statement
            statement.executeQuery();

        }catch (SQLException | ClassNotFoundException exception){
            exception.printStackTrace();
        }

    }

    public void deleteCertificate(CertificateModel certificate){

        try{

            // Get connection to database
            Connection db = DBUtils.getINSTANCE().getConnection(out);

            // Write  insertion query
            String query =
                    "delete from CERTIFICATE where User_ID = ?";

            // Set parameters with PreparedStatement
            PreparedStatement statement = db.prepareStatement(query);
            statement.setInt(1, certificate.getUserID());

            // Execute the statement
            statement.executeQuery();

        }catch (SQLException | ClassNotFoundException exception){
            exception.printStackTrace();
        }

    }
}
