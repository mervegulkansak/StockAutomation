package magazaproje;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.SystemColor;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class musteri extends JFrame {

	private JPanel contentPane;
	private JTable table;
    DefaultTableModel tablo = new DefaultTableModel();
	
	Object[] kolonlar = {"id","Adi","Soyadi","Telefon","Adres",	"Cinsiyet"};
	Object[] satirlar = new Object[6];
	private JTextField txt_id;
	private JTextField txt_adi;
	private JTextField txt_telefon;
	private JTextField txt_adres;
	private JTextField txt_soyadi;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					musteri frame = new musteri();
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
	public musteri() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 689, 762);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.textInactiveText);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(43, 141, 555, 168);
		contentPane.add(scrollPane);
		
		table = new JTable();
		tablo.setColumnIdentifiers(kolonlar);
		
		table.setBounds(186, 185, 204, 115);
		scrollPane.setViewportView(table);
		
		JLabel lblMteriEklesil = new JLabel("M\u00DC\u015ETER\u0130 EKLE/S\u0130L");
		lblMteriEklesil.setForeground(Color.ORANGE);
		lblMteriEklesil.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 22));
		lblMteriEklesil.setBounds(199, 54, 234, 37);
		contentPane.add(lblMteriEklesil);
		
		JLabel lblNewLabel = new JLabel("ID :");
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel.setBounds(209, 378, 60, 21);
		contentPane.add(lblNewLabel);
		
		JLabel lblAdi = new JLabel("ADI :\r\n");
		lblAdi.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 14));
		lblAdi.setBounds(209, 419, 60, 21);
		contentPane.add(lblAdi);
		
		JLabel lblSoyad = new JLabel("SOYADI :");
		lblSoyad.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 14));
		lblSoyad.setBounds(209, 459, 79, 21);
		contentPane.add(lblSoyad);
		
		JLabel lblAdres = new JLabel("ADRES :");
		lblAdres.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 14));
		lblAdres.setBounds(209, 491, 70, 21);
		contentPane.add(lblAdres);
		
		JLabel lblTelefon = new JLabel("TELEFON :\r\n");
		lblTelefon.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 14));
		lblTelefon.setBounds(209, 532, 79, 21);
		contentPane.add(lblTelefon);
		
		JLabel lblCinsiyet = new JLabel("C\u0130NS\u0130YET :\r\n");
		lblCinsiyet.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 14));
		lblCinsiyet.setBounds(209, 568, 96, 21);
		contentPane.add(lblCinsiyet);
		
		txt_id = new JTextField();
		txt_id.setBounds(299, 378, 135, 21);
		contentPane.add(txt_id);
		txt_id.setColumns(10);
		
		txt_adi = new JTextField();
		txt_adi.setColumns(10);
		txt_adi.setBounds(299, 419, 135, 21);
		contentPane.add(txt_adi);
		
		txt_soyadi = new JTextField();
		txt_soyadi.setColumns(10);
		txt_soyadi.setBounds(299, 461, 135, 21);
		contentPane.add(txt_soyadi);
		
		txt_telefon = new JTextField();
		txt_telefon.setColumns(10);
		txt_telefon.setBounds(299, 534, 135, 21);
		contentPane.add(txt_telefon);
		
		txt_adres = new JTextField();
		txt_adres.setColumns(10);
		txt_adres.setBounds(299, 493, 135, 21);
		contentPane.add(txt_adres);
		
		JComboBox box_cinsiyet = new JComboBox();
		box_cinsiyet.setModel(new DefaultComboBoxModel(new String[] {"C\u0130NS\u0130YET SE\u00C7\u0130N\u0130Z", "KADIN", "ERKEK"}));
		box_cinsiyet.setBounds(299, 569, 135, 20);
		contentPane.add(box_cinsiyet);
		
		
		JButton btnTmMterileriListele = new JButton("T\u00DCM M\u00DC\u015ETER\u0130LER\u0130 L\u0130STELE");
		btnTmMterileriListele.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)  {
				tablo.setRowCount(0);
				ResultSet rs = baglanti_musteri.yap();	
				
			
				try {
					while(rs.next()) {
						satirlar[0]= rs.getString("id");
						satirlar[1]= rs.getString("Adi");
						satirlar[2]= rs.getString("Soyadi");
						satirlar[3]= rs.getString("Telefon");
						satirlar[4]= rs.getString("Adres");
						satirlar[5]= rs.getString("Cinsiyet");
						tablo.addRow(satirlar);
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				table.setModel(tablo);
			}
		});
		btnTmMterileriListele.setForeground(Color.WHITE);
		btnTmMterileriListele.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 15));
		btnTmMterileriListele.setBackground(new Color(34, 139, 34));
		btnTmMterileriListele.setBounds(199, 321, 272, 46);
		contentPane.add(btnTmMterileriListele);
		
		
		
		JButton btn_ekle = new JButton("");
		btn_ekle.setIcon(new ImageIcon("iconlar\\ekle.png"));
		btn_ekle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String id,Adi,Soyadi,Telefon,Adres,sql_sorgu;
				Object Cinsiyet;
				
				id    = txt_id.getText();
				Adi = txt_adi.getText();
				Soyadi    = txt_soyadi.getText();
				Telefon  = txt_telefon.getText();
				Adres = txt_adres.getText();
				Cinsiyet = box_cinsiyet.getSelectedItem();
			
				sql_sorgu = "INSERT INTO musteri(id,Adi,Soyadi,Telefon,Adres,Cinsiyet) VALUES ("+
				id+",'" + Adi + "'," +"'"+ Soyadi + "'," + "'" + Telefon + "'," + "'"+ Adres + "'," + "'" + Cinsiyet + "')";	
				baglanti_musteri.ekle(sql_sorgu);
			
			}
		});
		btn_ekle.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 14));
		btn_ekle.setBounds(179, 616, 85, 85);
		contentPane.add(btn_ekle);
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txt_id.setText(tablo.getValueAt(table.getSelectedRow(),0).toString());
				txt_adi.setText(tablo.getValueAt(table.getSelectedRow(),1).toString());
				txt_soyadi.setText(tablo.getValueAt(table.getSelectedRow(),2).toString());
				txt_telefon.setText(tablo.getValueAt(table.getSelectedRow(),3).toString());
				txt_adres.setText(tablo.getValueAt(table.getSelectedRow(),4).toString());
				box_cinsiyet.setToolTipText(tablo.getValueAt(table.getSelectedRow(),5).toString());
			}
		});
		
		
		JButton btn_sil = new JButton("");
		btn_sil.setIcon(new ImageIcon("iconlar\\sil.jpg"));
		btn_sil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id,sql_sorgu;
				
				id    = txt_id.getText();
				
				sql_sorgu = "DELETE  FROM musteri WHERE  id = "+id;
				
				baglanti_musteri.sil(sql_sorgu);
			}
		});
		btn_sil.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 14));
		btn_sil.setBounds(296, 616, 85, 85);
		contentPane.add(btn_sil);
		
		
		
		JButton btn_update = new JButton("");
		btn_update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id,Adi,Soyadi,Telefon,Adres,sql_sorgu;
				Object Cinsiyet;
				id    = txt_id.getText();
				Adi = txt_adi.getText();
				Soyadi    = txt_soyadi.getText();
				Telefon  = txt_telefon.getText();
				Adres = txt_adres.getText();
				Cinsiyet = box_cinsiyet.getSelectedItem();
				
				sql_sorgu= "UPDATE musteri SET id="+id+"," +"Adi='"+Adi+"',Soyadi='"+ Soyadi + "',Telefon='" + Telefon +  "',Adres='" + Adres +  "',Cinsiyet='" + Cinsiyet + "'WHERE id ="+id;
						
				
				baglanti_musteri.update(sql_sorgu);
			}
		});
		
		btn_update.setIcon(new ImageIcon("iconlar\\update.png"));
		btn_update.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 14));
		btn_update.setBounds(411, 616, 85, 85);
		contentPane.add(btn_update);
		
		JButton btn_anasayfa = new JButton("");
		btn_anasayfa.setIcon(new ImageIcon("iconlar\\anasayfa.jpg"));
		btn_anasayfa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				anasayfa ana = new anasayfa();
				ana.setVisible(true);
				setVisible(false);
			}
		});
		btn_anasayfa.setBackground(SystemColor.textInactiveText);
		btn_anasayfa.setBounds(10, 11, 60, 60);
		contentPane.add(btn_anasayfa);
		
		
		
		
	}
}
