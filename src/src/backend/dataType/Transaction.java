package src.backend.dataType;

import java.util.Date;
import java.util.Random;

public class Transaction {
    private int transactionId;
    private Account account; // Many to One with Account
    private double transactionAmount;
    private Date transferDate;
    Random random = new Random();

    public Transaction() {
        this.transactionId = generateID();
        this.account = null;
        this.transactionAmount = 0.0;
        this.transferDate = null;
    }

    public Transaction(int transactionId, Account account, double transactionAmount, Date transferDate) {
        this.transactionId = transactionId;
        this.account = account;
        this.transactionAmount = transactionAmount;
        this.transferDate = transferDate;
    }
    private int generateID() {
        int randomNumber = random.nextInt(1000);
        return randomNumber;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public double getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(double transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public Date getTransferDate() {
        return transferDate;
    }

    public void setTransferDate(Date transferDate) {
        this.transferDate = transferDate;
    }

    @Override
    public String toString() {
        return "Transaction [transactionId=" + transactionId + ", account=" + account + ", transactionAmount="
                + transactionAmount + ", transferDate=" + transferDate + "]";
    }
}
