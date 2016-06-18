/* Grupo TAIS17, Benito Álvaro Cifuentes y Rafael Guerra

Para resolver el problema se utiliza una cola de prioridad de mínimos y otra cola de máximos, de tal forma que en la cola de máximos guardamos a nivel
conceptual todos los pajaros con menor edad que el pajaro central y en la cola de mínimos los que son mayores que el, de esta forma, podremos acceder en un
buen tiempo al pajaro central, y en caso de la llegada de nuevos pajaros, decidiremos en que grupo meterle o si debe ser el pajaro central. Para mantener
los tamaños de las pilas despues de cada inserción realizaremos la operación equilibra y moverá los pajaros en caso de ser necesario.

El pajaro central en esta implementación del problema se trata del nodo en lo alto del monticulo de maximos.

*/
#include <algorithm>
#include <iostream>
#include <vector>
#include "Bandada.h"
#include "PriorityQueue.h"


//En este método leemos y procesamos todas las parejas de un caso, y actualizamos las colas para mantener el orden lógico de los pajaros.
//El coste por la operación de resuelveCaso es de aproximadamente N*log N, ya que se hacen N inserciones siendo N el número de elementos.
//A lo que habría que sumar operaciones en el método equilibra, que efectua operaciones de coste (log N) N veces.
// O(N*log N) siendo N el número de pajaros de la bandada.
void resuelveCaso(long long pajaro_inicial, int numero_parejas) {
	int valor = -1;
	long long aux;
	Bandada bandada = Bandada(pajaro_inicial);

	for (int i = 0; i < numero_parejas; i++) {
		for (int j = 0; j < 2;j++) {
			std::cin >> aux;
			
			bandada.insertar(aux);
		}
		std::cout << bandada.edadGaviota();
		if (i != numero_parejas - 1) {
			std::cout << " ";
		}
	}
	std::cout << "\n";
}
int main() {

	long long pajaro_inicial = -1;
	int numero_de_parejas = -1;
	std::cin >> pajaro_inicial;
	std::cin >> numero_de_parejas;
	while (pajaro_inicial != 0 && numero_de_parejas != 0) {
		resuelveCaso(pajaro_inicial,numero_de_parejas);

		std::cin >> pajaro_inicial;
		std::cin >> numero_de_parejas;
	}
	return 0;
}
