package bacit.web.Web;

import bacit.web.DAOs.BookingDAO;
import bacit.web.DAOs.FileDAO;
import bacit.web.DAOs.ToolDAO;
import bacit.web.Models.BookingModel;
import bacit.web.Models.FileModel;
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


        BookingModel booking = getBooking(bookingID);

        ToolModel tool = new ToolModel();
        try {
            tool = getTool(booking.getToolID());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        ToolDAO tDao = new ToolDAO();
        ToolModel toolModel = null;
        try {
            toolModel = tDao.getTool(tool.getToolID());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        assert toolModel != null;
        int toolID = toolModel.getToolID();
        FileModel file = null;
        try {
            file = getFile(toolID);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }


        request.setAttribute("tool", tool);
        request.setAttribute("booking", booking);
        request.setAttribute("file", file);
        request.getRequestDispatcher("booking.jsp").forward(request, response);
    }

    private ToolModel getTool(int toolID) throws SQLException {

        ToolDAO tDao = new ToolDAO();

        return tDao.getTool(toolID);
    }

    private BookingModel getBooking(int bookingID){

        BookingDAO bDao = new BookingDAO();

        return bDao.getBooking(bookingID);
    }

    private FileModel getFile(int toolID) throws SQLException, ClassNotFoundException {

        FileDAO fDao = new FileDAO();

        return fDao.getFileForTool(toolID);

    };

}
