package src.backend.dataType;

import java.util.Random;

public class Currency {
    private String currencyId;
    private String currencyName; // One to One with Currency_Exchange_Rate

    public Currency() {
        this.currencyId = "";
        this.currencyName = "";
    }

    public Currency(String currencyId, String currencyName) {
        this.currencyId = currencyId;
        this.currencyName = currencyName;
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

    @Override
    public String toString() {
        return "Currency [currencyId=" + currencyId + ", currencyName=" + currencyName + "]";
    }
}
