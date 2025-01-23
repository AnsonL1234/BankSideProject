package src.backend.databaseConnection;

import src.backend.dataType.*;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Select extends DatabaseConnection {

    public User retrieveInfoByLogin(String emailOrUserID, String password) {
        User user = null;
        String userQuery = "SELECT * FROM bank_app_database WHERE (email_address = ? OR user_ID = ?) AND user_password = ?";

        try (Connection connectDatabase = DriverManager.getConnection(url, username, password)) {
            PreparedStatement statement = connectDatabase.prepareStatement(userQuery);

            statement.setString(1, emailOrUserID);
            statement.setString(2, emailOrUserID);
            statement.setString(3, password);

            ResultSet queryExecute = statement.executeQuery();

            if (queryExecute.next()) {
                user = new User();
                user.setUserID(queryExecute.getString("user_ID"));
                user.setPassword(queryExecute.getString("user_password"));
                user.setEmailAddress(queryExecute.getString("email_address"));

                int profile_ID = queryExecute.getInt("profile_ID");
                Profile profile = retrieveDataByProfileID(profile_ID);
                user.setProfile(profile);

                List<Account> accountList = retrieveAccountByUserID(user.getUserID());
                user.setAccounts(accountList);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }

    protected Profile retrieveDataByProfileID(int profile_ID) {
        Profile profile = null;
        String profileQuery = "SELECT * FROM bank_app_database.profile WHERE profile_ID = ?";

        try (Connection connectDatabase = DriverManager.getConnection(url, username, password)) {
            PreparedStatement profileState = connectDatabase.prepareStatement(profileQuery);

            profileState.setInt(1, profile_ID);

            ResultSet profileResult = profileState.executeQuery();

            if (profileResult.next()) {
                profile = new Profile();
                profile.setProfileId(profileResult.getInt("profile_ID"));
                profile.setAvatar_Path(profileResult.getString("avatar_path"));
                profile.setFirstName(profileResult.getString("first_name"));
                profile.setLastName(profileResult.getString("last_name"));
                profile.setDateOfBirth(profileResult.getDate("date_of_birth"));
                profile.setPhoneNumber(profileResult.getInt("phone_number"));
                profile.setSpecificAddress(profileResult.getString("address"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return profile;
    }

    protected List<Account> retrieveAccountByUserID(String user_ID) {
        List<Account> accountList = new ArrayList<>();
        String accountQuery = "SELECT * FROM bank_app_database.account JOIN bank_app_database.user ON account.account_ID = user.account_ID WHERE user_ID = ?";

        try (Connection connectDatabase = DriverManager.getConnection(url, username, password)) {
            PreparedStatement accountState = connectDatabase.prepareStatement(accountQuery);

            accountState.setString(1, user_ID);

            ResultSet accountResult = accountState.executeQuery();

            while (accountResult.next()) {
                Account account = new Account();
                account.setAccountId(accountResult.getString("account_ID"));
                account.setTypeOfAccount(accountResult.getString("type_of_account"));
                account.setCurrentBalance(accountResult.getDouble("current_balance"));
                account.setAvailableBalance(accountResult.getDouble("available_balance"));

                Currency currency = retrieveCurrencyByAccountID(account.getAccountId());
                account.setCurrency(currency);

                List<Transaction> transactions = retrieveTransactionByAccountID(account.getAccountId());
                account.setTransactions(transactions);

                accountList.add(account);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return accountList;
    }

    protected Currency retrieveCurrencyByAccountID(String account_ID) {
        Currency currency = null;

        String currencyQuery = "SELECT * FROM bank_app_database.currency JOIN bank_app_database.account ON currency.currency_ID = account.currency_ID WHERE account_ID = ?";

        try (Connection connectDatabase = DriverManager.getConnection(url, username, password)) {
            PreparedStatement currencyState = connectDatabase.prepareStatement(currencyQuery);

            currencyState.setString(1, account_ID);

            ResultSet currencyResult = currencyState.executeQuery();

            if (currencyResult.next()) {
                currency = new Currency();
                currency.setCurrencyId(currencyResult.getString("currency_ID"));
                currency.setCurrencyName(currencyResult.getString("currency_name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return currency;
    }

    protected List<Transaction> retrieveTransactionByAccountID(String account_ID) {
        List<Transaction> transactions = new ArrayList<>();

        String transactionQuery = "SELECT * FROM bank_app_database.account " +
                "JOIN bank_app_database.transaction " +
                "ON account_ID = payment_ID OR account_ID = payment_receiver_ID WHERE account_ID = ?";

        try (Connection connectDatabase = DriverManager.getConnection(url, username, password)) {
            PreparedStatement transactionState = connectDatabase.prepareStatement(transactionQuery);

            transactionState.setString(1,account_ID);

            ResultSet transactionResult = transactionState.executeQuery();
            while (transactionResult.next()) {
                Transaction transaction = new Transaction();
                transaction.setTransactionId(transactionResult.getInt("transaction_ID"));
                transaction.setPayment_ID(transactionResult.getString("payment_ID"));
                transaction.setPayment_receiver_ID(transactionResult.getString("payment_receiver_ID"));
                transaction.setTransactionAmount(transactionResult.getDouble("transaction_amount"));
                transaction.setTransferDate(transactionResult.getDate("transfer_date"));
                transactions.add(transaction);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return transactions;
    }
}
