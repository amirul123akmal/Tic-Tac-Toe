import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class reqNameWindow {
    void start(){
        // Window Requirement
        JFrame window = new JFrame();
        JPanel frame = new JPanel();
        
        // Window Setting
        window.setTitle("Please insert your name");
        window.setSize(500,400);
        window.setBackground(Color.WHITE);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);

        // Frame Setting
        frame.setVisible(true);

        // Input by user using JTextField
        JTextField name1 = new JTextField(10);
        JTextField name2 = new JTextField(10);

        // JButton
        JButton enter = new JButton("Enter");

        // JLabel INIT
        JLabel player1 = new JLabel("Player 1 ( X ) :");
        JLabel player2 = new JLabel("Player 2 ( O ) :");

        // Add-ing Settings
        enter.addActionListener(e -> {
            window.dispose();
        });


        // Frame add(s)
        frame.add(player1);
        frame.add(name1);
        frame.add(player2);
        frame.add(name2);
        frame.add(enter);

        // Window add(s)
        window.add(frame);
    }   
}
