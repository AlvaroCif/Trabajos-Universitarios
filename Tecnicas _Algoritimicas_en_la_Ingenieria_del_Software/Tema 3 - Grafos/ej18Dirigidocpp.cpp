#include <iostream>
#include <vector>
#include "GrafoDirigidoValorado.h"
#include "clase18Dirigida.h"

GrafoDirigidoValorado<int> leerGrafo(int intersecciones, int calles) {
	GrafoDirigidoValorado<int> g = GrafoDirigidoValorado<int>(intersecciones);
	int origen, destino, peso;
	for (int i = 0; i < calles; i++) {
		std::cin >> origen >> destino >> peso;
		origen--;destino--;
		AristaDirigida<int> a = AristaDirigida<int>(origen, destino, peso);
		AristaDirigida<int> b = AristaDirigida<int>(destino, origen, peso);
		g.ponArista(a);
	}

	return g;
}
bool resuelve() {
	int intersecciones, calles;
	std::cin >> intersecciones;
	if (!std::cin) return false;
	std::cin >> calles;

	auto grafo = leerGrafo(intersecciones, calles);
	clase18Dirigida aux = clase18Dirigida(grafo);

}

int main() {
	while (resuelve()) {

	}
	return 0;
}