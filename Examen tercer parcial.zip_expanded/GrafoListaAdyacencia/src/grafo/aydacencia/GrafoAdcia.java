package grafo.aydacencia;

import java.util.ArrayList;

public class GrafoAdcia {

	int numVerts;
	static int maxVerts = 20;
	VerticeAdy [] tablAdc;

	public GrafoAdcia(int mx) {
		tablAdc = new VerticeAdy[mx];
		numVerts = 0;
		maxVerts = mx;
	}


	// Agregar la m�todo que permite agregar un nuevo v�rtice
	/*
	 * A�ade un nuevo v�rtice a la lista directorio. Si el v�rtice ya est� en la tabla no hace nada, 
	 * devuelve control; si es nuevo, se asigna a continuaci�n del �ltimo. 
	 */
	public void aregarVertice(VerticeAdy nuwVertice) {
		if (numVerts < maxVerts) {
			for(int i =0; i< numVerts; i++) {
				if (tablAdc[i] == nuwVertice) {
					System.out.println("El verice ya existe");
					return;
				}
			}

			tablAdc[numVerts]= nuwVertice;
			numVerts++;
		}else {
			System.out.println("Ya se alcanzo el maximo de vertices");
		}
	}


	//Agregar m�todo que permite agregar un nuevo arco
	/*
	 * Esta operaci�n da entrada a un arco del grafo. El m�todo tiene como entrada el v�rtice origen y el 
	 * v�rtice destino. El m�todo adyacente() determina si la arista ya est� en la lista de adyacencia, 
	 * y, por �ltimo, el Arco se inserta en la lista de adyacencia del nodo origen. 
	 * La inserci�n se hace como primer nodo para que el tiempo sea constante, O(1). 
	 * Otra versi�n del m�todo recibe, directamente, los n�meros de v�rtices que forman los extremos del arco. 
	 * ara a�adir una arista en un grafo valorado, se debe asignar el factor de peso al crear el Arco.
	 */
	public boolean adyacente(VerticeAdy origen, VerticeAdy destino) {
	    for (int i = 0; i < numVerts; i++) {
	        if (tablAdc[i].equals(origen)) {
	            ArrayList<Arco> listaAdy = tablAdc[i].lad;
	            for (Arco arco : listaAdy) {
	                if (tablAdc[arco.destino].equals(destino)) {
	                    return true;
	                }
	            }
	        }
	    }
	    return false;
	}

	public void agregarArco(VerticeAdy origen, VerticeAdy destino, double pesoDKm) {
        for (int i = 0; i < numVerts; i++) {
            if (tablAdc[i].equals(origen)) {
                Arco nuevoArco = new Arco(destino.numVertice, pesoDKm);
                tablAdc[i].lad.add(nuevoArco);
                return;
            }
        }
        System.out.println("No se encontró el vértice origen");
    }




	//Agregar un m�todo que determina si dos v�rtices son adyacentes
	/*
	 * La operaci�n determina si dos v�rtices, v1 y v2, forman un arco. En definitiva, 
	 * si el v�rtice v2 est� en la lista de adyacencia de v1. 
	 * El m�todo buscarLista() devuelve la direcci�n del nodo que contiene al arco, si no est� devuelve null. 
	 */
	public boolean sonAdyacentes(VerticeAdy v1, VerticeAdy v2) {
	    for (int i = 0; i < numVerts; i++) {
	        if (tablAdc[i].equals(v1)) {
	            ArrayList<Arco> listaAdy = tablAdc[i].lad;
	            for (Arco arco : listaAdy) {
	                if (tablAdc[arco.destino].equals(v2)) {
	                    return true;
	                }
	            }
	        }
	    }
	    return false;
	}
	
	//buscarLista()
	public ArrayList<Arco> buscarLista(VerticeAdy vertice) {
	    for (int i = 0; i < numVerts; i++) {
	        if (tablAdc[i].equals(vertice)) {
	            return tablAdc[i].lad;
	        }
	    }
	    return null;
	}


}
