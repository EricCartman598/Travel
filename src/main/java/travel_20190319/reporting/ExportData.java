package main.java.travel_20190319.reporting;

import main.java.travel_20190319.order.domain.Order;

import java.io.FileNotFoundException;

public interface ExportData {
    void exportFile(String filePath, Order order) throws FileNotFoundException;
}
