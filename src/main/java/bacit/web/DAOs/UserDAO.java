package bacit.web.DAOs;

import bacit.web.Utilities.DBUtils;
import bacit.web.Models.UserModel;

import java.io.PrintWriter;
import java.util.*;
import java.sql.*;

public class UserDAO
{


    static PrintWriter out;


    public List<UserModel> searchUsers (String searchString) throws SQLException, ClassNotFoundException {


        List<UserModel> users = new ArrayList<>();

        try {
            Connection db = DBUtils.getINSTANCE().getConnection(out);

            String query = "select * from USER where Username = ?";
            PreparedStatement statement = db.prepareStatement(query);
            statement.setString(1, searchString);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                UserModel model = new UserModel(
                        rs.getInt("USER_ID"),
                        rs.getString("Fname"),
                        rs.getString("Lname"),
                        rs.getString("Phone"),
                        rs.getString("Username"),
                        rs.getString("Password"),
                        true
                        );

                users.add(model);
            }
        }
        catch(SQLException exception){
            exception.printStackTrace();
        }
        return users;
    }

    public UserModel getUser(String Username){

        UserModel model = null;

        try {
            Connection db = DBUtils.getINSTANCE().getConnection(out);

            String query = "select * from USER where Username = ?";
            PreparedStatement statement = db.prepareStatement(query);
            statement.setString(1, Username);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                model = new UserModel();
                model.setUserID(rs.getInt("USER_ID"));
                model.setFirstName(rs.getString("Fname"));
                model.setLastName(rs.getString("Lname"));
                model.setPhone(rs.getString("Phone"));
                model.setUserName(rs.getString("Username"));
                model.setPassWord(rs.getString("Password"));
            }
        }
        catch(SQLException | ClassNotFoundException exception){
            exception.printStackTrace();
        }

        return model;

    }

    public UserModel userByID(int userID){

        UserModel model = null;

        try {
            Connection db = DBUtils.getINSTANCE().getConnection(out);

            String query = "select * from USER where USER_ID = ?";
            PreparedStatement statement = db.prepareStatement(query);
            statement.setInt(1, userID);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                model = new UserModel();
                model.setUserID(rs.getInt("USER_ID"));
                model.setFirstName(rs.getString("Fname"));
                model.setLastName(rs.getString("Lname"));
                model.setPhone(rs.getString("Phone"));
                model.setUserName(rs.getString("Username"));
                model.setPassWord(rs.getString("Password"));
            }
        }
        catch(SQLException | ClassNotFoundException exception){
            exception.printStackTrace();
        }

        return model;

    }

    public List<UserModel> getAllUsers() throws SQLException {

        List<UserModel> users = new ArrayList<>();

        try {
            Connection db = DBUtils.getINSTANCE().getConnection(out);
            String query = "select * from USER";
            PreparedStatement statement = db.prepareStatement(query);
            ResultSet rs = statement.executeQuery();

        while (rs.next()) {
            UserModel model = new UserModel(
                    rs.getInt("USER_ID"),
                    rs.getString("Fname"),
                    rs.getString("Lname"),
                    rs.getString("Phone"),
                    rs.getString("Username"),
                    rs.getString("Password"),
                    true
            );

            users.add(model);
        }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return users;

    }


    public void registerUser(UserModel model){

        try{

            // Get connection to database
            Connection db = DBUtils.getINSTANCE().getConnection(out);

            // Write  insertion query
            String query = "insert into USER (Fname, Lname, Phone, Username, Password, IsActive) values (?, ?, ?, ?, sha2(?, 256), ?)";

            // Set parameters with PreparedStatement
            PreparedStatement statement = db.prepareStatement(query);
            statement.setString(1, model.getFirstName());
            statement.setString(2, model.getLastName());
            statement.setString(3, model.getPhone());
            statement.setString(4, model.getUserName());
            statement.setString(5, model.getPassword());
            statement.setBoolean(6, true);

            // Execute the statement
            statement.executeQuery();

        }catch (SQLException | ClassNotFoundException exception){
            exception.printStackTrace();
        }
    }

    public int verifyPassword(int userID, String password) throws SQLException, ClassNotFoundException {

        Connection db = DBUtils.getINSTANCE().getConnection(out);
        String query = "select USER_ID from USER where USER_ID = ? and Password = sha2(?, 256);";
        PreparedStatement statement = db.prepareStatement(query);
        statement.setInt(1, userID);
        statement.setString(2, password);
        ResultSet rs = statement.executeQuery();

        int ID = 0;
        while(rs.next()){
            ID = rs.getInt("USER_ID");
        }

        return ID;
    }

    public void changePassword(int userID, String password) throws SQLException, ClassNotFoundException {

        Connection db = DBUtils.getINSTANCE().getConnection(out);
        String query = "update USER set Password = SHA2(?, 256) where USER_ID = ?;";
        PreparedStatement statement = db.prepareStatement(query);
        statement.setString(1,  password);
        statement.setInt(2, userID);
        statement.executeQuery();

    }

    public void editUser(UserModel model){

        try{

            // Get connection to database
            Connection db = DBUtils.getINSTANCE().getConnection(out);

            // Write  update query
            String query = "update USER set Phone = ? where USER_ID = ?";

            // Set parameters with PreparedStatement
            PreparedStatement statement = db.prepareStatement(query);
            statement.setString(1, model.getPhone());
            statement.setInt(2, model.getUserID());

            // Execute the statement
            statement.executeQuery();

        }catch (SQLException | ClassNotFoundException exception){
            exception.printStackTrace();
        }
    }

    public void deleteUser(int userID) throws SQLException, ClassNotFoundException {

        Connection db = DBUtils.getINSTANCE().getConnection(out);

        String query = "update USER set IsActive = 0 where USER_ID = ?;";
        PreparedStatement statement = db.prepareStatement(query);
        statement.setInt(1, userID);
        statement.executeQuery();

    }


}