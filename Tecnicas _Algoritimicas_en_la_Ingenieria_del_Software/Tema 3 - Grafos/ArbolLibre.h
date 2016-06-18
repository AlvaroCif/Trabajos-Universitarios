#include <algorithm>
#include <iostream>
#include <vector>
#include "Grafo.h"

class ArbolLibre {
private:
	std::vector<int> vector;
	int nodos_recorridos = 0;
	int aristas_pasadas = 0;
	// quizás otros atributos
public:
	/** Constructor:  */
	ArbolLibre(Grafo const& G);
};