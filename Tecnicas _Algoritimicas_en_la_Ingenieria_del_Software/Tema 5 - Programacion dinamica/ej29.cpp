/* Benito Álvaro Cifuentes de la Torre y Rafael Guerra Grupo 17 Tais.
A pesar de que el problema de nuestro aventurero se puede resolver mediante la aplicación de Floyd sobre el mapa de villas. Existe una forma menos costosa de hallar la solución
para ello nos basaremos en que para saber si hay un camino mas barato para llegar a una aldea, solo tenemos que comparar ir directamente, o ir a través de las siguientes villas.
Pudiendo en una de estas ir directamente o tomar otro desvio a otra aldea.

El algoritmo tiene un coste cúbico, ya que para cada viaje tenemos que comparar el viaje directo y todas las demás posibilidades.

El algoritmo tiene un coste cuadrático en espacio ya que se necesita una matriz para la representación, aunque se puede considerar sobreescribir la matriz dada por el enunciado(mi caso),
cuyo espacio entonces seria constante.

Definicion de la recursión: Aldeas(i,j): Coste mínimo para viajar desde la aldea i hasta la aldea j.
Usaremos como elemento auxiliar la matriz alquiler, que significa alquiler(i,j) = coste de una canoa para ir directamente a j desde i.
Recursión:		Aldeas(i, i + 1) = alquiler(i,i+1)
				Aldeas[i,j] = min (alquiler(i,j), min(Aldeas(i,k) + Aldeas(k,j)) ) siendo siempre i < j - 1
												  i<k<j
*/

#include <iostream>
#include <fstream>
#include <vector>
#include <algorithm>   
#include "Matriz.h"

void resuelve(Matriz<long long> &matriz) {
	int n = matriz.numfils();
	for (int d = 1; d < n; d++) {
		for (int i = 0; i < n - d; i++) {
			int j = i + d;
			for (int k = i; k < j; k++) {
				//std::cout << matriz[i][j] << " : " << matriz[i][k] + matriz[k][j] << "\n";
				matriz[i][j] = std::min(matriz[i][j], matriz[i][k] + matriz[k][j]);
			}
		}
	}
}

bool resuelveCaso() {
	int num_poblados;

	const int INF = 2000000000;
	std::cin >> num_poblados;

	if (!std::cin) return false;


	Matriz<long long> matriz(num_poblados, num_poblados, INF);

	for (int i = 0; i < num_poblados; i++) {
		for (int j = i; j < num_poblados - 1; j++) {
			std::cin >> matriz[i][j + 1];
		}
	}

	resuelve(matriz);

	for (int i = 0; i < num_poblados - 1; i++) {
		for (int j = i + 1; j < num_poblados; j++) {
			std::cout << matriz[i][j];
			if (j != num_poblados - 1) std::cout << " ";
		}
		std::cout << "\n";
	}

	return true;
}

int main() {
#ifndef DOMJUDGE
		std::ifstream in("casos29.txt");
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