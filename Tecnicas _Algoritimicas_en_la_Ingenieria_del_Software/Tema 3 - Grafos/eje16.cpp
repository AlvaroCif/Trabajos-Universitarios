/* Grupo TAIS17, Benito Álvaro Cifuentes y Rafael Guerra

Para resolver el problema de la pavimentación, la clave está en siempre buscar las calles que menor coste tienen y que a la vez pavimenta dos intersecciones
para ello, nos basta simplemente con ir seleccionando siempre la calle de menor coste, y comprobar si ya estan pavimentados las dos intersecciones de los extremos
de la calle, en caso de que lo estén, se ignora y si no lo están, pues se añade el coste de la calle y añadimos su coste al actual.
Para la implementación del problema se ha decidido usar el algoritmo de Prim (que funciona perfecto para este caso).

Se estima un coste de E*log E + V (prim E*log E + V). Siendo E el numero de aristas y V el de vértices.
*/

#include <iostream>
#include <algorithm>
#include "GrafoValorado.h"
#include "prim.h"

GrafoValorado<int> crearGrafoValorado(const int numVertices, const int numAristas);

int main(){
	int numNodos = 0, numAristas = 0;

	while(std::cin >> numNodos){
		std::cin >> numAristas;
		
		GrafoValorado<int> grafoVal = crearGrafoValorado(numNodos,numAristas);

		Prim calPrim(grafoVal);													
		//Una única ejecución del algoritmo de Prim mas una comprobación de si estan todos los nodos marcados E*logE + V
		

		if(!calPrim.getPosible())
			std::cout << "Imposible" << std::endl;
		else
			std::cout<< calPrim.getCost()<< std::endl;

	}
	return 0;
}

GrafoValorado<int> crearGrafoValorado(const int numVertices, const int numAristas){
	
	//std::cout << numVertices << " - " << numAristas << std::endl;
	
	GrafoValorado<int> g(numVertices);
	
	for(unsigned int i = 0; i < numAristas; i++){
		int vert1 = 0, vert2 = 2, valor = 0;
		std::cin >> vert1;
		std::cin >> vert2;
		std::cin >> valor;
		
		Arista<int> arista(vert1 - 1,vert2 - 1,valor);

		g.ponArista(arista);
	}

	return g;
}
