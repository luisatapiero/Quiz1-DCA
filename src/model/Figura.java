package model;

import processing.core.PApplet;

public abstract class Figura {
	
	protected String tipo;
	protected int posX;
	protected int posY;
	protected int tam;
	protected int dir;
	protected int valor;
	protected int r;
	protected int g;
	protected int b;
	protected PApplet app;

	public Figura(String tipo, int posX, int posY, int tam, int dir, int valor, int r, int g, int b, PApplet app) {
		this.tipo = tipo;
		this.posX = posX;
		this.posY = posY;
		this.tam = tam;
		this.dir = dir;
		this.valor = valor;
		this.r = r;
		this.g = g;
		this.b = b;
	}

}
