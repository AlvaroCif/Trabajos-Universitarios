#include <iostream>
#include <fstream>
#include <algorithm>
#include <vector>

#include "Matriz.h"

void resuelve(std::vector<double> &operandos) {
	int n = operandos.size();
	Matriz<double> maximos(n, n);
	Matriz<double> minimos(n, n);

	for (int d = 0; d < n; d++) {
		maximos[d][d] = operandos[d];
		minimos[d][d] = operandos[d];
	}

	for (int d = 1; d < n; d++) {
		for (int i = 0; i < n - d; i++) {
			int j = i + d;
			double aux = 0;	double aux1 = 0; double aux2 = 0; double aux3 = 0;
			for (int k = i; k < j; k++) {
				aux1 = maximos[i][k] / minimos[k + 1][j];
				if (aux1 > aux || aux == 0) {
					aux = aux1;
				}

				aux3 = minimos[i][k] / maximos[k + 1][j];
				if (aux3 < aux2 || aux2 == 0) {
					aux2 = aux3;
				}
			}
			maximos[i][j] = aux;
			minimos[i][j] = aux2;
		}
	}
	std::cout << "Hola";
}

bool resuelveCaso() {

	int numoperandos;
	std::cin >> numoperandos;
	if (numoperandos == 0) return false;
	std::vector<double> operandos(numoperandos);

	for (int i = 0; i < numoperandos;i++) {
		std::cin >> operandos[i];
	}

	resuelve(operandos);
	return true;
}

int main() {


#ifndef DOMJUDGE
	std::ifstream in("Casos33.txt");
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