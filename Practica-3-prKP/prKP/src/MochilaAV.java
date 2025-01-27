
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * 
 * @author
 *
 */
public class MochilaAV extends Mochila {

	static class ValorItem implements Comparable<ValorItem>{
		int peso, valor, indice, unidades;
		double densidad;
		
		public ValorItem(int peso, int valor, int indice, int unidades) {
			this.peso=peso;
			this.valor=valor;
			this.indice=indice;
			this.unidades=unidades;
			densidad= (double) this.valor/ (double) this.peso;
		}
		public int compareTo(ValorItem item2) {
			if(densidad==item2.densidad && indice==item2.indice) {
				return 0;
			}else if(densidad==item2.densidad  && indice> item2.indice) {
				return 1;
			}else if(densidad<item2.densidad) {
				return 1;
			}else {
				return -1;
			}
		}
	}
	public SolucionMochila resolver(ProblemaMochila pm) {
		int [] pesos= pm.getPesos();
		int [] valores = pm.getValores();
		int [] unidades = pm.getUnidades();
		int w= pm.getPesoMaximo();
		int n= pesos.length;
		
		ValorItem [] vali = new ValorItem[n];
		int [] sol = new int [n];
		for(int i=0; i<n; i++) {
			sol[i]=0;
		}
		for(int i=0; i<n; i++) {
			vali[i]= new ValorItem(pesos[i], valores[i], i, unidades[i]);
		}
		Arrays.sort(vali);
		int pesoTotal= 0;
		int valorTotal=0;
		
		int i=0;
		int pesoMaximo= w;
		
		while(i<n && pesoTotal<pesoMaximo) {
			if(vali[i].peso<=pesoMaximo-pesoTotal && vali[i].unidades>=1) {
				sol[vali[i].indice]++;
				pesoTotal+=vali[i].peso;
				valorTotal+=vali[i].valor;
				vali[i].unidades--;
			}else {
				i++;
			}
		}
		ArrayList<Integer> solFinal =  new ArrayList<>();
		solFinal = ArrayUtils.toArray(sol);
		SolucionMochila sm = new SolucionMochila(solFinal, pesoTotal,  valorTotal);
		return sm;
	}
}
