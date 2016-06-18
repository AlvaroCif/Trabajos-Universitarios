#include "GrafoDirigido.h"
#include <vector>

class Prueba {
	public:
		Prueba(GrafoDirigido G) {
			GrafoDirigido aux = G.reverse();
			//std::vector<bool> gradosCero(G.V());
			for (int i = 0; i < G.V();i++) {
				if (aux.adj(i).size == 0) {
					//gradosCero[i] = true;
					dfs(G, i);
				}
			}
		}

	private:
		void dfs(GrafoDirigido const& G, size_t v) {
			_marked[v] = true;
			for (auto w : G.adj(v)) {
				if (!_marked[w]) {
					dfs(G, w);
				}
				recorrido.insert(recorrido.begin(), 1);
			}
		}
		bool es_posible;
		std::vector<bool> _marked;
		std::vector<int> recorrido;
};