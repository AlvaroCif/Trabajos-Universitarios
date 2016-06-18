/* Grupo TAIS17, Benito Álvaro Cifuentes y Rafael Guerra
El principal reto en este problema es una correcta construcción del grafo, para ello, haremos que cada nodo este conectado a tantos nodos posteriores a el
como caras tenga el dado, además de que si se encuentra el extremo inicial de una serpiente o una escalera en el, en vez de estar conectado a ese nodo, estará
conectado al extremo final de la serpiente o escalera.

Una vez construido el grafo, solo hay que hacer un recorrido en achura, guardando la distancia, para ello se ha adaptado el metodo de recorrido en anchura para 
hacerlo finalizar según se encuentre el nodo final prescindiendo de guardar el posible recorrido y teniendo un atributo que permite el acceso en tiempo constante.

Al ser un recorrido en anchura se estima un coste de E+V que queda normalmente algo reducido al definirlo como una búsqueda hasta el nodo final.
*/

#include <algorithm>
#include <iostream>
#include <vector>
#include "Numero_de_pasos.h"
#include "GrafoDirigido.h"


// lee un grafo de la entrada estandar, primero recibe el número de aristas y vertices, y despues recibe una arista en cada línea.
GrafoDirigido leerGrafo(int dimension, int caras, int serpientes, int escaleras) {
	int tamano_tablero = dimension * dimension;
	std::vector<int> vector = std::vector<int>(tamano_tablero + 1,-1);
	int aux1 = 0, aux2 = 0;
	for (int i = 0; i < serpientes + escaleras; i++){
		std::cin >> aux1;	std::cin >> aux2;
		vector.at(aux1) = aux2;
	}

	GrafoDirigido g = GrafoDirigido(tamano_tablero + 1);
	for (int i = 1; i < tamano_tablero + 1; i++) {
		for (int j = i + 1; j < i +caras + 1; j++){
			if (j < tamano_tablero + 1){
				if (vector.at(j) != -1){
					g.ponArista(i, vector.at(j));
				}
				else g.ponArista(i, j);
			}
		}

	}
	return g;
}

bool resuelveCaso() {
	int dimension = 0, caras = 0, escaleras = 0, serpientes = 0;
	std::cin >> dimension;
	std::cin >> caras;
	std::cin >> serpientes;
	std::cin >> escaleras;
	if (dimension == 0 && caras == 0 && escaleras == 0 && serpientes == 0) return false;
	else{
		auto grafo = leerGrafo(dimension, caras, serpientes, escaleras);
		Numero_de_pasos aux = Numero_de_pasos(grafo);
		std::cout << aux.num_pasos() << "\n";
		return true;
	}

}
int main() {
	while (resuelveCaso());
	return 0;
}