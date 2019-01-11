package app;
public class Board {
	private char[][] board;
	
	public Board() {
		board = new char[7][7];
		reset();
	}
	
	public boolean tieGame() {
		return !isWinner('x')&&!isWinner('o') && !anotherPlayPossible();
	}
	
	public void reset() {
		// traverse the whole thing and give initial values
		// foreach for rows, for for columns
		for(char[] row : board) {
			// regular for loop because foreach is read-only
			for(int c = 0; c < row.length; c++) {
				row[c] = '-';
			}
		}
	}
	
	// is another play possible?
	public boolean anotherPlayPossible() {
		// check for a blank spot (aka '-')
		for(char[] row: board) {
			for(char a :row) {
				if(a=='-') {
					return true;
				}
			}
		}
		return false;
	}
	
	// is there a winner?
	public boolean isWinner(char player) {
		// check for vertical wins
		if(verticalWin(player)) 
			return true;
		// check for horizontal wins
		if(horizontalWin(player)) return true;
		// check for diagonal wins
		if(diagonalPosWin(player)) return true;
		if(diagonalNegWin(player)) return true;
		// no winner:
		return false;
	}
	public boolean horizontalWin(char player) {
		
		for(int row=0; row <board.length; row++) {
			int count = 0;
			for(int x=0; x<7;x++) {
				if(board[row][x]==player) {
					count++;
				}
				else count = 0;
				
				if(count==4) return true;
			}
		}
		
		
		
		return false;
	}
	public boolean verticalWin(char player) {
		
		for(int row=0; row <board.length; row++) {
			int count = 0;
			for(int x=0; x<7;x++) {
				if(board[x][row]==player) {
					count++;
				}
				else count = 0;
				
				if(count==4) return true;
			}
		}
		
		
		
		return false;
	}
	public boolean diagonalPosWin(char player) {
		for(int row = 3; row < board.length; row++) {
			int count = 0;
			for(int col = 0; col <= row; col++) {
				if(board[row-col][col] == player) count++;
				else count = 0;
				
				if (count == 4) return true;
			}
		}
		// Tim condition
		for(int col = 1; col <= 3; col++) {
			int count = 0;
			int col_copy = col;
			for(int row = 6; row >= col; row--) {
				if(board[row][col_copy] == player) count++;
				else count = 0;
				
				col_copy++;
				if (count == 4) return true;
			}
		}
		
		return false;
	}
	public boolean diagonalNegWin(char player) {
		for(int r = 0; r < board.length; r++) {
			int count = 0;
			int row_copy = r;
			for(int c = 0; row_copy < board.length; c++) {
				if(board[row_copy][c] == player) count++;
				
				else count = 0;
				
				row_copy++;
				if (count == 4) return true;
			}
		}
		// TIM CONDITION
		for(int c = 1; c <= 3; c++) {
			int count = 0;
			for(int r = 0; r+c < board.length; r++) {
				if(board[r][c+r] == player) count++;
				else count = 0;
				
				if (count == 4) return true;
			}
		}
		
		return false;
	}
	// drop a piece
	public boolean dropPiece(char player, int column) {
		
		if(column>=board.length||column<0) return false;
		  for(int i = (board.length - 1); i >= 0; i--){
	            
	            if(board[i][column] == '-'){
	                
	                board[i][column] = player;
	                
	                return true;
	                
	            }
		  }
	      return false;	
	}
	
	// toString: print the current board
	@Override
	public String toString() {
		String result = "";
		// print board
		for(char[] row : board) {
			for(char col : row) {
				result += col + " ";
			}
			// line break after each row
			result += "\n";
		}
		return result;
	}
}

	