#include <iostream>
#include "Grafo.h"

class Bipartito {

public:
	Bipartito(Grafo const& G) : marked(G.V(), false), color(G.V(), false) {
		Bip = true;
		for (int i = 0; i < G.V(); i++) {
			if (!marked[i]) {
				color[i] = true;
				esBipartitoAux(G, i);
			}
		}
	}
	bool getBipartito() { return Bip; }
private:
	bool Bip;
	std::vector<bool> marked;
	std::vector<bool> color;

	void esBipartitoAux(Grafo const& G, int origen) {
		marked[origen] = true;
		for (auto w : G.adj(origen)) {
			if (!marked[w]) {
				color[w] = !color[origen];
				esBipartitoAux(G, w);
			}
			else {
				if (color[w] == color[origen])
					Bip = false;
			}
		}
	}
};
