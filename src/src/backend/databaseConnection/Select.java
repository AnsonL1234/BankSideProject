package src.backend.databaseConnection;

import java.sql.*;
import java.time.LocalDateTime;

public class Select extends DatabaseConnection{

    /**
     * this will retrieve all the information from database,
     * so whenever the user execute the program, it will first retrieve all data from database
     * */
    protected static void retrieveUserValue() {

        String userQuery = "SELECT * FROM bank_app_database.user";

        try ( Connection connectDatabase = DriverManager.getConnection(url, username, password)) {
            connectDatabase.setAutoCommit(false);

            if(connectDatabase != null) {
                Statement queryStatement = connectDatabase.createStatement();
                ResultSet user_Query = queryStatement.executeQuery(userQuery);

                while (user_Query.next()) {
                    String user_ID = user_Query.getString("user_ID");
                    String user_password = user_Query.getString("user_password");
                    String email_Address = user_Query.getString("email_Address");
                    int profile_ID = user_Query.getInt("profile_ID");
                    String account_ID = user_Query.getString("account_ID");
                }
            }

            //commit the change after retrieve the data from database
            connectDatabase.commit();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static void retrieveProfileValue() {
        String profileQuery = "SELECT * FROM bank_app_database.profile";
        try ( Connection connectDatabase = DriverManager.getConnection(url, username, password)) {
            connectDatabase.setAutoCommit(false);

            if(connectDatabase != null) {
                Statement queryStatement = connectDatabase.createStatement();
                ResultSet profile_Query = queryStatement.executeQuery(profileQuery);

                while (profile_Query.next()) {
                    int profile_ID = profile_Query.getInt("profile_ID");
                    String avatar_path = profile_Query.getString("avatar_path");
                    String first_name = profile_Query.getString("first_name");
                    String last_name = profile_Query.getString("last_name");
                    Date date_of_birth = profile_Query.getDate("date_of_birth");
                    Double phone_number = profile_Query.getDouble("phone_number");
                    String address = profile_Query.getString("address");
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static void retrieveAccountValue() {
        String accountQuery = "SELECT * FROM bank_app_database.account";
        try ( Connection connectDatabase = DriverManager.getConnection(url, username, password)) {
            connectDatabase.setAutoCommit(false);

            if(connectDatabase != null) {
                Statement queryStatement = connectDatabase.createStatement();
                ResultSet account_Query = queryStatement.executeQuery(accountQuery);

                while (account_Query.next()) {
                    String account_ID = account_Query.getString("account_ID");
                    String type_of_account = account_Query.getString("type_of_account");
                    Double current_balance = account_Query.getDouble("current_balance");
                    Double available_balance = account_Query.getDouble("available_balance");
                    String currency_ID = account_Query.getString("currency_ID");
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static void retrieveCurrencyValue() {
        String currencyQuery = "SELECT * FROM bank_app_database.currency";
        try ( Connection connectDatabase = DriverManager.getConnection(url, username, password)) {
            connectDatabase.setAutoCommit(false);

            if(connectDatabase != null) {
                Statement queryStatement = connectDatabase.createStatement();
                ResultSet currency_Query = queryStatement.executeQuery(currencyQuery);

                while (currency_Query.next()) {
                    String currency_ID = currency_Query.getString("currency_ID");
                    String currency_name = currency_Query.getString("currency_name");
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static void retrieveCurrencyExchangeValue() {
        String currency_exchangeQuery = "SELECT * FROM bank_app_database.currency_exchange";
        try ( Connection connectDatabase = DriverManager.getConnection(url, username, password)) {
            connectDatabase.setAutoCommit(false);

            if(connectDatabase != null) {
                Statement queryStatement = connectDatabase.createStatement();
                ResultSet currency_exchange_Query = queryStatement.executeQuery(currency_exchangeQuery);

                while (currency_exchange_Query.next()) {
                    int exchange_ID = currency_exchange_Query.getInt("exchange_ID");
                    String base_exchange_currency = currency_exchange_Query.getString("base_exchange_currency");
                    String target_exchange_currency = currency_exchange_Query.getString("target_exchange_currency");
                    Double exchange_rate = currency_exchange_Query.getDouble("exchange_rate");
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static void retrieveTransactionValue() {
        String transactionQuery = "SELECT * FROM bank_app_database.transaction";
        try ( Connection connectDatabase = DriverManager.getConnection(url, username, password)) {
            connectDatabase.setAutoCommit(false);

            if(connectDatabase != null) {
                Statement queryStatement = connectDatabase.createStatement();
                ResultSet transaction_Query = queryStatement.executeQuery(transactionQuery);

                while (transaction_Query.next()) {
                    int transaction_ID = transaction_Query.getInt("transaction_ID");
                    String payment_ID = transaction_Query.getString("payment_ID");
                    String payment_receiver_ID = transaction_Query.getString("payment_receiver_ID");
                    Double transaction_amount = transaction_Query.getDouble("transaction_amount");
                    Date transfer_date = transaction_Query.getDate("transfer_date");
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static void retrieveLoanValue() {
        String loanQuery = "SELECT * FROM bank_app_database.loan";
        try ( Connection connectDatabase = DriverManager.getConnection(url, username, password)) {
            connectDatabase.setAutoCommit(false);

            if(connectDatabase != null) {
                Statement queryStatement = connectDatabase.createStatement();
                ResultSet loan_Query = queryStatement.executeQuery(loanQuery);

                while (loan_Query.next()) {
                    int loan_ID = loan_Query.getInt("loan_ID");
                    String user_ID = loan_Query.getString("user_ID");
                    String account_ID = loan_Query.getString("account_ID");
                    Double loan_amount = loan_Query.getDouble("loan_amount");
                    Date start_date = loan_Query.getDate("start_date");
                    Date end_date = loan_Query.getDate("end_date");
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
