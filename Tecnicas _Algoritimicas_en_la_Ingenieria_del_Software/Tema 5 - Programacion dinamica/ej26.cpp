/* Benito Álvaro Cifuentes de la Torre Grupo TAIS17
Para resolver el problema de forma dinámica, la estrategia seguida, es construir una tabla decidiendo si colocar o no la varilla que estemos decidiendo en ese preciso momento.
Esto tiene diferentes implicaciones en cada una de las tres versiones:
-Coste minimo, cuando elegimos no usar la varilla, mantenemos el coste igual que cuando no contabamos con esta varilla
			   cuando elegimos usarla, sumamos al coste de crear una varilla de longuitud i - longuitudVarillaActual el coste de nuestra varilla.
-Numero mínimo de varillas. Si descartamos la varilla, tendremos las mismas varillas que cuando no teniamos en consideración esta nueva varilla.
							Si la usamos, tendremos una varilla mas el minimo de varillas posible para la varilla con una longuitud del tamaño de la varilla menor.
-Posibles combinaciones. En este caso hay que sumar las formas de llegar hasta la varilla actual no usando la que esta disponible y usandola. (suma de las dos combinaciones).

El coste del algoritmo es cuadrático para cada uno de los 3 casos (N * L) siendo N el número de varillas y L la longuitud de la mayor de las varillas.
Se usa de espacio adicional un vector de tamaño L para cada uno de los 3 problemas.
*/

#include <iostream>
#include <algorithm>
#include <fstream>
#include <vector>
#include <string>
#include <limits>
#include "Matriz.h"

struct varilla {
	int longitud;
	int coste;
};

bool operator <(const varilla &x, const varilla &y) {
	return x.longitud < y.longitud;
}
/*
totalPosibilidades(i, j) Total de posibilidades para crear una varilla de longuitud j con las primeras i varillas disponibles.
totalPosibilidades(i, j) totalPosibilidades(i - 1, j) si j < varillas[i].longuitud.
						 totalPosibilidades(i - 1, j) + totalPosibilidades(i - 1, j - varillas[i].longuitud).
totalPosibilidades(0,j) = 0
totalPosibilidades(i,0) = 1
*/
void rellenarArray1(std::vector<int>& C, std::vector<varilla>& varillas) {
	int longitud_max = C.size() - 1;
	for (int i = 1; i <= varillas.size() - 1; i++) {
		C[0] = 1;
		for (int j = longitud_max; j > 0; j--) {
			if (j >= varillas[i].longitud) {
				C[j] = C[j] + C[j - varillas[i].longitud];
			}
		}
	}
}
/*
minimoVarillas(i, j) número mínimo de soldaduras para crear una varilla de longuitud j con las primeras i varillas disponibles.
minimoVarillas(i, j) minimoVarillas(i - 1, j) si j < varillas[i].longuitud.
					 min(minimoVarillas(i - 1, j), 1 + minimoVarillas(i - 1, j - varillas[i].longuitud).
minimoVarillas(i,0) = 0
minimoVarillas(0,j) = infinito
*/
void rellenarArray2(std::vector<int>& C, std::vector<varilla>& varillas) {
	int longitud_max = C.size() - 1;
	C[0] = 0;
	for (int i = 1; i <= varillas.size() - 1; i++) {
		C[0] = 0;
		for (int j = longitud_max; j > 0; j--) {
			if (j >= varillas[i].longitud) {
				C[j] = std::min(C[j], 1 + C[j - varillas[i].longitud]);
			}
		}
	}
}
/*
minimoCoste(i, j) coste mínimo para crear una varilla de longuitud j con las primeras i varillas disponibles.
minimoCoste(i, j) minimoCoste(i-1 , j) si j < varillas[i].longuitud.
				  min(minimoCoste(i-1, j) , varillas[i].coste + minimoCoste(i-1,j-varillas[i].longuitud).
minimoCoste(i,0) = 0
minimoCoste(0,j) = infinito
*/
void rellenarArray3(std::vector<int>& C, std::vector<varilla>& varillas) {
	int longitud_max = C.size() - 1;
	for (int i = 1; i <= varillas.size() - 1; i++) {
		C[0] = 0;
		for (int j = longitud_max; j > 0; j--) {
			if (j >= varillas[i].longitud) {
				C[j] = std::min(C[j], varillas[i].coste + C[j - varillas[i].longitud]);
			}
		}
	}
}

/*
Para resolver cualquiera de los 3 problemas planteados, es necesario usar como espacio adicional un vector de tamaño N, siendo N la longuitud de la vara que queremos crear.
*/
std::string resuelve(int longitud_max, std::vector<varilla>& varillas) {
	const int INF = 2000000000;
	varilla v;	v.coste = 0;	v.longitud = 0;
	varillas.insert(varillas.begin(), v);
	Matriz<int> C(varillas.size() + 1, longitud_max + 1, INF);
	// Matriz<int> C(varillas.size() + 1, longuitud_max + 1, 1000; Aqui se puede ver que rellena la tabla con cierto sentido
	//std::cout << C[0][0];
	std::vector <int> total_formas(longitud_max + 1, 0);
	std::vector<int> minimo_varillas(longitud_max + 1,INF);
	std::vector<int> minimo_coste(longitud_max + 1, INF);
	rellenarArray1(total_formas, varillas);
	if (total_formas[total_formas.size() - 1] == 0) return "NO\n";
	rellenarArray2(minimo_varillas,varillas);
	rellenarArray3(minimo_coste, varillas);

	//if (minimo_varillas[minimo_varillas.size() - 1] >= INF) return "NO\n";
	//else {
	std::string s = "SI " + std::to_string(total_formas[total_formas.size() - 1]) + " " + std::to_string(minimo_varillas[minimo_varillas.size() - 1]) + " " + std::to_string(minimo_coste[minimo_varillas.size() - 1]) +"\n";
	return s;
	//}
}

bool resuelveCaso() {
	int numero_varillas, longitud_max;
	std::cin >> numero_varillas >> longitud_max;
	if (!std::cin) return false;
	std::vector<varilla> varillas(numero_varillas);
	varilla v;
	int longitud, coste;
	for (int i = 0; i < numero_varillas; i++) {
		std::cin >> longitud >> coste;
		v.longitud = longitud;	v.coste = coste;
		varillas[i] = v;
	}

	std::cout << resuelve(longitud_max, varillas);
	return true;
}

int main() {
	while (resuelveCaso) {
#ifndef DOMJUDGE
		std::ifstream in("casos26.txt");
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
}