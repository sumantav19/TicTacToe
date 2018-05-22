/**
 * 
 */

/**
 * @author Nishant Gupta
 *
 */
public interface BoardInterface {
	int findWinner();
	void addUser(final User aUser);
	void placePlayerCall(User player); // places call for player till it finds a suitable match in the board to place.
	void displayBoard();// remove from here later based on single responsibility principle as displaing is not a responsibility of the board class object
}
