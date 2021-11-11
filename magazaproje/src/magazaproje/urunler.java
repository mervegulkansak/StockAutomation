package magazaproje;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFormattedTextField;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.SystemColor;




public class urunler extends JFrame {

	private JPanel contentPane;
	private JTable table;
	
	DefaultTableModel model = new DefaultTableModel();
	
	Object[] kolonlar = {"id","Kategori","Adi","UrunAdet","Beden","Renk","Tarih","Fiyat","Durum"};
	Object[] satirlar = new Object[9];
	private JTextField txt_id;
	private JTextField txt_urunadi;
	private JTextField txt_adet;
	private JTextField txt_fyt;
	private JTextField txt_renk;
	private JTextField txt_tarih;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					urunler frame = new urunler();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
					
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws ParseException 
	 */
	public urunler() throws ParseException {
		setBackground(SystemColor.scrollbar);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1086, 795);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.textInactiveText);
		contentPane.setForeground(new Color(152, 251, 152));
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 112, 707, 220);
		contentPane.add(scrollPane);
		
		table = new JTable();
		
		model.setColumnIdentifiers(kolonlar);
		
		
		table.setBounds(200, 196, 410, 151);
		scrollPane.setViewportView(table);
		
		
		JButton btnlistele = new JButton("T\u00DCM \u00DCR\u00DCNLER\u0130 L\u0130STELE");
		btnlistele.setForeground(new Color(255, 255, 255));
		btnlistele.setBackground(new Color(34, 139, 34));
		btnlistele.addActionListener(new ActionListener() {
		
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
		btnlistele.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 19));
		btnlistele.setBounds(212, 367, 281, 59);
		contentPane.add(btnlistele);
		
		txt_id = new JTextField();
		txt_id.setHorizontalAlignment(SwingConstants.RIGHT);
		txt_id.setBounds(844, 74, 132, 26);
		contentPane.add(txt_id);
		txt_id.setColumns(10);
		
		JLabel lblrnEkle = new JLabel("\u00DCR\u00DCN EKLE/S\u0130L");
		lblrnEkle.setForeground(new Color(0, 0, 255));
		lblrnEkle.setHorizontalAlignment(SwingConstants.CENTER);
		lblrnEkle.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 18));
		lblrnEkle.setBounds(748, 37, 205, 26);
		contentPane.add(lblrnEkle);
		
		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setBounds(727, 78, 107, 22);
		contentPane.add(lblNewLabel);
		
		JLabel lblrnAd = new JLabel("\u00DCR\u00DCN ADI");
		lblrnAd.setBounds(727, 172, 107, 22);
		contentPane.add(lblrnAd);
		
		JLabel lblKategori = new JLabel("KATEGOR\u0130");
		lblKategori.setBounds(727, 124, 107, 22);
		contentPane.add(lblKategori);
		
		JLabel lblrnAdet = new JLabel("\u00DCR\u00DCN ADET");
		lblrnAdet.setBounds(727, 217, 107, 22);
		contentPane.add(lblrnAdet);
		
		JLabel lblTarih = new JLabel("TAR\u0130H");
		lblTarih.setBounds(727, 357, 107, 22);
		contentPane.add(lblTarih);
		
		JLabel lblDurum = new JLabel("DURUM");
		lblDurum.setBounds(727, 451, 107, 22);
		contentPane.add(lblDurum);
		
		JLabel lblBeden = new JLabel("BEDEN ");
		lblBeden.setBounds(727, 265, 107, 22);
		contentPane.add(lblBeden);
		
		JLabel lblRenk = new JLabel("RENK");
		lblRenk.setBounds(727, 311, 107, 22);
		contentPane.add(lblRenk);
		
		JLabel lblFiyat = new JLabel("F\u0130YAT");
		lblFiyat.setBounds(727, 402, 107, 22);
		contentPane.add(lblFiyat);
		
		
		txt_urunadi = new JTextField();
		txt_urunadi.setHorizontalAlignment(SwingConstants.RIGHT);
		txt_urunadi.setColumns(10);
		txt_urunadi.setBounds(844, 168, 132, 26);
		contentPane.add(txt_urunadi);

		JComboBox box_kategori = new JComboBox();
		box_kategori.setModel(new DefaultComboBoxModel(new String[] {"KATEGOR\u0130 SE\u00C7\u0130N\u0130Z", "ERKEK", "KADIN", "\u00C7OCUK", "SPOR", "AB\u0130YE"}));
		box_kategori.setBounds(844, 122, 132, 26);
		contentPane.add(box_kategori);
		
		
		txt_adet = new JTextField();
		txt_adet.setHorizontalAlignment(SwingConstants.RIGHT);
		txt_adet.setColumns(10);
		txt_adet.setBounds(844, 215, 132, 26);
		contentPane.add(txt_adet);
		
		JComboBox comboBox_bdn = new JComboBox();
		comboBox_bdn.setModel(new DefaultComboBoxModel(new String[] {"BEDEN SEÇÝNÝZ", "S/36", "M/38", "L/40", "XL/42","4-5YAS","6-7YAS","8-9YAS","10-11YAS"}));
		comboBox_bdn.setBounds(844, 263, 132, 26);
		contentPane.add(comboBox_bdn);
		
		txt_fyt = new JTextField();
		txt_fyt.setHorizontalAlignment(SwingConstants.RIGHT);
		txt_fyt.setColumns(10);
		txt_fyt.setBounds(844, 400, 132, 26);
		contentPane.add(txt_fyt);
		
		txt_renk = new JTextField();
		txt_renk.setHorizontalAlignment(SwingConstants.RIGHT);
		txt_renk.setColumns(10);
		txt_renk.setBounds(844, 309, 132, 26);
		contentPane.add(txt_renk);
		
		txt_tarih = new JTextField();
		txt_tarih.setBackground(new Color(255, 255, 255));
		txt_tarih.setForeground(new Color(0, 0, 0));
		txt_tarih.setHorizontalAlignment(SwingConstants.RIGHT);
		txt_tarih.setColumns(10);
		txt_tarih.setBounds(844, 358, 132, 26);
		contentPane.add(txt_tarih);
		
		JComboBox box_durum = new JComboBox();
		box_durum.setModel(new DefaultComboBoxModel(new String[] {"DURUM SE\u00C7\u0130N\u0130Z", "REYONDA", "DEPODA"}));
		box_durum.setBounds(844, 437, 132, 26);
		contentPane.add(box_durum);
		
		JButton btn_ekle = new JButton("");
		btn_ekle.setIcon(new ImageIcon("iconlar\\ekle.png"));
		btn_ekle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				String id,Adi,UrunAdet,Renk,Fiyat,Tarih,sql_sorgu;
				Object Beden,Durum,Kategori;
				id    = txt_id.getText();
				Kategori = box_kategori.getSelectedItem();
				Adi    = txt_urunadi.getText();
				UrunAdet  = txt_adet.getText();
				Beden = comboBox_bdn.getSelectedItem();
				Renk  = txt_renk.getText();
				Tarih = txt_tarih.getText();
				Fiyat = txt_fyt.getText();
				Durum = box_durum.getSelectedItem();
			
				sql_sorgu = "INSERT INTO urunler(id,Kategori,Adi,UrunAdet,Beden,Renk,Tarih,Fiyat,Durum) VALUES ("+
				id+",'" + Kategori + "'," +"'"+ Adi + "'," + "'" + UrunAdet + "'," + "'" + Beden + "',"	+ "'" + Renk + "'," + "'" + Tarih + "'," + "'" + Fiyat + "'," + "'" + Durum + "')";	
				baglanti.ekle(sql_sorgu);
			
			
			}
			
		});
		btn_ekle.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 14));
		btn_ekle.setBounds(727, 505, 85, 85);
		contentPane.add(btn_ekle);
		
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txt_id.setText(model.getValueAt(table.getSelectedRow(),0).toString());
				box_kategori.setToolTipText(model.getValueAt(table.getSelectedRow(),1).toString());
				txt_urunadi.setText(model.getValueAt(table.getSelectedRow(),2).toString());
				txt_adet.setText(model.getValueAt(table.getSelectedRow(),3).toString());
				comboBox_bdn.setSelectedItem(model.getValueAt(table.getSelectedRow(),4).toString());
				txt_renk.setText(model.getValueAt(table.getSelectedRow(),5).toString());
				txt_tarih.setText(model.getValueAt(table.getSelectedRow(),6).toString());
				txt_fyt.setText(model.getValueAt(table.getSelectedRow(),7).toString());
				box_durum.setToolTipText(model.getValueAt(table.getSelectedRow(),8).toString());
			}
		});
		
		
		JButton btnUpdate = new JButton("");
		btnUpdate.setIcon(new ImageIcon("iconlar\\update.png"));
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id,Adi,UrunAdet,Renk,Tarih,Fiyat,sql_sorgu;
				Object Beden,Durum,Kategori;
				id    = txt_id.getText();
				Kategori = box_kategori.getSelectedItem();
				Adi    = txt_urunadi.getText();
				UrunAdet  = txt_adet.getText();
				Beden = comboBox_bdn.getSelectedItem();
				Renk  = txt_renk.getText();
				Tarih = txt_tarih.getText();
				Fiyat = txt_fyt.getText();
				Durum = box_durum.getSelectedItem();
				
				sql_sorgu= "UPDATE urunler SET id="+id+"," +"Kategori='"+Kategori+"',Adi='"+ Adi + "',UrunAdet='" + UrunAdet + "',Beden='" + Beden + "',Renk='"+ Renk + "',Tarih='" + Tarih + "',Fiyat='" + Fiyat + "',Durum='" + Durum + "'WHERE id ="+id;
						
				
				baglanti.update(sql_sorgu);
						
			}
		});
		btnUpdate.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 14));
		btnUpdate.setBounds(959, 505, 85, 85);
		contentPane.add(btnUpdate);
		
		
		
		
		JButton btnSil = new JButton("");
		btnSil.setIcon(new ImageIcon("iconlar\\sil.jpg"));
		btnSil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id,sql_sorgu;
				
				id    = txt_id.getText();
				
				sql_sorgu = "DELETE  FROM urunler WHERE  id = "+id;
				
				baglanti.sil(sql_sorgu);
			}
		});
		btnSil.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 14));
		btnSil.setBounds(844, 505, 85, 85);
		contentPane.add(btnSil);
		
		
		
		JButton btnTemizle = new JButton("TEM\u0130ZLE");
		btnTemizle.setForeground(new Color(255, 255, 255));
		btnTemizle.setBackground(new Color(255, 140, 0));
		btnTemizle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txt_id.setText(null);
				box_kategori.setSelectedItem("KATEGORÝ SEÇÝNÝZ");
				txt_urunadi.setText(null);
				txt_adet.setText(null);
				comboBox_bdn.setSelectedItem("BEDEN SEÇÝNÝZ");
				txt_renk.setText(null);
				txt_tarih.setText(null);
				txt_fyt.setText(null);
				box_durum.setSelectedItem("DURUM SEÇÝNÝZ");
			}
		});
		btnTemizle.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 23));
		btnTemizle.setBounds(799, 611, 177, 59);
		contentPane.add(btnTemizle);
		
		JButton btn_anasayfa = new JButton("");
		btn_anasayfa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				anasayfa ana = new anasayfa();
				ana.setVisible(true);
				setVisible(false);
			}
		});
		btn_anasayfa.setIcon(new ImageIcon("iconlar\\anasayfa.jpg"));
		btn_anasayfa.setBackground(SystemColor.textInactiveText);
		btn_anasayfa.setBounds(10, 25, 60, 60);
		contentPane.add(btn_anasayfa);
		
		
		
		
		
		
	
		
		
		
		
		
		
	}
}




































