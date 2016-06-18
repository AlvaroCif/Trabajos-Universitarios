#pragma once
#pragma once
#include <algorithm>
#include <iostream>
#include "TreeMap_RB.h"
#include "PriorityQueue.h"
#include <queue>


class Bandada {
private:
	PriorityQueue<long long> min;
	PriorityQueue<long long, std::greater<long long>> max;

	//En caso de que la altura de la cola de maximos sea mayor por 2 elementos transferimos un elemento de la cola de máximos a la de mínimos
	//o si la cola de minimos es mayor que la de maximos, igualamos las alturas pasando un elemento de la de minimos a la de maximos.
	void equilibra() {
		long long aux;
		if (!(min.size() == max.size() || min.size() == max.size() - 1)) {
			if (min.size() > max.size()) {
				aux = min.top();
				min.pop();
				max.push(aux);
			}
			else {
				aux = max.top();
				max.pop();
				min.push(aux);
			}
		}
	}
	// quizás otros atributos
public:
	/** Constructor:  */
	Bandada(long long pajaro){
		max.push(pajaro);
	};
	void insertar(long long edad) {
		if (edad > max.top()) {
			min.push(edad);
		}
		else {
			max.push(edad);
		}
		equilibra();
	}
	bool esVacia() const {
		return max.empty() && min.empty();
	}
	long long edadGaviota() const {
		return max.top();
	}
};