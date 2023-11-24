package cat2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;

public class regFrm {

	private JFrame frame;
	private JTextField textFieldName;
	private JTextField textFieldUsName;
	private JTextField textFieldPass;
	private JTextField textFieldConPass;
	private JTextField textFieldEmail;
	private JTextField textFieldPhone;
	private JTextField textFieldAdd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					regFrm window = new regFrm();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public regFrm() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 415, 446);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Registration Form");
		lblNewLabel.setBounds(24, 21, 133, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setBounds(24, 67, 46, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Username");
		lblNewLabel_2.setBounds(24, 99, 71, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Password");
		lblNewLabel_3.setBounds(24, 138, 46, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Confirm Password");
		lblNewLabel_4.setBounds(24, 173, 86, 14);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Email");
		lblNewLabel_5.setBounds(24, 209, 46, 14);
		frame.getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Phone");
		lblNewLabel_6.setBounds(24, 252, 46, 14);
		frame.getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Address:");
		lblNewLabel_7.setBounds(24, 292, 46, 14);
		frame.getContentPane().add(lblNewLabel_7);
		
		textFieldName = new JTextField();
		textFieldName.setBounds(139, 64, 191, 17);
		frame.getContentPane().add(textFieldName);
		textFieldName.setColumns(10);
		
		textFieldUsName = new JTextField();
		textFieldUsName.setBounds(139, 96, 191, 17);
		frame.getContentPane().add(textFieldUsName);
		textFieldUsName.setColumns(10);
		
		textFieldPass = new JTextField();
		textFieldPass.setBounds(139, 135, 191, 17);
		frame.getContentPane().add(textFieldPass);
		textFieldPass.setColumns(10);
		
		textFieldConPass = new JTextField();
		textFieldConPass.setBounds(139, 170, 191, 17);
		frame.getContentPane().add(textFieldConPass);
		textFieldConPass.setColumns(10);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setBounds(139, 206, 191, 17);
		frame.getContentPane().add(textFieldEmail);
		textFieldEmail.setColumns(10);
		
		textFieldPhone = new JTextField();
		textFieldPhone.setBounds(139, 249, 191, 17);
		frame.getContentPane().add(textFieldPhone);
		textFieldPhone.setColumns(10);
		
		textFieldAdd = new JTextField();
		textFieldAdd.setBounds(139, 289, 191, 17);
		frame.getContentPane().add(textFieldAdd);
		textFieldAdd.setColumns(10);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try 
				{
					Class.forName("com.mysql.cj.jdbc.Driver");	
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/root", "root", "Liasma");
					String sql="INSERT INTO registration(Name,Username,Password,Email,Phone,Address) VALUES(?,?,?,?,?,?)";
					PreparedStatement pr=con.prepareStatement(sql);
					pr.setString(1,textFieldName.getText());
					pr.setString(2,textFieldUsName.getText());
					pr.setString(3,textFieldPass.getText());
					pr.setString(4,textFieldEmail.getText());
					pr.setString(5,textFieldPhone.getText());
					pr.setString(6,textFieldAdd.getText());

				if(textFieldConPass.getText().equals(textFieldPass.getText())) {
					int count=pr.executeUpdate();
					if(count > 0) {
						JOptionPane.showMessageDialog(null,"Record added successfully");
						textFieldName.setText("");
						textFieldUsName.setText("");
						textFieldPass.setText("");
						textFieldConPass.setText("");
						textFieldEmail.setText("");
						textFieldPhone.setText("");
						textFieldAdd.setText("");
						con.close();
					} else {
						JOptionPane.showMessageDialog(null,"No Record added");
						con.close();
					}
				} else {
						JOptionPane.showMessageDialog(null, "The password do not match");
			}
				} catch (Exception arg0) {
				arg0.printStackTrace();
				return;
			}
				}
		

		});
		btnNewButton.setBounds(21, 346, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Reset");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldName.setText("");
				textFieldUsName.setText("");
				textFieldPass.setText("");
				textFieldConPass.setText("");
				textFieldEmail.setText("");
				textFieldPhone.setText("");
				textFieldAdd.setText("");
			}
		});
		btnNewButton_1.setBounds(177, 346, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Close");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnNewButton_2.setBounds(310, 346, 89, 23);
		frame.getContentPane().add(btnNewButton_2);
	}
}
