/* Grupo TAIS17, Benito Álvaro Cifuentes

Para la solución se ha utilizado un arbol rojinegro que tiene como clave una palabra, y como valor un vector de enteros que indica las frases en
la que se encuentra las frases.

*/
#include <algorithm>
#include <iostream>
#include <string>
#include <vector>
#include "TreeMap_RB.h"
#include <iostream>
#include <sstream>


void mostrarSolucion(TreeMap<std::string, std::vector<int>> arbol) {
	TreeMap<std::string, std::vector<int>>::Iterator it = arbol.begin();

	while (it != arbol.end()) {
		std::cout << it.clave();
		std::vector<int> aux = it.valor();
		for (int i = 0;i < aux.size();++i) {
			std::cout << " " << aux[i];
		}
		std::cout << "\n";
		it++;
	}
	std::cout << "----" << "\n";
}

//La solución es muy simple, ya que una vez acabado el arbol, solo hay que recorrer cada elemento y despues recorrer el vector.
//En todos los casos se estima que el coste es O(f(n)) siendo n el numero de palabras mayores de dos letras que se introduzcan por consola.
void resuelveCaso(int numElem) {

	TreeMap<std::string, std::vector<int>> arbol;
	std::string cadena;

	std::getline(std::cin, cadena); //Lectura para quitar el salto de linea
	for (int i = 0; i < numElem;i++) {
		std::getline(std::cin, cadena);	//Lectura que sobrescribe el salto de linea y se queda con la frase de verdad

		std::istringstream iss(cadena);

		do {
			std::string sub;
			iss >> sub;

			if (sub.length() > 2) {
				std::transform(sub.begin(), sub.end(), sub.begin(), ::tolower); //Transformamos todos los caracteres a minúsculas porque no sabemos donde puede estar la mayuscula

				if (arbol.contains(sub)) {
					std::vector<int> aux = arbol.at(sub);

					if (aux[aux.size() - 1] != i+1) {		//Si la palabra se ha encontrado ya en la frase, se ignora.
						aux.push_back(i + 1);
						arbol.insert(sub, aux);
					}
				}
				else {
					std::vector<int> aux1;
					aux1.push_back(i + 1);
					arbol.insert(sub, aux1);
				}
			}

		} while (iss);
	}

	mostrarSolucion(arbol);
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
