package application;

public class Troncon {
	private String nomRue;
	private double vitesse;
	private double longueur;
	
	private Noeud depart;
	private Noeud destination;
	
	
	public Troncon(String nomRue, double vitesse, double longueur,
			Noeud depart, Noeud destination) {
		super();
		this.nomRue = nomRue;
		this.vitesse = vitesse;
		this.longueur = longueur;
		this.depart = depart;
		this.destination = destination;
		
		this.depart.getListeTronconSortants().add(this);
	}
	
	
	public String getNomRue() {
		return nomRue;
	}
	public double getVitesse() {
		return vitesse;
	}
	public double getLongueur() {
		return longueur;
	}
	public Noeud getDepart() {
		return depart;
	}
	public Noeud getDestination() {
		return destination;
	}
	
	//retourne la duree de traverse
	public double getCout() {
		return getLongueur()/getVitesse();
	}


	
	
	
}
