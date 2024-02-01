package at.campus02.swe.logic;

import java.util.HashMap;

public class CalcStore {
    private double storedValue;
    private HashMap<String, Double> storeHM = new HashMap<>();

    public double getStoredValue() {
        return storedValue;
    }

    public void setStoredValue(double storedValue) {
        this.storedValue = storedValue;
    }
    public double getStoredValue(String key) {
        return storeHM.get(key);
    }

    public void setStoredValue(String key, double v) {
        storeHM.put(key,v);
    }


}
