package main.java.travel_20190322.reporting;

import main.java.travel_20190322.order.domain.Order;

import java.io.FileNotFoundException;

public interface ExportData {
    void exportFile(String filePath, Order order) throws FileNotFoundException;
}
