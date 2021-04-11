package model;

import processing.core.PApplet;

public class Cuadrado extends Figura{

	public Cuadrado(String tipo, int tam, int posX, int posY, int dir, int valor, PApplet app) {
		super(tipo, tam, posX, posY, dir, valor, app);
	}
	

	@Override
	protected void pintarFigura() {
		app.fill(0);
		app.square(posX, posY, tam);
		app.stroke(0);
		app.strokeWeight(2);
		app.textSize(14);
		app.fill(255);
		app.text(valor, posX, posY+8);
		
	}

}
