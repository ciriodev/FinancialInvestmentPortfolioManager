package CarteraInversiones;

public final class Accion extends Activo{
	
	protected double dividendo;

	public Accion(String nombre, double valorInicial, double dividendo) {
		super(nombre, valorInicial);
		this.dividendo = dividendo;
	}
	
	@Override
	public double calcularValorFinal() {
		// TODO Auto-generated method stub
		return valorInicial + dividendo;
	}
}
