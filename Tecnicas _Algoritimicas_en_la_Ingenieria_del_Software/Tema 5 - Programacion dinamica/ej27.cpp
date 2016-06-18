/* Benito Álvaro Cifuentes de la Torre y Rafael Guerra Grupo Tais 17
Para la resolución de este ejercicio se ha usado 3 matrices adicionales que nos dan la información necesaria para saber si es posible o no conseguir una letra usando unos
determinados operandos: si En la matriz A la posicion A[2][3] tiene como valor true, significa que usando los operandos del 2 al 3 se puede conseguir una A, en caso de que no se
pueda se pondría a false.

Por lo tanto, se comparan todas las posibles combinaciones entre los operandos, y se determinan los valores de las Matrices A B y C siguiendo los valores de la tabla de multiplicación

El coste del algoritmo es de O(N^3) debido a la presencia de los 3 bucles anidados. Ya que no solo se recorren los elementos de la matriz sino que también se comprueban todas sus
posibilidades.

El coste en espacio adicional se podría considerar que es de 3 * N^2 -> O(N^2) ya que al ser el 3 una constante no afecta.

Significado de la función A(i,j) = True si se puede conseguir una A insertando parentesis entre los operandos i y j false en cc.
						  B(i,j) = True si se puede conseguir una B insertando parentesis entre los operandos i y j false en cc.
						  C(i,j) = True si se puede conseguir una C insertando parentesis entre los operandos i y j false en cc.
Recursión:
(llamaremos a la entrada x)
A(i,i) = (x[i] == a)
B(i,i) = (x[i] == b)
C(i,i) = (x[i] == c)


		 j
A(i,j) = \/    ( (A(i,k) /\ C(k+1,j)) \/ (B(i,k) /\ (C(k+1 ,j)) \/ (C(i,k) /\ (A(k+1,j)))
		 k = i

		 j
B(i,j) = \/    ( (A(i,k) /\ A(k+1,j)) \/ (A(i,k) /\ (B(k+1 ,j)) \/ (B(i,k) /\ (B(k+1,j)))
		 k = i

		 j
C(i,j) = \/    ( (B(i,k) /\ A(k+1,j)) \/ (C(i,k) /\ (B(k+1 ,j)) \/ (C(i,k) /\ (C(k+1,j)))
		 k = i
*/

#include <iostream>
#include <string>
#include <vector>
#include <fstream>

#include "Matriz.h"

bool resuelve(std::string cadena) {
	Matriz<bool> A(cadena.length(), cadena.length(), false);
	Matriz<bool> B(cadena.length(), cadena.length(), false);
	Matriz<bool> C(cadena.length(), cadena.length(), false);

	for (int i = 0; i < cadena.length();i++) {
		if (cadena.at(i) == 'a') A[i][i] = true;
		else if (cadena.at(i) == 'b') B[i][i] = true;
		else if (cadena.at(i) == 'c') C[i][i] = true;
	}

	for (int d = 0; d < cadena.length();d++) {
		for (int i = 0; i < cadena.length() - d;i++) {
			int j = i + d;
			int k = i;
			while (!A[i][j] && k < j) {
				if (A[i][k] && C[k + 1][j]) {
					A[i][j] = true;
				}
				else {
					if (B[i][k] && C[k + 1][j]) {
						A[i][j] = true;
					}

					else {
						if (C[i][k] && A[k + 1][j]) {
							A[i][j] = true;
						}
						else k = k + 1;
					}
				}
			}

			k = i;
			while (!B[i][j] && k < j) {

				if (A[i][k] && A[k + 1][j]) {
					B[i][j] = true;
				}
				else {
					if (A[i][k] && B[k + 1][j]) {
						B[i][j] = true;
					}
					else {
						if (B[i][k] && B[k + 1][j]) {
							B[i][j] = true;
						}
						else k = k + 1;
					}
				}
			}

			k = i;
			while (!C[i][j] && k < j) {
				if (B[i][k] && A[k + 1][j]) {
					C[i][j] = true;
				}
				else {
					if (C[i][k] && B[k + 1][j]) {
						C[i][j] = true;
					}
					else {
						if (C[i][k] && C[k + 1][j]) {
							C[i][j] = true;
						}
						else k = k + 1;
					}
				}
			}
		}
	}


/*	for (int i = 0; i < cadena.length();i++) {
		for (int j = 0; j < cadena.length(); j++) {
			std::cout << A[i][j] << "\t";
		}
		std::cout << "\n";
	}
	std::cout << "------------------" << "\n";
	for (int i = 0; i < cadena.length();i++) {
		for (int j = 0; j < cadena.length(); j++) {
			std::cout << B[i][j] << "\t";
		}
		std::cout << "\n";
	}
	std::cout << "------------------" << "\n";
	for (int i = 0; i < cadena.length();i++) {
		for (int j = 0; j < cadena.length(); j++) {
			std::cout << C[i][j] << "\t";
		}
		std::cout << "\n";
	}
	std::cout << "------------------" << "\n";

	*/

	return A[0][cadena.length()-1];
}

bool resuelveCaso() {
	std::string aux;
	char salto_linea;
	std::getline(std::cin, aux);
	if (aux.length() == 0) return false;
	bool resultado = resuelve(aux);

	if (resultado) std::cout << "SI" << "\n";
	else std::cout << "NO" << "\n";
	return true;
}

int main() {
	while (resuelveCaso) {
#ifndef DOMJUDGE
		std::ifstream in("casos27.txt");
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
}