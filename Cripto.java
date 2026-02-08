package CarteraInversiones;

public final class Cripto extends Activo{
	
	protected double volatilidad;

	public Cripto(String nombre, double valorInicial, double volatilidad) {
		super(nombre, valorInicial);
		this.volatilidad = volatilidad;
	}
	
	@Override
	public double calcularValorFinal() {
		// TODO Auto-generated method stub
		return valorInicial * volatilidad;
	}
}
