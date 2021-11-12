package bacit.web.Models;

public class UserModel {
    private int userID;
    private String firstName;
    private String lastName;
    private String phone;
    private String userName;
    private String passWord;
    public boolean active;

    public UserModel() {
    }

    public UserModel(int userID, String firstName, String lastName, String phone, String userName, String passWord, boolean active) {
        this.userID = userID;
        this.userName = userName;
        this.passWord = passWord;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.active = active;
    }

    public int getUserID(){
        return userID;
    }

    public void setUserID(int userID){
        this.userID = userID;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword(){
        return passWord;
    }

    public void setPassWord(String passWord){
        this.passWord = passWord;
    }

    public boolean isActive() { return active; }

    public void setActive(boolean active) { this.active = active; }
}