/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g58414.chess.model;

import g58414.chess.model.pieces.Piece;

/**
 *
 * @author ayout
 *
 * This class represents the 64 cases of the board's play.
 */
public class Square {

    /*
    attribute : piece.
     */
    private Piece piece;

    /*
    constructor of the class Square of the piece 
    @param piece
     */
    public Square(Piece piece) {
        this.piece = piece;
    }

    /*
    getter (method) of piece , it give us acces to the piece of the board's game.
    @return piece and its value
     */
    public Piece getPiece() {
        return piece;
    }

    /**
     * Setter (method) of piece, that allows us to edit the piece of the square.
     *
     * @param piece
     */
    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    /**
     * Check whether or not there's any piece in the square.
     *
     * @return true if the square is free and empty, false if it's not.
     */
    public boolean isFree() {
        return this.piece == null;
    }

}
