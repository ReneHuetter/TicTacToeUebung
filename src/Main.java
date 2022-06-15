/* Tic Tac Toe
* Author: Rene Hütter
* Datum: 16.03.2022
* Version: 0.1
* */
import java.util.*;

public class Main {

    /***
     * Die Klassenobjekte
     * scanner und game
     * wobei game aus der Klasse TicTacToe kommt.
     */
    static Scanner scanner = new Scanner(System.in);
    static TicTacToe game = new TicTacToe();
    static boolean playgame = true;
    static int drawcount = 0;
    static int Xwinercount = 0;
    static int Owinercount = 0;

    /***
     * main methode wo player auf "O" gesetzt wird.
     * das Spielfeld ausgeben wird.
     * wo die Zähler variable auf 0 gelegt wird.
     */
    public static void main(String[] args){

        System.out.println("Willkommen beim Tic Tac Toe\n");

        int count = 0;

        while (playgame) {
            String player = " O ";
            game.initBoard();
            System.out.println(game.printBord());

            while (true) {
                int i = getRow();
                int j = getColum();
                player = getPlayer(player);

                while (!TicTacToe.setPlay(i, j, player)) {
                    System.out.println("Fehler xxx");
                    break;
                }
                System.out.println(game.printBord());

                count++;

                if (TicTacToe.isGameOver()) {
                    System.out.println("\n" + game.printBord() + "\n" + player + " wins!");
                    if (player.equals("X")) {
                        Xwinercount++;
                        replaygame();
                    } else {
                        Owinercount++;
                        replaygame();
                    }
                    break;
                }
                if (count >= 9) {
                    System.out.println("UNENTSCHIEDEN\n" + "Es wurde so oft ein UNENTSCHIEDEN erspielt" + drawcount);
                    drawcount++;
                    playgame = false;
                }

            }
        }

    }

    /**
     *
     */
    private static void replaygame() {
        System.out.println("wollen sie noch mal spielen ?\n 1 für JA\n 2 für NEIN");
        int choose = getInput();
        System.out.println(
                "Spieler: X hat so oft gewonnen: " + Xwinercount + "\n" +
                "Spieler: O hat so oft gewonnen: " + Owinercount + "\n" +
                "Es wurde so oft ein UNENTSCHIEDEN erspielt" + drawcount + "\n"
        );
        playgame = choose == 1;
    }


    /**
     * Wechselt den Spieler von "O" auf "X" und zurück von "X" auf "O".
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
     * gibt die Reihe zurück wo der aktive Spieler sein Zeichen setzt.
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
     * gibt die Spalte zurück wo der aktive Spieler sein Zeichen setzt.
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