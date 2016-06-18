/* Grupo TAIS17, Benito Álvaro Cifuentes y Rafael Guerra
Para la solución del problema, he usado una estructura auxiliar que guarda un número (dolencia), una cadena(nombre) junto al orden de ingreso.

El algoritmo seguido para resolver el ejercicio es simple, se introducen pacientes en la cola de pacientes (cola de maximos que usa de clave la dolencia
teniendo en cuenta el orden de llegada en caso de coincidir las dolencias) y cuando uno vaya a ser atendido, simplemente se saca al primero, y se le atiende.
*/
#include <algorithm>
#include <iostream>
#include "TreeMap_RB.h"
#include "PriorityQueue.h"
#include "Urgencias.h"
#include <queue>


//El coste de resolver cada caso es de O(N * log N) debido a que se realizan tantas inserciones como pacientes se ingresen y log N es el coste de la inserción
//Siendo N el número de pacientes que se ingresan.
void resuelveCaso(int num_elem) {
	long long int a = 10;
	char valor;
	char cadena_aux[20];
	long long dolencia;
	std::string cadena;
	myStruct aux;

	PriorityQueue<myStruct> cola_pacientes;

	for (int i = 0;i < num_elem;i++) {
		std::cin >> valor;
		if (valor == 'I') {					//Si recibimos una I...
			std::cin >> cadena_aux;
			cadena = cadena_aux;			//Se leen dos valores, primero una cadena y despues un numero.
			std::cin >> dolencia;

			aux.dolencia = dolencia;
			aux.cadena = cadena;
			aux.orden_llegada = i;

			cola_pacientes.push(aux);

		}
		else if (valor == 'A') {									//En caso de que tengamos que atender a un paciente...
			aux = cola_pacientes.top();
			cola_pacientes.pop();

			std::cout << aux.cadena.c_str() << "\n";
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
