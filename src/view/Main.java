package view;

import controller.Controlador;
import processing.core.PApplet;

public class Main extends PApplet{
	
	private Controlador controlador;

	public static void main(String[] args) {
		PApplet.main(Main.class.getName());

	}
	
	
	public void settings() {
		size(600, 600);
	}
	
	
	public void setup() {
		controlador = new Controlador(this);

	}
	
	
	public void draw() {
		background(255);
		controlador.pintarFiguras(this);
	
	}

}
