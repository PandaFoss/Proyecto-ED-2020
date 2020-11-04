package GUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import Programa.CuentaBancaria;
import Programa.Transaccion;

public class GUI {

	private JFrame frame;
	private JTable table;
	private DefaultTableModel tablaModel;
	private static CuentaBancaria miCuenta;

	/**
	 * Launch the application. (Este main es temporal!)
	 */
	public static void main(String[] args) {
		startGUI();
	}

	/**
	 * Create the application.
	 */
	public GUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
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
	
	public static void startGUI() {
		miCuenta = new CuentaBancaria();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Métodos que permiten crear e inicializar los componentes de la GUI
	 */
	
	private void crearBotonesDeSeleccion() {
		// Botones para seleccionar las operaciones
		JRadioButton rdbtnTodas = new JRadioButton("Todas");
		rdbtnTodas.setSelected(true);
		rdbtnTodas.setHorizontalAlignment(SwingConstants.CENTER);
		
		JRadioButton rdbtnMsHistrica = new JRadioButton("Más histórica");
		rdbtnMsHistrica.setHorizontalAlignment(SwingConstants.CENTER);
		
		JRadioButton rdbtnMsReciente = new JRadioButton("Más reciente");
		rdbtnMsReciente.setHorizontalAlignment(SwingConstants.CENTER);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Monto...");
		rdbtnNewRadioButton.setHorizontalAlignment(SwingConstants.CENTER);
		
		// Agrupo botones
		ButtonGroup botones = new ButtonGroup();
		botones.add(rdbtnTodas);
		botones.add(rdbtnMsHistrica);
		botones.add(rdbtnMsReciente);
		botones.add(rdbtnNewRadioButton);
		
		// Creo una VerticalBox para posicionar los botones verticalmente
		Box verticalBox = Box.createVerticalBox();
		verticalBox.add(rdbtnTodas);
		verticalBox.add(rdbtnMsHistrica);
		verticalBox.add(rdbtnMsReciente);
		verticalBox.add(rdbtnNewRadioButton);
		
		// Muestro los botones
		GridBagConstraints gbc_verticalBox = new GridBagConstraints();
		gbc_verticalBox.anchor = GridBagConstraints.NORTH;
		gbc_verticalBox.insets = new Insets(0, 0, 5, 0);
		gbc_verticalBox.gridx = 3;
		gbc_verticalBox.gridy = 1;
		frame.getContentPane().add(verticalBox, gbc_verticalBox);
	}
	
	private void crearPanelTabla() {
		tablaModel = new TablaModel();
		table = new JTable();
		table.setModel(tablaModel);
		JScrollPane scrollPane = new JScrollPane(table);
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
	
	private void agregarFila(Float monto, String descripcion) {
	    int fila = table.getRowCount();
	    Transaccion nuevaTransaccion = new Transaccion(monto, descripcion);
	    
		// Crear fila en tabla (GUI)
	    ((DefaultTableModel) table.getModel()).setRowCount(fila+1); // Creo nueva fila
	    table.setValueAt(monto, fila, 0);
	    table.setValueAt(descripcion, fila, 1);
	    
	    // Añadir entrada en Deque
	    miCuenta.realizarTransaccion(nuevaTransaccion);
	}
	
	private void crearLabelMostrar() {
		JLabel lblMostrar = new JLabel("Mostrar");
		lblMostrar.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		GridBagConstraints gbc_lblMostrar = new GridBagConstraints();
		gbc_lblMostrar.insets = new Insets(0, 0, 5, 0);
		gbc_lblMostrar.gridx = 3;
		gbc_lblMostrar.gridy = 0;
		frame.getContentPane().add(lblMostrar, gbc_lblMostrar);
	}
	
	private void crearLabelHistorialDeTransacciones() {
		JLabel lblHistorialDeTransacciones = new JLabel("Historial de Transacciones");
		GridBagConstraints gbc_lblHistorialDeTransacciones = new GridBagConstraints();
		gbc_lblHistorialDeTransacciones.insets = new Insets(0, 0, 5, 5);
		gbc_lblHistorialDeTransacciones.gridx = 1;
		gbc_lblHistorialDeTransacciones.gridy = 0;
		frame.getContentPane().add(lblHistorialDeTransacciones, gbc_lblHistorialDeTransacciones);
	}
	
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
	
	private void crearBtnNuevaTransaccion() {
		JPanel panelBotonNew = new JPanel();
		GridBagConstraints gbc_panelBotonNew = new GridBagConstraints();
		gbc_panelBotonNew.insets = new Insets(0, 0, 5, 0);
		gbc_panelBotonNew.fill = GridBagConstraints.BOTH;
		gbc_panelBotonNew.gridx = 3;
		gbc_panelBotonNew.gridy = 2;
		frame.getContentPane().add(panelBotonNew, gbc_panelBotonNew);
		JButton btnNuevaTransaccin = new JButton("Nueva transacción");
		btnNuevaTransaccin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNuevaTransaccinListener();
			}
		});
		panelBotonNew.add(btnNuevaTransaccin);
	}
	
	private void crearSaldo() {
		JPanel panelSaldo = new JPanel();
		GridBagConstraints gbc_panelSaldo = new GridBagConstraints();
		gbc_panelSaldo.insets = new Insets(0, 0, 5, 5);
		gbc_panelSaldo.fill = GridBagConstraints.BOTH;
		gbc_panelSaldo.gridx = 1;
		gbc_panelSaldo.gridy = 2;
		frame.getContentPane().add(panelSaldo, gbc_panelSaldo);

		JLabel lblSaldo = new JLabel("Saldo $");
		panelSaldo.add(lblSaldo);
	}
	
	/**
	 * Métodos oyentes
	 */
	
	private void btnNuevaTransaccinListener() {
		String montoInput = JOptionPane.showInputDialog("Monto de la operación: ");
		float monto = 0.00F;
		boolean flag = false;
		String descripcion = null;

		if (!montoInput.isBlank()) {
			try {
				monto = Float.parseFloat(montoInput);
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null,"Asegúrese de ingresar un número válido.","Error", JOptionPane.ERROR_MESSAGE);
				flag = true;
			}

			if (!flag) {
				descripcion = JOptionPane.showInputDialog("Descripción: ");
				if (descripcion.isBlank()) {
					descripcion = "<Sin descripción>";
				}
				agregarFila(monto,descripcion);
			}
		} else {
			JOptionPane.showMessageDialog(null,"El campo 'monto' es obligatorio.","Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	 
}
