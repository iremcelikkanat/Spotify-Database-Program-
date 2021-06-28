package Spotify;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import java.awt.Color;

public class hesap extends JFrame {

	private JPanel contentPane;
	
	static String isim=null;
	static String id=null;
	private JTable table;
	private JScrollPane scrollPane_1;
	private JTable table_1;
	private JScrollPane scrollPane_2;
	private JTable table_2;
	
	DefaultTableModel modelim= new DefaultTableModel();
    DefaultTableModel modelim1= new DefaultTableModel();
    DefaultTableModel modelim2= new DefaultTableModel();
	Object[] kolonlar= {"pop sarki"};
	Object[] kolonlar1= {"caz sarki"};
	Object[] kolonlar2= {"klasik sarki"};
	Object[] satirlar= new Object[1];
	Object[] satirlar1= new Object[1];
	Object[] satirlar2= new Object[1];
	ResultSet res=null;
    ArrayList<String> takipEdilen1=new ArrayList<String>();
    ArrayList<String> kullanici1=new ArrayList<String>();
    ArrayList<String> sarki1=new ArrayList<String>();
    ArrayList<Integer> takipci=new ArrayList<Integer>();
    ArrayList<Integer> kullanici=new ArrayList<Integer>();
    private JButton btnNewButton;
    private int ekle=0;
    private JLabel lblNewLabel_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					hesap frame = new hesap(isim, id);
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
	public hesap(String isim,String id) {
		this.isim=isim;
		this.id=id;
		uyeOl o=new uyeOl();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1600, 900);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);	

		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"pop", "caz", "klasik"}));
		comboBox.setBounds(235, 623, 136, 33);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel = new JLabel("Kaydetmek \r\nistediginiz \r\nliste:");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel.setBounds(20, 618, 250, 40);
		contentPane.add(lblNewLabel);
		
		btnNewButton = new JButton("Ekle");
		JButton takip = new JButton("TAKIP ET");
		takip.setForeground(new Color(0, 102, 0));
		takip.setFont(new Font("Arial", Font.BOLD, 20));
		takip.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				takip.setText("takip ediliyor");
				res=baglanti.yap("takipedilenkullanici");
				String sqlsorgu="insert into takipedilenkullanici(kullaniciID,takipedilen_ID) values("+o.k_id+","+id+")";
				baglanti.ekle(sqlsorgu);
				comboBox.setVisible(true);
				btnNewButton.setVisible(true);
				lblNewLabel.setVisible(true);
			}
		});
		takip.setBounds(1085, 66, 262, 33);
		contentPane.add(takip);
		
		comboBox.setVisible(false);
		btnNewButton.setVisible(false);
		takip.setVisible(false);
		lblNewLabel.setVisible(false);
		
		res=baglanti.yap("kullanici");
		String sorgu="select aboneTur from kullanici where kullanici_id="+id;
		res=baglanti.arama(sorgu);

			int tur = 0;	
			try {
				while(res.next()){
				        
				     tur  = res.getInt("aboneTur");
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		res=baglanti.yap("takipedilenkullanici");
		String sorgu1="select takipedilen_ID from takipedilenkullanici where kullaniciID="+o.k_id;
		res=baglanti.arama(sorgu1);
		try {
			while(res.next()){
			        
			     takipci.add(res.getInt("takipedilen_ID"));
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		int var=0;
		for(int i=0;i<takipci.size();i++) {
			if(takipci.get(i)==Integer.parseInt(id)) {
				var++;
			}
		}
		if(tur==1) {
			takip.setVisible(true);
		}
		
		if(var!=0) {
			comboBox.setVisible(true);
			btnNewButton.setVisible(true);
			takip.setVisible(true);
			lblNewLabel.setVisible(true);
			takip.setText("takip ediliyor");
		}
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String sql = null;
				ResultSet myRs=baglanti.yap("kullanicidinlenensarkilar");
				int secilen=comboBox.getSelectedIndex();
				
				if(secilen==0) {
					sql="select sarki_adi,sarki.sarki_id from sarki where turID='1' and sarki_id in(select sarkilarID from kullanicidinlenensarkilar where kullanicilarID="+id+")";
				}else if(secilen==1) {
					sql="select sarki_adi,sarki.sarki_id from sarki where turID='2' and sarki_id in(select sarkilarID from kullanicidinlenensarkilar where kullanicilarID="+id+")";
				}else if(secilen==2) {
					sql="select sarki_adi,sarki.sarki_id from sarki where turID='3' and sarki_id in(select sarkilarID from kullanicidinlenensarkilar where kullanicilarID="+id+")";
				}
				System.out.println(sql);
				myRs=baglanti.arama(sql);
				takipEdilen1.clear();
				sarki1.clear();
				try {
					while(myRs.next()){
						 takipEdilen1.add(myRs.getString("sarki_adi"));
						 sarki1.add(myRs.getString("sarki_id"));
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				System.out.print(takipEdilen1);
				System.out.print(sarki1);
				
				int n=0;
				res=baglanti.yap("kullanicidinlenensarkilar");
				String sorgu1="select sarki_adi from sarki where sarki_id in(select sarkilarID from kullanicidinlenensarkilar where kullanicilarID="+o.k_id+")";
				res=baglanti.arama(sorgu1);
				try {
					while(res.next()){
					        
					     kullanici1.add(res.getString("sarki_adi"));
					     n++;
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				System.out.print(kullanici1);
				
				int ekle=0;
				for(int j=0;j<takipEdilen1.size();j++) {
					for(int k=0;k<kullanici1.size();k++) {
						if(takipEdilen1.get(j).equals(kullanici1.get(k))) {
							ekle++;
						}
					}
					if(ekle==0) {
						myRs=baglanti.yap("kullanicidinlenensarkilar");
						String sqlsorgu="insert into kullanicidinlenensarkilar(kullanicilarID,sarkilarID) values("+o.k_id+","+sarki1.get(j)+")";
						System.out.print(sarki1);
						baglanti.ekle(sqlsorgu);
					}else {
						System.out.println("listede var");
					}
				}
			
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnNewButton.setBounds(394, 623, 144, 33);
		contentPane.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(34, 88, 136, 402);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(modelim);
		modelim.setColumnIdentifiers(kolonlar);
		table.setBounds(272, 193, 120, 259);
		scrollPane.setViewportView(table);
		
		res=baglanti.yap("kullanicidinlenensarkilar");
		String sqlsorgu="select sarki_adi from sarki where turID='1' and sarki_id in(select sarkilarID from kullanicidinlenensarkilar where kullanicilarID="+id+")";
		modelim.setRowCount(0);
		res=baglanti.arama(sqlsorgu);
		System.out.println(sqlsorgu);
		try {
			while(res.next()) {
				satirlar[0]= res.getString("sarki_adi");
				modelim.addRow(satirlar);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		table.setModel(modelim);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ekle=0;
				String ad;
				int turid=0,sarkiid=0;
				ad= (String) modelim.getValueAt(table.getSelectedRow(), 0);
				res=baglanti.yap("sarki");
				String sqlsorgu2="SELECT sarki_id,turID FROM spotify.sarki where sarki_adi='"+ad+"'";
			     res=baglanti.arama(sqlsorgu2);
			     try {
						while(res.next()) {
			      	     
							turid=res.getInt("turID");
						    sarkiid=res.getInt("sarki_id");
							
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			     int n=0;
					res=baglanti.yap("kullanicidinlenensarkilar");
					String sorgu1="select sarki_id from sarki where sarki_id in(select sarkilarID from kullanicidinlenensarkilar where kullanicilarID="+o.k_id+")";
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
			    	    res=baglanti.yap("kullanicidinlenensarkilar");
						String sqlsorgu="insert into kullanicidinlenensarkilar(kullanicilarID,sarkilarID) values("+o.k_id+","+sarkiid+")";
						baglanti.ekle(sqlsorgu);
			     }else {
			    	 System.out.println("listede zaten var");
			     }
				
			}
		});
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(180, 88, 134, 402);
		contentPane.add(scrollPane_1);
		
		table_1 = new JTable();
		table_1.setModel(modelim1);
		modelim1.setColumnIdentifiers(kolonlar1);
		table_1.setBounds(350, 94, 102, 267);
		scrollPane_1.setViewportView(table_1);
		
		res=baglanti.yap("kullanicidinlenensarkilar");
		String sqlsorgu1="select sarki_adi from sarki where turID='2' and sarki_id in(select sarkilarID from kullanicidinlenensarkilar where kullanicilarID="+id+")";
		modelim1.setRowCount(0);
		res=baglanti.arama(sqlsorgu1);
		System.out.println(sqlsorgu1);
		try {
			while(res.next()) {
				satirlar1[0]= res.getString("sarki_adi");
				modelim1.addRow(satirlar1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		table_1.setModel(modelim1);
		table_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ekle=0;
				String ad;
				int turid=0,sarkiid=0;
				ad= (String) modelim1.getValueAt(table_1.getSelectedRow(), 0);
				res=baglanti.yap("sarki");
				String sqlsorgu2="SELECT sarki_id,turID FROM spotify.sarki where sarki_adi='"+ad+"'";
			     res=baglanti.arama(sqlsorgu2);
			     try {
						while(res.next()) {
			      	     
							turid=res.getInt("turID");
						    sarkiid=res.getInt("sarki_id");
							
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			     int n=0;
					res=baglanti.yap("kullanicidinlenensarkilar");
					String sorgu1="select sarki_id from sarki where sarki_id in(select sarkilarID from kullanicidinlenensarkilar where kullanicilarID="+o.k_id+")";
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
			    	    res=baglanti.yap("kullanicidinlenensarkilar");
						String sqlsorgu="insert into kullanicidinlenensarkilar(kullanicilarID,sarkilarID) values("+o.k_id+","+sarkiid+")";
						baglanti.ekle(sqlsorgu);
			     }else {
			    	 System.out.println("listede zaten var");
			     }
				
			}
		});
		
		scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(334, 88, 134, 402);
		contentPane.add(scrollPane_2);
		
		table_2 = new JTable();
		table_2.setModel(modelim2);
		modelim2.setColumnIdentifiers(kolonlar2);
		table_2.setBounds(497, 88, 109, 270);
		scrollPane_2.setViewportView(table_2);
		
		res=baglanti.yap("kullanicidinlenensarkilar");
		String sqlsorgu2="select sarki_adi from sarki where turID='3' and sarki_id in(select sarkilarID from kullanicidinlenensarkilar where kullanicilarID="+id+")";
		modelim2.setRowCount(0);
		res=baglanti.arama(sqlsorgu2);
		System.out.println(sqlsorgu2);
		try {
			while(res.next()) {
				satirlar2[0]= res.getString("sarki_adi");
				modelim2.addRow(satirlar2);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		table_2.setModel(modelim2);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 79, 22);
		contentPane.add(menuBar);
		
		JMenu mnNewMenu = new JMenu("MENU");
		menuBar.add(mnNewMenu);
		
		JMenu mnNewMenu_1 = new JMenu("Anasayfa");
		mnNewMenu_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				kullaniciGiris giris= new kullaniciGiris();
				giris.setVisible(true);
				setVisible(false);
			}
		});
		mnNewMenu.add(mnNewMenu_1);
		
		JMenu mnNewMenu_2 = new JMenu("\u00C7\u0131k\u0131\u015F");
		mnNewMenu_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				uyeOl uye=new uyeOl();
				uye.setVisible(true);
				System.exit(JFrame.EXIT_ON_CLOSE);
			}
		});
		mnNewMenu.add(mnNewMenu_2);
		table_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ekle=0;
				String ad;
				int turid=0,sarkiid=0;
				ad= (String) modelim2.getValueAt(table_2.getSelectedRow(), 0);
				res=baglanti.yap("sarki");
				String sqlsorgu2="SELECT sarki_id,turID FROM spotify.sarki where sarki_adi='"+ad+"'";
			     res=baglanti.arama(sqlsorgu2);
			     try {
						while(res.next()) {
			      	     
							turid=res.getInt("turID");
						    sarkiid=res.getInt("sarki_id");
							
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			     int n=0;
					res=baglanti.yap("kullanicidinlenensarkilar");
					String sorgu1="select sarki_id from sarki where sarki_id in(select sarkilarID from kullanicidinlenensarkilar where kullanicilarID="+o.k_id+")";
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
			    	    res=baglanti.yap("kullanicidinlenensarkilar");
						String sqlsorgu="insert into kullanicidinlenensarkilar(kullanicilarID,sarkilarID) values("+o.k_id+","+sarkiid+")";
						baglanti.ekle(sqlsorgu);
			     }else {
			    	 System.out.println("listede zaten var");
			     }
				
			}
		});
		Image img2=new ImageIcon(this.getClass().getResource("/667775.jpg")).getImage();
	
		lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(img2));
		lblNewLabel_1.setBounds(-11, 0, 1600, 900);
		contentPane.add(lblNewLabel_1);
	
		
		
		
		//contentPane.add(table_2);
		//contentPane.add(table_1);
		//contentPane.add(table);

	}
}
