#pragma once
//
//  ConjuntosDisjuntos.h
//
//  Implementación de estructuras de partición o conjuntos disjuntos
//  con unión por tamaño y compresión de caminos
//
//  Técnicas Algoritmicas en Ingeniería del Software / Diseño de Algoritmos
//  Facultad de Informática
//  Universidad Complutense de Madrid
//
//  Created by Alberto Verdejo on 26/6/15.
//  Copyright (c) 2015 Alberto Verdejo. All rights reserved.
//


#include <vector>
#include <iostream>
//Todas las operaciones tienen un coste aproximadamente constante.
class MayorComponenteCreciente {
public:

	// crea una estructura de partición con los elementos 0..N-1, cada uno en un conjunto
	MayorComponenteCreciente(size_t N) : size(N), _count(size), id(size, -1), maxTam(-1) {}

	// devuelve el número de conjuntos disjuntos
	size_t count() const { return _count; }

	//  devuelve el identificador del conjunto que contiene a p
	size_t buscar(size_t p) const {
		if (id[p] < 0) // es una raíz
			return p;
		else
			return id[p] = int(buscar(id[p]));
	}
	int dameTamMax() {
		return -maxTam;
	}
	// unir los conjuntos que contengan a p y q
	void unir(size_t p, size_t q) {
		auto i = buscar(p);
		auto j = buscar(q);
		if (i == j) return;
		if (id[i] < id[j]) { // i es la raíz del mayor árbol
			id[i] += id[j]; id[j] = int(i);
			if (id[i] < maxTam) {
				maxTam = id[i];
			}
		}
		else {
			id[j] += id[i]; id[i] = int(j);
			if (id[j] < maxTam) {
				maxTam = id[j];
			}
		}
		_count--;
	}

	// muestra el array por la salida o 
	void print(std::ostream& o = std::cout) const {
		o << _count << ": ";
		for (auto i = 0; i < size; ++i)
			o << id[i] << " ";
	}

protected:
	size_t size;             // los elementos son 0 .. size-1
	size_t _count;           // número de conjuntos disjuntos
	mutable std::vector<int> id;  // si id[i]>=0 es el padre de i, si no es el tamaño del conjunto de i
	int maxTam;

};