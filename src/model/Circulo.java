package model;

import processing.core.PApplet;

public class Circulo extends Figura{

	public Circulo(String tipo, int tam, int posX, int posY, int dir, int valor, PApplet app) {
		super(tipo, tam, posX, posY, dir, valor, app);
		fijarColor();
	}
	
	@Override
	protected void pintarFigura() {
		app.noStroke();
		app.fill(r, g, b);
		app.circle(posX, posY, tam);
		app.fill(0);
		app.stroke(255);
		app.strokeWeight(2);
		app.textSize(14);
		app.text(valor, posX, posY);
		
	}
	

}
