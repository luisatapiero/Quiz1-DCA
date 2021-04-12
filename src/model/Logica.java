package model;

import java.util.ArrayList;

import processing.core.PApplet;

public class Logica {

	private PApplet app;
	private String[] info;
	private ArrayList<String> infoList;
	private ArrayList<Figura> arrayFiguras;

	public Logica(PApplet app) {
		this.app = app;
		infoList = new ArrayList<String>();
		arrayFiguras = new ArrayList<Figura>();
		cargarTxt();
		System.out.println(arrayFiguras.size());
		crearFiguras();

	}

	private void cargarTxt() {
		info = app.loadStrings("./TXT/info.txt");
		separarInfo();

	}

	private void separarInfo() {
		for (int i = 0; i < info.length; i++) {
			String[] arrayInfo = info[i].split(" ");
			for (int j = 0; j < arrayInfo.length; j++) {
				infoList.add(arrayInfo[j]);

			}

		}
	}

	public void pintarFiguras() {
		for (int i = 0; i < getArrayFiguras().size(); i++) {
			getArrayFiguras().get(i).pintarFigura();
		}
		choqueFiguras();

	}

	private void crearFiguras() {
		for (int i = 0; i < infoList.size(); i += 6) {

			if (infoList.get(i).equals("Circulo")) {
				crearCirculo(infoList.get(i), Integer.parseInt(infoList.get(i + 1)),
						Integer.parseInt(infoList.get(i + 2)), Integer.parseInt(infoList.get(i + 3)),
						Integer.parseInt(infoList.get(i + 4)), Integer.parseInt(infoList.get(i + 5)));
			} else if (infoList.get(i).equals("Cuadrado")) {
				crearCuadrado(infoList.get(i), Integer.parseInt(infoList.get(i + 1)),
						Integer.parseInt(infoList.get(i + 2)), Integer.parseInt(infoList.get(i + 3)),
						Integer.parseInt(infoList.get(i + 4)), Integer.parseInt(infoList.get(i + 5)));
			}
		}
	}

	private void crearCirculo(String tipo, int tam, int posX, int posY, int dir, int value) {
		Circulo circulo = new Circulo(tipo, tam, posX, posY, dir, value, app);
		arrayFiguras.add(circulo);
	}

	private void crearCuadrado(String tipo, int tam, int posX, int posY, int dir, int value) {
		Cuadrado cuadrado = new Cuadrado(tipo, tam, posX, posY, dir, value, app);
		arrayFiguras.add(cuadrado);
	}

	private void crearTriangulo(String tipo, int tam, int posX, int posY, int dir, int value) {
		Triangulo triangulo = new Triangulo(tipo, tam, posX, posY, dir, value, app);
		arrayFiguras.add(triangulo);
	}

	public void clicFigura() {

		for (int i = 0; i < arrayFiguras.size(); i++) {
			if (app.mouseX > (arrayFiguras.get(i).getPosX() - (arrayFiguras.get(i).getTam() / 2))
					&& app.mouseX < (arrayFiguras.get(i).getPosX() + (arrayFiguras.get(i).getTam() / 2))
					&& app.mouseY > (arrayFiguras.get(i).getPosY() - (arrayFiguras.get(i).getTam() / 2))
					&& app.mouseY < (arrayFiguras.get(i).getPosY() + (arrayFiguras.get(i).getTam() / 2))
					&& !arrayFiguras.get(i).getTipo().equals("Triangulo")) {
				arrayFiguras.get(i).setMueve(!arrayFiguras.get(i).isMueve());

			} else if (app.mouseX > (arrayFiguras.get(i).getPosX())
					&& app.mouseX < (arrayFiguras.get(i).getPosX() + arrayFiguras.get(i).getTam())
					&& app.mouseY > (arrayFiguras.get(i).getPosY())
					&& app.mouseY < (arrayFiguras.get(i).getPosY() + (arrayFiguras.get(i).getTam() / 2))
					&& arrayFiguras.get(i).getTipo().equals("Triangulo")) {

				arrayFiguras.get(i).setMueve(!arrayFiguras.get(i).isMueve());
			}
		}

	}
	
	public void clicDerecho(){
		nuevasFiguras();
	}

	private void choqueFiguras() {
		for (int i = 0; i < arrayFiguras.size(); i++) {
			for (int j = 0; j < arrayFiguras.size(); j++) {
				if (arrayFiguras.get(i) != arrayFiguras.get(j)
						&& (PApplet.dist(arrayFiguras.get(i).getPosX(), arrayFiguras.get(i).getPosY(),
								arrayFiguras.get(j).getPosX(),
								arrayFiguras.get(j)
										.getPosY()) < (arrayFiguras.get(i).tam / 2 + arrayFiguras.get(j).getTam() / 2))
						&& !arrayFiguras.get(i).getTipo().equals("Triangulo")
						&& !arrayFiguras.get(j).getTipo().equals("Triangulo")) {
					int valor = arrayFiguras.get(i).getValor() + arrayFiguras.get(j).getValor();
					int posX = (arrayFiguras.get(i).getPosX() + arrayFiguras.get(j).getPosX()) / 2;
					int posY = (arrayFiguras.get(i).getPosY() + arrayFiguras.get(j).getPosY()) / 2;

					crearTriangulo("Triangulo", (int) app.random(20, 60), posX, posY, 1, valor);
					System.out.println(arrayFiguras.get(arrayFiguras.size() - 1).getPosX());
					System.out.println(app.mouseX);
					arrayFiguras.remove(i);
					arrayFiguras.remove(j - 1);
				}
			}
		}
	}
	
	public void nuevasFiguras() {
		int aleatoria = (int) app.random(1,10);
		if (aleatoria <= 5 && aleatoria >= 1) {
			crearCirculo("Circulo", (int) app.random(20, 60), (int) app.random(20, 580), (int) app.random(20, 580), -1, (int) app.random(1, 20));

		} else if (aleatoria <= 10 && aleatoria >= 6) {
			crearCuadrado("Cuadrado", (int) app.random(20, 60), (int) app.random(20, 580), (int) app.random(20, 580), -1, (int) app.random(1, 20));
		}
		
	}

	public ArrayList<String> getInfoList() {
		return infoList;
	}

	public void setInfoList(ArrayList<String> infoList) {
		this.infoList = infoList;
	}

	public ArrayList<Figura> getArrayFiguras() {
		return arrayFiguras;
	}

	public void setArrayFiguras(ArrayList<Figura> arrayFiguras) {
		this.arrayFiguras = arrayFiguras;
	}

}
