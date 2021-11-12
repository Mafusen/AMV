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
        //Under er bare et eksempel og skal endres når hovedside er ferdig.
        int bookingID = 12;

        // Insert in constructor for BookingModel
        BookingModel model = new BookingModel();
        model.setComment(comment);
        model.setBookingID(bookingID);

        // Call DAO layer and save the user object to DB
        BookingDAO dao = new BookingDAO();
        dao.deliverBooking(model);

        // Prepare information message for user about operation result
        response.sendRedirect("calendar-delivery.jsp");

    }

}
