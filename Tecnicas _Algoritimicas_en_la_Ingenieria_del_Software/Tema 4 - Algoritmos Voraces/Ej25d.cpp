/* Benito Álvaro Cifuentes de la Torre y Rafael Guerra Grupo TAIS 17
Para resolver el problema del trabajo mínimo de los aliens, hay que tener muchas cosas en cuenta, la principal es saber cuando se puede o no se puede cubrir el area de
trabajo, se puede cubrir en caso de que sea capaz de llegar usando todos los trabajos que hagan falta desde la feha de inicio hasta la de final.
La estrategia seguida para la resolución una vez dejado el anterior concepto claro, es sencilla, en caso de que podamos llegar hasta la fecha de inicio, seleccionamos
de todos los posibles trabajos uno que empiece antes o justo en el momento de la fecha de inicio y que a la vez sea el que su hora de finalización se aleje mas de la fecha de inicio
,una vez seleccionado este, se vuelve a ejecutar el mismo procedimiento, y se busca un nuevo trabajo que cumpla que su fecha de inicio sea menor que el mayor alcance, y que a su
vez sea el que mas se aleje de la fecha de finalización.

El coste se ve agrandado por la función de ordenación, ya que el algoritmo recorre solo una vez todas las posibilidades.
Coste: N log N siendo N el número de trabajos totales.
*/

#include <iostream>
#include <vector>
#include <fstream>
#include <algorithm>

struct Trabajo {
	int hora_inicio;
	int hora_final;
};
//Definición del operando < para poder usar la ordenación con estructuras de trabajo.
bool operator<(const Trabajo& x, const Trabajo& y)
{
	bool condicion;
	if (x.hora_inicio < y.hora_inicio) {
		condicion = true;
	}
	else {
		if (x.hora_inicio == y.hora_inicio) condicion = x.hora_final > y.hora_final;
		else {
			condicion = false;
		}
	}
	return condicion;
}
//Función que en coste n log n siendo n el número de trabajos devuelve un entero que representa el numero de trabajos necesarios, o un -1 en caso de que no sea posible.
int resuelve(std::vector<Trabajo>& trabajos, int inicio, int final) {
	int resultado = 0;
	std::sort(trabajos.begin(), trabajos.end());

	Trabajo t, taux;
	bool descartar = true;
	int contador = 0;
	int alcance = inicio;

	while (contador < trabajos.size() && alcance < final) {
		if (trabajos[contador].hora_inicio > alcance && alcance < final) return -1;
		int alcanceaux = alcance;
		resultado++;
		while (contador < trabajos.size() && trabajos[contador].hora_inicio <= alcanceaux) {
			if (trabajos[contador].hora_final > alcance) {
				alcance = trabajos[contador].hora_final;
				t = trabajos[contador];
			}
			contador++;
		}
	}

	if (alcance >= final)return resultado;
	else return -1;
	
}

//Lee de la entrada estandar un caso de prueba e imprime por pantalla el resultado, en caso de ser 0 la fecha de inicio de trabajo, la fecha de final de trabajo y los trabajos
//devuelve false.
bool resuelveCaso() {
	int inicio_trabajo, finalizacion_trabajo, numero_trabajos;

	std::cin >> inicio_trabajo;	std::cin >> finalizacion_trabajo; std::cin >> numero_trabajos;
	if (inicio_trabajo == 0 && finalizacion_trabajo == 0 && numero_trabajos == 0) return false;
	std::vector<Trabajo> trabajos(numero_trabajos);
	Trabajo t;
	int aux1, aux2;
	for (int i = 0; i < numero_trabajos; i++) {
		std::cin >> aux1; std::cin >> aux2;	//Se lee por entrada estandar la hora de inicio y finalización de cada trabajo.
		t.hora_inicio = aux1;	t.hora_final = aux2;
		trabajos[i] = t;
	}

	int resultado = resuelve(trabajos, inicio_trabajo, finalizacion_trabajo);

	if (resultado == -1) std::cout << "Imposible" << "\n";
	else std::cout << resultado << "\n";
	return true;
}


int main() {
#ifndef DOMJUDGE
	std::ifstream in("casos25b.txt");
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