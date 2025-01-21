package src.backend.databaseConnection;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Update extends DatabaseConnection {

    protected void processTheTransaction(
            String payment_ID, String payment_receiver_ID, Double amount
    ) {

        String updateSenderQuery = "UPDATE bank_app_database.account SET current_balance = current_balance - ?, available_balance = available_balance - ? WHERE account_ID = ?";
        String updateReceiverQuery = "UPDATE bank_app_database.account SET current_balance = current_balance + ?, available_balance = available_balance + ? WHERE account_ID = ?";

        //reference variable from another class
        Insert transactionRecord = new Insert();

        //reference variable for connecting to database
        Connection databaseConnect = null;

        try{
            databaseConnect = DriverManager.getConnection(url,username,password);
            databaseConnect.setAutoCommit(false);

            //execute statement for update the transaction query after the user send the money
            try (PreparedStatement updateSender = databaseConnect.prepareStatement(updateSenderQuery)) {
                updateSender.setDouble(1, amount);
                updateSender.setDouble(2, amount);
                updateSender.setString(3, payment_ID);
                updateSender.executeUpdate();
            }

            //execute this statement for update the transaction query after the user receive the money
            try (PreparedStatement updateReceiver = databaseConnect.prepareStatement(updateReceiverQuery)) {
                updateReceiver.setDouble(1, amount);
                updateReceiver.setDouble(2, amount);
                updateReceiver.setString(3, payment_receiver_ID);
                updateReceiver.executeUpdate();
            }

            //commit the update after executing the query
            databaseConnect.commit();

        } catch (SQLException e) {
            try {
                if(databaseConnect != null) {
                    databaseConnect.rollback();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    /** Apply Loan is the method that will process the loan application */
    protected void applyLoan(
            String user_ID, String account_ID, Double loan_amount
    ) {

        //query for update the account
        String updateAccountQuery = "UPDATE bank_app_database.account SET current_balance = current_balance + ?," +
                " available_balance = available_balance + ? WHERE user_ID = ? AND account_ID = ?";

        Connection databaseConnection = null;

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
