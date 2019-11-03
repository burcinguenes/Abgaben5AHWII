package GUI;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import DB.Adresse;
import DB.Artikel;
import DB.Bestellung;
import DB.Bestellung_Artikel;
import DB.Kunde;

public class JDBC_main {
    static Connection conn;
    static int lastBestellungId;

    public JDBC_main() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/dbp_bestellung01", "postgres", "superuser"); //?
    }

    public void close() throws SQLException {
        conn.close();
    }
    
    /*------------------------------Kunde----------------------------------*/

    public ArrayList<Kunde> getKunden() throws SQLException {
        ArrayList<Kunde> s = new ArrayList<Kunde>();
        String sql = "SELECT * FROM  kunde";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        while(rs.next()) {
        	int ID= rs.getInt("Kunden_ID");
            String tV= rs.getString("TitelV");
            String vname= rs.getString("Vorname");
           	String nname= rs.getString("Nachname");
            String tN= rs.getString("TitelN");
            
            Kunde st = new Kunde(tV, vname, nname, tN);
            s.add(st);
            System.out.printf("ID: " + ID + "\t"+tV+"\t"+ vname+" "+nname+"\t"+tN+"\n");
        }

        rs.close();
        stmt.close();
        return s;
    }
    
    public Kunde getKunde(int id) throws SQLException {
    	String tV, vname, nname, tN;
    	Kunde st=null;
    	
    	String sql = "SELECT * FROM  kunde WHERE kunden_id="+id;
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        while(rs.next()) {
            tV= rs.getString("TitelV");
            vname= rs.getString("Vorname");
           	nname= rs.getString("Nachname");
            tN= rs.getString("TitelN");
            
            st = new Kunde(tV, vname, nname, tN);
        }

        rs.close();
        stmt.close();
        return st;
    }
    
    public void createKunde(String tV, String vname, String nname, String tN) throws SQLException {
    	String sql = "INSERT INTO kunde (TitelV, Vorname, Nachname, TitelN) VALUES(?,?,?,?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, tV);
        stmt.setString(2, vname);
        stmt.setString(3, nname);
        stmt.setString(4, tN);

        stmt.executeUpdate();
        stmt.close();   
        System.out.println("Neuer Kunde angelegt.");
    }

    public void removeKunde(int id) throws SQLException {
        String sql = "DELETE from kunde WHERE Kunden_ID= ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setLong(1, (long)id);
        stmt.executeUpdate();
        
        sql = " DELETE from bestellung WHERE Kunde_ID= ? ";
        stmt = conn.prepareStatement(sql);
        stmt.setLong(1, (long)id);
        stmt.executeUpdate();
        stmt.close();
        System.out.println("Kunde wurde entfernt.");

    }
    
    public void updateKunde(String tV, String vname, String nname, String tN, int id) throws SQLException{
    	String sql = "UPDATE Kunde SET TitelV=?, Vorname=?, Nachname=?, TitelN=? WHERE Kunden_ID= ? ";
    	
    	PreparedStatement stmt = conn.prepareStatement(sql);
    	 stmt.setString(1, tV);
         stmt.setString(2, vname);
         stmt.setString(3, nname);
         stmt.setString(4, tN);
        stmt.setLong(5, (long)id);
        
        stmt.executeUpdate();
        stmt.close();
        System.out.println("Kundendaten wurde geändert.");
    }

    /*----------------------------Kunde Ende----------------------------------*/
    
    /*------------------------------Adresse----------------------------------*/
    public Adresse getAdresse(int id) throws SQLException {
    	Adresse ad = null; 
    	String sql = "SELECT * FROM  adresse WHERE adresse_id="+id;
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        while(rs.next()) {
            String st= rs.getString("Stadt");
            String str= rs.getString("Strasse");
           	int p= rs.getInt("PLZ");
            String hnr= rs.getString("HausNr");
            
            ad = new Adresse(id, st, str, p, hnr);
            System.out.printf(id+ "\t" + st+ "\t" +str+ "\t" +p+ "\t" +hnr+"\n");
        }

        rs.close();
        stmt.close();
        
        return ad;
    }
    
    public void createAdresse(String st, String str, int p, String hnr) throws SQLException {
    	String sql = "INSERT INTO adresse (stadt, strasse, plz, hausnr) VALUES(?,?,?,?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, st);
        stmt.setString(2, str);
        stmt.setLong(3, (long)p);
        stmt.setString(4, hnr);
        

        stmt.executeUpdate();
        stmt.close();   
        System.out.println("Neue Adresse angelegt.");
    }

    public void removeAdresse(int id) throws SQLException {
        String sql = "DELETE from adresse WHERE adresse_id= ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setLong(1, (long)id);
        stmt.executeUpdate();
        
        sql = " DELETE from bestellung WHERE Adresse_Rechnung_ID= ? ";
        stmt = conn.prepareStatement(sql);
        stmt.setLong(1, (long)id);
        stmt.executeUpdate();
        
        sql = " DELETE from bestellung WHERE Adresse_Liefer_ID= ? ";
        stmt = conn.prepareStatement(sql);
        stmt.setLong(1, (long)id);
        stmt.executeUpdate();
        
        stmt.close();    
        System.out.println("Adresse wurde entfernt.");

    }
    
    public void updateAdresse(int id, String st, String str, int p, String hnr) throws SQLException{
    	String sql = "UPDATE adresse SET stadt=?, strasse=?, plz=?, hausnr=? WHERE adresse_id= ? ";
    	PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, st);
        stmt.setString(2, str);
        stmt.setLong(3, (long)p);
        stmt.setString(4, hnr);
        stmt.setLong(5, (long)id);

        
        stmt.executeUpdate();
        stmt.close();
        System.out.println("Adresse wurde geändert.");
    }
    /*----------------------------Adresse Ende----------------------------------*/
    
    /*------------------------------ Artikel ----------------------------------*/
    public ResultSet getArticles() throws SQLException {
        String sql = "SELECT artikel_id, name FROM artikel";
        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
         
        return rs;

        /*while(rs.next()) {
        	int id = rs.getInt("artikel_ID");
        	String n= rs.getString("name");
           	int p= rs.getInt("preis");
            
            Artikel ad = new Artikel(id, n, p);
            s.add(ad);
            System.out.printf("ID: " + id + "\t, Artikel: " + n + "\t Preis: "+p+"\n");
        }*/
    }    
    
    public ArrayList<Artikel> getArrayListArticles() throws SQLException {
    	ArrayList<Artikel> s=new ArrayList<Artikel>();
    	
    	String sql = "SELECT * FROM artikel ";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
         
        while(rs.next()) {
        	int id = rs.getInt("artikel_ID");
        	String n= rs.getString("name");
           	int p= rs.getInt("preis");
            
            Artikel ad = new Artikel(id, n, p);
            s.add(ad);
            System.out.printf("ID: " + id + "\t, Artikel: " + n + "\t Preis: "+p+"\n");
        }
		return s;
    }  
    
    public void getArtikel(int id) throws SQLException { 	
    	String sql = "SELECT * FROM  artikel WHERE artikel_id="+id;
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        while(rs.next()) {
            String n= rs.getString("name");
           	int p= rs.getInt("preis");
            
            Artikel ad = new Artikel(id, n, p);
            System.out.printf(id+ "\t" + n+ "\t" +p+"\n");
        }
        

        rs.close();
        stmt.close();
    }
    
    public void createArtikel(int id, String n, int p) throws SQLException {
    	String sql = "INSERT INTO artikel (artikel_id, name, preis) VALUES(?,?,?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setLong(1, (long)id);
        stmt.setString(2, n);
        stmt.setLong(3, (long)p);
        

        stmt.executeUpdate();
        stmt.close();   
        System.out.println("Neuer Artikel angelegt.");
    }
    public void removeArtikel(int id) throws SQLException {
        String sql = "DELETE from artikel WHERE artikel_id= ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setLong(1, (long)id);
        stmt.executeUpdate();
                
        sql = " DELETE from bestellung_artikel WHERE Artikel_ID= ? ";
        stmt = conn.prepareStatement(sql);
        stmt.setLong(1, (long)id);
        stmt.executeUpdate();
        
        stmt.close();    
        System.out.println("Artikel wurde entfernt.");

    }
    
    public void updateArtikel(int id, String n, int p) throws SQLException{
    	String sql = "UPDATE artikel SET  name=?, preis=? WHERE artikel_id= ? ";
    	PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, n);
        stmt.setLong(2, (long)p);
        stmt.setLong(3, (long)id);

        stmt.executeUpdate();
        stmt.close();
        System.out.println("Artikel wurde geändert.");
    }
    
    
    /*----------------------------Artikel Ende----------------------------------*/
    /*------------------------------Bestellung----------------------------------*/
    
    public void createBestellung(int kunde_id, int ar_id, int al_id) throws SQLException {
    	    	
    	String sql = "INSERT INTO bestellung (Kunde_ID, Adresse_Rechnung_ID, Adresse_Liefer_ID) VALUES(?,?,?)";
        PreparedStatement stmt = conn.prepareStatement(sql);

        stmt.setLong(1, (long)kunde_id);
        stmt.setLong(2, (long)ar_id);
        stmt.setLong(3, (long)al_id);

  

        stmt.executeUpdate();
        stmt.close();   
        System.out.println("Neue Bestellung erstellt.");
    }
    
    public void removeBestellung(int id) throws SQLException {

        String sql = "DELETE from bestellung WHERE bestellung_id= ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setLong(1, (long)id);
        stmt.executeUpdate();
                
        sql = " DELETE from bestellung_artikel WHERE Bestellung_ID= ? ";
        stmt = conn.prepareStatement(sql);
        stmt.setLong(1, (long)id);
        stmt.executeUpdate();
        
        stmt.close();    
        System.out.println("Bestellung wurde abgebrochen.");
    }
    
    public void updateBestellung(int id, int kunde_id, int ar_id, int al_id) throws SQLException{
    	String sql = "UPDATE bestellung SET  Kunde_ID=?, Adresse_Rechnung_ID=?, Adresse_Liefer_ID=? WHERE Bestellung_ID=? ";
    	PreparedStatement stmt = conn.prepareStatement(sql);

    	stmt.setLong(1, (long)kunde_id);
    	stmt.setLong(2, (long)ar_id);
        stmt.setLong(3, (long)al_id);
        stmt.setLong(4, (long)id);


        stmt.executeUpdate();
        stmt.close();
        System.out.println("Bestellung wurde geändert.");
    }
   
    public void getBestellung(int id) throws SQLException {
        String sql = "SELECT * FROM  bestellung WHERE bestellung_id="+id;
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        while(rs.next()) {
           	int k_id= rs.getInt("kunde_id");
        	int ar_id= rs.getInt("Adresse_Rechnung_ID");
        	int al_id= rs.getInt("Adresse_Liefer_ID");
            
            Bestellung b = new Bestellung(id, k_id, ar_id, al_id);
            System.out.printf(id+ "\t" + k_id + "\t" + ar_id + "\t"+ al_id +"\n");
        }

        rs.close();
        stmt.close();
    } 
    /*----------------------------Bestellung Ende----------------------------------*/
    /*------------------------------Bestellung_Artikel----------------------------------*/
    public int getLastBestellungId() throws SQLException {
    	
    	Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("select max(bestellung_id) AS max_id from bestellung");
         
        if (rs.next()) {
        	   lastBestellungId = rs.getInt("max_id");  
        	}
        
        rs.close();
        stmt.close();
        
        return lastBestellungId;
    }

    public void createBestell_Artikel(int ar_id, int m) throws SQLException {
    	String sql = "INSERT INTO bestellung_artikel (bestellung_id, artikel_id, menge) VALUES(?,?,?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setLong(1, (long)getLastBestellungId());
        stmt.setLong(2, (long)ar_id);
        stmt.setLong(3, (long)m);


        stmt.executeUpdate();
        stmt.close();   
        System.out.println("Neue Bestellung-Artikel erstellt.");
    }
    
    public void removeBestell_Artikel(int id) throws SQLException {

        String sql = "DELETE from bestellung_artikel WHERE bestellung_id= ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setLong(1, (long)id);
        stmt.executeUpdate();
                
        stmt.close();    
        System.out.println("Bestellung-Artikel wurde gelöscht.");
    }
    
    public void updateBestell_Artikel(int id, int ar_id, int m) throws SQLException{
    	String sql = "UPDATE bestellung_artikel SET  artikel_id=?, menge=? WHERE Bestellung_ID=? ";
    	PreparedStatement stmt = conn.prepareStatement(sql);

    	stmt.setLong(1, (long)ar_id);
    	stmt.setLong(2, (long)m);
        stmt.setLong(3, (long)id);
        stmt.executeUpdate();
        
        stmt.close();
        System.out.println("Bestellung-Artikel wurde geändert.");
    }
    
    public void getBestell_Artikel(int id) throws SQLException {
        String sql = "SELECT * FROM  bestellung_artikel WHERE bestellung_id="+id;
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        while(rs.next()) {
           	int ar_id= rs.getInt("artikel_id");
        	int m= rs.getInt("menge");
            
            Bestellung_Artikel b = new Bestellung_Artikel(id, ar_id, m);
            System.out.printf(id+ "\t" + ar_id + "\t" + m + "\n");
        }

        rs.close();
        stmt.close();
    } 
    /*----------------------------Bestellung Artikel Ende----------------------------------*/

    
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        JDBC_main db = new JDBC_main();
        
        //ArrayList<Kunde> kunden = db.getKunden();
        //db.createKunde("Mag", "Burcin", "Gunes", " ");
        //db.removeKunde(2);
        //db.updateKunde(" ", "Burcin", "Gunes", " ",1);
        
        //db.createAdresse(2, "Innsbruck", "General-Eccher-Strasse", 6020, "5");
        //db.getAdresse(1);
        //db.removeAdresse(2);
        //db.updateAdresse(1, "Reichenau", "General-Eccher-Strasse", 6020, "8");
        
        //db.createArtikel(5, "Maus", 20);
        //db.updateArtikel(1, "WLAN KABEL", 3050);
        //db.getArtikel(1);
        //db.removeArtikel(2);

        //db.createBestellung(1, 1, 1);
        //db.removeBestellung(3);
        //db.updateBestellung(2, 4, 1, 2);
        //db.getBestellung(2);
        
        //db.createBestell_Artikel(2, 1, 2);
        //db.removeBestell_Artikel(2);
        //db.updateBestell_Artikel(2, 1, 5);
        //db.getBestell_Artikel(2);
        db.close();
    }
}
