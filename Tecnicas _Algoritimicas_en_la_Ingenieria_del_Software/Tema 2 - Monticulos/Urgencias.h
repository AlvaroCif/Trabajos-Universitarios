#pragma once
#include <algorithm>
#include <iostream>
#include "TreeMap_RB.h"
#include "PriorityQueue.h"
#include <queue>


struct myStruct {
	long long dolencia;
	int orden_llegada;

	std::string cadena;

	bool operator<(const myStruct& rhs) const {
		int orden = this->orden_llegada;
		if (this->dolencia == rhs.dolencia) {
			return this->orden_llegada < rhs.orden_llegada;
		}
		else {
			return this->dolencia > rhs.dolencia;
		}
	}
};
class Urgencias {
private:
	PriorityQueue<myStruct> elementos;
	int contador;
	// quizás otros atributos
public:
	/** Constructor:  */
	Urgencias(int t = TAM_INICIAL) : contador(0){};
	void insertar(std::string nombre, int gravedad) {
		this->contador++;
		myStruct aux;

		aux.dolencia = gravedad;
		aux.cadena = nombre;
		aux.orden_llegada = contador;

		this->elementos.push(aux);
	}
	bool esVacia() const {
		return elementos.empty();
	}
	std::string nombrePrimero() const {
		return elementos.top().cadena;
	}
	void quitarPrimero() {
		elementos.pop();
	}

};