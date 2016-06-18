/* Benito Álvaro Cifuentes de la Torre y Rafael Guerra Grupo TAIS 17
La resolución del problema de las películas es muy sencilla, solo basta con ordenar las peliculas por su hora de finalización (de menor a mayor) e ir insertando cada una,
cuando se va a comprobar la siguiente peli, se mira si la anterior ya ha acabado, si no ha acabado, pasamos a la siguiente peli, si lo ha hecho, aumentamos el número de pelis
y actualizamos la hora de finalización para comprobar las siguientes peliculas.

El coste es de N log N debido a la necesidad de ordenar la entrada, siendo lineal la resolución.

Coste: N log N siendo N el número de peliculas.
*/

#include <iostream>
#include <algorithm>
#include <vector>
#include <fstream>
#include <sstream>

//Guarda la hora de inicio y de finalizacion de una pelicula (mas el tiempo de las palomitas, por supuesto, las pelis no serian lo mismo sin palomitas).
struct Pelicula {
	int min_inicio;
	int min_final;
};
//Definición del operando para poder utilizar el metodo sort definido por defecto.
bool operator<(const Pelicula& x, const Pelicula& y) {
	return x.min_final < y.min_final;
}
//Devuelve a partir de un array de peliculas el número máximo de pelis que se pueden llegar a ver con coste N log N siendo N el número de pelis.
int resuelve(std::vector<Pelicula> &pelis) {
	std::sort(pelis.begin(), pelis.end());		//Ordena con coste N log N.

	int resultado = 0;

	int inicio = 0;
	for (int i = 0; i < pelis.size();i++) {		//Recorrido lineal.
		if (pelis[i].min_inicio >= inicio) {
			inicio = pelis[i].min_final;
			resultado++;
		}
	}

	return resultado;
}
//Lee por entrada estandar un caso, invoca al método para resolverlo, e imprime el resultado por pantalla, también detecta el caso final (numPelis = 0).
bool resuelveCaso() {
	int numPelis;
	std::cin >> numPelis;
	if (numPelis == 0) return false;		//Caso final.
	int horas, minutos,duracion;
	std::vector<Pelicula> pelis(numPelis);
	char dos_puntos;
	Pelicula p;
	for (int i = 0; i < numPelis; i++) {
		std::cin >> horas;
		std::cin >> dos_puntos;
		std::cin >> minutos;
		std::cin >> duracion;

		p.min_inicio = horas * 60 + minutos;
		p.min_final = horas * 60 + minutos + duracion + 10;
		pelis[i] = p;
	}
	int resultado = resuelve(pelis);
	std::cout << resultado << "\n";
	return true;
}
int main() {

#ifndef DOMJUDGE
	std::ifstream in("casos23.txt");
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