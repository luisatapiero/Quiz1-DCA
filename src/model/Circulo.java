package model;

import processing.core.PApplet;

public class Circulo extends Figura {

	private int velX;
	private int velY;

	public Circulo(String tipo, int tam, int posX, int posY, int dir, int valor, PApplet app) {
		super(tipo, tam, posX, posY, dir, valor, app);
		fijarColor();

		velX = 2;
		velY = 1;
	}

	@Override
	protected void pintarFigura() {
		app.stroke(0);
		app.strokeWeight(1);
		app.fill(r, g, b);
		app.circle(posX, posY, tam);
		app.fill(0);
		app.stroke(255);
		app.strokeWeight(5);
		app.textSize(14);
		app.text(valor, posX, posY);
		mover();

	}

	@Override
	protected void mover() {

		if (mueve) {
			posX += velX * dir;
			posY += velY * dir;
			rebotar();
		}

	}

	protected void rebotar() {
		if (posX - tam / 2 < 0 || posX + tam / 2 > app.width) {
			velX *= -1;
		}

		if (posY - tam / 2 < 0 || posY + tam / 2 > app.height) {
			velY *= -1;
		}
	}

}
