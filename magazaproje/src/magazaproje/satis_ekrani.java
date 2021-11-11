package magazaproje;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class satis_ekrani extends JFrame {

	private JPanel contentPane;
	private JTable table;
	DefaultTableModel model = new DefaultTableModel();
	
	Object[] kolonlar = {"id","Kategori","Adi","UrunAdet","Beden","Renk","Tarih","Fiyat","Durum"};
	Object[] satirlar = new Object[9];
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					satis_ekrani frame = new satis_ekrani();
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
	public satis_ekrani() {
		setBackground(SystemColor.textInactiveText);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 778, 673);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.textInactiveText);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u00DCR\u00DCN SATI\u015E");
		lblNewLabel.setForeground(Color.ORANGE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 22));
		lblNewLabel.setBounds(197, 21, 329, 48);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(74, 77, 626, 169);
		contentPane.add(scrollPane);
		
		table = new JTable();
		
		model.setColumnIdentifiers(kolonlar);
		
		table.setBounds(197, 262, 356, 131);
		scrollPane.setViewportView(table);
		
		JLabel label = new JLabel("ID");
		label.setBounds(103, 295, 107, 22);
		contentPane.add(label);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.RIGHT);
		textField.setColumns(10);
		textField.setBounds(220, 291, 132, 26);
		contentPane.add(textField);
		
		JLabel label_1 = new JLabel("KATEGOR\u0130");
		label_1.setBounds(103, 341, 107, 22);
		contentPane.add(label_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(220, 339, 132, 26);
		contentPane.add(comboBox);
		
		JLabel label_2 = new JLabel("\u00DCR\u00DCN ADI");
		label_2.setBounds(103, 389, 107, 22);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("\u00DCR\u00DCN ADET");
		label_3.setBounds(103, 434, 107, 22);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("BEDEN ");
		label_4.setBounds(103, 482, 107, 22);
		contentPane.add(label_4);
		
		JLabel label_5 = new JLabel("RENK");
		label_5.setBounds(421, 297, 107, 22);
		contentPane.add(label_5);
		
		JLabel label_6 = new JLabel("TAR\u0130H");
		label_6.setBounds(421, 343, 107, 22);
		contentPane.add(label_6);
		
		JLabel label_7 = new JLabel("F\u0130YAT");
		label_7.setBounds(421, 388, 107, 22);
		contentPane.add(label_7);
		
		JLabel label_8 = new JLabel("DURUM");
		label_8.setBounds(421, 437, 107, 22);
		contentPane.add(label_8);
		
		textField_1 = new JTextField();
		textField_1.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_1.setColumns(10);
		textField_1.setBounds(220, 385, 132, 26);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_2.setColumns(10);
		textField_2.setBounds(220, 432, 132, 26);
		contentPane.add(textField_2);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(220, 480, 132, 26);
		contentPane.add(comboBox_1);
		
		textField_3 = new JTextField();
		textField_3.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_3.setColumns(10);
		textField_3.setBounds(538, 295, 132, 26);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_4.setForeground(Color.BLACK);
		textField_4.setColumns(10);
		textField_4.setBackground(Color.WHITE);
		textField_4.setBounds(538, 344, 132, 26);
		contentPane.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_5.setColumns(10);
		textField_5.setBounds(538, 386, 132, 26);
		contentPane.add(textField_5);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(538, 423, 132, 26);
		contentPane.add(comboBox_2);
		
		JButton btnNewButton = new JButton("\u00DCR\u00DCNLER\u0130 G\u00D6STER");
		btnNewButton.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 15));
		btnNewButton.setBounds(103, 517, 249, 37);
		contentPane.add(btnNewButton);
		
		JButton btnSatYap = new JButton("");
		btnSatYap.setIcon(new ImageIcon("iconlar\\satis.jpg"));
		btnSatYap.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 15));
		btnSatYap.setBounds(540, 482, 130, 100);
		contentPane.add(btnSatYap);
		
		JButton button = new JButton("");
		button.setIcon(new ImageIcon("iconlar\\anasayfa.jpg"));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				anasayfa ana = new anasayfa();
				ana.setVisible(true);
				setVisible(false);
			}
		});
		button.setBackground(SystemColor.textInactiveText);
		button.setBounds(10, 11, 60, 60);
		contentPane.add(button);
	}
}
