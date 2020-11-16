package Programa;

import TDACola.Cola_con_arreglo_circular;
import TDACola.EmptyQueueException;
import TDACola.Queue;
import TDAPila.EmptyStackException;
import TDAPila.PilaConEnlaces;
import TDAPila.Stack;

public class Verificador {
	/**
	 * Evalúa una contraseña para determinar si sigue el patrón AXA'A', donde A es el apellido
	 * del usuario, A' es el apellido invertido y X el caracter 'x'.
	 * @param pass Contraseña de acceso al sistema.
	 * @return Retorna true si la contraseña tiene el formato adecuado.
	 */
	public static boolean check_password(String pass) {
		boolean invalido = false;
		int cont = 0;
		char charActual = ' ';
		Stack<Character> pilaApellido = new PilaConEnlaces<Character>();
		Queue<Character> colaApellido = new Cola_con_arreglo_circular<Character>();
		
		// Copio el apellido en una pila
		while (cont < pass.length() && pass.charAt(cont) != 'x') {
			pilaApellido.push(pass.charAt(cont));
			cont++;
		}

		// Chequeo el tamaño de la variable cont para evitar un IndexOutOfBoundsException
		if (cont != pass.length()) {
			// Si respeta el formato inicial "AX"...
			if (pass.charAt(cont) == 'x' && !pilaApellido.isEmpty()) {
				cont++;
				// ...chequeo que también respete el formato final "A'A'"
				if (cont < pass.length() && !invalido) {
					while (cont < pass.length() && !pilaApellido.isEmpty() && !invalido) {
						try {
							charActual = pilaApellido.pop();
							colaApellido.enqueue(charActual);
							if (pass.charAt(cont) != charActual) {
								invalido = true;
							} else {
								cont++;
							}
						} catch (EmptyStackException e) {
							e.printStackTrace();
						}
					}
					while (cont < pass.length() && !colaApellido.isEmpty() && !invalido) {
						try {
							if (pass.charAt(cont) != colaApellido.dequeue()) {
								invalido = true;
							} else {
								cont++;
							}
						} catch (EmptyQueueException e) {
							e.printStackTrace();
						}
					}
					if (!colaApellido.isEmpty() || !pilaApellido.isEmpty()) {
						invalido = true;
					}
				}
			}
		} else {
			invalido = true;
		}
		return !invalido;
	}
}
