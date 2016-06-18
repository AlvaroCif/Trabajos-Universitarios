/* Benito Álvaro Cifuentes de la Torre y Rafael Guerra Grupo Tais 17
El problema de las vacas del granjero Sancho resulta curioso ya que a diferencia de otras soluciones de programación dinámica tenemos que suponer la acción de la otra vaca,
Devoradora, pero eso se resuelve de manera sencilla ya que sabemos que siempre va a elegir el cubo de mayor tamaño, por lo que nuestra solución "saltará" dos diagonales en vez
de a lo que estamos acostumbrados de ir una a una.


El algoritmo tiene un coste cuadrático en tiempo, ya que necesitamos reconsiderar 3 posiciones para cada elemento en cada diagonal, y se recorren N/2 diagonales.

El algoritmo tiene un coste de espacio cuadrático tambien ya que es necesaria una matriz extra de dos dimensiones.

Definición:  Vacas(i,j) = cantidad maxima que come listilla con los cubos desde i hasta j cuando empieza.

Definicion de recursión: 

(asumiremos que los cubos de entrada vienen en una variable p)
Si el número total de cubos es par:
vacas(i, i+1) = max(p[i],p[i+1].

Si el número de cubos es impar:
vacas(i,i) = p[i].

vacas(i,j) = max( (p[i] + {	vacas(i + 1, j - 1) if p[j] > p[i+1]
							vacas(i + 2, j)		if p[i+1] > p[j]
							})
							,
				   p[j] + { vacas(i + 1, j - 1) if p[i] > p[j-1]
							vacas(i, j - 2)		if p[j+1] > p[i]
							})	)
*/

#include <iostream>
#include <string>
#include <vector>
#include <fstream>
#include <algorithm>
#include "Matriz.h"
int resuelve(std::vector<int> &cubos) {
	Matriz<int> vacas(cubos.size(), cubos.size());
	if (cubos.size() % 2 == 0) {
		for (int i = 0; i < cubos.size() - 1; i++) {
			vacas[i][i + 1] = std::max(cubos[i], cubos[i + 1]);
		}
		for (int d = 3; d < cubos.size(); d = d + 2) {
			for (int i = 0; i < cubos.size() - d; i++) {
				int comidai = 0;
				int j = i + d;
				if (cubos[j] > cubos[i + 1]) comidai = vacas[i + 1][j - 1];
				else comidai = vacas[i + 2][j];

				int comidaj = 0;
				if (cubos[i] > cubos[j - 1]) comidaj = vacas[i + 1][j - 1];
				else comidaj = vacas[i][j - 2];

				vacas[i][j] = std::max(cubos[i] + comidai, cubos[j] + comidaj);
			}
		}
	}
	else {
		for (int i = 0; i < cubos.size() ; i++) {
			vacas[i][i] = cubos[i];
		}
		for (int d = 2; d < cubos.size(); d = d + 2) {
			for (int i = 0; i < cubos.size() - d; i++) {
				int comidai = 0;
				int j = i + d;
				if (cubos[j] > cubos[i + 1]) comidai = vacas[i + 1][j - 1];
				else comidai = vacas[i + 2][j];

				int comidaj = 0;
				if (cubos[i] > cubos[j - 1]) comidaj = vacas[i + 1][j - 1];
				else comidaj = vacas[i][j - 2];

				vacas[i][j] = std::max(cubos[i] + comidai, cubos[j] + comidaj);
			}
		}
	}
	
	return vacas[0][cubos.size() - 1];
}


bool resuelveCaso() {
	int numcubos;
	std::cin >> numcubos;
	if (numcubos == 0) return false;

	std::vector<int> cubos(numcubos);

	for (int i = 0; i < numcubos;i++) {
		std::cin >> cubos[i];
	}


	int resultado = resuelve(cubos);
	std::cout << resultado << "\n";

	return true;
}

int main() {
#ifndef DOMJUDGE
		std::ifstream in("casos34.txt");
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
