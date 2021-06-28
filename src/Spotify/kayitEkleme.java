package Spotify;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;

public class kayitEkleme extends JFrame {

	private JPanel contentPane;
	private JTable table;
	
	DefaultTableModel modelim= new DefaultTableModel();
	
	Object[] kolonlar= {"ýd","isim","tur","sanatci","album","sure","dinlenmesys","tarih"};
	Object[] satirlar= new Object[8];
	Object[] kolonlar1= {"ýd","album adi","tarih","tur"};
	Object[] satirlar1= new Object[5];
	Object[] kolonlar2= {"sanatci_id","sanatci_adi","ulke_id"};
	Object[] satirlar2= new Object[3];
	private JTextField text_ID;
	private JTextField text_Ad;
	private JTextField text_tarih;
	private JTextField textSanatci;
	private JTextField textAlbum;
	private JTextField textTur;
	private JTextField textSure;
	private JTextField textDinlenmeSys;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JTextField textal_id;
	ResultSet res=null;
	private JLabel lblNewLabel_6;
	private JTextField text_ulke;
	private JLabel lblNewLabel_9;
	private JTextField textSanat_id;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					kayitEkleme frame = new kayitEkleme();
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
	public kayitEkleme() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1600, 900);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 79, 22);
		contentPane.add(menuBar);
		
		JMenu mnNewMenu = new JMenu("MENU");
		menuBar.add(mnNewMenu);
		
		JMenu mnNewMenu_1 = new JMenu("Cýkýs");
		mnNewMenu_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(JFrame.EXIT_ON_CLOSE);
			}
		});
		mnNewMenu.add(mnNewMenu_1);
		
		JMenu mnNewMenu_2 = new JMenu("Giris Sayfasý");
		mnNewMenu_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				uyeOl uye=new uyeOl();
				uye.setVisible(true);
				setVisible(false);
			}
		});
		mnNewMenu.add(mnNewMenu_2);
		
		JScrollPane scrollPane = new JScrollPane();
	
		scrollPane.setBounds(10, 71, 664, 542);
		contentPane.add(scrollPane);
		
	    JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Sarki", "Album", "Sanatci"}));
		comboBox.setBounds(715, 69, 128, 34);
		contentPane.add(comboBox);
		
		table = new JTable();
		modelim.setColumnIdentifiers(kolonlar);
		table.setBounds(193, 252, 335, 169);
		scrollPane.setViewportView(table);
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int secilen=comboBox.getSelectedIndex();
				
				if(secilen==0) {
					text_ID.setText((String) modelim.getValueAt(table.getSelectedRow(), 0));
					text_Ad.setText((String) modelim.getValueAt(table.getSelectedRow(), 1));
					text_tarih.setText((String) modelim.getValueAt(table.getSelectedRow(), 7));
					textSanatci.setText((String) modelim.getValueAt(table.getSelectedRow(), 3));
					textAlbum.setText((String) modelim.getValueAt(table.getSelectedRow(), 4));
					textTur.setText((String) modelim.getValueAt(table.getSelectedRow(), 2));
					textSure.setText((String) modelim.getValueAt(table.getSelectedRow(), 5));
					textDinlenmeSys.setText((String) modelim.getValueAt(table.getSelectedRow(), 6));
				}else if(secilen==1) {
					text_tarih.setText((String) modelim.getValueAt(table.getSelectedRow(), 2));
					textAlbum.setText((String) modelim.getValueAt(table.getSelectedRow(), 0));
					textTur.setText((String) modelim.getValueAt(table.getSelectedRow(), 3));
					textal_id.setText((String) modelim.getValueAt(table.getSelectedRow(), 1));
				}else if(secilen==2) {
					textSanat_id.setText((String) modelim.getValueAt(table.getSelectedRow(), 0));
					textSanatci.setText((String) modelim.getValueAt(table.getSelectedRow(), 1));
					text_ulke.setText((String) modelim.getValueAt(table.getSelectedRow(), 2));
				}
			}
		});
		
		JButton btnListele = new JButton("L\u0130STELE");
		btnListele.setForeground(new Color(0, 102, 0));
		btnListele.setFont(new Font("Arial", Font.BOLD, 20));
		btnListele.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				modelim.setColumnIdentifiers(kolonlar);
				int secilen=comboBox.getSelectedIndex();
				if(secilen==0) {
				res=baglanti.yap("sarki");
				modelim.setRowCount(0);
				try {
					while(res.next()) {
						satirlar[0]= res.getString("sarki_id");
						satirlar[1]= res.getString("sarkiadi");
						satirlar[2]= res.getString("turID");
						satirlar[3]= res.getString("sanatci");
						satirlar[4]= res.getString("album_id");
						satirlar[5]= res.getString("sure");
						satirlar[6]= res.getString("dinlenmeSayisi");
						satirlar[7]= res.getString("tarih");
						modelim.addRow(satirlar);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				table.setModel(modelim);
				}else if(secilen==1) {
					modelim.setColumnIdentifiers(kolonlar1);
					res=baglanti.yap("album");
					modelim.setRowCount(0);
					try {
						while(res.next()) {
							satirlar1[0]= res.getString("album_id");
							satirlar1[1]= res.getString("album_adi");
							satirlar1[2]= res.getString("tarih");
							satirlar1[3]= res.getString("tur_id");
							modelim.addRow(satirlar1);
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					table.setModel(modelim);
				}else if(secilen==2) {
					modelim.setColumnIdentifiers(kolonlar2);
					res=baglanti.yap("sanatci");
					modelim.setRowCount(0);
					try {
						while(res.next()) {
							satirlar2[0]= res.getString("sanatci_id");
							satirlar2[1]= res.getString("sanatci_adi");
							satirlar2[2]= res.getString("ulke_id");
							modelim.addRow(satirlar2);
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					table.setModel(modelim);
				}
			}
		});
		btnListele.setBounds(1262, 685, 246, 30);
		contentPane.add(btnListele);
		
		text_ID = new JTextField();
		text_ID.setBounds(1262, 122, 218, 30);
		contentPane.add(text_ID);
		text_ID.setColumns(10);
		
		text_Ad= new JTextField();
		text_Ad.setBounds(1262, 172, 218, 30);
		contentPane.add(text_Ad);
		text_Ad.setColumns(10);
		
		text_tarih = new JTextField();
		text_tarih.setBounds(1262, 223, 218, 30);
		contentPane.add(text_tarih);
		text_tarih.setColumns(10);
		
		textSanatci = new JTextField();
		textSanatci.setBounds(1262, 272, 218, 30);
		contentPane.add(textSanatci);
		textSanatci.setColumns(10);
		
		textAlbum = new JTextField();
		textAlbum.setBounds(1262, 325, 218, 30);
		contentPane.add(textAlbum);
		textAlbum.setColumns(10);
		
		textTur = new JTextField();
		textTur.setBounds(1262, 378, 218, 34);
		contentPane.add(textTur);
		textTur.setColumns(10);
		
		textSure = new JTextField();
		textSure.setBounds(1262, 431, 218, 30);
		contentPane.add(textSure);
		textSure.setColumns(10);
		
		textDinlenmeSys = new JTextField();
		textDinlenmeSys.setBounds(1262, 482, 218, 32);
		contentPane.add(textDinlenmeSys);
		textDinlenmeSys.setColumns(10);
		
		textal_id = new JTextField();
		textal_id.setBounds(1262, 531, 218, 30);
		contentPane.add(textal_id);
		textal_id.setColumns(10);
		
		text_ulke = new JTextField();
		text_ulke.setBounds(1262, 582, 218, 31);
		contentPane.add(text_ulke);
		text_ulke.setColumns(10);
		
		textSanat_id = new JTextField();
		textSanat_id.setBounds(1262, 629, 218, 30);
		contentPane.add(textSanat_id);
		textSanat_id.setColumns(10);
		
		JButton btnKaydet = new JButton("KAYDET");
		btnKaydet.setForeground(new Color(0, 102, 0));
		btnKaydet.setFont(new Font("Arial", Font.BOLD, 15));
		btnKaydet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int secilen=comboBox.getSelectedIndex();
				if(secilen==0) {
				String id,ad,tarih,sanatci,album,tur,sure,sayi,sqlsorgu,al_id;
				
				id=text_ID.getText();
				ad=text_Ad.getText();
				tarih=text_tarih.getText();
				sanatci=textSanatci.getText();
				album=textAlbum.getText();
				tur=textTur.getText();
				sure=textSure.getText();
				sayi=textDinlenmeSys.getText();
				al_id=textal_id.getText();

				res=baglanti.yap("album");
				sqlsorgu="INSERT INTO album(album_id,album_adi,tarih,tur_id) VALUES("
						+ album +",'" +al_id+"','"+tarih+"',"+tur+")";
				System.out.println(sqlsorgu);
				baglanti.ekle(sqlsorgu);
				
				res=baglanti.yap("sarki");
				sqlsorgu="INSERT INTO sarki(sarki_id,sarkiadi,turID,sanatci,album_id,sure,dinlenmeSayisi,tarih) VALUES("
						+ id +",'" +ad+"',"+ tur +",'"+sanatci+"',"+album+","+sure+","+sayi+",'"+tarih+"')";
				System.out.println(sqlsorgu);
				baglanti.ekle(sqlsorgu);
				
				res=baglanti.yap("album_sarki");
				sqlsorgu="INSERT INTO album_sarki(albumID,sarkiID) VALUES("
						+ album +","+id+")";
				System.out.println(sqlsorgu);
				baglanti.ekle(sqlsorgu);
				
				}else if(secilen==1) {
					String ad,tarih,album,tur,sqlsorgu,al_id;

					ad=text_Ad.getText();
					tarih=text_tarih.getText();
					album=textAlbum.getText();
					tur=textTur.getText();
					al_id=textal_id.getText();

					res=baglanti.yap("album");
					sqlsorgu="INSERT INTO album(album_id,album_adi,tarih,tur_id) VALUES("
							+ album +",'" +al_id+"','" +tarih+"',"+tur+")";
					System.out.println(sqlsorgu);
					baglanti.ekle(sqlsorgu);
					
				}else if(secilen==2){
					String id,sanatci,ulke,sqlsorgu;

					sanatci=textSanatci.getText();
					ulke=text_ulke.getText();
					id=textSanat_id.getText();

					res=baglanti.yap("sanatci");
					sqlsorgu="INSERT INTO sanatci(sanatci_id,sanatci_adi,ulke_id) VALUES("
							+id+",'" +sanatci+"',"+ulke+")";
					System.out.println(sqlsorgu);
					baglanti.ekle(sqlsorgu);
				}
			}
		});
		btnKaydet.setBounds(1123, 64, 114, 30);
		contentPane.add(btnKaydet);
		
		JLabel lblNewLabel = new JLabel("SARKI ID");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 19));
		lblNewLabel.setBounds(1141, 124, 86, 19);
		contentPane.add(lblNewLabel);
		
		JLabel lblIsm = new JLabel("SARKI ADI");
		lblIsm.setForeground(new Color(255, 255, 255));
		lblIsm.setFont(new Font("Arial", Font.BOLD, 19));
		lblIsm.setBounds(1141, 174, 101, 19);
		contentPane.add(lblIsm);
		
		JLabel lblUlke = new JLabel("TARIH");
		lblUlke.setForeground(new Color(255, 255, 255));
		lblUlke.setFont(new Font("Arial", Font.BOLD, 19));
		lblUlke.setBounds(1149, 225, 88, 19);
		contentPane.add(lblUlke);
		
		JButton btnUpdate = new JButton("GUNCELLE");
		btnUpdate.setForeground(new Color(0, 102, 0));
		btnUpdate.setFont(new Font("Arial", Font.BOLD, 15));
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int secilen=comboBox.getSelectedIndex();
				if(secilen==0) {
				String id,ad,tarih,sanatci,album,tur,sure,sayi,sqlsorgu,al_id;
				
	               id=text_ID.getText();
					ad=text_Ad.getText();
					tarih=text_tarih.getText();
					sanatci=textSanatci.getText();
					album=textAlbum.getText();
					tur=textTur.getText();
					sure=textSure.getText();
					sayi=textDinlenmeSys.getText();
					al_id=textal_id.getText();
					
					res=baglanti.yap("sarki");
					sqlsorgu="UPDATE sarki SET sarkiadi='"+ad+"',turID='"+tur+"',sanatci='"+sanatci+"',album_id='"+album+"',sure='"+sure+
							"',dinlenmeSayisi='"+sayi+"',tarih='"+tarih+"' WHERE sarki_id='"+id+"'";
					
					System.out.println(sqlsorgu);
					baglanti.duzenle(sqlsorgu);
					
					res=baglanti.yap("album");
					sqlsorgu="UPDATE album SET tarih='"+tarih+"',tur_id='"+tur+"' WHERE album_id='"+album+"'";
					System.out.println(sqlsorgu);
					baglanti.duzenle(sqlsorgu);

				}else if(secilen==1) {
					String tarih,album,tur,sqlsorgu,al_id;

					tarih=text_tarih.getText();
					album=textAlbum.getText();
					tur=textTur.getText();
					al_id=textal_id.getText();
					
					res=baglanti.yap("album");
					sqlsorgu="UPDATE album SET album_adi='"+al_id+"',tarih='"+tarih+"',tur_id='"+tur+"' WHERE album_id='"+album+"'";
					
					System.out.println(sqlsorgu);
					baglanti.duzenle(sqlsorgu);
					
				}else if(secilen==2) {
					String id,sanatci,ulke,sqlsorgu;

					sanatci=textSanatci.getText();
					ulke=text_ulke.getText();
					id=textSanat_id.getText();

					res=baglanti.yap("sanatci");
					sqlsorgu="UPDATE sanatci SET sanatci_adi='"+sanatci+"',ulke_id="+ulke+" WHERE sanatci_id='"+id+"'";
					
					System.out.println(sqlsorgu);
					baglanti.duzenle(sqlsorgu);
				}
					
			}
		});
		btnUpdate.setBounds(1262, 63, 133, 30);
		contentPane.add(btnUpdate);
		
		JButton btnSil = new JButton("S\u0130L");
		btnSil.setForeground(new Color(0, 102, 0));
		btnSil.setFont(new Font("Arial", Font.BOLD, 15));
		btnSil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int secilen=comboBox.getSelectedIndex();
				if(secilen==0) {
				String id,sqlsorgu,album;
				id=text_ID.getText();
				//album=textAlbum.getText();
				res=baglanti.yap("sarki");
				sqlsorgu="DELETE FROM sarki WHERE sarki_id="+id;
				System.out.println(sqlsorgu);
				baglanti.sil(sqlsorgu);
				}else if(secilen==1) {
					String id,sqlsorgu,album;
					id=textAlbum.getText();
					//album=textAlbum.getText();
					res=baglanti.yap("album");
					sqlsorgu="DELETE FROM album WHERE album_id="+id;
					System.out.println(sqlsorgu);
					baglanti.sil(sqlsorgu);
				}else if(secilen==2) {
					String id,sqlsorgu;
					id=textSanat_id.getText();
					res=baglanti.yap("sanatci");
					sqlsorgu="DELETE FROM sanatci WHERE sanatci_id="+id;
					System.out.println(sqlsorgu);
					baglanti.sil(sqlsorgu);
				}
			}
		});
		btnSil.setBounds(1420, 64, 96, 30);
		contentPane.add(btnSil);
		
		lblNewLabel_1 = new JLabel("Sanatci Ad\u0131");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 17));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(1141, 273, 128, 23);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel(" Album ID");
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 17));
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setBounds(1141, 329, 86, 16);
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Tur");
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 19));
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setBounds(1141, 367, 86, 25);
		contentPane.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("Sure");
		lblNewLabel_4.setFont(new Font("Arial", Font.BOLD, 19));
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setBounds(1141, 434, 68, 16);
		contentPane.add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("Dinlenme Sayisi");
		lblNewLabel_5.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_5.setForeground(new Color(255, 255, 255));
		lblNewLabel_5.setBounds(1138, 483, 146, 24);
		contentPane.add(lblNewLabel_5);
		
		
		JLabel lblNewLabel_7 = new JLabel("Album Ad\u0131");
		lblNewLabel_7.setFont(new Font("Arial", Font.BOLD, 19));
		lblNewLabel_7.setForeground(new Color(255, 255, 255));
		lblNewLabel_7.setBounds(1138, 542, 123, 19);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Sanatci Ulke");
		lblNewLabel_8.setFont(new Font("Arial", Font.BOLD, 19));
		lblNewLabel_8.setForeground(Color.WHITE);
		lblNewLabel_8.setBounds(1141, 583, 114, 30);
		contentPane.add(lblNewLabel_8);
		
		lblNewLabel_9 = new JLabel("Sanatci ID");
		lblNewLabel_9.setForeground(Color.WHITE);
		lblNewLabel_9.setFont(new Font("Arial", Font.BOLD, 19));
		lblNewLabel_9.setBounds(1141, 629, 120, 23);
		contentPane.add(lblNewLabel_9);
		
		
		Image img1=new ImageIcon(this.getClass().getResource("/arkaplan2.png")).getImage();
		
		lblNewLabel_6 = new JLabel("New label");
		lblNewLabel_6.setIcon(new ImageIcon(img1));
		lblNewLabel_6.setBounds(-16, 0, 1600, 900);
		contentPane.add(lblNewLabel_6);
		


		
		//contentPane.add(table);
	}
}
