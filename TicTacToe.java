import java.util.*;
public class TicTacToe {
	public static void main (String[]args){
		Scanner console = new Scanner (System.in);
		char[][] board = charArray();
		introduction();
		System.out.print("What is Player 1's name? ");
		String player1 = console.nextLine();
		System.out.print("What is Player 2's name? ");
		String player2 = console.nextLine();
		playOrNot(console,player1,player2,board);
	}
	public static void playOrNot (Scanner console, String player1, String player2, char[][]board){
		int playerTurns = 1;
		boolean stillInPlay = true;
		while (stillInPlay != false){
			System.out.println();
			System.out.println("Here's the current board:\n");
			display(board);
			if (playerTurns == 1){
				System.out.println("It's " + player1 + "'s turn.");
			}
			else {
				System.out.println("It's " + player2 + "'s turn.");
			}
			System.out.println("Enter some coordinates.");
			System.out.print("x: ");
			int x = console.nextInt();
			System.out.print("y: ");
			int y = console.nextInt();
			while (board[x][y] != ' '){
				System.out.println("This space is already in use!\nPlease use another space.");
				System.out.print("x: ");
				x = console.nextInt();
				System.out.print("y: ");
				y = console.nextInt();
			}
			if (playerTurns == 1){
					board[x][y] = 'X';
					playerTurns++;
				}
				else {
					board[x][y] = 'O';
					playerTurns = 1;
				}
			if (winner(board) == true){
				if (playerTurns == 1){
					System.out.println(player2 + " wins!");
					stillInPlay = false;
					System.out.print("Would you still like to play? (y/n) ");
					console.nextLine();
					if (console.nextLine().toUpperCase().charAt(0) == 'Y'){
						board = charArray();
						playerTurns = 1;
						stillInPlay = true;
					}
					else {
						stillInPlay = false;
					}
				}
				if (playerTurns == 2){
					System.out.println(player1 + " wins!");
					System.out.print("Would you still like to play? (y/n) ");
					console.nextLine();
					if (console.nextLine().toUpperCase().charAt(0) == 'Y'){
						board = charArray();
						playerTurns = 1;
						stillInPlay = true;
					}
					else {
						stillInPlay = false;
					}
				}
			}
		}
	}
	public static char[][] charArray (){
		char[][]board = new char[3][3];
		for (int x = 0; x < board.length; x++){
			for (int i = 0; i < board[0].length; i++){
				board[x][i] = ' ';
			}
		}
		return board;
	}
	public static void introduction (){
		System.out.println("Welcome to Tic Tac Toe!");
		System.out.println("This is how the board is ordered by x and y.");
		System.out.println();
		System.out.println("0 0|0 1|0 2");
		System.out.println("-----------");
		System.out.println("1 0|1 1|1 2");
		System.out.println("-----------");
		System.out.println("2 0|2 1|2 2");
		System.out.println();
	}
	/*This method displays the Tic Tac Toe board.*/
	public static void display (char[][]board){
		for (int x = 0; x < board.length; x++){
			String tempLine = " ";
			for (int i = 0; i < board[0].length; i++){
				if ( i == board[0].length-1){
					tempLine += board[x][i];
				}
				else {
					tempLine += board[x][i] + " | ";
				}
			}
			System.out.println(tempLine);
			if ( x != board.length-1){
					System.out.println("-----------");
			}
		}
		System.out.println();
	}
	public static boolean winner (char[][]board){
		char[]p1Wins = {'X','X','X'};
		char[]p2Wins = {'O','O','O'};
		//Left
		char[]counter1 = new char[3];
		//Middle
		char[]counter2 = new char[3];
		//Right
		char[]counter3 = new char[3];
		//Left Side Diagonal
		char[]counter4 = new char[3];
		//Right Side Diagonal
		char[]counter5 = new char[3];
		for (int x = 0; x < board.length; x++){
			if (Arrays.equals(board[x],p1Wins) || Arrays.equals(board[x],p2Wins)){
				return true;
			}
			for (int i = 0; i < board[0].length; i++){
				if (i == 0){
					if (x == 0){
						counter4[x] = board[x][i];
					}
					if (x == 2){
						counter5[x] = board[x][i];
					}
					counter1[x] = board[x][i];
				}
				if (i == 1){
					if (x == 1){
						counter4[x] = board[x][i];
						counter5[x] = board[x][i];
					}
					counter2[x] = board[x][i];
				}
				if (i == 2){
					if (x == 2){
						counter4[x] = board[x][i];
					}
					if (x == 0){
						counter5[x] = board[x][i];
					}
					counter3[x] = board[x][i];
				}
			}
		}
		if (Arrays.equals(counter1,p1Wins) || Arrays.equals(counter2,p1Wins) || Arrays.equals(counter3,p1Wins)|| Arrays.equals(counter4,p1Wins)|| Arrays.equals(counter5,p1Wins)){
			return true;
		}
		if (Arrays.equals(counter1,p2Wins) || Arrays.equals(counter2,p2Wins) || Arrays.equals(counter3,p2Wins)|| Arrays.equals(counter4,p2Wins)|| Arrays.equals(counter5,p2Wins)){
			return true;
		}
		return false;
	}
}