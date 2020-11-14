package GUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import Programa.CuentaBancaria;
import Programa.Transaccion;
import Programa.Programa;

/**
 * Implementa la clase GUI la cual modela la interfaz gráfica
 * @author Joaquin Garcia Diotto - Maximiliano Ferrer Gregori
 */
public class GUI extends JFrame{

	private static final long serialVersionUID = 1L;
	private JFrame frame;
	private JTable table;
	private JLabel lblSaldo;
	private DefaultTableModel tablaModel;
	private static CuentaBancaria miCuenta;
	private JRadioButton rdbtnTodas;
	private JRadioButton rdbtnMsHistrica;
	private JRadioButton rdbtnMsReciente;
	private JRadioButton rdbtnMsCostosa;
	private JRadioButton rdbtnNewRadioButton;
	private JButton btnNuevaTransaccin;
	

	/**
	 * Constructor de la clase GUI.
	 */
	public GUI() {
		miCuenta = new CuentaBancaria();
		initialize();
		frame.setVisible(true);
		String claveDeAcceso = JOptionPane.showInputDialog("Clave de acceso:");
		if(claveDeAcceso==null || !Programa.check_password(claveDeAcceso)){
			JOptionPane.showMessageDialog(null,"La clave de acceso tiene un formato incorrecto.","Error", JOptionPane.ERROR_MESSAGE);
			bloquearApp();
		}
	}
	

	/**
	 * Inicializa el contenido de la interfaz gráfica.
	 */
	private void initialize() {
		crearFrame();
		
		crearLabelHistorialDeTransacciones();
		
		crearLabelMostrar();
		
		crearPanelTabla();
		
		crearBotonesDeSeleccion();
		
		crearSaldo();
		
		crearBtnNuevaTransaccion();
	}
	/**
	 * Métodos que permiten crear e inicializar los componentes de la GUI
	 */
	
	/**
	 * Crea los Radio Buttons que aplican los filtros a la tabla
	 */
	private void crearBotonesDeSeleccion() {
		// Botones para seleccionar las operaciones
		rdbtnTodas = new JRadioButton("Todas");
		rdbtnTodas.setSelected(true);
		rdbtnTodas.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnTodas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnTodasListener();
			}
		});
		
		rdbtnMsHistrica = new JRadioButton("Más histórica");
		rdbtnMsHistrica.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnMsHistrica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnMsHistricaListener();
			}
		});
		
		rdbtnMsReciente = new JRadioButton("Más reciente");
		rdbtnMsReciente.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnMsReciente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnMsRecienteListener();
			}
		});
		
		rdbtnMsCostosa = new JRadioButton("Más costosa");
		rdbtnMsCostosa.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnMsCostosa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnMsCostosaListener();
			}
		});
		
		rdbtnNewRadioButton = new JRadioButton("Monto...");
		rdbtnNewRadioButton.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnNewRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnNewRadioButtonListener();
			}
		});
				
		// Agrupo botones
		ButtonGroup botones = new ButtonGroup();
		botones.add(rdbtnTodas);
		botones.add(rdbtnMsHistrica);
		botones.add(rdbtnMsReciente);
		botones.add(rdbtnMsCostosa);
		botones.add(rdbtnNewRadioButton);
		
		// Creo una VerticalBox para posicionar los botones verticalmente
		Box verticalBox = Box.createVerticalBox();
		verticalBox.add(rdbtnTodas);
		verticalBox.add(rdbtnMsHistrica);
		verticalBox.add(rdbtnMsReciente);
		verticalBox.add(rdbtnMsCostosa);
		verticalBox.add(rdbtnNewRadioButton);
		
		// Muestro los botones
		GridBagConstraints gbc_verticalBox = new GridBagConstraints();
		gbc_verticalBox.anchor = GridBagConstraints.NORTH;
		gbc_verticalBox.insets = new Insets(0, 0, 5, 0);
		gbc_verticalBox.gridx = 3;
		gbc_verticalBox.gridy = 1;
		frame.getContentPane().add(verticalBox, gbc_verticalBox);
	}
	
	/**
	 * Crea el panel que aloja a la tabla
	 */
	private void crearPanelTabla() {
		tablaModel = new TablaModel();
		table = new JTable();
		table.setModel(tablaModel);
		table.getTableHeader().setReorderingAllowed(false);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 1;
		frame.getContentPane().add(scrollPane, gbc_scrollPane);
		
		  // Alinear datos de la tabla
	      DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
	      centerRenderer.setHorizontalAlignment( JLabel.CENTER );
	      table.setDefaultRenderer(Float.class, centerRenderer);  
	      
	      DefaultTableCellRenderer leftRenderer = new DefaultTableCellRenderer();
	      leftRenderer.setHorizontalAlignment(JLabel.LEFT);
	      table.setDefaultRenderer(String.class, leftRenderer);  
	      
	      // Setear dimensiones
	      table.getColumnModel().getColumn(0).setPreferredWidth(30);
	      table.getColumnModel().getColumn(1).setPreferredWidth(300);
	}
	
	/**
	 * Añade una nueva fila en la tabla
	 * @param monto Monto de la transacción a ingresar en la tabla
	 * @param descripcion Descripción de la transacción a ingresar en la tabla
	 */
	private void agregarFila(Float monto, String descripcion) {
	    int fila = table.getRowCount();
	    
		// Crear fila en tabla (GUI)
	    ((DefaultTableModel) table.getModel()).setRowCount(fila+1); // Creo nueva fila
	    table.setValueAt(monto, fila, 0);
	    table.setValueAt(descripcion, fila, 1);
	}
	
	/**
	 * Vacía el contenido de la tabla
	 * @param tm TableModel referente a la tabla a limpiar
	 */
	private void limpiarTabla(DefaultTableModel tm) {
		tm.setRowCount(0);
	}
	
	/**
	 * Deshabilita los elementos interactivos de la aplicación
	 */
	private void bloquearApp() {
		rdbtnTodas.setEnabled(false);
		rdbtnMsCostosa.setEnabled(false);
		rdbtnMsHistrica.setEnabled(false);
		rdbtnMsReciente.setEnabled(false);
		rdbtnNewRadioButton.setEnabled(false);
		btnNuevaTransaccin.setEnabled(false);
	}
	
	/**
	 * Crea una etiqueta con el texto "Mostrar"
	 */
	private void crearLabelMostrar() {
		JLabel lblMostrar = new JLabel("Mostrar");
		lblMostrar.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		GridBagConstraints gbc_lblMostrar = new GridBagConstraints();
		gbc_lblMostrar.insets = new Insets(0, 0, 5, 0);
		gbc_lblMostrar.gridx = 3;
		gbc_lblMostrar.gridy = 0;
		frame.getContentPane().add(lblMostrar, gbc_lblMostrar);
	}
	
	/**
	 * Crea una etiqueta con el texto "Historial de Transacciones"
	 */
	private void crearLabelHistorialDeTransacciones() {
		JLabel lblHistorialDeTransacciones = new JLabel("Historial de Transacciones");
		GridBagConstraints gbc_lblHistorialDeTransacciones = new GridBagConstraints();
		gbc_lblHistorialDeTransacciones.insets = new Insets(0, 0, 5, 5);
		gbc_lblHistorialDeTransacciones.gridx = 1;
		gbc_lblHistorialDeTransacciones.gridy = 0;
		frame.getContentPane().add(lblHistorialDeTransacciones, gbc_lblHistorialDeTransacciones);
	}
	
	/**
	 * Crea el marco de la ventana
	 */
	private void crearFrame() {
		frame = new JFrame();
		frame.setTitle("Software de gestión de cuenta bancaria");
		frame.setBounds(100, 100, 800, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 723, 0, 314, 0};
		gridBagLayout.rowHeights = new int[]{0, 262, 61, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
	}
	
	/**
	 * Crea el botón para ingresar nuevas transacciones a la tabla
	 */
	private void crearBtnNuevaTransaccion() {
		JPanel panelBotonNew = new JPanel();
		GridBagConstraints gbc_panelBotonNew = new GridBagConstraints();
		gbc_panelBotonNew.insets = new Insets(0, 0, 5, 0);
		gbc_panelBotonNew.fill = GridBagConstraints.BOTH;
		gbc_panelBotonNew.gridx = 3;
		gbc_panelBotonNew.gridy = 2;
		frame.getContentPane().add(panelBotonNew, gbc_panelBotonNew);
		btnNuevaTransaccin = new JButton("Nueva transacción");
		btnNuevaTransaccin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNuevaTransaccinListener();
				saldoListener();
			}
		});
		panelBotonNew.add(btnNuevaTransaccin);
	}
	
	/**
	 * Crea la etiqueta "Saldo" y muestra el saldo total de la cuenta
	 */
	private void crearSaldo() {
		JPanel panelSaldo = new JPanel();
		GridBagConstraints gbc_panelSaldo = new GridBagConstraints();
		gbc_panelSaldo.insets = new Insets(0, 0, 5, 5);
		gbc_panelSaldo.fill = GridBagConstraints.BOTH;
		gbc_panelSaldo.gridx = 1;
		gbc_panelSaldo.gridy = 2;
		frame.getContentPane().add(panelSaldo, gbc_panelSaldo);

		lblSaldo = new JLabel("Saldo $ "+miCuenta.getSaldo());
		panelSaldo.add(lblSaldo);
	}
	
	/**
	 * Métodos oyentes
	 */
	
	/**
	 * Crea un oyente para el botón destinado a ingresar nuevas transacciones. 
	 */
	private void btnNuevaTransaccinListener() {
		rdbtnTodasListener();
		String montoInput = JOptionPane.showInputDialog("Monto de la operación: ");
		float monto = 0.00F;
		boolean flag = false;
		String descripcion = null;

		if (montoInput != null && !montoInput.isBlank()) {
			try {
				monto = Float.parseFloat(montoInput);
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null,"Asegúrese de ingresar un número válido.","Error", JOptionPane.ERROR_MESSAGE);
				flag = true;
			}

			if (!flag) {
				descripcion = JOptionPane.showInputDialog("Descripción: ");
				if (descripcion==null || descripcion.isBlank()) {
					descripcion = "<Sin descripción>";
				}
				agregarFila(monto,descripcion);
				miCuenta.realizarTransaccion(new Transaccion(monto,descripcion));
			}
		} else {
			JOptionPane.showMessageDialog(null,"El campo 'monto' es obligatorio.","Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	/**
	 * Crea un oyente que actualiza el saldo de la cuenta a medida que 
	 * se ingresan nuevas transacciones
	 */
	private void saldoListener() {
		lblSaldo.setText("Saldo $ "+miCuenta.getSaldo());
	}
	
	/**
	 * Crea un oyente y performa las acciones tendientes a mostrar todas
	 * las transacciones de la cuenta al activar el radio button "Todas"
	 */
	private void rdbtnTodasListener() {
		limpiarTabla(tablaModel);
		for (Transaccion t: miCuenta.transacciones()) {
			agregarFila(t.getMonto(),t.getDescripcion());
		}
	}
	
	/**
	 * Crea un oyente y performa las acciones tendientes a mostrar la
	 * transacción más histórica de la cuenta al activar el radio button
	 * "Más histórica"
	 */
	private void rdbtnMsHistricaListener() {
		limpiarTabla(tablaModel);
		Transaccion t = miCuenta.transaccionMasHistorica();
		if(t!=null)
			agregarFila(t.getMonto(),t.getDescripcion());
	}
	
	/**
	 * Crea un oyente y performa las acciones tendientes a mostrar la
	 * transacción más reciente de la cuenta al activar el radio button
	 * "Más reciente"
	 */
	private void rdbtnMsRecienteListener() {
		limpiarTabla(tablaModel);
		Transaccion t = miCuenta.transaccionMasReciente();
		if(t!=null)
			agregarFila(t.getMonto(), t.getDescripcion());
	}
	
	/**
	 * Crea un oyente y performa las acciones tendientes a mostrar la
	 * transacción más costosa de la cuenta al activar el radio button
	 * "Más costosa"
	 */
	private void rdbtnMsCostosaListener() {
		limpiarTabla(tablaModel);
		Transaccion t = miCuenta.transaccionMasCostosa();
		if(t!=null)
			agregarFila(t.getMonto(), t.getDescripcion());
	}
	
	/**
	 * Crea un oyente y performa las acciones tendientes a mostrar las
	 * transacciones cuyo monto es igual al indicado por el usuario al
	 * activar el radio button "Monto..."
	 */
	private void rdbtnNewRadioButtonListener() {
		rdbtnTodasListener();
		String montoInput = JOptionPane.showInputDialog("Monto a buscar: ");
		float monto = 0.00F;
		if (montoInput!=null && !montoInput.isBlank()) {
			try {
				monto = Float.parseFloat(montoInput);
				limpiarTabla(tablaModel);
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null,"Asegúrese de ingresar un monto válido.","¡Atención!", JOptionPane.WARNING_MESSAGE);
			}
		}
		
		for (Transaccion t: miCuenta.transaccionesIgualMonto(monto)) {
			agregarFila(t.getMonto(), t.getDescripcion());
		}
	}
}
