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
	protected boolean mueve;
	protected PApplet app;

	public Figura(String tipo, int tam, int posX, int posY, int dir, int valor, PApplet app) {
		this.tipo = tipo;
		this.tam = tam;
		this.posX = posX;
		this.posY = posY;
		this.dir = dir;
		this.valor = valor;
		this.app = app;

		mueve = true;

	}

	protected void fijarColor() {
		r = (int) (app.random(0, 255));
		g = (int) (app.random(0, 255));
		b = (int) (app.random(0, 255));

	}

	protected abstract void pintarFigura();

	protected abstract void mover();
		

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public int getTam() {
		return tam;
	}

	public void setTam(int tam) {
		this.tam = tam;
	}

	public int getDir() {
		return dir;
	}

	public void setDir(int dir) {
		this.dir = dir;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public boolean isMueve() {
		return mueve;
	}

	public void setMueve(boolean mueve) {
		this.mueve = mueve;
	}
	
	

}
