package Travel_20190315.Reporting;

import Travel_20190315.Order.Domain.Order;

import java.io.FileNotFoundException;

public interface ExportData {
    void exportFile(String filePath, Order order) throws FileNotFoundException;
}
