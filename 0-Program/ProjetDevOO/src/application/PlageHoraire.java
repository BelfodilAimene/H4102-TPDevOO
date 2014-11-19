package application;

import java.util.ArrayList;

/**
 * classe repr�sentant une plage horaire, elle contient aussi la liste des
 * livraisons pr�vues durant cette plage
 * 
 * @author H4102
 */
public class PlageHoraire {

	/**
	 * heure debut de la plage
	 */
	private Temps heureDebut;

	/**
	 * heure fin de la plage
	 */
	private Temps heureFin;

	/**
	 * liste des livraisons pr�vues durant cette plage
	 */
	private ArrayList<Livraison> listeLivraisons;

	/**
	 * construit une plage horaire avec une liste de livraison vide
	 * 
	 * @param heureDebut
	 *            heure debut de la plage
	 * @param heureFin
	 *            heure fin de la plage
	 */
	public PlageHoraire(Temps heureDebut, Temps heureFin) {
		super();
		this.heureDebut = heureDebut;
		this.heureFin = heureFin;
		this.listeLivraisons = new ArrayList<>();
	}

	/**
	 * 
	 * @return heure debut de la plage
	 */
	public Temps getHeureDebut() {
		return heureDebut;
	}

	/**
	 * 
	 * @return heure fin de la plage
	 */
	public Temps getHeureFin() {
		return heureFin;
	}

	/**
	 * 
	 * @return liste des livraisons pr�vues pour cette plage
	 */
	public ArrayList<Livraison> getListeLivraisons() {
		return listeLivraisons;
	}

	/**
	 * Ajoute la livraison dans la liste, et modifie l'objet livraison en
	 * mettant la plage horaire dans celui-ci
	 * 
	 * @param livraison
	 *            livraison pr�vu pour cette plage
	 */
	public void addLivraison(Livraison livraison) {
		livraison.setPlageHoraire(this);
		this.getListeLivraisons().add(livraison);
	}

	/**
	 * 
	 * @return nombre de livraisons pr�vu durant cette plage
	 */
	public int getNombreLivraisons() {
		return listeLivraisons.size();
	}

	/**
	 * 
	 * @param noeud
	 *            noeud
	 * @return la livraison pr�vu pour ce noeud (un noeud peut �tre associ� �
	 *         une seule livraison au max). retourne null dans le cas ou
	 *         aucune livraison dans cette plage correspond au noeud
	 */
	public Livraison getLivraisonDeNoeud(Noeud noeud) {
		for (Livraison L : this.getListeLivraisons()) {
			if (L.getNoeudLivraison() == noeud)
				return L;
		}
		return null;
	}

	@Override
	public String toString() {
		return "PlageHoraire [heureDebut=" + heureDebut + ", heureFin="
				+ heureFin + "]";
	}

}