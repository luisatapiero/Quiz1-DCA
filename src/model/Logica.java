package model;

import java.util.ArrayList;

import processing.core.PApplet;

public class Logica {

	private PApplet app;
	private String[] info;
	private ArrayList<String> infoList;
	// private ArrayList<Cuadrado> cuadradoList;
	// private ArrayList<Circulo> circuloList;
	// private ArrayList<Triangulo> trianguloList;
	private ArrayList<Figura> arrayFiguras;

	public Logica(PApplet app) {
		this.app = app;
		infoList = new ArrayList<String>();
		// cuadradoList = new ArrayList<Cuadrado>();
		// circuloList = new ArrayList<Circulo>();
		// trianguloList = new ArrayList<Triangulo>();
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
			//arrayFiguras()).get(i).move();
		}
	}

	private void crearFiguras() {
		for (int i = 0; i < infoList.size(); i += 6) {

			if (infoList.get(i).equals("Circulo")) {
				crearCirculo(infoList.get(i), Integer.parseInt(infoList.get(i + 1)),
						Integer.parseInt(infoList.get(i + 2)), Integer.parseInt(infoList.get(i + 3)),
						Integer.parseInt(infoList.get(i + 4)), Integer.parseInt(infoList.get(i + 5)));
				System.out.println("sirve1");
			} else if (infoList.get(i).equals("Cuadrado")) {
				System.out.println("sirve2");
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
