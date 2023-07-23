/**
 * 
 * @author Rodrigo Muñoz 22062417
 *	Practica 2: Algoritmo de Prim
 * 	Fecha de creacion: 22/05/2023
 * 	Ultima modificacion: 26/05/2023
 * 
 * 
 */

public class Prim {

	public static int algoritmoPrim(Grafo<String, String, Integer> g, Lista<Par<String, String>> aristas) {
		// Creo un conjunto para almacenar los vértices visitados
		Lista<String> visitados = new Lista<>();

		// Agrego el primer vértice al conjunto de visitados
		String primerVertice = g.listaVertices().consultar(1);
		visitados.insertar(1, primerVertice);

		// Mientras no se hayan visitado todos los vértices
		while (visitados.longitud() < g.numVertices()) {
			// Creo variables para almacenar la arista de menor peso y su peso
			Par<String, String> aristaMinima = null;
			int pesoMinimo = Integer.MAX_VALUE;
			// Busco la arista de menor peso que conecte un vértice visitado con uno no visitado
			for (int i=1; i<=visitados.longitud(); i++) {
				String v1 = visitados.consultar(i);
				Lista<String> sucesores = g.listaSucesores(v1);
				for (int j = 1; j <= sucesores.longitud(); j++) {
					String v2 = sucesores.consultar(j);
					if (visitados.buscar(v2) == 0) {
						int peso = g.costeArista(v1, v2);
						if (peso < pesoMinimo) {
							pesoMinimo = peso;
							aristaMinima = new Par<>(v1, v2);
						}
					}
				}
			}

			// Agrego la arista mínima al conjunto de aristas seleccionadas
			aristas.insertar(1, aristaMinima);

			// Agrego el vértice no visitado al conjunto de visitados
			String v2 = aristaMinima.getValor();
			visitados.insertar(1, v2);
		}

		// Calculo la suma de los pesos de las aristas seleccionadas
		int pesoTotal = 0;
		for (int i = 1; i <= aristas.longitud(); i++) {
			Par<String, String> arista = aristas.consultar(i);
			int peso = g.costeArista(arista.getAtributo(), arista.getValor());
			pesoTotal += peso;
		}

		return pesoTotal;
	}

	public static void escribirLista(Lista<Par<String, String>> aristas) {
		for (int i = 1; i <= aristas.longitud(); i++) {
			Par<String, String> arista = aristas.consultar(i);
			System.out.println(arista.getAtributo() + " - " + arista.getValor());
		}
	}
	
	public static void main(String args[]) {

		// Grafo de ejemplo
		Grafo<String, String, Integer> g = new Grafo<>();
	
		// Grafo vacio
		Grafo<String, String, Integer> g2 = new Grafo<>();

		// Tercer grafo de ejemplo
		Grafo<String, String, Integer> g3 = new Grafo<>();
		
		
		Lista<Par<String, String>> aristas = new Lista<>();
		Lista<Par<String, String>> aristas2 = new Lista<>();
		Lista<Par<String, String>> aristas3 = new Lista<>();



		// Creo los vertices del grafo
		g.insertarVertice("A", "A");
		g.insertarVertice("B", "B");
		g.insertarVertice("C", "C");
		g.insertarVertice("D", "D");
		g.insertarVertice("E", "E");
		g.insertarVertice("F", "F");
		g.insertarVertice("G", "G");

		// Inserto las aristas del grafo, se insertan en ambas direcciones para simular el comportamiento de un grafo no dirigido
		g.insertarArista("A", "B", 10);
		g.insertarArista("B", "A", 10);

		g.insertarArista("A", "D", 7);
		g.insertarArista("D", "A", 7);

		g.insertarArista("A", "C", 4);
		g.insertarArista("C", "A", 4);

		g.insertarArista("B", "D", 2);
		g.insertarArista("D", "B", 2);

		g.insertarArista("B", "E", 10);
		g.insertarArista("E", "B", 10);

		g.insertarArista("D", "C", 2);
		g.insertarArista("C", "D", 2);

		g.insertarArista("D", "G", 5);
		g.insertarArista("G", "D", 5);

		g.insertarArista("C", "F", 3);
		g.insertarArista("F", "C", 3);

		g.insertarArista("F", "G", 5);
		g.insertarArista("G", "F", 5);

		g.insertarArista("E", "G", 2);
		g.insertarArista("G", "E", 2);
		
		// Creo los vertices del grafo 3
		g3.insertarVertice("A", "A");
		g3.insertarVertice("B", "B");
		g3.insertarVertice("C", "C");
		g3.insertarVertice("D", "D");
		g3.insertarVertice("E", "E");
		g3.insertarVertice("F", "F");


		// Inserto las aristas del grafo 3, se insertan en ambas direcciones para simular el comportamiento de un grafo no dirigido
		g3.insertarArista("A", "B", 10);
		g3.insertarArista("B", "A", 10);

		g3.insertarArista("A", "D", 25);
		g3.insertarArista("D", "A", 25);
		
		g3.insertarArista("B", "D", 10);
		g3.insertarArista("D", "B", 10);
		
		g3.insertarArista("B", "C", 30);
		g3.insertarArista("C", "B", 30);

		g3.insertarArista("D", "F", 20);
		g3.insertarArista("F", "D", 20);

		g3.insertarArista("D", "E", 5);
		g3.insertarArista("E", "D", 5);

		g3.insertarArista("C", "E", 12);
		g3.insertarArista("E", "C", 12);
		
		g3.insertarArista("F", "E", 40);
		g3.insertarArista("E", "F", 40);


		System.out.println("Coste total: " + algoritmoPrim(g, aristas));
		
		System.out.println("Aristas seleccionadas:");

		escribirLista(aristas);
		
		System.out.println("--------------------------------------------------");
		
		
		System.out.println("Coste total grafo vacio: " + algoritmoPrim(g2, aristas2));
		
		System.out.println("Aristas seleccionadas grafo 2:");

		escribirLista(aristas2);
		
		System.out.println("--------------------------------------------------");
		
		
		System.out.println("Coste total grafo 3: " + algoritmoPrim(g3, aristas3));

		System.out.println("Aristas seleccionadas grafo 3:");

		escribirLista(aristas3);
		
	}
}