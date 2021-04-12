package model;

import processing.core.PApplet;

public class Triangulo extends Figura {
	
	protected int velX;
	protected int velY;

	public Triangulo(String tipo, int tam, int posX, int posY, int dir, int valor, PApplet app) {
		super(tipo, tam, posX, posY, dir, valor, app);
		fijarColor();
		velX = 1;
		velY = 2;
	}

	@Override
	protected void pintarFigura() {
		app.noStroke();
		app.fill(r, g, b);
		app.triangle(posX, posY, posX + tam / 2, posY - tam, posX + tam, posY);
		app.fill(0);
		app.stroke(255);
		app.strokeWeight(5);
		app.textSize(14);
		app.text(valor, posX + tam / 2, posY - tam / 2);
		mover();

	}

	protected void mover() {

		if (mueve) {
			posX += velX * dir;
			posY += velY * dir;
			rebotar();
		}

	}

	protected void rebotar() {
		if (posX < 0 || posX + tam > app.width) {
			velX *= -1;
		}
		
		if (posY - tam/2 <= 0  || posY > app.height) {
		    velY *= -1;
		  }

	}
}
