#ifndef DJSTAR
#define DJSTAR

#include <vector>
#include <iostream>
#include "GrafoDirigidoValorado.h"
#include "IndexPQ.h"
#include <limits>

class Dijkstra {
public:
	//Se estima un coste de E log V suponiendo que el coste de inicializar el vector con los valores al maximo sea 0.
	Dijkstra(const GrafoDirigidoValorado<int> &g, int origen)
	:
	edgeTo (g.V()),
	disTo (g.V(), std::numeric_limits<int>::max()), //Puede ser coste V o 0.
	pq(g.V())
	{

		disTo.at(origen) = 0;
		//********************************
		pq.push(origen,0);
		//******************************
		while (!pq.empty()){	//Se ejecuta E veces en el peor de los casos.
			int v = pq.top().elem;
			pq.pop();			//log V
			AdysDirVal<int> adyacentes = g.adj(v);
			for (AristaDirigida<int> a : adyacentes){
				relax(a);
			}
		}

	}

	std::vector<AristaDirigida<int>> getEdgeTo() {
		return edgeTo;
	}

	std::vector<int> getDistTo() {
		return disTo;
	}


protected:
	std::vector<AristaDirigida<int>> edgeTo;
	std::vector<int> disTo;
	IndexPQ<int> pq;

	void relax(AristaDirigida<int> e){
		int v = e.from(), w = e.to();
		if (disTo.at(w) > disTo.at(v) + e.valor()) {
			disTo.at(w) = disTo.at(v) + e.valor();
			edgeTo.at(w) = e;

			pq.update(w, disTo.at(w));

		}
	}

};

#endif