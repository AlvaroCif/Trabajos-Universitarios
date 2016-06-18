/* Grupo TAIS17, Benito Álvaro Cifuentes y Rafael Guerra
Para comprobar si un arbol es bipartito o no, la clave está en realizar un recorrido en profundidad de forma que para todos los adyacentes de cada nodo
que no se hayan visitado aun se pinte del color contrario al que se tiene en el nodo actual y para los adyacentes que si se hayan visitado comprobar
que están pintados de un color diferente.

Al ser un recorrido en profundidad por cada componente conexa, el coste es de E+V
*/
#include <iostream>
#include <algorithm>
#include "Grafo.h"
#include "Bipartito.h"

Grafo construyeGrafo(int numNodos, int numAristas) {
	Grafo g(numNodos);
	int x = 0, y = 0;

	for (int i = 0; i < numAristas; i++) {
		std::cin >> x;
		std::cin >> y;
		g.ponArista(x, y);
	}
	return g;
}

void imprimeResult(Bipartito& b) {
	if (b.getBipartito()) std::cout << "SI" << std::endl;
	else   std::cout << "NO" << std::endl;
}

int main() {
	int numNodos = 0, numAristas = 0;

	while (std::cin >> numNodos) {
		std::cin >> numAristas;
		Grafo grafo = construyeGrafo(numNodos, numAristas);
		Bipartito b(grafo);		//Se hace el recorrido en profundidad...
		imprimeResult(b);
	}
	return 0;
}
