#include <vector>
#include <iostream>
#include "Dijkstra.h"
#include "GrafoDirigidoValorado.h"
#include <limits>

class clase17 {
public:
	clase17(GrafoDirigidoValorado<int> const& G,std::vector<int> const& lugares_donde_entregar_paquetes,int origen) {
		inalcanzable = false;
		coste = 0;
		ejecutar(G,lugares_donde_entregar_paquetes,origen);
	};

	bool getInalcanzable() {
		return inalcanzable;
	}

	int getCoste() {
		return coste;
	}
protected:
	bool inalcanzable;
	int coste;
	//Dos algoritmos de dijkstra y un recorrido de un vector menor o igual que V: -> 2*ElogV + V (siendo V en el peor caso cuando hay que llevar paquetes a todas las casas)
	void ejecutar(GrafoDirigidoValorado<int> const& G, std::vector<int> const& lugares, int origen) {
		Dijkstra dijkstra_a = Dijkstra(G, origen);
		auto grafob = G.reverse();
		Dijkstra dijkstra_b = Dijkstra(grafob, origen);

		auto aux1 = dijkstra_a.getDistTo();
		auto aux2 = dijkstra_b.getDistTo();

		int indice = 0;
		while (!inalcanzable && indice < lugares.size()) {
			if (aux1.at(lugares.at(indice)) == std::numeric_limits<int>::max() || aux2.at(lugares.at(indice)) == std::numeric_limits<int>::max()) {	//Si uno de los dos valores es inalcanzable...
				inalcanzable = true;
			}
			else {
				coste = coste + aux1.at(lugares.at(indice)) + aux2.at(lugares.at(indice));
				indice++;
			}
		}
	}
};
