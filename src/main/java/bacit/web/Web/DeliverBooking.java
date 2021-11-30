package bacit.web.Web;

import bacit.web.DAOs.BookingDAO;
import bacit.web.DAOs.ToolDAO;
import bacit.web.Models.BookingModel;
import bacit.web.Models.ToolModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "deliverBooking", value = "/deliverBooking")
public class DeliverBooking extends HttpServlet {

    @Override protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {


        // Collect form data
        String comment = request.getParameter("kommentar");
        String bookingIDString = request.getParameter("bookingID");
        int bookingID = Integer.parseInt(bookingIDString);

        // Insert in constructor for BookingModel
        BookingDAO bDao = new BookingDAO();
        BookingModel booking = bDao.getBooking(bookingID);
        booking.setComment(comment);

        ToolDAO tDao = new ToolDAO();
        ToolModel tool = new ToolModel();
        try {
            tool = tDao.getTool(booking.getToolID());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Call DAO layer and save the user object to DB

        bDao.deliverBooking(booking, tool);
        BookingModel finalBooking = bDao.getBooking(bookingID);

        request.setAttribute("tool", tool);
        request.setAttribute("finalBooking", finalBooking);
        request.getRequestDispatcher("/popupDelivery.jsp").forward(request, response);

    }

}
