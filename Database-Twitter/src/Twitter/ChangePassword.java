package Twitter;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JPasswordField;

public class ChangePassword extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField id_textField;
	private JPasswordField current_password_pwField;
	private JPasswordField new_password_pwField;

	
	public ChangePassword() {
		super("Change Password");
		setSize(350, 500);	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		// Change Password
		
		JLabel change_password = new JLabel("Change Password");
		
		// ID
		
		JLabel id_label = new JLabel("ID");
		
		id_textField = new JTextField();
		id_textField.setColumns(10);
		
		// Current password
		
		JLabel current_password = new JLabel("Current password");
		
		current_password_pwField = new JPasswordField();
		
		// New password
		
		JLabel new_password = new JLabel("New password");
		
		new_password_pwField = new JPasswordField();
		
		JButton btnNewButton = new JButton("Apply");
		
		// 버튼 눌렀을 때 -> ActionListener 달아야 
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(108)
							.addComponent(change_password))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(41)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(id_textField, GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
								.addComponent(id_label)
								.addComponent(current_password)
								.addComponent(new_password)
								.addComponent(current_password_pwField)
								.addComponent(new_password_pwField)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(115)
							.addComponent(btnNewButton)))
					.addContainerGap(61, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(47)
					.addComponent(change_password)
					.addGap(45)
					.addComponent(id_label)
					.addGap(18)
					.addComponent(id_textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(47)
					.addComponent(current_password)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(current_password_pwField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(42)
					.addComponent(new_password)
					.addGap(18)
					.addComponent(new_password_pwField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
					.addComponent(btnNewButton)
					.addGap(27))
		);
		contentPane.setLayout(gl_contentPane);
	}

}
