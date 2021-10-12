package bacit.web.bacit_web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.*;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class AddToolServlet extends HttpServlet {
        public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                response.setContentType("text/html");
                PrintWriter out = response.getWriter();

                String toolName = request.getParameter("toolName");
                String toolInfo = request.getParameter("toolInfo");
                int price = Integer.parseInt(request.getParameter("price"));
                try {

                        //load the driver
                        Class.forName("org.mariadb.jdbc.Driver");
                        //create connection object
                        Connection con = DriverManager.getConnection("jdbc:mariadb://localhost:8081/AMVDB?user=root&password=12345");
                        // create the prepared statement object
                        PreparedStatement ps = con.prepareStatement("insert into TOOL values(?,?,?)");

                        ps.setString(1, toolName);
                        ps.setString(2, toolInfo);
                        ps.setInt(3, price);

                        int i = ps.executeUpdate();
                        if (i > 0)
                                out.print("Nytt verktøy er lagt til.");

                } catch (Exception ex) {
                        ex.printStackTrace();
                }
                out.close();
        }
}