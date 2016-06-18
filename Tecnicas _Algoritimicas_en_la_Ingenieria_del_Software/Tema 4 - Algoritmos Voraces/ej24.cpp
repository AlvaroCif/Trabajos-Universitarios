/* Grupo 17 Benito Álvaro Cifuentes de la Torre y Rafael Guerra

Para resolver el problema de las conferencias, la mayor dificultad que presenta es ser capaz de comprobar en un tiempo menor que lineal si hay conferencias
disponibles, por ello, se descarta la idea de recorrer todas las conferencias cada vez que se vaya a revisar una, ya que podría llegar a tener
un coste cuadrático en el número de conferencias.

La solución dada busca evitar esto escogiendo como función de selección una función que devuelve siempre la conferencia con una menor hora de inicio (ordenandolas
y recorriendolas), para poder determinar si una conferencia necesita de una nueva sala o no, se guarda en una cola de prioridad(que devuelve siempre el menor)
las horas de finalización de las salas ocupadas, de forma que si la menor hora de finalización es mayor que la hora de inicio de la siguiente, necesitaremos
de una nueva sala, por lo que añadiremos un nuevo elemento a la pila, que será la hora de finalizacion de esta nueva, en caso de que no sea así, no hará falta
de una nueva sala, pero si actualizar el valor de la hora de finalización con el nuevo, por lo que sacaremos de la cola de prioridad la hora y pondremos la
hora de finalización de la sala que acabamos de ocupar.

El coste es de N log N, ya que la funcion de selección necesita de una ordenación de un vector, y el mantenimiento de la cola de prioridad genera otro coste
de N log N ya que se encuentra dentro del bucle (N conferencias * (log N) usos de pila en el caso peor).

Coste estimado N log N, siendo N el número de conferencias.
*/

#include <iostream>
#include <algorithm>
#include <vector>
#include "PriorityQueue.h"

struct Conferencia {
	int hora_inicio;
	int hora_final;
};

bool operator<(const Conferencia& x, const Conferencia& y) {
	return x.hora_inicio < y.hora_inicio;
}

//Tiene como precondición que el número de conferencias sea mayor que 0.
/*
Ordena las conferencias por su hora de inicio y las recorre secuencialmente determinando si se necesita o no una nueva sala
ayudandose de una cola de prioridad.
*/
int resuelve(std::vector<Conferencia>& conferencias) {
	std::sort(conferencias.begin(), conferencias.end());

	PriorityQueue<int> pq;

	pq.push(conferencias[0].hora_final);
	for (int i = 1; i < conferencias.size(); i++) {
		int hora_final = pq.top();
		if (hora_final > conferencias[i].hora_inicio) {
			pq.push(conferencias[i].hora_final);
		}
		else {
			pq.pop();
			pq.push(conferencias[i].hora_final);
		}
	}

	return pq.size();
}

//Resuelve por completo un caso e imprime por pantalla el valor esperado.
bool resuelveCaso() {
	int numero_conferencias;
	std::cin >> numero_conferencias;
	if (numero_conferencias == 0) return false; //Caso especial
	std::vector<Conferencia> conferencias(numero_conferencias);
	for (int i = 0; i < numero_conferencias; i++) {
		int aux1, aux2;
		std::cin >> aux1;
		std::cin >> aux2;
		Conferencia c;
		c.hora_inicio = aux1;
		c.hora_final = aux2;
		conferencias[i] = c;
	}

	int resultado = resuelve(conferencias);

	std::cout << resultado << "\n";

	return true;
}


int main() {
	//ResuelveCaso devuelve false si encuentra el caso especial(0 conferencias)
	while (resuelveCaso()) {

	}
	return 0;
}