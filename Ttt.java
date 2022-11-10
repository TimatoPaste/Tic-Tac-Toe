import java.util.ArrayList;
import java.util.Scanner;
public class Ttt implements GameState{
  private Player x;
  private Player o;
  private Player current;
  public Ttt(Player x, Player o){
    this.x = x;
    this.o = o;
    current = x;
  }

  
  public static Ttt setup(){
    Scanner reader = new Scanner(System.in);
    System.out.println("Player One, enter your name: ");
    Player x = new Player(reader.nextLine().trim()+ " (x)");
    System.out.println("\nPlayer Two, enter your name: ");
    Player o = new Player(reader.nextLine().trim()+" (o)");
	System.out.print("\n");
    
    return new Ttt(x,o);
	
  }
  
   private String[][] state = {
    {"-", "-", "-"}, 
    {"-", "-", "-"},
    {"-", "-", "-"}
  };
  
  public boolean isGameover(){
   return getWinner() != null || getCurrentMoves().size()==0;
  }
  
  public Player getWinner(){
    //it is impossible to win without either having [0, 0], [1, 1], or [2, 2]
    //three ways to win: diagonal, vertical, horizontal
    Player potentialWinner = fromString(0, 0);
    if(potentialWinner != null){
      if(potentialWinner == fromString(1, 1) && potentialWinner ==fromString(2, 2))
        return potentialWinner;//diagonal
      if(potentialWinner == fromString(0, 1) && potentialWinner == fromString(0, 2))
        return potentialWinner;//vertical
      if(potentialWinner == fromString(1, 0)&& potentialWinner == fromString(2, 0))
        return potentialWinner;//horizontal
    }
	  
    potentialWinner = fromString(1, 1);
    if(potentialWinner != null){
      if(potentialWinner == fromString(2, 0) && potentialWinner ==fromString(0, 2))
        return potentialWinner;//diagonal
      if(potentialWinner == fromString(1, 0) && potentialWinner == fromString(1, 2))
        return potentialWinner;//vertical
      if(potentialWinner == fromString(0, 1)&& potentialWinner == fromString(2, 1))
        return potentialWinner;//horizontal
    }
    potentialWinner = fromString(2, 2);
    if(potentialWinner != null){
      if(potentialWinner == fromString(2, 0) && potentialWinner == fromString(2, 1))
        return potentialWinner;//vertical
      if(potentialWinner == fromString(0, 2)&& potentialWinner == fromString(0, 1))
        return potentialWinner;//horizontal
    }
    return null;
  }
  
  
  public Player getCurrentPlayer(){
    return current;
  }
  
  public ArrayList<String> getCurrentMoves(){
    ArrayList<String> result = new ArrayList<String>();
    for(int i = 0; i<state.length; i++)
      for(int j = 0; j<state.length; j++)
        if(state[i][j].equals("-"))
          result.add(i+" "+j);
    return result;
  }
  
  public int[] stringMoveToIntMove(String move){
    String[] moveS = move.split(" ");
    int[] moveI = {Integer.parseInt(moveS[0]),Integer.parseInt(moveS[1])};
    return moveI;
  }
  
  public void makeMove(String move){

    int[] latestMove = stringMoveToIntMove(move);

    if(state[latestMove[0]][latestMove[1]].equals("-")){

      if(getCurrentPlayer() == x){
        state[latestMove[0]][latestMove[1]] = "x";
      }
      if(getCurrentPlayer() == o){
        state[latestMove[0]][latestMove[1]] = "o";
      }
      togglePlayers();
    }
    else{
      System.out.println("NOOOOOOOOOOOOOOOOOOO");//test
    }
  }
  
  public String toString(){
    String outputS = "";
    for(String[] r:state){
      for(String c:r){
        outputS += c+" ";
      }
      outputS += "\n";
    }
    return outputS;
  }
  
  //helper methods
  private Player fromString(String s){
    if(s.toUpperCase().equals("X"))
       return x;
    if(s.toUpperCase().equals("O"))
       return o;
    return null;//a blank string
  }
  private void togglePlayers(){
    if(current == x)
      current = o;
    else if(current == o)
      current = x;
    else System.out.println("error with player names");
  }
  private Player fromString(int a, int b){
    return fromString(state[a][b]);
  }
}
