package magazaproje;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.PasswordView;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.accessibility.AccessibleContext;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.SystemColor;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Toolkit;

public class kullanicigiris extends JFrame {

	private JPanel contentPane;
	static String ad;
	static String sifre;
	private JTextField txt_ad;
	private JTextField txt_sifre;

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					kullanicigiris frame = new kullanicigiris();
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
	public kullanicigiris() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("iconlar\\login 2.jpg"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(650, 300, 448, 410);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.textInactiveText);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("iconlar\\giris.jpg"));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		label.setBounds(164, 38, 100, 100);
		contentPane.add(label);
		
		JButton btn_giris = new JButton("G\u0130R\u0130\u015E");
		btn_giris.setBackground(new Color(50, 205, 50));
		btn_giris.setForeground(new Color(255, 255, 255));
		btn_giris.addActionListener(new ActionListener() {
	
			public void actionPerformed(ActionEvent e) {
				ResultSet rs = baglanti.yap();
				
				ad= txt_ad.getText();
				sifre= txt_sifre.getText();
			
				
				String sql_sorgu= "SELECT count(id) as giris FROM hesaplar WHERE PersonelAdi='"+ad+"' and Sifre='"+sifre+"'" ;     
				
				rs=baglanti.sorgula(sql_sorgu);
				
				try {
					while(rs.next()){
						if(rs.getInt("giris")==1) {
							anasayfa ana = new anasayfa();
							ana.setVisible(true);
							setVisible(false);
						}else {
							hatalýgiris hata = new hatalýgiris();
							hata.setVisible(true);
							setVisible(true);
						
						}
					
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			
				
			}
		});
		btn_giris.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		btn_giris.setBounds(177, 267, 165, 33);
		contentPane.add(btn_giris);
		
		JButton btnKaytOl = new JButton("KAYIT OL");
		btnKaytOl.setForeground(new Color(255, 255, 255));
		btnKaytOl.setBackground(new Color(255, 182, 193));
		btnKaytOl.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				kayitekrani kayit = new kayitekrani();
				kayit.setVisible(true);
				setVisible(false);
			}
		});
		btnKaytOl.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		btnKaytOl.setBounds(177, 311, 165, 33);
		contentPane.add(btnKaytOl);
		
		JLabel label_3 = new JLabel("KULLANICI ADI :");
		label_3.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 15));
		label_3.setBounds(28, 174, 138, 20);
		contentPane.add(label_3);
		
		txt_ad = new JTextField();
		txt_ad.setColumns(10);
		txt_ad.setBounds(176, 170, 165, 33);
		contentPane.add(txt_ad);
		
		JLabel label_4 = new JLabel("\u015E\u0130FRE :");
		label_4.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 15));
		label_4.setBounds(28, 212, 113, 33);
		contentPane.add(label_4);
		
		txt_sifre = new JTextField();
		txt_sifre.setColumns(10);
		txt_sifre.setBounds(176, 214, 165, 33);
		contentPane.add(txt_sifre);
		
		
	}
}
