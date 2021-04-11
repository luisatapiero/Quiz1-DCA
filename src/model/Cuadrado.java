package model;

import processing.core.PApplet;

public class Cuadrado extends Figura{
	
	private int velX;
	private int velY;

	public Cuadrado(String tipo, int tam, int posX, int posY, int dir, int valor, PApplet app) {
		super(tipo, tam, posX, posY, dir, valor, app);
		fijarColor();
		
		velX = 2;
		velY = 1;
	}
	

	@Override
	protected void pintarFigura() {
		app.rectMode(PApplet.CENTER);
		app.noStroke();
		app.fill(r, g, b);
		app.square(posX, posY, tam);
		app.fill(0);
		app.textAlign(PApplet.CENTER);
		app.stroke(255);
		app.strokeWeight(2);
		app.textSize(14);
		app.text(valor, posX, posY+5);
		mover();		
	}


	@Override
	protected void mover() {
		posX += velX * dir;
		posY += velY * dir;
		rebotar();
	}
	
	
	protected void rebotar() {
		if (posX - tam/2 < 0 || posX + tam/2 > app.width) {
		    velX *= -1;
		  }

		  if (posY - tam/2 < 0  || posY + tam/2 > app.height) {
		    velY *= -1;
		  }
	}
	
	

}
