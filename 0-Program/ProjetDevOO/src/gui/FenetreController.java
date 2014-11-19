package gui;

import java.net.URL;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ResourceBundle;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Polygon;
import application.Noeud;
import application.Zone;

public class FenetreController implements Initializable{
	@FXML
    private AnchorPane anchor;	
	
	@FXML
    private Pane paneDuPlan;
	
	@FXML
    private Label btnNouvelleFeuille;
	
	@FXML
    private Label btnCalculerItineraire;
	
	@FXML
    private Label btnAjouterLivraison;
		
	@FXML
    private Label btnSupprimerItineraire;
	
	// les constantes:
	public static final int widthPlan=635;
	public static final int  heightPlan=478;
	public static final int marge=50;
	
	
	
	private LinkedList<VueNoeud> listeVueNoeuds;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub		
    	//paneDuPlan.setStyle("-fx-background-color: #D2D2D2;");    	
    	afficherZone();
    	reglerLesListeners();    
    	/*Polygon pp=new Polygon();
    	pp.getPoints().addAll(new Double[]{
    		    0.0, 0.0,
    		    20.0, 10.0,
    		    10.0, 20.0 });*/
    	//pp.setLayoutX(100);
    	//pp.setLayoutY(100);
    	
    	//paneDuPlan.getChildren().add(pp);
    	
	}

	private void afficherZone() {
		// TODO Auto-generated method stub
		Zone zoneAAfficher=Main.zoneDeTest;
		Iterator it=zoneAAfficher.getNoeuds().values().iterator();
		listeVueNoeuds=new LinkedList<VueNoeud>();
		while (it.hasNext()){
			listeVueNoeuds.add(new VueNoeud((Noeud) it.next(),zoneAAfficher.getMaxX(),zoneAAfficher.getMaxY(),zoneAAfficher.getMinX(),zoneAAfficher.getMinY()));
		}
		//ajouter les noeuds au paneDuPlan
		ajouterNoeudsEtTronconsAuPlan();	
	
		
	}

	

	private void ajouterNoeudsEtTronconsAuPlan() {
		// TODO Auto-generated method stub
		Iterator<VueNoeud> it=listeVueNoeuds.iterator();
		VueNoeud v;
		//System.out.println(paneDuPlan.getWidth());
		//System.out.println(paneDuPlan.getHeight());
		while (it.hasNext())
		{
			v= it.next();
			paneDuPlan.getChildren().add(v);
			afficherLesTronconsDuNoeud(v);
		}
		it=listeVueNoeuds.iterator();
		
		while (it.hasNext())
		{
			(it.next()).toFront();
		}
		
	}
	private void afficherLesTronconsDuNoeud(VueNoeud vueNoeud) {
		// TODO Auto-generated method stub
		Iterator<VueTroncon> it=vueNoeud.getListeVueTroncon().iterator();
		while (it.hasNext()){
			it.next().ajouterTronconAuPane(paneDuPlan);
		}
	}
	
	public void reglerLesListeners(){
		// on devra factoriser les listeners pour optimiser cette partie
		btnNouvelleFeuille.setOnMouseEntered(new EventHandler<Event>() {

			@Override
			public void handle(Event arg0) {
				// TODO Auto-generated method stub
				btnNouvelleFeuille.setStyle("-fx-background-color: #03A9F4;");
				
			}
		});		
		btnNouvelleFeuille.setOnMouseExited(new EventHandler<Event>() {

			@Override
			public void handle(Event arg0) {
				// TODO Auto-generated method stub
				btnNouvelleFeuille.setStyle("-fx-background-color: #039BE5;");
			}
		});
		btnCalculerItineraire.setOnMouseEntered(new EventHandler<Event>() {

			@Override
			public void handle(Event arg0) {
				// TODO Auto-generated method stub
				btnCalculerItineraire.setStyle("-fx-background-color: #03A9F4;");
				
			}
		});		
		btnCalculerItineraire.setOnMouseExited(new EventHandler<Event>() {

			@Override
			public void handle(Event arg0) {
				// TODO Auto-generated method stub
				btnCalculerItineraire.setStyle("-fx-background-color: #039BE5;");
			}
		});
		btnAjouterLivraison.setOnMouseEntered(new EventHandler<Event>() {

			@Override
			public void handle(Event arg0) {
				// TODO Auto-generated method stub
				btnAjouterLivraison.setStyle("-fx-background-color: #03A9F4;");
				
			}
		});		
		btnAjouterLivraison.setOnMouseExited(new EventHandler<Event>() {

			@Override
			public void handle(Event arg0) {
				// TODO Auto-generated method stub
				btnAjouterLivraison.setStyle("-fx-background-color: #039BE5;");
			}
		});
		btnSupprimerItineraire.setOnMouseEntered(new EventHandler<Event>() {

			@Override
			public void handle(Event arg0) {
				// TODO Auto-generated method stub
				btnSupprimerItineraire.setStyle("-fx-background-color: #03A9F4;");
				
			}
		});		
		btnSupprimerItineraire.setOnMouseExited(new EventHandler<Event>() {

			@Override
			public void handle(Event arg0) {
				// TODO Auto-generated method stub
				btnSupprimerItineraire.setStyle("-fx-background-color: #039BE5;");
			}
		});
	}
	
	

}
