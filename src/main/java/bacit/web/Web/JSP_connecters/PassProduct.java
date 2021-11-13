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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@WebServlet (name = "passProduct", value = "/passProduct")
public class PassProduct extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String toolIString = request.getParameter("toolID").trim();
        int toolID = Integer.parseInt(toolIString);

        ToolFileModel product = getProduct(toolID);
        HashMap<UserModel, BookingModel> bookings = getBookings(toolID);

        request.setAttribute("product", product);
        request.setAttribute("bookings", bookings);
        request.getRequestDispatcher("calendar-booking.jsp").forward(request, response);
    }

    public HashMap<UserModel, BookingModel> getBookings(int toolID){

        BookingDAO bDao = new BookingDAO();

        return bDao.activeToolBookings(toolID);
    }

    public ToolFileModel getProduct(int toolID){

        ToolDAO tDao = new ToolDAO();
        ToolModel tool = new ToolModel();

        try {
            tool = tDao.getTool(toolID);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        FileDAO fDao = new FileDAO();
        FileModel file = new FileModel();
        try {
            file = fDao.getFileForTool(tool.getToolID());
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return new ToolFileModel(tool.getToolID(), tool.getToolName(), tool.getToolInfo(), tool.getPrice(), tool.isActive(),
                file.getFileID(), file.getName(), file.getContents(), file.getContentType());
    }


}