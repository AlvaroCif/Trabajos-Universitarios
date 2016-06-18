%Autores
%Benito Álvaro Cifuentes
%Yaofang Zhang

include "alldifferent.mzn";
par int:n = 17;
array[1..n,1..n] of var 1..n*n: a;
array[1..n*n] of var 1..n*n:aux;
int: v = (n *((n*n) + 1))div 2;


constraint forall(i in 1..n)(sum(j in 1..n)(a[i,j]) == v);
constraint forall(i in 1..n)(sum(j in 1..n)(a[j,i]) == v);

constraint sum(i in 1..n)(a[i,i]) = v;
constraint sum(i in 1..n)(a[i,n-i + 1]) = v;

constraint forall(i,j in 1..n)(aux[n*(i-1) + j]=a[i,j]);

constraint alldifferent(aux);


solve :: int_search(aux,first_fail,indomain_random, complete) satisfy;

output([show(a[j,i])++(if (j==n) then "\n" else "\t" endif) | i in 1..n,j in 1..n])
