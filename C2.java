// C2: 4 operaciones
import java.util.Scanner;
public class C2{
	static Scanner sc = new Scanner(System.in);
	public static void main(String args[]){
		int m, n; 
		m = leerEntero(); 
		n = leerEntero(); 
		operaciones(m, n); 
	} 
	static int leerEntero(){ 
		int m; 
		System.out.printf("Ingrese un entero > 0: "); 
		m = sc.nextInt(); 
		return m; 
	} 
	static int menu(){ 
		int op; 
		System.out.printf("\nOperación que requiere:\n"); 
		System.out.printf("1) Sumar: m + n\n"); 
		System.out.printf("2) Restar: m – n\n"); 
		System.out.printf("3) Multiplicar: m * n\n"); 
		System.out.printf("4) Dividir: m/n\n"); 
		System.out.printf("5) Salir:\n"); 
		do { 						// Valida la opción entre 1 y 5 
			System.out.printf("Elija su opción: ");	  op = sc.nextInt(); 
		} while (op<1 || op > 5); 
		return op; 
	} 
	static void operaciones(int m, int n){ 
		int op; 									// op = opción
		do { 
			op = menu(); 
			switch(op){ 					// Ejecute de operación seleccionada. 
				case 1: suma(m,n);	   		break; 
				case 2: resta(m,n);				break; 
				case 3: multiplicacion(m,n);	break; 
				case 4: division(m,n);	   	break; 
				default: System.out.printf("Gracias por su visita\n"); 
			}	 
		} while(op!=5); 
	} 
	static void suma(int m, int n)	   {System.out.printf("suma  = %d\n", m+n);} 
	static void resta(int m, int n)	   {System.out.printf("resta  = %d\n", m-n);} 
	static void multiplicacion(int m, int n) {System.out.printf("multiplicación  = %d\n", m*n);} 
	static void division(int m, int n) { 
		if(n==0) System.out.printf("No se puede dividir, divisor = 0"); 
		else     System.out.printf("división  = %.2f\n", (float)m/n); 
	}
}