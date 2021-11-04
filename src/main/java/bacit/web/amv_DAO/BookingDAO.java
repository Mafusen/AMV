package bacit.web.amv_DAO;

import bacit.web.amv_models.BookingModel;
import bacit.web.amv_utilities.DBUtils;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class BookingDAO {
    PrintWriter out;


    public List<BookingModel> searchProductBookings(String userID, String toolID){

        List<BookingModel> productBookings = new ArrayList<>();

        try{
            Connection db = DBUtils.getINSTANCE().getConnection(out);

            String query ="select * from Booking where USER_ID = ? and TOOL_ID = ?";
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

            String query = "select * from Booking where USER_ID = ?";
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

            String query = "select * from Booking where BOOKING_ID = ?";
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

}
