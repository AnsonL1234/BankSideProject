package src.backend.dataType;

import java.util.Random;

public class Currency {
    private String currencyId;
    private String currencyName;
    private double exchangeRate;
    private Currency_Exchange_Rate exchangeRateDetails; // One to One with Currency_Exchange_Rate
    Random random = new Random();

    public Currency() {
        this.currencyId = generateID();
        this.currencyName = "";
        this.exchangeRate = 0.0;
        this.exchangeRateDetails = null;
    }

    public Currency(String currencyId, String currencyName, double exchangeRate, Currency_Exchange_Rate exchangeRateDetails) {
        this.currencyId = currencyId;
        this.currencyName = currencyName;
        this.exchangeRate = exchangeRate;
        this.exchangeRateDetails = exchangeRateDetails;
    }

    private String generateID() {
        int randomNumber = random.nextInt(1000);
        return String.format("C%03d", randomNumber);
    }

    public String getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(String currencyId) {
        this.currencyId = currencyId;
    }

    public String getCurrencyName() {
        return currencyName;
    }

    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }

    public double getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(double exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    public Currency_Exchange_Rate getExchangeRateDetails() {
        return exchangeRateDetails;
    }

    public void setExchangeRateDetails(Currency_Exchange_Rate exchangeRateDetails) {
        this.exchangeRateDetails = exchangeRateDetails;
    }

    @Override
    public String toString() {
        return "Currency [currencyId=" + currencyId + ", currencyName=" + currencyName + ", exchangeRate="
                + exchangeRate + ", exchangeRateDetails=" + exchangeRateDetails + "]";
    }
}
