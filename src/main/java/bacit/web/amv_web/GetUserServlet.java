package bacit.web.amv_web;

import bacit.web.amv_DAO.UserDAO;
import bacit.web.amv_models.UserModel;
import bacit.web.amv_utilities.DBUtils;

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "getUserServlet", value = "/getUserServlet")
public class GetUserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        UserDAO uDao = new UserDAO();

        List<UserModel> users = new ArrayList<>();

        try {
            users = uDao.getUsers();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        request.setAttribute("users", users);
        request.getRequestDispatcher("/adminEmployees.jsp").forward(request, response);

    }

}
