package DB;

public class Artikel {
		
	int Artikel_ID;
	String name;
	int Preis;

	public Artikel(int id, String n, int p) 
	    {
	    	this.Artikel_ID = id;
	    	this.name = n;
	    	this.Preis = p;
	    }

	public int getArtikel_ID() {
		return Artikel_ID;
	}

	public String getName() {
		return name;
	}

	public int getPreis() {
		return Preis;
	}

	public void setArtikel_ID(int artikel_ID) {
		Artikel_ID = artikel_ID;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPreis(int preis) {
		Preis = preis;
	}


}
