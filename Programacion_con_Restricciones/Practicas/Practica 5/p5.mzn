#Nombre1: Jaime Boixadós
#Nombre2: Benito Alvaro Cifuentes
int:n;
int:m;
array[1..n, 1..nb] of int:f;
array[1..m, 1..mb] of int:c;
int:nb;
int:mb;

array[1..n, 1..m] of var 0..1:tablero;

array[1..n] of var int:sumafila;
array[1..m] of var int:sumacol;

constraint forall(i in 1..n)(sumafila[i] = sum( [f[i, k] | k in 1..nb]));
constraint forall(i in 1..n)(sumafila[i] = sum( [tablero[i, j] | j in 1..m])); 

constraint forall(i in 1..n)(sumacol[i] = sum( [c[i, k] | k in 1..mb]));
constraint forall(i in 1..m)(sumacol[i] = sum( [tablero[j, i] | j in 1..n]));

constraint forall(i in 1..n)(sum(j in 1..nb)(f[i,j]!=0) == sum(k in 1..m)(tablero[i,k]=1 /\ (k=1 \/ (k>1 /\ tablero[i,k-1] = 0))));
constraint forall(i in 1..m)(sum(j in 1..mb)(c[i,j]!=0) == sum(k in 1..n)(tablero[k,i]=1 /\ (k=1 \/ (k>1 /\ tablero[k-1,i] = 0))));

solve satisfy;
