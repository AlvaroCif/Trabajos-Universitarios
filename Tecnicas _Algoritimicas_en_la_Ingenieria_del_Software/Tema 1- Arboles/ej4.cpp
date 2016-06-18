/* Grupo TAIS17, Benito Álvaro Cifuentes y Rafael Guerra

Para la solución se ha han modificado las operaciones de insertar, de rotar a la derecha
y de rotar a la izquierda para que tengan en cuenta el valor de tam_i, tambien se ha tenido en cuenta
que en caso de estar la clave ya introducida no se deben efectuar estas modificaciones.

El método que lo resuelve se simplifica mucho ya que para encontrar el k elemento, comprobamos si tenemos
mas o menos elementos en el hijo izquierdo, si es el caso llamamos recursivamente al método con el hijo izquierdo
sin alterar el valor de k, si k coincide con el numero de elementos, estamos en el nodo a devolver, y si por el contrario
debemos ir al hijo derecho, haremos la llamada recursiva restandole a k el número de elementos del hijo izq

*/
#include <algorithm>
#include <iostream>
#include "TreeMap_AVL_tami.h"
// lee un árbol por la entrada estandar
TreeMap<int, int> leerArbol(int numElem) {
	int clave;
	TreeMap<int, int> arbol;
	for (int i = 0; i<numElem; i++) {
		std::cin >> clave;

		arbol.insert(clave, 0);
	}
	return arbol;
}

/* 
El coste en el caso peor, se estima que es logaritmico ya que es necesario comprobar al menos una rama completa en el peor de los casos.
O(f(log N)) siendo N el número de nodos que tiene el árbol.

*/

void resuelveCaso(int numElem) {
	int clave_de_busqueda = 0;
	int numero_de_claves = 0;
	int respuesta = 0;
	auto arbol = leerArbol(numElem);
	std::cin >> numero_de_claves;
	for (int i = 0; i<numero_de_claves; i++){
		std::cin >> clave_de_busqueda;
		respuesta = arbol.k_elem(clave_de_busqueda);
		if (respuesta != -1) std::cout << respuesta << "\n";
		else std::cout << "??" << "\n";
	}
	std::cout << "----" << "\n";
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