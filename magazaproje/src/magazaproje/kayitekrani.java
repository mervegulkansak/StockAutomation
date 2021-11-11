package magazaproje;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class kayitekrani extends JFrame {

	private JPanel contentPane;
	private JTextField txt_adi;
	private JTextField txt_sifree;
	private JTextField txt_id;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					kayitekrani frame = new kayitekrani();
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
	public kayitekrani() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(650, 300, 452, 468);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.textInactiveText);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblKasiyerKayt = new JLabel("");
		lblKasiyerKayt.setIcon(new ImageIcon("iconlar\\kayit.jpg"));
		lblKasiyerKayt.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 20));
		lblKasiyerKayt.setBounds(169, 38, 100, 100);
		contentPane.add(lblKasiyerKayt);
		
		JLabel label = new JLabel("KULLANICI ADI :");
		label.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 15));
		label.setBounds(10, 237, 138, 20);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("\u015E\u0130FRE :");
		label_1.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 15));
		label_1.setBounds(10, 275, 113, 33);
		contentPane.add(label_1);
		
		txt_adi = new JTextField();
		txt_adi.setColumns(10);
		txt_adi.setBounds(158, 233, 165, 33);
		contentPane.add(txt_adi);
		
		txt_sifree = new JTextField();
		txt_sifree.setColumns(10);
		txt_sifree.setBounds(158, 277, 165, 33);
		contentPane.add(txt_sifree);
		
		JButton btn_kayit = new JButton("KAYIT OL");
		btn_kayit.setForeground(new Color(255, 255, 255));
		btn_kayit.setBackground(new Color(34, 139, 34));
		btn_kayit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ResultSet rs = baglanti_kayit.yap();
				String id, PersonelAdi, Sifre,sql_sorgu1;
				
				id= txt_id.getText();
				PersonelAdi = txt_adi.getText();
				Sifre = txt_sifree.getText();
				
			sql_sorgu1 = "INSERT INTO hesaplar (id,PersonelAdi,Sifre) VALUES ("+
			id+",'"+PersonelAdi+ "'," + "'" +Sifre+ "')";	
			
			baglanti_kayit.ekle(sql_sorgu1);
			
						btn_kayit.setText("Kayýt baþarýlý");
					
				
				
			}
		});
		btn_kayit.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 20));
		btn_kayit.setBounds(158, 321, 165, 39);
		contentPane.add(btn_kayit);
		
		JLabel lblId = new JLabel("ID:");
		lblId.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 15));
		lblId.setBounds(10, 191, 113, 27);
		contentPane.add(lblId);
		
		txt_id = new JTextField();
		txt_id.setColumns(10);
		txt_id.setBounds(158, 191, 165, 33);
		contentPane.add(txt_id);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				kullanicigiris giris = new kullanicigiris();
				giris.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton.setIcon(new ImageIcon("iconlar\\giris1.jpg"));
		btnNewButton.setBounds(10, 11, 70, 70);
		contentPane.add(btnNewButton);
		
		JLabel lblGiriYap = new JLabel("G\u0130R\u0130\u015E YAP");
		lblGiriYap.setHorizontalAlignment(SwingConstants.CENTER);
		lblGiriYap.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 11));
		lblGiriYap.setBounds(10, 92, 70, 14);
		contentPane.add(lblGiriYap);
	}
}
