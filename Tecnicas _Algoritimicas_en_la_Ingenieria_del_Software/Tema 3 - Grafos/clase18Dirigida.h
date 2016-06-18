#include <vector>
#include <iostream>
#include "DijkstraModDirigido.h"
#include "GrafoDirigidoValorado.h"
#include <limits>

class clase18Dirigida {
public:
	clase18Dirigida(GrafoDirigidoValorado<int> const& G) {
		posibilidades = 0;
		ejecutar(G);
	};

	int getPosibilidades() {
		return posibilidades;
	}
protected:
	int posibilidades;

	//Dos algoritmos de dijkstra y un recorrido de un vector menor o igual que V: -> E+V
	void ejecutar(GrafoDirigidoValorado<int> const& G) {
		Dijkstra a = Dijkstra(G, 0);
	}
};

