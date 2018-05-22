/**
 * 
 */

/**
 * @author Nishant Gupta
 *
 */
public class Player implements User{

	// players will have an incremental symbol. Eg. A will have 1 as its symbol, B will have 2 and so on...
	private static int count;
	
	private int symbol;
	
	Player() {
		this.setSymbol(++count) ;
	}
	
//	@Override
//	public int[] playTurn(final int rowLimit,final int columnLimit) {
//		// TODO Auto-generated method stub
////		List<int> playerTurnRowColumn = new ArrayList<int>();
////		playerTurnRowColumn.add((int)Math.floor(Math.random() * rowLimit));
////		playerTurnRowColumn.add((int)Math.floor(Math.random() * columnLimit));
//		int playerTurnRowColumn[] = {(int)Math.floor(Math.random() * rowLimit), (int)Math.floor(Math.random() * columnLimit)};
//		System.out.println("Player turn is : row = " + Math.floor(Math.random() * rowLimit) + " column = " + Math.floor(Math.random() * columnLimit));
//		return playerTurnRowColumn;
//	}

	public int getSymbol() {
		return symbol;
	}

	public void setSymbol(int symbol) {
		this.symbol = symbol;
	}

	@Override
	public int decideRow(int rowLimit) {
		// TODO Auto-generated method stub
		return (int)Math.floor(Math.random() * rowLimit);
	}

	@Override
	public int decideColumn(int columnLimit) {
		// TODO Auto-generated method stub
		return (int)Math.floor(Math.random() * columnLimit);
	}

}
