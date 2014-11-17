package application;

import java.util.ArrayList;

public class Noeud {
	private int id;
	private int x;
	private int y;
	private ArrayList<Troncon> listeTronconSortants;
	
	public Noeud(int id, int x, int y) {
		super();
		this.id=id;
		this.x=x;
		this.y=y;
		listeTronconSortants=new ArrayList<>();	
	}

	public ArrayList<Troncon> getListeTronconSortants() {
		return listeTronconSortants;
	}

	public int getId() {
		return id;
	}

	
	public int getX() {
		return x;
	}

	
	public int getY() {
		return y;
	}	
	
	public ArrayList<Integer> getSucc() {
		ArrayList<Integer> listSucc=new ArrayList<>();
		for (Troncon troncon : getListeTronconSortants()) {
			listSucc.add(troncon.getDestination().getId());
		}
		return listSucc;
	}

	@Override
	public String toString() {
		return "Noeud [id=" + id + ", x=" + x + ", y=" + y + "]";
	}

	
	
	
	

}
