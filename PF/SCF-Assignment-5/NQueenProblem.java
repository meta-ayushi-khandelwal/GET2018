
public class NQueenProblem 
{
	int[][] nQueenSolution(int size)
    	{
		int[][] board = init(size);	// init() will initialize board array
		int col = 0;
		if (nQueen(board, col, size) == true){
			System.out.println();
	    	System.out.println("--------------N Queen Problem for " + size + " x " + size + " :  --------------\n");
			printArray(board, size);	//print final board
		}
		else 
			throw new AssertionError();	//if number of queens can't be placed
		
        return board;
    }

    private int[][] init(int size) {	//method to initialize board
    	int[][] board = new int[size][size];
		for(int i = 0; i < size; i++){
			for(int j = 0; j < size; j++){
		    	board[i][j] = 0;
			}
		}
		return board;
	}

	private void printArray(int[][] board, int size) {	//this method is used to print board 
		for (int i = 0; i < size; i++)
		{
		    for (int j = 0; j < size; j++)
			System.out.print(" " + board[i][j]
					 + " ");
		    System.out.println();
		}
		System.out.print("\n\n");
	}

	boolean isSafe(int board[][], int row, int col, int size) {	//checks if place of queen is safe or not
		int i, j;

		for (i = 0; i < col; i++)	// Check this row on left side 
		    if (board[row][i] == 1)
			return false;

		for (i=row, j=col; i>=0 && j>=0; i--, j--)	// Check upper diagonal on left side 
		    if (board[i][j] == 1)
			return false;

		for (i=row, j=col; j>=0 && i<size; i++, j--)	// Check lower diagonal on left side 
		    if (board[i][j] == 1)
			return false;

		return true;
	    }
 
    boolean nQueen(int board[][], int col, int size)	//returns true if all queens are successfully placed
    {
        if (col >= size)	//If all queens are placed then return true
            return true;
 
        for (int i = 0; i < size; i++)	//Consider this column and try placing this queen in all rows one by one
        {
            if (isSafe(board, i, col, size))	// Check if the queen can be placed on board[i][col]
            {
                board[i][col] = 1;
                System.out.println("Current status of board is : ");
                printArray(board, size);
                if (nQueen(board, col + 1, size) == true)
                    return true;
                
                board[i][col] = 0; // BACKTRACK If placing queen in board[i][col] doesn't lead to a solution
                					//then remove queen from board[i][col] 
            }
        }
	    
        /* If the queen can not be placed in any row in
           this colum col, then return false */
        return false;
	}
    
}
