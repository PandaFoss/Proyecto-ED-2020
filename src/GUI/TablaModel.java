/**
 * Provee clases relativas a la creación de la interfaz gráfica
 */
package GUI;

import javax.swing.table.DefaultTableModel;

/**
 * Implementa la interfaz DefaultTableModel y la modela siguiendo la estructura
 * de monto-descripción
 * @author Skorrom - Max Ferrer [Panda Foss]
 */
final class TablaModel extends DefaultTableModel{
	private Class[] types;
    private boolean[] canEdit;
      
    /**
     * Crea una TablaModel con columnas "Monto" y "Descripción"
     */
    TablaModel(){
        super(new String[][] {}, new String[]{"Monto", "Descripción"});
        types = new Class[] {java.lang.Float.class,   java.lang.String.class};
        canEdit = new boolean[] { false, false};
    }               
      
    @Override
	public Class<?> getColumnClass(int columnIndex){
		return types[columnIndex];
	}
    
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex){
		return canEdit[columnIndex];
	}
 }
