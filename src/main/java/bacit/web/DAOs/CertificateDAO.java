package bacit.web.DAOs;

import bacit.web.Models.CertificateModel;
import bacit.web.Utilities.DBUtils;

import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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

    public List<Integer> userCertificates(int userID) throws SQLException, ClassNotFoundException {

        List<Integer> certificates = new ArrayList<>();
        Connection db = DBUtils.getINSTANCE().getConnection(out);

        String query = "select COURSE_ID from CERTIFICATE where USER_ID = ?;";

        PreparedStatement statement = db.prepareStatement(query);
        statement.setInt(1, userID);
        ResultSet rs = statement.executeQuery();

        while (rs.next()){
            certificates.add(rs.getInt("COURSE_ID"));
        }

        return certificates;
    }

    public Date expiryDate(int courseID, int userID) throws SQLException, ClassNotFoundException {

        Connection db = DBUtils.getINSTANCE().getConnection(out);

        String query = "select Expiry_Date from CERTIFICATE where Course_ID = ? and USER_ID = ?;";
        PreparedStatement statement = db.prepareStatement(query);
        statement.setInt(1, courseID);
        statement.setInt(2, userID);
        ResultSet rs = statement.executeQuery();

        return rs.getDate("Expiry_Date");
    }

    public void deleteCertificate(int courseID, int userID) throws SQLException, ClassNotFoundException{

        Connection db = DBUtils.getINSTANCE().getConnection(out);

        String query = "delete FROM CERTIFICATE where USER_ID = ? and COURSE_ID = ?;";
        PreparedStatement statement = db.prepareStatement(query);
        statement.setInt(1, userID);
        statement.setInt(2, courseID);
        statement.executeQuery();

    }

    public CertificateModel getCertificate(int userID, int courseID) throws SQLException, ClassNotFoundException{


        Connection db = DBUtils.getINSTANCE().getConnection(out);
        String query = "select * from CERTIFICATE where USER_ID = ? and COURSE_ID = ?;";
        PreparedStatement statement = db.prepareStatement(query);
        statement.setInt(1, userID);
        statement.setInt(2, userID);
        ResultSet rs = statement.executeQuery();

        return new CertificateModel(
                rs.getInt("USER_ID"),
                rs.getInt("COURSE_ID"),
                rs.getDate("Expiry_Date")
        );
    }

    public void updateDate(CertificateModel certificate) throws SQLException, ClassNotFoundException {

        Connection db = DBUtils.getINSTANCE().getConnection(out);

        String query = "update CERTIFICATE set Expiry_Date = ? where USER_ID = ? and COURSE_ID = ?;";
        PreparedStatement statement = db.prepareStatement(query);
        statement.setDate(1, certificate.getDate());
        statement.setInt(2, certificate.getUserID());
        statement.setInt(3, certificate.getCourseID());
        statement.executeQuery();

    }

}
