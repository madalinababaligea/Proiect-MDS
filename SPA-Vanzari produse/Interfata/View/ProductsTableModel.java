package spa.View;

import javax.swing.table.DefaultTableModel;


public class ProductsTableModel extends DefaultTableModel {

    public ProductsTableModel(int tableData, int colNames) {
        super(tableData, colNames);
    }

    public boolean isCellEditable(int row, int column) {
        if(column >= 5)
            return true;
        return false;
    }
}
