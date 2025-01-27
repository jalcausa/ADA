public class Analizador {
	
	private static Temporizador temporizador = new Temporizador();
	
	public static void main(String[] args) {
		int [] n1 = {10, 12, 15};
		int [] n2 = {20, 24, 30};
		double ratio = ratio(n1,n2);
		if(ratio>1000) {
			if(ratio<35000) {
				System.out.println("2N");
			}else {
				System.out.println("NF");
			}
		}else {
			int [] m1= {10000,12000,15000};
			int [] m2= {20000,22000,30000};
			ratio = ratio(m1,m2);
			if(6.0<=ratio && ratio<=10.0) {
				System.out.println("N3");
			}else if(2.3<=ratio && ratio<=6) {
				System.out.println("N2");
			}else if (1.6<ratio && ratio<2.3) {
				System.out.println("NLOGN");
			}else{
				int [] p1 = {1000, 2000, 3000};
				int [] p2 = {1000000, 2000000, 3000000};
				ratio= ratio(p1,p2);
				if(ratio>100) {
					System.out.println("N");
				}else if(ratio<1 || (ratio>1 && ratio<1.05)) {
					System.out.println("LOGN");
				}else {
					System.out.println("1");
				}
			}
		}
		
	}
	private static double  ratio (int [] n1, int[] n2) {
		long [] t1 = new long[n1.length];
		long [] t2 = new long [n1.length];
		
		double [] ratio = new double [n1.length];
		
		for (int nTam=0; nTam<n1.length; ++nTam) {
			temporizador.reiniciar();
			temporizador.iniciar();
			Algoritmo.f(n1[nTam]);
			temporizador.parar();
			t1[nTam] = temporizador.tiempoPasado();
			
			temporizador.reiniciar();
			temporizador.iniciar();
			Algoritmo.f(n2[nTam]);
			temporizador.parar();
			t2[nTam] = temporizador.tiempoPasado();
			ratio[nTam] = t2[nTam]/t1[nTam];
		}
		return mediaRatio(ratio);
	}	
	private static double mediaRatio (double [] ratio) {
		double ratioMedio=0;
		for (int i=0; i<ratio.length; ++i) {
			ratioMedio+=ratio[i];
		}
		ratioMedio= ratioMedio/ratio.length;
		return ratioMedio;
	}
}

