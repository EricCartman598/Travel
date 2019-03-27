package main.java.travel_20190315.reporting;

import main.java.travel_20190315.order.domain.Order;

import java.io.FileNotFoundException;

public interface ExportData {
    void exportFile(String filePath, Order order) throws FileNotFoundException;
}
