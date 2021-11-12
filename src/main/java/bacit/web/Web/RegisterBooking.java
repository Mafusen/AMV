package bacit.web.Web;

import bacit.web.DAOs.BookingDAO;
import bacit.web.DAOs.ToolDAO;
import bacit.web.DAOs.UserDAO;
import bacit.web.Models.BookingModel;
import bacit.web.Models.ToolModel;
import bacit.web.Models.UserModel;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "registerBooking", value = "/registerBooking")
public class RegisterBooking extends HttpServlet {

    @Override protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        HttpSession session = request.getSession();


        // Collect form data
        String startDate = request.getParameter("start");
        String endDate = request.getParameter("end");
        String comment = "";

        String username = (String) session.getAttribute("username");

        UserDAO uDao = new UserDAO();
        UserModel user;
        user = uDao.getUser(username);
        int userID = user.getUserID();

        String toolIDString = request.getParameter("toolID");
        int toolID = Integer.parseInt(toolIDString);

        ToolDAO tDao = new ToolDAO();
        ToolModel tool = new ToolModel();
        try {
            tool = tDao.getTool(toolID);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        int totalPrice = tool.getPrice();

        // Insert in constructor for BookingModel
        BookingModel booking = new BookingModel(startDate, endDate, comment, totalPrice, userID, toolID);

        // Call DAO layer and save the user object to DB
        BookingDAO dao = new BookingDAO();
        dao.registerBooking(booking);

        // Prepare information message for user about operation result
        response.sendRedirect("frontpageServlet");

    }

}
