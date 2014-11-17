package application;

public class Temps {
	int heure;
	int minute;
	int seconde;
	public Temps(int heure, int minute, int seconde) {
		super();
		this.heure = heure;
		this.minute = minute;
		this.seconde = seconde;
	}
	// format de l'heure heure:minute:seconde
	public Temps(String stringHeure) {
		super();
		this.heure = Integer.parseInt(stringHeure.substring(0, stringHeure.indexOf(":")));
		String tmp=stringHeure.substring(stringHeure.indexOf(":")+1);
		this.minute = Integer.parseInt(tmp.substring(0, tmp.indexOf(":")));
		tmp=tmp.substring(tmp.indexOf(":")+1);
		this.seconde=Integer.parseInt(tmp);
	}
	
	public int getTempsValue() {
		return heure*3600+minute*60+seconde;
	}
	
	public void addTempsSeconde(int secondes) {
		int val=getTempsValue()+secondes;
		heure=val/3600;
		minute=(val%3600)/60;
		seconde=val%60;
	}
	
	@Override
	public String toString() {
		return heure+":"+minute+":"+seconde;
	}
	
	
	
	

}
