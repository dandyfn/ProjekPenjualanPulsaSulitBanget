package com.partials;
import javax.swing.JTable;

public class cTable extends JTable {

  public cTable(javax.swing.table.TableModel dm)
  {
    super(dm);
    setFont( cFont.fontteksisi );
    getTableHeader().setFont(cFont.fonttabeljudul);
    getTableHeader().setBackground( cColor.BLUE );
    getTableHeader().setForeground( cColor.WHITE );
    getTableHeader().setBorder(null);
    setBorder(null);
    setRowHeight(30);
    getTableHeader().setReorderingAllowed(false);
    setShowVerticalLines(false);
    setShowHorizontalLines(false);
    setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
    setDragEnabled(true);
    setSelectionBackground(cColor.RED);
    setSelectionForeground(cColor.WHITE);
  }

  @Override
  public boolean isCellEditable(int row, int column){
    return false;
  }
  
}