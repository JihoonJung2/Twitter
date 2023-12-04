package Twitter;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Profile extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	final ConnectingDB dbConnector = new ConnectingDB();

	public Profile() {
		super("Profile");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(398, 474);	
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        
		setContentPane(contentPane);
		ImageIcon imageIcon = new ImageIcon("./image/person.png");
		CircularLabel circularLabel = new CircularLabel("Hello", imageIcon);
        circularLabel.setHorizontalAlignment(JLabel.CENTER);
        circularLabel.setVerticalAlignment(JLabel.CENTER);
        circularLabel.setBounds(10, 100, 130, 130); // 위치와 크기 설정
        circularLabel.setOpaque(false);

        this.getContentPane().add(circularLabel);
		contentPane.setLayout(null);
		
		JLabel backgroundLbl = new JLabel("");
		backgroundLbl.setBackground(new Color(192, 192, 192));
		backgroundLbl.setBounds(0, 0, 384, 162);
		contentPane.add(backgroundLbl);
		backgroundLbl.setOpaque(true);
		
		// id -> nickname
		String nickname = getIdToNickname(dbConnector.getConnection(), Signin.loggedInId);
		
		JLabel nameLbl = new JLabel(nickname);
		nameLbl.setFont(new Font("Segoe UI Semibold", Font.BOLD, 19));
		nameLbl.setBounds(12, 230, 112, 31);
		contentPane.add(nameLbl);
		
		JLabel intrudoceLbl = new JLabel("introduce yourself");
		intrudoceLbl.setFont(new Font("Segoe UI Variable", Font.BOLD, 14));
		intrudoceLbl.setBounds(12, 281, 179, 20);
		contentPane.add(intrudoceLbl);
		
		// id -> following
		int following = getIdToFollowing(dbConnector.getConnection(), Signin.loggedInId);
		
		JLabel numberOfFollowings = new JLabel(String.valueOf(following));
		numberOfFollowings.setFont(new Font("휴먼둥근헤드라인", Font.PLAIN, 12));
		numberOfFollowings.setBounds(12, 325, 25, 15);
		contentPane.add(numberOfFollowings);
		
		JLabel lblNewLabel_3 = new JLabel("Followings");
		lblNewLabel_3.setFont(new Font("굴림체", Font.ITALIC, 12));
		lblNewLabel_3.setBounds(31, 325, 77, 15);
		contentPane.add(lblNewLabel_3);
		
		// id -> follower
		int follower = getIdToFollower(dbConnector.getConnection(), Signin.loggedInId);
		
		JLabel lblNewLabel = new JLabel(String.valueOf(follower));
		lblNewLabel.setFont(new Font("휴먼둥근헤드라인", Font.PLAIN, 12));
		lblNewLabel.setBounds(130, 325, 15, 15);
		contentPane.add(lblNewLabel);
		
		JLabel numberOfFollowers = new JLabel("Followers");
		numberOfFollowers.setFont(new Font("굴림체", Font.ITALIC, 12));
		numberOfFollowers.setBounds(156, 325, 68, 15);
		contentPane.add(numberOfFollowers);
		
		JButton editBtn = new JButton("Edit Profile");
		editBtn.setHorizontalAlignment(SwingConstants.LEFT);
		editBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				EditProfile editprofile=new EditProfile();
				editprofile.setLocationRelativeTo(null);
				editprofile.setVisible(true);
			}
		});
		editBtn.setBackground(new Color(39, 162, 209));
		editBtn.setBounds(252, 184, 120, 31);
		contentPane.add(editBtn);
		editBtn.setOpaque(false);
		
		JLabel blueBack = new JLabel("");
		blueBack.setIcon(new ImageIcon("C:\\Users\\82107\\eclipse-workspace\\Database-Twitter\\image\\blue button (1).png"));
		blueBack.setBounds(252, 184, 120, 31);
		contentPane.add(blueBack);
		
		JButton backBtn = new JButton("");
		backBtn.setBackground(new Color(255, 255, 255));
		
		backBtn.setIcon(new ImageIcon("C:\\Users\\82107\\eclipse-workspace\\Database-Twitter\\image\\home.png"));
		backBtn.setBounds(156, 382, 42, 31);
		contentPane.add(backBtn);
		backBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Home home = new Home();
				home.setLocationRelativeTo(null);
				home.setVisible(true);
				setVisible(false);
			}
		});
		
        
	}
	 public int getIdToFollower(Connection con, String id) {
		 try {
			 String sql = "SELECT COUNT(*) AS FollowerCount FROM follow WHERE following = ?";
			 try (PreparedStatement statement = con.prepareStatement(sql)) {
				 statement.setString(1, id);
				 
				// 쿼리 실행 및 결과 가져오기
		            try (ResultSet resultSet = statement.executeQuery()) {
		            	 if (resultSet.next()) {
		            		 int followerCount = resultSet.getInt("FollowerCount");
			                    
			                    return followerCount;
		                 } else {
		                     System.out.println("User not found for id: " + id);
		                     return 0; // 사용자가 존재하지 않을 경우 null 반환
		                 }
		            }
			 }catch (SQLException e) {
			        e.printStackTrace();
			 }
			 System.out.println("ERROR");
			 return 0;
		 }finally {
			 
		 }
	}
	
	public int getIdToFollowing(Connection con, String id) {
	    try {
	        String sql = "SELECT COUNT(*) AS FollowingCount FROM follow WHERE follower= ?";
	        try (PreparedStatement statement = con.prepareStatement(sql)) {
	            statement.setString(1, id);

	            // 쿼리 실행 및 결과 가져오기
	            try (ResultSet resultSet = statement.executeQuery()) {
	                if (resultSet.next()) {
	                    int followingCount = resultSet.getInt("FollowingCount");
	                   
	                    return followingCount;
	                } else {
	                    System.out.println("User not found for id: " + id);
	                    return 0; // 사용자가 존재하지 않을 경우 0 반환
	                }
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        System.out.println("ERROR");
	        return 0;
	    } finally {
	        // 리소스 정리 (생략 가능)
	    }
	}
	
	public class CircularLabel extends JLabel {
	        private ImageIcon imageIcon;

	        public CircularLabel(String text, ImageIcon imageIcon) {
	            super(text, JLabel.CENTER);
	            this.imageIcon = imageIcon;
	            setPreferredSize(new Dimension(100, 100)); // 크기 조절
	        }

	        @Override
	        protected void paintComponent(Graphics g) {
	            super.paintComponent(g);

	            int diameter = Math.min(getWidth(), getHeight());
	            int x = (getWidth() - diameter) / 2;
	            int y = (getHeight() - diameter) / 2;

	            g.setColor(new Color(244, 244, 255));
	            g.fillOval(x, y, diameter, diameter);
	            
	            if (imageIcon != null) {
	                Image image = imageIcon.getImage();
	                g.drawImage(image, x, y, diameter, diameter, this);
	            }
	        }
	    }
	 public static String getIdToNickname(Connection con, String id) {
		 try {
			 String sql = "SELECT Nickname FROM user WHERE id = ?";
			 try (PreparedStatement statement = con.prepareStatement(sql)) {
				 statement.setString(1, id);
				 
				// 쿼리 실행 및 결과 가져오기
		            try (ResultSet resultSet = statement.executeQuery()) {
		            	 if (resultSet.next()) {
		                     String storedNickname = resultSet.getString("nickname"); // 결과가 있는지 확인하여 반환
		                    
		                     return storedNickname;
		                 } else {
		                     System.out.println("User not found for id: " + id);
		                     return null; // 사용자가 존재하지 않을 경우 null 반환
		                 }
		            }
			 }catch (SQLException e) {
			        e.printStackTrace();
			 }
			 System.out.println("ERROR");
			 return null;
		 }finally {
			 
		 }
	 }
}