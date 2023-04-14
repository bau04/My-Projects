package LoginForm;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginForm extends JFrame implements ActionListener {

    // GUI Components
    private JLabel titleLabel;
    private JLabel nameLabel;
    private JLabel passwordLabel;
    private JTextField nameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JLabel statusLabel;
    private String[] loginInfo;
    private JCheckBox showPasswordCheckbox;

	JOptionPane jOptionPane = new JOptionPane();
	
	
    public LoginForm() {
    	
    	loginInfo = new String[2];
    	
        // Set up the window
        setTitle("Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setResizable(false);

        // Create and add the components
        Container container = getContentPane();
        container.setBackground(Color.decode("#7a4988"));
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));

        container.add(Box.createVerticalStrut(20)); // Add space

        // Image Label
        ImageIcon icon = new ImageIcon("myspace_logo.png");
        Image image = icon.getImage();
        int width = 200; // set the desired width of the image
        int height = 100; // set the desired height of the image
        Image resizedImage = image.getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH);
        ImageIcon resizedIcon = new ImageIcon(resizedImage);
        JLabel imageLabel = new JLabel(resizedIcon);
        imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        container.add(imageLabel);
        
        // Title Label
        titleLabel = new JLabel("YourSpace Login");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 25));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        titleLabel.setForeground(Color.decode("#e9cfec"));
        container.add(titleLabel);
        
        container.add(Box.createVerticalStrut(20)); // Add space


        // Name Label and Field
        nameLabel = new JLabel("Name:");
        nameLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        nameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        nameLabel.setForeground(Color.decode("#e9cfec"));
        container.add(nameLabel);
        
        container.add(Box.createVerticalStrut(10)); // Add space

        nameField = new JTextField(20);
        nameField.setMaximumSize(nameField.getPreferredSize());
        nameField.setForeground(Color.decode("#7a4988"));
        nameField.setBackground(Color.decode("#e9cfec"));
        nameField.setAlignmentX(Component.CENTER_ALIGNMENT);
        container.add(nameField);
        
        container.add(Box.createVerticalStrut(10)); // Add space

        // Password Label and Field
        passwordLabel = new JLabel("Password:");
        passwordLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        passwordLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        passwordLabel.setForeground(Color.decode("#e9cfec"));
        container.add(passwordLabel);
        
        container.add(Box.createVerticalStrut(10)); // Add space

        passwordField = new JPasswordField(20);
        passwordField.setMaximumSize(passwordField.getPreferredSize());
        passwordField.setForeground(Color.decode("#7a4988"));
        passwordField.setBackground(Color.decode("#e9cfec"));
        passwordField.setAlignmentX(Component.CENTER_ALIGNMENT);
        container.add(passwordField);

        container.add(Box.createVerticalStrut(10)); // Add space

        // Login Button
        loginButton = new JButton("Login");
        loginButton.setFont(new Font("Arial", Font.BOLD, 16));
        loginButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        loginButton.setBackground(Color.decode("#e9cfec"));
        loginButton.setForeground(Color.decode("#7a4988"));
        loginButton.addActionListener(this);
        container.add(loginButton);

        // Status Label
        statusLabel = new JLabel("");
        statusLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        statusLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        statusLabel.setPreferredSize(new Dimension(300, 40)); // specify a preferred size
        container.add(statusLabel);

        
        // Show the window
        setLocationRelativeTo(null);
        setVisible(true);
    }

   
    public void actionPerformed(ActionEvent e) {
    	
        if (e.getSource() == loginButton) {
        	
            // Get the name and password entered by the user
        	
            String name = nameField.getText();
            String password = new String(passwordField.getPassword());
            
            loginInfo = new String[]{name, password}; // To store the name and password the user entered

            // Validate the password
            boolean valid = isValidPassword(password);

            if (valid) {
          
              Dashboard dashboard = new Dashboard(name,password);
              
                        
                dispose(); // Closes the login form
                
            } else {
                // Show the password validation errors
                statusLabel.setForeground(Color.decode("#ff6961"));
                statusLabel.setText("Invalid password!");
            }
        }
    
    
   

    }
    
 public boolean isValidPassword(String password) {
        
        // Checks length
        if (password.length() < 8) {
            JOptionPane.showMessageDialog(null, "Password must be at least 8 characters long", "Password Invalid!", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
        
        // Checks for at least one uppercase letter
        
        boolean hasUppercase = false;
        
        for (int i = 0; i < password.length(); i++) {
            
            char c = password.charAt(i);
            if (c >= 'A' && c <= 'Z') {
                hasUppercase = true;
                break;
                
            }
        }
        if (!hasUppercase) {
            JOptionPane.showMessageDialog(null, "Password must contain at least one uppercase letter", "Password Invalid!", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
        
        // Checks for at least one lowercase letter
        
        boolean hasLowercase = false;
        
        for (int i = 0; i < password.length(); i++) {
            
            char c = password.charAt(i);
            if (c >= 'a' && c <= 'z') {
                hasLowercase = true;
                break;
                
            }
        }
        if (!hasLowercase) {
            JOptionPane.showMessageDialog(null, "Password must contain at least one lowercase letter", "Password Invalid!", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
        
        // Checks for at least one digit
        
        boolean hasDigit = false;
        
        for (int i = 0; i < password.length(); i++) {
            
            char c = password.charAt(i);
            if (c >= '0' && c <= '9') {
                hasDigit = true;
                break;
                
            }
        }
        if (!hasDigit) {
            JOptionPane.showMessageDialog(null, "Password must contain at least one digit", "Password Invalid!", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
        
        // Checks for special characters
        
        boolean hasSpecial = false;
        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);
            if (c == '@' || c == '#' || c == '$' || c == '%' || c == '&' || c == '*' || c == '+') {
                hasSpecial = true;
                break;
            }
        }
        if (!hasSpecial) {
            JOptionPane.showMessageDialog(null, "Password may contain special characters such as @, #, $, %, &, *, or +", "Password Invalid!", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
        
        // if all checks pass, the password is valid
        return true;
    }
    
    

    public static void main(String[] args) {
    	
        // Create and show the login form
        LoginForm loginForm = new LoginForm();
        loginForm.setVisible(true);
    }
}
    
    
 
