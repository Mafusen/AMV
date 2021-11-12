package bacit.web.Web;

import bacit.web.DAOs.BookingDAO;
import bacit.web.DAOs.ToolDAO;
import bacit.web.DAOs.UserDAO;
import bacit.web.Models.BookingModel;
import bacit.web.Models.ToolBookingModel;
import bacit.web.Models.ToolModel;
import bacit.web.Models.UserModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "bookingHistoryServlet", value = "/bookingHistoryServlet")
public class BookingHistoryServlet extends HttpServlet {

    PrintWriter out;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String searchString = request.getParameter("search");

        String username = request.getRemoteUser();

        UserDAO dao = new UserDAO();
        UserModel user = dao.getUser(username);
        int userID = user.getUserID();

        BookingDAO bDao = new BookingDAO();

        List<ToolBookingModel> toolBookings = createToolBookingList(bDao.getUserBookings(userID), searchString);

        request.setAttribute("toolBookings", toolBookings);
        request.getRequestDispatcher("/bookingHistory.jsp").forward(request, response);

    }

    public List<ToolBookingModel> createToolBookingList(List<BookingModel> bookings, String searchString) {
        List<ToolBookingModel> toolBookings = new ArrayList<>();

        for (BookingModel booking : bookings) {
            int toolID = booking.getToolID();
            ToolDAO tDao = new ToolDAO();
            if (searchString == null) {
                ToolModel tool;
                ToolBookingModel model = new ToolBookingModel();

                try {
                    tool = tDao.getTool(toolID);

                    model.setUserID(booking.getUserID());
                    model.setBookingID(booking.getBookingID());
                    model.setToolID(tool.getToolID());
                    model.setToolName(tool.getToolName());
                    model.setToolInfo(tool.getToolInfo());
                    model.setPrice(tool.getPrice());
                    model.setActive(tool.isActive());
                    model.setStartDate(booking.getStartDate());
                    model.setEndDate(booking.getEndDate());
                    model.setComment(booking.getComment());
                    model.setIsDelivered(booking.getIsDelivered());
                    model.setTotalPrice(booking.getTotalPrice());
                    toolBookings.add(model);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            } else {
                ToolModel tool;
                ToolBookingModel model = new ToolBookingModel();

                try {
                    tool = tDao.getTool(toolID);

                    model.setUserID(booking.getUserID());
                    model.setBookingID(booking.getBookingID());
                    model.setToolID(tool.getToolID());
                    model.setToolName(tool.getToolName());
                    model.setToolInfo(tool.getToolInfo());
                    model.setPrice(tool.getPrice());
                    model.setActive(tool.isActive());
                    model.setStartDate(booking.getStartDate());
                    model.setEndDate(booking.getEndDate());
                    model.setComment(booking.getComment());
                    model.setIsDelivered(booking.getIsDelivered());
                    model.setTotalPrice(booking.getTotalPrice());
                    if (tool.getToolName().contains(searchString)) {
                        toolBookings.add(model);
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }
        }
        return toolBookings;
    }
}