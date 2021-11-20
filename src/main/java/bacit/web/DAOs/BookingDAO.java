package bacit.web.DAOs;

import bacit.web.Models.BookingModel;
import bacit.web.Models.ToolModel;
import bacit.web.Models.UserModel;
import bacit.web.Utilities.DBUtils;

import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;


public class BookingDAO {
    PrintWriter out;


    public List<BookingModel> searchProductBookings(String userID, String toolID){

        List<BookingModel> productBookings = new ArrayList<>();

        try{
            Connection db = DBUtils.getINSTANCE().getConnection(out);

            String query ="select * from BOOKING where USER_ID = ? and TOOL_ID = ?";
            PreparedStatement statement = db.prepareStatement(query);
            statement.setString(1, userID);
            statement.setString(2, toolID);
            ResultSet rs = statement.executeQuery();

            while(rs.next()){
                BookingModel model = new BookingModel();
                model.setBookingID(rs.getInt("BOOKING_ID"));
                model.setStartDate(rs.getString("StartDate"));
                model.setEndDate(rs.getString("EndDate"));
                model.setComment(rs.getString("Cmnt"));
                model.setIsDelivered(rs.getBoolean("IsDelivered"));
                model.setTotalPrice(rs.getInt("TotalPrice"));
                model.setUserID(rs.getInt("USER_ID"));
                model.setToolID(rs.getInt("TOOL_ID"));
                productBookings.add(model);
            }


        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return productBookings;
    }

    public LinkedHashMap<UserModel, BookingModel> activeToolBookings(int toolID){

        LinkedHashMap<UserModel, BookingModel> bookings = new LinkedHashMap<>();

        try{
            Connection db = DBUtils.getINSTANCE().getConnection(out);

            String query = "SELECT USER.Fname, USER.Lname, USER.Phone, BOOKING.StartDate, BOOKING.EndDate FROM BOOKING " +
                    "inner JOIN USER ON BOOKING.USER_ID=USER.USER_ID where TOOL_ID = ? and " +
                    "EndDate >= curdate() ORDER BY EndDate ASC";
            PreparedStatement statement = db.prepareStatement(query);
            statement.setInt(1, toolID);
            ResultSet rs = statement.executeQuery();

            while(rs.next()){
                UserModel user = new UserModel();
                user.setFirstName(rs.getString("Fname"));
                user.setLastName(rs.getString("Lname"));
                user.setPhone(rs.getString("Phone"));

                BookingModel booking = new BookingModel();
                booking.setStartDate(rs.getString("StartDate"));
                booking.setEndDate(rs.getString("EndDate"));

                bookings.put(user, booking);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return bookings;

    }

    public LinkedHashMap<ToolModel, BookingModel> getUserBookings(int userID){

        LinkedHashMap<ToolModel, BookingModel> bookings = new LinkedHashMap<>();

        try {
            Connection db = DBUtils.getINSTANCE().getConnection(out);
            String query = "SELECT BOOKING.BOOKING_ID, BOOKING.StartDate, BOOKING.EndDate, BOOKING.Cmnt, BOOKING.IsDelivered, BOOKING.TotalPrice, TOOL.Tool_Name FROM BOOKING " +
                    "inner JOIN TOOL ON BOOKING.TOOL_ID = TOOL.TOOL_ID where BOOKING.USER_ID = ?;";
            PreparedStatement statement = db.prepareStatement(query);
            statement.setInt(1, userID);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                ToolModel tool = new ToolModel();
                tool.setToolName(rs.getString("Tool_Name"));

                BookingModel booking = new BookingModel();
                booking.setBookingID(rs.getInt("BOOKING_ID"));
                booking.setStartDate(rs.getString("StartDate"));
                booking.setEndDate(rs.getString("EndDate"));
                booking.setComment(rs.getString("Cmnt"));
                booking.setIsDelivered(rs.getBoolean("IsDelivered"));
                booking.setTotalPrice(rs.getInt("TotalPrice"));

                bookings.put(tool, booking);
            }
        }
        catch(SQLException | ClassNotFoundException exception){
            exception.printStackTrace();
        }

        return bookings;
    }

    public LinkedHashMap<ToolModel, BookingModel> activeUserBookings(int userID){

        LinkedHashMap<ToolModel, BookingModel> bookings = new LinkedHashMap<>();

        try {
            Connection db = DBUtils.getINSTANCE().getConnection(out);
            String query = "SELECT BOOKING.BOOKING_ID, BOOKING.StartDate, BOOKING.EndDate, BOOKING.Cmnt, BOOKING.IsDelivered, BOOKING.TotalPrice, " +
                    "TOOL.TOOL_ID, TOOL.Tool_Name, TOOL.Tool_Info, TOOL.Price FROM BOOKING inner JOIN TOOL ON " +
                    "BOOKING.TOOL_ID = TOOL.TOOL_ID where BOOKING.USER_ID = ? and BOOKING.StartDate >= curdate() and " +
                    "BOOKING.EndDate <= curdate()+(BOOKING.EndDate-BOOKING.StartDate) and BOOKING.IsDelivered = 0; ";

            PreparedStatement statement = db.prepareStatement(query);
            statement.setInt(1, userID);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                ToolModel tool = new ToolModel();
                tool.setToolID(rs.getInt("TOOL_ID"));
                tool.setToolName(rs.getString("Tool_Name"));
                tool.setToolInfo(rs.getString("Tool_Info"));
                tool.setPrice(rs.getInt("Price"));

                BookingModel booking = new BookingModel();
                booking.setBookingID(rs.getInt("BOOKING_ID"));
                booking.setStartDate(rs.getString("StartDate"));
                booking.setEndDate(rs.getString("EndDate"));
                booking.setComment(rs.getString("Cmnt"));
                booking.setIsDelivered(rs.getBoolean("IsDelivered"));
                booking.setTotalPrice(rs.getInt("TotalPrice"));

                bookings.put(tool, booking);
            }
        }
        catch(SQLException | ClassNotFoundException exception){
            exception.printStackTrace();
        }

        return bookings;
    }

    public LinkedHashMap<ToolModel, BookingModel> getFutureBookings(int userID){

        LinkedHashMap<ToolModel, BookingModel> bookings = new LinkedHashMap<>();

        try {
            Connection db = DBUtils.getINSTANCE().getConnection(out);
            String query = "SELECT BOOKING.BOOKING_ID, BOOKING.StartDate, BOOKING.EndDate, BOOKING.Cmnt, " +
                    "BOOKING.IsDelivered, BOOKING.TotalPrice, TOOL.TOOL_ID, TOOL.Tool_Name, TOOL.Tool_Info, TOOL.Price FROM BOOKING " +
                    "inner JOIN TOOL ON BOOKING.TOOL_ID = TOOL.TOOL_ID where BOOKING.USER_ID = ? " +
                    "and BOOKING.StartDate > curdate();";

            PreparedStatement statement = db.prepareStatement(query);
            statement.setInt(1, userID);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                ToolModel tool = new ToolModel();
                tool.setToolID(rs.getInt("TOOL_ID"));
                tool.setToolName(rs.getString("Tool_Name"));
                tool.setToolInfo(rs.getString("Tool_Info"));
                tool.setPrice(rs.getInt("Price"));

                BookingModel booking = new BookingModel();
                booking.setBookingID(rs.getInt("BOOKING_ID"));
                booking.setStartDate(rs.getString("StartDate"));
                booking.setEndDate(rs.getString("EndDate"));
                booking.setComment(rs.getString("Cmnt"));
                booking.setIsDelivered(rs.getBoolean("IsDelivered"));
                booking.setTotalPrice(rs.getInt("TotalPrice"));

                bookings.put(tool, booking);
            }
        }
        catch(SQLException | ClassNotFoundException exception){
            exception.printStackTrace();
        }

        return bookings;
    }

    public BookingModel getBooking(int bookingID){

        BookingModel model = new BookingModel();

        try {
            Connection db = DBUtils.getINSTANCE().getConnection(out);

            String query = "select * from BOOKING where BOOKING_ID = ?";
            PreparedStatement statement = db.prepareStatement(query);
            statement.setInt(1, bookingID);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                model.setBookingID(rs.getInt("BOOKING_ID"));
                model.setStartDate(rs.getString("StartDate"));
                model.setEndDate(rs.getString("EndDate"));
                model.setComment(rs.getString("Cmnt"));
                model.setIsDelivered(rs.getBoolean("IsDelivered"));
                model.setTotalPrice(rs.getInt("TotalPrice"));
                model.setUserID(rs.getInt("USER_ID"));
                model.setToolID(rs.getInt("TOOL_ID"));
            }

        }
        catch(SQLException | ClassNotFoundException exception){
            exception.printStackTrace();
        }

        return model;

    }

    public void registerBooking(BookingModel model) {

        try {

            Connection db = DBUtils.getINSTANCE().getConnection(out);

            // Write  insertion query
            String query = "insert into BOOKING (StartDate, EndDate, Cmnt, TotalPrice, USER_ID, TOOL_ID, IsDelivered) values (?, ?, ?, ?, ?, ?, 0)";

            // Set parameters with PreparedStatement
            PreparedStatement statement = db.prepareStatement(query);
            statement.setString(1, model.getStartDate());
            statement.setString(2, model.getEndDate());
            statement.setString(3, model.getComment());
            statement.setInt(4, model.getTotalPrice());
            statement.setInt(5, model.getUserID());
            statement.setInt(6, model.getToolID());

            // Execute the statement
            statement.executeQuery();

        } catch (SQLException | ClassNotFoundException exception) {
            exception.printStackTrace();
        }
    }

    public void updateTotalPrice(int bookingID, int toolPrice) throws SQLException, ClassNotFoundException {

        Connection db = DBUtils.getINSTANCE().getConnection(out);

        String query = "select DATEDIFF(curdate(), StartDate) from BOOKING where BOOKING_ID = ?;";
        PreparedStatement statement = db.prepareStatement(query);
        statement.setInt(1, bookingID);
        ResultSet rs = statement.executeQuery();

        String diffString = rs.getString("DATEDIFF(curdate(), StartDate)");
        int dateDiff = Integer.parseInt(diffString);
        int totalPrice = dateDiff * toolPrice;

        String query2 = "update BOOKING set TotalPrice = ? where BOOKING_ID = ?;";
        PreparedStatement statement2 = db.prepareStatement(query2);
        statement2.setInt(1, totalPrice);
        statement2.setInt(2, bookingID);
        ResultSet rs2 = statement.executeQuery();

    }

    public void deliverBooking(BookingModel model, ToolModel tool) {

        try {

            Connection db = DBUtils.getINSTANCE().getConnection(out);

            // Write  insertion query
            String query = "UPDATE BOOKING set IsDelivered = 1, Cmnt = ?, EndDate = curdate() where BOOKING_ID = ?";

            // Set parameters with PreparedStatement
            PreparedStatement statement = db.prepareStatement(query);
            statement.setString(1, model.getComment());
            statement.setInt(2, model.getBookingID());

            // Execute the statement
            statement.executeQuery();

            updateTotalPrice(model.getBookingID(), tool.getPrice());
        } catch (SQLException | ClassNotFoundException exception) {
            exception.printStackTrace();
        }

    }

    public boolean checkFuture (int bookingID) throws SQLException, ClassNotFoundException {

        boolean isFuture = false;

        Connection db = DBUtils.getINSTANCE().getConnection(out);
        String query = "SELECT BOOKING_ID FROM BOOKING where BOOKING_ID = ? and BOOKING.StartDate > curdate();";
        PreparedStatement statement = db.prepareStatement(query);
        statement.setInt(1, bookingID);
        ResultSet rs = statement.executeQuery();
        int dbID = 0;
        while(rs.next()){
            dbID = rs.getInt("BOOKING_ID");
        }

        if(dbID != 0){
            isFuture = true;
        }

        return isFuture;

    }

    public boolean deleteBooking(int bookingID) throws SQLException, ClassNotFoundException {

        boolean deletion = false;

        Connection db = DBUtils.getINSTANCE().getConnection(out);
        String query = "DELETE from BOOKING where BOOKING.Booking_ID = ?;";
        PreparedStatement statement = db.prepareStatement(query);
        statement.setInt(1, bookingID);
        statement.executeQuery();

        if(getBooking(bookingID).getBookingID() != bookingID){
            deletion = true;
        }

        return deletion;
    }

}
