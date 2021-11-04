package bacit.web.amv_models;

public class BookingModel {

    private int bookingID;
    private String startDate;
    private String endDate;
    private String comment;
    private boolean isDelivered;
    private int totalPrice;
    private int userID;
    private int toolID;

    public BookingModel() {

    }

    public BookingModel(String startDate, String endDate, String comment, int totalPrice, int userID, int toolID) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.comment = comment;
        this.totalPrice = totalPrice;
        this.userID = userID;
        this.toolID = toolID;
    }


    public int getBookingID() {
        return bookingID;
    }

    public void setBookingID(int bookingID) {
        this.bookingID = bookingID;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public boolean getIsDelivered() {
        return isDelivered;
    }

    public void setIsDelivered(boolean delivered) {
        isDelivered = delivered;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getToolID() {
        return toolID;
    }

    public void setToolID(int toolID) {
        this.toolID = toolID;
    }

}
