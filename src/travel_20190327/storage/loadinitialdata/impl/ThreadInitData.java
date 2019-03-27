package travel_20190327.storage.loadinitialdata.impl;

import travel_20190327.country.domain.BaseCountry;

import java.util.ArrayList;
import java.util.List;

public class ThreadInitData extends InitMemoryListCountryStorageFromXmlJAXB implements Runnable {

    private String filePath;
    private List<BaseCountry> countriesList = new ArrayList<>();
    private Thread thread;

    public ThreadInitData(String filePath) {
        this.filePath = filePath;
        this.thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        try {
            countriesList = getDataFromFile(filePath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<BaseCountry> getCountriesList() {
        return countriesList;
    }

    public Thread getThread() {
        return thread;
    }
}
