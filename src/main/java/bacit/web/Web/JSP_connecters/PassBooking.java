package bacit.web.Web.JSP_connecters;

import bacit.web.DAOs.BookingDAO;
import bacit.web.DAOs.FileDAO;
import bacit.web.DAOs.ToolDAO;
import bacit.web.Models.BookingModel;
import bacit.web.Models.FileModel;
import bacit.web.Models.ToolModel;
import bacit.web.Models.UserModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "passBooking", value = "/passBooking")
public class PassBooking extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String toolIDString = request.getParameter("bookingID");
        int bookingID = Integer.parseInt(toolIDString);

        BookingModel booking = getBooking(bookingID);
        ToolModel tool = null;
        FileModel file = null;
        try {
            tool = getTool(booking.getToolID());
            file = getFile(booking.getToolID());
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        request.setAttribute("booking", booking);
        request.setAttribute("tool", tool);
        request.setAttribute("file", file);
        request.getRequestDispatcher("/calendar-delivery.jsp").forward(request, response);
    }

    public ToolModel getTool(int toolID) throws SQLException {

        ToolDAO tDao = new ToolDAO();

        return tDao.getTool(toolID);
    }

    public BookingModel getBooking(int bookingID){

        BookingDAO bDao = new BookingDAO();

        return bDao.getBooking(bookingID);
    }

    public FileModel getFile(int toolID) throws SQLException, ClassNotFoundException {

        FileDAO fDao = new FileDAO();

        return fDao.getFileForTool(toolID);
    }

}
