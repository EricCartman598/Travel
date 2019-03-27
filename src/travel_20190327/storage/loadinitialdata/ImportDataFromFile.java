package travel_20190327.storage.loadinitialdata;


public interface ImportDataFromFile<EXTRACTED_DATA> {
    EXTRACTED_DATA getDataFromFile(String filePath) throws Exception;
}
