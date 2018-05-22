/**
 * 
 */

/**
 * @author Nishant Gupta
 *
 */
public interface User {
//	public void playTurn(final int rowLimit,final int columnLimit);
	public int decideRow(final int rowLimit);
	public int decideColumn(final int columnLimit);
	public int getSymbol();
}
