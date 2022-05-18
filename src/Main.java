/* Tic Tac Toe
* Author: Rene Hütter
* Datum: 16.03.2022
* Version: 0.1
* */
import java.util.*;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args){

        String player = "";
        player = getPlayer(player);

        System.out.println("Willkommen beim Tic Tac Toe");

        TicTacToe game = new TicTacToe();
        game.initBoard();
        System.out.println(game.printBord());

        System.out.println("Spieler " + player + " ist an der Reihe.");

    }

    /**
     *
     * @param player
     * @return
     */
    public static String getPlayer(String player) {
        if (player.equals("X")){
            player = "O";
        } else {
            player = "X";
        }
        return player;
    }

    public static int getRow(int input) {
        int row = getInput();
        try {
            if (input >= TicTacToe.ROWS-1){
                return row;
            }
        }catch (IndexOutOfBoundsException e){
            System.out.println("Fehler bei der Eingabe");
        }
        return -1;
    }
    
    public static int getColumn(int input) {
        int column = getInput();
        try {
            if (input >= TicTacToe.COLUMNS - 1) {
                return column;
            }
        }catch (IndexOutOfBoundsException e){
            System.out.println("Fehler bei der Eingabe");
        }
        return -1;
    }

    public static int getInput() {
        String inputstr = scanner.nextLine();
        int input = 0;
        try {
            input = Integer.parseInt(inputstr);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Fehler bei der Eingabe");
        }
        return input;
    }
}