public class Tetris {
	public static final int ROWS = 20;
	public static final int COLS = 10;
	
	private int[][] board;
	private Shape activeShape;
	private int score = 0;
	
	public Tetris() {
		board = new int[ROWS][COLS];
		int[] nums = {1,2,3};
		for (int row = 0; row < ROWS; row++) {
			for (int col = 0; col < COLS; col++) {
					board[row][col] = -1;
			}
		}
		
		activeShape = Shape.getRandomShape();
		
	}
	
	public int getScore() {
		return score;
	}
	

	
	public boolean playNextShape() {
		activeShape = Shape.getRandomShape();
		return !overlapShape(activeShape.getX(), activeShape.getY());
	}
	
	public boolean overlapShape(int shapeX, int shapeY) {
		String[] shapeStr = activeShape.getShape();
		for (int row = 0; row < shapeStr.length; row++) {
			for (int col = 0; col < shapeStr.length; col++) {
				int offsetRow = shapeY + row;
				int offsetCol = shapeX + col;
				if (shapeStr[row].charAt(col) != ' ' && offsetRow >= 0 && (offsetCol < 0 || offsetCol >= COLS || offsetRow >= ROWS || board[offsetRow][offsetCol] >= 0)) {
					return true;
				}
			}
		}
		return false;
	}
	
	public int clearRows() {
		int clearedRows = 0;
		int  col;
		for (int row = ROWS - 1; row >= 0; row--) {
			for (col = 0; col < COLS; col++) {
				if (board[row][col] == -1) break;
			}
			
			if (col == COLS) {
				for (int i = row; i > 0; i--) {
					board[i] = board[i - 1];
				}
			}
			
			board[0] = new int[COLS];
			for (int i = 0; i < COLS; i++) {
				board[0][i] = -1;
			}
			
			clearedRows++;
			score += (int)Math.pow(2, clearedRows - 1) * 100;
			row++;
		}
		return clearedRows;
	}
	
	public void moveShapeLeft() {
		if (!overlapShape(activeShape.getX() - 1, activeShape.getY())) {
		activeShape.setX(activeShape.getX() - 1);
		}
		
		
	}
	public void moveShapeRight() {
		if (!overlapShape(activeShape.getX() + 1, activeShape.getY())) {
			activeShape.setX(activeShape.getX() +1);
		}
	}
	
	public void rotateShape() {
		activeShape.rotateRight();
		if (overlapShape(activeShape.getX(), activeShape.getY())) {
			activeShape.rotateLeft();
		}
	}
	
	public void placeShape() {
		while (!overlapShape(activeShape.getX(), activeShape.getY() + 1)) {
			activeShape.incY();
		}
	}
	
	
	
	public int[][] getBoard() {
		int [][] activeBoard = new int[ROWS][COLS];
		for (int row = 0; row < ROWS; row++) {
			for (int col = 0; col < COLS; col++) {
				activeBoard[row][col] = board[row][col];
			}
		}
		String[] shapeStr = activeShape.getShape();
		int shapeX = activeShape.getX();
		int shapeY = activeShape.getY();
		for(int row = 0; row < shapeStr.length; row++) {
			for (int col = 0; col < shapeStr[0].length(); col++) {
				int offsetRow = shapeY + row;
				int offsetCol = shapeX + col;
				if (shapeStr[row].charAt(col) != ' ' &&
						offsetCol >= 0 && offsetCol < COLS &&
						offsetRow >= 0 && offsetRow < ROWS) {
					activeBoard[offsetRow][offsetCol] = activeShape.getType();
				}
			}
		}
		return activeBoard;
	}
	public void updateBoard() {
		board = getBoard();
	}
	
	public boolean dropShape() {
		int y = activeShape.getY();
		if (overlapShape(activeShape.getX(), y +1 )) {
			updateBoard();
			clearRows();
			return false;
		}
		activeShape.incY();
		return true;
		

	}
}





