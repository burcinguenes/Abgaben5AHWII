package DB;
public class Kunde {
    int Kunden_ID;
    String TitelV;
    String Vorname;
   	String Nachname;
    String TitelN;

    public Kunde(String tV, String vname, String nname, String tN) 
    {
    	this.TitelV = tV;
    	this.Vorname = vname;
    	this.Nachname = nname;
    	this.TitelN = tN;
    }

 
    public String toString() {
        return this.Kunden_ID + " " + this.TitelV+ " " +this.Vorname+ " " +this.Nachname+ " " +this.TitelN;
    }
    
    public int getKunden_ID() {
		return Kunden_ID;
	}

	public void setKunden_ID(int kunden_ID) {
		Kunden_ID = kunden_ID;
	}

	public String getTitelV() {
		return TitelV;
	}

	public void setTitelV(String titelV) {
		TitelV = titelV;
	}

	public String getVorname() {
		return Vorname;
	}

	public void setVorname(String vorname) {
		Vorname = vorname;
	}

	public String getNachname() {
		return Nachname;
	}

	public void setNachname(String nachname) {
		Nachname = nachname;
	}

	public String getTitelN() {
		return TitelN;
	}

	public void setTitelN(String titelN) {
		TitelN = titelN;
	}
}
