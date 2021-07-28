import java.io.PrintStream;

public class games {
    private static PrintStream print = System.out;
    String player1,player2;
    private char[] mapping[] = {
        {',',',',','},
        {',',',',','},
        {',',',',','}
    };

    void welcome(){
        // Welcome message
        print.println("Welcome to Amirul's homemade Tic-Tac-Toe java games");
        print.println("This game is 2 players game");
        print.println("please enjoy...");
    }

    void map(){
        print.println();
        for(int i = 0 ; i < 3 ; i++){
            print.println("--------");
            for (int j = 0 ; j < 3 ; j++){
                print.print("|" + mapping[i][j]);
            }
            print.print("|\n");
        }
        print.println("--------\n");
    }

    void clearConsole(){
        // get the cmd.exe
        //                                       app... command ...
        ProcessBuilder pb = new ProcessBuilder("cmd","/c","cls");

        //  pb.inheritIO() needed to be in try-catch
        
        // If dont want to use try-catch method  
        // https://stackoverflow.com/a/33379766/10613167
        try{
            Process start = pb.inheritIO().start();
            start.waitFor();
        }    
        catch(Exception e){
            print.print(e + "\nMaybe you are in Mac or any Linux Distribution\nSorry , I'm still not making it cross-compile :P ");
        }
    }

    private boolean checker(int pos){
        if(pos < 4 && (mapping[0][pos-1] == 'X' || mapping[0][pos-1] =='O')){
            return false;
        }
        else if((pos > 3 && pos < 7) && (mapping[1][pos-4] == 'X' || mapping[1][pos-4] =='O')){
            return false;
        }
        else if((pos > 6 && pos < 10) && (mapping[2][pos-7] == 'X' || mapping[2][pos-7] =='O')){
            return false;
        }
        return true;
    }

    void insert(int pos,short player){
        if(checker(pos)){
            if (player == 0){
                if(pos < 4){
                    mapping[0][pos-1] = 'X';
                }
                else if((pos > 3 && pos < 7)){
                    mapping[1][pos-4] = 'X';
                }
                else if((pos > 6)){
                    mapping[2][pos-7] = 'X';
                }
            }
            else{
                if(pos < 4 ){
                    mapping[0][pos-1] = 'O';
                }
                else if((pos > 3 && pos < 7)){
                    mapping[1][pos-4] = 'O';
                }
                else if((pos > 6)){
                    mapping[2][pos-7] = 'O';
                }
            }
        }
    }

    private int check_winner(){
        // X = 1
        // O = 2
        
        for (int i = 0 ; i < 3 ; i++ ){

            //                      Comparing Mapping value(s)                              Read the Value
            // Horizontal 
            if((mapping[i][0] == mapping[i][1] && mapping[i][1] == mapping[i][2] ) && ( mapping[i][2] == 'X' )){
                return 1;
            }
            if((mapping[i][0] == mapping[i][1] && mapping[i][1] == mapping[i][2] ) && ( mapping[i][2] == 'O' )){
                return 2;
            }

            // Vertical
            if((mapping[0][i] == mapping[1][i] && mapping[1][i] == mapping[2][i] ) && ( mapping[0][i] == 'X' )){
                return 1;
            }
            if((mapping[0][i] == mapping[1][i] && mapping[1][i] == mapping[2][i] ) && ( mapping[0][i] == 'O' )){
                return 2;
            }

            
        }

        // Diagonal
        // Top left to Bottom Right
        if((mapping[0][0] == mapping[1][1] && mapping[1][1] == mapping[2][2] ) && ( mapping[0][0] == 'X' )){
            return 1;
        }
        if((mapping[0][0] == mapping[1][1] && mapping[1][1] == mapping[2][2] ) && ( mapping[0][0] == 'O' )){
            return 2;
        }

        // Top Right to Bottom Left
        if((mapping[0][2] == mapping[1][1] && mapping[1][1] == mapping[2][0] ) && ( mapping[2][0] == 'X' )){
            return 1;
        }
        if((mapping[0][2] == mapping[1][1] && mapping[1][1] == mapping[2][0] ) && ( mapping[2][0] == 'O' )){
            return 2;
        }
        return 0;
    }

    void player_winner(int num){
        clearConsole();
        if (num == 1){
            print.println("\nCongratulations on " + player1 + " for wining ths round");
        }
        else{
            print.println("\nCongratulations on " + player2 + " for wining ths round");
        }
    }

    int winner(){
        int pointer = check_winner();
        if (pointer == 0){
            return 0;
        }
        else if (pointer == 1 || pointer == 2){
            player_winner(pointer);
            return 1;
        }
        return 0;
    }

}