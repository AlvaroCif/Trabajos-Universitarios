#include <iostream>
#include <algorithm>
#include <vector>
#include <fstream>

#include "Matriz.h"


const int INF = 2000000000;

struct Cancion {
	double duracion;
	double valoracion;
};

int resuelve(std::vector<Cancion>& c,int duracion) {
	std::vector<int> ocupada(2, 0);

	return 0;
}
bool resuelveCaso() {
	int numCanciones;

	std::cin >> numCanciones;

	if (numCanciones == 0) return false;
	int duracion;
	std::cin >> duracion;
	std::vector<Cancion> canciones(numCanciones);
	Cancion c;
	for (int i = 0; i < numCanciones;i++) {
		std::cin >> c.duracion;
		std::cin >> c.valoracion;

		canciones[i] = c;
	}

	int resultado = resuelve(canciones, duracion);
	return true;
}
int main() {
#ifndef DOMJUDGE
	std::ifstream in("Casos39.txt");
	auto cinbuf = std::cin.rdbuf(in.rdbuf()); //save old buf and redirect std::cin to casos.txt
#endif

	while (resuelveCaso()) {

	}
#ifndef DOMJUDGE
	std::cin.rdbuf(cinbuf);   //reset to standard input again
	system("PAUSE");
#endif
	return 0;
}