#pragma once
//
//  TreeMapRango.h
//
//  Extensión de tablas <clave, valor> como árboles de búsqueda AVL
//  con una operación para consultar las claves en un rango
//

#ifndef TREEMAPRANGO_H_
#define TREEMAPRANGO_H_

#include <vector>

#include "TreeMap_AVL.h"

template <typename Clave, typename Valor, typename Comparador = std::less<Clave>>
class TreeMapRango : public TreeMap<Clave, Valor, Comparador> {
public:

	TreeMapRango(Comparador c = Comparador()) : TreeMap<Clave, Valor, Comparador>(c) {};

	std::vector<Clave> rango(Clave const& k1, Clave const& k2) const {
		std::vector<Clave> vector;
		rango(k1, k2, this->raiz, vector);

		return vector;

	}

protected:
	using TreeNode = typename TreeMap<Clave, Valor, Comparador>::TreeNode;
	using Link = TreeNode *;

	void rango(Clave const& k1, Clave const& k2, Link a, std::vector<Clave> &lista) const {
		if (k1 < a->cv.clave) {
			if (a->iz != nullptr) {
				rango(k1, k2, a->iz, lista);
			}
		}

		if (a->cv.clave >= k1 && a->cv.clave <= k2) {
			lista.push_back(a->cv.clave);
		}

		if (a->cv.clave < k2) {
			if (a->dr != nullptr) {
				rango(k1, k2, a->dr, lista);
			}
		}
	}
};



#endif /* TREEMAPRANGO_H_ */
