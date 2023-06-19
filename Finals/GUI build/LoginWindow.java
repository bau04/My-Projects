import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;
import javax.swing.*;
import javax.swing.border.Border;


public class LoginWindow implements ActionListener{


    JFrame LoginWindowFrame = new JFrame();  

    JPanel loginPanel = new JPanel();

    JLabel LoginLabel = new JLabel("Login");
    JLabel UserNameLabel = new JLabel("Username or Email:");
    JLabel PasswordLabel = new JLabel("Password : ");
    JLabel ErrorLabel = new JLabel("");

    JButton loginButton = new JButton("Sign in");
    JButton backButton = new JButton("<<<");
    JButton resetButton = new JButton("Reset");
    
    JTextField userField = new JTextField();
    JPasswordField passwordField = new JPasswordField();
    JCheckBox showPassword = new JCheckBox("Show Password");

    Border emptyborder = BorderFactory.createEmptyBorder();

    LoginWindow() {  

        LoginWindowFrame.setSize(1200, 800);
        LoginWindowFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        LoginWindowFrame.setResizable(false);
        LoginWindowFrame.setLocationRelativeTo(null);


        loginPanel.setLayout(null);
        loginPanel.setBackground(Color.black);


        userField.setBounds(490, 315, 250, 25);
        userField.setFont(new Font("helvetica", Font.BOLD, 12));
        userField.setBackground(Color.DARK_GRAY);
        userField.setForeground(Color.white);
        userField.setCaretColor(Color.white);

        passwordField.setBounds(490, 345, 250, 25);
        passwordField.setFont(new Font("helvetica", Font.BOLD, 12));
        passwordField.setBackground(Color.darkGray);
        passwordField.setForeground(Color.white);
        passwordField.setCaretColor(Color.white);

        loginButton.setBounds(620, 415, 80, 25);
        loginButton.setFocusable(false);
        loginButton.setBackground(Color.RED);
        loginButton.setForeground(Color.white);
        loginButton.setBorder(emptyborder);

        resetButton.setBounds(520, 415, 80, 25);
        resetButton.setFocusable(false);
        resetButton.setBackground(Color.RED);
        resetButton.setForeground(Color.white);
        resetButton.setBorder(emptyborder);

        backButton.setBounds(20, 20, 60, 20);
        backButton.setFocusable(false);
        backButton.setBackground(Color.RED);
        backButton.setForeground(Color.white);
        backButton.setBorder(emptyborder);


        showPassword.setBounds(490, 375, 150, 30);
        showPassword.setBackground(Color.black);
        showPassword.setForeground(Color.white);

        // LoginLabel.setBounds(550, 250, 50, 50);
        UserNameLabel.setBounds(370, 315, 150, 25);
        UserNameLabel.setForeground(Color.white);
        PasswordLabel.setBounds(370, 345, 150, 25);
        PasswordLabel.setForeground(Color.white);
        ErrorLabel.setBounds(480, 500, 250, 25);


        LoginWindowFrame.add(loginPanel);
        // panel.add(LoginLabel);
        loginPanel.add(UserNameLabel);
        loginPanel.add(userField);
        loginPanel.add(PasswordLabel);
        loginPanel.add(passwordField);
        loginPanel.add(ErrorLabel);
        loginPanel.add(loginButton);
        loginPanel.add(backButton);
        loginPanel.add(resetButton);
        loginPanel.add(showPassword);

        loginButton.addActionListener(this);
        backButton.addActionListener(this);
        resetButton.addActionListener(this);
        showPassword.addActionListener(this);

        LoginWindowFrame.setVisible(true);

  
    }   


    //performs the actions
    public void actionPerformed(ActionEvent e){  

        String user = userField.getText();
        String password = passwordField.getText();

        String error = "Invalid Email, Username, or Password";

        System.out.println(user + ", " + password);

        if (e.getSource() == loginButton){
            boolean isValidLogin = validateLogin(user, password);
            if (isValidLogin) {
                LoginWindowFrame.dispose();
                // ProductCatalog productCatalog = new ProductCatalog();
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        new ShoppingApp ().setVisible(true);
                    }
                });
                // sLabel.setText("Login Successful");
            }
            else {
                JOptionPane.showMessageDialog(ErrorLabel, error);
            }
        }



        if (e.getSource() == backButton) {
            LoginWindowFrame.dispose();
            LaunchPage launchPage = new LaunchPage();
        }

        if (e.getSource() == resetButton) {
            userField.setText("");
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
private Map<String, String> readUserInformation(String filePath) {
    Map<String, String> userInformation = new HashMap<>();

    try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(":");
            if (parts.length == 2) {
                String key = parts[0].trim();
                String value = parts[1].trim();
                userInformation.put(key, value);
            }
        }
    } catch (IOException e) {
        e.printStackTrace();
    }

    // Print user information for debugging
    for (Map.Entry<String, String> entry : userInformation.entrySet()) {
        System.out.println(entry.getKey() + " : " + entry.getValue());
    }

    return userInformation; 
}    

private boolean validateLogin(String user, String password) {
    String filePath = "C:\\Users\\Charles\\Documents\\Java (VS Code)\\Shopping\\user.txt";
    Map<String, String> userInformation = readUserInformation(filePath);

    if (userInformation.containsKey("Username") && userInformation.containsKey("Email") && userInformation.containsKey("Password")) {
        String storedUser = userInformation.get("Username");
        String storedEmail = userInformation.get("Email");
        String storedPassword = userInformation.get("Password");
        if (user.equals(storedUser) && password.equals(storedPassword)) {
            return true; // Valid login credentials
        } if (storedEmail.equals(user) && password.equals(storedPassword)) {
            return true; // Valid email login (no password required)
        }
    }

    return false; // Invalid login credentials
}
}
