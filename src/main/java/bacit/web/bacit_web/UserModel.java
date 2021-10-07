package bacit.web.bacit_web;

public class UserModel {
    private String firstName;
    private String lastName;
    private String phone;
    private String userName;
    private String passWord;

    public UserModel(String firstName, String lastName, String phone, String userName, String passWord) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.userName = userName;
        this.passWord = passWord;

    }

    public String getfirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setlastName(String lastName) {
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

}