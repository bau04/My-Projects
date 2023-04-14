package LoginForm;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Dashboard extends JFrame{
	
		private JFrame dashboardFrame;
	    private Color backgroundColor = Color.decode("#3c2268");
	    private Font WelcomelabelFont = new Font("Arial", Font.BOLD, 30);
	    private Font labelFont = new Font("Arial", Font.BOLD, 25);
	    private Font aboutMeFont = new Font("Arial", Font.PLAIN, 20);
	    private Font aboutMeContentFont = new Font("Arial", Font.PLAIN, 13);
	    private Color labelColor = Color.decode("#bca6cf");
	    private String username, password;
	    JLabel userName;
	   
	    
	    public Dashboard (String username, String password) {
	    	
	    	this.username = username;
	    	this.password = password;
	    	
	        // create the dashboard page
	        dashboardFrame = new JFrame("Dashboard");
	        dashboardFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        dashboardFrame.setSize(900, 750);
	        dashboardFrame.setLayout(new BorderLayout());
	        dashboardFrame.getContentPane().setBackground(backgroundColor);
	        dashboardFrame.setResizable(false);
	        
	        // create the top panel for the image
			JPanel topPanel = new JPanel(new BorderLayout());
			topPanel.setBackground(Color.decode("#3c2268"));

			// create the image label and add it to the top panel
			ImageIcon icon = new ImageIcon("dashboard.png");
			Image image = icon.getImage();
		    int width = 350; // set the desired width of the image
		    int height = 200; // set the desired height of the image
		    Image resizedImage = image.getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH);
		    ImageIcon resizedIcon = new ImageIcon(resizedImage);
		    JLabel imageLabel = new JLabel(resizedIcon);
		    imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
			
			topPanel.add(imageLabel, BorderLayout.CENTER);
			
			// add the top panel to the dashboard frame
			dashboardFrame.add(topPanel, BorderLayout.NORTH);

			imageLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 0)); //add space between the image and the welcome panel
	        
	     // create the welcome message panel
	        JPanel welcomePanel = new JPanel(new FlowLayout());
	        welcomePanel.setBackground(Color.decode("#3c2268"));

	        // create the welcome message label
	        JLabel welcomeLabel = new JLabel("Welcome to YourSpace, " + username + "!");
	        welcomeLabel.setFont(WelcomelabelFont);
	        welcomeLabel.setForeground(labelColor);

	        // set the alignment of the welcome label to center and bottom
	        welcomeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
	        welcomeLabel.setVerticalAlignment(SwingConstants.BOTTOM);

	        // add the welcome label to the welcome panel
	        welcomePanel.add(welcomeLabel);

			welcomePanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 0)); //add space between the welcome panel and the about me section

	        // create the about me section
	        JPanel aboutMePanel = new JPanel(new GridLayout(1, 2, 10, 0));
	        aboutMePanel.setBackground(Color.decode("#3c2268"));

	        // create the left part of the about me section
	        JPanel leftPanel = new JPanel();
	        leftPanel.setBackground(Color.decode("#bca6cf"));
	        leftPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // add some padding

	        JLabel aboutMeLeftLabel = new JLabel("<html>My Hobbies, Talents, and Achievements</html>");
	        aboutMeLeftLabel.setFont(aboutMeFont);
	        aboutMeLeftLabel.setForeground(Color.decode("#3c2268"));
	        aboutMeLeftLabel.setHorizontalAlignment(JLabel.LEFT); // center the label horizontally
	        aboutMeLeftLabel.setVerticalAlignment(JLabel.BOTTOM); // align the label text to the bottom

	        JTextArea aboutMeTextArea = new JTextArea("\nI enjoy engaging in various activities during my leisure time, including but not limited to reading, " //Hobbies
	        		+ "knitting, playing video games, and playing musical instruments."
	        		+ "\n\nI believe that I possess artistic abilities; however, I have not been able to fully explore and develop this talent. " // Talent
	        		+ "While I may have had a few opportunities to showcase my creativity, "
	        		+ "I feel that I have not yet reached my full potential."
	        		+ "\n\nI take great pride in my ongoing efforts to improve my communication skills, and I view this as a noteworthy achievement. " // Achievement
	        		+ "I also regard being awarded a scholarship as a significant accomplishment. "
	        		+ "This recognition not only provides me with financial assistance but also serves as a validation of my hard work.");
	        
	        aboutMeTextArea.setLineWrap(true);
	        aboutMeTextArea.setFont(aboutMeContentFont);
	        aboutMeTextArea.setForeground(Color.decode("#3c2268"));
	        aboutMeTextArea.setOpaque(false); // make the text area transparent
	        aboutMeTextArea.setEditable(false); // make the text area read-only
	        aboutMeTextArea.setLineWrap(true); // enable line wrapping

	        leftPanel.setLayout(new BorderLayout());
	        leftPanel.add(aboutMeLeftLabel, BorderLayout.NORTH);
	        leftPanel.add(Box.createVerticalStrut(20)); // add some vertical space between the label and text area
	        leftPanel.add(aboutMeTextArea, BorderLayout.CENTER);
	        
	        	        
	        
	        JPanel aboutMeContentPanel = new JPanel();
	        aboutMeContentPanel.setBackground(Color.decode("#bca6cf"));
	        aboutMeContentPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // add some padding

	        JLabel aboutMeContentLabel = new JLabel("About Me");
	        aboutMeContentLabel.setFont(labelFont);
	        aboutMeContentLabel.setForeground(Color.decode("#3c2268"));
	        aboutMeContentLabel.setHorizontalAlignment(JLabel.LEFT);
	        aboutMeContentLabel.setVerticalAlignment(JLabel.BOTTOM);

	        JTextArea aboutMeContentTextArea = new JTextArea("\nHi! My name is Natalie Lazaro, born on the 23rd of August 2003, and currently, I am a freshman pursuing a Bachelor of Science in Information Technology."
	        		+ "\n\nThe reason for my interest in this field is due to my fascination with technology and its evolution"
	        		+ "I believe that studying Information Technology will equip me with the skills and knowledge necessary to make significant contributions to the field in the future.");
	        aboutMeContentTextArea.setLineWrap(true);
	        aboutMeContentTextArea.setFont(aboutMeContentFont);
	        aboutMeContentTextArea.setForeground(Color.decode("#3c2268"));
	        aboutMeContentTextArea.setOpaque(false); // make the text area transparent
	        aboutMeContentTextArea.setEditable(false); // make the text area read-only

	        aboutMeContentPanel.setLayout(new BorderLayout());
	        aboutMeContentPanel.add(aboutMeContentLabel, BorderLayout.NORTH);
	        aboutMeContentPanel.add(Box.createVerticalStrut(20));
	        aboutMeContentPanel.add(aboutMeContentTextArea, BorderLayout.CENTER);

	        aboutMePanel.add(leftPanel);
	        aboutMePanel.add(aboutMeContentPanel);

	        
	        
	        
	        // create the right part of the about me section
	        JPanel rightPanel = new JPanel();
	        rightPanel.setBackground(Color.decode("#bca6cf"));
	        rightPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // add some padding

	        JLabel aboutMeRightLabel = new JLabel("<html>My Strengths and Weaknesses</html>");
	        aboutMeRightLabel.setFont(aboutMeFont);
	        aboutMeRightLabel.setForeground(Color.decode("#3c2268"));
	        aboutMeRightLabel.setHorizontalAlignment(JLabel.LEFT); // center the label horizontally
	        aboutMeRightLabel.setVerticalAlignment(JLabel.BOTTOM); // align the label text to the bottom

	        JTextArea aboutMeTextArea1 = new JTextArea("\nBeing a student, I find that I am more proficient in written communication as compared to verbal communication. "
	        		+ "\n\nThis is because I sometimes struggle with articulating my ideas effectively when speaking. "
	        		+ "However, I am continually working on improving my oral communication skills by practicing and seeking feedback from others. "
	        		+ "\n\nIn the meantime, I leverage my strength in writing to compensate for my weakness in speaking, and I have found that it has helped me effectively express my thoughts and ideas in various academic and personal settings.");
	        
	        aboutMeTextArea1.setLineWrap(true);
	        aboutMeTextArea1.setFont(aboutMeContentFont);
	        aboutMeTextArea1.setForeground(Color.decode("#3c2268"));
	        aboutMeTextArea1.setOpaque(false); // make the text area transparent
	        aboutMeTextArea1.setEditable(false); // make the text area read-only
	        aboutMeTextArea1.setLineWrap(true); // enable line wrapping

	        
	        rightPanel.add(aboutMeRightLabel);
	        
	        rightPanel.setLayout(new BorderLayout());
	        rightPanel.add(aboutMeRightLabel, BorderLayout.NORTH);
	        rightPanel.add(Box.createVerticalStrut(20)); // add some vertical space between the label and text area
	        rightPanel.add(aboutMeTextArea1, BorderLayout.CENTER);       
	        

	        // add the left and right parts of the about me section to the main panel
	        aboutMePanel.add(leftPanel);
	        aboutMePanel.add(rightPanel);

	        // create the dashboard panel
	        JPanel dashboardPanel = new JPanel(new BorderLayout());
	        dashboardPanel.add(welcomePanel, BorderLayout.NORTH);
	        dashboardPanel.add(aboutMePanel, BorderLayout.CENTER);

	        // add the dashboard panel to the dashboard frame
	        dashboardFrame.add(dashboardPanel);
      
	        
	        dashboardFrame.setVisible(true);
	        
	        
	}

		
}
