package bacit.web.DAOs;

import bacit.web.Models.BookingModel;
import bacit.web.Utilities.DBUtils;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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

    public List<BookingModel> getUserBookings(int userID){


        List<BookingModel> bookings = new ArrayList<>();

        try {
            Connection db = DBUtils.getINSTANCE().getConnection(out);

            String query = "select * from BOOKING where USER_ID = ?";
            PreparedStatement statement = db.prepareStatement(query);
            statement.setInt(1, userID);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                BookingModel model = new BookingModel();
                model.setBookingID(rs.getInt("BOOKING_ID"));
                model.setStartDate(rs.getString("StartDate"));
                model.setEndDate(rs.getString("EndDate"));
                model.setComment(rs.getString("Cmnt"));
                model.setIsDelivered(rs.getBoolean("IsDelivered"));
                model.setTotalPrice(rs.getInt("TotalPrice"));
                model.setUserID(rs.getInt("USER_ID"));
                model.setToolID(rs.getInt("TOOL_ID"));
                bookings.add(model);
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
            String query = "insert into BOOKING (StartDate, EndDate, Cmnt, TotalPrice, USER_ID, TOOL_ID) values (?, ?, ?, ?, ?, ?)";

            // Set parameters with PreparedStatement
            PreparedStatement statement = db.prepareStatement(query);
            statement.setString(1, model.getStartDate());
            statement.setString(2, model.getEndDate());
            statement.setString(3, model.getComment());
            statement.setInt(4, model.getTotalPrice());
            statement.setInt(5, model.getUserID());
            statement.setInt(6, model.getToolID());

            // Execute the statement
            ResultSet rs = statement.executeQuery();

        } catch (SQLException | ClassNotFoundException exception) {
            exception.printStackTrace();
        }
    }

    public void deliverBooking(BookingModel model) {

        try {

            Connection db = DBUtils.getINSTANCE().getConnection(out);

            // Write  insertion query
            String query = "UPDATE BOOKING set IsDelivered = 1, Cmnt = ? where BOOKING_ID = ?";

            // Set parameters with PreparedStatement
            PreparedStatement statement = db.prepareStatement(query);
            statement.setString(1, model.getComment());
            statement.setInt(2, model.getBookingID());

            // Execute the statement
            ResultSet rs = statement.executeQuery();

        } catch (SQLException | ClassNotFoundException exception) {
            exception.printStackTrace();
        }
    }

}
