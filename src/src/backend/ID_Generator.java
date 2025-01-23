package src.backend;

import java.sql.*;
import java.util.Random;

public class ID_Generator {
    private Random random = new Random();
    private static int profile_ID = 1;

    public String generate_user_ID() {
        String user_ID;
        int ID_Number = random.nextInt((19999 - 10000) + 1) + 10000;
        return user_ID = String.format("UID%d",ID_Number);
    }

    public String generate_account_ID() {
        String account_ID;
        int ID_Number = random.nextInt((19999 - 10000) + 1) + 10000;
        return account_ID = String.format("AID%d",ID_Number);
    }

    public int generate_transaction_ID() {
        return random.nextInt((19999 - 10000) + 1) + 10000;
    }

    public int generate_loan_ID() {
        return random.nextInt((29999 - 20000) + 1) + 20000;
    }

    public int generate_profile_ID() {
        return + 1;
    }

    public boolean checkUniqueUserID(String user_ID, Connection connection) throws SQLException {
        String query = "SELECT EXISTS (SELECT * FROM bank_app_database.user WHERE user_ID = ?)";

        try (PreparedStatement checkStatement = connection.prepareStatement(query)) {
            checkStatement.setString(1, user_ID);
            ResultSet resultSet = checkStatement.executeQuery();

            if(resultSet.next()) {
                return resultSet.getBoolean(1);
            }
            return false;
        }
    }

    public boolean checkUniqueProfileID(int profile_ID, Connection connection) throws SQLException {
        String query = "SELECT EXISTS (SELECT * FROM bank_app_database.profile WHERE profile_ID = ?)";

        try (PreparedStatement checkStatement = connection.prepareStatement(query)) {
            checkStatement.setInt(1, profile_ID);
            ResultSet resultSet = checkStatement.executeQuery();

            if(resultSet.next()) {
                return resultSet.getBoolean(1);
            }
            return false;
        }
    }

    public boolean checkUniqueAccountID(String account_ID, Connection connection) throws SQLException {
        String query = "SELECT EXISTS (SELECT * FROM bank_app_database.account WHERE account_ID = ?)";

        try (PreparedStatement checkStatement = connection.prepareStatement(query)) {
            checkStatement.setString(1, account_ID);
            ResultSet resultSet = checkStatement.executeQuery();

            if(resultSet.next()) {
                return resultSet.getBoolean(1);
            }
            return false;
        }
    }
}
