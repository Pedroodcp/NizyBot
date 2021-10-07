package br.com.pedrodcp.nizybot.models;

import java.util.ArrayList;

public class Account {

    public static ArrayList<Account> accounts = new ArrayList<>();

    private String userId;
    private int pluginsNumber;

    public Account(String userId, int pluginsNumber) {
        this.userId = userId;
        this.pluginsNumber = pluginsNumber;
    }

    public String getUserId() {
        return userId;
    }

    public int getPluginsNumber() {
        return pluginsNumber;
    }

    public void setPluginsNumber(int pluginsNumber) {
        this.pluginsNumber = pluginsNumber;
    }
}
