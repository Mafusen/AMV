package bacit.web.Web;

import bacit.web.DAOs.BookingDAO;
import bacit.web.DAOs.ToolDAO;
import bacit.web.DAOs.UserDAO;
import bacit.web.Models.BookingModel;
import bacit.web.Models.ToolModel;
import bacit.web.Models.UserModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

@WebServlet(name = "bookingHistoryServlet", value = "/bookingHistoryServlet")
public class BookingHistoryServlet extends HttpServlet {

    PrintWriter out;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getRemoteUser();

        UserDAO dao = new UserDAO();
        UserModel user = dao.getUser(username);
        int userID = user.getUserID();

        LinkedHashMap<ToolModel, BookingModel> bookings = listBookings(userID);

        request.setAttribute("bookings", bookings);
        request.getRequestDispatcher("/bookingHistory.jsp").forward(request, response);

    }

    public LinkedHashMap<ToolModel, BookingModel> listBookings(int userID) {

        BookingDAO bDao = new BookingDAO();

        return bDao.getUserBookings(userID);
    }
}
