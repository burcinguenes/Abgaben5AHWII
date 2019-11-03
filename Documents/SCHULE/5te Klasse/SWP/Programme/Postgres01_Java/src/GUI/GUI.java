package GUI;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import DB.Adresse;
import DB.Bestellung;
import DB.Kunde;

import javax.swing.JComboBox;
import java.awt.Color;

public class GUI {

	private JFrame frame;
	static Connection conn;
	private JTextField textfield_adresse;
	private JTextField textfield_stadt;
	private JTextField textfield_plz;
	private JTextField textfield_hausnr;
	
	static JDBC_main db;
	private JButton btnDelete;
	private JTextField textfield_id;
	private JLabel lblId;
	private JButton btnUpdate;
	private JCheckBox chckbxKunde;
	private JCheckBox chckbxAdresse;
	private JLabel lblVortitel;
	private JTextField textfield_tV;
	private JLabel lblVorname;
	private JLabel lblNachname;
	private JLabel lblNachtitel;
	private JTextField textfield_vorname;
	private JTextField textfield_tN;
	private JTextField textfield_nachname;
	private JTextField textField_Artikel_ID;
	private JTextField textField_Menge;
	private JTextField textField_kundenID;
	private JTextField textField_laID;
	private JTextField textField_raID;

	public static void main(String[] args) {
		
		try {
			db = new JDBC_main();
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public GUI() {
		initialize();
	}

	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 624, 410);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		/*------------------------------------------------Labels-------------------------------------------------------------*/
		JLabel lblAdresse = new JLabel("Adresse");
		lblAdresse.setBounds(10, 113, 53, 13);
		frame.getContentPane().add(lblAdresse);
		
		JLabel lblStadt = new JLabel("Stadt");
		lblStadt.setBounds(10, 136, 45, 13);
		frame.getContentPane().add(lblStadt);
		
		JLabel lblPlz = new JLabel("PLZ");
		lblPlz.setBounds(10, 159, 45, 13);
		frame.getContentPane().add(lblPlz);
		
		lblVortitel = new JLabel("Vortitel ");
		lblVortitel.setBounds(10, 33, 53, 13);
		frame.getContentPane().add(lblVortitel);
		
		JLabel lblHausnr = new JLabel("Hausnr.");
		lblHausnr.setBounds(226, 113, 45, 13);
		frame.getContentPane().add(lblHausnr);
		
		lblId = new JLabel("ID");
		lblId.setBounds(402, 346, 23, 13);
		frame.getContentPane().add(lblId);
		
		lblVorname = new JLabel("Vorname");
		lblVorname.setBounds(10, 56, 53, 13);
		frame.getContentPane().add(lblVorname);
		
		lblNachname = new JLabel("Nachname");
		lblNachname.setBounds(226, 56, 58, 13);
		frame.getContentPane().add(lblNachname);
		
		lblNachtitel = new JLabel("Nachtitel");
		lblNachtitel.setBounds(226, 33, 53, 13);
		frame.getContentPane().add(lblNachtitel);
		
		JLabel lblArtikelId = new JLabel("Artikel ID");
		lblArtikelId.setBounds(138, 197, 53, 13);
		frame.getContentPane().add(lblArtikelId);
		
		JLabel lblMenge = new JLabel("Menge");
		lblMenge.setBounds(214, 197, 45, 13);
		frame.getContentPane().add(lblMenge);
		
		JLabel lblKundenid = new JLabel("Kunden-ID");
		lblKundenid.setBounds(288, 197, 68, 13);
		frame.getContentPane().add(lblKundenid);
		
		JLabel lblLieferadresse = new JLabel("Lieferadresse");
		lblLieferadresse.setBounds(138, 239, 99, 13);
		frame.getContentPane().add(lblLieferadresse);
		
		JLabel lblRechnungsadresse = new JLabel("Rechnungsadresse");
		lblRechnungsadresse.setBounds(286, 239, 118, 13);
		frame.getContentPane().add(lblRechnungsadresse);
		
		JLabel lblNurIdsAngeben = new JLabel("Nur IDs angeben");
		lblNurIdsAngeben.setForeground(Color.RED);
		lblNurIdsAngeben.setBounds(10, 256, 108, 13);
		frame.getContentPane().add(lblNurIdsAngeben);
		
		
		/*------------------------------------------------TextFields-------------------------------------------------------------*/
		textfield_adresse = new JTextField();
		textfield_adresse.setBounds(73, 110, 96, 19);
		frame.getContentPane().add(textfield_adresse);
		textfield_adresse.setColumns(10);
		
		textfield_stadt = new JTextField();
		textfield_stadt.setBounds(73, 133, 96, 19);
		frame.getContentPane().add(textfield_stadt);
		textfield_stadt.setColumns(10);
		
		textfield_plz = new JTextField();
		textfield_plz.setBounds(73, 156, 45, 19);
		frame.getContentPane().add(textfield_plz);
		textfield_plz.setColumns(10);
		
		textfield_hausnr = new JTextField();
		textfield_hausnr.setBounds(299, 110, 33, 19);
		frame.getContentPane().add(textfield_hausnr);
		textfield_hausnr.setColumns(10);
		
		
		
		
		textfield_id = new JTextField();
		textfield_id.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(textfield_id.getSelectedText()==null) {
					deleteTextfields();
						
			}}
		});
		
		
		textfield_id.setBounds(422, 343, 33, 19);
		frame.getContentPane().add(textfield_id);
		textfield_id.setColumns(10);
		
		textfield_vorname = new JTextField();
		textfield_vorname.setBounds(73, 53, 96, 19);
		frame.getContentPane().add(textfield_vorname);
		textfield_vorname.setColumns(10);
		
		textfield_tN = new JTextField();
		textfield_tN.setBounds(299, 30, 96, 19);
		frame.getContentPane().add(textfield_tN);
		textfield_tN.setColumns(10);
		
		textfield_nachname = new JTextField();
		textfield_nachname.setText("");
		textfield_nachname.setBounds(299, 53, 96, 19);
		frame.getContentPane().add(textfield_nachname);
		textfield_nachname.setColumns(10);
		
		textfield_tV = new JTextField();
		textfield_tV.setBounds(73, 30, 96, 19);
		frame.getContentPane().add(textfield_tV);
		textfield_tV.setColumns(10);
		
		textField_Artikel_ID = new JTextField();
		textField_Artikel_ID.setBounds(138, 210, 45, 19);
		frame.getContentPane().add(textField_Artikel_ID);
		textField_Artikel_ID.setColumns(10);
		
		textField_Menge = new JTextField();
		textField_Menge.setBounds(214, 210, 45, 19);
		frame.getContentPane().add(textField_Menge);
		textField_Menge.setColumns(10);
		
		textField_kundenID = new JTextField();
		textField_kundenID.setBounds(288, 210, 45, 19);
		frame.getContentPane().add(textField_kundenID);
		textField_kundenID.setColumns(10);
		
		textField_laID = new JTextField();
		textField_laID.setBounds(138, 253, 45, 19);
		frame.getContentPane().add(textField_laID);
		textField_laID.setColumns(10);
		
		textField_raID = new JTextField();
		textField_raID.setBounds(288, 253, 45, 19);
		frame.getContentPane().add(textField_raID);
		textField_raID.setColumns(10);
		
		
		/*------------------------------------------------Buttons-------------------------------------------------------------*/
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0){
				
				if(chckbxAdresse.isSelected()) {
					String adresse, stadt, hausnr;
					int plz;
					
					try {
						adresse = textfield_adresse.getText();
						stadt = textfield_stadt.getText();
						hausnr = textfield_hausnr.getText();
						plz = Integer.parseInt(textfield_plz.getText());
					
						db.createAdresse(stadt, adresse, plz, hausnr);
					} catch (SQLException e) {
						e.printStackTrace();
					} 
					
					JOptionPane.showMessageDialog(null, "Adresse hinzugefügt.");	
					deleteTextfields();
					chckbxAdresse.setSelected(false);

				}
				
				
				if(chckbxKunde.isSelected()) {
					String tV, vn, nn, tN;
					try {
						tV = textfield_tV.getText();
						vn = textfield_vorname.getText();
						nn = textfield_nachname.getText();
						tN = textfield_tN.getText();
					
						db.createKunde(tV, vn, nn, tN);
					} catch (SQLException e) {
						e.printStackTrace();
					}
					
					JOptionPane.showMessageDialog(null, "Kunde hinzugefügt.");	
					deleteTextfields();
					chckbxKunde.setSelected(false);
				}	
			}
		});
		btnSave.setBounds(10, 342, 76, 21);
		frame.getContentPane().add(btnSave);
		
		btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id = Integer.parseInt(textfield_id.getText());
;
				
				if(chckbxKunde.isSelected()) {
					try {
						db.removeKunde(id);;
					} catch (SQLException e1) {
						e1.printStackTrace();
					} 
					
					JOptionPane.showMessageDialog(null, "Kunde entfernt.");
					deleteTextfields();
					chckbxKunde.setSelected(false);

				}
				if(chckbxAdresse.isSelected()) {
					try {
						db.removeAdresse(id);
					} catch (SQLException e1) {
						e1.printStackTrace();
					} 
					
					JOptionPane.showMessageDialog(null, "Adresse entfernt.");
					deleteTextfields();
					chckbxAdresse.setSelected(false);
				}
			}
		});
		btnDelete.setBounds(96, 342, 85, 21);
		frame.getContentPane().add(btnDelete);
		
		btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id = Integer.parseInt(textfield_id.getText());

				if(chckbxKunde.isSelected()) {
					String tV, vn, nn, tN;
					try {
						tV = textfield_tV.getText();
						vn = textfield_vorname.getText();
						nn = textfield_nachname.getText();
						tN = textfield_tN.getText();
					
						db.updateKunde(tV, vn, nn, tN, id);
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
					
					JOptionPane.showMessageDialog(null, "Kunde geändert.");	
					deleteTextfields();
					chckbxKunde.setSelected(false);

				}
				if(chckbxAdresse.isSelected()) {
					String adresse, stadt, hausnr;
					int plz;
					
					try {
						adresse = textfield_adresse.getText();
						stadt = textfield_stadt.getText();
						hausnr = textfield_hausnr.getText();
						plz = Integer.parseInt(textfield_plz.getText());
					
						db.updateAdresse(id, stadt, adresse, plz, hausnr);
					} catch (SQLException e1) {
						e1.printStackTrace();
					} 
					
					JOptionPane.showMessageDialog(null, "Adresse geändert.");
					deleteTextfields();
					chckbxAdresse.setSelected(false);
				}
			}
		});
		btnUpdate.setBounds(189, 342, 85, 21);
		frame.getContentPane().add(btnUpdate);
		
		JButton btnArtikelauswahl = new JButton("Artikelauswahl");
		btnArtikelauswahl.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ArtikelFrame artikelf;
				try {
					artikelf = new ArtikelFrame();
					artikelf.setVisible(true);

				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});
		btnArtikelauswahl.setBounds(10, 209, 118, 21);
		frame.getContentPane().add(btnArtikelauswahl);
		
		JButton btnBestellen = new JButton("Bestellen");
		btnBestellen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int artikelID, menge, lieferAid, rechnungsAid, kundenID;
				
				try {
					
					artikelID = Integer.parseInt(textField_Artikel_ID.getText());
					menge = Integer.parseInt(textField_Menge.getText());
					lieferAid = Integer.parseInt(textField_laID.getText());
					rechnungsAid = Integer.parseInt(textField_raID.getText());
					kundenID = Integer.parseInt(textField_kundenID.getText());

				
					db.createBestellung(kundenID, rechnungsAid, lieferAid);
					db.createBestell_Artikel(artikelID, menge);
					
					JOptionPane.showMessageDialog(null, "Bestellung erfolgreich.");	

					
				} catch (SQLException e) {
					e.printStackTrace();
				}

				
			}
		});
		btnBestellen.setBounds(422, 252, 99, 21);
		frame.getContentPane().add(btnBestellen);
		
		JButton btnRead = new JButton("Read");
		btnRead.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int id = Integer.parseInt(textfield_id.getText());

				if(chckbxKunde.isSelected()) {
					try {
						Kunde k = db.getKunde(id);
						
						textfield_tV.setText(k.getTitelV());
						textfield_vorname.setText(k.getVorname());
						textfield_nachname.setText(k.getNachname());
						textfield_tN.setText(k.getTitelN());
						
						chckbxKunde.setSelected(false);
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				if(chckbxAdresse.isSelected()) {
					
					Adresse a;
					try {
						a = db.getAdresse(id);
						textfield_stadt.setText(a.getStadt());
						textfield_adresse.setText(a.getStrasse());
						textfield_plz.setText(Integer.toString(a.getPLZ()));
						textfield_hausnr.setText(a.getHausNr());
						
						chckbxAdresse.setSelected(false);
						
					} catch (SQLException e) {
						e.printStackTrace();
					}
									    
				   
				    
				}

			}
			
		});
		btnRead.setBounds(283, 342, 85, 21);
		frame.getContentPane().add(btnRead);
		
		
		/*------------------------------------------------Checkbox-------------------------------------------------------------*/
		chckbxKunde = new JCheckBox("Kunde");
		chckbxKunde.setBounds(10, 6, 65, 21);
		frame.getContentPane().add(chckbxKunde);
		
		chckbxAdresse = new JCheckBox("Adresse");
		chckbxAdresse.setBounds(76, 6, 85, 21);
		frame.getContentPane().add(chckbxAdresse);
	
	}
	
	public void deleteTextfields() {
		textfield_tV.setText("");
		textfield_vorname.setText("");
		textfield_nachname.setText("");
		textfield_tN.setText("");

		textfield_stadt.setText("");
		textfield_adresse.setText("");
		textfield_plz.setText("");
		textfield_hausnr.setText("");

	}
}
