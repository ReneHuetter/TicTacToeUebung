public class TicTacToe {

    /**
     * Klasseneigenschaften
     * 2 dimensionales String-Array (board)
     * 2 Konstante für Zeilen (ROWS) und Spalten (COLUMNS)
     * Konstante String Variable (regex)
     */
    public static String[][] board;
    public static final int ROWS = 3;
    public static final int COLUMNS = 3;
    public static final String regex = "   ";

    /**
     * Konstruktor für das Spielfeld
     */
    public TicTacToe(){
        board = new String[ROWS][COLUMNS];
    }

    /**
     * Methode initBoard initialisiert das Spielfeld mit den vorgegebenen Standardwerte.
     */
    public void initBoard(){
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                board[i][j] = "   ";
            }
        }
    }

    /**
     * gameBoard gibt das Spielfeld auf der Konsole aus.
     */
    public String printBord() {
        String output = "";
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                if (j != COLUMNS - 1){
                    output += board[i][j] + "|";
                } else {
                    output += board[i][j];
                }
            }
            if (i != COLUMNS - 1) {
                output += "\n---+---+---\n";
            }
        }
        return output;
    }

    /**
     * Ist zum Setzen vom Spieler sein Zeichen
     * @param i ist für Rows.
     * @param j ist für Columns.
     * @param player ist für den Spieler X / O.
     * @return true / false
     */
    public static boolean setPlay(int i, int j, String player) {
        if(board[i][j].equals(regex)) {
            board[i][j] = " " + player + " ";
            return true;
        }
        return false;
    }

    /**
     * überprüft, ob drei gleich in einer Reihe oder in einer Spalte sind oder diagonal sind.
     * @return true / false
     */
    public static boolean isGameOver() {
       for (int i = 0; i < ROWS; i++) {
           if (!board[i][0].equals(regex) && board[i][1].equals(board[i][0]) && board[i][2].equals(board[i][1]))
               return true;
       }
       for (int j = 0; j < COLUMNS; j++) {
           if (!board[0][j].equals(regex) && board[1][j].equals(board[0][j]) && board[2][j].equals(board[1][j]))
                   return true;
       }
       if (!board[2][2].equals(regex) && board[2][2].equals(board[1][1]) && board[1][1].equals(board[0][0])){
           return true;
       }
       if (!board[0][2].equals(regex) && board[0][2].equals(board[1][1]) && board[1][1].equals(board[2][0])){
           return true;
       }
        return false;
    }
}
