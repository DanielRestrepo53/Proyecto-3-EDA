package arbolAPS;

public class APS<T extends Comparable<T>> {

	protected Nodo<T> raiz;

	public APS(Nodo<T> raiz) {//constructor con insercion inmediata de la raiz
		this.raiz = raiz;
	}

	public Nodo<T> getRaiz() {
		return raiz;
	}
	
	public void insertNodo(Nodo<T> n, Nodo<T> padre) throws ExceptionNodo {
		if(padre == null) {
			throw new ExceptionNodo();//el padre es nulo, no hay donde insertarlo
		} else {//verifica si el padre existe
			Nodo<T> Nodoaux = padre;
			//Nodo<T> Nodoaux;
			// Nodo<T> Nodoaux = buscarNodo(padre.getLlave());
			//if ((Nodoaux = buscarNodo(padre.getLlave())) != null && Nodoaux.getHijo() == null) {//si el padre no tiene hijos pone el que se quiere insertar de hijo
			if (Nodoaux.getHijo() == null) {
				Nodoaux.setHijo(n);
			} else if (Nodoaux != null) {
				Nodoaux = Nodoaux.getHijo();//si si tiene hijos entonces se pasa al primer hijo
				while (Nodoaux.getSigHermano() != null) {
					Nodoaux = Nodoaux.getSigHermano();//se recorren los hermanos y se inserta en el primer hermano nulo
				}
				Nodoaux.setSigHermano(n);
			}
		}
	}

	public Nodo<T> buscarNodo(T llaveN) {
		return buscarNodo(new Nodo<T>(llaveN), raiz);
	}

	protected Nodo<T> buscarNodo(Nodo<T> n, Nodo<T> r) {
		Nodo<T> a = null;
		Nodo<T> b = null;
		if (n.getLlave().compareTo(r.getLlave()) == 0) {//cuando sean iguales devuelve n
			return r;
		}
		if (r.getSigHermano() != null) {//si tiene hermano iguala a a la busqueda por el hermano
			a = buscarNodo(n, r.getSigHermano());
		}
		if (r.getHijo() != null) {//si tiene hijo iguala a b la busqueda por el hermano
			b = buscarNodo(n, r.getHijo());
		}
		if (a != null)//si a no es nulo significa que encontro algo
			return a;//se devuelve a
		else//si a es nulo significa que o no encontro nada o no estaba por la ruta del hermano
			return b;//se devuelve b
	}

}