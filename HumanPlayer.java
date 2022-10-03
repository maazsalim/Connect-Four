import java.util.Scanner;

public class HumanPlayer extends Player {
	
	int num;
	Scanner scanner = new Scanner(System.in);
	
	public HumanPlayer(char symbol, Board board, String name) {
		super(symbol, board, name);
	}

	public void makeMove(Board board) {
		System.out.println("Enter the column you would like to choose");
		num = scanner.nextInt();
		
		board.setValue(num, symbol);
		
		
	}

}
