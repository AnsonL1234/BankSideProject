package src.backend.dataType;

import java.util.Random;

public class Currency_Exchange_Rate {
    private String exchangeId;
    private String baseCurrencyId;
    private String targetCurrencyId;
    private double exchangeRate;
    Random random = new Random();

    public Currency_Exchange_Rate() {
        this.exchangeId = generateID();
        this.baseCurrencyId = "";
        this.targetCurrencyId = "";
        this.exchangeRate = 0.0;
    }

    public Currency_Exchange_Rate(String exchangeId, String baseCurrencyId, String targetCurrencyId, double exchangeRate) {
        this.exchangeId = exchangeId;
        this.baseCurrencyId = baseCurrencyId;
        this.targetCurrencyId = targetCurrencyId;
        this.exchangeRate = exchangeRate;
    }

    private String generateID() {
        int randomNumber = random.nextInt(1000);
        return String.format("CER%03d", randomNumber);
    }

    public String getExchangeId() {
        return exchangeId;
    }

    public void setExchangeId(String exchangeId) {
        this.exchangeId = exchangeId;
    }

    public String getBaseCurrencyId() {
        return baseCurrencyId;
    }

    public void setBaseCurrencyId(String baseCurrencyId) {
        this.baseCurrencyId = baseCurrencyId;
    }

    public String getTargetCurrencyId() {
        return targetCurrencyId;
    }

    public void setTargetCurrencyId(String targetCurrencyId) {
        this.targetCurrencyId = targetCurrencyId;
    }

    public double getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(double exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    @Override
    public String toString() {
        return "Currency_Exchange_Rate [exchangeId=" + exchangeId + ", baseCurrencyId=" + baseCurrencyId + ", targetCurrencyId=" + targetCurrencyId + ", exchangeRate=" + exchangeRate + "]";
    }

    public static void main(String[] args) {

        Currency_Exchange_Rate account1 = new Currency_Exchange_Rate();
        Currency_Exchange_Rate account2 = new Currency_Exchange_Rate();
        Currency_Exchange_Rate account3 = new Currency_Exchange_Rate();

        System.out.println("Account 1 ID: " + account1.getExchangeId());
        System.out.println("Account 2 ID: " + account2.getExchangeId());
        System.out.println("Account 3 ID: " + account3.getExchangeId());
    }
}
