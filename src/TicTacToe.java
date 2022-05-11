public class TicTacToe {

    /**
     * Variablendeklaration
     * 2 Dimensionales String-Array
     * 2 Konstante für Zeilen und Spalten
     */
    public String[][] board;
    public final int ROWS = 3;
    public final int COLUMNS = 3;

    /**
     * Konstruktor
     */
    public TicTacToe(){
        board = new String[ROWS][COLUMNS];
    }

    public void initBoard(){
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                board[i][j] = "   ";
            }
        }
    }

    /**
     * print the gameBoard
     */
    public String printBord() {
        String strBord = "";
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                if (j != COLUMNS -1){
                    strBord += board[i][j] + "|";
                } else {
                    strBord += board[i][j];
                }
            }
            if (i != COLUMNS - 1) {
               strBord += "\n---+---+---\n";
            }
        }
        return strBord;
    }
}
