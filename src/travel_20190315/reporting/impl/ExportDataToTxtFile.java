package travel_20190315.reporting.impl;

import travel_20190315.city.domain.City;
import travel_20190315.country.domain.BaseCountry;
import travel_20190315.order.domain.Order;
import travel_20190315.reporting.ExportData;
import travel_20190315.reporting.ReportStrings;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class ExportDataToTxtFile implements ExportData {
    @Override
    public void exportFile(String filePath, Order order) throws FileNotFoundException {

        try (PrintWriter printWriter = new PrintWriter(filePath)) {

            StringBuilder stringToWrite = prepareDataToWrite(order);
            printWriter.println(stringToWrite);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw e;
        }
    }

    private StringBuilder prepareDataToWrite(Order order) {
        StringBuilder dataToWrite = new StringBuilder();

        // Report chapter
        dataToWrite.append(ReportStrings.REPORT_CHAPTER + "\r\n");

        // user's personal info
        dataToWrite.append(ReportStrings.USER_NAME).append(order.getUser().getFirstName()).append("\r\n");
        dataToWrite.append(ReportStrings.USER_LAST_NAME).append(order.getUser().getLastName()).append("\r\n");
        dataToWrite.append(ReportStrings.USER_PHONE_NUMBER).append(order.getUser().getPhoneNumber()).append("\r\n");

        // order info
        for (BaseCountry country : order.getCountries()) {
            dataToWrite.append(ReportStrings.ORDERED_COUNTRY).append(country.getName()).append("\r\n");
            int cityNum = 1;
            for (City city : country.getCities()) {
                dataToWrite.append(String.valueOf(cityNum)).append(". ").append(ReportStrings.ORDERED_CITY).append(city.getName()).append("\r\n");
                cityNum++;
            }
        }

        // order price
        dataToWrite.append(ReportStrings.ORDER_PRICE).append(order.getPrice()).append("\r\n");

        return dataToWrite;
    }
}
