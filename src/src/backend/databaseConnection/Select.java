package src.backend.databaseConnection;

import src.backend.dataType.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Select extends DatabaseConnection {

    //private instance variable
    private Connection connectDatabase = null;


    public User retrieveInfoByLogin(String emailOrUserID, String user_password) {

        //reference variable for user
        User user = null;

        //Query Setting
        String userQuery = "SELECT * FROM bank_app_database.user WHERE (email_address = ? OR user_ID = ?) AND user_password = ?";

        try {
            connectDatabase = getConnect();
            PreparedStatement statement = connectDatabase.prepareStatement(userQuery);

            //Find the info query
            statement.setString(1, emailOrUserID);
            statement.setString(2, emailOrUserID);
            statement.setString(3, user_password);

            ResultSet queryExecute = statement.executeQuery();
//            System.out.println("User List: ");
            if (queryExecute.next()) {
//                isUserExists = true;
                user = new User();
                user.setUserID(queryExecute.getString("user_ID"));
                user.setPassword(queryExecute.getString("user_password"));
                user.setEmailAddress(queryExecute.getString("email_address"));

                //debug
                System.out.println("User Info; \n" + user.getUserID() + "Email: " + user.getEmailAddress() + "\nPassword" + user.getPassword());

                int profile_ID = queryExecute.getInt("profile_ID");
                Profile profile = retrieveDataByProfileID(profile_ID);
                user.setProfile(profile);

                List<Account> accountList = retrieveAccountByUserID(user.getUserID());
                user.setAccounts(accountList);
//                userList.add(user);
//                System.out.println(userList);
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

//        return isUserExists;
        return null;
    }

    protected Profile retrieveDataByProfileID(int profile_ID) {
        List<Profile> profileList = new ArrayList<>();;
        Profile profile = null;
        String profileQuery = "SELECT * FROM bank_app_database.profile WHERE profile_ID = ?";

        try  {
            connectDatabase = getConnect();
            PreparedStatement profileState = connectDatabase.prepareStatement(profileQuery);

            profileState.setInt(1, profile_ID);

            ResultSet profileResult = profileState.executeQuery();
            System.out.println("\nProfile List :");
            if (profileResult.next()) {
                profile = new Profile();

                profile.setProfileId(profileResult.getInt("profile_ID"));
                profile.setAvatar_Path(profileResult.getString("avatar_path"));
                profile.setFirstName(profileResult.getString("first_name"));
                profile.setLastName(profileResult.getString("last_name"));
                profile.setDateOfBirth(profileResult.getDate("date_of_birth"));
                profile.setPhoneNumber(profileResult.getInt("phone_number"));
                profile.setSpecificAddress(profileResult.getString("address"));

                profileList.add(profile);
                System.out.println(profileList);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return profile;
    }

    protected List<Account> retrieveAccountByUserID(String user_ID) {
        List<Account> accountList = new ArrayList<>();
        String accountQuery = "SELECT * FROM bank_app_database.account JOIN bank_app_database.user ON account.account_ID = user.account_ID WHERE user_ID = ?";

        try {
            connectDatabase = getConnect();
            PreparedStatement accountState = connectDatabase.prepareStatement(accountQuery);

            accountState.setString(1, user_ID);

            ResultSet accountResult = accountState.executeQuery();

            while (accountResult.next()) {
                Account account = new Account();
                account.setAccountId(accountResult.getString("account_ID"));
                account.setTypeOfAccount(accountResult.getString("type_of_account"));
                account.setCurrentBalance(accountResult.getDouble("currency_balance"));
                account.setAvailableBalance(accountResult.getDouble("available_balance"));

                //debug
                System.out.println("\nAccount Detail; " + "\nAccount ID: " + account.getAccountId() + "\nAccount Type: " + account.getTypeOfAccount() + "\nCurrent Balance: " + account.getCurrentBalance() + "\nAvailable Balance: " + account.getAvailableBalance());

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
        List<Currency> currencyList = new ArrayList<>();

        Currency currency = null;

        String currencyQuery = "SELECT * FROM bank_app_database.currency JOIN bank_app_database.account ON currency.currency_ID = account.currency_ID WHERE account_ID = ?";

        try {
            connectDatabase = getConnect();
            PreparedStatement currencyState = connectDatabase.prepareStatement(currencyQuery);

            currencyState.setString(1, account_ID);

            ResultSet currencyResult = currencyState.executeQuery();
            System.out.println("\nCurrency List :");
            if (currencyResult.next()) {
                currency = new Currency();
                currency.setCurrencyId(currencyResult.getString("currency_ID"));
                currency.setCurrencyName(currencyResult.getString("currency_name"));
                currencyList.add(currency);
                System.out.println(currencyList);
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

        try {
            connectDatabase = getConnect();
            PreparedStatement transactionState = connectDatabase.prepareStatement(transactionQuery);

            transactionState.setString(1,account_ID);

            ResultSet transactionResult = transactionState.executeQuery();
            System.out.println("\nTransaction List :");
            while (transactionResult.next()) {
                Transaction transaction = new Transaction();
                transaction.setTransactionId(transactionResult.getInt("transaction_ID"));
                transaction.setPayment_ID(transactionResult.getString("payment_ID"));
                transaction.setPayment_receiver_ID(transactionResult.getString("payment_receiver_ID"));
                transaction.setTransactionAmount(transactionResult.getDouble("transaction_amount"));
                transaction.setTransferDate(transactionResult.getDate("transfer_date"));
                transactions.add(transaction);
                System.out.println(transactions);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return transactions;
    }
}
