package travel_20190327.storage.loadinitialdata.impl;

import travel_20190327.country.domain.BaseCountry;

import java.util.*;

public class MultiThreadReader {

    public List<BaseCountry> getDataFromFiles(String... files) {

        List<BaseCountry> dataFromFiles = new ArrayList<>();
        List<ThreadInitData> readThreadsList = new ArrayList<>();

       /* for (int i = 0; i < files.length; i++) {
            readThreadsList.add(new ThreadInitData(files[i]));
        }*/

        for (int i = 0; i < readThreadsList.size(); i++) {
            try {
                readThreadsList.get(i).getThread().join();
                dataFromFiles.addAll(readThreadsList.get(i).getCountriesList());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        return dataFromFiles;
    }
}
