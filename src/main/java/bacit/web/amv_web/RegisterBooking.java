package bacit.web.amv_web;

import bacit.web.amv_DAO.BookingDAO;
import bacit.web.amv_models.BookingModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "registerBooking", value = "/registerBooking")
public class RegisterBooking extends HttpServlet {

    @Override protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        // Collect form data
        String startDate = request.getParameter("start");
        String endDate = request.getParameter("end");
        String comment = "";
        int totalPrice = 100;
        int user_ID = 4;
        int tool_ID = 1;

        // Insert in constructor for BookingModel
        BookingModel booking = new BookingModel(startDate, endDate, comment, totalPrice, user_ID, tool_ID);

        // Call DAO layer and save the user object to DB
        BookingDAO dao = new BookingDAO();
        dao.registerBooking(booking);

        // Prepare information message for user about operation result
        response.sendRedirect("calendar-delivery.jsp");

    }

}
