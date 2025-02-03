package src.backend;

import src.backend.dataType.Account;
import src.backend.dataType.Profile;
import src.backend.dataType.User;
import src.backend.dataType.Currency;
import src.backend.databaseConnection.DatabaseConnection;
import src.backend.databaseConnection.Insert;
import src.backend.databaseConnection.Select;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ManagementSystem {

    private List<User> usersList = null;

    /** Insert the new info to the array list added to the database */
    public void usersRegistration(
            String user_ID, String user_password, String email_address,
            int profile_ID, String avatar_path, String first_name, String last_name, Date date_of_birth, int phone_number, String address,
            String account_ID, String type_of_account, double current_balance, double available_balance, String currency_ID, String currency_name
    ) {
        Insert newAccountCreate = new Insert();
        ID_Generator idGenerator = new ID_Generator();
        usersList = new ArrayList<>();

        //check if the ID is unique, if not re-generate the ID
        try {
            Connection connection = DatabaseConnection.getConnect();
            boolean isUserIDUnique = checkIsUserIDUnique(user_ID,connection,idGenerator),
                    isProfileIDUnique = checkIsProfileIDUnique(profile_ID,connection,idGenerator),
                    isAccountIDUnique = checkIsAccountIDUnique(account_ID,connection,idGenerator);

            while (isUserIDUnique || isProfileIDUnique || isAccountIDUnique) {
                if (isUserIDUnique) {
                    System.out.println("The user id is not unique, omw to re-generate");
                    user_ID = idGenerator.generate_user_ID();
                    isUserIDUnique = false;
                } else if (isProfileIDUnique) {
                    profile_ID = idGenerator.generate_profile_ID();
                    isProfileIDUnique = false;
                } else {
                    account_ID = idGenerator.generate_account_ID();
                    isAccountIDUnique = false;
                }
            }

        } catch (SQLException e) {
            System.out.println("Duplicate Data Found!");
        }

        //added to the user-define class and array list
        Currency currency = new Currency(currency_ID,currency_name);
        Account account = new Account(account_ID,type_of_account,current_balance,available_balance, currency);
        Profile profile = new Profile(profile_ID, avatar_path, first_name, last_name, date_of_birth, phone_number, address);
        usersList.add(new User(user_ID,user_password,email_address,profile,account));

        //after user fill up the info, insert to the database connection class
        newAccountCreate.userRegistration(
                user_ID,user_password,email_address,
                profile_ID,avatar_path,first_name,last_name, date_of_birth, phone_number, address,
                account_ID,type_of_account,current_balance, available_balance,currency_ID,currency_name
        );
    }

    private boolean checkIsUserIDUnique(String user_ID, Connection connection, ID_Generator idGenerator) {
        try {
            //check is the profile id unique
            if (idGenerator.checkUniqueUserID(user_ID, connection)) {
                //return true, if exists
                return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        //otherwise, return false
        return false;
    }

    private boolean checkIsProfileIDUnique(int profile_ID, Connection connection, ID_Generator idGenerator) {
        try {
            //check is the user id unique
            if (idGenerator.checkUniqueProfileID(profile_ID, connection)) {
                //return true, if exists
                return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        //otherwise, return false
        return false;
    }

    private boolean checkIsAccountIDUnique(String account_ID, Connection connection, ID_Generator idGenerator) {
        try {
            //check is the account id unique
            if (idGenerator.checkUniqueAccountID(account_ID, connection)) {
                //return true, if exists
                return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        //otherwise, return false
        return false;
    }

    public List<User> usersLogin(String userIDOrEmail, String password) {
        usersList = new ArrayList<>();
        Select retrieveDataByLogin = new Select();

        //reference variable
        User user = retrieveDataByLogin.retrieveInfoByLogin(userIDOrEmail,password);

        //add to the arrayList
        usersList.add(user);

        //return the value
        return usersList;
    }
}
