/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g58414.chess.model;

/**
 *
 * @author g58414 enumeration of Colors that will be used in the game.s
 */
public enum Color {
    WHITE, BLACK;

    /**
     * method that returns the opposite of colors.
     *
     * @return black if the color is white & white if the color is black.
     */
    public Color opposite() {
        Color opposed = WHITE;
        if (this == WHITE) {
            opposed = BLACK;
        }
        return opposed;
    }

}
