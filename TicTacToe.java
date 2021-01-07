class TicTacToe{
 
  private String[][] ticTacToe = {{" ", " ", " "},
                                  {" ", " ", " "},
                                  {" ", " ", " "}};
  
  public boolean isFreeSpace(int row, int column){
    return ticTacToe[row][column].equals(" ");
  }
  
  public void markSpace(int row, int column, String mark){
    ticTacToe[row][column] = mark;
  }
  
  public void reset(){
    for (int row=0; row < ticTacToe.length; row++){
      for (int column=0; column < ticTacToe[0].length; column++){
        ticTacToe[row][column] = " ";
      }
    }
  }
  
  public boolean isGameOver(){
    if (getWinner() != 0){return true;}
    for (String[] row : ticTacToe){
      for (String entry : row){
        if (entry.equals(" ")){
          return false;
        }
      }
    }
      return true;
  }
  
  public int getWinner(){
    
    // Check for three across
    for (String[] row : ticTacToe){
      int xCount = 0;
      int oCount = 0;
      for (String entry : row){
        if (entry.equals("X")){
          xCount += 1;
        }
        else if (entry.equals("O")){
          oCount += 1;
        }
      }
      if (xCount == 3){return 1;}
      if (oCount == 3){return 2;}
    }
    
    // Check for three down
    for (int column=0; column < ticTacToe[0].length; column++){
      int xCount = 0;
      int oCount = 0;
      for (int row=0; row < ticTacToe.length; row++){
        String entry = ticTacToe[row][column];
        if (entry.equals("X")){
          xCount += 1;
        }
        else if (entry.equals("O")){
          oCount += 1;
        }
      }
      if (xCount == 3){return 1;}
      if (oCount == 3){return 2;}
    }
    
    // Check for three on the down diagonal
    int xCount = 0;
    int oCount = 0;
    for (int x=0; x < ticTacToe.length; x++){
      String entry = ticTacToe[x][x];
      if (entry.equals("X")){
         xCount += 1;
      }
      else if (entry.equals("O")){
         oCount += 1;
      }
    }
    if (xCount == 3){return 1;}
    if (oCount == 3){return 2;}
    
    // Check for three on the up diagonal
    xCount = 0;
    oCount = 0;
    for (int row=0; row < ticTacToe.length; row++){
      int column = (ticTacToe.length - 1) - row;
      String entry = ticTacToe[row][column];
      if (entry.equals("X")){
         xCount += 1;
      }
      else if (entry.equals("O")){
         oCount += 1;
      }
    }
    if (xCount == 3){return 1;}
    if (oCount == 3){return 2;}
    
    return 0;
  }
  
  public void printBoard(){
    for (int row=0; row < ticTacToe.length; row++){
      for (int column=0; column < ticTacToe[row].length; column++){
        System.out.print(ticTacToe[row][column]);
        if (column < ticTacToe[row].length-1){
          System.out.print("|");
        }
      }
      if (row < ticTacToe.length-1){
        System.out.println("\n-----");
      }
    }
    System.out.println();
  }
}