// AWT imports
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
// IO imports
import java.io.PrintStream;

// SWING imports
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class mainWindow{
    public static void main(String [] args){
        PrintStream print = System.out;

        int delay = 1000; //milliseconds
        ActionListener task = new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                //...Perform a task...
                print.println("hai");
            }
        };

        // Init the window & Frame
        JFrame window = new JFrame();
        JPanel frame = new JPanel();

        // set the size of the windows
        // set the title of the window
        window.setSize(800,600);
        window.setTitle("Tic Tac Toe by Amirul");

        new Timer(delay, task).start();

        JLabel welcome = new JLabel("Welcome\n");
        JLabel haha = new JLabel("test second line");
        frame.add(welcome);
        frame.add(haha);

        // Close the java operation when the user clicked 'x' on the window
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Insert the frame into the panel
        window.add(frame);

        // Options:
        // to enabled if the user could see it or not
        window.setVisible(true);
        // to force disabled resizing capabilities
        window.setResizable(false);
    }

    
    
}
