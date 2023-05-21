import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;  

public class GUI implements ActionListener{

    int count = 0;
    JLabel label, prompt, target, label2;
    JFrame frame;
    JButton button;
    JPanel panel;

    public GUI() {

        frame = new JFrame();

        button = new JButton("Click Me");
        button.addActionListener(this);

        label = new JLabel("Number of clicks: 0");
        label2 =new JLabel("Program will end at 50 clicks");
        prompt = new JLabel();
        target = new JLabel();

        panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(30, 10, 30, 10));
        panel.setLayout(new GridLayout(0, 1));
        panel.add(button);
        panel.add(label);
        panel.add(label2);
        panel.add(prompt);
        panel.add(target);

        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Our GUI");
        frame.pack();
        frame.setVisible(true);

    }

    public static void main(String[] args) throws Exception {
        new GUI();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        count++;
        label.setText("Number of clicks: " + count);
        // label2.setText("Program will end at 50 clicks");

        if (count < 10) {
            target.setText("Next Target: 10");
        }

        if (count >= 10 && count < 20) {
            target.setText("Next Target: 20");
        }


        if (count >= 10){
            prompt.setText("Congratulations you hit 10 clicks");;
        }

        if (count >= 20){
            prompt.setText("Congratulations you hit 20 clicks");;
        }

        if (count == 50){
            System.exit(0);
        }

    }
}
