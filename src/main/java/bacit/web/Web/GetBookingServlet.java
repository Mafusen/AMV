package bacit.web.Web;

        import bacit.web.DAOs.BookingDAO;
        import bacit.web.DAOs.ToolDAO;
        import bacit.web.Models.BookingModel;
        import bacit.web.Models.ToolBookingModel;
        import bacit.web.Models.ToolModel;

        import javax.servlet.ServletException;
        import javax.servlet.annotation.WebServlet;
        import javax.servlet.http.HttpServlet;
        import javax.servlet.http.HttpServletRequest;
        import javax.servlet.http.HttpServletResponse;
        import java.io.IOException;
        import java.sql.SQLException;

@WebServlet(name = "getBookingServlet", value = "/getBookingServlet")
public class GetBookingServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String bookingIDString = request.getParameter("bookingID");
        int bookingID = Integer.parseInt(bookingIDString);
        ToolBookingModel toolBooking = new ToolBookingModel();


        try {
            toolBooking = getToolBooking(bookingID);
        } catch (SQLException e) {
            e.printStackTrace();
        }


        request.setAttribute("toolBooking", toolBooking);
        request.getRequestDispatcher("booking.jsp").forward(request, response);
    }

    private ToolBookingModel getToolBooking(int bookingID) throws SQLException {
        ToolBookingModel toolBooking = new ToolBookingModel();

        BookingDAO bDao = new BookingDAO();
        BookingModel bModel = bDao.getBooking(bookingID);
        int toolID = bModel.getToolID();

        ToolDAO tDao = new ToolDAO();
        ToolModel tModel = tDao.getTool(toolID);

        toolBooking.setUserID(bModel.getUserID());
        toolBooking.setBookingID(bModel.getBookingID());
        toolBooking.setToolID(bModel.getToolID());
        toolBooking.setStartDate(bModel.getStartDate());
        toolBooking.setEndDate(bModel.getEndDate());
        toolBooking.setComment(bModel.getComment());
        toolBooking.setIsDelivered(bModel.getIsDelivered());
        toolBooking.setTotalPrice(bModel.getTotalPrice());
        toolBooking.setToolName(tModel.getToolName());
        toolBooking.setToolInfo(tModel.getToolInfo());
        toolBooking.setPrice(tModel.getPrice());
        toolBooking.setActive(tModel.isActive());

        return toolBooking;
    }

}
