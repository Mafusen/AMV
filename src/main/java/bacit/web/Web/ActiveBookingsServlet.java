package bacit.web.Web;

import bacit.web.DAOs.BookingDAO;
import bacit.web.DAOs.UserDAO;
import bacit.web.Models.BookingModel;
import bacit.web.Models.ToolModel;
import bacit.web.Models.UserModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedHashMap;


@WebServlet(name = "aktiveBookinger", value = "/aktiveBookinger")
public class ActiveBookingsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String search = request.getParameter("search");
        if (search == null){
            search = "empty";
        }

        String username = request.getRemoteUser();

        UserDAO dao = new UserDAO();
        UserModel user = dao.getUser(username);
        int userID = user.getUserID();

        LinkedHashMap<ToolModel, BookingModel> bookings = listBookings(userID, search);

        request.setAttribute("bookings", bookings);
        request.getRequestDispatcher("/bookingsActive.jsp").forward(request, response);

    }

    public LinkedHashMap<ToolModel, BookingModel> listBookings(int userID, String search) {

        BookingDAO bDao = new BookingDAO();

        return bDao.activeUserBookings(userID, search);
    }

}
