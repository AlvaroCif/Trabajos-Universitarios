/*Benito Álvaro Cifuentes y Rafael Guerra TAIS 17

Para resolver el problema de las pilas, el primer paso a tener en cuenta es la ordenación de estas. Lo que nos añadirá un coste adicional al algoritmo.
Una vez dadas las pilas ordenadas por su voltaje, se intenta juntar la pila con mayor voltaje con la de menor, y en caso de que la suma de voltajes sea
suficiente se coge ese par y se meten en un coche, en caso de que no sean suficientes, se descarta la pila de menor voltaje y se coge la siguiente de menor voltaje.

La función de ordenación tiene un coste N log N siendo n el número de pilas y la resolución del algoritmo una vez ordenada la entrada tiene un coste lineal en el 
número de pilas.

Coste: N log N
*/

#include <iostream>
#include <vector>
#include <algorithm>
#include <functional>
// Ordenar la entrada N log N, resolver el problema N en el peor de los casos, puede llegar a ser N/2 en el mejor, pero de cualquier forma se mantiene lineal.
int resuelve(std::vector<int> &pilas, int voltajeMinimo) {
	std::sort(pilas.begin(), pilas.end(), std::less<int>());

	int indice1 = 0;
	int indice2 = pilas.size() - 1;

	int coches_funcionando = 0;
	while (indice1 < indice2) {
		if (pilas[indice1] + pilas[indice2] >= voltajeMinimo) {
			indice1++; indice2--;
			coches_funcionando++;
		}
		else {
			indice1++;
		}
	}

	return coches_funcionando;
}

void resuelveCaso() {
	int numPilas;
	int voltaje_minimo;
	std::cin >> numPilas;
	std::cin >> voltaje_minimo;
	std::vector<int> pilas(numPilas);

	for (int i = 0; i < numPilas; i++) {
		int aux;	std::cin >> aux;
		pilas[i] = aux;
	}

	int resultado = resuelve(pilas,voltaje_minimo);
	std::cout << resultado << "\n";
}
int main() {
	int numero_de_casos = 0;
	std::cin >> numero_de_casos;
	for (int i = 0; i < numero_de_casos;i++) {
		resuelveCaso();
	}
	return 0;
}