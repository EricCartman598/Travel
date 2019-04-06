package travel_20190406.storage.loadinitialdata.impl;

import travel_20190406.country.domain.BaseCountry;
import travel_20190406.storage.loadinitialdata.ImportDataFromFile;

import java.util.ArrayList;
import java.util.List;

public class ThreadInitData<T> implements Runnable {

    private String filePath;
    private T countriesList;// = new ArrayList<>();
    private Thread thread;
    private ImportDataFromFile<T> importer;

    public ThreadInitData(String filePath, ImportDataFromFile importer) {
        this.filePath = filePath;
        this.importer = importer;
        this.thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        try {
            countriesList = importer.getDataFromFile(filePath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public T getCountriesList() {
        return countriesList;
    }

    public Thread getThread() {
        return thread;
    }
}
