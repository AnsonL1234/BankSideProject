package src.backend.dataType;

import java.util.Date;
import java.util.Random;

public class Loan {
    private int loanId;
    private double loanAmount;
    private Date startDate;
    private Date endDate;
    Random random = new Random();

    public Loan() {
        this.loanId = generateID();
        this.loanAmount = 0.0;
        this.startDate = null;
        this.endDate = null;
    }

    public Loan(int loanId, double loanAmount, Date startDate, Date endDate) {
        this.loanId = loanId;
        this.loanAmount = loanAmount;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    private int generateID() {
        int randomNumber = random.nextInt(2000);
        return randomNumber;
    }

    public int getLoanId() {
        return loanId;
    }

    public void setLoanId(int loanId) {
        this.loanId = loanId;
    }

    public double getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(double loanAmount) {
        this.loanAmount = loanAmount;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "Loan [loanId=" + loanId + ", loanAmount=" + loanAmount + ", startDate=" + startDate + ", endDate=" + endDate + "]";
    }
}
