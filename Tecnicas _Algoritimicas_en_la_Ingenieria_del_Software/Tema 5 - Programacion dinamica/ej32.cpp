/*Benito Álvaro Cifuentes de la Torre y Rafael Guerra Grupo 17 Tais

Para resolver el problema de nuestro atareado carpintero Ebanisto, se parte de la idea que explica el enunciado, encontrar la combinación que nos permite minimizar el
esfuerzo que necesitamos para realizar todos los cortes en la tabla. Para hacer esto, lo que hacemos es comprobar todas las posibilidades de cortes que se pueden hacer, y
quedarnos con el mínimo de todas.

El algoritmo tiene un coste cúbico, ya que es necesario no solo recorrer la mitad de la matriz, sino para cada posibilidad, tenemos que comprobar todos sus "estados anteriores"
y elegir el mínimo.

El algoritmo en cambio solo tiene un coste cuadrático en espacio, ya que solo es necesario mantener una matriz como espacio adicional.

Definición de la recursión: Carpintero(i,j) : Esfuerzo mínimo para conseguir mediante el esfuerzo minimo posible realizar todos los cortes entre el corte nº i y el corte nº j

Recursión:		Carpintero (i, i+1) = 0.
				Carpintero (i,j) =  min			{ 2*(cortes(j) - cortes(i) + cortes(i,k) + cortes(k,j) }
							   i+1 <= k <= j -1
*/
#include <iostream>
#include <fstream>
#include <algorithm>
#include <vector>

#include "Matriz.h"


int resuelve(std::vector<int> &cortes,int longitud) {
	const int INF = 2000000000;
	int resultado = 0;
	cortes.insert(cortes.begin(), 0);
	cortes.push_back(longitud);

	Matriz<int> carpintero(cortes.size(), cortes.size());

	for (int i = 1; i < cortes.size() - 1;i++) {
		carpintero[i][i + 1] = 0;
	}

	for (int d = 2;d < cortes.size();d++) {
		for (int i = 0; i < cortes.size() - d; i++) {
			int j = d + i;
			int aux = 0;
			int aux1 = 0;
			for (int k = i + 1; k < j;k++) {
				
				aux1 = 2 * (cortes[j] - cortes[i]) + (carpintero[i][k] + carpintero[k][j]);

				if (aux == 0 || aux > aux1) {
					aux = aux1;
				}
			}
			carpintero[i][j] = aux;
		}
	}

	/*for (int i = 0; i < carpintero.numcols();i++) {
		for (int j = 0; j < carpintero.numfils();j++) {
			std::cout << carpintero[i][j] << "\t";
		}
		std::cout << "\n";
	}
	*/
	return carpintero[0][cortes.size()-1];
}

bool resuelveCaso() {
	int longitud, cortes;
	std::cin >> longitud;
	std::cin >> cortes;
	if (longitud == 0 && cortes == 0) return false;
	std::vector<int> poscortes(cortes);
	for (int i = 0; i < cortes; i++) {
		std::cin >> poscortes[i];
	}

	int resultado = resuelve(poscortes,longitud);
	std::cout << resultado << "\n";
	return true;
}

int main() {
#ifndef DOMJUDGE
	std::ifstream in("casos32.txt");
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