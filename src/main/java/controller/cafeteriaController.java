package controller;

import data.GestorDatos;
import model.Cafe;
import model.Cafeteria;

import java.util.ArrayList;

public class cafeteriaController {


	public boolean agregarCafe(Cafe cafe) {
		Cafeteria cafeteria=new Cafeteria();
		return cafeteria.agregarCafe(cafe);
	}

	public ArrayList<Cafe> obtenerCafes() {
		Cafeteria cafeteria=new Cafeteria();
		return cafeteria.obtenerCafes();
	}

	public boolean modificarCafeteria(Cafeteria cafeteria) {
		throw new UnsupportedOperationException();
	}

	public boolean eliminarCafe(Cafe cafe) {
		throw new UnsupportedOperationException();
	}
}