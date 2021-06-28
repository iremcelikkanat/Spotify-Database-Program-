package Spotify;

import java.sql.*;

import com.mysql.*;

public class baglanti {

	static Connection c;
	static Statement s;
	static ResultSet yap(String tablo) {
		// TODO Auto-generated method stub
		ResultSet res = null;
		try {
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/spotify?useTimezone=true&serverTimezone=UTC", "root", "Xje0815F");
            s = c.createStatement();
            res = s.executeQuery("select * from "+tablo);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
		return res;
	}

	static void ekle(String sorgu) {
		try {
			s.executeUpdate(sorgu);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	static void duzenle(String sorgu) {
		try {
			s.executeUpdate(sorgu);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	static void sil(String sorgu) {
		try {
			s.executeUpdate(sorgu);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	static ResultSet arama(String sorgu) {
		ResultSet myRs=null;
		try {
			myRs=s.executeQuery(sorgu);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return myRs;
	}
}
