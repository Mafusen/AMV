package bacit.web.amv_models;

public class ToolBookingModel {

    private int bookingID;
    private String startDate;
    private String endDate;
    private String comment;
    private boolean isDelivered;
    private int totalPrice;
    private int userID;
    private int toolID;
    private String toolName;
    private String toolInfo;
    private int price;
    private boolean isActive;

    public ToolBookingModel(){}

    public String getToolName() {
        return toolName;
    }

    public void setToolName(String toolName) {
        this.toolName = toolName;
    }

    public String getToolInfo() {
        return toolInfo;
    }

    public void setToolInfo(String toolInfo) {
        this.toolInfo = toolInfo;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public int getBookingID() {return bookingID;}

    public void setBookingID(int bookingID) {this.bookingID = bookingID;}

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

    public int getUserID() {return userID;}

    public void setUserID(int userID) {this.userID = userID;}

    public int getToolID() {return toolID;}

    public void setToolID(int toolID) {this.toolID = toolID;}
}
