public class GameDriver{
	private GameState state;
	public GameDriver(GameState initial){state = initial;}
	public void play(){
		// System.out.println("playing");
		//part(b)
		//base case
		if(state.isGameover()){
			if(state.getWinner()!=null)
				System.out.println(state.getWinner()+" wins!");
			else 
				System.out.println("Game ends in a draw");
			return;
		}
		Player current = state.getCurrentPlayer();
		System.out.println("current player is "+current);
		String nextMove = current.getNextMove(state);
		if(nextMove.equals("no move"))
			System.out.println("Player "+current+" has no move");
		else
			System.out.println("Player "+current +" makes move "+nextMove);
		state.makeMove(nextMove);
		//recur
		play();
	}
	public static void main(String[] args){
		new GameDriver().play();
	}
}
