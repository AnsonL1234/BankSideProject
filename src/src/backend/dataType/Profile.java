package src.backend.dataType;

import java.sql.Date;
import java.util.Random;
public class Profile {
    private int profileId;
    private String avatar_path; //avatar_path missing, modify by anson at 12:39 22/01/2025
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private int phoneNumber;
    private String specificAddress;

    public Profile() {
        this.profileId = 0;
        this.avatar_path = "";
        this.firstName = "";
        this.lastName = "";
        this.dateOfBirth = null;
        this.phoneNumber = 0;
        this.specificAddress = "";
    }

    public Profile(int profileId, String avatar, String firstName, String lastName, Date dateOfBirth, int phoneNumber, String specificAddress) {
        this.profileId = profileId;
        this.avatar_path = avatar;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phoneNumber;
        this.specificAddress = specificAddress;
    }

    public int getProfileId() {
        return profileId;
    }

    public void setProfileId(int profileId) {
        this.profileId = profileId;
    }

    //avatar_path missing, added by anson at 12:39 22/01/2025
    public String getAvatar_Path() {
        return avatar_path;
    }

    public void setAvatar_Path(String avatar) {
        this.avatar_path = avatar;
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

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getSpecificAddress() {
        return specificAddress;
    }

    public void setSpecificAddress(String specificAddress) {
        this.specificAddress = specificAddress;
    }


    //avatar_path missing, added by anson at 12:39 22/01/2025
    @Override
    public String toString() {
        return "Profile [profileId=" + profileId + "avatar=" + this.avatar_path + "firstName=" + firstName + ", lastName=" + lastName
                + ", dateOfBirth=" + dateOfBirth + ", phoneNumber=" + phoneNumber + ", specificAddress="
                + specificAddress + "]";
    }
}
