package Twitter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JPasswordField;

public class Signin extends JFrame {

	private static final long serialVersionUID = 1L;
	static String loggedInId;
	private JPanel contentPane;
	private JTextField Email_textField;
	private JPasswordField Password_textField;

	
	public Signin() {
		super("Sign in");
		setTitle("Sign in");							
		this.setSize(675, 500);	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// setBounds(100, 100, 450, 300);
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		Email_textField = new JTextField();
		Email_textField.setColumns(10);
		
		JButton Login_button = new JButton("LOGIN");
		
		final ConnectingDB dbConnector = new ConnectingDB();
		
		Login_button.addActionListener(new ActionListener(){
			   public void actionPerformed(ActionEvent ae){
			      String textFieldValue = Email_textField.getText();
			      char[] passwordCharArray = Password_textField.getPassword();
			      String password = new String(passwordCharArray);

			      // .... do some operation on value ...
			      if (checkEmail(dbConnector.getConnection(), textFieldValue) && CheckPassword(dbConnector.getConnection(), textFieldValue, password)) {
			    	  String tmp = returnId(dbConnector.getConnection(), textFieldValue);
			    	  if(tmp!=null) {
			    		  loggedInId=tmp;
			    	  }
			    	  else {
				    	  LoginFail fail = new LoginFail();
				    	  fail.setLocationRelativeTo(null);
				    	  fail.setVisible(true);
				      }
			    	 
			    	  Home home = new Home();
			    	  home.setLocationRelativeTo(null);
				      setVisible(false);
				      home.setVisible(true);
			      }
			      else {
			    	  LoginFail fail = new LoginFail();
			    	  fail.setLocationRelativeTo(null);
			    	  fail.setVisible(true);
			      }
			      
			   }
			});
		
		JButton SignUpBtn = new JButton("Sign Up");
		SignUpBtn.addActionListener(new ActionListener(){
			   public void actionPerformed(ActionEvent ae){
			      setVisible(false);
			      Signup Signup = new Signup();
			      Signup.setLocationRelativeTo(null);
					Signup.setVisible(true);
			   }
			});
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\82107\\eclipse-workspace\\Database-Twitter\\image\\twitter-312464_640.png"));
		
		JLabel lblNewLabel_1 = new JLabel("See  what's happeing in the world right now");
		lblNewLabel_1.setFont(new Font("Eras Bold ITC", Font.BOLD, 21));
		
		JLabel lblNewLabel_2 = new JLabel("Join us today");
		lblNewLabel_2.setFont(new Font("Gadugi", Font.BOLD | Font.ITALIC, 16));
		
		Password_textField = new JPasswordField();
		
		JLabel lblNewLabel_3 = new JLabel("E-mail : ");
		
		JLabel lblNewLabel_4 = new JLabel("Password : ");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(22)
							.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(Email_textField, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(Password_textField, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE)
							.addGap(34)
							.addComponent(Login_button))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(77)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 647, Short.MAX_VALUE)
								.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(199)
							.addComponent(SignUpBtn, GroupLayout.PREFERRED_SIZE, 253, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(Email_textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(Login_button)
						.addComponent(lblNewLabel_3)
						.addComponent(lblNewLabel_4)
						.addComponent(Password_textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(72)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel_2)
					.addGap(18)
					.addComponent(SignUpBtn)
					.addGap(109))
		);
	
		
		
		contentPane.setLayout(gl_contentPane);
	}
	private static boolean CheckPassword(Connection con, String email, String password) {
	    String sql = "SELECT password FROM user WHERE email = ?";
	    try (PreparedStatement statement = con.prepareStatement(sql)) {
	        // 쿼리의 파라미터 설정
	        statement.setString(1, email);

	        // 쿼리 실행 및 결과 가져오기
	        try (ResultSet resultSet = statement.executeQuery()) {
	            if (resultSet.next()) {
	                // 저장된 비밀번호 가져오기
	                String storedPassword = resultSet.getString("password");

	                // 저장된 비밀번호가 존재하고 입력된 비밀번호와 일치하는지 확인
	                return storedPassword != null && storedPassword.equals(password);
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return false;
	}

	private static boolean checkEmail(Connection con, String username) {
	    // 데이터베이스 연결
	    try {
	        // SQL 쿼리 작성
	        String sql = "SELECT * FROM user WHERE email = ?";
	        try (PreparedStatement statement = con.prepareStatement(sql)) {
	            // 쿼리의 파라미터 설정
	            statement.setString(1, username);

	            // 쿼리 실행 및 결과 가져오기
	            try (ResultSet resultSet = statement.executeQuery()) {
	                return resultSet.next(); // 결과가 있는지 확인하여 반환
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return false;
	}
	private static String returnId(Connection con, String email) {
		try {
			String sql = "SELECT id FROM user WHERE email = ?";
			try (PreparedStatement statement = con.prepareStatement(sql)) {
	            // 쿼리의 파라미터 설정
	            statement.setString(1, email);

	            // 쿼리 실행 및 결과 가져오기
	            try (ResultSet resultSet = statement.executeQuery()) {
	            	 if (resultSet.next()) {
	                     String storedId = resultSet.getString("id"); // 결과가 있는지 확인하여 반환
	                     
	                     return storedId;
	                 } else {
	                     System.out.println("User not found for email: " + email);
	                     return null; // 사용자가 존재하지 않을 경우 null 반환
	                 }
	            }
	        }
		}catch (SQLException e) {
	        e.printStackTrace();
	    }
		System.out.println("ERROR");
		return null;
	}

}
