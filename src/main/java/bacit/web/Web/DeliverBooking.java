package bacit.web.Web;

import bacit.web.DAOs.BookingDAO;
import bacit.web.Models.BookingModel;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "deliverBooking", value = "/deliverBooking")
public class DeliverBooking extends HttpServlet {

    @Override protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {


        // Collect form data
        String comment = request.getParameter("kommentar");
        String bookingIDString = request.getParameter("bookingID");
        int bookingID = Integer.parseInt(bookingIDString);

        // Insert in constructor for BookingModel
        BookingDAO bDao = new BookingDAO();
        BookingModel booking = bDao.getBooking(bookingID);
        booking.setComment(comment);

        // Call DAO layer and save the user object to DB

        bDao.deliverBooking(booking);

        // Prepare information message for user about operation result
        response.sendRedirect(request.getContextPath() + "/frontpageServlet");

    }

}
