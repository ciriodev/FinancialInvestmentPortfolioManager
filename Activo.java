package CarteraInversiones;

public abstract class Activo {

	protected String nombre;
	protected double valorInicial;
	
	public Activo(String nombre, double valorInicial) {
		this.nombre = nombre;
		this.valorInicial = valorInicial;
	}
	
	
	public abstract double calcularValorFinal();
	
	
}
