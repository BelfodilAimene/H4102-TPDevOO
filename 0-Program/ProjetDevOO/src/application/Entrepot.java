package application;

/**
 * classe repr�senant un entrep�t
 * 
 * @author H4102
 *
 */
public class Entrepot {

	/**
	 * noeud de l'empla�ement l'entrep�t
	 */
	private Noeud noeud;
	/**
	 * Heure de d�part de l'entrep�t (pour une demande de livraison
	 * particuli�re)
	 */
	private Temps heureDepart = null;

	/**
	 * Heure d'arriv� � l'entrep�t (pour une demande de livraison particuli�re)
	 */
	private Temps heureArrive = null;

	/**
	 * construit un entrep�t
	 * 
	 * @param noeud
	 *            empla�ement de l'entrep�t
	 */
	public Entrepot(Noeud noeud) {
		super();
		this.noeud = noeud;
	}

	/**
	 * 
	 * @return Heure de d�part de l'entrep�t
	 */
	public Temps getHeureDepart() {
		return heureDepart;
	}

	/**
	 * 
	 * @param heureDepart
	 *            Heure de d�part de l'entrep�t
	 */
	public void setHeureDepart(Temps heureDepart) {
		this.heureDepart = heureDepart;
	}

	/**
	 * 
	 * @return Heure d'arriv�e � l'entrep�t
	 */
	public Temps getHeureArrive() {
		return heureArrive;
	}

	/**
	 * 
	 * @param heureArrive
	 *            Heure d'arriv�e � l'entrep�t
	 */
	public void setHeureArrive(Temps heureArrive) {
		this.heureArrive = heureArrive;
	}

	/**
	 * 
	 * @return noeud repr�sentant l'empla�ement de l'entrep�t
	 */
	public Noeud getNoeud() {
		return noeud;
	}

	@Override
	public String toString() {
		return "Entrepot [noeud=" + noeud + ", heureDepart=" + heureDepart
				+ ", heureArrive=" + heureArrive + "]";
	}
}
