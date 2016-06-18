#include <algorithm>
#include <iostream>
#include <vector>
#include "GrafoDirigido.h"


class Numero_de_pasos {
public:
	Numero_de_pasos(GrafoDirigido const& G) {
		numero_de_pasos(G);
	};


	int num_pasos() const {
		return _numPasos;
	}

private:
	//Se hace un recorrido en anchura con coste E+V reducido ya que no se completa del todo, y se detiene al encontrar el nodo final.
	void numero_de_pasos(const GrafoDirigido &g) {
		size_t casilla_final = g.V() - 1;
		std::vector<bool> marked = std::vector<bool>(g.V());		//Se inicializa automaticamente a false.
		marked.at(1) = true;
		std::queue<size_t> q;
		q.push(1);

		std::vector<size_t> distTo = std::vector<size_t>(g.V());;   // distTo[v] = número de aristas en el camino s-v más corto
		bool encontrado = false;
		//Recorrido en anchura finalizando en cuanto se encuentra la casilla final
		while (!q.empty() && !encontrado) {
			size_t v = q.front(); q.pop();
			for (size_t w : g.adj(v)) {
				if (w == casilla_final) encontrado = true;
				if (!marked[w]) {
					distTo[w] = distTo[v] + 1;
					marked[w] = true;
					q.push(w);
				}
			}
		}
		_numPasos = distTo[casilla_final];
	}

	int _numPasos;
};