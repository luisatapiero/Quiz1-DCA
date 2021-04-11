package model;

import java.util.ArrayList;

import processing.core.PApplet;

public class Logica {
	
	private PApplet app;
	private String[] info;
	private ArrayList <String> infoList;

	public Logica(PApplet app) {
		this.app = app;
		infoList = new ArrayList<String>();
		cargarTxt();
		separarInfo();
	}
	
	private void cargarTxt() {
		info = app.loadStrings("./TXT/info.txt");
	}
	
	private void separarInfo() {
		for (int i = 0; i < info.length; i++) {
			String[] arrayInfo = info[i].split(" ");
			for (int j = 0; j < arrayInfo.length; j++) {
				infoList.add(arrayInfo[j]);
				System.out.println(arrayInfo[j]);
			}
			
		}
	}

}
