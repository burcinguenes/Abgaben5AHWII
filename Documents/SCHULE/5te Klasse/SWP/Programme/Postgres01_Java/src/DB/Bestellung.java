package DB;

public class Bestellung {

	int Bestellung_ID;
	int Kunde_ID;
	int Adresse_Rechnung_ID;
	int Adresse_Liefer_ID;

	public Bestellung(int id, int kunde_id, int ar_id, int al_id)
	    {
			this.Bestellung_ID=id;
	    	this.Kunde_ID=kunde_id;
	    	this.Adresse_Rechnung_ID=ar_id;
	    	this.Adresse_Liefer_ID=al_id;
	    }

	public void setBestellung_ID(int bestellung_ID) {
		Bestellung_ID = bestellung_ID;
	}

	public void setKunde_ID(int kunde_ID) {
		Kunde_ID = kunde_ID;
	}

	public void setAdresse_Rechnung_ID(int adresse_Rechnung_ID) {
		Adresse_Rechnung_ID = adresse_Rechnung_ID;
	}

	public void setAdresse_Liefer_ID(int adresse_Liefer_ID) {
		Adresse_Liefer_ID = adresse_Liefer_ID;
	}

	public int getBestellung_ID() {
		return Bestellung_ID;
	}

	public int getKunde_ID() {
		return Kunde_ID;
	}

	public int getAdresse_Rechnung_ID() {
		return Adresse_Rechnung_ID;
	}

	public int getAdresse_Liefer_ID() {
		return Adresse_Liefer_ID;
	}
	
	

}
