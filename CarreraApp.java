import java.util.Random;
import java.util.Arrays;
interface Constantes{
	final static int EQUIPOS = 8, POSTAS = 4; 
}
class CarreraApp implements Constantes{
	public static void main(String[] args){
		System.out.println("\tBienvenidos a la carrera de " + POSTAS + " postas");
		Equipo[] equipos = new Equipo[EQUIPOS];
		for(int i=0; i<EQUIPOS; i++) equipos[i] = new Equipo(i);
		for(Equipo eq: equipos) eq.correr();
//		for(int i=0; i<EQUIPOS; i++) {equipos[i] = new Equipo(i); equipos[i].correr();}  No representa a la realidad
		Arrays.sort(equipos);
		System.out.println("Equipo  Tiempos ordenados por TOTAL");		
		System.out.println("\tPosta 1\tPosta 2\tPosta 3\tPosta 4\tTOTAL");
		for(Equipo eq: equipos)
			System.out.printf("    %2d       %2d      %2d      %2d      %2d    %2d\n", eq.numero,
				eq.tiempoCorredor[0], eq.tiempoCorredor[1], eq.tiempoCorredor[2], eq.tiempoCorredor[3], eq.tiempo);
		System.out.println("Felicitaciones al equipo " + equipos[0].numero + ", ganador de la carrera.");
	}
}
class Equipo implements Constantes, Comparable{
	static Random ran = new Random();
	int numero, tiempo;
	int[] tiempoCorredor = new int[POSTAS];
	Equipo(int numero){
		this.numero = numero+1;
	}
	void correr(){
		for(int i=0; i<POSTAS; i++){
			tiempoCorredor[i] = ran.nextInt(4)+10;
			tiempo += tiempoCorredor[i];
		}
	}
	public int compareTo(Object obj) {
		Equipo eqi = (Equipo) obj;
		if (tiempo < eqi.tiempo) return -1 ;   
		if (tiempo > eqi.tiempo) return 1 ;   
		return 0 ;
	}		
}