package bacit.web.amv_web;

import bacit.web.amv_DAO.BookingDAO;
import bacit.web.amv_DAO.ToolDAO;
import bacit.web.amv_DAO.UserDAO;
import bacit.web.amv_models.BookingModel;
import bacit.web.amv_models.ToolBookingModel;
import bacit.web.amv_models.ToolModel;
import bacit.web.amv_models.UserModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.tools.Tool;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@WebServlet(name = "bookingHistoryServlet", value = "/bookingHistoryServlet")
public class BookingHistoryServlet extends HttpServlet {

    PrintWriter out;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String searchString = request.getParameter("search");
        Cookie[] cookie = request.getCookies();
        String username = cookie[0].getValue();

        UserDAO dao = new UserDAO();
        UserModel user = dao.getUser(username);
        int userID = user.getUserID();

        // Call DAO layer and get all bookings for specific user
        BookingDAO bDao = new BookingDAO();

        List<ToolBookingModel> toolBookings = createToolBookingList(bDao.getUserBookings(userID), searchString);

        request.setAttribute("toolBookings", toolBookings);
        request.getRequestDispatcher("/bookingHistory.jsp").forward(request, response);

    }

    private List<ToolModel> getToolFromID(String username) throws SQLException, ClassNotFoundException {
        ArrayList<Integer> iDs = new ArrayList<>();

        UserDAO uDao = new UserDAO();
        UserModel user = uDao.getUser(username);
        int userID = user.getUserID();

        BookingDAO bDao = new BookingDAO();
        List<BookingModel> bookings = bDao.getUserBookings(userID);

        List<ToolModel> tools = new ArrayList<>();

        for (BookingModel booking : bookings) {
            int iD = booking.getToolID();
            ToolDAO tDao = new ToolDAO();
            ToolModel tool = tDao.getTool(iD);
            tools.add(tool);
        }

        return tools;
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
