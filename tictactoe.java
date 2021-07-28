import java.io.PrintStream;
import java.util.Scanner;

public class tictactoe{
    public static void main(String [] args){
        // initializing shortcuts whenever possible
        PrintStream print = System.out;

        // External class calling
        // new objects
        games game = new games();
        Scanner input = new Scanner(System.in);

        // Start
        game.welcome();

        // Req Player Name
        print.print("\nPlease insert your name:\n\nPlayer 1 ( X ) :");
        game.player1 = input.nextLine();
        print.print("Player 2 ( O ) :");
        game.player2 = input.nextLine(); 

        while(true){
            // Variable Initliaziation
            int pos; 
            short switcher = 0;
            int pointer;

            // the map
            game.map();         
            
            game.clearConsole();
            game.map();
            if(switcher == 0){
                print.print("\nPlease insert " + game.player1 + " ( X ) :\n");
            }
            else{
                print.print("\nPlease insert " + game.player2 + " ( Y ) :\n");
            }
            

            // Input Safety
            // If there are any error(s) , the game still could continue
            try{
                pos = input.nextInt();
                if (pos > 0 && pos < 10){
                    if (switcher == 0){
                        game.insert(pos, switcher);
                        switcher = 1;
                    }
                    else{
                        game.insert(pos, switcher);
                        switcher = 0;
                    }
                }
                else{
                    print.println("are you want to exit the game (y/n)?");
                    try{
                        if(input.nextLine() == "y"){
                            break;
                        }
                    }
                    catch(Exception b){
                        break;
                    }
                }
            }
            catch(Exception e){
                print.print(e + "\nYou need to enter a number between 1 and 10");
            }
            pointer = game.check_winner();
            if(pointer == 0){
                continue;
            }
            else if (pointer == 1){

            }
        }
        input.close();
    }
}