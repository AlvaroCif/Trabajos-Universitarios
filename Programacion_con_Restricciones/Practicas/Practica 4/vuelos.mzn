#Nombre1: Jaime Boixadós
#Nombre2: Benito Alvaro Cifuentes
int: n;
int: ini;
int: fin;
int: max;
array [1..n, 1..n] of int: t;
array [1..max] of var 0..n: trayecto; 
var 1..max: posfin;
var int: constr;
array [1..max] of var int: costes; 


constraint trayecto[1] = ini /\ trayecto[posfin] = fin;
constraint forall(i in posfin..max)(costes[i] = 0);
constraint forall(i in posfin+1..max)(trayecto[i] = 0);
constraint forall(i in 1..posfin-1)(t[trayecto[i], trayecto[i+1]] > 0);
constraint forall(i in 1..posfin-1)(costes[i] = t[trayecto[i], trayecto[i+1]]);
constraint constr=sum(i in 1..max)(costes[i]);

%solve minimize posfin;
solve minimize constr;
