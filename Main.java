package CarteraInversiones;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Activo[] activos = new Activo[] {new Accion("Apple", 150, 5), new Cripto("Bitcoin", 40000, 1.2)};
		double patrimonio = 0;
		for (Activo activo : activos) {
			System.out.println("Nombre: "+activo.nombre + "\n Valor: " + activo.calcularValorFinal());
			patrimonio+=activo.calcularValorFinal();
		}
		
		System.out.println("Patrimonio Neto Total= " + (patrimonio - patrimonio*0.21) + "€");
	}

}
