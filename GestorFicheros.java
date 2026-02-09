package CarteraInversiones;

import java.io.*;
import java.util.ArrayList;

public class GestorFicheros {
    private String filename = "files/cartera.dat";

    public void guardar(ArrayList<Activo> activos) {
        try (RandomAccessFile fitxer = new RandomAccessFile(filename, "rw")) {
            fitxer.setLength(0); // Vaciamos el archivo para escribir de nuevo
            for (Activo a : activos) {
                fitxer.writeUTF(a.nombre);
                fitxer.writeDouble(a.valorInicial);
                
                if (a instanceof Accion) {
                    fitxer.writeInt(1); // ID para Accion
                    fitxer.writeDouble(((Accion) a).dividendo);
                } else {
                    fitxer.writeInt(2); // ID para Cripto
                    fitxer.writeDouble(((Cripto) a).volatilidad);
                }
            }
        } catch (IOException e) {
            System.out.println("Error al guardar: " + e.getMessage());
        }
    }

    public ArrayList<Activo> cargar() {
        ArrayList<Activo> lista = new ArrayList<>();
        File f = new File(filename);
        
        // Si el archivo no existe, ni lo intentamos
        if (!f.exists()) {
            System.out.println("Archivo no encontrado. Creando cartera nueva...");
            return lista;
        }

        try (RandomAccessFile fitxer = new RandomAccessFile(filename, "r")) {
            while (fitxer.getFilePointer() < fitxer.length()) {
                // Leemos en el orden exacto
                String nom = fitxer.readUTF();
                double val = fitxer.readDouble();
                int tipo = fitxer.readInt();
                
                if (tipo == 1) { // Accion
                    double div = fitxer.readDouble();
                    lista.add(new Accion(nom, val, div));
                } else if (tipo == 2) { // Cripto
                    double vol = fitxer.readDouble();
                    lista.add(new Cripto(nom, val, vol));
                }
            }
        } catch (Exception e) {
            // Esto nos dirá exactamente qué línea falla
            System.out.println("Error específico: " + e.getMessage());
            e.printStackTrace(); 
        }
        return lista;
    }
    
    
    public void buscarArchivo(String nombre) {
		nombre = nombre.trim();
    	RandomAccessFile rnd = null;
    	File f = new File("cartera.dat");
    	if (!f.exists()) {
    	    System.out.println("La bóveda está cerrada (el archivo no existe aún).");
    	    return;
    	}
    	try {
			rnd = new RandomAccessFile(filename, "r");
			
			while (rnd.getFilePointer() < rnd.length()) {
				String nombreActual = rnd.readUTF();
				System.out.println("Puntero después de leer nombre: " + rnd.getFilePointer());
				if (nombreActual.equalsIgnoreCase(nombre)) {
					double valor = rnd.readDouble();
					System.out.println(nombre + " encontrado! Valor = " + valor);
					return;
				}else {
					long posicionSalto = rnd.getFilePointer() +20;
					rnd.seek(posicionSalto);
				}
			}
			System.out.println(nombre + " no encontrado.");
			rnd.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
    	
    	
    }
    

}
