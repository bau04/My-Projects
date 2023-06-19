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

public class AdminWindow implements ActionListener{


    JFrame AdminWindowFrame = new JFrame();  
    JPanel AdminPanel = new JPanel();

    String usersDataBase = "users.txt";

    JButton addStock1 = new JButton();
    JButton addStock2 = new JButton();
    JButton addStock3 = new JButton();
    JButton addStock4 = new JButton();
    JButton addStock5 = new JButton();

    JButton removeStock1 = new JButton();
    JButton removeStock2 = new JButton();
    JButton removeStock3 = new JButton();
    JButton removeStock4 = new JButton();
    JButton removeStock5 = new JButton();

    Border emptyborder = BorderFactory.createEmptyBorder();


    AdminWindow() {  

        AdminWindowFrame.setSize(1200, 800);
        AdminWindowFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        AdminWindowFrame.setResizable(false);
        AdminWindowFrame.setLocationRelativeTo(null);

        addStock1.setBounds(0,0 , 115, 30);
        addStock1.setFocusable(false);
        addStock1.addActionListener(this);
        addStock1.setLocation(100, 300);
        addStock1.setBackground(Color.red);
        addStock1.setForeground(Color.white);
        addStock1.setBorder(emptyborder);

        removeStock1.setBounds(0,0 , 115, 30);
        removeStock1.setFocusable(false);
        removeStock1.addActionListener(this);
        removeStock1.setLocation(100, 300);
        removeStock1.setBackground(Color.red);
        removeStock1.setForeground(Color.white);
        removeStock1.setBorder(emptyborder);


        addStock2.setBounds(0,0 , 115, 30);
        addStock2.setFocusable(false);
        addStock2.addActionListener(this);
        addStock2.setLocation(100, 400);
        addStock2.setBackground(Color.red);
        addStock2.setForeground(Color.white);
        addStock2.setBorder(emptyborder);

        removeStock1.setBounds(0,0 , 115, 30);
        removeStock1.setFocusable(false);
        removeStock1.addActionListener(this);
        removeStock1.setLocation(100, 300);
        removeStock1.setBackground(Color.red);
        removeStock1.setForeground(Color.white);
        removeStock1.setBorder(emptyborder);


        addStock3.setBounds(0,0 , 115, 30);
        addStock3.setFocusable(false);
        addStock3.addActionListener(this);
        addStock3.setLocation(100, 500);
        addStock3.setBackground(Color.red);
        addStock3.setForeground(Color.white);
        addStock3.setBorder(emptyborder);

        removeStock1.setBounds(0,0 , 115, 30);
        // removeStock1.setFocusable(false);
        removeStock1.addActionListener(this);
        removeStock1.setLocation(100, 300);
        removeStock1.setBackground(Color.red);
        removeStock1.setForeground(Color.white);
        removeStock1.setBorder(emptyborder);


        addStock4.setBounds(0,0 , 115, 30);
        addStock4.setFocusable(false);
        addStock4.addActionListener(this);
        addStock4.setLocation(100, 600);
        addStock4.setBackground(Color.red);
        addStock4.setForeground(Color.white);
        addStock4.setBorder(emptyborder);

        addStock1.setBounds(0,0 , 115, 30);
        addStock1.setFocusable(false);
        addStock1.addActionListener(this);
        addStock1.setLocation(100, 300);
        addStock1.setBackground(Color.red);
        addStock1.setForeground(Color.white);
        addStock1.setBorder(emptyborder);


        addStock5.setBounds(0,0 , 115, 30);
        addStock5.setFocusable(false);
        addStock5.addActionListener(this);
        addStock5.setLocation(100, 700);
        addStock5.setBackground(Color.red);
        addStock5.setForeground(Color.white);
        addStock5.setBorder(emptyborder);

        addStock1.setBounds(0,0 , 115, 30);
        addStock1.setFocusable(false);
        addStock1.addActionListener(this);
        addStock1.setLocation(100, 300);
        addStock1.setBackground(Color.red);
        addStock1.setForeground(Color.white);
        addStock1.setBorder(emptyborder);

        AdminWindowFrame.add(AdminPanel);


        AdminPanel.add(addStock1);
        AdminPanel.add(addStock2);
        AdminPanel.add(addStock3);
        AdminPanel.add(addStock4);
        AdminPanel.add(addStock5);

        AdminPanel.setLayout(null);
        AdminPanel.setBackground(Color.black);


        AdminWindowFrame.setVisible(true);
         
    }



    public void actionPerformed(ActionEvent e){  

    }  
}
