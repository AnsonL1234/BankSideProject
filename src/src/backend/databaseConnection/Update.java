package src.backend.databaseConnection;

import src.backend.ID_Generator;
import src.backend.dataType.Loan;

import java.sql.*;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Update extends DatabaseConnection {

    public void processTheTransaction(
            String payment_ID, String payment_receiver_ID, Double amount
    ) {

        String updateSenderQuery = "UPDATE bank_app_database.account SET currency_balance = currency_balance - ?, available_balance = available_balance - ? WHERE account_ID = ?";
        String updateReceiverQuery = "UPDATE bank_app_database.account SET currency_balance = currency_balance + ?, available_balance = available_balance + ? WHERE account_ID = ?";

        //reference variable from another class
        Insert transactionRecord = new Insert();

        //reference variable for connecting to database
        Connection databaseConnect = null;

        try{
            databaseConnect = DriverManager.getConnection(url,username,password);
            databaseConnect.setAutoCommit(false);
//            System.out.println("Connect to database");


            //execute statement for update the transaction query after the user send the money
            PreparedStatement updateSender = databaseConnect.prepareStatement(updateSenderQuery);
//            System.out.println("Preparing statement");
            updateSender.setDouble(1, amount);
            updateSender.setDouble(2, amount);
            updateSender.setString(3, payment_ID);
            int rowsSender = updateSender.executeUpdate();

            if (rowsSender == 0) {
                System.out.println("No rows updated for sender. Check account ID: " + payment_ID);
            }

            //execute this statement for update the transaction query after the user receive the money
            PreparedStatement updateReceiver = databaseConnect.prepareStatement(updateReceiverQuery);
//            System.out.println("Preparing second statement");
            updateReceiver.setDouble(1, amount);
            updateReceiver.setDouble(2, amount);
            updateReceiver.setString(3, payment_receiver_ID);
            int rowsReceiver = updateReceiver.executeUpdate();

            //debug
            if (rowsReceiver == 0) {
                System.out.println("No rows updated for receiver. Check account ID: " + payment_receiver_ID);
            }

            //commit the update after executing the query
            databaseConnect.commit();
            System.out.println("Transaction processed successfully.");

            //record the transaction after the commit
            ID_Generator idGenerator = new ID_Generator();
            LocalDateTime localDateTime = LocalDateTime.now();
            Timestamp timestamp = Timestamp.valueOf(localDateTime);
            transactionRecord.newTransferInsert(idGenerator.generate_transaction_ID(), payment_ID, payment_receiver_ID, amount, timestamp);
            System.out.println("Transaction record successfully.");

        } catch (SQLException e) {
            try {
                if(databaseConnect != null) {
                    databaseConnect.rollback();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        }
    }

    /** Apply Loan is the method that will process the loan application */
    public void applyLoan(
            String user_ID, String account_ID, double loan_amount
    ) {

        //query for update the account
        String updateAccountQuery = "UPDATE bank_app_database.account SET current_balance = current_balance + ?," +
                " available_balance = available_balance + ? WHERE user_ID = ? AND account_ID = ?";

        Connection databaseConnection = null;

        Insert insertLoanRecord = new Insert();

        try {
            databaseConnection = DriverManager.getConnection(url,username,password);
            databaseConnection.setAutoCommit(false);

            //update the account query by executing the statement
            try(PreparedStatement updateLoanQuery = databaseConnection.prepareStatement(updateAccountQuery)) {
                updateLoanQuery.setDouble(1, loan_amount);
                updateLoanQuery.setDouble(2, loan_amount);
                updateLoanQuery.setString(3, user_ID);
                updateLoanQuery.setString(4, account_ID);
            }

            //commit the update after executing the query
            databaseConnection.commit();

            ID_Generator idGenerator = new ID_Generator();
            LocalDateTime localDateTime = LocalDateTime.now();
            Timestamp timestamp = Timestamp.valueOf(localDateTime);
            insertLoanRecord.newLoanInsert(idGenerator.generate_loan_ID(),user_ID,account_ID,loan_amount,timestamp,timestamp);

        } catch (SQLException e) {
            try {
                if(databaseConnection != null) {
                    databaseConnection.rollback();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}
