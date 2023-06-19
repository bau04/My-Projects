import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.Border;

public class LaunchPage implements ActionListener{
    
    JFrame LaunchPageFrame = new JFrame();
    JButton registerButton = new JButton("Register");
    JButton loginButton = new JButton("Sign in");
    JButton exitButton = new JButton("Exit");
    JButton guestButton = new JButton("Continue as guest ");
    JButton adminButton = new JButton("Continue as Admin");

    JPanel upPanel = new JPanel();
    JPanel lowPanel = new JPanel();

    Border emptyborder = BorderFactory.createEmptyBorder();

    JLabel label = new JLabel("Online Greenhills");
    JLabel text1 = new JLabel("Unlimited choices of Computer Parts and");
    JLabel text2 = new JLabel("more");
    JLabel text3 = new JLabel("Shop anywhere. shop Anytime.");

    LaunchPage(){

        LaunchPageFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        LaunchPageFrame.setSize(1200, 800);
        LaunchPageFrame.setLayout(null);
        LaunchPageFrame.setVisible(true);
        LaunchPageFrame.setResizable(false);
        LaunchPageFrame.setLocationRelativeTo(null);

        loginButton.setBounds(0,0 , 100, 30);
        loginButton.setFocusable(false);
        loginButton.addActionListener(this);
        loginButton.setLocation(1050, 25);
        loginButton.setBackground(Color.red);
        loginButton.setForeground(Color.white);
        loginButton.setBorder(emptyborder);

        registerButton.setBounds(0,0 , 100, 30);
        registerButton.setFocusable(false);
        registerButton.addActionListener(this);
        registerButton.setLocation(540, 390);
        registerButton.setBackground(Color.red);
        registerButton.setForeground(Color.white);
        registerButton.setBorder(emptyborder);

        guestButton.setBounds(0,0 , 115, 30);
        guestButton.setFocusable(false);
        guestButton.addActionListener(this);
        guestButton.setLocation(415, 700);
        guestButton.setBackground(Color.red);
        guestButton.setForeground(Color.white);
        guestButton.setBorder(emptyborder);
        guestButton.setFont(new Font("Arial", Font.BOLD, 10));;

        exitButton.setBounds(0,0 , 115, 30);
        exitButton.setFocusable(false);
        exitButton.addActionListener(this);
        exitButton.setLocation(550, 700);
        exitButton.setBackground(Color.red);
        exitButton.setForeground(Color.white);
        exitButton.setBorder(emptyborder);

        adminButton.setBounds(0,0 , 115, 30);
        adminButton.setFocusable(false);
        adminButton.addActionListener(this);
        adminButton.setLocation(680, 700);
        adminButton.setBackground(Color.red);
        adminButton.setForeground(Color.white);
        adminButton.setBorder(emptyborder);


        label.setFont(new Font("Verdana", Font.ROMAN_BASELINE, 36));
        label.setBounds(30,20 , 800, 46);
        label.setForeground(Color.red);

        text1.setFont(new Font("Verdana", Font.BOLD, 36));
        text1.setBounds(175,250 , 900, 40);
        text1.setForeground(Color.white);

        text2.setFont(new Font("Verdana", Font.BOLD, 36));
        text2.setBounds(536,300 , 300, 40);
        text2.setForeground(Color.white);

        text3.setFont(new Font("Verdana", Font.PLAIN, 18));
        text3.setBounds(450,340 , 500, 40);
        text3.setForeground(Color.white);

        upPanel.setLayout(null);
        upPanel.setBackground(Color.white);
        upPanel.setBounds(0, 0, 1200, 75);

        lowPanel.setLayout(null);
        lowPanel.setBackground(Color.black);
        lowPanel.setBounds(0, 75, 1200, 800);


        LaunchPageFrame.add(label);
        LaunchPageFrame.add(text1);
        LaunchPageFrame.add(text2);
        LaunchPageFrame.add(text3);
        LaunchPageFrame.add(adminButton);
        LaunchPageFrame.add(registerButton);
        LaunchPageFrame.add(loginButton);
        LaunchPageFrame.add(exitButton); 
        LaunchPageFrame.add(guestButton); 
        LaunchPageFrame.add(upPanel);
        LaunchPageFrame.add(lowPanel);



    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == registerButton){
            LaunchPageFrame.dispose();
            RegisterWindow registerWindow = new RegisterWindow();
        }

        else if(e.getSource() == loginButton){
            LaunchPageFrame.dispose();
            LoginWindow loginWindow = new LoginWindow();
        }

        if (e.getSource() == guestButton){
            LaunchPageFrame.dispose();

            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    ShoppingApp app = new ShoppingApp();
                    app.setVisible(true);
                }
            });
        }

        if (e.getSource() == adminButton){
            LaunchPageFrame.dispose();
            AdminWindow adminWindow = new AdminWindow();
        }

        else if(e.getSource() == exitButton){
            LaunchPageFrame.dispose();
        }

    }

    public void setVisible(boolean b) {
    }
}
