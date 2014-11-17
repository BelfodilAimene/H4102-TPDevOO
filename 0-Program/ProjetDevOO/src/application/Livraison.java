package application;

/**
 * 
 */

public class Livraison {
	public static int DureeArret = 600; // en secondes;

	/**
     * 
     */
	private int idLivraision;

	/**
     * 
     */
	private Temps heureArrive;

	/**
     * 
     */
	private Temps heureDepart;

	/**
     * 
     */
	private Noeud noeudLivraison;

	/**
     * 
     */
	private PlageHoraire plageHoraire;

	/**
     * 
     */
	public Livraison(int idLivraision, Noeud noeudLivraison) {
		super();
		this.idLivraision = idLivraision;
		this.noeudLivraison = noeudLivraison;
	}

	public Temps getHeureArrive() {
		return heureArrive;
	}

	public void setHeureArrive(Temps heureArrive) {
		this.heureArrive = heureArrive;
		this.heureDepart = heureArrive;
		if (this.heureDepart.getTempsValue() < plageHoraire.getHeureDebut()
				.getTempsValue()) {
			this.heureDepart = plageHoraire.getHeureDebut();
		}
		this.heureDepart.addTempsSeconde(DureeArret);

	}

	public Temps getHeureDepart() {
		return heureDepart;
	}

	public void setHeureDepart(Temps heureDepart) {
		this.heureDepart = heureDepart;
	}

	public PlageHoraire getPlageHoraire() {
		return plageHoraire;
	}

	public void setPlageHoraire(PlageHoraire plageHoraire) {
		this.plageHoraire = plageHoraire;
	}

	public int getIdLivraision() {
		return idLivraision;
	}

	public Noeud getNoeudLivraison() {
		return noeudLivraison;
	}

}