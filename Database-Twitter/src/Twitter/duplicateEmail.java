package Twitter;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;

public class duplicateEmail extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;


	public duplicateEmail() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Duplicate Email");
		lblNewLabel.setBounds(74, 63, 224, 129);
		contentPane.add(lblNewLabel);
		
		JButton backBtn = new JButton("Back");
		backBtn.setBounds(74, 172, 91, 23);
		contentPane.add(backBtn);
		backBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
	}

}
