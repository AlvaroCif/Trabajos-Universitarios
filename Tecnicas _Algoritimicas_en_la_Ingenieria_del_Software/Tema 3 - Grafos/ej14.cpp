/* Grupo TAIS17, Benito Álvaro Cifuentes y Rafael Guerra
El principal reto en este problema es una correcta construcción del grafo, para ello utilizaremos una estructura auxiliar de un vector multidimensional de 
valores booleanos, que nos indicará en que posiciones se encuentra la mancha. Para crear el grafo, se buscará si la propia posición es una mancha, y de ser
así se comprobaran las posiciones adyacentes creando aristas si hay manchas a los alrededores.

Una vez creado el grafo, se hace un recorrido en profundidad de cada componente (recorriendo en orden los nodos hasta encontrar un nodo por el que aun no se haya pasado)
guardando en una variable si se alcanza un tamaño de componente conexa mayor ahorrandonos un recorrer el vector que guarda los tamaños de las componentes conexas.

Se estima un coste de E+V siendo E el numero de aristas y V el numero de vertices ya que siempre se van a recorrer todas las aristas y todos los vértices.
*/

#include <algorithm>
#include <iostream>
#include <vector>
#include <string>
#include "Grafo.h"
#include "Mayor_componente.h"


// lee un grafo de la entrada estandar, primero recibe el número de aristas y vertices, y despues recibe una arista en cada línea.
Grafo leerGrafo(int dimension1, int dimension2) {
	bool hay_mancha = false;
	std::vector<std::vector<bool> > vector(dimension1, std::vector<bool>(dimension2,false));
	std::string cadena;

	std::getline(std::cin, cadena);			//Me llevo el salto de linea
	for (int i = 0; i < dimension1; i++) {
		std::getline(std::cin, cadena);
		for (int j = 0; j < dimension2;j++) {
			if (cadena.at(j) == '#') {
				vector.at(i).at(j) = true;
			}
		}
	}

	Grafo g = Grafo(dimension1 * dimension2);
	for (int i = 0; i < dimension1; i++) {
		for (int j = 0; j < dimension2;j++) {
			if (vector.at(i).at(j)) {
				hay_mancha = true;
				//Se realizan solo 2 comprobaciones para no volver a añadir aristas, en este caso elegiremos hacia la derecha y abajo.
			//	if (i - 1 >= 0 && vector.at(i - 1).at(j)) g.ponArista(i*dimension2 + j, (i - 1)*dimension2 + j);//Si esta encima
				if (i + 1 < dimension1 && vector.at(i + 1).at(j))  g.ponArista(i*dimension2 + j, (i + 1)*dimension2 + j); //Si esta debajo
			//	if (j - 1 >= 0 && vector.at(i).at(j - 1)) g.ponArista(i*dimension2 + j, i*dimension2 + (j - 1)); //Si esta a la izquierda
				if (j + 1 < dimension2 && vector.at(i).at(j + 1)) g.ponArista(i*dimension2 + j, (i*dimension2) + j + 1); //Si esta a la derecha
			}
		}
		
	}
	//En caso de que no haya habido ninguna mancha, devuelvo un grafo vacio.
	if (hay_mancha)return g;
	else{
		Grafo vacio = Grafo(0);
		return vacio;
	}
}

bool resuelveCaso() {
	int dimension1 = 0, dimension2 = 0;
	std::cin >> dimension1;
	std::cin >> dimension2;
	if (!std::cin) return false;
	auto grafo = leerGrafo(dimension1,dimension2);
	Mayor_componente aux = Mayor_componente(grafo);
	std::cout << aux.max_tam() << "\n";
	return true;
}

int main() {
	while (resuelveCaso());
	return 0;
}