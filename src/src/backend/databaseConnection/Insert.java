package src.backend.databaseConnection;

import src.backend.ID_Generator;

import java.sql.*;

public class Insert extends DatabaseConnection {

    /** Insertion the new value for user registration */
    public void userRegistration(
            String user_ID, String user_password, String email_address,
            int profile_ID, String avatar_path, String first_name, String last_name, Date date_of_birth, int phone_number, String address,
            String account_ID, String type_of_account, double current_balance, double available_balance, String currency_ID, String currency_name
    ) {

        Connection connectDatabase = null;

        ID_Generator idGenerator = new ID_Generator();

        String profileQuery = "INSERT INTO bank_app_database.profile VALUES(?,?,?,?,?,?,?)";
        String accountQuery = "INSERT INTO bank_app_database.account VALUES(?,?,?,?,?)";
        String currencyQuery = "INSERT INTO bank_app_database.currency VALUES(?,?)";
        String userQuery = "INSERT INTO bank_app_database.user VALUES(?,?,?,?,?)";
        String checkCurrency = "SELECT EXISTS (SELECT 1 FROM bank_app_database.currency WHERE currency_ID = ?)";

        try {

            //connect to the database by url, username, and password
            connectDatabase = DriverManager.getConnection(url, username, password);
            connectDatabase.setAutoCommit(false);

            try {
                boolean isUserIDUnique = false, isAccountIDUnique = false, isProfileIDUnique = false;

                do {
                    System.out.println("Checking user ID " + user_ID);
                    System.out.println(idGenerator.checkUniqueUserID(user_ID,connectDatabase));
                    if (!idGenerator.checkUniqueUserID(user_ID,connectDatabase)) {
                        isUserIDUnique = true;
                    } else {
                        user_ID = idGenerator.generate_user_ID();
                        System.out.println("Re-generate User ID " + user_ID);
                    }
                } while(!isUserIDUnique);

                do {
                    System.out.println("Checking Profile ID " + account_ID);
                    if (!idGenerator.checkUniqueAccountID(account_ID,connectDatabase)) {
                        isAccountIDUnique = true;
                    } else {
                        account_ID = idGenerator.generate_user_ID();
                        System.out.println("Re-generate Account ID " + account_ID);
                    }
                } while(!isAccountIDUnique);

                do {
                    System.out.println("Checking Profile ID " + profile_ID);
                    if (!idGenerator.checkUniqueProfileID(profile_ID,connectDatabase)) {
                        isProfileIDUnique = true;
                    } else {
                        profile_ID = 4;
                        System.out.println("Re-generate Profile ID " + profile_ID);
                    }
                } while(!isProfileIDUnique);

            } catch (SQLException e) {
                e.printStackTrace();
            }

            // Insert into profile table
            PreparedStatement new_profile = connectDatabase.prepareStatement(profileQuery);
            new_profile.setInt(1, profile_ID);
            new_profile.setString(2, avatar_path);
            new_profile.setString(3, first_name);
            new_profile.setString(4, last_name);
            new_profile.setDate(5, date_of_birth);
            new_profile.setInt(6, phone_number);
            new_profile.setString(7, address);

            //after the new value has been insert then execute the query to the database
            int rowsAffectedProfile = new_profile.executeUpdate();

            PreparedStatement checkCurrencyState = connectDatabase.prepareStatement(checkCurrency);
            checkCurrencyState.setString(1, currency_ID);
            ResultSet currencyResult = checkCurrencyState.executeQuery();

            boolean currencyExists = false;
            if(currencyResult.next()) {
                currencyExists = currencyResult.getBoolean(1);
            }

            int rowsAffectedCurrency = 0;
            if (!currencyExists) {
                //insert into currency table
                PreparedStatement new_currency = connectDatabase.prepareStatement(currencyQuery);
                new_currency.setString(1,currency_ID);
                new_currency.setString(2,currency_name);
                rowsAffectedCurrency = new_currency.executeUpdate();
            }

            // Insert into account table
            PreparedStatement new_account = connectDatabase.prepareStatement(accountQuery);
            new_account.setString(1, account_ID);
            new_account.setString(2, type_of_account);
            new_account.setDouble(3, current_balance);
            new_account.setDouble(4, available_balance);
            new_account.setString(5, currency_ID);
            int rowsAffectedAccount = new_account.executeUpdate();

            // Insert into user table
            PreparedStatement new_user = connectDatabase.prepareStatement(userQuery);
            new_user.setString(1, user_ID);
            new_user.setString(2, user_password);
            new_user.setString(3, email_address);
            new_user.setInt(4, profile_ID);
            new_user.setString(5, account_ID);
            int rowsAffectedUser = new_user.executeUpdate();

            connectDatabase.commit();

            if (rowsAffectedProfile > 0 && rowsAffectedAccount > 0 && rowsAffectedUser > 0) {
                System.out.println("User added to the database successfully.");
            }
            System.out.println("Register Successfully!");
        } catch (SQLException e) {

            /** when java check if there is value when catching the error, rollback/delete the value
             *  because once the user didn't enter the data probably which mean the user has failed the registration
             * */
            try {
                if (connectDatabase != null) {
                    connectDatabase.rollback();
                }
            } catch(SQLException e1) {
                System.out.println("Failed to roll back!");
            }
            System.out.println("Connection failed!");
            e.printStackTrace();
        }
    }

    /** Insert the new transaction  */
    public void newTransferInsert(
            int transaction_ID, String payment_ID, String payment_Receiver_ID,
            double transaction_amount, Timestamp transfer_date
    ) {
        Connection connectDatabase = null;

        String transactionQuery = "INSERT INTO bank_app_database.transaction (transaction_ID, payment_ID, payment_receiver_ID, transaction_amount, transfer_date) VALUES(?,?,?,?,?)";

        try {
            connectDatabase = DriverManager.getConnection(url, username, password);
            connectDatabase.setAutoCommit(false);

            PreparedStatement new_transaction = connectDatabase.prepareStatement(transactionQuery);
            new_transaction.setInt(1, transaction_ID);
            new_transaction.setString(2, payment_ID);
            new_transaction.setString(3, payment_Receiver_ID);
            new_transaction.setDouble(4, transaction_amount);
            new_transaction.setTimestamp(5, transfer_date);
            System.out.println("Executing query: " + new_transaction.toString());
            int rowAffectedTransaction = new_transaction.executeUpdate();

            System.out.println("connect to the database");
            //commit the change after execute the row
            connectDatabase.commit();

            if(rowAffectedTransaction > 0) {
                System.out.println("New transaction added to the database!");
            }
        } catch (SQLException e) {
            try {
                if (connectDatabase != null) {
                    connectDatabase.rollback();
                }
            } catch (SQLException e1) {
                System.out.println("New transaction failed add to database!");
            }
            e.printStackTrace();
        }
    }

    public boolean isCurrencyExchangeInsert(
            int exchange_ID, String base_exchange_currency, String target_exchange_currency, Double exchange_date
    ) {
        Connection connectDatabase = null;

        String currencyExchangeQuery = "INSERT INTO bank_app_database.currency_exchange VALUES(?,?,?,?)";

        try {
            connectDatabase = DriverManager.getConnection(url, username, password);
            connectDatabase.setAutoCommit(false);

            PreparedStatement new_exchange_rate = connectDatabase.prepareStatement(currencyExchangeQuery);
            new_exchange_rate.setInt(1, exchange_ID);
            new_exchange_rate.setString(2, base_exchange_currency);
            new_exchange_rate.setString(3, target_exchange_currency);
            new_exchange_rate.setDouble(4, exchange_date);
            int rowAffectedExchangeRate = new_exchange_rate.executeUpdate();

            //commit the change after execute the row
            connectDatabase.commit();

            if(rowAffectedExchangeRate > 0) {
                System.out.println("New transaction added to the database!");
                return true;
            }

            return true;
        } catch (SQLException e) {
            try {
                if (connectDatabase != null) {
                    connectDatabase.rollback();
                }
            } catch (SQLException e1) {
                System.out.println("New transaction failed add to database!");
            }
            return false;
        }
    }

    public void newLoanInsert(
            int loan_ID, String user_ID, String account_ID, Double loan_amount, Timestamp start_date, Timestamp end_date
    ) {
        Connection connectDatabase = null;

        String loanQuery = "INSERT INTO bank_app_database.loan VALUES(?,?,?,?,?,?)";

        try {
            connectDatabase = DriverManager.getConnection(url, username, password);
            connectDatabase.setAutoCommit(false);

            PreparedStatement new_loan = connectDatabase.prepareStatement(loanQuery);
            new_loan.setInt(1, loan_ID);
            new_loan.setString(2, user_ID);
            new_loan.setString(3, account_ID);
            new_loan.setDouble(4, loan_amount);
            new_loan.setTimestamp(4, start_date);
            new_loan.setTimestamp(4, end_date);
            int rowAffectedLoan = new_loan.executeUpdate();

            //commit the change after execute the row
            connectDatabase.commit();

            if(rowAffectedLoan > 0) {
                System.out.println("New transaction added to the database!");
            }
        } catch (SQLException e) {
            try {
                if (connectDatabase != null) {
                    connectDatabase.rollback();
                }
            } catch (SQLException e1) {
                System.out.println("New transaction failed add to database!");
            }
        }
    }

}
