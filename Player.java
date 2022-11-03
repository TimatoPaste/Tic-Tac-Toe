import java.util.Scanner;
public class Player{
  private String name; // name of this player
  public Player (String aName)
  { name = aName; }
  public String getName()
  { return name; }
  /** This implementation chooses the first valid move.
  * Ovenide this method in subclasses to define players with other strategies.
  * @param state the cunent state ofthe game; its curent player is this player.
  * @return a string representing the move chosen;
  * "no move" if no valid moves for the current player. */

  public String getNextMove (Gamestate state)
  { 
      Scanner er = new Scanner();
      System.out.println(state.toString());
      String move = er.next();
    
      // later put in error checking to see if the player made an invalid move
      // either incorrect format or an impossible move
      
       if(!state.getValidMoves().contains(move)){
        System.out.println("invalid move, try again");
        return getNextMove(state);
      }  
    
      if(!move.equals(""))
      {
          return move;
      }
    
     
    
      return "no move";
 
   }
}
