#include <iostream>
#include <vector>
#include <string>
#include"MayorComponenteCreciente.h"

class clase15 {
public:

	clase15(int dimension1, int dimension2) :
		cd(dimension1*dimension2),
		vector(dimension1, std::vector<bool>(dimension2, false))
	{
		this->dimension1 = dimension1;
		this->dimension2 = dimension2;
		//Leer primera parte con las dimensiones.
		std::string cadena;

		std::getline(std::cin, cadena);			//Me llevo el salto de linea
		for (int i = 0; i < dimension1; i++) {														//Coste V * const
			std::getline(std::cin, cadena);
			for (int j = 0; j < dimension2; j++) {
				if (cadena.at(j) == '#') {
					vector.at(i).at(j) = true;
				}
			}
		}
		for (int i = 0; i < dimension1; i++) {													//V * const
			for (int j = 0; j < dimension2; j++) {
				if (vector.at(i).at(j)) {
					//Se realizan solo 2 comprobaciones para no volver a añadir aristas, en este caso elegiremos hacia la derecha y abajo.
					if (i - 1 >= 0 && vector.at(i - 1).at(j)) cd.unir(i*dimension2 + j, (i - 1)*dimension2 + j);//Si esta encima
					//if (i + 1 < dimension1 && vector.at(i + 1).at(j))  cd.unir(i*dimension2 + j, (i + 1)*dimension2 + j); //Si esta debajo
					if (j - 1 >= 0 && vector.at(i).at(j - 1)) cd.unir(i*dimension2 + j, i*dimension2 + (j - 1)); //Si esta a la izquierda
					//if (j + 1 < dimension2 && vector.at(i).at(j + 1)) cd.unir(i*dimension2 + j, (i*dimension2) + j + 1); //Si esta a la derecha
				}
			}
		}
	}
	void addArista(int posicioni, int posicionj) {
		vector.at(posicioni).at(posicionj) = true;
		//Se realizan las 4 comprobaciones para comprobar si tenemos manchas en los alrededores.
		if (posicioni - 1 >= 0 && vector.at(posicioni - 1).at(posicionj)) cd.unir(posicioni*dimension2 + posicionj, (posicioni - 1)*dimension2 + posicionj);//Si esta encima
		if (posicioni + 1 < dimension1 && vector.at(posicioni + 1).at(posicionj))cd.unir(posicioni*dimension2 + posicionj, (posicioni + 1)*dimension2 + posicionj); //Si esta debajo
		if (posicionj - 1 >= 0 && vector.at(posicioni).at(posicionj - 1))cd.unir(posicioni*dimension2 + posicionj, posicioni*dimension2 + (posicionj - 1)); //Si esta a la izquierda
		if (posicionj + 1 < dimension2 && vector.at(posicioni).at(posicionj + 1)) cd.unir(posicioni*dimension2 + posicionj, (posicioni*dimension2) + posicionj + 1); //Si esta a la derecha
	}

	int dameMax() {
		return cd.dameTamMax();
	}
protected:
	MayorComponenteCreciente cd;
	std::vector<std::vector<bool> > vector;
	int dimension1, dimension2;
};
