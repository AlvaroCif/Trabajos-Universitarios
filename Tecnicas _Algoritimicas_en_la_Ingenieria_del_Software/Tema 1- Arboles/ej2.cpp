/* Grupo TAIS17, Benito Álvaro Cifuentes

Para comprobar si un arbol es equilibrado o no, simplemente se comprueba recursivamente si el hijo izquierdo tiene la misma altura que el derecho
permitiendo una diferencia de 1

A eso se le suma que para ser AVL sus hijos izquierdos en caso de tenerlos deberán ser menores que la raiz, y para los hijos derechos, sucede el mismo con la diferencia de que tendrán
que ser mayores que la raiz
*/
#include <algorithm>
#include <iostream>
#include "BinTree.h"
#include <math.h>


bool equilibrado(BinTree<int> const& arbol);
bool avl(BinTree<int> const& arbol);

// lee un árbol binario de la entrada estándar
BinTree<int> leerArbol() {
	int raiz;
	std::cin >> raiz;
	if (raiz == -1) { // es un árbol vacío
		return{};
	}
	else { // leer recursivamente los hijos
		auto iz = leerArbol();
		auto dr = leerArbol();
		return{ iz, raiz, dr };
	}
}




// dado un árbol binario, calcula su altura
// lineal en el número N de nodos del árbol, O(N)
int altura(BinTree<int> const& arbol) {
	if (arbol.empty()) {
		return 0;
	}
	else {
		return 1 + std::max(altura(arbol.left()), altura(arbol.right()));
	}
}



//Cuadrático ya que para cada elemento se deben comprobar todos sus elementos hijos .
//O(f(N^2)) siendo N el número de elementos del árbol.
void resuelveCaso() {
	auto arbol = leerArbol();
	if (equilibrado(arbol) && avl(arbol)) {
		std::cout << "SI" << "\n";
	}
	else {
		std::cout << "NO" << "\n";
	}

}

bool avl(BinTree<int> const& arbol) {

	if (arbol.empty()) return true;
	else {
		BinTree<int>::Iterator it_iz = arbol.left().begin();
		while (it_iz != arbol.left().end()) {
			if (arbol.root() <= *it_iz) return false;
			it_iz++;
		}

		BinTree<int>::Iterator it_dr = arbol.right().begin();
		while (it_dr != arbol.right().end()) {
			if (arbol.root() >= *it_dr) return false;
			it_dr++;
		}

		return (avl(arbol.right()) && avl(arbol.left()));
	}
}
bool equilibrado(BinTree<int> const& arbol) {
	if (arbol.empty()) {
		return true;
	}
	else {
		if (equilibrado(arbol.left()) && equilibrado(arbol.right()) && abs(altura(arbol.left()) - altura(arbol.right())) <= 1) {
			return true;
		}
		else return false;
	}
}

int main() {
	int numCasos;
	std::cin >> numCasos;
	for (int i = 0; i < numCasos; ++i)
		resuelveCaso();

	return 0;
}