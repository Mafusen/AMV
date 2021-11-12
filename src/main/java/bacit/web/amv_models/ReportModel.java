package bacit.web.amv_models;

import java.sql.Date;

public class ReportModel {

    private int bookingID;
    private Date startDate;
    private Date endDate;
    private String comment;
    private int totalPrice;
    private String toolName;
    private String firstName;
    private String lastName;

    public ReportModel(int bookingID, Date startDate, Date endDate, String comment, int totalPrice,
                       String toolName, String firstName, String lastName){
        this.bookingID = bookingID;
        this.startDate = startDate;
        this.endDate = endDate;
        this.comment = comment;
        this.totalPrice = totalPrice;
        this.toolName = toolName;
        this.firstName = firstName;
        this.lastName = lastName;

    }

    public int getBookingID() {
        return bookingID;
    }

    public void setBookingID(int bookingID) {
        this.bookingID = bookingID;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getToolName() {
        return toolName;
    }

    public void setToolName(String toolName) {
        this.toolName = toolName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

}

