package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import DB.Artikel;
import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JScrollPane;

public class ArtikelFrame extends JFrame {
	static Connection conn;
	private JPanel contentPane;

	static ArrayList<Artikel> al;
	static JDBC_main db;
	private JTable table;
	private DefaultTableModel model;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ArtikelFrame frame = new ArtikelFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public ArtikelFrame() throws SQLException {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblArtikelauswahl = new JLabel("Artikelauswahl");
		lblArtikelauswahl.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblArtikelauswahl.setBounds(151, 10, 105, 31);
		contentPane.add(lblArtikelauswahl);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 49, 324, 202);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setBackground(Color.PINK);
		
		Object [] column = {"ID","Name","Preis"};
		model = new DefaultTableModel();
		model.setColumnIdentifiers(column);
		table.setModel(model);
		
		JButton btnLoad = new JButton("Load");
		btnLoad.setBounds(344, 46, 85, 21);
		contentPane.add(btnLoad);
		btnLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 Object [] row = new Object[3];  
			
				try {
				Class.forName("org.postgresql.Driver");
			    conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/dbp_bestellung01", "postgres", "superuser"); //?
				
				String sql = "SELECT * FROM  artikel";
		        Statement stmt = conn.createStatement();
		        ResultSet rs = stmt.executeQuery(sql);

		        while(rs.next()) {
		        	int id = rs.getInt("artikel_id");
		        	String n= rs.getString("name");
		           	int p= rs.getInt("preis");
		           	
		           	row[0]=id;
		           	row[1]=n;
		           	row[2]=p;
		           	
		           	model.addRow(row);

		        }
		        
		        btnLoad.setEnabled(false);
		            
				//table.setModel(DbUtils.resultSetToTableModel(db.getArticles()));
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, e);
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
					
			}
		});
				
	}
}
