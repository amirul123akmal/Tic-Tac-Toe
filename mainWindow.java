// AWT imports
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
// SWING imports
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class mainWindow{
    // Global var to insert in ActionListener
    public class global{
        static int counter = 0;
        // Welcoming Message
        static String words[] = {"Welcome to Amirul's homemade Tic-Tac-Toe java games" , "This game is 2 players game" , "please enjoy..."};
    }

    // Main program starts here
    public static void main(String [] args){

        // Var init
        int delay = 1000; //milliseconds

        // JLabel
        JLabel welcoming = new JLabel();

        // Timer
        Timer timer = new Timer(delay, null);

        // Action Listener of event
        ActionListener task = new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                if(global.counter < 3){
                    welcoming.setText(global.words[global.counter]);
                    global.counter++;
                }
                else{
                    reqNameWindow name = new reqNameWindow();
                    name.start();
                    timer.stop();
                }
            }
        };

        // JButton
        JButton button = new JButton("test close");

        timer.addActionListener(task);
        timer.start();

        // Init the window & Frame
        JFrame window = new JFrame();
        JPanel frame = new JPanel();

        // Button's action Listener
        button.addActionListener(e -> {
            window.dispose();
        });

        // Frame Setting
        frame.setLayout(new BoxLayout(frame, BoxLayout.Y_AXIS));
        frame.setAlignmentX(Component.CENTER_ALIGNMENT);
        frame.setSize(500,100);
        
        // Frame add(s)
        frame.add(welcoming);
        frame.add(button);

        // Window add(s)
        window.add(frame);

        // Window Options:
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
        window.setBackground(Color.WHITE);
        window.setSize(800,600);
        window.setTitle("Tic Tac Toe by Amirul");
        window.setResizable(false);
    }

    
    
}
