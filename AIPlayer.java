import java.util.Random;
public class AIPlayer extends Player {

	public AIPlayer(char symbol, Board board, String name) {
		super(symbol, board, name);
	}

	Random rand = new Random();
	
	public void makeMove(Board board) {

        int n;

        if (check_win(board) == 0){
        	n = rand.nextInt(7) + 1;
        } else {
            n = check_win(board);
        }


        while (board.allowed(n) == false) {
            System.out.println("Please Enter a valid move");
            n = rand.nextInt(7) + 1;
        }

		board.setValue(n, symbol);
        
    }


    public static int check_win(Board board) {

  
    	int h = board.Horizontal_win();
    	int v = board.Vertical_win();
        int u = board.Udiagonal_win();
        int d = board.Ddiagonal_win();

        if (h != 0){
            return h;
        }
        else if (v != 0){
            return v;
        }
        else if (u != 0){
            return u;
        }
        else if (d != 0){
            return d;
        }
        else {
            return 0;
        }

    }

	
		
	
	
}
