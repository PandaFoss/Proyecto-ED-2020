package Programa;

import TDAPila.EmptyStackException;
import TDAPila.PilaConEnlaces;
import TDAPila.Stack;

public class Programa {
	/**
	 * Evalúa una contraseña para determinar si sigue el patrón AXA'A', donde A es el apellido
	 * del usuario, A' es el apellido invertido y X el caracter 'x'.
	 * @param pass Contraseña de acceso al sistema.
	 * @return Retorna true si la contraseña tiene el formato adecuado.
	 */
	public static boolean check_password(String pass) {
		boolean invalido = false;
		int cont = 0;
		Stack<Character> apellido = new PilaConEnlaces<Character>();
		Stack<Character> apellidoDuplicado = new PilaConEnlaces<Character>();
		
		// Copio el apellido en una pila
		while (cont < pass.length() && pass.charAt(cont) != 'x') {
			apellido.push(pass.charAt(cont));
			apellidoDuplicado.push(pass.charAt(cont));
			cont++;
		}

		// Chequeo el tamaño de la variable cont para evitar un IndexOutOfBoundsException
		if (cont != pass.length()) {
			// Si respeta el formato inicial "AX"...
			if (pass.charAt(cont) == 'x' && !apellido.isEmpty()) {
				cont++;
				// ...chequeo que también respete el formato final "A'A'"
				if (cont < pass.length() && !invalido) {
					while (!apellido.isEmpty() && !invalido) {
						try {
							if (pass.charAt(cont) != apellido.pop()) {
								invalido = true;
							} else {
								cont++;
							}
						} catch (EmptyStackException e) {
							e.printStackTrace();
						}
					}
					while (!apellidoDuplicado.isEmpty() && !invalido) {
						try {
							if (pass.charAt(cont) != apellidoDuplicado.pop()) {
								invalido = true;
							} else {
								cont++;
							}
						} catch (EmptyStackException e) {
							e.printStackTrace();
						}
					}
				}
			}
		} else {
			invalido = true;
		}
		return !invalido;
	}
}
