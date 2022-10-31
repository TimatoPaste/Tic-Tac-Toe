public class Ttt implements GameState{
  private int[] latestMove;
  boolean isGameOver(){
    if(getWinner() == null){
      return false;
    }
    //checks for draws
    for(String a:state){
      if(a.equals(" ")){
        return false;
      }
    }
    return true;
  }
  
  Player getWinner(){}
  
  Player getCurrentPlayer(){}
  
  ArrayList<String> getCurrentMoves(){}
  
  int[] stringMoveToIntMove(String move){
    String[] moveS = move.split(" ");
    int[] moveI = {Integer.parseInt(moveS[0]),Integer.parseInt(moveS[1])};
    return moveI;
  }
  
  void makeMove(String move){
    latestMove = stringMoveToIntMove(move);
    if(state[latestMove[0],latestMove[1]].equals(" ")){
      if(getCurrentPlayer() == x){
        state[latestMove[0],latestMove[1]] = "x";
      }
      if(getCurrentPlayer() == o){
        state[latestMove[0],latestMove[1]] = "o";
      }
    }
    else{
      System.out.println("NOOOOOOOOOOOOOOOOOOO");//test
    }
  }
  
  String toString(){}
}
