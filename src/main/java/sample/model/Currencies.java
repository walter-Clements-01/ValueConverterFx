package sample.model;

import java.util.Map;

public class Currencies {
    private boolean success;
    public long timestamp;
    private String base;
    private String date;
    private Map<String, Double> rates;
    private Map<String, Double> ratesNames; //TODO

    public boolean isSuccess() {
        return success;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public String getBase() {
        return base;
    }

    public String getDate() {
        return date;
    }

    public Map<String, Double> getRates() {
        return rates;
    }

    public Map<String, Double> getRatesNames() {
        return ratesNames;
    }

    public void setRatesNames(Map<String, Double> names) {
        ratesNames=names;
    }
}
