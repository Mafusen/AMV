package bacit.web.bacit_web;

import java.io.PrintWriter;
import java.text.*;
import java.util.*;
import java.sql.*;

public class UserDAO
{
    static Connection db = null;
    static ResultSet rs = null;
    static PrintWriter out = null;


    public static UserModel login(UserModel model) {

        //preparing some objects for connection
        Statement statement = null;

        String username = model.getUserName();
        String password = model.getPassword();

        String searchQuery =
                "select * from USER where Username='"
                        + username
                        + "' AND Password='"
                        + password
                        + "'";

        // "System.out.println" prints in the console; Normally used to trace the process
        System.out.println("Your user name is " + username);
        System.out.println("Your password is " + password);
        System.out.println("Query: "+searchQuery);

        try
        {
            //connect to DB
            db = DBUtils.getINSTANCE().getConnection(out);
            statement=db.createStatement();
            rs = statement.executeQuery(searchQuery);
            boolean more = rs.next();

            // if user does not exist set the isValid variable to false
            if (!more)
            {
                System.out.println("Sorry, you are not a registered user! Please sign up first");
                model.setValid(false);
            }

            //if user exists set the isValid variable to true
            else if (more)
            {
                String firstName = rs.getString("Fname");
                String lastName = rs.getString("Lname");

                System.out.println("Welcome " + firstName);
                model.setFirstName(firstName);
                model.setLastName(lastName);
                model.setValid(true);
            }
        }

        catch (Exception ex)
        {
            System.out.println("Log In failed: An Exception has occurred! " + ex);
        }

        //some exception handling
        finally
        {
            if (rs != null)	{
                try {
                    rs.close();
                } catch (Exception e) {}
                rs = null;
            }

            if (statement != null) {
                try {
                    statement.close();
                } catch (Exception e) {}
                statement = null;
            }

            if (db != null) {
                try {
                    db.close();
                } catch (Exception e) {
                }

                db = null;
            }
        }

        return model;

    }
}