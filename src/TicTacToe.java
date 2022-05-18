public class TicTacToe {

    /**
     * Variablendeklaration
     * 2 Dimensionales String-Array
     * 2 Konstante für Zeilen und Spalten
     */
    public static String[][] board;
    public static final int ROWS = 3;
    public static final int COLUMNS = 3;

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
        StringBuilder strBord = new StringBuilder();
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                if (j != COLUMNS -1){
                    strBord.append(board[i][j]).append("|");
                } else {
                    strBord.append(board[i][j]);
                }
            }
            if (i != COLUMNS - 1) {
               strBord.append("\n---+---+---\n");
            }
        }
        return strBord.toString();
    }

    public static String setPlay(int i, int j, String player) {
        return null;
    }
}
