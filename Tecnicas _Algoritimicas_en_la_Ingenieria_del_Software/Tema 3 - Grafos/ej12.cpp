/* Grupo TAIS17, Benito Álvaro Cifuentes y Rafael Guerra
Para comprobar si un arbol es arborescencia, se debe encontrar primero un nodo raiz, al cual no le lleguen ninguna arista, para que se trate de una arborescencia.
este nodo debe ser único (ya que sino no se podría llegar hasta el desde la anterior raiz).

Una vez elegida y comprobado que se trata de la unica posible raiz, se realiza un recorrido en profundidad, en el que se deben alcanzar el resto de nodos del grafo.
Si es asi, se trata de una arborescencia, en caso contrario no lo es.
*/

#include <algorithm>
#include <iostream>
#include <vector>
#include "GrafoDirigido.h"
// lee un grafo de la entrada estandar, primero recibe el número de aristas y vertices, y despues recibe una arista en cada línea.
GrafoDirigido leerGrafo(int numero_vertices, int numero_aristas) {

	int nodo_origen = 0;
	int nodo_destino = 0;

	GrafoDirigido g = GrafoDirigido(numero_vertices);
	for (int i = 0; i < numero_aristas; i++) {

		std::cin >> nodo_origen;
		std::cin >> nodo_destino;

		g.ponArista(nodo_origen, nodo_destino);
	}
	return g;
}
//Recorrido en profundidad desde la posible raiz, si se recorren todos los nodos, el valor de es_arb se mantendra a true, si por el contrario, se visita 
//algun nodo ya recorrido, será false.
void arb_aux(const GrafoDirigido &g, int nodo_actual, int &nodos_recorridos, std::vector<int> &recorrido, bool &es_arb) {
	nodos_recorridos = nodos_recorridos + 1;
	recorrido.at(nodo_actual) = nodos_recorridos;

	for (int aux : g.adj(nodo_actual)) {
		if (recorrido.at(aux) == 0) arb_aux(g, aux, nodos_recorridos, recorrido,es_arb);
		else es_arb = false;
	}
}
//Determina si un grafo es arborescencia o no
//Se hace una primera selección de coste lineal recorriendo los adyacentes del grafo inicial invertido (lo que corresponderia a los grados de adyacencia)
//La operación de inversión tiene coste cuadrático, se podria evitar recorriendo todas las listas de adyacentes, pero también tendría coste cuadrático y asi se simplifica el codigo.
//La función tiene un coste lineal ya que para cada vértice se consiguen todas sus aristas, y se recorren todos los nodos conectados, haciendo lo mismo con estos.
//y siempre evitando volver a pasar por un nodo que ya hayamos recorrido con anterioridad.
// O(f(N)) siendo N el número de nodos 
int arbolescencia(const GrafoDirigido &g) {
	std::vector<int> vector;
	int nodos_recorridos = 0, numero_de_nodos = g.V(),contador_de_raices = 0, raiz = 0;
	GrafoDirigido ginv = g.reverse();
//Consultando el inverso del arbol, podemos ver rapidamente si hay algún nodo al que no le llegue ninguna arista
	for (int j = 0; j < numero_de_nodos;j++) {
		if (ginv.adj(j).size() == 0) {
			contador_de_raices++;
			raiz = j;
		}
	}

	if (contador_de_raices == 1) {
		//inicializamos el vector con todos los valores a 0
		for (int i = 0; i < numero_de_nodos;i++) {
			vector.push_back(0);
		}
		bool aux = true;
		arb_aux(g, raiz, nodos_recorridos, vector, aux);
		if (nodos_recorridos == numero_de_nodos && aux) return raiz;
	}
	return -1;
}
// Resuelve un caso de prueba, leyendo de la entrada la
// configuracion, y escribiendo la respuesta
bool resuelveCaso() {
	int vertices = 0, aristas = 0;
	std::cin >> vertices;
	if (!std::cin) return false;
	std::cin >> aristas;
	auto grafo = leerGrafo(vertices, aristas);

	int raiz = arbolescencia(grafo);
	if (raiz != -1) {
		std::cout << "SI" << " " << raiz << "\n";
	}
	else {
		std::cout << "NO" << "\n";
	}

	return true;

}
int main() {
	while (resuelveCaso());
	return 0;
}