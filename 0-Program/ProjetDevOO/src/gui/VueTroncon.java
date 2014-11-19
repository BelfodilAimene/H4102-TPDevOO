package gui;

import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import application.Troncon;

public class VueTroncon extends Line{

	private Troncon troncon;
	private Polygon teteFleche;
	public VueTroncon(Troncon troncon, int maxX, int maxY, int minX, int minY){
		super();
		this.troncon=troncon;
		setStartX(FenetreController.marge+(troncon.getDepart().getX()-minX)*(FenetreController.widthPlan-FenetreController.marge*2)/(maxX-minX));
		setStartY(FenetreController.marge+(troncon.getDepart().getY()-minY)*(FenetreController.heightPlan-FenetreController.marge*2)/(maxY-minY));
		setEndX(FenetreController.marge+(troncon.getDestination().getX()-minX)*(FenetreController.widthPlan-FenetreController.marge*2)/(maxX-minX));
		setEndY(FenetreController.marge+(troncon.getDestination().getY()-minY)*(FenetreController.heightPlan-FenetreController.marge*2)/(maxY-minY));
		initialiserTeteFleche();
	}
	
	
	private void initialiserTeteFleche() {
		// TODO Auto-generated method stub
		teteFleche=new Polygon();
		
		Double xA=(getEndX()+getStartX())/2-10*cosTeta();
		Double yA=(getEndY()+getStartY())/2-10*sinTeta();
		Double xB=(getEndX()+getStartX())/2-10*cosTeta();
		Double yB=(getEndY()+getStartY())/2-10*sinTeta();
		Double xC=(getEndX()+getStartX())/2+10*cosTeta();
		Double yC=(getEndY()+getStartY())/2+10*sinTeta();
		System.out.println(cosTeta());
		System.out.println(sinTeta());
		/*teteFleche.getPoints().addAll(new Double[]{
    		   (double ((getEndX()+getStartX())/2)) ,(getEndY()+getStartY())/2 ,
    		   (getEndX()+getStartX())/2 +10,(getEndY()+getStartY())/2 +10,
    		   (getEndX()+getStartX())/2 -10,(getEndY()+getStartY())/2 -10 });*/
		/*teteFleche.getPoints().addAll(new Double[]{
				 xA, yA,
	    		    xB, yB,
	    		    xC, yC});*/
		teteFleche.getPoints().add(xA);
		teteFleche.getPoints().add(yA);
		teteFleche.getPoints().add(xB);
		teteFleche.getPoints().add(yB);
		teteFleche.getPoints().add(xC);
		teteFleche.getPoints().add(yC);
		teteFleche.setStyle("-fx-background-color: #000000;");
		//System.out.println(teteFleche.getPoints().get(0).doubleValue());
	}


	

	public void ajouterTronconAuPane(Pane paneParent){
		paneParent.getChildren().add(this);
		paneParent.getChildren().add(teteFleche);
	}
	private double cosTeta(){
		return ( (getEndX()-getStartX()) / distance(getEndX(),getStartX(),getEndY(),getStartY()) );
	}
	


	private double sinTeta(){
		return ( (getEndY()-getStartY()) / distance(getEndX(),getStartX(),getEndY(),getStartY()) );
	}
	private double distance(double endX, double startX, double endY,
			double startY) {
		// TODO Auto-generated method stub
		return (Math.sqrt((endX-startX)*(endX-startX)+(endY-startY)*(endY-startY)));
	}
	
	
	
	
}
