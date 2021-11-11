package magazaproje;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class personel extends JFrame {

	private JPanel contentPane;
private JTable table;
	
	DefaultTableModel tablo = new DefaultTableModel();
	
	Object[] kolonlar = {"PersonelID","PersonelAdi","PersonelSoyadi","Cinsiyet","DogumTarihi","Adres"};
	Object[] satirlar = new Object[6];
	private JTextField txt_id;
	private JTextField txt_adi;
	private JTextField txt_soyadi;
	private JTextField txt_dt;
	private JTextField txt_adres;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					personel frame = new personel();
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
	public personel() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 844, 808);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.textInactiveText);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(61, 85, 651, 164);
		contentPane.add(scrollPane);
		
		table = new JTable();
		tablo.setColumnIdentifiers(kolonlar);
		table.setBounds(199, 295, 169, 96);
		scrollPane.setViewportView(table);
		
		JButton btnPersonelleriListele = new JButton("PERSONELLER\u0130 L\u0130STELE");
		btnPersonelleriListele.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				tablo.setRowCount(0);
				ResultSet rs = baglanti_personel.yap();	
				
			
				try {
					while(rs.next()) {
						satirlar[0]= rs.getString("PersonelID");
						satirlar[1]= rs.getString("PersonelAdi");
						satirlar[2]= rs.getString("PersonelSoyadi");
						satirlar[3]= rs.getString("Cinsiyet");
						satirlar[4]= rs.getString("DogumTarihi");
						satirlar[5]= rs.getString("Adres");
					
						tablo.addRow(satirlar);
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				table.setModel(tablo);
			}
		});

		btnPersonelleriListele.setForeground(Color.WHITE);
		btnPersonelleriListele.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 19));
		btnPersonelleriListele.setBackground(new Color(34, 139, 34));
		btnPersonelleriListele.setBounds(234, 274, 281, 59);
		contentPane.add(btnPersonelleriListele);
		
		
		JLabel lblPersonelBilgileri = new JLabel("PERSONEL B\u0130LG\u0130LER\u0130");
		lblPersonelBilgileri.setForeground(new Color(0, 0, 255));
		lblPersonelBilgileri.setHorizontalAlignment(SwingConstants.CENTER);
		lblPersonelBilgileri.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 20));
		lblPersonelBilgileri.setBounds(259, 34, 256, 40);
		contentPane.add(lblPersonelBilgileri);
		
		JLabel lblNewLabel = new JLabel("Personel ID");
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel.setBounds(105, 431, 99, 28);
		contentPane.add(lblNewLabel);
		
		JLabel lblPersonelAdi = new JLabel("Personel Adi");
		lblPersonelAdi.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 15));
		lblPersonelAdi.setBounds(389, 439, 99, 28);
		contentPane.add(lblPersonelAdi);
		
		JLabel lblPersonelSoyadi = new JLabel("Personel Soyadi");
		lblPersonelSoyadi.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 15));
		lblPersonelSoyadi.setBounds(105, 470, 121, 28);
		contentPane.add(lblPersonelSoyadi);
		
		JLabel lblCinsiyet = new JLabel("Cinsiyet");
		lblCinsiyet.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 15));
		lblCinsiyet.setBounds(389, 472, 99, 28);
		contentPane.add(lblCinsiyet);
		
		JLabel lblDogumtarihi = new JLabel("DogumTarihi");
		lblDogumtarihi.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 15));
		lblDogumtarihi.setBounds(105, 501, 99, 28);
		contentPane.add(lblDogumtarihi);
		
		JLabel lblAdres = new JLabel("Adres");
		lblAdres.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 15));
		lblAdres.setBounds(389, 501, 99, 28);
		contentPane.add(lblAdres);
		
		txt_id = new JTextField();
		txt_id.setBounds(225, 439, 135, 20);
		contentPane.add(txt_id);
		txt_id.setColumns(10);
		
		txt_adi = new JTextField();
		txt_adi.setColumns(10);
		txt_adi.setBounds(509, 439, 135, 20);
		contentPane.add(txt_adi);
		
		txt_soyadi = new JTextField();
		txt_soyadi.setColumns(10);
		txt_soyadi.setBounds(225, 470, 135, 20);
		contentPane.add(txt_soyadi);
		
		txt_dt = new JTextField();
		txt_dt.setColumns(10);
		txt_dt.setBounds(225, 507, 135, 20);
		contentPane.add(txt_dt);
		
		txt_adres = new JTextField();
		txt_adres.setColumns(10);
		txt_adres.setBounds(509, 507, 135, 20);
		contentPane.add(txt_adres);
		
		JComboBox box_cinsiyet = new JComboBox();
		box_cinsiyet.setModel(new DefaultComboBoxModel(new String[] {"C\u0130NS\u0130YET SE\u00C7\u0130N\u0130Z", "KADIN", "ERKEK"}));
		box_cinsiyet.setBounds(509, 476, 135, 20);
		contentPane.add(box_cinsiyet);
		
		
		JButton btn_ekle = new JButton("");
		btn_ekle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String PersonelID,PersonelAdi,PersonelSoyadi,DogumTarihi,Adres,sqlsorgu;
				Object Cinsiyet;
				
				PersonelID = txt_id.getText();
				PersonelAdi = txt_adi.getText();
				PersonelSoyadi = txt_soyadi.getText();
				Cinsiyet = box_cinsiyet.getSelectedItem();
				DogumTarihi = txt_dt.getText();
				Adres = txt_adres.getText();
				
				
			
				sqlsorgu = "INSERT INTO personel_bilgileri(PersonelID,PersonelAdi,PersonelSoyadi,Cinsiyet,DogumTarihi,Adres) VALUES ("+
				PersonelID +",'" + PersonelAdi + "'," + "'"+ PersonelSoyadi + "'," + "'" + Cinsiyet + "'," + "'" + DogumTarihi + "',"+ "'" + Adres + "')";	
				baglanti_personel.ekle(sqlsorgu);
				
				
			}
		});
		btn_ekle.setIcon(new ImageIcon("iconlar\\ekle.png"));
		btn_ekle.setBounds(274, 585, 85, 85);
		contentPane.add(btn_ekle);
		
		
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txt_id.setText(tablo.getValueAt(table.getSelectedRow(),0).toString());
				txt_adi.setText(tablo.getValueAt(table.getSelectedRow(),1).toString());
				txt_soyadi.setText(tablo.getValueAt(table.getSelectedRow(),2).toString());
				box_cinsiyet.setSelectedItem(tablo.getValueAt(table.getSelectedRow(),3).toString());
				txt_dt.setText(tablo.getValueAt(table.getSelectedRow(),4).toString());
				txt_adres.setText(tablo.getValueAt(table.getSelectedRow(),5).toString());
				
			}
		});
		
	
		JButton btn_sil = new JButton("");
		btn_sil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String PersonelID,sqlsorgu;
				
				PersonelID   = txt_id.getText();
				
				sqlsorgu = "DELETE  FROM personel_bilgileri WHERE  PersonelID = "+PersonelID;
				
				baglanti_personel.sil(sqlsorgu);
			}
		});
		
		btn_sil.setIcon(new ImageIcon("iconlar\\sil.jpg"));
		btn_sil.setBounds(430, 585, 85, 85);
		contentPane.add(btn_sil);
		
		
		
		
		JLabel lblPersonelEkle = new JLabel("PERSONEL EKLE\r\n");
		lblPersonelEkle.setForeground(new Color(0, 0, 255));
		lblPersonelEkle.setHorizontalAlignment(SwingConstants.CENTER);
		lblPersonelEkle.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 20));
		lblPersonelEkle.setBounds(274, 380, 209, 40);
		contentPane.add(lblPersonelEkle);
		
		
		
		JButton btn_temizle = new JButton("TEM\u0130ZLE");
		btn_temizle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txt_id.setText(null);
				txt_adi.setText(null);
				txt_soyadi.setText(null);
				box_cinsiyet.setSelectedItem("Cinsiyet Seçiniz");
				txt_dt.setText(null);
				txt_adres.setText(null);
				
			}
		});
		btn_temizle.setForeground(Color.WHITE);
		btn_temizle.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 23));
		btn_temizle.setBackground(new Color(255, 140, 0));
		btn_temizle.setBounds(315, 681, 177, 59);
		contentPane.add(btn_temizle);
		
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
		button.setBounds(10, 11, 60, 60);
		contentPane.add(button);
		
		
		
		
	}
}
