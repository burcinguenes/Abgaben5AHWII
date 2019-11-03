package DB;

public class Adresse {
	
	int Adresse_ID;
    String Stadt;
    String Strasse;
   	int PLZ;
    String HausNr;

   
	public Adresse(int id, String st, String str, int p, String hnr) 
    {
    	this.Adresse_ID = id;
    	this.Stadt = st;
    	this.Strasse = str;
    	this.PLZ = p;
    	this.HausNr = hnr;
    }

 
    public String toString() {
        return this.Adresse_ID + " " + this.Stadt+ " " +this.Strasse+ " " +this.PLZ+ " " +this.HausNr;
    }
    
    public int getAdresse_ID() {
		return Adresse_ID;
	}


	public String getStadt() {
		return Stadt;
	}


	public String getStrasse() {
		return Strasse;
	}


	public int getPLZ() {
		return PLZ;
	}


	public String getHausNr() {
		return HausNr;
	}


	public void setAdresse_ID(int adresse_ID) {
		Adresse_ID = adresse_ID;
	}


	public void setStadt(String stadt) {
		Stadt = stadt;
	}


	public void setStrasse(String strasse) {
		Strasse = strasse;
	}


	public void setPLZ(int pLZ) {
		PLZ = pLZ;
	}


	public void setHausNr(String hausNr) {
		HausNr = hausNr;
	}



}
