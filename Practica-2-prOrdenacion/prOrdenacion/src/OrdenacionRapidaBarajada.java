////////////////////////////////////////////////////////////////////////////////////////////
// ALUMNO:
// GRUPO:
////////////////////////////////////////////////////////////////////////////////////////////

public class OrdenacionRapidaBarajada extends OrdenacionRapida {
	
	public static <T extends Comparable<? super T>> void ordenar(T v[]) {
		barajar(v);
		OrdenacionRapida.ordenar(v);
	}

    private static <T> void barajar(T v[]) {
    	for(int i=0; i<v.length; i++) {
    		int n= aleat.nextInt(v.length-1);
    		intercambiar(v,n,i);
    	}
    }	
	

}
