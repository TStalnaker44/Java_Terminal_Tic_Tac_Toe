
import java.util.Scanner;

class TicTacToeDriver{
 
  public static void main(String[] args){
    
    // Create a scanner object
    Scanner scan = new Scanner(System.in);
    
    // Make a new Tic-Tac-Toe Game
    TicTacToe game = new TicTacToe();
    
    // Create a boolean turn flag
    boolean turn = true; // Player one's turn
    
    // Declare the mark variable
    String mark;
    
    // Print the initial board state
    game.printBoard();
    
    // The Game Loop
    while (!game.isGameOver()){
      
      // Determine whose turn it is
      
      if (turn){mark="X";}
      else {mark="O";}
      
      System.out.printf("\n%s's Turn:\n", mark);
      
      // Collect move input from the user
      int row, column;
      while (true){
        
        // Prompt the user for their move
        System.out.println("What is your move?");
        System.out.print("Row: ");
        row = scan.nextInt();
        System.out.print("Column: ");
        column = scan.nextInt();
        
        // Check that the inputs are valid and available
        if (0 <= row && row <= 2 && 0 <= column && column <= 2){
          if (game.isFreeSpace(row, column)){
            break;
          }
          System.out.printf("Move (%d, %d) is not free\n", row, column);
        }
        else{
          System.out.printf("Move (%d, %d) is not valid\n", row, column);
        }
      }
      
      // Execute Player's move
      game.markSpace(row, column, mark);
      
      // Alternate player turns
      turn = !turn;
      
      // Print the new game state
      game.printBoard();
    }
    int winner = game.getWinner();
    if (winner == 0){
      System.out.println("It was a draw!");
    }
    else{
      if (winner == 1){mark="X";}
      else {mark="O";}
      System.out.printf("%s's Wins!\n", mark);
    }
  }
  
}