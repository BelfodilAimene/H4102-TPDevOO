package application;
import java.util.ArrayList;




/**
 * 
 */
public class PlageHoraire {

    /**
     * 
     */
    private Temps heureDebut;

    /**
     * 
     */
    private Temps heureFin;

    /**
     * 
     */
    private ArrayList<Livraison> listeLivraisons;

	public PlageHoraire(Temps heureDebut, Temps heureFin) {
		super();
		this.heureDebut = heureDebut;
		this.heureFin = heureFin;
		this.listeLivraisons = new ArrayList<>();
	}

	public Temps getHeureDebut() {
		return heureDebut;
	}

	public Temps getHeureFin() {
		return heureFin;
	}

	public ArrayList<Livraison> getListeLivraisons() {
		return listeLivraisons;
	}
	
	public void addLivraison(Livraison livraison) {
		livraison.setPlageHoraire(this);
		this.getListeLivraisons().add(livraison);
	}
	
	public int getNombreLivraisons() {
		return listeLivraisons.size();
	}
	
	public Livraison getLivraisonDeNoeud(Noeud noeud) {
		for (Livraison L : this.getListeLivraisons()) {
			if (L.getNoeudLivraison() == noeud) return L;
		}
		return null;
	}

	@Override
	public String toString() {
		return "PlageHoraire [heureDebut=" + heureDebut + ", heureFin="
				+ heureFin + "]";
	}
    
    
	

}