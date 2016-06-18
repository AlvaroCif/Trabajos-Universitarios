/* Grupo TAIS17, Benito Álvaro Cifuentes y Rafael Guerra

Para resolver el problema de la entrega de paquetes, se ha realizado dos veces el algoritmo de dijkstra, la primera, obteniendo el grafo de 
recubrimiento mínimo partiendo como origen la sede central de correos, este grafo nos permite saber la distancia minima a todos los nodos(si son
conexos claro) desde la sede, para el camino de vuelta, se ha invertido el grafo y se ha vuelto a aplicar otro dijkstra, esta vez, este grafo nos
representa la distancia minima de todas las casas hasta la sede, lo que es perfecto para la resolución del ejercicio.

Una vez hecho eso, simplemente para cada paquete que entregar a cada casa, se pregunta cuanto es el camino de ida y cuanto es el de vuelta, y si en
algunos de ellos no se puede alcanzar la sede o la casa (dependiendo de cual de los dos sea) se determina que es imposible realizar el reparto.

Se estima un coste de E log V para cada ejecución del algoritmo de dijkstra y despues se debe conseguir la distancia a recorrer para cada paquete.
Por lo que 2(ElogV) + V-> ElogV + V
*/

#include <vector>
#include <iostream>
#include "GrafoDirigidoValorado.h"
#include "clase17.h"

GrafoDirigidoValorado<int> leerGrafo(int nodos, int aristas){
	GrafoDirigidoValorado<int> g = GrafoDirigidoValorado<int>(nodos);
	int origen, destino, peso;
	for (int i = 0; i < aristas; i++){
		std::cin >> origen >> destino >> peso;
		origen--; destino--;
		AristaDirigida<int> a = AristaDirigida<int>(origen,destino, peso);
		g.ponArista(a);
	}
	return g;
}
bool resuelve(){
	int numero_casas, numero_conexiones;
	std::cin >> numero_casas;
	if (!std::cin) return false;
	std::cin >> numero_conexiones;

	auto grafo = leerGrafo(numero_casas, numero_conexiones); //Se lee todo el grafo...
	int sede_correos, numero_paquetes;
	std::cin >> sede_correos >> numero_paquetes;
	sede_correos--;

	int lugar_a_entregar_paquete;
	std::vector<int> lugares_a_entregar = std::vector<int>(numero_paquetes);
	for (int i = 0; i < numero_paquetes;i++) {
		std::cin >> lugar_a_entregar_paquete;
		lugar_a_entregar_paquete--;
		lugares_a_entregar.at(i) = lugar_a_entregar_paquete;
	}
	//Ejecuta el algoritmo de Dijkstra dos veces por lo que 2 * (E + V) -> E + V siendo E el numero de aristas y v el numero de vertices
	clase17 aux = clase17(grafo, lugares_a_entregar, sede_correos);
	if(!aux.getInalcanzable()) std::cout << aux.getCoste() << "\n";
	else std::cout << "Imposible" << "\n";

	return true;
}
int main(){
	while (resuelve()){

	}

	return 0;
}