import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.border.Border;
import java.util.HashMap;
import java.util.Map;

public class RegisterWindow implements ActionListener{


    JFrame RegisterWindoFrame = new JFrame();  
    JPanel registerPanel = new JPanel();

    JLabel emailLabel = new JLabel("Email:");
    JLabel passwordLabel = new JLabel("Password : ");
    JLabel usernameLabel = new JLabel("Username: ");

    JButton registerButton = new JButton("Register");
    JButton backButton = new JButton("<<<");
    JButton resetButton = new JButton("Reset");

    

    JTextField emailTextField = new JTextField();
    JTextField passwordTextField = new JTextField();
    JTextField userNameField = new JTextField();

    String usersDataBase = "users.txt";

    JPasswordField passwordField = new JPasswordField();
    JCheckBox showPassword = new JCheckBox("Show Password");

    Border emptyborder = BorderFactory.createEmptyBorder();


    RegisterWindow() {  

        RegisterWindoFrame.setSize(1200, 800);
        RegisterWindoFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        RegisterWindoFrame.setResizable(false);
        RegisterWindoFrame.setLocationRelativeTo(null);

        RegisterWindoFrame.add(registerPanel);

        registerPanel.setLayout(null);
        registerPanel.setBackground(Color.black);


        registerPanel.add(emailLabel);
        registerPanel.add(passwordLabel);
        registerPanel.add(usernameLabel);
        registerPanel.add(passwordField);
        registerPanel.add(emailTextField);
        registerPanel.add(userNameField);
        registerPanel.add(registerButton);
        registerPanel.add(backButton);
        registerPanel.add(resetButton);
        registerPanel.add(showPassword);



        usernameLabel.setBounds(390, 315, 150, 25);
        usernameLabel.setForeground(Color.white);

        emailLabel.setBounds(390, 345, 150, 25);
        emailLabel.setForeground(Color.white);

        passwordLabel.setBounds(390, 375, 150, 25);
        passwordLabel.setForeground(Color.white);

        userNameField.setBounds(490, 315, 250, 25);
        userNameField.setFont(new Font("helvetica", Font.BOLD, 12));
        userNameField.setBackground(Color.DARK_GRAY);
        userNameField.setForeground(Color.white);
        userNameField.setCaretColor(Color.white);

        emailTextField.setBounds(490, 345, 250, 25);
        emailTextField.setFont(new Font("helvetica", Font.BOLD, 12));
        emailTextField.setBackground(Color.DARK_GRAY);
        emailTextField.setForeground(Color.white);
        emailTextField.setCaretColor(Color.white);

        passwordField.setBounds(490, 375, 250, 25);
        passwordField.setFont(new Font("helvetica", Font.BOLD, 12));
        passwordField.setBackground(Color.DARK_GRAY);
        passwordField.setForeground(Color.white);
        passwordField.setCaretColor(Color.white);


        //show password icon
        showPassword.setBounds(490, 405, 150, 30);
        showPassword.setFocusable(false);
        showPassword.setBackground(Color.black);
        showPassword.setForeground(Color.white);

        backButton.setBounds(20, 20, 60, 20);
        backButton.setFocusable(false);
        backButton.setBackground(Color.RED);
        backButton.setForeground(Color.white);
        backButton.setBorder(emptyborder);

        registerButton.setBounds(520, 445, 80, 25);
        registerButton.setFocusable(false);
        registerButton.setBackground(Color.RED);
        registerButton.setForeground(Color.white);
        registerButton.setBorder(emptyborder);

        resetButton.setBounds(620, 445, 80, 25);
        resetButton.setFocusable(false);
        resetButton.setBackground(Color.RED);
        resetButton.setForeground(Color.white);
        resetButton.setBorder(emptyborder);


        registerButton.addActionListener(this);
        backButton.addActionListener(this);
        resetButton.addActionListener(this);
        showPassword.addActionListener(this);


        RegisterWindoFrame.setVisible(true);
         
    }



    public void actionPerformed(ActionEvent e){  

        String username = userNameField.getText();
        String email = emailTextField.getText();
        String password = passwordField.getText();



        if(e.getSource() == registerButton){

// second if statement for if email already exists

            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\Charles\\Documents\\Java (VS Code)\\Shopping\\user.txt", true));
                writer.write("Username: " + username);
                writer.newLine();
                writer.write("Email: " + email);
                writer.newLine();
                writer.write("Password: " + password);
                writer.newLine();
                writer.newLine(); // Add an extra newline to separate user entries
                writer.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            System.out.println("\nUsername: " + username + "\nEmail: "+ email + "\nPassword: " + password);
            RegisterWindoFrame.dispose();
            LaunchPage launchPage = new LaunchPage();
            launchPage.setVisible(true);
        }
       

        if (e.getSource() == backButton){
            RegisterWindoFrame.dispose();
            LaunchPage launchPage = new LaunchPage();
        }

        if (e.getSource() == resetButton) {
            userNameField.setText("");
            emailTextField.setText("");
            passwordField.setText("");
        }

        if (e.getSource() == showPassword) {
            if (showPassword.isSelected()) {
                passwordField.setEchoChar((char) 0);
            } 
            
            else {
                passwordField.setEchoChar('•');
            }
        }  



    }  
}
