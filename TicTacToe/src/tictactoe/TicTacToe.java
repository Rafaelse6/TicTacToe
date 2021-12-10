
package tictactoe;

import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

   
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
       
        char[][] board = {{' ', ' ', ' ',}, {' ', ' ', ' ',}, {' ', ' ', ' '}};
        
        printBoard(board);
        
        while(true){
            playerTurn(board, scanner);
            if (isGameFinished(board)){
                break;
            }
            printBoard(board);
            computerTurn(board);
            if(isGameFinished(board)){
             break;   
            }
            printBoard(board);
        }
        
       scanner.close();
    }   

    private static boolean isGameFinished(char[][] board){
        
        if(hasConstestantWon(board,'X')){
            
            printBoard(board);
            System.out.println("Player Wins! ");
            return true;
        }
        
         if(hasConstestantWon(board,'O')){
            
            printBoard(board);
            System.out.println("Computer Wins! ");
            return true;
        }
        
               
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                if(board[i][j] == ' '){
                    return false;
                }
                
            }
        }
        
        printBoard(board);
        System.out.println("The game ended in a tie!");
        return true;
    }

    private static boolean hasConstestantWon(char[][] board, char symbol) {
        if (board [0][0] == symbol && board [0][1] == symbol && board [0][2] == symbol || board[1][0] == symbol && board[1][1] == symbol && board[1][2] == symbol
                || board[2][0] == symbol && board[2][1] == symbol && board[2][2] == symbol || board[0][0] == symbol && board[1][0] == symbol && board[2][0] == symbol
                || board[0][1] == symbol && board[1][1] == symbol && board[2][1] == symbol || board[0][2] == symbol && board[1][2] == symbol && board[2][2] == symbol
                || board[0][0] == symbol && board[1][1] == symbol && board[2][2] == symbol || board[0][2] == symbol && board[1][1] == symbol && board[2][0] == symbol) {
            return true;
        }
        return false;
    }
    
    private static void computerTurn(char[][] board) {
        Random rand = new Random();
        
        int computerPlay;
        
        while(true){
            computerPlay = rand.nextInt(9) + 1;
            if (isValidMove(board, Integer.toString(computerPlay))){
                break;
            }
            
        }
        System.out.println("The computer move is: " + computerPlay);
        placeMove(board,Integer.toString(computerPlay), 'O');
    }   
    
    private static boolean isValidMove(char [][] board, String position){
        
         switch(position){
            case "1":
               return (board[0][0] == ' ');
                 
            case "2":
               return ( board[0][1] == ' ');
               
            case "3":
                return (board[0][2] == ' ');
                
            case "4":
                return (board[1][0] == ' ');
                
            case "5":
               return (board[1][1] == ' ');
               
            case "6":
               return (board[1][2] == ' ');
                
            case "7":
                return (board[2][0] == ' ');
                
            case "8":
               return (board[2][1] == ' ');
                
            case "9":
               return  (board[2][2] == ' ');
               
            
            default:
              return false;
        }
      
    }
        
        
    

    private static void playerTurn(char[][] board, Scanner scanner) {
        String userInput;
        while(true){
            System.out.println("Where would you like to play? (1-9)");

            userInput = scanner.nextLine();
            if(isValidMove(board, userInput)){
                break;
            }else{
                System.out.println("It's not a valid move, try again");
            }
        }
          placeMove(board, userInput, 'X');
    }   

    private static void placeMove(char[][] board, String userInput, char symbol) {
        switch(userInput){
            case "1":
                board[0][0] = symbol;
                break;
            case "2":
                board[0][1] = symbol;
                break;
            case "3":
                board[0][2] = symbol;
                break;
            case "4":
                board[1][0] = symbol;
                break;
                
            case "5":
                board[1][1] = symbol;
                break;
                
            case "6":
                board[1][2] = symbol;
                break;
            
            case "7":
                board[2][0] = symbol;
                break;
            
            case "8":
                board[2][1] = symbol;
                break;
                
            case "9":
                board[2][2] = symbol;
                break;
            
            default:
                System.out.println("Nothing was typped or a different number was typped, try again");
        }
    }   

    private static void printBoard(char[][] board) {
        System.out.println(board[0][0] + "|" + board [0][1] + "|" + board [0][2]);
        System.out.println("-+-+-");
        System.out.println(board[1][0] + "|" + board [1][1] + "|" + board [1][2]);
        System.out.println("-+-+-");
        System.out.println(board[2][0] + "|" + board [2][1] + "|" + board [2][2]);
    }   
    
}
