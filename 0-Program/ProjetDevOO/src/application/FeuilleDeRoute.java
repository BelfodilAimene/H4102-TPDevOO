package application;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import tsp.SolutionState;
import tsp.TSP;

/**
 * 
 */
public class FeuilleDeRoute {

	/**
     * 
     */
    private Zone zone;

    private Entrepot entrepot;
    
    /**
     * 
     */
    private ArrayList<PlageHoraire> listePlagesHoraire;

    
    /**
     * 
     */
    private ArrayList<Chemin> itineraire;

    
    
    /**
     * 
     */
    public FeuilleDeRoute(Zone zone,int idEntrepot, ArrayList<PlageHoraire> listePlagesHoraire) {
		super();
		this.zone = zone;
		this.listePlagesHoraire=listePlagesHoraire;
		this.entrepot=new Entrepot(zone.getNoeuds().get(idEntrepot));
		this.itineraire = null;
	}
    
    
    
    public Zone getZone() {
		return zone;
	}



	public ArrayList<PlageHoraire> getListePlagesHoraire() {
		return listePlagesHoraire;
	}



	public ArrayList<Chemin> getItineraire() {
		return itineraire;
	}



	


	public Entrepot getEntrepot() {
		return entrepot;
	}



	public void setItineraire(ArrayList<Chemin> itineraire) {
		this.itineraire = itineraire;
	}
    
    public int getNombreLivraisons() {
    	int S=0;
    	for (PlageHoraire plageHoraire : listePlagesHoraire) {
    		S+=plageHoraire.getNombreLivraisons();
    	}
    	return S;
    }
    
    public Livraison getLivraisonDeNoeud(Noeud noeud) {
    	Livraison tmp=null;
    	for (PlageHoraire plageHoraire : listePlagesHoraire) {
    		tmp=plageHoraire.getLivraisonDeNoeud(noeud);
    		if (tmp != null) return tmp;
    	}
    	return null;
    }

	
    /**
     * 
     */
    public void calculerItineraire() {
    	itineraire=new ArrayList<>();
    	GraphLivraison graphLivraison=new GraphLivraison(this);
    	TSP tsp = new TSP(graphLivraison);
    	
    	tsp.solve(200000,graphLivraison.getNbVertices()*graphLivraison.getMaxArcCost()+1);
    	if (tsp.getSolutionState() != SolutionState.INCONSISTENT){
			int[] next = tsp.getNext();
			
			Chemin cheminInitial=graphLivraison.getMatriceChemin()[0][next[0]];
			Temps tempsDepart=getLivraisonDeNoeud(cheminInitial.getDestination()).getPlageHoraire().getHeureDebut().copy();
			tempsDepart.subTempsSeconde((int) Math.ceil(cheminInitial.getCout()));		
			entrepot.setHeureDepart(tempsDepart);
			
			
			Temps actuel=new Temps(entrepot.getHeureDepart().toString());
			for (int i=0; i<graphLivraison.getNbVertices(); i++) {
				Chemin chemin=graphLivraison.getMatriceChemin()[i][next[i]];
				itineraire.add(chemin);
				
				Livraison l=this.getLivraisonDeNoeud(chemin.getDestination());
				if (l!=null) {
					Temps heureArrive=actuel.copy();
					heureArrive.addTempsSeconde((int) Math.ceil(chemin.getCout()));
					l.setHeureArrive(heureArrive);
					actuel=l.getHeureDepart().copy();
				} else {
					Temps heureArrive=actuel.copy();
					heureArrive.addTempsSeconde((int) Math.ceil(chemin.getCout()));
					entrepot.setHeureArrive(heureArrive);
					
				}
			}
			//System.out.println(tsp.getTotalCost());
		}
		else {
			System.out.println("No solution found after 200 seconds...");
		}
    }

    public void AfficherItiniraire() {
    	System.out.println("Itiniraire : ");
    	System.out.println("-------------");
    	System.out.println();
    	Chemin chemin=itineraire.get(0);
    	System.out.println("Depart de l'entrepot : "+getEntrepot().toString());
    	
    	for (int i=0;i<itineraire.size()-1;i++) {
    		chemin=itineraire.get(i);
    		System.out.print("\tChemin � suivre : ");
    		System.out.println(chemin);
    		System.out.println();
    		System.out.println("Livraison � faire : "+getLivraisonDeNoeud(chemin.getDestination()));
    	}
    	
    	
    	chemin=itineraire.get(itineraire.size()-1);
    	System.out.print("\tChemin � suivre : ");
		System.out.println(chemin);
		System.out.println();
		Temps Arrive=getLivraisonDeNoeud(chemin.getDepart()).getHeureDepart().copy();
		Arrive.addTempsSeconde((int) Math.ceil(chemin.getCout()));
    	System.out.println("Arriv�e � l'entrepot : "+getEntrepot().toString());
    	
    }


}