#include <algorithm>
#include <iostream>
#include <vector>
#include "Grafo.h"


class Arbol_Libre {
public:
	Arbol_Libre(Grafo const& G){
		arbol_libre(G);
	};


	bool esLibre() const {
		return _esLibre;
	}

private:

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
	//La función tiene un coste lineal en el número de nodos y aristas ya que para cada vértice se consiguen todas sus aristas, y se recorren todos los nodos conectados, haciendo lo mismo con estos.
	//y siempre evitando volver a pasar por un nodo que ya hayamos recorrido con anterioridad.
	// Un coste de E+V siendo E el número de aristas y V el número de vértices.
	void arbol_libre(const Grafo &g) {
		int nodos_recorridos = 0;
		int aristas_pasadas = 0;
		int numero_de_nodos = g.V();

		std::vector<int> vector = std::vector<int>(numero_de_nodos);

		libre_aux(g, 0, nodos_recorridos, aristas_pasadas, vector);

		_esLibre = (nodos_recorridos == numero_de_nodos && aristas_pasadas == numero_de_nodos - 1);
	}

	bool _esLibre;
};