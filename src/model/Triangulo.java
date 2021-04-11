package model;

import processing.core.PApplet;

public class Triangulo extends Figura {

	public Triangulo(String tipo, int tam, int posX, int posY, int dir, int valor, PApplet app) {
		super(tipo, tam, posX, posY, dir, valor, app);
		fijarColor();
	}

	@Override
	protected void pintarFigura() {
		app.noStroke();
		app.fill(r, g, b);
		app.triangle(posX, posY, posX + tam/2, posY - tam, posX + tam, posY);
		app.fill(0);
		app.stroke(255);
		app.strokeWeight(5);
		app.textSize(14);
		app.text(valor, posX + tam/2, posY - tam/2);
		// mover();

		
	}

	@Override
	protected void mover() {
		// TODO Auto-generated method stub

	}

}
