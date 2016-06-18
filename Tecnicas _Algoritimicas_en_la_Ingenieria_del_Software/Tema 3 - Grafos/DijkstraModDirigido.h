#ifndef DJSTAR
#define DJSTAR

#include <vector>
#include <iostream>
#include "GrafoDirigidoValorado.h"
#include "IndexPQ.h"
#include <limits>

class Dijkstra {
public:

	Dijkstra(const GrafoDirigidoValorado<int> &g, int origen)
		:
		edgeTo(g.V()),
		disTo(g.V(), std::numeric_limits<int>::max()),
		pq(g.V()),
		coincidencias(g.V())
	{
		coincidencias.at(0) = 1;
		disTo.at(origen) = 0;
		pq.push(origen, 0);
		while (!pq.empty()) {
			int v = pq.top().elem;
			pq.pop();
			AdysDirVal<int> adyacentes = g.adj(v);
			for (AristaDirigida<int> a : adyacentes) {
				//	std::cout << "Arista: " << a.uno() << a.otro(a.uno()) << " ";
				relax(a);

			}
		}
		for (int i = 0;i < coincidencias.size();i++) {
			std::cout << coincidencias.at(i);
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
	std::vector<int> coincidencias;
	IndexPQ<int> pq;

	void relax(AristaDirigida<int> e) {
		int v = e.from(), w = e.to();

		if (disTo.at(w) == disTo.at(v) + e.valor()) {
			coincidencias.at(w) = coincidencias.at(w) + coincidencias.at(v);
		}
		else if (disTo.at(w) > disTo.at(v) + e.valor()) {
			disTo.at(w) = disTo.at(v) + e.valor();
			edgeTo.at(w) = e;
			coincidencias.at(w) = coincidencias.at(v);
			pq.update(w, disTo.at(w));
		}
	}

};

#endif