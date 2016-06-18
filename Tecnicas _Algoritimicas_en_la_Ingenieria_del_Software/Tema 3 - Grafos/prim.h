#include <iostream>
#include "PriorityQueue.h"
#include "GrafoValorado.h"
class Prim{

public:
	Prim(GrafoValorado<int> &G):marked(G.V(),false), coste(0),isPosible(true),contador(0){

		visit(G,0);

		while(!cola.empty() && contador < G.V() - 1){
			Arista<int> aux = cola.top();
			cola.pop();							//Se hace en el peor de los casos E veces por lo su coste es de ElogE
			int v = aux.uno();
			int w = aux.otro(v);

			if(marked[v] && marked[w]) continue;
			contador++;
			coste = coste + aux.valor();	
			if(!marked[v]) visit(G,v);
			if(!marked[w]) visit(G,w);
		}
		evaluate(G.V());			//V
	}

	int getCost(){
                return coste;
        }

	bool getPosible(){
		return isPosible;
	}
private:
	int coste;
	bool isPosible;
	std::vector<bool> marked;
	PriorityQueue<Arista<int>> cola;
	int contador;

	void visit(GrafoValorado<int> &G, int v){
		marked[v] = true;
		for(Arista<int> e : G.adj(v)){
			if(!marked[e.otro(v)])
				cola.push(e);
		}
	}
	//Coste de V siendo v el numero de aristas
	void evaluate(const int n){
		int i = 0;
		bool aux = true;
		while(i < n && aux){
			if(marked[i] == false){
				isPosible = false;
				aux = false;
			}
			i++;
		}	
	}

};

