/* Grupo TAIS17, Benito Álvaro Cifuentes y Rafael Guerra
Para resolver el problema del cole, se ha modificado el algoritmo de dijkstra para que este almacene 
un array con los posibles caminos mínimos para cada nodo, esto se consigue, inicializando la primera posición
a 1, y cada vez que se encuentre un mejor camino a un nuevo nodo, se le asigna el número de caminos del anterior nodo,
en caso de que se encuentre un camino igual de bueno, se suma la cantidad de caminos posibles para el destino con la cantidad
de caminos posibles del origen, creando asi el nuevo valor que determina el numero de caminos para el nodo destino.

El coste se ve ligeramente aumentado pero mantiene lo mismo que el algoritmo de dijkstra E*logV siendo E el número de aristas y V
el número de nodos.

*/

#include <iostream>
#include <vector>
#include "GrafoValorado.h"
#include "clase18.h"

GrafoValorado<int> leerGrafo(int intersecciones, int calles) {
	GrafoValorado<int> g = GrafoValorado<int>(intersecciones);
	int origen, destino, peso;
	for (int i = 0; i < calles; i++) {
		std::cin >> origen >> destino >> peso;
		origen--;destino--;
		Arista<int> a = Arista<int>(origen, destino, peso);
		g.ponArista(a);
	}

	return g;
}
bool resuelve() {
	int intersecciones, calles;
	std::cin >> intersecciones;
	if (!std::cin) return false;
	std::cin >> calles;

	auto grafo = leerGrafo(intersecciones, calles);
	clase18 aux = clase18(grafo);	//Una única aplicación del algoritmo de dijkstra.
	std::cout << aux.getPosibilidades() << "\n";

	return true;
}

int main() {
	while (resuelve()) {
		
	}
	return 0;
}