import java.util.Scanner;
public class tictactoe
{
    int[][][] board = new int[3][3][2];
    int x ,o , turn , nogme ;
    Scanner in = new Scanner(System.in);
    public tictactoe() 
    {
        for (int i = 0 ; i<=2 ; i++)
        {
            for(int j = 0 ; j <=2 ; j++)
            {
                board[i][j][0] = 32;
                board[i][j][1] = 0;
            }
        }
        //bord initalised 
        // [][][0] is for players and [][][1] is for computer
        nogme=1;
        x=88;
        o=79;
        turn=0;
    }

    public int getinput(){
        if (turn%2==0){
            System.out.println("its is X's turn");
            int t = in.nextInt();
            return (t);
        }
        else{
            System.out.println("its is O's turn");
            int t = in.nextInt();
            return (t);
        }

    }

    public void updateboard(){

        //validate the turn
        if (turn >= 9){        
            if (turn != 100)
                System.out.println("the game is a draw!!");

            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println("Play Again?");
            System.out.println("1 for yes anything else for no");
            int t = in.nextInt();
            if(t == 1){
                nogme++;
                resetgame();
            }
            else
                System.exit(0);
        }

        int inpt = getinput() ;
        if (inpt == -1){
            startgame();
        }
        if (inpt==0)
            System.exit(0);
        if (inpt==101){
            turn = 12028;
            updateboard();

        }
        if (inpt==404)
            resetgame();

        //enter all break cases before this
        //the following will only be game state changes
        if (inpt>9 || inpt<0){
            System.out.println("invalid input please enter a valid value");
            updateboard();
        }

        int i= 0 ,j= 0;
        if(inpt<=3){
            j = inpt -1 ;
        }
        else if (inpt>3&&inpt<=6){
            i = 1;
            j = inpt - 4;
        }
        else if (inpt>6){
            i = 2;
            j = inpt - 7 ;
        }
        if (board[i][j][0] != 32){
            System.out.println("invalid input please enter a valid value");
            updateboard();
        }

        if ((turn%2)==0){
            board[i][j][0] = x;
            turn++;
            displayboard();
        }
        else{
            board[i][j][0] = o;
            turn++;
            displayboard();
        }

        if(checkwin()){
            if ((turn-1)%2==0){
                System.out.println("X wins");
            }
            else{
                System.out.println("O wins");
            }
            turn = 100;
        }

        updateboard();
    }

    public void displayboard(){

        System.out.println("current board");
        for (int i = 0 ; i<=2 ; i++)
        {
            for(int j = 0 ; j <=2 ; j++)
            {
                System.out.print("|" + ((char)board[i][j][0])) ;  
            }
            System.out.print("|"); 
            System.out.println();
            System.out.println("-------");
        }

    }

    public void resetgame(){
        for (int i = 0 ; i<=2 ; i++)
        {
            for(int j = 0 ; j <=2 ; j++)
            {
                board[i][j][0] = 32;
                board[i][j][1] = 0;
            }
        }
        turn=0;
        displayboard();
        updateboard();
    }

    public void startgame(){
        int t=1;

        System.out.println("This is a game of tic-tac-toe");
        System.out.println("Enter 0 to end the game");
        System.out.println("Enter -1 to for the rules again");
        System.out.println("Enter 101 to for a immediate draw");
        System.out.println("Enter 404 to reset the game");
        System.out.println("Enter board positions when asked as shown below");
        for (int i = 0 ; i<=2 ; i++)
        {
            for(int j = 0 ; j <=2 ; j++)
            {
                System.out.print("|" + t) ;  
                t++;
            }
            System.out.print("|"); 
            System.out.println();
            System.out.println("-------");
        }

        System.out.println("let the game begin!!");
        updateboard();

        System.out.println("no. of games played" + nogme + "turn" + turn);
    }

    public boolean checkwin(){
        // check left diognal
        if((board[0][0][0] == board[1][1][0] && board[1][1][0] == board[2][2][0]))
        {
            if(board[0][0][0] == 32){return(false);}else{return(true);}
        }
        // check right diognal
        if((board[0][2][0] == board[1][1][0] && board[2][0][0] == board[1][1][0]))
        {
            if(board[0][2][0]== 32){return(false);}else{return(true);}
        }
        // check first row
        if((board[0][0][0] == board[0][1][0] && board[0][2][0] == board[0][1][0]))
        {
            if(board[0][0][0]== 32){return(false);}else{return(true);}
        }
        //check second row
        if((board[1][0][0] == board[1][1][0] && board[1][2][0] == board[1][1][0]))
        {
            if(board[1][0][0]== 32){return(false);}else{return(true);}
        }
        //check third row
        if((board[2][0][0] == board[2][1][0] && board[2][2][0] == board[2][1][0]))
        {
            if(board[2][0][0]== 32){return(false);}else{return(true);}
        }
        //check first column
        if((board[0][0][0] == board[1][0][0] && board[2][0][0] == board[1][0][0]))
        {
            if(board[0][0][0]== 32){return(false);}else{return(true);}
        }
        //check second column
        if((board[0][1][0] == board[1][1][0] && board[2][1][0] == board[1][1][0]))
        {
            if(board[0][1][0]== 32){return(false);}else{return(true);}
        }
        //check third column
        if((board[0][2][0] == board[1][2][0] && board[2][2][0] == board[1][2][0]))
        {
            if(board[0][2][0]== 32){return(false);}else{return(true);}
        }

        return(false);
    }

    public static void main(String args[])
    {
        tictactoe ob = new tictactoe();
        ob.startgame();
    }

}