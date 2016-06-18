
#include <algorithm>
#include <iostream>
#include <vector>
#include "Grafo.h"


class Mayor_componente {
public:
	//En el constructor realizamos el recorrido en profundidad de cada componente, y guardamos en el atributo_mayor_componente el mayor tamaño encontrado.
	//Coste de E+V siendo E el número de aristas y V el número de vértices.
	Mayor_componente(Grafo const& G) : marked(G.V(), false),
		_size(G.V(), 0), _count(0),_mayor_componente(0) {
		for (auto v = 0; v < G.V(); ++v) {
			if (!marked[v]) { // se recorre una nueva componente conexa
				dfs(G, v);
				++_count;
			}
		}
	}


	int max_tam() const {
		return _mayor_componente;
	}

private:

	// recorrido en profundidad de la componente de v
	void dfs(Grafo const& G, size_t v) {
		marked[v] = true;
		++_size[_count];
		if (_mayor_componente < _size[_count]) _mayor_componente = _size[_count];
		for (auto w : G.adj(v)) {
			if (!marked[w]) {
				dfs(G, w);
			}
		}
	}

	std::vector<bool> marked;     // marked[v] = se ha visitado el vértice v?
	std::vector<size_t> _size;    // size[id] = número de vértices en la componente id
	size_t _count;                // número de componentes conexas

								  // recorrido en profundidad de la componente de v
	int _mayor_componente;
};