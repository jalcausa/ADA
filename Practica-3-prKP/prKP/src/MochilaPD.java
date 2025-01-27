/**
 * 
 * @author ***** Jose A. Onieva *******
 *
 */
import java.util.ArrayList;

public class MochilaPD extends Mochila {
	
	public SolucionMochila resolver(ProblemaMochila pm) {
		SolucionMochila sm=null;
		int filas = pm.size()+1;
		int col = pm.getPesoMaximo()+1;
		int [][] F = new int [filas][col];
		for (int i=0; i<filas; i++) {
			F[i][0]=0; //Casos base
		}
		for (int j=0; j<col; j++) {
			F[0][j]=0; //Casos base
		}
		for (int i=1; i<filas; i++) {
			for(int j=0; j<col; j++) {
				int peso = pm.getPeso(i-1);
				if(j-peso<0) {
					F[i][j]=F[i-1][j];
				}else {
					F[i][j]= Math.max(F[i-1][j], F[i-1][j-peso]+ pm.getValor(i-1));
				}
			}
		}
		int res = F[filas-1][col-1];
		int valores = res;
		int w= pm.getPesoMaximo();
		ArrayList<Integer> itemsSol = new ArrayList<>();
		ArrayList<Item> items = pm.getItems();
		
		for(int i=filas-1; i>0 && res>0; i--) {
			if(res!=F[i-1][w]) {
				itemsSol.add(items.get(i-1).index);
				res-=items.get(i-1).valor;
				w-=items.get(i-1).peso;
			}
		}
		
		ArrayList<Integer> v= new ArrayList<>();
		for (int i=0; i<items.size(); i++) {
			v.add(0);
		}
		
		for(Integer val: itemsSol) {
			v.set(val, 1);
		}
		
		sm= new SolucionMochila(v, pm.getPesoMaximo()-w, valores);
		return sm;
	}
}
