/* Tic Tac Toe
* Author: Rene Hütter
* Datum: 16.03.2022
* Version: 0.1
* */
import java.util.*;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    static TicTacToe game = new TicTacToe();

    public static void main(String[] args){

        System.out.println("Willkommen beim Tic Tac Toe\n");

        String player = " O ";

        game.initBoard();

        int count = 0;
        System.out.println(game.printBord());

        while(true)
        {
            int i = getRow();
            int j = getColum();
            player = getPlayer(player);

            while(!TicTacToe.setPlay(i, j, player)){
                System.out.println("Fehler xxx");
                break;
            }
            System.out.println(game.printBord());

            count++;

            if (TicTacToe.isGameOver()){
                System.out.println("\n" + game.printBord() + "\n" + player + " wins!");
                break;
            }
            if(count >= 9){
                System.out.println("UNENTSCHIEDEN\n");
            }

        }
    }


    /**
     *
     * @param player O / X
     * @return player
     */
    public static String getPlayer(String player) {
        if (player.equals("X")){
            player = "O";
        } else {
            player = "X";
        }
        return player;
    }

    /**
     *
     * @return row / -1
     */
    public static int getRow() {
        System.out.println("Geben Sie die Reihe an: ");
        int row = getInput();
        try {
            if (row <= TicTacToe.ROWS -1) {
                return row;
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Zahl außerhalb der Range of indexes");
        }
        return -1;
    }

    /**
     * gibt die Spalte
     * @return column / -1
     */
    public static int getColum() {
        System.out.println("Geben Sie die Spalte an. ");
        int column = getInput();
        try {
            if (column <= TicTacToe.COLUMNS -1) {
                return column;
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Zahl außerhalb der Range of indexes");
        }
        return -1;
    }

    /**
     * parst einen String zu einem int
     * @return input
     */
    public static int getInput() {
        String inputstr = scanner.nextLine();
        int input = 0;
        try {
            input = Integer.parseInt(inputstr);
        } catch (NumberFormatException nfe) {
            System.out.println("Es können nur Zahlen eingegeben werden!");
        }
        return input;
    }
}