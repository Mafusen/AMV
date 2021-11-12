package bacit.web.Models;

import java.sql.Date;

public class CertificateModel {

    private int userID;
    private int courseID;
    private Date date;

    public CertificateModel(int userID, int courseID, Date date){

        this.userID = userID;
        this.courseID = courseID;
        this.date = date;

    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getCourseID() {
        return courseID;
    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
