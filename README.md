# AlgoritmoPrim
Implementación de una clase denominada "Prim" que contendrá un método para resolver el problema del árbol de recubrimiento mínimo en un grafo. El método
implementará el algoritmo de Prim, el cual es utilizado para encontrar el conjunto de aristas de menor peso que conecta todos los nodos de un grafo conexo no dirigido.

El método principal de la clase "Prim" se llama "algoritmoPrim" y recibe como entrada un objeto dela clase "Grafo" y una lista de pares de tipo "Par<String, String>". 
El método se encargará de llenar la lista con las aristas seleccionadas y devolverá la suma total de los pesos de esas aristas.
Además del método principal, la clase "Prim" también incluirá otro método auxiliar. 
Llamado "escribirLista", imprimirá por pantalla las aristas contenidas en la lista que se le pase como argumento.

En el "main", el cual será utilizado para realizar pruebas, se creará un grafo de prueba, se ejecutará el
algoritmo de Prim utilizando se mostrará por pantalla las aristas seleccionadas y el peso total que
suman.
