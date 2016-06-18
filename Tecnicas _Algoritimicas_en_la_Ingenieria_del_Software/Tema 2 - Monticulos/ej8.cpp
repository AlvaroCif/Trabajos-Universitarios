/* Grupo TAIS17, Benito Álvaro Cifuentes
Para la solución del problema, he usado una estructura auxiliar que guarda un número (dolencia) y una vector de cadenas(nombres), he usado la implementación de arbol
que tenemos para ahorrar al maximo los costes de inserción y de búsqueda de forma que siguen siendo operaciones de coste logarítmico.

El algoritmo seguido para resolver el ejercicio es simple, se introducen pacientes en la cola de pacientes(cola de maximos que usa de clave la dolencia) 
y cuando uno vaya a ser atendido, simplemente se saca al primero, y se le atiende. A partir de la dolencia, vemos en el arbol que pacientes tienen esa misma
dolencia, y elegimos el paciente que haya entrado primero, sacandolo de la cola.
*/
#include <algorithm>
#include <iostream>
#include "TreeMap_RB.h"
#include "PriorityQueue.h"
#include <queue>


//El coste de resolver cada caso es de O(N * log N) debido a que se realizan tantas inserciones como pacientes se ingresen y log N es el coste de la inserción
//Siendo N el número de pacientes que se ingresan.
void resuelveCaso(int num_elem) {
	char valor;
	char cadena_aux[20];
	long long dolencia;
	std::string cadena;

	PriorityQueue<long long,std::greater<long long>> cola_pacientes;
	TreeMap<long long, std::queue<std::string>> dolencias_pacientes;

	for (int i = 0;i < num_elem;i++) {
		std::cin >> valor;
		if (valor == 'I') {					//Si recibimos una I...
			std::cin >> cadena_aux;
			cadena = cadena_aux;			//Se leen dos valores, primero una cadena y despues un numero.
			std::cin >> dolencia;

			cola_pacientes.push(dolencia);	//Se guarda en la cola de prioridad la dolencia para saber cuales son las primeras.

			if (dolencias_pacientes.contains(dolencia)) {	//A continuación se actualiza el arbol que controla las relaciones nombres/dolencias
				std::queue<std::string> vectoraux;
				vectoraux = dolencias_pacientes.at(dolencia);	//En caso de que la dolencia ya esté, se coloca al paciente al final
				vectoraux.push(cadena);
				dolencias_pacientes.insert(dolencia, vectoraux);
			}
			else {
				std::queue<std::string> vectoraux2;		//Si la dolencia no estaba, se le incluye en el arbol.
				vectoraux2.push(cadena);
				dolencias_pacientes.insert(dolencia, vectoraux2);
			}
		}
		else if (valor == 'A') {									//En caso de que tengamos que atender a un paciente...
			long long dolencia_a_mostrar = cola_pacientes.top();	//Obtenemos primero la máxima dolencia y la eliminamos
			cola_pacientes.pop();

			std::queue<std::string> vectoraux3 = dolencias_pacientes.at(dolencia_a_mostrar);	//Despues obtenemos la cola de pacientes con esta dolencia
			std::cout << vectoraux3.front().c_str() << "\n";									//Y mostramos el que mas tiempo lleve
				
			vectoraux3.pop();										//Lo eliminamos de la cola
			dolencias_pacientes.insert(dolencia_a_mostrar, vectoraux3);		//Y volvemos a insertar la cola en el arbol

			
		}
	}

	std::cout << "----" << "\n";
}
int main() {

	int num_elem = -1;
	std::cin >> num_elem;
	while (num_elem != 0) {
		resuelveCaso(num_elem);

		std::cin >> num_elem;
	}
	return 0;
}
