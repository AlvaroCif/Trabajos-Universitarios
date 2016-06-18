%Nombres : Jaime Boixadós
%	   Benito Álvaro Cifuentes

int:n=5;
array [1..n,1..2] of 0.0..1000.0:a=[| 1,1 | 2,1 | 3,1 | 4,1 | 5,1|];
float:lado=1.0;

predicate enElCuadrado(var float:x0, var float:y0, var float:x1, var float:y1, var float:l) =
x0 >= x1 /\ x0<= x1 + l /\ y0 >= y1 /\ y0<= y1 + l;

predicate nosobrepuesto(var float:x0, var float:y0, var float:l0, var float:x1, var float:y1, var float:l1) =
(x0 <= x1 /\ x0 + l0 <= x1 \/ y0 <= y1 /\ y0 + l0 <= y1) /\  (x1 <= x0 /\ x1 + l1 <= x0 \/ y1 <= y0 /\ y1 + l1 <= y0) /\
(x0 <= x1 /\ x0 + l0 <= x1 \/ y1 <= y0 /\ y1 + l1 <= y0) /\  (x1 <= x0 /\ x1 + l1 <= x0 \/ y0 <= y1 /\ y0 + l0 <= y1);


array [1..n,1..3] of var 0.0..1000.0:b;

var 1..n: numero_cuadrados;

constraint forall(i in 1..n)(b[i,3] <= lado /\ b[i,3] >= 0);
constraint forall(i in 1..n)(exists(j in 1..n)(j <= numero_cuadrados /\ enElCuadrado(a[i,1],a[i,2],b[j,1],b[j,2],b[j,3])));
constraint forall(i in 1..n)( i <= numero_cuadrados /\ forall(j in 1..n)((i=j /\ j <= numero_cuadrados) \/ (i != j /\ j <= numero_cuadrados /\ nosobrepuesto(b[i,1],b[i,2],b[i,3],b[j,1],b[j,2],b[j,3]))));


solve minimize numero_cuadrados;
