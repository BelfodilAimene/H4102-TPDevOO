package gui;

import java.util.Iterator;
import java.util.LinkedList;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import application.Noeud;
import application.Troncon;

import com.sun.glass.events.MouseEvent;

public class VueNoeud extends Circle{
	
	
	
	private Noeud noeud;
	private LinkedList<VueTroncon> listeVueTroncon;
	
	public VueNoeud(Noeud noeud, int maxX, int maxY, int minX, int minY){
		super();
		setRadius(7);
		setFill(Color.web("#616161"));
		this.noeud=noeud;
		setCenterX(FenetreController.marge+(noeud.getX()-minX)*(FenetreController.widthPlan-FenetreController.marge*2)/(maxX-minX));
		setCenterY(FenetreController.marge+(noeud.getY()-minY)*(FenetreController.heightPlan-FenetreController.marge*2)/(maxY-minY));	
		
		
		
		setOnMouseEntered(new EventHandler() {		    
			@Override
			public void handle(Event arg0) {
				// TODO Auto-generated method stub
				VueNoeud.this.setRadius(10);
			}
		});
		setOnMouseExited(new EventHandler() {		    
			@Override
			public void handle(Event arg0) {
				// TODO Auto-generated method stub
				VueNoeud.this.setRadius(7);
			}
		});
		
		
		creerListeTroncon(maxX,maxY,minX,minY);
		
	}

	
	public Noeud getNoeud() {
		return noeud;
	}
	
	
	
	
	public LinkedList<VueTroncon> getListeVueTroncon() {
		return listeVueTroncon;
	}


	private void creerListeTroncon(int maxX, int maxY, int minX, int minY) {
		// TODO Auto-generated method stub
		listeVueTroncon=new LinkedList<>();
		Iterator<Troncon> it=noeud.getListeTronconSortants().iterator();
		while (it.hasNext()){
			listeVueTroncon.add(new VueTroncon(it.next(),maxX,maxY,minX,minY));
		}
	}
	
	
}
