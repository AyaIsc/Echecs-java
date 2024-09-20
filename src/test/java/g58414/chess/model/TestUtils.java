/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g58414.chess.model;

import g58414.chess.view.TextView;

/**
 *
 * @author g58414
 */
public class TestUtils {

    public static void displayBoard(Game game) {
        TextView view = new TextView(game);
        view.displayBoard();
    }
}
