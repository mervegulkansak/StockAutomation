package magazaproje;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class baglanti_kayit {
	static Connection conn;
	static Statement st ;
	
	
	static ResultSet yap(){
		ResultSet rs = null;
		try {
			conn = (Connection) DriverManager.getConnection("jdbc:sqlite:C://sqlite/magaza.db");
			st =(Statement) conn.createStatement();
			rs = st.executeQuery("select * from hesaplar");
			return rs;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}

	
	 static void ekle(String sql_sorgu1) {
		 try {
			st.executeUpdate(sql_sorgu1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	 
		 
	 
	 }
}
