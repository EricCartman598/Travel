package travel_20190326.storage.loadinitialdata.impl;

import travel_20190326.country.domain.BaseCountry;

import java.util.*;

public class MultiThreadReader {

    public HashMap<Integer, List<BaseCountry>> getDataFromFiles(String... files) {

        HashMap<Integer, List<BaseCountry>> dataFromFiles = new HashMap<>();
        List<ThreadInitData> readerList = new ArrayList<>();
        List<Thread> threadInitData = new ArrayList<>();

        for (int i = 0; i < files.length; i++) {
            readerList.add(new ThreadInitData(files[i]));
            threadInitData.add(new Thread(readerList.get(i)));
            threadInitData.get(i).start();
        }

        for (int i = 0; i < threadInitData.size(); i++) {
            try {
                threadInitData.get(i).join();
                dataFromFiles.put(i, readerList.get(i).getCountriesList());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        Iterator iter = dataFromFiles.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry pair = (Map.Entry)iter.next();
            List<BaseCountry> importedCountries = (List<BaseCountry>)pair.getValue();
            for(BaseCountry country : importedCountries) {
                System.out.println(country.getDiscriminator());
                System.out.println(country.getName());
                System.out.println(country.getLanguage());
            }
        }

        return dataFromFiles;
    }
}
