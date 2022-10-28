package yeetivity.jjve.tic_tac_toe.model;

public class Logic {

    public static final int SIZE=3;

    public enum Player {CROSS, NOUGHT, NONE}

    private Player[][] board;
    private int moves;
    private Player currentPlayer;
    private boolean isDecided;

    public void reset(){
        // Method to reset the board back to starting state
        for (int row = 0; row < SIZE; row++){
            for (int col = 0; col<SIZE; col++){
                board[row][col] = Player.NONE;
            }
        }
        moves = 0;
        currentPlayer = Player.CROSS;
        isDecided = false;
    }

    public Player getCurrentPlayer(){return currentPlayer;}

    public boolean isEmpty(int row, int col){return board[row][col] == Player.NONE;}

    public Player getWinner(){
        if (isDecided){
            return currentPlayer;
        }
        return Player.NONE;
    }

    public boolean isDecided() {return isDecided;}

    public int getMoves(){return moves;}

    public boolean isLegalMove(int row, int col){
        if (isDecided) return false;
        return isEmpty(row, col);
    }

    public boolean makeMove(int row, int col){
        if (!isLegalMove(row,col)) return false;

        // Make the move
        board[row][col] = currentPlayer;
        moves++;

        // Update state, check winner and update current player
        checkIfDecided(row,col);
        if (!isDecided){
            currentPlayer = currentPlayer == Player.CROSS ? Player.NOUGHT : Player.CROSS;
        }
        return true;
    }

    private void checkIfDecided(int row, int col){
        //row
        int c;
        for (c=0; c<SIZE; c++){
            if (board[row][c] != currentPlayer) break;
        }
        if (c== SIZE){
            isDecided = true;
            return;
        }

        //col
        int r;
        for (r=0; r<SIZE; r++){
            if (board[r][col] != currentPlayer) break;
        }
        if (r== SIZE){
            isDecided = true;
            return;
        }

        //first diagonal
        if (row == col){
            int pos;
            for (pos =0; pos<SIZE; pos++){
                if(board[pos][pos] != currentPlayer) break;
            }
            if (pos == SIZE){
                isDecided = true;
                return;
            }
        }

        //second diagonal
        if (row + col == SIZE - 1){
            int pos;
            for (pos =0; pos<SIZE; pos++){
                if(board[pos][SIZE - 1 - pos] != currentPlayer) break;
            }
            if (pos == SIZE){
                isDecided = true;
                return;
            }
        }

        //draw
        if (moves == SIZE * 3){
            isDecided = true;
            currentPlayer = Player.NONE;
            return;
        }
    }

    public Player[][] getCopyOfBoard() {
        Player[][] copy = new Player[SIZE][SIZE];
        for (int row = 0; row < SIZE; row++){
            for (int col = 0; col <SIZE; col++){
                copy[row][col] = board[row][col];
            }
        }
        return copy;
    }

    //Singleton
    public static Logic getInstance(){
        if (logic == null){
            logic = new Logic();
        }
        return logic;
    }

    private static Logic logic = null;

    private Logic(){
        board = new Player[SIZE][SIZE];
        reset();
    }
}
