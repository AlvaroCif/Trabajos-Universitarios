/* Benito Álvaro Cifuentes y Rafael Guerra Grupo 17  Tais

*/
#include <iostream>
#include <fstream>
#include <vector>


#include "Matriz.h"
const int INF = 2000000000;
struct Pelicula {
	int min_inicio;
	int min_final;
	int duracion;
};

int resuelve(std::vector<Pelicula>& pelis) {
	int resultado = 0;
	int n = pelis.size();
	Matriz<int> peliculas(n, n,0);
	Matriz<int> finalizacion(n, n, INF);
	for (int i = 0; i < n; i++) {
		peliculas[i][i] = pelis[i].duracion;
		finalizacion[i][i] = pelis[i].min_final + 10;
	}

	for (int d = 1; d < n; d++) {
		for (int i = 0; i < n - d; i++) {
			int j = i + d;
			int aux1 = 0;
			int aux = 0;
			int finalización_final;
			for (int k = i; k <= j; k++) {
				if (finalizacion[i][k] > pelis[k + 1].min_inicio) {
					finalización_final = finalizacion[k + 1][j];
					aux1 = peliculas[i][k] + peliculas[k + 1][j];
				}
				else {
					if (peliculas[i][k] > peliculas[k + 1][j]) {

					}
				}
			}
		}
	}
	return resultado;
}
bool resuelveCaso() {
	int numPelis = 0;
	std::cin >> numPelis;

	if (numPelis == 0) return false;
	int horas; int minutos;	int duracion;
	std::vector<Pelicula> pelis(numPelis);
	char dos_puntos;
	Pelicula p;
	for (int i = 0; i < numPelis; i++) {
		std::cin >> horas;
		std::cin >> dos_puntos;
		std::cin >> minutos;
		std::cin >> duracion;

		p.min_inicio = horas * 60 + minutos;
		p.min_final = horas * 60 + minutos + duracion + 10;
		p.duracion = duracion;
		pelis[i] = p;
	}

	int resultado = resuelve(pelis);

	return true;
}

int main() {
#ifndef DOMJUDGE
	std::ifstream in("casos35.txt");
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