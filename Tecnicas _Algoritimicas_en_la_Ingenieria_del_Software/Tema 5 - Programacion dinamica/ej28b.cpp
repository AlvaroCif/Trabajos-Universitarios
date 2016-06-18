#include <iomanip>
#include <iostream>
#include <limits>
#include <algorithm> // min
#include "Matriz.h"
#include <vector>
#include <string>

using namespace std;

typedef struct {
	int posicion;
	char resultado1, resultado2;

}tDecision;



void asignar(tDecision &d, int p, char r1, char r2) 
{
	d.posicion = p;
	d.resultado1 = r1; 
	d.resultado2 = r2;
}

long long parentesis(vector<char> const& X) {

	int numero = 0;
	int n = X.size() ;
	
	Matriz<int>A(n , n);
	Matriz<int>B(n , n);
	Matriz<int>C(n , n);

	for (int i = 1; i < n; i++)
	{
		if (X[i] == 'a') A[i][i] = 1 ; else  A[i][i] = 0;
		if (X[i] == 'b') B[i][i] = 1 ; else  B[i][i] = 0;
		if (X[i] == 'c') C[i][i] = 1 ; else  C[i][i] = 0;
	}
	//recorre diagonales
	for (int d = 1; d < n - 1; d++)
	{
		//recorre elementos dentro de la diagonal
		for (int i = 1; i < n-d; i++)
		{
			int j = i + d;

			A[i][j] = 0; B[i][j] = 0; C[i][j] = 0;
			
			for (int k = i ; k < j ; k++)
			{

				A[i][j] = (A[i][j] + A[i][k] * (long long)C[k + 1][j] + B[i][k] * (long long)
					 C[k + 1][j] + C[i][k] * (long long)A[k + 1][j]) % 1000000007;
				B[i][j] = (B[i][j] + A[i][k] * (long long)A[k + 1][j] + A[i][k] * (long long)
					B[k + 1][j] + B[i][k] * (long long)B[k + 1][j]) % 1000000007;
				C[i][j] = (C[i][j] + B[i][k] * (long long)A[k + 1][j] + C[i][k] * (long long)
					B[k + 1][j] + C[i][k] * (long long)C[k + 1][j]) % 1000000007;
			}
		}
	}
	// fin recorrido diagonales
	numero = A[1][n - 1];

	return numero;
}
bool resuelveCaso() {

	
	string caracteres;
	
	cin >> caracteres;

	if (!cin) {
		return false;
	}
	// convertimos Striing a Vector de Char
	vector<char> X(caracteres.size() +1);
	int i = 1;
	for (char k : caracteres) {
		X[i] = k;
		i++;
	}

	int solucion =  parentesis(X);

	// mostrar solucion
	cout << solucion  << endl;
	

	return true;
}

int main() {

	while (resuelveCaso());

	return 0;
}