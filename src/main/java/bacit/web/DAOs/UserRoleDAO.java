package bacit.web.DAOs;

import bacit.web.Models.RoleModel;
import bacit.web.Utilities.DBUtils;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserRoleDAO {

    PrintWriter out;

    public void registerRole(RoleModel model){

        try{

            // Get connection to database
            Connection db = DBUtils.getINSTANCE().getConnection(out);

            // Write  insertion query
            String query = "insert into USER_ROLE (Username, Rolename) values (?, ?)";

            // Set parameters with PreparedStatement
            PreparedStatement statement = db.prepareStatement(query);
            statement.setString(1, model.getUserName());
            statement.setString(2, model.getRoleName());

            // Execute the statement
            statement.executeQuery();

        }catch (SQLException | ClassNotFoundException exception){
            exception.printStackTrace();
        }
    }

    public List<String> getRoles (String username) throws SQLException, ClassNotFoundException {

        List<String> roles = new ArrayList<>();

        Connection db = DBUtils.getINSTANCE().getConnection(out);
        String query = "select Rolename from USER_ROLE where Username = ?;";
        PreparedStatement statement = db.prepareStatement(query);
        statement.setString(1, username);
        ResultSet rs = statement.executeQuery();

        while(rs.next()){

            roles.add(rs.getString("Rolename"));
        }

        return roles;

    }

    public void deleteRole(String username, String rolename) throws SQLException, ClassNotFoundException {

        Connection db = DBUtils.getINSTANCE().getConnection(out);
        String query = "delete FROM USER_ROLE where Username = ? and Rolename = ?;";
        PreparedStatement statement = db.prepareStatement(query);
        statement.setString(1, username);
        statement.setString(2, rolename);
        statement.executeQuery();

    }

}
