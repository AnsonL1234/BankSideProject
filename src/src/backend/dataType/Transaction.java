package src.backend.dataType;

import java.util.Date;
import java.util.Random;

public class Transaction {
    private int transactionId;
    private String payment_ID;
    private String payment_receiver_ID;
    private double transactionAmount;
    private Date transferDate;

    public Transaction() {
        this.transactionId = 0;
        this.payment_ID = "";
        this.payment_receiver_ID = "";
        this.transactionAmount = 0.00;
        this.transferDate = null;

    }

    public Transaction(int transactionId, String payment_ID, String payment_receiver_ID, Date transferDate, double transactionAmount) {
        this.transactionId = transactionId;
        this.payment_ID = payment_ID;
        this.payment_receiver_ID = payment_receiver_ID;
        this.transferDate = transferDate;
        this.transactionAmount = transactionAmount;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public String getPayment_ID() {
        return payment_ID;
    }

    public String getPayment_receiver_ID() {
        return payment_receiver_ID;
    }

    public double getTransactionAmount() {
        return transactionAmount;
    }

    public Date getTransferDate() {
        return transferDate;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public void setPayment_ID(String payment_ID) {
        this.payment_ID = payment_ID;
    }

    public void setPayment_receiver_ID(String payment_receiver_ID) {
        this.payment_receiver_ID = payment_receiver_ID;
    }

    public void setTransactionAmount(double transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public void setTransferDate(Date transferDate) {
        this.transferDate = transferDate;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "transactionId=" + transactionId +
                ", payment_ID='" + payment_ID + '\'' +
                ", payment_receiver_ID='" + payment_receiver_ID + '\'' +
                ", transactionAmount=" + transactionAmount +
                ", transferDate=" + transferDate +
                '}';
    }
}
