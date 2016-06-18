/*Benito Álvaro Cifuentes y Rafael Guerra TAIS 17

El algoritmo es muy simple, en caso de que haya agujeros, se utiliza el primer parche para tapar el agujero, buscando ponerlo en un extremo para poder recubrir el maximo
de la manguera.

La función de selección escoge el agujero mas cercano al extremo inicial de la manguera que no haya sido recubierto.
En este caso no se descarta ningun agujero con el test de factibilidad, solo se comprueba si se necesita un nuevo parche para recubrirlo.

Tiene un coste lineal en el número de agujeros. -> N siendo N el número de agujeros.
*/

#include <iostream>
#include <vector>
#include <limits>

int resuelve(int tamParche, std::vector<int> agujeros) {
	int parches = 0;
	int distanciaOrigen = 0;

	parches = 1; distanciaOrigen = agujeros[0];
	for (int i = 0; i < agujeros.size(); i++) {
		if (agujeros[i] > distanciaOrigen + tamParche) {
			parches++;
			distanciaOrigen = agujeros[i];
		}
	}
	return parches;
}

bool resuelveCaso() {
	int numAgujeros, tamParche;
	std::cin >> numAgujeros;
	if (!std::cin) return false;
	std::cin >> tamParche;

	std::vector<int> agujeros(numAgujeros);
	for (int i = 0; i < numAgujeros;i++) {
		int aux;
		std::cin >> aux;
		agujeros[i] = aux;
	}
	//La función tiene como precondición que al menos haya un agujero.
	if (numAgujeros > 0) std::cout << resuelve(tamParche, agujeros) << "\n";
	else std::cout << "0" << "\n";
	return true;
}
int main() {
	while (resuelveCaso()) {

	}
	return 0;
}
