package src.Testing;

import src.backend.ID_Generator;
import src.backend.dataType.Transaction;
import src.backend.databaseConnection.*;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Locale;
import java.util.Scanner;

public class FeatureTesting {

    private Scanner scan = new Scanner(System.in);

    public FeatureTesting() {
        transaction();
//        list_transaction();
    }

    public void retrieveData() {
        Select retrieving = new Select();
//        retrieving.retrieveUserValue();
    }

    //testing login function
    public void login() {
        String email_address, password;
    }

    //testing the user registration table
//    public void user_Registration() {
//        ID_Generator idGenerator = new ID_Generator();
//        Insert userRegister = new Insert();
//
//        //variable for register user
//        String user_ID = idGenerator.generate_user_ID();
//
//        //variable for profile detail
//        int profile_ID = idGenerator.generate_profile_ID();
//
//        //variable for account detail
//        String account_ID = idGenerator.generate_account_ID();
//
//        userRegister.userRegistration(
//               user_ID,"admin2","taydon@gmail.com",
//                2, "E:\\Image\\download.jpg","Taydon","Ling",Date.valueOf("2006-01-15"),874061518, "SandyFord Road, Dundrum, D16R588",
//                account_ID,"business",100, 90,"EUR","Europe Currency"
//        );
//    }

    //method that testing the transaction
    public void transaction() {
        Update updateTransaction = new Update();
        updateTransaction.processTheTransaction("AID12220", "A1001",10.00);
    }

    //display all the transaction
    public void list_transaction() {
        Insert updateTransaction = new Insert();
        ID_Generator idGenerator = new ID_Generator();
        LocalDateTime localDateTime = LocalDateTime.now();
        Timestamp timestamp = Timestamp.valueOf(localDateTime);
        updateTransaction.newTransferInsert(idGenerator.generate_transaction_ID(), "AID12220", "A1001", 10.0, timestamp);
    }

    //method that testing the loan application
    public void loan_application() {

    }

    //displaying all the loan
    public void list_loan() {

    }

    //main method
    public static void main(String[] args) {
        new FeatureTesting();
    }
}
