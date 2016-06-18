#ifndef DJSTAR
#define DJSTAR

#include <vector>
#include <iostream>
#include "GrafoValorado.h"
#include "IndexPQ.h"
#include <limits>

class Dijkstra {
public:

	Dijkstra(const GrafoValorado<int> &g, int origen)
		://Se inicializan todos los valores vacios, menos las distancias que se establecen como el máximo conocido.
		edgeTo(g.V()),
		disTo(g.V(), std::numeric_limits<int>::max()),
		pq(g.V()),
		coincidencias(g.V())
	{
		coincidencias.at(0) = 1;	//Para el primer nodo conocemos un camino.
		disTo.at(origen) = 0;		//La distancia es evidentemente 0
		pq.push(origen, 0);
		while (!pq.empty()) {
			int v = pq.top().elem;	//Seleccionamos el nodo que tenga una menor distancia posible y relajamos todas sus aristas.
			pq.pop();
			AdysVal<int> adyacentes = g.adj(v);
			for (Arista<int> a : adyacentes) {
					relax(a,v);		//Tiene un coste de logV
			}
		}
	}

	int getPosibilidades() {
		return coincidencias.at(coincidencias.size() - 1);
	}


protected:
	std::vector<Arista<int>> edgeTo;
	std::vector<int> disTo;
	std::vector<int> coincidencias;
	IndexPQ<int> pq;

	void relax(Arista<int> e,int v) {
		int w = e.otro(v);

		if (disTo.at(w) == disTo.at(v) + e.valor()) {	//En caso de ser iguales, se suman la cantidad de caminos posibles
			coincidencias.at(w) = coincidencias.at(w) + coincidencias.at(v);
		}
		else if (disTo.at(w) > disTo.at(v) + e.valor()) {	//Si se descubre un nuevo camino mejor, se ponen los caminos posibles del anterior nodo.
			disTo.at(w) = disTo.at(v) + e.valor();
			edgeTo.at(w) = e;
			coincidencias.at(w) = coincidencias.at(v);
			pq.update(w, disTo.at(w));
		}
	}

};

#endif