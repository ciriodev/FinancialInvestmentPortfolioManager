package CarteraInversiones;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		GestorFicheros gestor = new GestorFicheros();

		// 1. Cargamos lo que hubiera guardado
		ArrayList<Activo> misActivos = gestor.cargar();

		// 2. Si la lista está vacía, añadimos algo para probar
		if (misActivos.isEmpty()) {
			misActivos.add(new Accion("Google", 2500, 50));
			misActivos.add(new Cripto("Ethereum", 2200, 1.15));
		}

		// 3. Mostramos la cartera actual
		double total = 0;
		for (Activo a : misActivos) {
			System.out.println(a.nombre + " - Valor final: " + a.calcularValorFinal());
			total += a.calcularValorFinal();
		}
		System.out.println("Patrimonio Total: " + total);

		// 4. Guardamos los cambios antes de salir
		gestor.guardar(misActivos);
	}

}
