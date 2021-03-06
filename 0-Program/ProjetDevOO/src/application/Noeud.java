package application;

import java.util.ArrayList;

/**
 * classe repr�sentant un noeud (un point d'une zone donn�e)
 * 
 * @author H4102
 *
 */
public class Noeud {
	/**
	 * identifiant du noeud dans la zone
	 */
	private int id;

	/**
	 * Abscisse du noeud
	 */
	private int x;
	/**
	 * Ordonn�e du noeud
	 */
	private int y;

	/**
	 * liste des tron�ons sortants du noeud
	 */
	private ArrayList<Troncon> listeTronconSortants;

	/**
	 * Construit le noeud, la liste des tron�ons sortants est vide
	 * 
	 * @param id
	 *            identifiant du noeud dans la zone
	 * @param x
	 *            Abscisse du noeud
	 * @param y
	 *            Ordonn�e du noeud
	 */
	public Noeud(int id, int x, int y) {
		super();
		this.id = id;
		this.x = x;
		this.y = y;
		listeTronconSortants = new ArrayList<>();
	}

	/**
	 * 
	 * @return liste des tron�ons sortants du noeud
	 */
	public ArrayList<Troncon> getListeTronconSortants() {
		return listeTronconSortants;
	}

	/**
	 * 
	 * @return identifiant du noeud dans la zone
	 */
	public int getId() {
		return id;
	}

	/**
	 * 
	 * @return Abscisse du noeud
	 */
	public int getX() {
		return x;
	}

	/**
	 * 
	 * @return Ordonn�e du noeud
	 */
	public int getY() {
		return y;
	}

	/**
	 * 
	 * @return la liste des identifiants des noeuds succ�dants le noeud
	 */
	public ArrayList<Integer> getSucc() {
		ArrayList<Integer> listSucc = new ArrayList<>();
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
