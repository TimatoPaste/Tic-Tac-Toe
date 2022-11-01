public class GameDriver{
	
	private GameState state;
	private Easyreader Names;
	private String Name1;
	private String Name2;
	
	public GameDriver(GameState initial){
		state = initial;
	}
	public void setUp(){
		System.out.print("Player 1: ");
		Name1=Names.readWord();
		System.out.print(/n"Player 2: ");
		Name2=Names.readWord();
	}
	/*
	get players' names from command line
	save into player variables
	construct a gameState(player x, player o);
	make moves
	*/
	public void play(){
		setUp();
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
}
