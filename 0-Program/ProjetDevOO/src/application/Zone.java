package application;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

public class Zone {
	private String nomFichier;
	private HashMap<Integer, Noeud> noeuds ;
	
	
	
	
	public Zone(String nomFichier) {
		super();
		this.nomFichier = nomFichier;
		noeuds=new HashMap<>();
	}
	
	public Zone(String nomFichier,ArrayList<Noeud> noeuds) {
		super();
		this.nomFichier = nomFichier;
		this.noeuds=new HashMap<>();
		this.addAllNoeud(noeuds);
	}
	
	public String getNomFichier() {
		return nomFichier;
	}
	
	
	
	public HashMap<Integer, Noeud> getNoeuds() {
		return noeuds;
	}
	
	
	public void addNoeud(Noeud noeud) {
		noeuds.put(noeud.getId(),noeud);
	}
	
	public void addAllNoeud(ArrayList<Noeud> noeuds) {
		for (Noeud noeud : noeuds) {
			addNoeud(noeud);
		}
	}
	
	
	public int getMinX() {
		int MinX=Integer.MAX_VALUE;
		for (Entry<Integer,Noeud> entry: noeuds.entrySet()) {
			if (MinX>entry.getValue().getX()) MinX=entry.getValue().getX();
		}
		return MinX;
	}
	
	public int getMaxX() {
		int MaxX=0;
		for (Entry<Integer,Noeud> entry: noeuds.entrySet()) {
			if (MaxX<entry.getValue().getX()) MaxX=entry.getValue().getX();
		}
		return MaxX;
	}
	
	public int getMinY() {
		int MinY=Integer.MAX_VALUE;
		for (Entry<Integer,Noeud> entry: noeuds.entrySet()) {
			if (MinY>entry.getValue().getY()) MinY=entry.getValue().getY();
		}
		return MinY;
	}
	
	public int getMaxY() {
		int MaxY=0;
		for (Entry<Integer,Noeud> entry: noeuds.entrySet()) {
			if (MaxY<entry.getValue().getY()) MaxY=entry.getValue().getY();
		}
		return MaxY;
	}


	
	

}
