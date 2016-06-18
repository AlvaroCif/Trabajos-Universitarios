/* Grupo TAIS17, Benito Álvaro Cifuentes y Rafael Guerra

Para la solución se ha creado un método nuevo en la clase TreeMapRango que recorre desde la raiz sus hijos
dependiendo si el valor de estos esta contemplado entre los valores de las claves limites, es decir, si el hijo
izquierdo es menor que la clave limite inferior, lo ignora. Para conseguir el orden de salida, primero se pregunta
al hijo izquierdo, despues al nodo actual, y finalmente al hijo derecho.

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

/* Resuelve un caso de prueba, leyendo de la entrada la
configuracion, y escribiendo la respuesta

El coste en el caso peor, se estima que es lineal ya que es necesario comprobar todos los hijos.
O(f(N)) siendo N el número de nodos que tiene el árbol

*/

void resuelveCaso(int numElem) {
	auto arbol = leerArbol(numElem);
	int clave_mayor = 0;
	int clave_menor = 0;

	std::cin >> clave_menor;
	std::cin >> clave_mayor;

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
