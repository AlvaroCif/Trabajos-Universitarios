/* Benito Álvaro Cifuentes de la Torre y Rafael Guerra Grupo TAIS 17

Para resolver el problemas de las monedas limitadas, es necesario, tener siempre en cuenta que no siempre se pueden usar todas las que se quieran. Para ello, se comprobará
para cada valor si usando todas las posibles cantidades de monedas de nuevo tipo obtenemos un menor numero de monedas respecto a la solución dada para el valor sin tener este
tipo de moneda. Para reconstruir la solución, se ha usado otra matriz auxiliar donde se guarda en cada casilla el número de monedas del tipo en el que nos encontremos que se 
han usado para llegar hasta ese valor.

El algoritmo tiene un coste en tiempo cúbico, por la presencia de los tres bucles anidados (tipos de monedas,valor y cantidades)

El algoritmo tiene un coste cuadrático respecto al espacio, ya que es necesaria una matriz de dos dimensiones para ir guardando las soluciones y otra para ayudar a la
reconstrucción de la solución.

Definición de la recursión: Monedas(i,j) = Número de monedas mínimas usando monedas desde el primer tipo hasta i, para pagar j, INF si no se puede.

Recursión:	Monedas[0][0] = 0.
			Monedas[i][j] = {	monedas[i-1][j] if Valores[i] > j
						  else			min ( monedas(i - 1, j - k*Valores[i] ) + k)
									0 <= k <= Cantidades[i]
*/

#include <fstream>
#include <iostream>
#include <vector>
#include <algorithm>
#include "Matriz.h"
const int INF = 2000000000;

void calcularMonedas(Matriz<int> &mapa,std::vector<int> &valor_monedas, int valor, int tipo_moneda,std::vector<int> &resultado) {
	
	if (valor == 0) {

	}
	else {
		if (valor_monedas[tipo_moneda] <= valor) {
			int k = mapa[tipo_moneda][valor];
			resultado[tipo_moneda] = k;
			calcularMonedas(mapa, valor_monedas, valor - k*valor_monedas[tipo_moneda], tipo_moneda- 1, resultado);
		}
		else {
			calcularMonedas(mapa, valor_monedas, valor, tipo_moneda - 1, resultado);
		}
	}
}

std::vector<int> resuelve(std::vector<int>& valor_monedas, std::vector<int>& cantidad_monedas, int valor) {
	int n = valor_monedas.size();
	valor_monedas.insert(valor_monedas.begin(), 0);
	cantidad_monedas.insert(cantidad_monedas.begin(), 0);
	std::vector<int> resultado(valor_monedas.size(), 0);
	Matriz<int> matriz(valor_monedas.size(), valor + 1, INF);
	Matriz<int> mapa(valor_monedas.size(), valor + 1,-1);
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
							mapa[i][j] = k;
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
	if (matriz[cantidad_monedas.size() - 1][valor] < INF) {
		calcularMonedas(mapa, valor_monedas, valor, cantidad_monedas.size() - 1, resultado);
	}
	else {
		resultado[0] = INF;
	}
	/*for (int i = 0; i < cantidad_monedas.size();i++) {
		for (int j = 0; j <= valor;j++) {
			std::cout << mapa[i][j] << "|\t";
		}
		std::cout << "\n";
	}
	*/

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
	if (result[0] == INF) {
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