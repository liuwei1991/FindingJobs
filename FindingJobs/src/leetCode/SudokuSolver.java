package leetCode;

public class SudokuSolver {
	public void solveSudoku(char[][] board) {
		if (board == null || board.length != 9 || board[0].length != 9) {
			return;
		}
		this.fillNum(board, 0, 0);
	}

	private boolean fillNum(char[][] board, int x, int y) {
		if (y >= 9) {
			return this.fillNum(board, x + 1, 0);
		}
		if (x >= 9) {
			return true;
		}
		if (board[x][y] == '.') {
			for (int k = 1; k <= 9; k++) {
				board[x][y] = (char) (k + '0');
				if (this.check(board, x, y) && this.fillNum(board, x, y + 1)) {
					return true;
				}
				board[x][y] = '.';
			}
		}else{
			return fillNum(board,x,y+1);
		}
		return false;
	}

	private boolean check(char[][] board, int i, int j) {
		for (int k = 0; k < board.length; k++) {
			if (k != i  && board[k][j] == board[i][j]) {
				return false;
			}
		}
		for (int k = 0; k < board[0].length; k++) {
			if (k != j && board[i][k] == board[i][j]) {
				return false;
			}
		}
		int x = (i / 3) * 3;
		int y = (j / 3) * 3;
		for (int m = 0; m < 3; m++) {
			for (int n = 0; n < 3; n++) {
				if ((x + m) == i && (y + n) == j) {
					continue;
				} else if ( board[x + m][y + n] == board[i][j]) {
					return false;
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {
		SudokuSolver ss = new SudokuSolver();
		String[] s = { "53..7....",
				"6..195...", 
				".98....6.", 
				"8...6...3",
				"4..8.3..1",
				"7...2...6",
				".6....28.",
				"...419..5", 
				"....8..79" };
		char[][] chars = new char[9][9];
		for (int i = 0; i < 9; i++) {
			chars[i] = s[i].toCharArray();
		}
		ss.solveSudoku(chars);
	}
}
