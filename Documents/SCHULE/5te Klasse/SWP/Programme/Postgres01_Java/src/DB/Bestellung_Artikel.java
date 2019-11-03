package DB;

public class Bestellung_Artikel {

	int Bestellung_ID;
	int Artikel_ID;
	int Menge;

	public Bestellung_Artikel(int bestell_id, int ar_id, int m)
	    {
	    	this.Bestellung_ID=bestell_id; 
	    	this.Artikel_ID=ar_id;
	    	this.Menge=m;
	    }

	public int getBestellung_ID() {
		return Bestellung_ID;
	}

	public void setBestellung_ID(int bestellung_ID) {
		Bestellung_ID = bestellung_ID;
	}

	public int getArtikel_ID() {
		return Artikel_ID;
	}

	public void setArtikel_ID(int artikel_ID) {
		Artikel_ID = artikel_ID;
	}

	public int getMenge() {
		return Menge;
	}

	public void setMenge(int menge) {
		Menge = menge;
	}
	
	

}
