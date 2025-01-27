public class PruebaAlgoritmo {
	
	private static Temporizador temporizador = new Temporizador();
	public static void main(String[] args) {
		int n=100;
		temporizador.reiniciar();
		temporizador.iniciar();
		Algoritmo.f(n);
		temporizador.parar();
		System.out.println(temporizador.tiempoPasado());
	}

}
