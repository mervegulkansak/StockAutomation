package magazaproje;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class baglanti {
	static Connection conn;
	static Statement st ;
	
	
	static ResultSet yap(){
		ResultSet rs = null;
		try {
			conn = (Connection) DriverManager.getConnection("jdbc:sqlite:C://sqlite/magaza.db");
			st =(Statement) conn.createStatement();
			rs = st.executeQuery("select * from urunler");
			return rs;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}
	 static void ekle(String sql_sorgu) {
		 try {
			st.executeUpdate(sql_sorgu);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	 
		 
	 
	 }
	 
	 static void update(String sql_sorgu) {
		 try {
			st.executeUpdate(sql_sorgu);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	 }
	 
	 static void sil (String sql_sorgu) {
		 try {
			st.executeUpdate(sql_sorgu);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
	 
	static ResultSet sorgula(String sql_sorgu) {
		ResultSet rs = null;
		
		try {
			rs =  st.executeQuery(sql_sorgu);
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
				
		return rs;
	}
	
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
}














