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
// lee un grafo de la entrada estandar, primero recibe el número de aristas y vertices, y despues recibe una arista en cada línea.
Grafo leerGrafo(int numero_vertices,int numero_aristas) {

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

void libre_aux(const Grafo &g, int nodo_actual, int &nodos_recorridos, int &numero_aristas, std::vector<int> &recorrido) {
	nodos_recorridos = nodos_recorridos + 1;
	recorrido.at(nodo_actual) = nodos_recorridos;

	for (int aux : g.adj(nodo_actual)) {
		//Hay que evitar sumar dos veces la misma arista, optando por solo recogerla desde un extremo
		if (nodo_actual <= aux) numero_aristas = numero_aristas + 1;
		if (recorrido.at(aux) == 0) libre_aux(g, aux, nodos_recorridos, numero_aristas, recorrido);
	}
}
//Determina si un grafo es libre o no
//La función tiene un coste lineal de E + V ya que para cada vértice se consiguen todas sus aristas, y se recorren todos los nodos conectados, haciendo lo mismo con estos.
//y siempre evitando volver a pasar por un nodo que ya hayamos recorrido con anterioridad.
// O(f(N)) siendo N el número de nodos 
bool arbol_libre(const Grafo &g) {
	std::vector<int> vector;
	int nodos_recorridos = 0;
	int aristas_pasadas = 0;
	int numero_de_nodos = g.V();
	//for (int i = 0; i < numero_de_nodos; i++) {
	//	vector.push_back(0);
	//}
	vector[numero_de_nodos] = 0;
	libre_aux(g, 0, nodos_recorridos, aristas_pasadas, vector);

	return (nodos_recorridos == numero_de_nodos && aristas_pasadas == numero_de_nodos - 1);

}
// Resuelve un caso de prueba, leyendo de la entrada la
// configuracion, y escribiendo la respuesta
bool resuelveCaso() {
	int vertices = 0, aristas = 0;
	std::cin >> vertices;
	if (!std::cin) return false;
	std::cin >> aristas;
	auto grafo = leerGrafo(vertices,aristas);
	if (arbol_libre(grafo)) {
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