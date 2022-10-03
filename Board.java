
public class Board {

	private final int NUM_OF_COLUMNS = 7;
	private final int NUM_OF_ROW = 6;
	private char[][] board = new char[NUM_OF_ROW][NUM_OF_COLUMNS];
	//private boolean check;
	
	/* 
	 * The board object must contain the board state in some manner.
	 * You must decide how you will do this.
	 * 
	 * You may add addition private/public methods to this class is you wish.
	 * However, you should use best OO practices. That is, you should not expose
	 * how the board is being implemented to other classes. Specifically, the
	 * Player classes.
	 * 
	 */
	
	public Board() {

		for (int i = 0; i < NUM_OF_ROW; i++){
			for (int j = 0; j < NUM_OF_COLUMNS; j++){
				board[i][j] = ' ';
			}
		}

	}
	
	public boolean allowed(int column){
		if (board[0][column - 1] != ' '){
			return false;
		}
		
		return true;
	}
	
	
	public void setValue(int input, char symbol) {
		
		for (int i = board.length - 1; i >= 0; i--){
			if(board[i][input - 1] == ' '){
				board[i][input - 1] = symbol;
				break;
			}
		}
	}
	
	
	public void printBoard() {
		for (int i = 0; i < NUM_OF_ROW; i++){
			System.out.print("|");
			for (int j = 0; j < NUM_OF_COLUMNS; j++){
				System.out.print(board[i][j]);
				System.out.print("|");
			}
			System.out.println();
		}
		
	}
	
	
	
	public boolean containsWin() {
		if (containsHorizontal() == true || containsVertical() == true 
				|| containsDiagonal() == true ) {
			return true;
		}
		else {
			return false;
		}
	}
	

	
	public boolean containsHorizontal() {
		for(int i = 0; i<NUM_OF_ROW; i++){
			for (int j = 0;j < NUM_OF_COLUMNS - 3;j++){
				if (board[i][j] == board[i][j+3] && 
					board[i][j+1] == board[i][j+3] && 
					board[i][j+2] == board[i][j+3] &&
					board[i][j+3] != ' ' )
					{
					return true;
				}
			}			
		}
		return false;
	}
	
	public boolean containsVertical() {
		for(int i = 0; i < NUM_OF_ROW - 3; i++){
			for(int j = 0; j < NUM_OF_COLUMNS; j++){
				if (board[i][j] == board[i+3][j]   && 
				    board[i+1][j] == board[i+3][j] &&
					board[i+2][j] == board[i+3][j] &&
					board[i+3][j] != ' ')
					{
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean containsDiagonal() {
		for(int i = 3; i < NUM_OF_ROW; i++){
			for(int j = 0; j < NUM_OF_COLUMNS - 3; j++){
				if (board[i][j] == board[i-3][j+3]   && 
					board[i-1][j+1] == board[i-3][j+3] &&
					board[i-2][j+2] == board[i-3][j+3] &&
					board[i-3][j+3] != ' ')
					{
					return true;
				}
			}
		}
		for(int i = 0; i < NUM_OF_ROW - 3; i++){
			for(int j = 0; j < NUM_OF_COLUMNS - 3; j++){
				if (board[i][j] == board[i+3][j+3] && 
				    board[i+1][j+1] == board[i+3][j+3] &&
					board[i+2][j+2] == board[i+3][j+3] &&
					board[i+3][j+3] != ' ')
					{
					return true;
				}
			}
		}
		return false;
	}
	
	
	
	public boolean isTie() {
		if (board[0][0] != ' ' && 
			board[0][1] != ' ' && 
		    board[0][2] != ' ' && 
			board[0][3] != ' ' && 
			board[0][4] != ' ' && 
			board[0][5] != ' ' && 
			board[0][6] != ' ')
		{
			return true;
		}
		else {
			return false;
		}
	}
	
	public void reset() {

		for (int i = 0; i < NUM_OF_ROW; i++){
			for (int j = 0; j < NUM_OF_COLUMNS; j++){
				board[i][j] = ' ';
			}
		}
	}
	


public int Horizontal_win() {
	for(int i = 0; i< NUM_OF_ROW; i++){
		for (int j = 0;j < NUM_OF_COLUMNS - 3;j++){
			if (board[i][j] == board[i][j+2] && 
				board[i][j+1] == board[i][j+2] && 
				board[i][j+2] != ' ' &&
				board[i][j+3] == ' ' )
				{
				return j+4;
			}
			else if (board[i][j] == board[i][j+3] && 
				board[i][j+1] == board[i][j+3] && 
				board[i][j+2] == ' ' &&
				board[i][j+3] != ' ' )
				{
				return j+3;
			}
			else if (board[i][j] == board[i][j+3]  && 
			board[i][j+1] == ' ' && 
			board[i][j+2] == board[i][j+3]  &&
			board[i][j+3] != ' '   )
			{
			return j+2;
		}
			else if (board[i][j] == ' ' && 
			board[i][j+1] == board[i][j+3] && 
			board[i][j+2] == board[i][j+3] &&
			board[i][j+3] != ' ' )
			{
			return j+1;
		}
		}			
	}
	return 0;
}


// checking for possible win

public int Vertical_win() {

	for(int i = 0; i < NUM_OF_ROW - 3; i++){
		for(int j = 0; j < NUM_OF_COLUMNS; j++){
			if (board[i][j] == ' '      && 
				board[i+1][j] == board[i+3][j] &&
				board[i+2][j] == board[i+3][j] &&
				board[i+3][j] != ' ')
				{
			return j+1;
			}
		}
	}
	return 0;
}

public int Udiagonal_win() {

	for(int i = 3; i < NUM_OF_ROW; i++){
		for(int j = 0; j < NUM_OF_COLUMNS - 3; j++){
			if (board[i][j] == board[i-2][j+2]   && 
				board[i-1][j+1] == board[i-2][j+2] &&
				board[i-2][j+2] != ' ' &&
				board[i-3][j+3] == ' ')
				{
				return j+4;
			}
			else if (board[i][j] == board[i-3][j+3]   && 
				board[i-1][j+1] == board[i-3][j+3] &&
				board[i-2][j+2] == ' ' &&
				board[i-3][j+3] != ' ' )
				{
				return j+3;
			}
			else if (board[i][j] == board[i-3][j+3]   && 
				board[i-1][j+1] == ' ' &&
				board[i-2][j+2] == board[i-3][j+3] &&
				board[i-3][j+3] != ' ')
				{
				return j+2;
			}
			else if (board[i][j] == ' ' && 
				board[i-1][j+1] == board[i-3][j+3] &&
				board[i-2][j+2] == board[i-3][j+3] &&
				board[i-3][j+3] != ' ')
				{
				return j+1;
			}
		}
	}
	return 0;
}

public int Ddiagonal_win() {

	for(int i = 0; i < NUM_OF_ROW - 3; i++){
		for(int j = 0; j < NUM_OF_COLUMNS - 3; j++){
			if (board[i][j] == board[i+2][j+2] && 
				board[i+1][j+1] == board[i+2][j+2] &&
				board[i+2][j+2] != ' ' &&
				board[i+3][j+3] == ' ')
				{
				return j+4;
			}
			if (board[i][j] == board[i+3][j+3] && 
				board[i+1][j+1] == board[i+3][j+3] &&
				board[i+2][j+2] == ' ' &&
				board[i+3][j+3] != ' ')
				{
				return j+3;
			}
			if (board[i][j] == board[i+3][j+3] && 
				board[i+1][j+1] == ' ' &&
				board[i+2][j+2] == board[i+3][j+3] &&
				board[i+3][j+3] != ' ')
				{
				return j+2;
			}
			if (board[i][j] == ' ' && 
				board[i+1][j+1] == board[i+3][j+3] &&
				board[i+2][j+2] == board[i+3][j+3] &&
				board[i+3][j+3] != ' ')
				{
				return j+1;
			}
		}
	}
	return 0;		
}

}
