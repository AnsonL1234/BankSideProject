package src.backend.dataType;
import java.util.Random;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class User {
    private String userID;
    private String password;
    private String emailAddress;
    private Profile profile; // One to One with Profile
    private List<Account> accounts; // One to Many with Account

    public User() {
        this.userID = "";
        this.password = "";
        this.emailAddress = "";
        this.profile = null;
        this.accounts = new ArrayList<>();
    }

    public User(String userID, String password, String emailAddress) {
        this.userID = userID;
        this.password = password;
        this.emailAddress = emailAddress;
    }

    public User(String userID, String password, String emailAddress, Profile profile) {
        this.userID = userID;
        this.password = password;
        this.emailAddress = emailAddress;
        this.profile = profile;
        this.accounts = new ArrayList<>();
    }

    public boolean isValidEmail() {
        if(this.emailAddress.contains("@gmail.com"))
            return true;
        else if (this.emailAddress.contains("@yahoo.com"))
            return true;
        else if (this.emailAddress.contains("@mytudublin.ie"))
            return true;
        else if (this.emailAddress.contains("@github.com"))
            return true;
        else
            return false;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    @Override
    public String toString() {
        return "User [userID=" + userID + ", password=" + password + ", emailAddress=" + emailAddress + ", profile="
                + profile + ", accounts=" + accounts + "]";
    }
}
