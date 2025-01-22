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
    private List<Loan> loans; // One to Many with Loan
    Random random = new Random();

    public User() {
        this.userID = generateID();
        this.password = "";
        this.emailAddress = "";
        this.accounts = new ArrayList<>();
        this.loans = new ArrayList<>();
    }

    public User(String userID, String password, String emailAddress, Profile profile) {
        this.userID = userID;
        this.password = password;
        this.emailAddress = emailAddress;
        this.profile = profile;
        this.accounts = new ArrayList<>();
        this.loans = new ArrayList<>();
    }

    private String generateID() {
        int randomNumber = random.nextInt(1000);
        return String.format("U%03d", randomNumber);
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

    public List<Loan> getLoans() {
        return loans;
    }

    public void setLoans(List<Loan> loans) {
        this.loans = loans;
    }

    @Override
    public String toString() {
        return "User [userID=" + userID + ", password=" + password + ", emailAddress=" + emailAddress + ", profile="
                + profile + ", accounts=" + accounts + ", loans=" + loans + "]";
    }
}
