import java.util.*;

public class Recursive{
	private StringBuilder pF;

	private int fibonacci(int n){

		/*Plantear casos bases*/
		/*En el caso del proyecto los casos base serían todos aquellos que hagan que
		  un camino sea aceptado o sea descartado*/
		if(n == 0){
			pF.append("0\n");	
			return 0;	
		} 
		else if(n == 1){
			pF.append("1\n");
			return 1;
		} 

		/*Plantear los casos recursivos*/
		/*En el caso del proyecto, todos aquellos que su respuesta dependa de otra función
		  como esto ya es más pisado, podriamos pensar que si no se cumplió ningún caso base
		  es necesario avanzar hacia alguna dirección*/
		pF.append(String.format("\nfib(%d)+fib(%d)\n", n-1, n-2));

		pF.append(String.format("fib(%d):", n-1));
		int fU = this.fibonacci(n-1);
		pF.append(String.format("fib(%d):", n-2)); 
		int fD = this.fibonacci(n-2);

		return fU+fD;
		/*RECORDAR: las instrucciones de un programa son secuenciales
			una razón del porque fibonacci para este ejemplo es para 
			modelar que el codigo es secuencial, porque si se dan cuenta 
			primero va a calcular fibonacci(n-1) y cuando termine y el 
			programa retorne un valor seguirá con fibonacci(n-2) modelando
			la secuencialidad que es necesaria en la recursividad en este caso*/
	}

	private Recursive(){
		/*constructor*/
		pF = new StringBuilder();
	}

	private static void print(Object ob){
		System.out.print(ob.toString());
	}

	private void end(int nF, int nI){
		pF.append(String.format("\nEl resultado de fib(%d) es: %d\n\nJosue les desea que terminen su proyecto :)\n\n", nI, nF));
		print(pF.toString());
	}

	/*programa principal*/
	public static void main(String args[]){

		Recursive rC = new Recursive();
		Scanner sC = new Scanner(System.in);
		int n;

		print("\n***Clase ejemplo de recursividad**\n");
		print("\ncalculo de fibonacci\n");
		print("\nfib: ");

		n = sC.nextInt();

		rC.end(rC.fibonacci(n), n);
	}

}