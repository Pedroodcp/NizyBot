package br.com.pedrodcp.nizybot.statements;

import br.com.pedrodcp.nizybot.NizyBot;
import br.com.pedrodcp.nizybot.models.Account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Statements {

    public static Connection connection;

    private static void openConnection() {
        Statements.connection = NizyBot.connectionModel.getConnection();
    }

    public static void initialize() {
        try {
            openConnection();
                PreparedStatement st = connection.prepareStatement("CREATE TABLE IF NOT EXISTS sprucepluginsbot_usersinfo (userId varchar(24), pluginsNumber text)");
            st.executeUpdate();
            st.close();
            loadAccounts();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void loadAccounts() {
        try {
            PreparedStatement st = connection.prepareStatement("SELECT * FROM sprucepluginsbot_usersinfo");
            ResultSet rs = st.executeQuery();
            while (rs.next()) Account.accounts.add(new Account(rs.getString("userId"), rs.getInt("pluginsNumber")));
            rs.close();
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static boolean exists(String playerName) {
        boolean exists = false;
        try {
            PreparedStatement st = connection.prepareStatement("SELECT userId FROM sprucepluginsbot_usersinfo WHERE userId=?");
            st.setString(1, playerName);
            ResultSet rs = st.executeQuery();
            exists = rs.next();
            rs.close();
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return exists;
    }

    public static void saveAccounts() {
        try {
            openConnection();
            PreparedStatement existsStatement = connection.prepareStatement("UPDATE sprucepluginsbot_usersinfo SET pluginsNumber=? WHERE userId=?");
            PreparedStatement st = connection.prepareStatement("INSERT INTO sprucepluginsbot_usersinfo (userId, pluginsNumber) VALUES (?, ?)");
            for (Account account : Account.accounts) {
                if (exists(account.getUserId())) {
                    existsStatement.setInt(1, account.getPluginsNumber());
                    existsStatement.setString(2, account.getUserId());
                    existsStatement.executeUpdate();
                } else {
                    st.setString(1, account.getUserId());
                    st.setInt(2, account.getPluginsNumber());
                    st.executeUpdate();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
