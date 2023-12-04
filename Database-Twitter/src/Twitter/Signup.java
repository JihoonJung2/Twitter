package Twitter;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;

public class Signup extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField nickname_textField;
	private JTextField email_textField;
	private JTextField number_textField;
	private JTextField birth_textField;
	private JTextField password_textField;

	public Signup() {
		super("Sign up");
		setTitle("Sign up");
		setSize(350, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);

		// password

		JLabel pw_label = new JLabel("password");

		// nickname

		JLabel nickname_label = new JLabel("nickname");

		nickname_textField = new JTextField();
		nickname_textField.setColumns(10);

		// email

		JLabel email_label = new JLabel("email");

		email_textField = new JTextField();
		email_textField.setColumns(10);

		// phone number

		JLabel number_label = new JLabel("phone number");

		number_textField = new JTextField();
		number_textField.setText("01012345678");
		number_textField.setColumns(10);

		// birth

		JLabel birth_label = new JLabel("birth");

		birth_textField = new JTextField();
		birth_textField.setText("20030101");
		birth_textField.setColumns(10);

		// gender

		JLabel gender_label = new JLabel("gender");

		final JComboBox gender_comboBox = new JComboBox();
		gender_comboBox.setModel(new DefaultComboBoxModel(new String[] { "Male", "Female" }));

		// sign up button

		JButton signup_button = new JButton("Sign up");
		signup_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				ConnectingDB dbConnector = new ConnectingDB();
				try {
					if (updateUser(dbConnector.getConnection(), password_textField.getText(),
							nickname_textField.getText(), email_textField.getText(), number_textField.getText(),
							birth_textField.getText(), gender_comboBox.getSelectedItem().toString())) {

						Signin signin = new Signin();
						setVisible(false);
						signin.setLocationRelativeTo(null);
						signin.setVisible(true);
					}

				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});

		JButton BackBtn = new JButton("Back");
		BackBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				setVisible(false);
				Signin Signin = new Signin();
				Signin.setLocationRelativeTo(null);
				Signin.setVisible(true);
			}
		});

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel
				.setIcon(new ImageIcon("C:\\Users\\82107\\eclipse-workspace\\Database-Twitter\\image\\bluebird2.png"));

		password_textField = new JTextField();
		password_textField.setColumns(10);

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup().addGap(37)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING).addGroup(gl_contentPane
						.createSequentialGroup()
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING).addGroup(gl_contentPane
								.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
										.addComponent(number_label, GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
										.addComponent(birth_label, GroupLayout.PREFERRED_SIZE, 94,
												GroupLayout.PREFERRED_SIZE)
										.addGroup(gl_contentPane.createSequentialGroup()
												.addComponent(nickname_label, GroupLayout.DEFAULT_SIZE, 61,
														Short.MAX_VALUE)
												.addPreferredGap(ComponentPlacement.RELATED))
										.addGroup(gl_contentPane.createSequentialGroup()
												.addComponent(pw_label, GroupLayout.DEFAULT_SIZE,
														GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addPreferredGap(ComponentPlacement.RELATED))
										.addGroup(gl_contentPane.createSequentialGroup()
												.addComponent(email_label, GroupLayout.PREFERRED_SIZE, 41,
														GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED)))
								.addComponent(gender_label, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup().addComponent(BackBtn)
										.addPreferredGap(ComponentPlacement.RELATED)))
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING).addGroup(gl_contentPane
								.createSequentialGroup().addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(birth_textField, Alignment.LEADING)
										.addComponent(gender_comboBox, Alignment.LEADING, 0, GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addComponent(signup_button).addComponent(number_textField)
										.addComponent(nickname_textField)))
								.addGroup(Alignment.LEADING,
										gl_contentPane.createSequentialGroup()
												.addPreferredGap(ComponentPlacement.RELATED)
												.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
														.addComponent(password_textField, Alignment.TRAILING,
																GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
														.addComponent(email_textField, 108, 108, 108))))
						.addGap(81))
						.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
								.addGap(146)))));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup()
				.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE).addGap(57)
				.addGroup(gl_contentPane
						.createParallelGroup(Alignment.BASELINE).addComponent(email_label).addComponent(email_textField,
								GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(30)
				.addGroup(gl_contentPane
						.createParallelGroup(Alignment.BASELINE).addComponent(pw_label).addComponent(password_textField,
								GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(33)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING).addComponent(nickname_label)
						.addComponent(nickname_textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
				.addGap(47)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(number_label)
						.addComponent(number_textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
				.addGap(28)
				.addGroup(gl_contentPane
						.createParallelGroup(Alignment.BASELINE).addComponent(birth_label).addComponent(birth_textField,
								GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(28)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(gender_comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(gender_label))
				.addGap(50).addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(BackBtn)
						.addComponent(signup_button))
				.addContainerGap()));
		contentPane.setLayout(gl_contentPane);
	}

	private static boolean updateUser(Connection con, String password, String nn, String email, String phoneNumber,
			String birth, String gender) {

		if (EmailExistsInTable(con, email)) {
			duplicateEmail error = new duplicateEmail();
			error.setLocationRelativeTo(null);
			error.setVisible(true);
			return false;
		} else {
			String randomId = generateRandomId(con);
			String insertQuery = "INSERT INTO user ( id, email, password, nickname, phone_number, birth_date, gender) VALUES (?, ?, ?, ?, ?, ?, ?)";
			try {
				PreparedStatement state = con.prepareStatement(insertQuery);

				state.setString(1, randomId);
				state.setString(2, email);
				state.setString(3, password);
				state.setString(4, nn);
				state.setString(5, phoneNumber);
				state.setString(6, birth);
				state.setString(7, gender);

				int rowsAffected = state.executeUpdate();

				if (rowsAffected > 0) {
					System.out.println("User ID saved to the database.");
					return true;

				} else {
					System.out.println("Failed to save user ID to the database.");
					return false;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	public static String generateRandomId(Connection con) {
		while (true) {
			// 랜덤한 ID 생성
			long timestamp = System.currentTimeMillis();
			int randomInt = (int) (Math.random() * Integer.MAX_VALUE);
			long result = timestamp + randomInt;
			String randomId = Long.toString(result);

			// 생성한 ID가 특정 테이블에 이미 존재하는지 확인
			if (!idExistsInTable(con, randomId)) {
				return randomId;
			}
		}
	}

	private static boolean idExistsInTable(Connection con, String id) {
		// 특정 테이블에서 ID가 존재하는지 확인하는 로직
		String sql = "SELECT COUNT(*) FROM user WHERE id = ?";
		try (PreparedStatement statement = con.prepareStatement(sql)) {
			statement.setString(1, id);
			try (ResultSet resultSet = statement.executeQuery()) {
				if (resultSet.next()) {
					int count = resultSet.getInt(1);
					return count > 0;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	private static boolean EmailExistsInTable(Connection con, String email) {
		// 특정 테이블에서 ID가 존재하는지 확인하는 로직
		String sql = "SELECT COUNT(*) FROM user WHERE email = ?";
		try (PreparedStatement statement = con.prepareStatement(sql)) {
			statement.setString(1, email);
			try (ResultSet resultSet = statement.executeQuery()) {
				if (resultSet.next()) {
					int count = resultSet.getInt(1);
					return count > 0;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}
