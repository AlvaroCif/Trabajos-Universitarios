/*Benito Álvaro Cifuentes y Rafael Guerra TAIS 17
El principal problema es asignar a las ciudades que deben ser defendidas el equipo minimo para que puedan defender la ciudad con éxito.
Para ello se ha hecho una ordenación de mayor a menor de los atacantes y defensores, de forma que se compara el mejor equipo atacante, con los mejores equipos defensores,
de este modo, si el mejor equipo de defensores no puede con el mejor equipo de atacantes, se da por perdida esa ciudad, y se compara el siguiente mejor grupo de atacantes 
con el anterior grupo de defensores. En caso de que los defensores puedan con los atacantes, se mandan a salvar la ciudad, y a eliminar a los atacantes que ya bastante daño
han hecho en nuestra querida patria.

Para resolver el algoritmo, primero se deben ordenar dos vectores de tamaño N -> 2 * (N log N) siendo N el número de ciudades, y despues se hace un recorrido de la solución
con coste lineal.

Coste total: N log N.
*/

#include <iostream>
#include <algorithm>
#include <vector>
#include <functional>
#include <fstream>
#include <sstream>
/*Ordenar dos vectores 2 * (nlogn)
Recorrer el vector n
*/
int resuelve(std::vector<int> &atacantes,std::vector<int> &defensores) {
	//Ordenamos el vector
	std::sort(atacantes.begin(), atacantes.end(), std::greater<int>());
	std::sort(defensores.begin(), defensores.end(), std::greater<int>());

	int ciudades_defendidas = 0;
	for (int i = 0; i < atacantes.size();i++) {
		if (atacantes[i] <= defensores[ciudades_defendidas]) ciudades_defendidas++;
	}
	return ciudades_defendidas;
}
bool resuelveCaso() {
	int ciudades;
	std::cin >> ciudades;
	if (!std::cin) return false;
	std::vector<int> atacantes(ciudades); std::vector<int> defensores(ciudades);
	int aux;
	for (int i = 0; i < ciudades; i++) {
		std::cin >> aux;
		atacantes[i] = aux;
	}
	for (int j = 0; j < ciudades; j++) {
		std::cin >> aux;
		defensores[j] = aux;
	}

	int resultado = resuelve(atacantes, defensores);
	std::cout << resultado << "\n";
	return true;
}

int main() {

#ifndef DOMJUDGE
		std::ifstream in("casos21.txt");
		auto cinbuf = std::cin.rdbuf(in.rdbuf()); //save old buf and redirect std::cin to casos.txt
#endif

		while (resuelveCaso());

#ifndef DOMJUDGE
		std::cin.rdbuf(cinbuf);   //reset to standard input again
		system("PAUSE");
#endif

	return 0;
}