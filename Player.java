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
  public String getNextMove (GameState state)
  { /* implementation not shown */ 
    //MUST return a valid move
    return state.getCurrentMoves().get(0);
  }
}
