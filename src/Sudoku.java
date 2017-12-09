import java.util.Scanner;
public class Sudoku {
	/**
	 * the upper left square.
	 */
	private int[][] square1 = new int[3][3];
	/**
	 * the left middle square.
	 */
	private int[][] square2 = new int[3][3];
	/**
	 * the left bottom square.
	 */
	private int[][] square3 = new int[3][3];
	/**
	 * the middle top square.
	 */
	private int[][] square4 = new int[3][3];
	/**
	 * the middle middle square.
	 */
	private int[][] square5 = new int[3][3];
	/**
	 * the middle bottom square.
	 */
	private int[][] square6 = new int[3][3];
	/**
	 * the right top square.
	 */
	private int[][] square7 = new int[3][3];
	/**
	 * the right middle square.
	 */
	private int[][] square8 = new int[3][3];
	/**
	 * the right bottom square.
	 */
	private int[][] square9 = new int[3][3];
	/**
	 * the total board.
	 */
	private int[][] board;
	
	/**
	 * All of the parts of the board that are empty spaces will be initalized with 0
	 * @param gameBoard this is the board given 
	 */
	public Sudoku(int[][] gameBoard) {
		board = gameBoard;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				square1[i][j] = board[i][j];
			}
		}
		for (int i = 0; i < 3; i++) {
			for (int j = 3; j < 6; j++) {
				square2[i][j - 3] = board[i][j];
			}
		}
		for (int i = 0; i < 3; i++) {
			for (int j = 6; j < 9; j++) {
				square3[i][j - 6] = board[i][j];
			}
		}
		for (int i = 3; i < 6; i++) {
			for (int j = 0; j < 3; j++) {
				square4[i-3][j] = board[i][j];
			}
		}
		for (int i = 3; i < 6; i++) {
			for (int j = 3; j < 6; j++ ) {
				square5[i-3][j-3] = board[i][j];
			}
		}
		for (int i = 3; i < 6; i++) {
			for (int j = 6; j < 9; j++) {
				square6[i-3][j-6] = board[i][j];
			}
		}
		for (int i = 6; i < 9; i++) {
			for (int j = 0; j < 3; j++) {
				square7[i-6][j] = board[i][j];
			}
		}
		for (int i = 6; i < 9; i++) {
			for (int j = 3; j < 6; j++) {
				square8[i-6][j-3] = board[i][j];
			}
		}
		for (int i = 6; i < 9; i++) {
			for (int j = 6; j < 9; j++) {
				square9[i-6][j-6] = board[i][j];
			}
		}
		printBoard();
	}
	
	public void printBoard() {
		System.out.println("  0 1 2 3 4 5 6 7 8");
		for (int i = 0; i < board.length; i++) {
			System.out.print(i);
			for (int j = 0; j < board.length; j++) {
				System.out.print(" " + board[i][j]);
			}
			System.out.println();
		}
	}
	public boolean gameDone() {
		boolean done = true;
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == 0) {
					done = false;
					break;
				}
			}
		}
		return done;
	}
	public void move() {
		Scanner key = new Scanner(System.in);
		System.out.println("Enter a x coordinate: ");
		int x = key.nextInt();
		while (x > 8 || x < 0) {
			System.out.println("Please enter a value between 0 and 8: ");
		}
		System.out.println("Enter a y coordinate: ");
		int y = key.nextInt();
		while (y > 8 || y < 0) {
			System.out.println("Please enter a value between 0 and 8: ");
		}
		System.out.println("Enter your value (a number between 1 - 9): ");
		int value = key.nextInt();
		while (value > 9 || value < 1) {
			System.out.println("Please enter a value between 1 and 9: ");
		}
		if (!validMove(x, y, value)) {
			System.out.println("That was not a valid move");
		}
		printBoard();
	}
	
	public int[][] board (int x, int y) {
		if (x < 3) {
			if (y < 3) {
				return square1;
			} else if (y > 3 && y < 6) {
				return square2;
			} else {
				return square3;
			}
		} else if (x > 3 && x < 6) {
			if (y < 3) {
				return square4;
			} else if (y > 3 && y < 6) {
				return square5;
			} else {
				return square6;
			}
		} else {
			if (y < 3) {
				return square7;
			} else if (y > 3 && y < 6) {
				return square8;
			} else {
				return square9;
			}
		}
	}
	
	public boolean validMove(int x, int y, int value) {
		for (int i = 0; i < board.length; i++) {
			if (board[x][i] == value) {
				return false;
			}
		}
		for (int i = 0; i < board[0].length; i++) {
			if (board[i][y] == value) {
				return false;
			}
		}
		int[][] temp = board(x,y);
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (temp[i][j] == value) {
					return false;
				}
			}
		}
		if (x < 3) {
			if (y < 3) {
				square1[x][y] = value;
			} else if (y > 3 && y < 6) {
				square2[x][y] = value;
			} else {
				square3[x][y] = value;
			}
		} else if (x > 3 && x < 6) {
			if (y < 3) {
				square4[x][y] = value;
			} else if (y > 3 && y < 6) {
				square5[x][y] = value;
			} else {
				square6[x][y] = value;;
			}
		} else {
			if (y < 3) {
				square7[x][y] = value;;
			} else if (y > 3 && y < 6) {
				square8[x][y] = value;;
			} else {
				square9[x][y] = value;;
			}
		}
		board[x][y] = value;
		return true;
	}
}
