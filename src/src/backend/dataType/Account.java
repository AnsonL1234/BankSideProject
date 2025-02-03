package src.backend.dataType;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Account {

    private String accountId;
    private String typeOfAccount;
    private double currentBalance;
    private double availableBalance;
    private Currency currency; // One to One with Currency
    private List<Transaction> transactions; // One to Many with Transaction

    public Account() {
        this.accountId = "";
        this.typeOfAccount = "";
        this.currentBalance = 0.0;
        this.availableBalance = 0.0;
        this.transactions = new ArrayList<>();
    }

    public Account(String accountId, String typeOfAccount, double currentBalance, double availableBalance, Currency currency) {
        this.accountId = accountId;
        this.typeOfAccount = typeOfAccount;
        this.currentBalance = currentBalance;
        this.availableBalance = availableBalance;
        this.currency = currency;
    }

    public Account(String accountId, String typeOfAccount, double currentBalance, double availableBalance, Currency currency, Transaction transaction) {
        this.accountId = accountId;
        this.typeOfAccount = typeOfAccount;
        this.currentBalance = currentBalance;
        this.availableBalance = availableBalance;
        this.currency = currency;
        this.transactions = new ArrayList<>();
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getTypeOfAccount() {
        return typeOfAccount;
    }

    public void setTypeOfAccount(String typeOfAccount) {
        this.typeOfAccount = typeOfAccount;
    }

    public double getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(double currentBalance) {
        this.currentBalance = currentBalance;
    }

    public double getAvailableBalance() {
        return availableBalance;
    }

    public void setAvailableBalance(double availableBalance) {
        this.availableBalance = availableBalance;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    @Override
    public String toString() {
        return "Account [accountId=" + accountId + ", typeOfAccount=" + typeOfAccount + ", currentBalance="
                + currentBalance + ", availableBalance=" + availableBalance + ", currency=" + currency
                + ", transactions=" + transactions + "]";
    }
}
