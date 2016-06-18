%Jaime Boixadós


% num asignaturas
int:n=5;
% 1-> ge , 2->fp, 3->fc, 4-> mdl, 5->mmi
% num dias con clase
int:dias=5;
% num horas/dia
int:horas=4;
% bloques de 1 hora semanal, bloques de 2 horas semanales
array [1..n,1..2] of 0..n:bloques = [|0,2 | 2,1 | 2,1 | 4,0 | 4,0 |];
% esto es lo que queremos averiguar
array [1..dias,1..horas] of var 1..n:horario;



constraint forall(i in 1..n)(sum(j in 1..horas,k in 1..dias)(horario[j,k]==i) == (bloques[i,1] + bloques[i,2] * 2));
constraint forall(h in 1..dias)(forall(i in 1..horas-1)(( i<horas-1 /\ horario[h,i] == horario[h,i+1] /\ horario[h,i+1] != horario[h,i+2] 
                                   \/(horario[h,i] != horario[h,i+1] /\ forall(k in i+1..horas)(horario[h,i] != horario[h,k])))));
constraint forall(k in 1..n)(sum(i in 1..horas,j in 1..dias)(horario[j,i]==k /\ horario[j,i+1]==k) == bloques[k,2]);

solve satisfy;

output([show(horario[j,i])++(if (j==dias) then "\n" else "  " endif) | i in 1..horas,j in 1..dias]);

