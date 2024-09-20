/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g58414.chess.view;

import g58414.chess.model.Color;
import g58414.chess.model.Model;
import g58414.chess.model.pieces.Piece;
import g58414.chess.model.Position;
import g58414.chess.model.pieces.Bishop;
import g58414.chess.model.pieces.King;
import g58414.chess.model.pieces.Knight;
import g58414.chess.model.pieces.Pawn;
import g58414.chess.model.pieces.Queen;
import g58414.chess.model.pieces.Rook;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 *
 * @author ayout
 */
public class TextView implements View {

    private final Model model;

    public TextView(Model model) {
        this.model = model;
    }

    /**
     * Displays a title and a welcome message to the players.
     */
    @Override
    public void displayTitle() {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Weclome to the Chess Game of user g58414");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }

    /**
     * Displays the winner.
     */
    @Override
    public void displayWinner() {
        System.out.println("Congratulation," + model.getOppositePlayer() + " you are the winner.");
    }

    /**
     * Displays the board's game.
     */
    @Override
    public void displayBoard() {
        String check = ""; //affiche board
        String color = "";
        for (int i = 7; i >= 0; i--) {
            System.out.println();
            System.out.println("  -------------------------");
            System.out.print(i + 1 + " ");
            for (int j = 0; j < 8; j++) {
                final Piece piece = model.getPiece(new Position(i, j));
                if (piece == null) {
                    check = " ";
                    color = " ";
                } else if (piece.getColor().equals(Color.WHITE)) {
                    color = "W";
                } else {
                    color = "B";
                }
                if (piece instanceof Pawn) {
                    check = "P";
                } else if (piece instanceof Knight) {
                    check = "C";
                } else if (piece instanceof King) {
                    check = "*K";
                } else if (piece instanceof Queen) {
                    check = "#Q";
                } else if (piece instanceof Bishop) {
                    check = "B";
                } else if (piece instanceof Rook) {
                    check = "R";
                }
                String result = check + color;
                System.out.print("|" + result);
            }
            System.out.print("|");
        }
        System.out.println();
        System.out.println("  -------------------------");
        System.out.println("    a  b  c  d  e  f  g  h");
        System.out.println();
    }

    /**
     * Displays a message to invite the current Player (black or white) to play.
     */
    @Override
    public void displayPlayer() {
        System.out.println("It's your turn , " + model.getCurrentPlayer() + "!");
    }

    /**
     * Asks a valid position in the game's board
     *
     * @return the position
     */
    @Override
    public Position askPosition() {
        Scanner clavier = new Scanner(System.in);
        System.out.println("Enter a position with number (between 1 and 8) and a letter (between a and h) w/O any space : ");
        String valid = "[1-8][a-h]";
        String text = clavier.nextLine();

        Pattern pattern = Pattern.compile(valid);
        while (!pattern.matcher(text).matches()) {
            System.out.println("Invalid entry");
            System.out.println("Please enter a valid position (number between 1 and 8) and a letter (between a and h)");
            text = clavier.nextLine();
        }

        char lignes = text.charAt(0);
        char colonnes = text.charAt(1);

        int lg = lignes - '1';
//        switch (lignes) {
//            case '1':
//                lg = 0;
//                break;
//            case '2':
//                lg = 1;
//                break;
//            case '3':
//                lg = 2;
//                break;
//            case '4':
//                lg = 3;
//                break;
//            case '5':
//                lg = 4;
//                break;
//            case '6':
//                lg = 5;
//                break;
//            case '7':
//                lg = 6;
//                break;
//            case '8':
//                lg = 7;
//                break;
//            default:
//                lg = -1;
//                break;
//        };
        int col = colonnes - 'a';
//        switch (colonnes) {
//            case 'a':
//                col = 0;
//                break;
//            case 'b':
//                col = 1;
//                break;
//            case 'c':
//                col = 2;
//                break;
//            case 'd':
//                col = 3;
//                break;
//            case 'e':
//                col = 4;
//                break;
//            case 'f':
//                col = 5;
//                break;
//            case 'g':
//                col = 6;
//                break;
//            case 'h':
//                col = 7;
//                break;
//            default:
//                col = -1;
//                break;
//        };
        return new Position(lg, col);
    }

    /**
     * Displays an error message in the parameters.
     *
     * @param message of error
     */
    @Override
    public void displayError(String message) {
        System.err.println("!ERROR!" + message + "!ERROR!");
    }

    /**
     * Displays a message if the player is in a situation of check.
     */
    @Override
    public void displayCheck() {
        System.out.println("you are in a situation of check " + model.getCurrentPlayer() + "!");
    }

    /**
     * Displays a message if the player is in a situation of displayMat.
     */
    @Override
    public void displayMat() {
        System.out.println("You are in a situation of mat " + model.getCurrentPlayer() + "!");
    }

    /**
     * Displays a message if the player is in a situation of Stale Mat.
     */
    @Override
    public void displayStaleMat() {
        System.out.println("You are in a situation of Stalemate " + model.getCurrentPlayer() + "!");
    }

}
