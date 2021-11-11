package magazaproje;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import javax.swing.ImageIcon;

public class stok_urun extends JFrame {

	private JPanel contentPane;
private JTable table;
	
	DefaultTableModel model = new DefaultTableModel();
	
	Object[] kolonlar = {"id","Kategori","Adi","UrunAdet","Beden","Renk","Tarih","Fiyat","Durum"};
	Object[] satirlar = new Object[9];
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					stok_urun frame = new stok_urun();
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
	public stok_urun() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 631);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.textInactiveText);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
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
		btnlistele.setBackground(new Color(255, 140, 0));
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
		
		JLabel lblStoktakirnler = new JLabel("STOKTAK\u0130 \u00DCR\u00DCNLER");
		lblStoktakirnler.setForeground(new Color(0, 0, 255));
		lblStoktakirnler.setHorizontalAlignment(SwingConstants.CENTER);
		lblStoktakirnler.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 22));
		lblStoktakirnler.setBounds(212, 48, 281, 39);
		contentPane.add(lblStoktakirnler);
		
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
