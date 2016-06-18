/* Grupo TAIS17, Benito �lvaro Cifuentes y Rafael Guerra

Para comprobar si un arbol es equilibrado o no, simplemente se comprueba recursivamente si el hijo izquierdo tiene la misma altura que el derecho
permitiendo una diferencia de 1
*/
#include <algorithm>
#include <iostream>
#include "BinTree.h"
#include <math.h>


bool equilibrado(BinTree<int> const& arbol);

// lee un �rbol binario de la entrada est�ndar
BinTree<int> leerArbol() {
	char raiz;
	std::cin >> raiz;
	if (raiz == '.') { // es un �rbol vac�o
		return{};
	}
	else { // leer recursivamente los hijos
		auto iz = leerArbol();
		auto dr = leerArbol();
		return{ iz, 0, dr };
	}
}



// dado un �rbol binario, calcula su altura
// lineal en el n�mero N de nodos del �rbol, O(N)
int altura(BinTree<int> const& arbol) {
	if (arbol.empty()) {
		return 0;
	}
	else {
		return 1 + std::max(altura(arbol.left()), altura(arbol.right()));
	}
}



//Lineal en el n�mero de elementos ya que en caso de ser equilibrado hay que comprobar todos los nodos O(f(N)) siendo N el n�mero de elementos del �rbol.
void resuelveCaso() {
	auto arbol = leerArbol();

	if (equilibrado(arbol)) {
		std::cout<<(arbol.left().root());
		std::cout << "SI" << "\n";
	}
	else {
		std::cout << "NO" << "\n";
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