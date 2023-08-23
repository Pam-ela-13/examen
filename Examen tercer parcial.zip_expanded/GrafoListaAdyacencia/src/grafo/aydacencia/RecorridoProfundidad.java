package grafo.aydacencia;
import java.util.HashSet;
import java.util.Stack;
import java.util.ArrayList;
//import java.util.List;

public class RecorridoProfundidad {

    private GrafoAdcia grafo;

    public RecorridoProfundidad(GrafoAdcia grafo) {
        this.grafo = grafo;
    }

    public void profundidad(VerticeAdy inicio) {
        long startTime = System.currentTimeMillis(); // Captura el tiempo inicial
        HashSet<Integer> visited = new HashSet<>();
        Stack<VerticeAdy> stack = new Stack<>();
        int iterationCount = 0; // Contador de iteraciones

        stack.push(inicio);
        visited.add(inicio.numVertice);

        while (!stack.isEmpty()) {
            VerticeAdy currentVertex = stack.pop();
            System.out.print(currentVertex.nomVertice() + " ");
            iterationCount++; // Aumenta el contador en cada iteración

            ArrayList<Arco> adjList = grafo.buscarLista(currentVertex);
            for (Arco arco : adjList) {
                if (!visited.contains(arco.destino)) {
                    stack.push(grafo.tablAdc[arco.destino]);
                    visited.add(arco.destino);
                }
            }
        }
        
        long endTime = System.currentTimeMillis(); // Captura el tiempo final
        long elapsedTime = endTime - startTime;   // Calcula la diferencia
        System.out.println("\nTiempo de ejecución: " + elapsedTime + " milisegundos");
        
        System.out.println("Total de iteraciones: " + iterationCount);
    }
}
