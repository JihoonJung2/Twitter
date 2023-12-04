package Twitter;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class EditProfile extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField emailLbl;
	private JTextField passwordLbl;
	private JTextField nicknameLbl;
	private JTextField pnLbl;
	private JTextField birthLbl;

	
	public EditProfile() {
		setBackground(new Color(255, 255, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 401, 509);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\82107\\eclipse-workspace\\Database-Twitter\\image\\bluebird2.png"));
		lblNewLabel.setBounds(166, 0, 36, 63);
		contentPane.add(lblNewLabel);
		
		final ConnectingDB dbConnector = new ConnectingDB();
		
		emailLbl = new JTextField();
		emailLbl.setText(getIdToSome(dbConnector.getConnection(), Signin.loggedInId, "email"));
		emailLbl.setBounds(55, 85, 154, 21);
		contentPane.add(emailLbl);
		emailLbl.setColumns(10);
		
		final JButton emailBtn = new JButton("Change email");
		emailBtn.setHorizontalAlignment(SwingConstants.LEFT);
		emailBtn.setBounds(224, 84, 131, 23);
		contentPane.add(emailBtn);
		emailBtn.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	            editSome(dbConnector.getConnection(), Signin.loggedInId,"email", emailLbl.getText());
	         }
	      });
		
		
		passwordLbl = new JTextField();
		passwordLbl.setText(getIdToSome(dbConnector.getConnection(), Signin.loggedInId, "password"));
		passwordLbl.setBounds(48, 147, 154, 21);
		contentPane.add(passwordLbl);
		passwordLbl.setColumns(10);
		
		final JButton passwordBtn = new JButton("Change password");
		passwordBtn.setHorizontalAlignment(SwingConstants.LEFT);
		passwordBtn.setBounds(224, 146, 139, 23);
		contentPane.add(passwordBtn);
		passwordBtn.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	            editSome(dbConnector.getConnection(), Signin.loggedInId,"password", passwordLbl.getText());
	         }
	      });
		
		nicknameLbl = new JTextField();
		nicknameLbl.setText(getIdToSome(dbConnector.getConnection(), Signin.loggedInId, "nickname"));
		nicknameLbl.setBounds(51, 220, 158, 21);
		contentPane.add(nicknameLbl);
		nicknameLbl.setColumns(10);
		
		final JButton nicknameBtn = new JButton("Change nickname");
		nicknameBtn.setHorizontalAlignment(SwingConstants.LEFT);
		nicknameBtn.setBounds(224, 219, 139, 23);
		contentPane.add(nicknameBtn);
		nicknameBtn.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	            editSome(dbConnector.getConnection(), Signin.loggedInId,"nickname", nicknameLbl.getText());
	         }
	      });
		
		pnLbl = new JTextField();
		pnLbl.setText(getIdToSome(dbConnector.getConnection(), Signin.loggedInId, "phone_number"));
		pnLbl.setBounds(48, 289, 158, 21);
		contentPane.add(pnLbl);
		pnLbl.setColumns(10);
		
		birthLbl = new JTextField();
		birthLbl.setText(getIdToSome(dbConnector.getConnection(), Signin.loggedInId, "birth_date"));
		birthLbl.setBounds(45, 361, 164, 21);
		contentPane.add(birthLbl);
		birthLbl.setColumns(10);
		
		final JButton phoneNumberBtn = new JButton("Change Phone number");
		phoneNumberBtn.setHorizontalAlignment(SwingConstants.LEFT);
		phoneNumberBtn.setBounds(220, 288, 167, 23);
		contentPane.add(phoneNumberBtn);
		phoneNumberBtn.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	            editSome(dbConnector.getConnection(), Signin.loggedInId,"phone_number", pnLbl.getText());
	         }
	      });
		
		final JButton birthBtn = new JButton("Change birth-date");
		birthBtn.setHorizontalAlignment(SwingConstants.LEFT);
		birthBtn.setBounds(224, 360, 139, 23);
		contentPane.add(birthBtn);
		birthBtn.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	            editSome(dbConnector.getConnection(), Signin.loggedInId,"birth_date", birthLbl.getText());
	         }
	      });
		
		JButton BackBtn = new JButton("Back");
		BackBtn.setBounds(144, 418, 91, 23);
		contentPane.add(BackBtn);
		BackBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Profile profile = new Profile();
				profile.setLocationRelativeTo(null);
				profile.setVisible(true);
				setVisible(false);
			}
		});
		
	}
	public static String getIdToSome(Connection con, String id, String a) {
	    try {
	        String sql = "SELECT " + a + " FROM user WHERE id = ?";
	        try (PreparedStatement statement = con.prepareStatement(sql)) {
	            statement.setString(1, id);

	            // 쿼리 실행 및 결과 가져오기
	            try (ResultSet resultSet = statement.executeQuery()) {
	                if (resultSet.next()) {
	                    String storedValue = resultSet.getString(1); // 결과가 있는지 확인하여 반환
	                    
	                    return storedValue;
	                } else {
	                    System.out.println("User not found for id: " + id);
	                    return null; // 사용자가 존재하지 않을 경우 null 반환
	                }
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        System.out.println("ERROR");
	        return null;
	    } finally {
	        // 리소스 정리 등 필요한 부분
	    }
	}
	public static void editSome(Connection con, String id, String schema, String value) {
	    try {
	        String sql = "UPDATE user SET " + schema + " = ? WHERE id = ?";
	        try (PreparedStatement statement = con.prepareStatement(sql)) {
	            statement.setString(1, value);
	            statement.setString(2, id);

	            // 쿼리 실행
	            int rowsUpdated = statement.executeUpdate();

	            if (rowsUpdated > 0) {
	                updateSuccess success = new updateSuccess();
	                success.setVisible(true);
	            } else {
	                System.out.println("레코드가 업데이트되지 않았습니다. 해당하는 ID가 없을 수 있습니다.");
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    } finally {
	        // 리소스 정리 등 필요한 부분
	    }
	}

}
