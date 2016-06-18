#include <iostream>
#include <String>
#include <algorithm>

class Pelicula {
public:

	int min_comienzo;
	int duracion;
	int hora_final;
	int min_final;

	Pelicula(int horaComienzo, int minComienzo, int duracion) {
		hora_comienzo = horaComienzo;
		min_comienzo = minComienzo;
		this->duracion = duracion;
		calcularFinalizacion();
	}
	bool operator < (const Pelicula& e){
		if (hora_final < e.hora_final) return true;
		else if (hora_final > e.hora_final) return false;
		else if (min_final <= e.min_final) return true;
		else return false;
	}

	std::string toString() {
		std::string aux("Hora de comienzo: " + std::to_string(hora_comienzo) + ":" + std::to_string(min_comienzo) + " Hora de finalizacion: " + std::to_string(hora_final) + ":" + std::to_string(min_final));
		return aux;
	}

	void calcularFinalizacion() {
		int aux = min_comienzo;
		int min_nuevos = min_comienzo + duracion;
		int horas_a_añadir = min_nuevos / 60;

		hora_final = hora_comienzo + horas_a_añadir;
		min_final = min_nuevos % 60;

	}
};
