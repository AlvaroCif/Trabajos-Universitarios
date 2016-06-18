/*Benito Álvaro Cifuentes de la Torre y Rafael Guerra Grupo 17 Tais

Para resolver el problema de las subsecuencias se ha empleado una recursión que permite calcular el número de subsecuencias para subsecuencias menores incluyendo la ultima
letra de una de las subsecuencias.

Para esto se parte de la idea de que si hay 2 letras que coinciden en una cadena, se puede conseguir una subsecuencia del tamaño de la mayor de las subsecuencias que no incluyen
estas letras mas una debido a esta coincidencia de letras. Quedará el concepto mas claro una vez este bien definida la recursión.

Para la reconstrucción de la solución, se parte de la tabla ya completa, y se encuentra la posición en la que está el máximo, una vez teniendo ese máximo, se comprueba
si las cadenas partiendo desde el tamaño máximo de la primera cadena, y la posición recien calculada coinciden, si es así, se busca el máximo de la anterior fila, recorriendo
solo las columnas hacia la izquierda(disminuyendo el tamaño considerado de la cadena1), de no coincidir las letras, se disminuye el tamaño de las filas en 1 (disminuir el
tamaño considerado de la cadena1).


La función tiene un coste cúbico ya que no solo hay que recorrer todas las posiciones, sino que en caso de que coincida hay que hacer un recorrido mas en función de 
la columna que nos encontremos.

La función tiene un coste de espacio adicional cuadrático ya que 

Definición de Recursión Palabras(i,j) = número máximo de letras de la subsecuencia que se puede formar incluyendo las primeras i letras de la cadena 1 
(suponiendo que la numeración comience en 0 de las letras de una cadena) con las j primeras letras de la cadena2 incluyendo j en la subsecuencia.

Recursión Palabras (0,j) = 1 if(cadena1(0) == cadena2(0)
						   0 else

		  Palabras (i,j) = Palabras(i-1,j) if cadena1(i) != cadena2(j)
						   1 + max(palabras(i-1,k) else 
						      0<=k<j
*/

#include <fstream>
#include <sstream>
#include <iostream>
#include <algorithm>
#include <string>

#include "Matriz.h"

void calcularSolucion(Matriz<int>& palabras, int filaActual,std::string& cadena1, std::string& cadena2, std::string &solucion) {
	int aux = 0;
	int aux1 = 0;
	int indice = 0;
	for (int j = 0; j < cadena2.size();j++) {
		aux1 = palabras[filaActual][j];
		if (aux == 0 || aux1 > aux) {
			aux = aux1;
			indice = j;
		}

	}
	int max = aux;
	int columnaActual = indice;
	while (filaActual != -1 && columnaActual != -1) {
		if (cadena1[filaActual] == cadena2[columnaActual]) {
			solucion = cadena1[filaActual] + solucion;
			filaActual--;
			columnaActual--;
			bool noencontrado = true;
			while (noencontrado && columnaActual >= 0 && filaActual >= 0) {
				if (palabras[filaActual][columnaActual] == max - 1) {
					max--;
					noencontrado = false;
				}
				else {
					columnaActual--;
				}
			}

		}
		else {
			filaActual--;
		}
	}
}

std::string resuelve(std::string &cadena1, std::string cadena2) {
	Matriz<int> palabras(cadena1.size(), cadena2.size(), 0);
	//Matriz<int> mapa(cadena1.size(), cadena2.size(), -1);
	/*for (int i = 0; i < cadena1.size();i++) {
		if (cadena1[i] == cadena2[0]) palabras[i][0] = 1;
	}/*/
	for (int j = 0; j < cadena2.size();j++) {
		if (cadena1[0] == cadena2[j]) {
			palabras[0][j] = 1;

		//	mapa[0][j] = j;
		}
	}
	for (int i = 1; i < cadena1.size();i++) {
		for (int j = 0; j < cadena2.size(); j++) {
			//std::cout << cadena1[i] << " " << cadena2[j];
			if (cadena1[i] == cadena2[j]) {
				int aux = 0;
				int aux1 = 0;
				for (int k = 0; k < j;k++) {
					aux1 = palabras[i - 1][k];
					if (aux1 > aux || aux == 0) {
						aux = aux1;
					//	mapa[i][j] = k;
					}
				}
				palabras[i][j] = aux + 1;
			}
			else {
				palabras[i][j] = palabras[i - 1][j];
			}
		}
	}/*
	for (int i = 0; i < cadena1.size();i++) {
		for (int j = 0; j < cadena2.size();j++) {
			std::cout << mapa[i][j] << "\t";
		}
		std::cout << "\n";
	}
	std::cout << "\n";
	for (int i = 0; i < cadena1.size();i++) {
		for (int j = 0; j < cadena2.size();j++) {
			std::cout << palabras[i][j] << "\t";
		}
		std::cout << "\n";
	}
	*/


	std::string solucion;
	calcularSolucion(palabras,cadena1.size() - 1,cadena1,cadena2, solucion);


	return solucion;
}

bool resuelveCaso() {
	std::string aux;

	std::getline(std::cin, aux);
	if (aux.size() == 0) return false;
	std::string cadena1;
	std::string cadena2;

	bool noEspacios = true;
	int i = 0;
	while (noEspacios) {
		if (aux[i] == ' ') {
			noEspacios = false;
			i++;
		}
		else {
			cadena1.push_back(aux[i]);
			i++;
		}
	}

	for (int j = i; j < aux.size();j++) {
		cadena2.push_back(aux[j]);
	}
	//std::cout << cadena1 << " " << cadena2  << "|\n";

	std::string resultado = resuelve(cadena1, cadena2);
	std::cout << resultado << "\n";
	return true;
}
int main() {
#ifndef DOMJUDGE
	std::ifstream in("casos36.txt");
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