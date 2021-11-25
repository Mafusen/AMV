package bacit.web.Web;

import bacit.web.DAOs.BookingDAO;
import bacit.web.DAOs.ToolDAO;
import bacit.web.DAOs.UserDAO;
import bacit.web.Models.BookingModel;
import bacit.web.Models.FileModel;
import bacit.web.Models.ToolModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

@WebServlet (name = "frontpageServlet", value = "/frontpageServlet")
public class FrontpageServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String search = request.getParameter("search");
        if (search == null){
            search = "empty";
        }

        String username = request.getRemoteUser();
        UserDAO uDao = new UserDAO();
        int userID = uDao.getUser(username).getUserID();

        LinkedHashMap<ToolModel, FileModel> products = getProducts(search);
        LinkedHashMap<ToolModel, BookingModel> bookings = getActiveBookings(userID);

        request.setAttribute("bookings", bookings);
        request.setAttribute("products", products);
        request.getRequestDispatcher("frontpage.jsp").forward(request, response);

    }

    public LinkedHashMap<ToolModel, FileModel> getProducts (String search) {

        ToolDAO tDao = new ToolDAO();

        return tDao.getProducts(search);
    }

    public LinkedHashMap<ToolModel, BookingModel> getActiveBookings(int userID){

        BookingDAO bDao = new BookingDAO();

        return bDao.activeUserBookings(userID);

    }

}
