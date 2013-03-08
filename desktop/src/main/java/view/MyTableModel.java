package view;

import javax.swing.table.DefaultTableModel;

/**
 * Created with IntelliJ IDEA.
 * User: Bernhard
 * Date: 07.03.13
 * Time: 23:21
 * To change this template use File | Settings | File Templates.
 */
public class MyTableModel extends DefaultTableModel{

    public MyTableModel(Object[] columnnames, int rowcount) {
        super(columnnames,rowcount);
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        if(column==0) return false;
        else return true;
    }
}
