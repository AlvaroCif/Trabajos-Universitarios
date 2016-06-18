#include <iostream>
#include <vector>
#include <string>
#include <fstream>



int main() {
#ifndef DOMJUDGE
	std::ifstream in("Casos38.txt");
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