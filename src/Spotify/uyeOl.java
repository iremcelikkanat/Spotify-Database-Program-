package Spotify;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

public class uyeOl extends JFrame {

	private JPanel contentPane;
	private JTextField textField_ad;
	private JTextField textField_mail;
	private JTextField textField_sifre;
	private JTextField textField_odeme;
	private JTextField textField_ülke;
	static String id;
	static String ad;
	static String sifre2;
	static String mail;
	static String odeme;
	static String ulke;
	private JTextField textad;
	private JTextField textsifre;
	static String isim;
	static String sifre;
	static int k_id=0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					uyeOl frame = new uyeOl();
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
	public uyeOl() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1600, 900);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField_ad = new JTextField();
		textField_ad.setBounds(282, 241, 145, 30);
		contentPane.add(textField_ad);
		textField_ad.setColumns(10);
		
		textField_mail = new JTextField();
		textField_mail.setBounds(282, 317, 145, 30);
		contentPane.add(textField_mail);
		textField_mail.setColumns(10);
		
		textField_sifre = new JTextField();
		textField_sifre.setBounds(282, 398, 145, 30);
		contentPane.add(textField_sifre);
		textField_sifre.setColumns(10);
		
		textField_odeme = new JTextField();
		textField_odeme.setBounds(282, 558, 145, 30);
		contentPane.add(textField_odeme);
		textField_odeme.setColumns(10);
		
		textField_ülke = new JTextField();
		textField_ülke.setBounds(282, 505, 145, 30);
		contentPane.add(textField_ülke);
		textField_ülke.setColumns(10);
		
		JButton btnNewButton = new JButton("KAYIT OL");
		btnNewButton.setForeground(new Color(0, 102, 0));
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 24));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ResultSet res=baglanti.yap("kullanici");
			//	id=textField_id.getText();
				ad=textField_ad.getText();
				sifre2=textField_sifre.getText();
				mail=textField_mail.getText();
				odeme=textField_odeme.getText();
				ulke=textField_ülke.getText();
				
						
						
			String 	sqlsorgu="INSERT INTO spotify.kullanici(kullanici_adi,email,sifre,ulkeID,odendi) VALUES("
				+ "'" + ad +"','" + mail +"','"+sifre2+"',"+ulke+","+odeme+")";
				
			System.out.println(sqlsorgu);
			baglanti.ekle(sqlsorgu);
			}
		});
		btnNewButton.setBounds(136, 670, 196, 40);
		contentPane.add(btnNewButton);
		
		textad = new JTextField();
		textad.setBounds(1410, 302, 164, 30);
		contentPane.add(textad);
		textad.setColumns(10);
		
		
		JLabel lblNewLabel_11 = new JLabel("Normal Uyelik i\u00E7in 0 giriniz.");
		lblNewLabel_11.setForeground(new Color(255, 255, 255));
		lblNewLabel_11.setBounds(283, 618, 145, 21);
		contentPane.add(lblNewLabel_11);
		JLabel lblNewLabel_2 = new JLabel("Premimum Uyelik i\u00E7in 1 giriniz.");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setBounds(283, 599, 145, 21);
		contentPane.add(lblNewLabel_2);
		
		textsifre = new JTextField();
		textsifre.setBounds(1410, 400, 164, 28);
		contentPane.add(textsifre);
		textsifre.setColumns(10);
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"T\u00FCrkiye i\u00E7in 1 giriniz.", "\u0130ngiltere i\u00E7in 2 giriniz.", "Almanya i\u00E7in 3 giriniz."}));
	comboBox.setBounds(282, 464, 145, 30);
	contentPane.add(comboBox);

		
		JButton kullanici = new JButton("G\u0130R\u0130S");
		kullanici.setForeground(new Color(0, 102, 0));
		kullanici.setFont(new Font("Arial", Font.BOLD, 24));
		kullanici.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				isim=textad.getText();
				sifre=textsifre.getText();
				
				String sqlsorgu="SELECT kullanici_id,odendi,count(kullanici_id) as giris FROM spotify.kullanici where kullanici_adi='"+isim+
						"' and sifre='"+sifre+"'";
				
				ResultSet res=baglanti.yap("kullanici");
				res=baglanti.arama(sqlsorgu);		
				try {
					while(res.next()) {
						 k_id=res.getInt("kullanici_id");
						if(res.getInt("giris")==1)
						{
							kullaniciGiris giris=new kullaniciGiris();
							giris.setVisible(true);//kayit sayfasýný aç
						    setVisible(false);//kullanici sayfasýný kapat
							
						}
						else
						{
							kullanici.setText("hatali giris");
						}
					}
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
			}
		});
		kullanici.setBounds(1194, 495, 380, 52);
		contentPane.add(kullanici);
		
		JButton uye = new JButton("ADM\u0130N G\u0130R\u0130S");
		uye.setForeground(new Color(0, 102, 0));
		uye.setFont(new Font("Arial", Font.BOLD, 24));
		uye.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				isim=textad.getText();
				sifre=textsifre.getText();
				
				
				String sqlsorgu="SELECT count(adminID) as giris FROM spotify.admin where adminAd='"+isim+
						"' and sifre='"+sifre+"'";
				ResultSet res=baglanti.yap("admin");
				res=baglanti.arama(sqlsorgu);		
				try {
					while(res.next()) {
						if(res.getInt("giris")==1)
						{
							kayitEkleme kayit=new kayitEkleme();
							kayit.setVisible(true);//kayit sayfasýný aç
							setVisible(false);//kullanici sayfasýný kapat
							
						}
						else
						{
							uye.setText("hatali giris");
						}
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		uye.setBounds(1194, 558, 380, 52);
		contentPane.add(uye);
		Image img=new ImageIcon(this.getClass().getResource("/arkaplan.png")).getImage();
		JLabel lblNewLabel_5 = new JLabel("New label");
		lblNewLabel_5.setIcon(new ImageIcon(img));

		lblNewLabel_5.setBounds(0, -50, 1948, 993);
		contentPane.add(lblNewLabel_5);
		
		
	}
}
