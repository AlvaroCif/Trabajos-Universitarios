package choco;

import org.chocosolver.solver.Solver;
import org.chocosolver.solver.constraints.Constraint;
import org.chocosolver.solver.constraints.IntConstraintFactory;
import org.chocosolver.solver.variables.IntVar;
import org.chocosolver.solver.variables.VariableFactory;

public class Main {

	public static void main(String[] args) {
		Solver solver = new Solver("Práctica 10");
		IntVar[] a = VariableFactory.enumeratedArray("a", 4, 0, 3, solver);
		IntVar[] b = VariableFactory.enumeratedArray("b", 4, 2, 5, solver);
		for(int i = 0; i <4; i++){
			Constraint a1 = IntConstraintFactory.arithm(a[i],"!=", b[i]);
			solver.post(a1);
		}
		int[] coeffs = new int[]{1, 2, 3, 4};
		IntVar ar = VariableFactory.bounded("ar", 0, 20, solver);
		IntVar br = VariableFactory.bounded("br", 0, 20, solver);
		solver.post(IntConstraintFactory.scalar(a, coeffs, ar));
		solver.post(IntConstraintFactory.scalar(b, coeffs, br));
		solver.post(IntConstraintFactory.arithm(ar,"=", br));
		int i = 1;
		if(solver.findSolution()){
			do{
				System.out.print("Sol"+i+" ");
				for(int j = 0; j < 4;j++){
					System.out.print(a[j] + " ");
				}
				for(int j = 0; j < 4;j++){
					System.out.print(b[j] + " ");
				}
				System.out.println(". Peso Total:" + ar.getValue());
				i++;
			}while(solver.nextSolution());
		}
	}

}
