package main.java.travel_20190319.storage.loadinitialdata;


public interface ImportDataFromFile<EXTRACTED_DATA> {
    EXTRACTED_DATA getDataFromFile(String filePath) throws Exception;
}
