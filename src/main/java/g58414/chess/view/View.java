/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g58414.chess.view;

import g58414.chess.model.Position;

/**
 *
 * @author ayout
 */
public interface View {

    /**
     * Displays a title and a welcome message to the players.
     */
    public void displayTitle();

    /**
     * Displays the winner.
     */
    public void displayWinner();

    /**
     * Displays the board's game.
     */
    public void displayBoard();

    /**
     * Displays a message to invite the current Player (balck or white) to play.
     */
    public void displayPlayer();

    /**
     * Asks a valid position in the game's board
     *
     * @return the position
     */
    public Position askPosition();

    /**
     * Displays an error message in the parameters.
     *
     * @param message of error
     */
    public void displayError(String message);

    public void displayCheck();

    public void displayMat();

    public void displayStaleMat();
}
