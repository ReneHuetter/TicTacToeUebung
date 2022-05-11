/* Tic Tac Toe
* Author: Rene Hütter
* Datum: 16.03.2022
* Version: 0.1
* */
import java.util.*;

public class Main {

    Scanner scanner = new Scanner(System.in);

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

}