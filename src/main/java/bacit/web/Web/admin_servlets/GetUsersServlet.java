package bacit.web.Web.admin_servlets;

import bacit.web.DAOs.UserDAO;
import bacit.web.Models.UserModel;

import java.io.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "admin/Users", value = "/admin/Users")
public class GetUsersServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        UserDAO uDao = new UserDAO();
        String search = request.getParameter("search");
        if (search == null){
            search = "empty";
        }
        List<UserModel> users = new ArrayList<>();

        try {
            users = uDao.activeUsers(search);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        request.setAttribute("users", users);
        request.getRequestDispatcher("/adminEmployees.jsp").forward(request, response);

    }
}
