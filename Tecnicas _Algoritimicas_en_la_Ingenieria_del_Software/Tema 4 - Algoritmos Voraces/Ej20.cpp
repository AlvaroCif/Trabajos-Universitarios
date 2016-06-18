/* Benito Álvaro CIfuentes y Rafael Guerra Tais17

*/

#include <iostream>
#include <algorithm>
#include <vector>

int resuelve(std::vector<int> &pies, std::vector<int> esquies){
	std::sort(pies.begin(), pies.end());
	std::sort(esquies.begin(), esquies.end());

	int suma_minima = 0;

	for (int i = 0; i < pies.size(); i++){
		suma_minima = suma_minima + std::abs(pies[i] - esquies[i]);
	}

	return suma_minima;
}


bool resuelveCaso(){
	int numero_de_personas;
	std::cin >> numero_de_personas;
	if (numero_de_personas == 0) return false;
	std::vector<int> pies(numero_de_personas);
	std::vector<int> esquies(numero_de_personas);
	int aux;
	for (int i = 0; i < numero_de_personas; i++){
		std::cin >> aux;
		pies[i] = aux;
	}

	for (int i = 0; i < numero_de_personas; i++){
		std::cin >> aux;
		esquies[i] = aux;
	}

	int resultado=resuelve(pies, esquies);
	std::cout << resultado << "\n";
	return true;
}
int main(){
	while (resuelveCaso()){

	}

	return 0;
}