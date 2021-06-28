package Spotify;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Label;

public class kullaniciGiris extends JFrame {

	private JPanel contentPane;
	private JTable table1;
    DefaultTableModel modelim= new DefaultTableModel();
    DefaultTableModel modelim1= new DefaultTableModel();
    DefaultTableModel modelim2= new DefaultTableModel();
    DefaultTableModel modelim3= new DefaultTableModel();
    DefaultTableModel modelimPop= new DefaultTableModel();  
    DefaultTableModel modelimCaz= new DefaultTableModel();
    DefaultTableModel modelimKlasik= new DefaultTableModel();
	Object[] kolonlar= {"isim","dinlenmeSayisi"};
	Object[] satirlar= new Object[2];
	Object[] kolonlar1= {"isim","id"};
	Object[] satirlar1= new Object[2];
	Object[] kolonlar2= {"id","takip ettiklerim"};
	Object[] satirlar2= new Object[2];
	Object[] kolonlar3= {"isim","dinlenmeSayisi"};
	Object[] satirlar3= new Object[2];
	Object[] kolonlarpop= {"Pop","dinlenme"};
	Object[] satirlarpop= new Object[2];
	Object[] kolonlarcaz= {"Caz","dinlenme"};
	Object[] satirlarcaz= new Object[10];
	Object[] kolonlarklasik= {"Klasik","dinlenme"};
	Object[] satirlarklasik= new Object[2];
	ArrayList<Integer> kullanici=new ArrayList<Integer>();
	private JTable tablepop;
	private JTable tablecaz;
	private JTable tableklasik;

	private JTextField textArama;
	private JTable table2;
	private JTable table;
	ResultSet res=null;
	private JTable table_1;
	private int ekle=0;
	int[] list=new int[3];

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					kullaniciGiris frame = new kullaniciGiris();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public kullaniciGiris() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1600, 900);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		uyeOl o=new uyeOl();
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 79, 22);
		contentPane.add(menuBar);
		
		JMenu mnNewMenu = new JMenu("MENU");
		menuBar.add(mnNewMenu);
		
		JMenu mnNewMenu_1 = new JMenu("Cýkýs");
		mnNewMenu_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				uyeOl uye=new uyeOl();
				uye.setVisible(true);
				System.exit(JFrame.EXIT_ON_CLOSE);
			}
		});
		mnNewMenu.add(mnNewMenu_1);
		
		res=baglanti.yap("calmalistesi");
		String sorguu="SELECT calmalistesi_id FROM calmalistesi where olusturanID="+o.k_id;
		res=baglanti.arama(sorguu);
		int k=0;
		try {
			while(res.next()){
				
			     list[k]=res.getInt("calmalistesi_id");
			     k++;
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		JLabel labelKlasik = new JLabel("Klasik Listem");
		labelKlasik.setForeground(new Color(0, 102, 0));
		labelKlasik.setFont(new Font("Arial", Font.PLAIN, 22));
		labelKlasik.setBounds(866, 510, 231, 36);
		contentPane.add(labelKlasik);
		
		JLabel labelPop = new JLabel("Pop Listem");
		labelPop.setForeground(new Color(0, 102, 0));
		labelPop.setBackground(new Color(255, 255, 255));
		labelPop.setFont(new Font("Arial", Font.PLAIN, 22));
		labelPop.setHorizontalAlignment(SwingConstants.CENTER);
		labelPop.setBounds(322, 515, 165, 26);
		contentPane.add(labelPop);
		
		JLabel labelCaz = new JLabel("");
		labelCaz.setIcon(new ImageIcon("C:\\Users\\Eliz\\OneDrive\\Masa\u00FCst\u00FC\\image\\kutu-removebg-preview.png"));
		labelCaz.setFont(new Font("Tahoma", Font.BOLD, 13));
		labelCaz.setBounds(759, 462, 338, 181);
		contentPane.add(labelCaz);
		
		JLabel lblNewLabel_3 = new JLabel("Caz Listem");
		lblNewLabel_3.setForeground(new Color(0, 102, 0));
		lblNewLabel_3.setFont(new Font("Arial", Font.PLAIN, 22));
		lblNewLabel_3.setBounds(577, 510, 153, 36);
		contentPane.add(lblNewLabel_3);
		
		
		JScrollPane scrollPanePop = new JScrollPane();
		scrollPanePop.setBounds(310, 556, 204, 294);
		contentPane.add(scrollPanePop);

		JScrollPane scrollPaneCaz = new JScrollPane();
		scrollPaneCaz.setBounds(547, 556, 216, 294);
		contentPane.add(scrollPaneCaz);
		
		JScrollPane scrollPaneKlasik = new JScrollPane();
		scrollPaneKlasik.setBounds(827, 556, 211, 294);
		contentPane.add(scrollPaneKlasik);
		
		tablepop = new JTable();
		modelimPop.setColumnIdentifiers(kolonlarpop);
		tablepop.setModel(modelimPop);
		scrollPanePop.setViewportView(tablepop);

		 String sql_sorgu=null;
		 res=baglanti.yap("listedekisarkilar");
		 sql_sorgu="select sarkiadi,dinlenmeSayisi from sarki where turID='1' and sarki_id in(select sarkilarID from listedekisarkilar where kullanicilarID="+o.k_id+")";
		System.out.println(sql_sorgu);
		res=baglanti.arama(sql_sorgu);

	try {
		while(res.next()) {
			satirlarpop[0]= res.getString("sarkiadi");
			satirlarpop[1]= res.getInt("dinlenmeSayisi");
			
			modelimPop.addRow(satirlarpop);
		
		}
	} catch (SQLException e2) {
		// TODO Auto-generated catch block
		e2.printStackTrace();
	}
			tablepop.setModel(modelimPop);
			
		tablecaz = new JTable();
		modelimCaz.setColumnIdentifiers(kolonlarcaz);
		tablecaz.setModel(modelimCaz);
		scrollPaneCaz.setViewportView(tablecaz);
		
		sql_sorgu="select sarkiadi,dinlenmeSayisi from sarki where turID='2' and sarki_id in(select sarkilarID from listedekisarkilar where kullanicilarID="+o.k_id+")";
		System.out.println(sql_sorgu);
		res=baglanti.arama(sql_sorgu);
	
	try {
		while(res.next()) {
			satirlarcaz[0]= res.getString("sarkiadi");
			satirlarcaz[1]= res.getInt("dinlenmeSayisi");
			
			modelimCaz.addRow(satirlarcaz);
		
		}
	} catch (SQLException e2) {
		// TODO Auto-generated catch block
		e2.printStackTrace();
	}
			tablecaz.setModel(modelimCaz);
		
		tableklasik = new JTable();
		modelimKlasik.setColumnIdentifiers(kolonlarklasik);
		tableklasik.setModel(modelimKlasik);
		scrollPaneKlasik.setViewportView(tableklasik);
		
		sql_sorgu="select sarkiadi,dinlenmeSayisi from sarki where turID='3' and sarki_id in(select sarkilarID from listedekisarkilar where kullanicilarID="+o.k_id+")";
		System.out.println(sql_sorgu);
		res=baglanti.arama(sql_sorgu);
		
	try {
		while(res.next()) {
			satirlarklasik[0]= res.getString("sarkiadi");
			satirlarklasik[1]= res.getInt("dinlenmeSayisi");
			
			modelimKlasik.addRow(satirlarklasik);
		
		}
		} catch (SQLException e2) {
		// TODO Auto-generated catch block
		e2.printStackTrace();
		}
	tableklasik.setModel(modelimKlasik);
	
		JScrollPane scrollPane1 = new JScrollPane();
		scrollPane1.setBounds(104, 155, 191, 241);
		contentPane.add(scrollPane1);
		
		JScrollPane scrollPaneArama = new JScrollPane();
		scrollPaneArama.setBounds(521, 91, 227, 125);
		contentPane.add(scrollPaneArama);
		
		scrollPaneArama.setVisible(false);
		table1 = new JTable();
		modelim.setColumnIdentifiers(kolonlar);
		
		table1.setBounds(81, 239, 244, 154);
		table1.setModel(modelim);
		scrollPane1.setViewportView(table1);
		
		
		table1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ekle=0;
				String ad;
				int turid=0,sarkiid=0,sayi=0;
				ad= (String) modelim.getValueAt(table1.getSelectedRow(), 0);
				res=baglanti.yap("sarki");
				String sqlsorgu2="SELECT sarki_id,turID,dinlenmeSayisi FROM spotify.sarki where sarkiadi='"+ad+"'";
			     res=baglanti.arama(sqlsorgu2);
			     try {
						while(res.next()) {
			      	     
							turid=res.getInt("turID");
						    sarkiid=res.getInt("sarki_id");
							sayi=res.getInt("dinlenmeSayisi");
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			     int n=0;
					res=baglanti.yap("listedekisarkilar");
					String sorgu1="select sarki_id from sarki where sarki_id in(select sarkilarID from listedekisarkilar where kullanicilarID="+o.k_id+")";
					res=baglanti.arama(sorgu1);
					try {
						while(res.next()){

						     kullanici.add(res.getInt("sarki_id"));
						     n++;
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
			     for(int i=0;i<kullanici.size();i++) {
			    	 
			    	 if(kullanici.get(i)==sarkiid) {
			    		 ekle++;
			    	 }
			     }
			     if(ekle==0) {
			    	    res=baglanti.yap("listedekisarkilar");
						String sqlsorgu="insert into listedekisarkilar(kullanicilarID,sarkilarID) values("+o.k_id+","+sarkiid+")";
						baglanti.ekle(sqlsorgu);
						
						res=baglanti.yap("takip_edilen_liste");
						sqlsorgu="insert into takip_edilen_liste(kullanici_id,calmalistesi_id,sarkilar_id) values("+o.k_id+","+list[0]+","+sarkiid+")";
						baglanti.ekle(sqlsorgu);
			
						sayi=sayi+1;
						
						res=baglanti.yap("sarki");
						sqlsorgu="UPDATE sarki SET dinlenmeSayisi="+sayi+" WHERE sarki_id='"+sarkiid+"'";
						System.out.print(sqlsorgu);
						baglanti.duzenle(sqlsorgu);
			     }else {
			    	 System.out.println("listede zaten var");
			     }
			     
			     if(turid==1) {
			    	 modelimPop.setRowCount(0);
			    	 String sql_sorgu=null;
					 res=baglanti.yap("listedekisarkilar");
					 sql_sorgu="select sarkiadi,dinlenmeSayisi from sarki where turID='1' and sarki_id in(select sarkilarID from listedekisarkilar where kullanicilarID="+o.k_id+")";
					res=baglanti.arama(sql_sorgu);

				try {
					while(res.next()) {
						satirlarpop[0]= res.getString("sarkiadi");
						satirlarpop[1]= res.getInt("dinlenmeSayisi");
						
						modelimPop.addRow(satirlarpop);
					
					}
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
						tablepop.setModel(modelimPop);
			     }else if(turid==2) {
			    	 modelimCaz.setRowCount(0);
			    	 res=baglanti.yap("listedekisarkilar");
			    	 String sql_sorgu="select sarkiadi,dinlenmeSayisi from sarki where turID='2' and sarki_id in(select sarkilarID from listedekisarkilar where kullanicilarID="+o.k_id+")";
			 		res=baglanti.arama(sql_sorgu);
			 	
			 	try {
			 		while(res.next()) {
			 			satirlarcaz[0]= res.getString("sarkiadi");
			 			satirlarcaz[1]= res.getInt("dinlenmeSayisi");
			 			
			 			modelimCaz.addRow(satirlarcaz);
			 		
			 		}
			 	} catch (SQLException e2) {
			 		// TODO Auto-generated catch block
			 		e2.printStackTrace();
			 	}
			 			tablecaz.setModel(modelimCaz);
			     }else if(turid==3) {
			    	 modelimKlasik.setRowCount(0);
			    	 res=baglanti.yap("listedekisarkilar");
			    	 String sql_sorgu="select sarkiadi,dinlenmeSayisi from sarki where turID='3' and sarki_id in(select sarkilarID from listedekisarkilar where kullanicilarID="+o.k_id+")";
			 		 res=baglanti.arama(sql_sorgu);
			 		
			 	try {
			 		while(res.next()) {
			 			satirlarklasik[0]= res.getString("sarkiadi");
			 			satirlarklasik[1]= res.getInt("dinlenmeSayisi");
			 			
			 			modelimKlasik.addRow(satirlarklasik);
			 		
			 		}
			 		} catch (SQLException e2) {
			 		// TODO Auto-generated catch block
			 		e2.printStackTrace();
			 		}
			 	tableklasik.setModel(modelimKlasik);
			     }
			     
			}
		});
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"pop", "caz", "klasik", "Genel Top 10"}));
		comboBox.setBounds(104, 103, 84, 26);
		contentPane.add(comboBox);
		
		JButton btnAra = new JButton("Seciniz");
		btnAra.setForeground(new Color(0, 102, 0));
		btnAra.setFont(new Font("Arial", Font.PLAIN, 15));
		btnAra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				modelim.setRowCount(0);
				String sqlsorgu = null;
				ResultSet myRs=baglanti.yap("sarki");
				int secilen=comboBox.getSelectedIndex();
				
				if(secilen==0) {
					sqlsorgu="select sarkiadi,dinlenmeSayisi from sarki where turID=1 order by dinlenmeSayisi DESC";
				}else if(secilen==1) {
					sqlsorgu="select sarkiadi,dinlenmeSayisi from sarki where turID=2 order by dinlenmeSayisi DESC";
				}else if(secilen==2) {
					sqlsorgu="select sarkiadi,dinlenmeSayisi from sarki where turID=3 order by dinlenmeSayisi DESC";
				}else if(secilen==3) {
					sqlsorgu="select sarkiadi,dinlenmeSayisi from sarki order by dinlenmeSayisi DESC";
				}
				System.out.println(sqlsorgu);
				myRs=baglanti.arama(sqlsorgu);
				try {
					
					while(myRs.next()) {
						satirlar[0]= myRs.getString("sarkiadi");
						satirlar[1]= myRs.getString("dinlenmeSayisi");
						
						modelim.addRow(satirlar);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				table1.setModel(modelim);
			}
		});
		
		btnAra.setBounds(226, 103, 94, 26);
		contentPane.add(btnAra);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(1294, 122, 191, 260);
		contentPane.add(scrollPane);
		
		table = new JTable();
		modelim2.setColumnIdentifiers(kolonlar2);
		table.setBounds(428, 252, 113, 226);
		table.setModel(modelim2);
		scrollPane.setViewportView(table);
		
		
		res=baglanti.yap("takip_edilenler");
		String sqlsorgu="select kullanici_adi,kullanici_id from kullanici where kullanici_id in(select takipedilen_ID from takip_edilenler where kullaniciID="+o.k_id+")";
		modelim2.setRowCount(0);
		res=baglanti.arama(sqlsorgu);
		System.out.println(sqlsorgu);
		try {
			while(res.next()) {
				satirlar[0]= res.getString("kullanici_id");
				satirlar[1]= res.getString("kullanici_adi");
				modelim2.addRow(satirlar);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		textArama = new JTextField();
		textArama.setBounds(521, 26, 231, 35);
		contentPane.add(textArama);
		textArama.setColumns(10);
		
		JLabel Arama = new JLabel("ARA");
		Arama.setForeground(new Color(255, 255, 255));
		Arama.setFont(new Font("Tahoma", Font.BOLD, 20));
		Arama.setBounds(463, 21, 84, 36);
		contentPane.add(Arama);
		
		table2 = new JTable();
		table2.setVisible(false);
		modelim1.setColumnIdentifiers(kolonlar1);
		modelim1.addRow(satirlar1);
		table2.setBounds(266, 254, 238, 61);
		table2.setModel(modelim1);
		scrollPaneArama.setViewportView(table2);
		
		table2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String ad,id;
				ad= (String) modelim1.getValueAt(table2.getSelectedRow(), 0);
				id=(String) modelim1.getValueAt(table2.getSelectedRow(), 1);
				hesap hesap=new hesap(ad,id);
				hesap.setVisible(true);
				setVisible(true);
			}
		});
		
		JButton btnArama = new JButton("Ara");
		btnArama.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				scrollPaneArama.setVisible(true);
				table2.setVisible(true);
				modelim1.setRowCount(0);
				String alan=textArama.getText();
				String sqlsorgu = null;
				ResultSet myRs=baglanti.yap("kullanici");
				
				sqlsorgu="select * from kullanici where kullanici_adi like'"+alan+"%'";
				
				System.out.println(sqlsorgu);
				myRs=baglanti.arama(sqlsorgu);
				
				try {
					while(myRs.next()) {
						satirlar1[0]= myRs.getString("kullanici_adi");
						satirlar1[1]= myRs.getString("kullanici_id");
						modelim1.addRow(satirlar1);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				table2.setModel(modelim1);
				
			}
		});
		btnArama.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnArama.setBounds(787, 29, 112, 28);
		contentPane.add(btnArama);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Turkiye", "Ýngiltere", "Almanya"}));
		comboBox_1.setBounds(1069, 78, 175, 33);
		contentPane.add(comboBox_1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(1066, 122, 178, 260);
		contentPane.add(scrollPane_1);
		
		table_1 = new JTable();
		modelim3.setColumnIdentifiers(kolonlar3);
		table_1.setBounds(266, 311, 135, 257);
		table_1.setModel(modelim3);
		scrollPane_1.setViewportView(table_1);
		table_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ekle=0;
				String ad;
				int turid=0,sarkiid=0,sayi=0;
				ad= (String) modelim3.getValueAt(table_1.getSelectedRow(), 0);
				res=baglanti.yap("sarki");
				String sqlsorgu2="SELECT sarki_id,turID,dinlenmeSayisi FROM spotify.sarki where sarkiadi='"+ad+"'";
			     res=baglanti.arama(sqlsorgu2);
			     try {
						while(res.next()) {
			      	     
							turid=res.getInt("turID");
						    sarkiid=res.getInt("sarki_id");
							sayi=res.getInt("dinlenmeSayisi");
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			     int n=0;
					res=baglanti.yap("listedekisarkilar");
					String sorgu1="select sarki_id from sarki where sarki_id in(select sarkilarID from listedekisarkilar where kullanicilarID="+o.k_id+")";
					res=baglanti.arama(sorgu1);
					try {
						while(res.next()){

						     kullanici.add(res.getInt("sarki_id"));
						     n++;
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
			     for(int i=0;i<kullanici.size();i++) {
			    	 
			    	 if(kullanici.get(i)==sarkiid) {
			    		 ekle++;
			    	 }
			     }
			     if(ekle==0) {
			    	    res=baglanti.yap("listedekisarkilar");
						String sqlsorgu="insert into listedekisarkilar(kullanicilarID,sarkilarID) values("+o.k_id+","+sarkiid+")";
						baglanti.ekle(sqlsorgu);
						
						res=baglanti.yap("takip_edilen_liste");
						sqlsorgu="insert into takip_edilen_liste(kullanici_id,calmalistesi_id,sarkilar_id) values("+o.k_id+","+list[1]+","+sarkiid+")";
						baglanti.ekle(sqlsorgu);
						
						sayi=sayi+1;
						
						res=baglanti.yap("sarki");
						sqlsorgu="UPDATE sarki SET dinlenmeSayisi="+sayi+" WHERE sarki_id='"+sarkiid+"'";
						System.out.print(sqlsorgu);
						baglanti.duzenle(sqlsorgu);
			     }else {
			    	 System.out.println("listede zaten var");
			     }
			     
			     if(turid==1) {
			    	 modelimPop.setRowCount(0);
			    	 String sql_sorgu=null;
					 res=baglanti.yap("listedekisarkilar");
					 sql_sorgu="select sarkiadi,dinlenmeSayisi from sarki where turID='1' and sarki_id in(select sarkilarID from listedekisarkilar where kullanicilarID="+o.k_id+")";
					res=baglanti.arama(sql_sorgu);

				try {
					while(res.next()) {
						satirlarpop[0]= res.getString("sarkiadi");
						satirlarpop[1]= res.getInt("dinlenmeSayisi");
						
						modelimPop.addRow(satirlarpop);
					
					}
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
						tablepop.setModel(modelimPop);
			     }else if(turid==2) {
			    	 modelimCaz.setRowCount(0);
			    	 res=baglanti.yap("listedekisarkilar");
			    	 String sql_sorgu="select sarkiadi,dinlenmeSayisi from sarki where turID='2' and sarki_id in(select sarkilarID from listedekisarkilar where kullanicilarID="+o.k_id+")";
			 		res=baglanti.arama(sql_sorgu);
			 	
			 	try {
			 		while(res.next()) {
			 			satirlarcaz[0]= res.getString("sarkiadi");
			 			satirlarcaz[1]= res.getInt("dinlenmeSayisi");
			 			
			 			modelimCaz.addRow(satirlarcaz);
			 		
			 		}
			 	} catch (SQLException e2) {
			 		// TODO Auto-generated catch block
			 		e2.printStackTrace();
			 	}
			 			tablecaz.setModel(modelimCaz);
			     }else if(turid==3) {
			    	 modelimKlasik.setRowCount(0);
			    	 res=baglanti.yap("listedekisarkilar");
			    	 String sql_sorgu="select sarkiadi,dinlenmeSayisi from sarki where turID='3' and sarki_id in(select sarkilarID from listedekisarkilar where kullanicilarID="+o.k_id+")";
			 		 res=baglanti.arama(sql_sorgu);
			 		
			 	try {
			 		while(res.next()) {
			 			satirlarklasik[0]= res.getString("sarkiadi");
			 			satirlarklasik[1]= res.getInt("dinlenmeSayisi");
			 			
			 			modelimKlasik.addRow(satirlarklasik);
			 		
			 		}
			 		} catch (SQLException e2) {
			 		// TODO Auto-generated catch block
			 		e2.printStackTrace();
			 		}
			 	tableklasik.setModel(modelimKlasik);
			     }
			     
			}
		});
		
		JButton ulkeSira = new JButton("Seciniz");
		ulkeSira.setFont(new Font("Arial", Font.PLAIN, 15));
		ulkeSira.setForeground(new Color(0, 102, 0));
		ulkeSira.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				modelim3.setRowCount(0);
				String sqlsorgu = null;
				ResultSet myRs=baglanti.yap("kullanici");
				int secilen=comboBox_1.getSelectedIndex();
				
				if(secilen==0) {
					sqlsorgu="select sarkiadi,dinlenmeSayisi from sarki where sarki_id in(select sarkilarID from listedekisarkilar where kullanicilarID in("
							+"select kullanici_id from kullanici where ulkeID=1)) order by dinlenmeSayisi DESC";
				}else if(secilen==1) {
					sqlsorgu="select sarkiadi,dinlenmeSayisi from sarki where sarki_id in(select sarkilarID from listedekisarkilar where kullanicilarID in("
							+"select kullanici_id from kullanici where ulkeID=2)) order by dinlenmeSayisi DESC";				
				}else if(secilen==2) {
					sqlsorgu="select sarkiadi,dinlenmeSayisi from sarki where sarki_id in(select sarkilarID from listedekisarkilar where kullanicilarID in("
							+"select kullanici_id from kullanici where ulkeID=3)) order by dinlenmeSayisi DESC";
				}
				System.out.println(sqlsorgu);
				myRs=baglanti.arama(sqlsorgu);
				try {
					
					while(myRs.next()) {
						satirlar3[0]= myRs.getString("sarkiadi");
						satirlar3[1]= myRs.getString("dinlenmeSayisi");
						
						modelim3.addRow(satirlar3);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				table_1.setModel(modelim3);
			}
		});
		ulkeSira.setBounds(1294, 79, 191, 26);
		contentPane.add(ulkeSira);	
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\Eliz\\OneDrive\\Masa\u00FCst\u00FC\\image\\kutu-removebg-preview.png"));
		lblNewLabel_2.setBounds(475, 474, 330, 155);
		contentPane.add(lblNewLabel_2);
		
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Eliz\\OneDrive\\Masa\u00FCst\u00FC\\image\\kutu-removebg-preview.png"));
		lblNewLabel_1.setForeground(new Color(255, 0, 153));
		lblNewLabel_1.setBackground(new Color(255, 0, 204));
		lblNewLabel_1.setBounds(237, 423, 393, 257);
		contentPane.add(lblNewLabel_1);
		
		Image img3=new ImageIcon(this.getClass().getResource("/667775.jpg")).getImage();
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(img3));
		lblNewLabel.setBounds(-17, 0, 1591, 861);
		contentPane.add(lblNewLabel);
		
		
		//contentPane.add(table);
		//contentPane.add(table_1);
		//contentPane.add(table2);
		//contentPane.add(table1);
	}	
}