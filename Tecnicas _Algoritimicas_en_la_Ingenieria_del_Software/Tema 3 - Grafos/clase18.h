#include <vector>
#include <iostream>
#include "DijkstraMod.h"
#include "GrafoValorado.h"

class clase18 {
public:
	clase18(GrafoValorado<int> const& G) {
		posibilidades = 0;
		ejecutar(G);
	};

	int getPosibilidades() {
		return posibilidades;
	}
protected:
	int posibilidades;

	//Un unico algoritmo de dijkstra E log V
	void ejecutar(GrafoValorado<int> const& G) {
		Dijkstra a = Dijkstra(G,0);
		posibilidades = a.getPosibilidades();
	}
};
