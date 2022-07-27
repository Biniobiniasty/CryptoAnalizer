package Main;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle.ComponentPlacement;

import Data.Storage;
import Harvaster.Harvaster;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class Main {

	private JFrame frmAnalizer;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frmAnalizer.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
		frmAnalizer.setResizable(false);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public static JComboBox comboBox = new JComboBox();
	public static JTextPane textPane = new JTextPane();
	public static JTextPane textPane_1 = new JTextPane();

	private void initialize() {
		textPane_1.setForeground(new Color(0, 204, 255));
		textPane_1.setFont(new Font("Sylfaen", Font.BOLD, 20));
		textPane_1.setBackground(new Color(0, 0, 51));
		frmAnalizer = new JFrame();
		frmAnalizer.setTitle("Analizer");
		frmAnalizer.getContentPane().setBackground(Color.DARK_GRAY);
		frmAnalizer.setBounds(100, 100, 1241, 724);
		frmAnalizer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		

		JButton btnNewButton = new JButton("Open Harvaster");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Harvaster();
				new Storage();
			}
		});
		
		
		GroupLayout groupLayout = new GroupLayout(frmAnalizer.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnNewButton, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 1206, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(textPane, GroupLayout.PREFERRED_SIZE, 585, GroupLayout.PREFERRED_SIZE)
									.addGap(18))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(comboBox, 0, 585, Short.MAX_VALUE)
									.addGap(18)))
							.addGap(18)
							.addComponent(textPane_1, GroupLayout.PREFERRED_SIZE, 585, GroupLayout.PREFERRED_SIZE)))
					.addGap(39))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnNewButton)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(textPane, GroupLayout.DEFAULT_SIZE, 582, Short.MAX_VALUE))
						.addComponent(textPane_1, GroupLayout.DEFAULT_SIZE, 622, Short.MAX_VALUE))
					.addContainerGap())
		);
		textPane.setFont(new Font("Sylfaen", Font.BOLD, 25));
		textPane.setForeground(new Color(255, 102, 51));
		textPane.setBackground(new Color(0, 0, 51));
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				ShowData.updateText();
			}
		});
		comboBox.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ShowData.updateText();
			}
		});
		frmAnalizer.getContentPane().setLayout(groupLayout);
	}
}
