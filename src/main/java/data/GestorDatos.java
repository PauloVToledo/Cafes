package data;

import model.Cafe;
import model.Cafeteria;

import java.io.*;
import java.util.ArrayList;

public class GestorDatos {
	private String direccionArchivo;

	public GestorDatos(String direccionArchivo) {
		this.direccionArchivo = direccionArchivo;
	}

	public ArrayList<Cafe> obtenerCafes() {
		String textoArchivo = "";
		ArrayList<Cafe> cafesEncontrados=new ArrayList<>();
		try {
			File archivo = new File(this.direccionArchivo);
			if (!archivo.exists()) {
				archivo.createNewFile();
			}
			// Comprobamos si existe
			FileReader fileReader = new FileReader(archivo);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			//Lee cada linea del archivo hasta que la linea sea nula
			while ((textoArchivo = bufferedReader.readLine()) != null) {
				String[] data = textoArchivo.split(",");
					cafesEncontrados.add(new Cafe(Integer.parseInt(data[0]),Integer.parseInt(data[1]),data[2],data[3]));
			}
			//Con eso corroboramos que el cliente no esta registrado por RUT
			fileReader.close();
			bufferedReader.close();
			return cafesEncontrados;
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
			return null;
		}
	}

	public boolean eliminarCafe(Cafe cafe) {
		try {
			// Abrir el archivo de texto en modo de lectura
			File archivo = new File("informacion.txt");
			FileReader lector = new FileReader(archivo);
			BufferedReader bufferLector = new BufferedReader(lector);

			// Leer el contenido del archivo línea por línea
			String linea;
			String contenido = "";
			while ((linea = bufferLector.readLine()) != null) {
				if (!linea.startsWith(cafe.getGCafe()+",")) {
					contenido += linea + "\n";
				}
			}

			// Cerrar el archivo de lectura
			bufferLector.close();
			lector.close();

			// Abrir el archivo de texto en modo de escritura
			FileWriter escritor = new FileWriter(archivo);
			BufferedWriter bufferEscritor = new BufferedWriter(escritor);

			// Escribir el contenido modificado en el archivo de texto
			bufferEscritor.write(contenido);

			// Cerrar el archivo de escritura
			bufferEscritor.close();
			escritor.close();
			return  true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean agregarCafe(Cafe cafe) {
		boolean lineaVacia=false;
		try{
			File archivo=new File(this.direccionArchivo);
			if (!archivo.exists()) {
				archivo.createNewFile();
			}
			FileWriter fileWriter = new FileWriter(archivo, true);
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

			if (lineaVacia == false) {
				bufferedWriter.newLine();
			}
			//bufferedWriter.write(cliente.toString());
			bufferedWriter.write(cafe.getGCafe()+","+cafe.getMmAgua()+","
					+cafe.getSize()+","+cafe.getOptIngrediente());
			bufferedWriter.close();
			fileWriter.close();

			return true;
		}catch (Exception e){
			System.out.println("Error al ingresar hora de llegada, favor contactar con administrador");
			return false;
		}
	}

	public boolean modificaCafeteria(Cafeteria cafeteria) {
		try {
			// Abrir el archivo de texto en modo de lectura
			File archivo = new File(this.direccionArchivo);
			FileReader lector = new FileReader(archivo);
			BufferedReader bufferLector = new BufferedReader(lector);

			// Leer el contenido del archivo línea por línea
			String linea;
			String contenido = cafeteria.getNombre()+","+cafeteria.getDireccion()+","+cafeteria.getRedesSociales();
			while ((linea = bufferLector.readLine()) != null) {
				if (linea.startsWith("Nombre:")) {
					// Si la línea empieza con "Edad:", modificar el valor de la edad
					linea = "Nombre:";
				}
				contenido += linea + "\n";
			}

			// Cerrar el archivo de lectura
			bufferLector.close();
			lector.close();

			// Abrir el archivo de texto en modo de escritura
			FileWriter escritor = new FileWriter(archivo);
			BufferedWriter bufferEscritor = new BufferedWriter(escritor);

			// Escribir el contenido modificado en el archivo de texto
			bufferEscritor.write(contenido);

			// Cerrar el archivo de escritura
			bufferEscritor.close();
			escritor.close();
			System.out.println("El archivo ha sido modificado correctamente.");
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
}