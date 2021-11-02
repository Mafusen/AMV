package bacit.web.amv_web;

import bacit.web.amv_DAO.BookingDAO;
import bacit.web.amv_models.BookingModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "bookingHistoryServlet", value = "/bookingHistoryServlet")
public class SearchBookingsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



        // Call DAO layer and get all bookings for specific user
        BookingDAO dao = new BookingDAO();
        List<BookingModel> bookings = dao.getUserBookings(1);

        request.setAttribute("bookings", bookings);
        request.getRequestDispatcher("/bookingHistory.jsp").forward(request, response);

    }
}