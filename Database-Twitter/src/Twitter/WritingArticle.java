package Twitter;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

public class WritingArticle extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField message_textField;
	private JTextField title_textField;
	private JLabel message_label;
	private JLabel title_label;
	private JButton article_save_button;
	private JLabel article_label;
	private JLabel Date_label;
	private JTextField date_textField;
	private JTextField tag_textField;

	
	public WritingArticle() {
		super("Article");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(350, 500);	
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		// Article 
		
		article_label = new JLabel("Article");
		
		// Title
		
		title_label = new JLabel("Title");
		
		title_textField = new JTextField();
		title_textField.setToolTipText("Title");
		title_textField.setColumns(10);
		
		// Date
		
		Date_label = new JLabel("Date");
		
		date_textField = new JTextField();
		date_textField.setColumns(10);
		
		// Tag
		
		JLabel tag_label = new JLabel("tag");
		
		tag_textField = new JTextField();
		tag_textField.setText("#tag #tag");
		tag_textField.setColumns(10);
		
		// Message
		
		message_label = new JLabel("Message");
		
		message_textField = new JTextField();
		message_textField.setToolTipText("Content");
		message_textField.setColumns(10);
		
		// Article Save Button
		
		article_save_button = new JButton("Save");
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(22)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(title_label)
								.addComponent(title_textField, 286, 286, Short.MAX_VALUE)
								.addComponent(message_textField, GroupLayout.DEFAULT_SIZE, 286, Short.MAX_VALUE)
								.addComponent(message_label)
								.addComponent(Date_label)
								.addComponent(date_textField)
								.addComponent(tag_label)
								.addComponent(tag_textField)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(128)
							.addComponent(article_save_button))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(141)
							.addComponent(article_label)))
					.addContainerGap(32, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(17)
					.addComponent(article_label)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(title_label)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(title_textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(Date_label)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(date_textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(12)
					.addComponent(tag_label)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(tag_textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
					.addComponent(message_label)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(message_textField, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(article_save_button)
					.addGap(24))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
