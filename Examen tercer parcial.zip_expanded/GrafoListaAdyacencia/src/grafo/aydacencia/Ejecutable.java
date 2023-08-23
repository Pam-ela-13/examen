package grafo.aydacencia;
import java.util.Scanner;
public class Ejecutable {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingresa el número máximo de vértices en el grafo: ");
        int maxVertices = scanner.nextInt();
        GrafoAdcia grafo = new GrafoAdcia(maxVertices);

        RecorridoProfundidad dfsTraversal = new RecorridoProfundidad(grafo);

        while (true) {
            System.out.println("\nMenú:");
            System.out.println("1. Agregar vértice");
            System.out.println("2. Agregar arista");
            System.out.println("3. Realizar recorrido DFS");
            System.out.println("4. Salir");
            System.out.print("Selecciona una opción: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Ingresa el nombre de la ciudad para el nuevo vértice: ");
                    String nombreCiudad = scanner.next();
                    VerticeAdy nuevoVertice = new VerticeAdy(nombreCiudad);
                    grafo.aregarVertice(nuevoVertice);
                    break;
                case 2:
                    System.out.print("Ingresa el nombre de la ciudad de origen: ");
                    String ciudadOrigen = scanner.next();
                    System.out.print("Ingresa el nombre de la ciudad de destino: ");
                    String ciudadDestino = scanner.next();
                    System.out.print("Ingresa el peso de la arista: ");
                    double peso = scanner.nextDouble();

                    // Supongamos que el grafo contiene los vértices agregados anteriormente
                    VerticeAdy verticeOrigen = buscarVerticePorNombre(grafo, ciudadOrigen);
                    VerticeAdy verticeDestino = buscarVerticePorNombre(grafo, ciudadDestino);
                    if (verticeOrigen != null && verticeDestino != null) {
                        verticeOrigen.asigVert(grafo.numVerts - 1); // Actualizar número de vértice
                        grafo.agregarArco(verticeOrigen, verticeDestino, peso);
                    } else {
                        System.out.println("Uno o ambos vértices no se encontraron.");
                    }
                    break;
                case 3:
                    System.out.print("Ingresa el nombre de la ciudad de inicio: ");
                    String ciudadInicio = scanner.next();
                    VerticeAdy verticeInicio = buscarVerticePorNombre(grafo, ciudadInicio);
                    if (verticeInicio != null) {
                        System.out.println("Recorrido DFS:");
                        dfsTraversal.profundidad(verticeInicio);
                    } else {
                        System.out.println("No se encontró el vértice de inicio.");
                    }
                    break;
                case 4:
                    System.out.println("Saliendo...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Opción inválida.");
            }
        }
    }

    private static VerticeAdy buscarVerticePorNombre(GrafoAdcia grafo, String nombreCiudad) {
        for (int i = 0; i < grafo.numVerts; i++) {
            if (grafo.tablAdc[i].nombreCiudad.equals(nombreCiudad)) {
                return grafo.tablAdc[i];
            }
        }
        return null;
    }
}


