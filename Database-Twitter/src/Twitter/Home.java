package Twitter;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Twitter.Profile.CircularLabel;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextField;

public class Home extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField dateTextField;
	private JTextField messageTextField;

	@SuppressWarnings("null")
	public Home() {
		super("Home");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(872, 500);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(0, 255, 255));
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);

		final ConnectingDB dbConnector = new ConnectingDB();

		JButton profile_button = new JButton("Profile");
		profile_button.setBounds(12, 121, 96, 23);
		profile_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Profile profile = new Profile();
				profile.setLocationRelativeTo(null);
				setVisible(false);
				profile.setVisible(true);
			}

		});
		contentPane.setLayout(null);
		contentPane.add(profile_button);

		JButton btnNewButton = new JButton("Home");
		btnNewButton.setBounds(12, 81, 96, 30);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Home home = new Home();
				home.setLocationRelativeTo(null);
				setVisible(false);
				home.setVisible(true);
			}

		});
		contentPane.add(btnNewButton);

		ImageIcon imageIcon = new ImageIcon("./image/person.png");
		Profile profileInstance = new Profile(); // 외부 클래스의 인스턴스 생성
		CircularLabel circularLabel = profileInstance.new CircularLabel("Hello", imageIcon);

		circularLabel.setHorizontalAlignment(JLabel.CENTER);
		circularLabel.setVerticalAlignment(JLabel.CENTER);
		circularLabel.setBounds(600, 100, 30, 30); // 위치와 크기 설정
		circularLabel.setOpaque(false);
		this.getContentPane().add(circularLabel);
		contentPane.setLayout(null);

		CircularLabel circularLabel2 = profileInstance.new CircularLabel("Hello", imageIcon);

		circularLabel2.setHorizontalAlignment(JLabel.CENTER);
		circularLabel2.setVerticalAlignment(JLabel.CENTER);
		circularLabel2.setBounds(600, 50, 30, 30); // 위치와 크기 설정
		circularLabel2.setOpaque(false);
		this.getContentPane().add(circularLabel2);
		contentPane.setLayout(null);

		CircularLabel circularLabel3 = profileInstance.new CircularLabel("Hello", imageIcon);

		circularLabel3.setHorizontalAlignment(JLabel.CENTER);
		circularLabel3.setVerticalAlignment(JLabel.CENTER);
		circularLabel3.setBounds(600, 150, 30, 30); // 위치와 크기 설정
		circularLabel3.setOpaque(false);
		this.getContentPane().add(circularLabel3);
		contentPane.setLayout(null);

		CircularLabel circularLabel4 = profileInstance.new CircularLabel("Hello", imageIcon);

		circularLabel4.setHorizontalAlignment(JLabel.CENTER);
		circularLabel4.setVerticalAlignment(JLabel.CENTER);
		circularLabel4.setBounds(600, 200, 30, 30); // 위치와 크기 설정
		circularLabel4.setOpaque(false);
		this.getContentPane().add(circularLabel4);
		contentPane.setLayout(null);
		final List<String> randomId = getRandomId(dbConnector.getConnection(), Signin.loggedInId);
		List<String> randomNicknames = new ArrayList<>();

		// Ensure that randomId is not empty before accessing its elements
		if (!randomId.isEmpty()) {
			randomNicknames.add(EditProfile.getIdToSome(dbConnector.getConnection(), randomId.get(0), "nickname"));
			randomNicknames.add(EditProfile.getIdToSome(dbConnector.getConnection(), randomId.get(1), "nickname"));
			randomNicknames.add(EditProfile.getIdToSome(dbConnector.getConnection(), randomId.get(2), "nickname"));
			randomNicknames.add(EditProfile.getIdToSome(dbConnector.getConnection(), randomId.get(3), "nickname"));
		} else {
			System.out.println("No random ID found.");
		}

		final JLabel txtA = new JLabel("New label");
		txtA.setText(randomNicknames.get(0));
		txtA.setBounds(643, 50, 80, 23);
		contentPane.add(txtA);

		final JLabel txtB = new JLabel("New label");
		txtB.setText(randomNicknames.get(1));
		txtB.setBounds(643, 105, 80, 23);
		contentPane.add(txtB);

		final JLabel txtC = new JLabel("New label");
		txtC.setText(randomNicknames.get(2));
		txtC.setBounds(643, 144, 80, 23);
		contentPane.add(txtC);

		final JLabel txtD = new JLabel("New label");
		txtD.setText(randomNicknames.get(3));
		txtD.setBounds(643, 203, 80, 23);
		contentPane.add(txtD);

		JLabel lblNewLabel = new JLabel("Who to follow");
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 16));
		lblNewLabel.setBounds(608, 10, 163, 30);
		contentPane.add(lblNewLabel);

		final JButton btnA = new JButton("Follow");
		btnA.setFont(new Font("굴림체", Font.ITALIC, 14));
		btnA.setBounds(756, 50, 90, 23);
		btnA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				follow(dbConnector.getConnection(), randomId.get(0));
				btnA.setVisible(false);
			}
		});
		contentPane.add(btnA);

		final JButton btnB = new JButton("Follow");
		btnB.setFont(new Font("굴림체", Font.ITALIC, 14));
		btnB.setBounds(756, 101, 90, 23);
		btnB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				follow(dbConnector.getConnection(), randomId.get(1));
				btnB.setVisible(false);
			}
		});
		contentPane.add(btnB);

		final JButton btnC = new JButton("Follow");
		btnC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				follow(dbConnector.getConnection(), randomId.get(2));
				btnC.setVisible(false);
			}
		});
		btnC.setFont(new Font("굴림체", Font.ITALIC, 14));
		btnC.setBounds(756, 140, 90, 23);

		contentPane.add(btnC);

		final JButton btnD = new JButton("Follow");
		btnD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				follow(dbConnector.getConnection(), randomId.get(3));
				btnD.setVisible(false);
			}
		});
		btnD.setFont(new Font("굴림체", Font.ITALIC, 14));
		btnD.setBounds(756, 199, 90, 23);
		contentPane.add(btnD);

		JLabel background = new JLabel("");
		background.setBackground(new Color(192, 192, 192));
		background.setOpaque(true);

		background.setBounds(571, 0, 287, 266);
		contentPane.add(background);

		JPanel AriticleMain = new JPanel();
		AriticleMain.setBounds(125, 27, 390, 199);
		contentPane.add(AriticleMain);
		AriticleMain.setLayout(null);

		JLabel dateLabel = new JLabel("Date");
		dateLabel.setBounds(16, 11, 29, 16);
		AriticleMain.add(dateLabel);

		JLabel messageLabel = new JLabel("message");
		messageLabel.setBounds(16, 39, 61, 16);
		AriticleMain.add(messageLabel);

		messageTextField = new JTextField();
		
		messageTextField.setBounds(16, 57, 362, 132);
		AriticleMain.add(messageTextField);
		messageTextField.setColumns(10);


		dateTextField = new JTextField();
		dateTextField.setText("20231203");
		dateTextField.setBounds(69, 6, 130, 26);

		AriticleMain.add(dateTextField);
		dateTextField.setColumns(10);
	

		JButton uploadButton = new JButton("Upload");
		uploadButton.setBounds(222, 6, 97, 29);
		AriticleMain.add(uploadButton);

		uploadButton.setFocusable(false);

		JPanel AriticleMain_1 = new JPanel();
		AriticleMain_1.setLayout(null);
		AriticleMain_1.setBounds(125, 254, 390, 199);
		contentPane.add(AriticleMain_1);

		JLabel lblWriter = new JLabel("Writer : ");
		lblWriter.setBounds(16, 11, 61, 16);
		AriticleMain_1.add(lblWriter);

		JLabel messageLabel_1 = new JLabel("message");
		messageLabel_1.setBounds(16, 39, 61, 16);
		AriticleMain_1.add(messageLabel_1);

		String randomWriterId = returnWriterId(dbConnector.getConnection(), Signin.loggedInId);
		String randomUser = EditProfile.getIdToSome(dbConnector.getConnection(),
				randomWriterId, "nickname");

		JLabel writerLbl = new JLabel(randomUser);
		writerLbl.setBounds(89, 12, 90, 15);
		AriticleMain_1.add(writerLbl);

		JLabel Article = new JLabel(returnArticleContent(dbConnector.getConnection(), randomWriterId));
		System.out.println("Article Content: " + returnArticleContent(dbConnector.getConnection(), randomWriterId));

		
		Article.setBackground(new Color(255, 255, 255));
		Article.setBounds(16, 65, 362, 124);
		AriticleMain_1.add(Article);
		
		JLabel lblNewLabel_2 = new JLabel("Twitter");
		lblNewLabel_2.setForeground(new Color(0, 255, 255));
		lblNewLabel_2.setFont(new Font("한컴 고딕", Font.BOLD, 20));
		lblNewLabel_2.setBounds(25, 42, 73, 29);
		contentPane.add(lblNewLabel_2);
		
		JPanel commnetBack = new JPanel();
		commnetBack.setBounds(516, 315, 255, 138);
		contentPane.add(commnetBack);
		commnetBack.setLayout(null);
		
		JLabel messageLabel_1_1 = new JLabel("commnet : ");
		messageLabel_1_1.setBounds(12, 22, 61, 16);
		commnetBack.add(messageLabel_1_1);
		
		JLabel writerLbl_1 = new JLabel((String) null);
		writerLbl_1.setBounds(89, 12, 90, 15);
		commnetBack.add(writerLbl_1);
		
		JButton commnetBtn = new JButton("hello");
		commnetBtn.setHorizontalAlignment(SwingConstants.LEFT);
		commnetBtn.setVerticalAlignment(SwingConstants.TOP);
		commnetBtn.setBounds(85, 22, 158, 99);
		commnetBack.add(commnetBtn);

		uploadButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {

					updateArticle(dbConnector.getConnection(), Signin.loggedInId, dateTextField.getText(),
							messageTextField.getText());
					messageTextField.setText("");

				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}

		});

	}

	public static List<String> getRandomId(Connection connection, String id) {
		List<String> ids = new ArrayList<>();

		try {
			// SQL query to fetch 4 random user IDs excluding the user itself
			String sql = "SELECT id FROM user " + "WHERE NOT EXISTS (SELECT 1 FROM follow "
					+ "WHERE follower = ? AND user.id = follow.following) " + "AND user.id <> ? "
					+ "ORDER BY RAND() LIMIT 4";

			try (PreparedStatement statement = connection.prepareStatement(sql)) {
				statement.setString(1, id);
				statement.setString(2, id);

				try (ResultSet resultSet = statement.executeQuery()) {
					// Process the result set
					while (resultSet.next()) {
						String userId = resultSet.getString("id");
						ids.add(userId);
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return ids;
	}

	public static void follow(Connection con, String follower_id) {
		try {
			String sql = "INSERT INTO follow (follower, following) VALUES (?, ?)";

			try (PreparedStatement statement = con.prepareStatement(sql)) {
				statement.setString(1, Signin.loggedInId);
				statement.setString(2, follower_id);

				// executeUpdate() 메서드를 사용하여 변경 사항이 있는 쿼리를 실행
				int rowsAffected = statement.executeUpdate();

				if (rowsAffected > 0) {
					System.out.println("Follow successful.");
				} else {
					System.out.println("Follow failed.");
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static boolean updateArticleMessage(Connection con, String articleId, String message) {

		String insertmessageQuery = "INSERT INTO article_content (article_id, article_message ) VALUES (?, ?) ";

		try {
			PreparedStatement messageState = con.prepareStatement(insertmessageQuery);

			messageState.setString(1, articleId);
			messageState.setString(2, message);

			int rowsMessageAffected = messageState.executeUpdate();

			if (rowsMessageAffected > 0) {
				System.out.println("Article Message saved to the database.");

				return true;
			} else {
				System.out.println("Failed to save Article Message to the database.");
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	// Insert Article Contents
	private static boolean updateArticle(Connection con, String userId, String date, String message) {

		String randomArticleId = generateRandomArticleId(con);
		String insertQuery = "INSERT INTO article ( article_id, user_id, date ) VALUES (?, ?, ?)";
		try {
			PreparedStatement state = con.prepareStatement(insertQuery);

			state.setString(1, randomArticleId);
			state.setString(2, userId);
			state.setString(3, date);

			int rowsAffected = state.executeUpdate();

			if (rowsAffected > 0) {
				System.out.println("Article ID saved to the database.");

				updateArticleMessage(con, randomArticleId, message);

				return true;
			} else {
				System.out.println("Failed to save user ID to the database.");
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;

	}

	public static String generateRandomArticleId(Connection con) {
		while (true) {
			// 랜덤한 ID 생성
			long timestamp = System.currentTimeMillis();
			int randomInt = (int) (Math.random() * Integer.MAX_VALUE);
			long result = timestamp + randomInt;
			String randomId = Long.toString(result);

			// 생성한 ID가 특정 테이블에 이미 존재하는지 확인
			if (!articleIdExistsInTable(con, randomId)) {
				return randomId;
			}
		}
	}

	private static boolean articleIdExistsInTable(Connection con, String id) {
		// 특정 테이블에서 ArticleID가 존재하는지 확인하는 로직
		String sql = "SELECT COUNT(*) FROM article WHERE article_id = ?";
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

	private static String returnArticleContent(Connection con, String id) {
		String sql = "SELECT article_content.article_message\r\n"
				+ "FROM article\r\n"
				+ "JOIN article_content ON article.article_id = article_content.article_id\r\n"
				+ "JOIN user ON article.user_id = user.id\r\n"
				+ "WHERE user.id = ?";

		try (PreparedStatement statement = con.prepareStatement(sql)) {
			statement.setString(1, id);
			try (ResultSet resultSet = statement.executeQuery()) {
				if (resultSet.next()) {
					return resultSet.getString("article_message");
				}
				else {
			        System.out.println("Result does not exist");
			    }
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "hello";
	}

	private static String returnWriterId(Connection con, String id) {
		String sql = "SELECT id FROM user WHERE id = ? OR id IN ( SELECT following FROM follow WHERE follower = ?)ORDER BY RAND()\r\n"
				+ "LIMIT 1; ";

		try (PreparedStatement statement = con.prepareStatement(sql)) {
			statement.setString(1, id);
			statement.setString(2, id);
			try (ResultSet resultSet = statement.executeQuery()) {
				if (resultSet.next()) {
					return resultSet.getString("id");
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
