#include <fstream>
#include <iostream>
#include <vector>
#include <algorithm>
#include "Matriz.h"
const int INF = 2000000000;
std::vector<int> resuelve(std::vector<int>& valor_monedas, std::vector<int>& cantidad_monedas, int valor) {
	int n = valor_monedas.size();
	valor_monedas.insert(valor_monedas.begin(), 0);
	cantidad_monedas.insert(cantidad_monedas.begin(), 0);
	std::vector<int> resultado(valor_monedas.size(), 0);
	Matriz<int> matriz(valor_monedas.size(), valor + 1, INF);
	matriz[0][0] = 0;
	int aux = 0;
	int aux1 = 0;
	for (int i = 1; i <= n; i++) {
		for (int j = 0; j <= valor; j++) {
			if (j < valor_monedas[i]) matriz[i][j] = matriz[i - 1][j];
			else {
				aux = 0;	aux1 = 0;
				for (int k = 0; k <= cantidad_monedas[i];k++) {
					int sumaMon = k * valor_monedas[i];
					if (j >= sumaMon) {
						aux1 = matriz[i - 1][j - sumaMon] + k;
						if (aux1 < aux || aux == 0) {
							aux = aux1;
						}
					}
					else {
						k = cantidad_monedas[i];
					}
				}
				matriz[i][j] = aux;
			}
		}
	}
	/*
	if (matriz[cantidad_monedas.size() - 1][valor] != INF) {
	std::cout << "SI " << matriz[cantidad_monedas.size() - 1][valor] << "\n";
	}
	else {
	std::cout << "NO" << "\n";
	}

	for (int i = 1; i < valor_monedas.size(); i++) {
	for (int j = 0; j <= valor;j++) {
	std::cout << matriz[i][j] << "\t";
	}
	std::cout << "\n";
	}

	if (matriz[cantidad_monedas.size() - 1][valor] != INF) {
	std::cout << "SI " << matriz[cantidad_monedas.size() - 1][valor] << "\n";
	}
	else {
	std::cout << "NO" << "\n";
	}
	*/
	//std::cout << matriz[cantidad_monedas.size() - 1][valor];
	/*
	if (matriz[cantidad_monedas.size() - 1][valor] <= INF) {
		int aux = valor;
		int n = valor_monedas.size() - 1;
		while (aux != 0) {
			bool encontrada = false;
			int i = 1;
			while (i < cantidad_monedas.size() && !encontrada) {
				if (valor_monedas[i] <= aux) {
					if ((matriz[n][aux]) == (matriz[n][aux - valor_monedas[i]]) + 1) {
						encontrada = true;
						aux = aux - valor_monedas[i];
						resultado[i]++;
					}
				}
				i++;
			}

		}
	}
	else { resultado[0] = INF; }
	*/
	if (matriz[cantidad_monedas.size() - 1][valor] < INF) {
		std::cout << "SI " << matriz[cantidad_monedas.size() - 1][valor] << "\n";
	}
	else {
		std::cout << "NO" << "\n";
	}
	return resultado;
}

bool resuelveCaso() {
	int num_monedas, valor;
	std::cin >> num_monedas;
	if (!std::cin) return false;
	std::vector<int> valor_monedas(num_monedas);
	std::vector<int> cantidad_monedas(num_monedas);
	for (int i = 0; i < num_monedas; i++) {
		std::cin >> valor_monedas[i];
	}

	for (int i = 0; i < num_monedas; i++) {
		std::cin >> cantidad_monedas[i];
	}

	std::cin >> valor;
	std::vector <int> result = resuelve(valor_monedas, cantidad_monedas, valor);
	/*if (result[0] == INF) {
		std::cout << "NO" << "\n";
	}
	else {
		std::cout << "SI ";
		for (int i = 1; i < result.size();i++) {

			std::cout << result[i];
			if (i != result.size() - 1) std::cout << " ";
		}
		std::cout << "\n";
	}
	*/
	return true;
}

int main() {
#ifndef DOMJUDGE
	std::ifstream in("Casos31.txt");
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