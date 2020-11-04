package GUI;

import javax.swing.*;
import Programa.Programa;

public class Main {
	//El método main es temporal (o no?)
	public static void main(String [] args) {
		// Muestra un popup para ingresar la clave de acceso y la almacena.
		String claveDeAcceso = JOptionPane.showInputDialog("Clave de acceso:");
		
		if (Programa.check_password(claveDeAcceso)) {
			GUI.startGUI();
		} else {
			JOptionPane.showMessageDialog(null,"La clave de acceso tiene un formato incorrecto.","Error", JOptionPane.ERROR_MESSAGE);
		}
	}
}
