package problemaJarras;

import arbolAPS.*;

public class Main {//hacer la busqueda por el padre, y los hermanos, no en todo el arbol y para la parte de que acciones se desarrollan guardarlas en la clase jarras
	public static void main(String[] args) {
		APS<Jarras> arbol = new APS<Jarras>(new Nodo<Jarras>(new Jarras(0,0, "Condicion Inicial ")));//se crea un arbol con llave del nodo raiz (0, 0)
		try {
			SolProblema solucion = new SolProblema(arbol);//se crea una instancia de SolProblema e inmediatamente se genera la solucion al problema
		} catch (ExceptionNodo e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
}
