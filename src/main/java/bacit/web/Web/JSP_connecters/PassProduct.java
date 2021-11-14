package bacit.web.Web.JSP_connecters;

import bacit.web.DAOs.BookingDAO;
import bacit.web.DAOs.FileDAO;
import bacit.web.DAOs.ToolDAO;
import bacit.web.Models.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.*;

@WebServlet (name = "passProduct", value = "/passProduct")
public class PassProduct extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String toolIDString = request.getParameter("toolID");
        int toolID = Integer.parseInt(toolIDString);

        HashMap<UserModel, BookingModel> bookings = getBookings(toolID);

        ToolModel tool = null;
        FileModel file = null;
        try {
            tool = getTool(toolID);
            file = getFile(toolID);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        request.setAttribute("file", file);
        request.setAttribute("tool", tool);
        request.setAttribute("bookings", bookings);
        request.getRequestDispatcher("calendar-booking.jsp").forward(request, response);
    }

    public HashMap<UserModel, BookingModel> getBookings(int toolID){

        BookingDAO bDao = new BookingDAO();

        return bDao.activeToolBookings(toolID);
    }

    public LinkedHashMap<ToolModel, FileModel> getProduct(int toolID){

        ToolDAO tDao = new ToolDAO();
        return tDao.getProduct(toolID);
    }

    public ToolModel getTool(int toolID) throws SQLException {

        ToolDAO tDao = new ToolDAO();
        return tDao.getTool(toolID);

    }

    public FileModel getFile(int toolID) throws SQLException, ClassNotFoundException {

        FileDAO fDao = new FileDAO();
        return fDao.getFileForTool(toolID);

    }

}