package src.backend.dataType;

import java.util.Random;
public class Profile {
    private int profileId;
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private String phoneNumber;
    private String specificAddress;
    Random random = new Random();

    public Profile() {
        this.profileId = generateID();
        this.firstName = "";
        this.lastName = "";
        this.dateOfBirth = "";
        this.phoneNumber = "";
        this.specificAddress = "";
    }

    public Profile(int profileId, String firstName, String lastName, String dateOfBirth, String phoneNumber, String specificAddress) {
        this.profileId = profileId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phoneNumber;
        this.specificAddress = specificAddress;
    }

    private int generateID() {
         int profileID =+ 1;
         return profileID;
    }

    public int getProfileId() {
        return profileId;
    }

    public void setProfileId(int profileId) {
        this.profileId = profileId;
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

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getSpecificAddress() {
        return specificAddress;
    }

    public void setSpecificAddress(String specificAddress) {
        this.specificAddress = specificAddress;
    }

    @Override
    public String toString() {
        return "Profile [profileId=" + profileId + ", firstName=" + firstName + ", lastName=" + lastName
                + ", dateOfBirth=" + dateOfBirth + ", phoneNumber=" + phoneNumber + ", specificAddress="
                + specificAddress + "]";
    }
}
