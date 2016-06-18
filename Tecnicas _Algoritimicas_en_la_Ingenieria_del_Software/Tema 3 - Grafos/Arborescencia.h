#include <algorithm>
#include <iostream>
#include <vector>
#include "GrafoDirigido.h"


class Arborescencia {
public:
	Arborescencia(GrafoDirigido const& G){
		arbolescencia(G);
	};

	bool esArborescencia() const {
		return _esArborescencia;
	}
	int dameRaiz() const {
		return _raiz;
	}

private:
	//Recorrido en profundidad desde la posible raiz, si se recorren todos los nodos, el valor de es_arb se mantendra a true, si por el contrario, se visita 
	//algun nodo ya recorrido, será false.
	void arb_aux(const GrafoDirigido &g, int nodo_actual, int &nodos_recorridos, std::vector<int> &recorrido, bool &es_arb) {
		nodos_recorridos = nodos_recorridos + 1;
		recorrido.at(nodo_actual) = nodos_recorridos;

		for (int aux : g.adj(nodo_actual)) {
			if (recorrido.at(aux) == 0) arb_aux(g, aux, nodos_recorridos, recorrido, es_arb);
			else es_arb = false;
		}
	}
	//Determina si un grafo es arborescencia o no
	//Se hace una primera selección de coste lineal recorriendo los adyacentes del grafo inicial invertido (lo que corresponderia a los grados de adyacencia)
	//La operación de inversión tiene coste cuadrático, se podria evitar recorriendo todas las listas de adyacentes, pero también tendría coste cuadrático y asi se simplifica el codigo.
	//La función tiene un coste lineal ya que para cada vértice se consiguen todas sus aristas, y se recorren todos los nodos conectados, haciendo lo mismo con estos.
	//y siempre evitando volver a pasar por un nodo que ya hayamos recorrido con anterioridad.
	// Coste E + V siendo E el número de aristas y V el número de nodos. 
	void arbolescencia(const GrafoDirigido &g) {
		std::vector<int> vector;
		int nodos_recorridos = 0, numero_de_nodos = g.V(), contador_de_raices = 0, raiz = 0;
		GrafoDirigido ginv = g.reverse();
		//Consultando el inverso del arbol, podemos ver rapidamente si hay algún nodo al que no le llegue ninguna arista
		for (int j = 0; j < numero_de_nodos; j++) {
			if (ginv.adj(j).size() == 0) {
				contador_de_raices++;
				raiz = j;
			}
		}

		if (contador_de_raices == 1) {
			//inicializamos el vector con todos los valores a 0
			for (int i = 0; i < numero_de_nodos; i++) {
				vector.push_back(0);
			}
			bool aux = true;
			arb_aux(g, raiz, nodos_recorridos, vector, aux);
			if (nodos_recorridos == numero_de_nodos && aux){
				_raiz = raiz;
				_esArborescencia = true;
			}
			else _esArborescencia = false;
		}
		else _esArborescencia = false;
	}

	bool _esArborescencia;
	int _raiz;
};