package magazaproje;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.ImageIcon;
import java.awt.Color;

public class urunsorgula extends JFrame {

	private JPanel contentPane;
	private JTable table;
	
    DefaultTableModel model = new DefaultTableModel();
	
	Object[] kolonlar = {"id","Kategori","Adi","UrunAdet","Beden","Renk","Tarih","Fiyat","Durum"};
	Object[] satirlar = new Object[9];
	private JTextField txt_sorgula;

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					urunsorgula frame = new urunsorgula();
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
	public urunsorgula() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 946, 703);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.textInactiveText);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(98, 79, 644, 286);
		contentPane.add(scrollPane);
		

		
		table = new JTable();
		
		model.setColumnIdentifiers(kolonlar);
		
		table.setBounds(71, 270, 668, 180);
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("\u00DCR\u00DCN SORGULA/L\u0130STELE");
		lblNewLabel.setForeground(new Color(0, 0, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel.setBounds(246, 28, 299, 40);
		contentPane.add(lblNewLabel);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBackground(new Color(218, 165, 32));
		comboBox.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 14));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"ALAN SE\u00C7\u0130N\u0130Z", "ID", "\u00DCR\u00DCN ADI", "KATEGOR\u0130", "RENK", "TAR\u0130H ", "DURUM"}));
		comboBox.setBounds(208, 518, 189, 44);
		contentPane.add(comboBox);
		
		txt_sorgula = new JTextField();
		txt_sorgula.setBounds(208, 586, 189, 35);
		contentPane.add(txt_sorgula);
		txt_sorgula.setColumns(10);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon("iconlar\\bul.png"));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				model.setRowCount(0);
				 String alan = txt_sorgula.getText();

				 String sql_sorgu=null;
				 ResultSet rs  = null;
				 
				 int secilen = comboBox.getSelectedIndex();
				 
				 if(secilen == 1) {
					  sql_sorgu= "select * from urunler where id= " + Integer.parseInt(alan);	 
				 } else if (secilen == 2) {
					 sql_sorgu= "select * from urunler where  Adi like'" + alan + "%'";	 
				 }else if (secilen == 3) {
					 sql_sorgu= "select * from urunler where Kategori like'" + alan + "%'";
				 } else if (secilen == 4) {
						 sql_sorgu= "select * from urunler where Renk like'" + alan + "%'";
		
				 }else if(secilen == 5) {
					  sql_sorgu= "select * from urunler where Tarih like'" + alan + "%'";	 
				 
				 }else if (secilen == 6) {
					 sql_sorgu= "select * from urunler where Durum like'" + alan + "%'";
				 }
				 
			

				rs = baglanti.sorgula(sql_sorgu);
				 
				 try {
						while(rs.next()) {
							satirlar[0]= rs.getString("id");
							satirlar[1]= rs.getString("Kategori");
							satirlar[2]= rs.getString("Adi");
							satirlar[3]= rs.getString("UrunAdet");
							satirlar[4]= rs.getString("Beden");
							satirlar[5]= rs.getString("Renk");
							satirlar[6]= rs.getString("Tarih");
							satirlar[7]= rs.getString("Fiyat");
							satirlar[8]= rs.getString("Durum");
							model.addRow(satirlar);
							
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				 

				
			}
		});
		btnNewButton.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 14));
		btnNewButton.setBounds(466, 527, 65, 65);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("SORGU ALANI SE\u00C7\u0130N\u0130Z");
		lblNewLabel_1.setBackground(new Color(218, 165, 32));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 17));
		lblNewLabel_1.setBounds(185, 470, 241, 40);
		contentPane.add(lblNewLabel_1);
		
		JButton btnTmrnleriListele = new JButton("T\u00DCM \u00DCR\u00DCNLER\u0130 L\u0130STELE");
		btnTmrnleriListele.setForeground(new Color(255, 255, 255));
		btnTmrnleriListele.setBackground(new Color(34, 139, 34));
		btnTmrnleriListele.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				model.setRowCount(0);
				ResultSet rs = baglanti.yap();	
				
			
				try {
					while(rs.next()) {
						satirlar[0]= rs.getString("id");
						satirlar[1]= rs.getString("Kategori");
						satirlar[2]= rs.getString("Adi");
						satirlar[3]= rs.getString("UrunAdet");
						satirlar[4]= rs.getString("Beden");
						satirlar[5]= rs.getString("Renk");
						satirlar[6]= rs.getString("Tarih");
						satirlar[7]= rs.getString("Fiyat");
						satirlar[8]= rs.getString("Durum");
						model.addRow(satirlar);
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				table.setModel(model);
			}
		});
		btnTmrnleriListele.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 19));
		btnTmrnleriListele.setBounds(280, 386, 281, 59);
		contentPane.add(btnTmrnleriListele);
		
		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				anasayfa ana = new anasayfa();
				ana.setVisible(true);
				setVisible(false);
			}
		});
		button.setIcon(new ImageIcon("iconlar\\anasayfa.jpg"));
		button.setBackground(SystemColor.textInactiveText);
		button.setBounds(10, 8, 60, 60);
		contentPane.add(button);
		
	}
}
