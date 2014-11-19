package application;

public class Parametres {
	/**
	 * Le temps moyen que fait le livreur pour effectuer une livraison, ce temps
	 * est traduit par le temps d'arr�t de livreur au point de livraison (en
	 * seconde).
	 */
	public static int TempsMoyenLivraison = 600;

	/**
	 * L'heure de depart du livreur de l'entrep�t si null : Le syst�me calcule
	 * automatiquement l'heure de d�part qui est l'heure permettant au livreur
	 * d'arriver � la premi�re livraison � faire � l'heure de d�but de la plage
	 * horaire de cette derni�re.
	 * 
	 */
	public static Temps HeureDepart = null;

	/**
	 * Repr�sente le temps maximal que le superviseur peut attendre avant que le
	 * syst�me affiche l'itin�raire (en seconde)
	 */
	public static int TempsMaxCalcul = 200;

}
