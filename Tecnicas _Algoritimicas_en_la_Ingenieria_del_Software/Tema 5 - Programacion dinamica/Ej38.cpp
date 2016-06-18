/* Benito Álvaro Cifuentes de la Torre y Rafael Guerra Grupo 17 tais
Para resolver el problema de los funcionarios tenemos que elegir aquellos trabajos para cada empleado, tales que se cumpla, que la asignación de cada trabajo a cada empleado,
nos da un resultado mínimo, es decir, tenemos que encontrar una permutación del tamaño de los empleados, donde el indice indica el empleado y el valor el trabajo asignado.
														   n
El cálculo de las estimaciones viene dado por est[k] = Sumatorio rapido[i]	donde rapido es: rapido[i] = min{Funcionarios(i,j)}
														i = k + 1										0<=j<n

Por lo que el algoritmo quedaría ya definido, haciendo que cada nodo del arbol, tenga n hijos, y hay un total de n niveles. La poda se realizará cuando el tiempo estimado
no sea mejor que el tiempo mejor que tenemos guardado. Quedandonos de esta forma con el mejor tiempo posible sin tener que explorar todas las soluciones innecesariamente.

El coste del calculo del vector rapido que utilizamos tiene un coste cuadrático. Siendo el de las estimaciones lineal.

Se estima que el coste del algoritmo tiende a ser cúbico, pero se confia en que la función de poda disminuya realmente esta cota.

*/
#include <iostream>
#include <algorithm>
#include <vector>
#include <fstream>

#include "Matriz.h"
const int INF = 2000000000;

void funcionarios_min(Matriz<int>&funcionarios,std::vector<int>& estimaciones,std::vector<int>& solucion,int k,int& tiempo,std::vector<bool>& asignado,std::vector<int>& solucionMejor,int& tiempo_mejor) {
	int n = funcionarios.numcols();
	for (int t = 0; t < n;t++) {
		if (!asignado[t]) {
			solucion[k] = t;
			asignado[t] = true;	tiempo = tiempo + funcionarios[k][solucion[k]];
			int tiempo_estimado = tiempo + estimaciones[k];

			if (tiempo_estimado < tiempo_mejor) {
				if (k == n - 1) {
					solucionMejor = solucion;
					tiempo_mejor = tiempo;
				}

				else {
					funcionarios_min(funcionarios, estimaciones, solucion, k + 1, tiempo, asignado, solucionMejor, tiempo_mejor);
				}
			}
			asignado[t] = false; tiempo = tiempo - funcionarios[k][solucion[k]];
		}
	}
}

std::vector<int> calcularEstimaciones(Matriz<int>& funcionarios) {

	int n = funcionarios.numcols();
	std::vector<int> rapido(n);
	for (int i = 0; i < n; i++) {
		rapido[i] = funcionarios[i][0];
		for (int j = 1; j < n;j++) {
			rapido[i] = std::min(rapido[i], funcionarios[i][j]);
		}
	}

	std::vector<int> estimaciones(n);
	estimaciones[n - 1] = 0;
	for (int i = n - 2; i >= 0; i--) {
		estimaciones[i] = estimaciones[i + 1] + rapido[i+1];
	}

	return estimaciones;
}

int resuelve(Matriz<int>& funcionarios) {
	std::vector<int> estimaciones = calcularEstimaciones(funcionarios);
	int tiempo = 0;
	std::vector<bool> asignado(funcionarios.numcols(), false);
	int tiempo_mejor = INF;
	std::vector<int> solucion(funcionarios.numcols());
	std::vector<int> solucionMejor(funcionarios.numcols());
	funcionarios_min(funcionarios, estimaciones, solucion, 0, tiempo, asignado, solucionMejor, tiempo_mejor);

	int resultado = tiempo_mejor;
	return resultado;
}

bool resuelveCaso() {
	int numFuncionarios = 0;
	std::cin >> numFuncionarios;
	if (numFuncionarios == 0) return false;

	Matriz<int> funcionarios(numFuncionarios, numFuncionarios);

	for (int i = 0; i < numFuncionarios; i++) {
		for (int j = 0; j < numFuncionarios;j++) {
			std::cin >> funcionarios[i][j];
		}
	}

	int resultado = resuelve(funcionarios);
	std::cout << resultado << "\n";
	return true;
}

int main() {
#ifndef DOMJUDGE
	std::ifstream in("Casos38.txt");
	auto cinbuf = std::cin.rdbuf(in.rdbuf()); //save old buf and redirect std::cin to casos.txt
#endif

	while (resuelveCaso()) {

	}
#ifndef DOMJUDGE
	std::cin.rdbuf(cinbuf);   //reset to standard input again
	system("PAUSE");
#endif
	return 0;
}