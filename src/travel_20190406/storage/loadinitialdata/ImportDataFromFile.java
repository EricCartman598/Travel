package travel_20190406.storage.loadinitialdata;


public interface ImportDataFromFile<EXTRACTED_DATA> {
    EXTRACTED_DATA getDataFromFile(String filePath) throws Exception;
}
