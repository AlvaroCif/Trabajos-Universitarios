% fichero lstrings.mzn
%Nombres: Jaime Boixadós
%	  Benito Álvaro Cifuentes
set of int:CHAR=1..4;

predicate substring(array [int] of var CHAR:a, var int:ini,
                    array [int] of var CHAR:b) = forall(i in ini..ini+length(a)-1)(a[i-ini + 1] == b[i]);
predicate reverse (array [int] of var CHAR:a, array [int] of var CHAR : b) = forall(i in 1..length(a))(a[i] == b[length(a)-i+1]);

predicate count(array [int] of var CHAR:a, var int:n,
                    var CHAR:c) = (n = sum(i in 1..length(a))(a[i] = c));
