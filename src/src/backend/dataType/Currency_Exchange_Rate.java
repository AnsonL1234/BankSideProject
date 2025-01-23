package src.backend.dataType;

import java.util.Random;

public class Currency_Exchange_Rate {
    private int exchangeId;
    private String baseCurrencyId;
    private String targetCurrencyId;
    private double exchangeRate;

    public Currency_Exchange_Rate() {
        this.exchangeId = 0;
        this.baseCurrencyId = "";
        this.targetCurrencyId = "";
        this.exchangeRate = 0.0;
    }

    public Currency_Exchange_Rate(int exchangeId, String baseCurrencyId, String targetCurrencyId, double exchangeRate) {
        this.exchangeId = exchangeId;
        this.baseCurrencyId = baseCurrencyId;
        this.targetCurrencyId = targetCurrencyId;
        this.exchangeRate = exchangeRate;
    }

    public int getExchangeId() {
        return exchangeId;
    }

    public void setExchangeId(int exchangeId) {
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
}
