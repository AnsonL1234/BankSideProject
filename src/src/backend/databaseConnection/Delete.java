package src.backend.databaseConnection;

import java.sql.*;

public class Delete extends DatabaseConnection{

    /** This is the method for delete the user and profile when user wish to delete */
    protected void deleteUserAndProfile(String user_ID, String first_name, String last_name) {

        String deleteUserQuery = "DELETE FROM bank_app_database.user JOIN bank_app_database.profile ON user.profile_ID = profile.profile_ID WHERE user_ID = ? AND first_name = ? AND last_name = ?";

        Connection databaseConnection = null;

        try {
            databaseConnection = DriverManager.getConnection(url,username,password);
            databaseConnection.setAutoCommit(false);

            try(PreparedStatement deleteQuery = databaseConnection.prepareStatement(deleteUserQuery)) {
                deleteQuery.setString(1, user_ID);
                deleteQuery.setString(1, first_name);
                deleteQuery.setString(1, last_name);
                deleteQuery.executeUpdate();
            }

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

    /** This is the method for delete the account when user wish to delete */
    protected void deleteAccount(String account_ID) {

        String deleteAccountQuery = "DELETE FROM bank_app_database.account WHERE account_ID = ?";

        Connection databaseConnection = null;

        try {
            databaseConnection = DriverManager.getConnection(url,username,password);
            databaseConnection.setAutoCommit(false);

            try(PreparedStatement deleteQuery = databaseConnection.prepareStatement(deleteAccountQuery)) {
                deleteQuery.setString(1, account_ID);
                deleteQuery.executeUpdate();
            }

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
