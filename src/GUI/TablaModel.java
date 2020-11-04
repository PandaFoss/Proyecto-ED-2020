package GUI;

import javax.swing.table.DefaultTableModel;

final class TablaModel extends DefaultTableModel{
    private Class[] types;
      private boolean[] canEdit;
      
      TablaModel(){
        super(new String[][] {},
            new String[]{"Monto", "Descripción"});
        types = new Class[] {java.lang.Float.class,
                             java.lang.String.class
                             };
        canEdit= new boolean[] { false, false};
      };               
                   
      public Class getColumnClass(int columnIndex){
         return types[columnIndex];
      }
      
      public boolean isCellEditable(int rowIndex, int columnIndex){
         return canEdit[columnIndex];
      }                                     
 };
