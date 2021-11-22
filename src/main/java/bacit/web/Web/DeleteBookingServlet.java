package bacit.web.Web;

import bacit.web.DAOs.BookingDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "deleteBooking", value = "/deleteBooking")
public class DeleteBookingServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String bookingIDString = request.getParameter("bookingID");
        int bookingID = Integer.parseInt(bookingIDString);

        BookingDAO bDao = new BookingDAO();
        boolean deletion = false;

        try {
            deletion = bDao.deleteBooking(bookingID);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        if(!deletion){
            response.sendRedirect(request.getContextPath() + "/error");
        }

        else{
            response.sendRedirect(request.getContextPath() + "/fremtidigeBookinger");
        }

    }
}
