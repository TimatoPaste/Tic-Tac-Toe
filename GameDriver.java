import java.util.Scanner;
public class GameDriver{
	
	
	private GameState state;
	
	public GameDriver(GameState initial){
		state = initial;
	}
	
	/*
	get players' names from command line
	save into player variables
	construct a gameState(player x, player o);
	make moves
	*/
	public void play(){
		playGame();
	}
	public void playGame(){
		if(state.isGameover()){ //checks for winner or a draw
			if(state.getWinner()!=null)
				System.out.println(state.getWinner()+" wins!");
			else 
				System.out.println("Game ends in a draw");
			return;
		}
		
		Player current = state.getCurrentPlayer();
		System.out.println("current player is "+current);
		String nextMove = current.getNextMove(state);
		
		if(nextMove.equals("no move")){
			System.out.println("Player "+current+" has no move");
		}
		else{
			System.out.println("Player "+current +" makes move "+nextMove);
		}
		state.makeMove(nextMove);
		//recur

		playGame();
	}
	public static void main(String[] args){
		new GameDriver(Ttt.setup()).play();
	}
}
