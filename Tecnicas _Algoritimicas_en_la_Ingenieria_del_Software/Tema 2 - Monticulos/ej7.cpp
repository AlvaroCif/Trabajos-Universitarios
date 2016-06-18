/* Grupo TAIS17, Benito Álvaro Cifuentes Y Rafael Guerra

Se utiliza una cola de prioridad que siempre nos dará el elemento mínimo, para calcular el coste mínimo, siempre se utilizarán los dos operandos
mas bajos, de forma que en cada suma logica, nosotros extraeremos dos elementos de la cola y sumaremos su coste, volviendo despues a insertar el resultado
de la suma de estos dos operandos. El algoritmo finalizará cuando en la cola quede un solo elemento.

*/
#include <algorithm>
#include <iostream>
#include <vector>
#include "PriorityQueue.h"

//Realiza N-1 iteraciones siendo N el número de elementos de la cola y en cada iteración elimina dos elementos e inserta uno, dando lugar a un coste
// parecido a (n-1) * (3 * log n) -> O(N*logN)
void resuelve(PriorityQueue<long long> &cola) {
	long long resultado = 0;
	long long operando1 = 0, operando2 = 0;
		while (cola.size() >= 2) {
		operando1 = cola.top();
		cola.pop();

		operando2 = cola.top();
		cola.pop();

		resultado = resultado + (operando1 + operando2);
		cola.push(operando1 + operando2);
	}
	std::cout << resultado << "\n";
}

//En este método creamos la cola (coste O(N*log N) siendo N el número de elementos de la cola) y llamamos a la funcion resuelve que trabaja con la cola ya creada.
void resuelveCaso(int numElem) {
	int valor = -1;
	PriorityQueue<long long> cola;
	for (int i = 0; i < numElem;i++) {
		std::cin >> valor;
		cola.push(valor);
	}
	resuelve(cola);
	
}
int main() {

	int numElem = -1;
	std::cin >> numElem;
	while (numElem != 0) {
		resuelveCaso(numElem);
		std::cin >> numElem;
	}
	return 0;
}
