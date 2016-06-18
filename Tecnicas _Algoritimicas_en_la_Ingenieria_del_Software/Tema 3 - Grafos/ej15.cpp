/* Grupo TAIS17, Benito Álvaro Cifuentes y Rafael Guerra
El mayor problema vuelve a ser dar una interpretación lógica al problema y trasladarla a una estructura de datos, para este caso, se utiliza una variación
de la implementación de conjuntosdisjuntos, donde simplemente se almacena en una variable el tamaño maximo, y cada vez que se unen dos componentes, se pregunta
si el tamaño de la unión es mayor, y de ser asi se actualiza el valor.

Para la representación se usa un vector de vectores con valores boolean, de forma que se puede representar una cuadricula, de tal forma que si una casilla
esta marcada a true, se considera que hay una mancha, esta representación se ha trasladado a un conjuntodisjunto que tiene tantos nodos como valores el vector
de vectores, dejando que la representación de una mancha quede dividida en un propio conjunto.

Al utilizar esta implementación de conjuntosdisjuntos se reducen al máximo los costes de operar con esta estructura, ya que almacena el tamaño en su propio vector.

El coste estimado es de V + M, donde V es el número de casillas o dicho de otro modo, la multiplicación de las dimensiones del tablero, y M son el número de
operaciones de pintado de manchas que se hacen.
*/

#include <iostream>
#include <vector>
#include <string>
#include"MayorComponenteCreciente.h"
#include "clase15.h"
//Coste de crear la estructura V siendo V dimension1*dimension2
//Coste de crear estructuras auxiliares V siendo V dimension1*dimension2
//Coste de unir constante, y en el caso peor se puede unir V veces --> V * const --> 
//Coste de dameTamMax constante.
//Coste total V

bool resuelveCaso() {
	int dimension1 = 0, dimension2 = 0;
	std::cin >> dimension1; std::cin >> dimension2;
	if (!std::cin) return false;
	clase15 aux(dimension1, dimension2);
	int entradas, posicioni, posicionj;
	std::cin >> entradas;
	for (int i = 0; i < entradas; i++) {		//Coste M siendo M el número de nuevas entradas.
		std::cin >> posicioni, std::cin >> posicionj;
		posicioni--;posicionj--;
		aux.addArista(posicioni,posicionj);

		std::cout << aux.dameMax();
		if (i != entradas - 1) {
			std::cout << " ";
		}
	}
	std::cout << "\n";

	return true;
}
int main() {
	while (resuelveCaso()) {

	}
	return 0;
}