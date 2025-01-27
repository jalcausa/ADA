import java.util.Arrays;

/**
 * 
 * @author ***** Jose A. Onieva ******* Asumimos que: a) Todos los items tienen
 *         un valor >=1 b) W>0
 */

public class MochilaFB extends Mochila {

	
	public SolucionMochila resolver(ProblemaMochila pm) {
		int size = pm.size();
		int [] solParcial = new int [pm.size()];
		int [] sol = new int [pm.size()];
		int solPeso = 0;
		int solValor = 0;
		
		boolean combinaciones = true;
		while(combinaciones) {
			boolean siguiente= true;
			for (int i=0; i<size && siguiente; i++) {
				int cantidad = solParcial[i]+1;
				
				if(cantidad > pm.getItems().get(i).unidades) {
					cantidad =0;
					combinaciones = (i!=size-1);
				}else {
					siguiente=false;
				}
				solParcial[i]=cantidad;
			}
			int valor = pm.sumaValores(solParcial);
			int peso = pm.sumaPesos(solParcial);
			
			if(valor>solValor && peso<=pm.pesoMaximo) {
				sol= Arrays.copyOf(solParcial, solParcial.length);
				solPeso= peso;
				solValor= valor;
			}
		}
		return new SolucionMochila(sol, solPeso, solValor);	
	}

}
