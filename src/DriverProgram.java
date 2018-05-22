
public class DriverProgram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final int row = 3;
		final int column = 3;
		int numberOfTurns = row * column;
		User player1 = new Player();
		User player2 = new Player();
		BoardInterface playingBoard = new Board(row, column);
		playingBoard.addUser(player1);
		playingBoard.addUser(player2);
		playingBoard.placePlayerCall(player1);
		playingBoard.placePlayerCall(player2);
		while(numberOfTurns-- > 0 && playingBoard.findWinner()==-1) {
			playingBoard.placePlayerCall(player1);
			playingBoard.placePlayerCall(player2);
		}
		if(numberOfTurns == 0 && playingBoard.findWinner()==-1) {
			System.out.println("match is draw");
		}
		playingBoard.displayBoard();
	}

}
