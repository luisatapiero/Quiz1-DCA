package controller;

import java.util.ArrayList;

import model.Logica;
import processing.core.PApplet;

public class Controlador {
	
	private Logica logica;


	public Controlador(PApplet app) {
		logica = new Logica(app);
	}
	
	public void pintarFiguras(PApplet app) {
		logica.pintarFiguras();
		
	}
	
	public void clicFIgura(PApplet app) {
		logica.clicFigura();
	}
	
	
	

}