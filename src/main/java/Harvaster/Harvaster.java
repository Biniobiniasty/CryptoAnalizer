package Harvaster;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.LayoutStyle.ComponentPlacement;

import Observer.ObThread;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Harvaster {

	public static int frequency;

	private static final JFrame frmHarvaster = new JFrame();
	private static boolean inicialize = false;

	/**
	 * Launch the application.
	 */
	public void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Harvaster window = new Harvaster();
					window.frmHarvaster.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Harvaster() {
		if (!inicialize) {
		initialize();
		inicialize = true;
		frmHarvaster.getContentPane().setBackground(new Color(0, 0, 51));
		frmHarvaster.setTitle("Harvaster");
		frmHarvaster.show(true);
		frmHarvaster.setResizable(false);
		 }
		frequency = 60;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		frmHarvaster.setBounds(100, 100, 487, 609);
		frmHarvaster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JProgressBar progressBar = new JProgressBar();

		JProgressBar progressBar_1 = new JProgressBar();

		JProgressBar progressBar_1_1 = new JProgressBar();

		JProgressBar progressBar_1_1_1 = new JProgressBar();

		JProgressBar progressBar_1_1_1_1 = new JProgressBar();

		JProgressBar progressBar_1_1_2 = new JProgressBar();

		JProgressBar progressBar_1_2 = new JProgressBar();

		JProgressBar progressBar_2 = new JProgressBar();

		JLabel lblNewLabel = new JLabel("-----");
		lblNewLabel.setForeground(new Color(0, 204, 255));

		JLabel lblNewLabel_1 = new JLabel("-----");
		lblNewLabel_1.setForeground(new Color(0, 204, 255));

		JLabel lblNewLabel_2 = new JLabel("-----");
		lblNewLabel_2.setForeground(new Color(0, 204, 255));

		JLabel lblNewLabel_3 = new JLabel("-----");
		lblNewLabel_3.setForeground(new Color(0, 204, 255));

		JLabel lblNewLabel_4 = new JLabel("-----");
		lblNewLabel_4.setForeground(new Color(0, 204, 255));

		JLabel lblNewLabel_5 = new JLabel("-----");
		lblNewLabel_5.setForeground(new Color(0, 204, 255));

		JLabel lblNewLabel_6 = new JLabel("-----");
		lblNewLabel_6.setForeground(new Color(0, 204, 255));

		JLabel lblNewLabel_7 = new JLabel("-----");
		lblNewLabel_7.setForeground(new Color(0, 204, 255));
		JComboBox comboBox = new JComboBox();
		JButton btnNewButton = new JButton("START");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				ObThread btc = new ObThread();
				if (btnNewButton.getText() == "START") {
					btc.startWork(() -> {
						try {
							Parser.parse1();
						} catch (IOException e1) {
							e1.printStackTrace();
						}
					}, progressBar, lblNewLabel, comboBox);
					btc.startWork(() -> {
						try {
							Parser.parse2();
						} catch (IOException e1) {
							e1.printStackTrace();
						}
					}, progressBar_1, lblNewLabel_1, comboBox);
					btc.startWork(Parser::parse3, progressBar_1_1, lblNewLabel_2, comboBox);
					btc.startWork(Parser::parse4, progressBar_1_1_1, lblNewLabel_3, comboBox);
					btc.startWork(Parser::parse5, progressBar_1_1_1_1, lblNewLabel_4, comboBox);
					btc.startWork(Parser::parse6, progressBar_1_1_2, lblNewLabel_5, comboBox);
					btc.startWork(Parser::parse7, progressBar_1_2, lblNewLabel_6, comboBox);
					btc.startWork(Parser::parse8, progressBar_2, lblNewLabel_7, comboBox);
					btnNewButton.setVisible(false);
				}
				;
			}
		});
		
		
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"25", "30", "45", "60", "80", "100", "120", "150", "200", "250", "300", "500", "750", "1000"}));
		comboBox.setSelectedIndex(2);
		
		JLabel lblNewLabel_1_1 = new JLabel("Seconds to download");
		lblNewLabel_1_1.setForeground(new Color(0, 204, 255));
		GroupLayout groupLayout = new GroupLayout(frmHarvaster.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(6)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel_2)
							.addContainerGap())
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(lblNewLabel_4)
								.addContainerGap())
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblNewLabel_5)
									.addContainerGap())
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblNewLabel_3)
									.addContainerGap())
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(lblNewLabel)
										.addGroup(groupLayout.createSequentialGroup()
											.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
												.addComponent(progressBar, GroupLayout.PREFERRED_SIZE, 457, GroupLayout.PREFERRED_SIZE)
												.addComponent(progressBar_1, GroupLayout.PREFERRED_SIZE, 457, GroupLayout.PREFERRED_SIZE)
												.addComponent(progressBar_1_1, GroupLayout.PREFERRED_SIZE, 457, GroupLayout.PREFERRED_SIZE)
												.addComponent(progressBar_1_1_1, GroupLayout.PREFERRED_SIZE, 457, GroupLayout.PREFERRED_SIZE)
												.addComponent(progressBar_2, GroupLayout.PREFERRED_SIZE, 457, GroupLayout.PREFERRED_SIZE)
												.addComponent(progressBar_1_2, GroupLayout.PREFERRED_SIZE, 457, GroupLayout.PREFERRED_SIZE)
												.addComponent(progressBar_1_1_2, GroupLayout.PREFERRED_SIZE, 457, GroupLayout.PREFERRED_SIZE)
												.addComponent(progressBar_1_1_1_1, GroupLayout.PREFERRED_SIZE, 457, GroupLayout.PREFERRED_SIZE)
												.addGroup(groupLayout.createSequentialGroup()
													.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
														.addComponent(lblNewLabel_6)
														.addComponent(lblNewLabel_1)
														.addComponent(lblNewLabel_7))
													.addPreferredGap(ComponentPlacement.RELATED, 304, Short.MAX_VALUE)
													.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
														.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)
														.addGroup(groupLayout.createSequentialGroup()
															.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
																.addComponent(lblNewLabel_1_1)
																.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE))
															.addGap(15)))))
											.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
									.addGap(8))))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(15, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(progressBar, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
							.addGap(3)
							.addComponent(progressBar_1, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
							.addGap(3)
							.addComponent(progressBar_1_1, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
							.addGap(3)
							.addComponent(progressBar_1_1_1, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
							.addGap(3)
							.addComponent(progressBar_2, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
							.addGap(3)
							.addComponent(progressBar_1_2, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
							.addGap(3)
							.addComponent(progressBar_1_1_2, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
							.addGap(3)
							.addComponent(progressBar_1_1_1_1, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblNewLabel)
									.addGap(20))
								.addComponent(lblNewLabel_1_1))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(20)
									.addComponent(lblNewLabel_2)
									.addGap(11)
									.addComponent(lblNewLabel_3))
								.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblNewLabel_4)
							.addGap(18)
							.addComponent(lblNewLabel_5)
							.addGap(12)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblNewLabel_6)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblNewLabel_7))
								.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE))
							.addGap(4))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel_1)
							.addGap(172))))
		);
		frmHarvaster.getContentPane().setLayout(groupLayout);
	}
}
