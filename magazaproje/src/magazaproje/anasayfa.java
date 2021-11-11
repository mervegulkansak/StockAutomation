package magazaproje;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class anasayfa extends JFrame {

	private JPanel contentPane;
	String hesaplar="";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					anasayfa frame = new anasayfa();
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
	public anasayfa() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("iconlar\\anasayfa.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(450, 300, 903, 685);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.textInactiveText);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel lblNewLabel = new JLabel("KULLANICI:");
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel.setBounds(10, 71, 134, 24);
		contentPane.add(lblNewLabel);
		lblNewLabel.setText("Kasiyer: "+kullanicigiris.ad);
		
		
		
		
		
		
		JButton btn_satis = new JButton("");
		btn_satis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				satis_ekrani satis = new satis_ekrani();
				satis.setVisible(true);
				setVisible(false);
			}
		});
		btn_satis.setIcon(new ImageIcon("iconlar\\satis.png"));
		btn_satis.setToolTipText("\u00DCR\u00DCN SATI\u015E");
		btn_satis.setForeground(new Color(0, 0, 128));
		btn_satis.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		btn_satis.setBackground(new Color(218, 165, 32));
		btn_satis.setBounds(125, 133, 175, 175);
		contentPane.add(btn_satis);
		
		JButton btn_iade = new JButton("");
		btn_iade.setIcon(new ImageIcon("iconlar\\uruniade .png"));
		btn_iade.setToolTipText("\u00DCR\u00DCN \u0130ADE");
		btn_iade.setForeground(new Color(0, 0, 128));
		btn_iade.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		btn_iade.setBackground(new Color(0, 139, 139));
		btn_iade.setBounds(310, 133, 135, 135);
		contentPane.add(btn_iade);
		
		JButton btn_gunluk = new JButton("");
		btn_gunluk.setIcon(new ImageIcon("iconlar\\gunluksatis.png"));
		btn_gunluk.setToolTipText("G\u00DCNL\u00DCK SATI\u015E");
		btn_gunluk.setForeground(new Color(0, 0, 128));
		btn_gunluk.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		btn_gunluk.setBackground(new Color(218, 165, 32));
		btn_gunluk.setBounds(455, 274, 130, 110);
		contentPane.add(btn_gunluk);
		
		JButton btn_urunekle = new JButton("");
		btn_urunekle.setIcon(new ImageIcon("iconlar\\uruneklesil.jpg"));
		btn_urunekle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				urunler urun= null;
				try {
					urun = new urunler();
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				urun.setVisible(true);
				setVisible(false);
			}
		});
		btn_urunekle.setToolTipText("\u00DCR\u00DCN EKLE/S\u0130L");
		btn_urunekle.setForeground(new Color(0, 0, 128));
		btn_urunekle.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		btn_urunekle.setBackground(new Color(0, 139, 139));
		btn_urunekle.setBounds(592, 133, 175, 175);
		contentPane.add(btn_urunekle);
		
		JButton btn_stok = new JButton("");
		btn_stok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				stok_urun stok = new stok_urun();
				stok.setVisible(true);
				setVisible(false);
			}
		});
		btn_stok.setIcon(new ImageIcon("iconlar\\stoktakiurun.png"));
		btn_stok.setToolTipText("STOK \u00DCR\u00DCNLER");
		btn_stok.setForeground(new Color(0, 0, 128));
		btn_stok.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		btn_stok.setBackground(SystemColor.controlShadow);
		btn_stok.setBounds(455, 133, 130, 130);
		contentPane.add(btn_stok);
		
		JButton btnPersonelKayt = new JButton("");
		btnPersonelKayt.setIcon(new ImageIcon("iconlar\\kasiyerkayit.jpg"));
		btnPersonelKayt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				kayitekrani kayit = new kayitekrani();
				kayit.setVisible(true);
				setVisible(false);
			}
		});
		btnPersonelKayt.setToolTipText("PERSONEL KAYIT");
		btnPersonelKayt.setForeground(new Color(0, 0, 128));
		btnPersonelKayt.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		btnPersonelKayt.setBackground(Color.GREEN);
		btnPersonelKayt.setBounds(125, 319, 175, 175);
		contentPane.add(btnPersonelKayt);
		
		JButton btn_sorgula = new JButton("");
		btn_sorgula.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				urunsorgula sorgu = new urunsorgula();
				sorgu.setVisible(true);
				setVisible(false);
			}
		});
		btn_sorgula.setIcon(new ImageIcon("iconlar\\sorgula.png"));
		btn_sorgula.setToolTipText("SORGULA");
		btn_sorgula.setForeground(new Color(0, 0, 128));
		btn_sorgula.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		btn_sorgula.setBackground(SystemColor.controlShadow);
		btn_sorgula.setBounds(455, 394, 130, 100);
		contentPane.add(btn_sorgula);
		
		JButton btn_prsnelbilgi = new JButton("");
		btn_prsnelbilgi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				personel bilgi =new personel();
				bilgi.setVisible(true);
				setVisible(false);
			}
		});
		btn_prsnelbilgi.setToolTipText("PERSONEL B\u0130LG\u0130LER\u0130/EKLE\r\n");
		btn_prsnelbilgi.setIcon(new ImageIcon("iconlar\\personelekle.jpg"));
		btn_prsnelbilgi.setBounds(310, 279, 135, 215);
		contentPane.add(btn_prsnelbilgi);
		
		JButton btn_musteri = new JButton("");
		btn_musteri.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				musteri musteri = new musteri();
				musteri.setVisible(true);
				setVisible(false);
			}
		});
		btn_musteri.setIcon(new ImageIcon("iconlar\\musteriekle.png"));
		btn_musteri.setToolTipText("\u00DCR\u00DCN EKLE/S\u0130L");
		btn_musteri.setForeground(new Color(0, 0, 128));
		btn_musteri.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		btn_musteri.setBackground(new Color(0, 139, 139));
		btn_musteri.setBounds(595, 319, 175, 175);
		contentPane.add(btn_musteri);
		
		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				kullanicigiris giris = new  kullanicigiris();
				giris.setVisible(true);
				setVisible(false);
			}
		});
		button.setIcon(new ImageIcon("iconlar\\cikis.png"));
		button.setBounds(803, 11, 65, 61);
		contentPane.add(button);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("iconlar\\kasiyer.jpg"));
		lblNewLabel_1.setBounds(10, 11, 65, 61);
		contentPane.add(lblNewLabel_1);
	
	}
}
