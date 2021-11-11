package magazaproje;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class baglanti_personel {
	static Connection conn;
	static Statement st ;
	
	
	static ResultSet yap(){
		ResultSet rs = null;
		try {
			conn = (Connection) DriverManager.getConnection("jdbc:sqlite:C://sqlite/magaza.db");
			st =(Statement) conn.createStatement();
			rs = st.executeQuery("select * from personel_bilgileri");
			return rs;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}
	 static void ekle(String sqlsorgu) {
		 try {
			st.executeUpdate(sqlsorgu);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	 
		 
	 }
	 
	 static void sil (String sqlsorgu) {
		 try {
			st.executeUpdate(sqlsorgu);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
}
