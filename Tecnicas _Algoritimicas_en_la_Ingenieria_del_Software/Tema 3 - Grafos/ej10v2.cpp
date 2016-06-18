/* Grupo TAIS17, Benito Álvaro Cifuentes y Rafael Guerra
Para comprobar si un arbol es libre, se debe cumplir la condición de que el número total de aristas de un grafo, sea exactamente el número de nodos menos una
y que además usando todas estas aristas se lleguen a todos los nodos (para comprobar si es convexo)

Para ello, se parte desde un nodo cualquiera, empezaremos desde el primero, y recorreremos la lista de nodos adyacentes guardando en unas variables el
numero de nodos recorridos y las aristas visitadas, teniendo siempre cuidado de no sumar dos veces la misma arista.

*/

#include <algorithm>
#include <iostream>
#include <vector>
#include "Grafo.h"
#include "Arbol_Libre.h"
// lee un grafo de la entrada estandar, primero recibe el número de aristas y vertices, y despues recibe una arista en cada línea.
Grafo leerGrafo(int numero_vertices, int numero_aristas) {

	int nodo_origen = 0;
	int nodo_destino = 0;
	Grafo g = Grafo(numero_vertices);
	for (int i = 0; i < numero_aristas; i++) {

		std::cin >> nodo_origen;
		std::cin >> nodo_destino;

		g.ponArista(nodo_origen, nodo_destino);
	}
	return g;
}


// Resuelve un caso de prueba, leyendo de la entrada la
// configuracion, y escribiendo la respuesta
//Coste de E+V explicado el coste en la clase auxiliar
bool resuelveCaso() {
	int vertices = 0, aristas = 0;
	std::cin >> vertices;
	if (!std::cin) return false;
	std::cin >> aristas;
	auto grafo = leerGrafo(vertices, aristas);
	Arbol_Libre arbolG = Arbol_Libre(grafo);
	if (arbolG.esLibre()) {
		std::cout << "SI" << "\n";
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