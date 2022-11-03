import java.util.ArrayList;
public interface GameState{
	public boolean isGameover();
	public Player getWinner();
	public Player getCurrentPlayer();
	public ArrayList<String> getCurrentMoves();
	public void makeMove(String move);
	public String toString();
}