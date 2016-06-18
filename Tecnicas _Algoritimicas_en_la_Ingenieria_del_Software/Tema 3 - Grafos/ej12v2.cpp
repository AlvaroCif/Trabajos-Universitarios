/* Grupo TAIS17, Benito Álvaro Cifuentes y Rafael Guerra
Para comprobar si un arbol es arborescencia, se debe encontrar primero un nodo raiz, al cual no le lleguen ninguna arista, para que se trate de una arborescencia.
este nodo debe ser único (ya que sino no se podría llegar hasta el desde la anterior raiz).

Una vez elegida y comprobado que se trata de la unica posible raiz, se realiza un recorrido en profundidad, en el que se deben alcanzar el resto de nodos del grafo.
Si es asi, se trata de una arborescencia, en caso contrario no lo es.
*/

#include <algorithm>
#include <iostream>
#include <vector>
#include "GrafoDirigido.h"
#include "Arborescencia.h"
// lee un grafo de la entrada estandar, primero recibe el número de aristas y vertices, y despues recibe una arista en cada línea.
GrafoDirigido leerGrafo(int numero_vertices, int numero_aristas) {

	int nodo_origen = 0;
	int nodo_destino = 0;

	GrafoDirigido g = GrafoDirigido(numero_vertices);
	for (int i = 0; i < numero_aristas; i++) {

		std::cin >> nodo_origen;
		std::cin >> nodo_destino;

		g.ponArista(nodo_origen, nodo_destino);
	}
	return g;
}
// Resuelve un caso de prueba, leyendo de la entrada la
// configuracion, y escribiendo la respuesta

//Coste E+V explicado en la clase Arborescencia
bool resuelveCaso() {
	int vertices = 0, aristas = 0;
	std::cin >> vertices;
	if (!std::cin) return false;
	std::cin >> aristas;
	auto grafo = leerGrafo(vertices, aristas);

	Arborescencia g = Arborescencia(grafo);
	if (g.esArborescencia()) {
		std::cout << "SI" << " " << g.dameRaiz() << "\n";
	}
	else {
		std::cout << "NO" << "\n";
	}

	return true;

}
int main() {
	while (resuelveCaso());
	return 0;
}