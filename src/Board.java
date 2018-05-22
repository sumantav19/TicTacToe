/**
 * 
 */

/**
 * @author Nishant Gupta
 *
 */
import java.util.*;
public class Board implements BoardInterface{

	private int row;
	private int column;
	private List<User> usersInGame;
	private int winnerSymbol;
//	private List<ArrayList<BoardInterface>> playBoard; 
	private int[][] playBoard;
	
	Board(int aRow,int aColumn /*, BoardInterface aPlayBoard*/ ){
		this.setRow(aRow);
		this.setColumn(aColumn);
		setUsersInGame(new ArrayList<User>());
		playBoard = new int[row][column];
		for(int i=0; i<row ; ++i) {
			for(int j =0; j<column; ++j) {
				playBoard[i][j] = -1;
			}
		}
//		this.playBoard = new ArrayList<ArrayList<BoardInterface>>();
	}
	
	@Override
	public int findWinner() {
		// TODO Auto-generated method stub
		int rowColDifference;
		rowColDifference = ( this.getRow() > this.getColumn() ) ? ( this.getRow() - this.getColumn() ) : ( this.getColumn() - this.getColumn() );
		int rowTemp = this.getRow();
		int columnTemp = this.getColumn();
		int winningUser = -1;
		int columnsMatched = 0;
		
		
		while(--rowTemp >= 0) {//check for same player places accross rows
			columnsMatched = 0 ;
			int iteratorColumn = this.getColumn();
			int previousValue = -1 ;// intializing previous value to match with the next value
			while(--iteratorColumn >= 0) {
				int currentValue = playBoard[rowTemp][iteratorColumn];
				if(previousValue == -1) {
					previousValue = currentValue;
				}
				if(currentValue != -1 && currentValue == previousValue) {
					++columnsMatched;
					winningUser = currentValue;
				}
				previousValue = playBoard[rowTemp][iteratorColumn];
			}
			if(columnsMatched == this.getColumn()) {// player has won
				return winningUser;
			}
		}
		
		rowTemp = this.getRow();
		columnTemp = this.getColumn();
		int rowsMatched = 0;
		
		while(--columnTemp >= 0) {//check for same player places accross columns
			rowsMatched = 0 ;
			int iteratorRow = this.getRow();
			int previousValue = -1 ;// intializing previous value to match with the next value
			while(--iteratorRow >= 0) {
				int currentValue = playBoard[iteratorRow][columnTemp];
				if(previousValue == -1) {
					previousValue = currentValue;
				}
				if(currentValue != -1 && currentValue == previousValue) {
					++rowsMatched;
					winningUser = currentValue;
				}
				previousValue = playBoard[iteratorRow][columnTemp];
			}
			if(rowsMatched == this.getColumn()) {// player has won
				return winningUser;
			}
		}

		
		return -1;
//		while(--columnTemp >= 0) {//check for winner for columns
//			
//		}
	}
	
	

	@Override
	public void addUser(final User aUser) {
		// TODO Auto-generated method stub
		usersInGame.add(aUser);
	}

	public List<User> getUsersInGame() {
		return usersInGame;
	}

	public void setUsersInGame(List<User> usersInGame) {
		this.usersInGame = usersInGame;
	}

	public int getColumn() {
		return column;
	}

	public void setColumn(int column) {
		this.column = column;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getWinnerSymbol() {
		return winnerSymbol;
	}

	public void setWinnerSymbol(int winnerSymbol) {
		this.winnerSymbol = winnerSymbol;
	}

	@Override
	public void displayBoard() {
		// TODO Auto-generated method stub
		for(int i=0; i<row ; ++i) {
			for(int j =0; j<column; ++j) {
				System.out.print(" " + playBoard[i][j] + " ");
			}
			System.out.print("\n");
		}
	}

	@Override
	public void placePlayerCall(User player) {
		// TODO Auto-generated method stub
		boolean placedCallSuccessfully = false;
		while(!placedCallSuccessfully) {
			int playerRow = player.decideRow(row);
			int playerColumn = player.decideColumn(column);
			if(playBoard[playerRow][playerColumn] == -1) {
				playBoard[playerRow][playerColumn] = player.getSymbol();
				placedCallSuccessfully = true;
			}
		}
		if(findWinner()!=-1) {
			System.out.println("the winner is player" + findWinner());
		}
	}
	
}
