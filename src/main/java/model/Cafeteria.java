package model;

import java.util.ArrayList;

import data.GestorDatos;
import model.Cafe;

public class Cafeteria {
	private String nombre;
	private String direccion;
	private ArrayList<String> redesSociales;
	private ArrayList<Cafe> cafes = new ArrayList<Cafe>();

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public ArrayList<String> getRedesSociales() {
		throw new UnsupportedOperationException();
	}

	public void setRedesSociales(ArrayList<String> redesSociales) {
		throw new UnsupportedOperationException();
	}
	public boolean agregarCafe(Cafe cafe){
		GestorDatos gestorDatos=new GestorDatos("cafes.txt");
		return gestorDatos.agregarCafe(cafe);
	}
	public ArrayList<Cafe> obtenerCafes(){
		GestorDatos gestorDatos=new GestorDatos("cafes.txt");
		return gestorDatos.obtenerCafes();
	}
	public boolean eliminarCafe(){
		return true;
	}

}