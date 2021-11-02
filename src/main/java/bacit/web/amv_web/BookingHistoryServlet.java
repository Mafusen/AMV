package bacit.web.amv_web;

import bacit.web.amv_DAO.BookingDAO;
import bacit.web.amv_DAO.ToolDAO;
import bacit.web.amv_DAO.UserDAO;
import bacit.web.amv_models.BookingModel;
import bacit.web.amv_models.ToolModel;
import bacit.web.amv_models.UserModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.tools.Tool;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@WebServlet(name = "bookingHistoryServlet", value = "/bookingHistoryServlet")
public class BookingHistoryServlet extends HttpServlet {

    PrintWriter out;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        UserDAO dao = new UserDAO();
        UserModel user = dao.getUser("Jenru");
        int userID = user.getUserID();

        // Call DAO layer and get all bookings for specific user
        BookingDAO bDao = new BookingDAO();
        List<BookingModel> bookings = bDao.getUserBookings(userID);


        ToolDAO tDao = null;
        List<ToolModel> tools = new ArrayList<>();


        try {
            tools = getToolFromID(out);

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        request.setAttribute("bookings", bookings);
        request.setAttribute("user", user);
        request.setAttribute("tools", tools);
        request.getRequestDispatcher("/bookingHistory.jsp").forward(request, response);

    }

    private List<ToolModel> getToolFromID(PrintWriter out) throws SQLException, ClassNotFoundException {
        ArrayList<Integer> iDs = new ArrayList<>();

        UserDAO uDao = new UserDAO();
        UserModel user = uDao.getUser("Jenru");
        int userID = user.getUserID();

        BookingDAO bDao = new BookingDAO();
        List<BookingModel> bookings = bDao.getUserBookings(userID);

        List<ToolModel> tools = new ArrayList<>();

        for(BookingModel booking : bookings){
            int iD = booking.getToolID();
            ToolDAO tDao = new ToolDAO();
            ToolModel tool = tDao.getTool(iD);
            tools.add(tool);
        }

        return tools;
    }

}
