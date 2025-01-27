////////////////////////////////////////////////////////////////////////////////////////////
// ALUMNO: Juan Carlos Alcausa Luque
// GRUPO: D
////////////////////////////////////////////////////////////////////////////////////////////

public class OrdenacionRapida extends Ordenacion {
  
	public static <T extends Comparable<? super T>> void ordenar(T v[]) {
	    ordRapidaRec(v, 0, v.length-1);
	}

	public static <T extends Comparable<? super T>> void ordRapidaRec(T v[], int izq, int der) {
	    if(izq<der) {
	    	int pivote = partir(v, v[izq], izq, der);
	    	
	    	ordRapidaRec(v, izq, pivote-1);
	    	ordRapidaRec(v, pivote+1, der);
	    }
	}
	   
   public static <T extends Comparable<? super T>> int partir(T v[], T pivote, int izq, int der) {
	   
	   int i=izq+1;
	   int j= der;
	   
	   do {
		   while((i<=j) && (v[i].compareTo(pivote)<=0)) {
			   i++;
		   }while((i<=j) && (v[j].compareTo(pivote)>0)) {
			   j--;
		   }if(i<j) {
			   intercambiar(v,i,j);
		   }
	   }while(i<j);	
	   intercambiar(v,izq,j);
	   return j;
   }

	public static void main (String args[]) {
	
		Integer vEnt[] = {3,8,6,5,2,9,1,1,4};
		ordenar(vEnt);
		System.out.println(vectorAString(vEnt));

		Character vCar[] = {'d','c','v','b'};
		ordenar(vCar);
		System.out.println(vectorAString(vCar));

	}	
    
}
