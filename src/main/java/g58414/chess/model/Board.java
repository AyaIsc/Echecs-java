/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g58414.chess.model;

import g58414.chess.model.pieces.Piece;
import static g58414.chess.model.Color.BLACK;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ayout
 *
 * Class for the board of the game.
 */
public class Board {

    private final Square[][] board;

    /**
     * Initialize a new board 8 times 8 without any piece.
     */
    public Board() {
        board = new Square[8][8];
        for (Square[] board1 : board) {
            //parcous 1X //for(int i = 0; i<board.length;i++){
            for (int j = 0; j < board1.length; j++) {
                //parcours 2x car tab 2D
                board1[j] = new Square(null); // 0 pieces dans le jeu
            }
        }
    }

    /**
     * this method shows us if the position (pos) is on the board
     *
     * @param pos
     * @return true if the position is present , false if it's not
     */
    public boolean contains(Position pos) {
        return pos.getColumn() <= 7 && pos.getColumn() >= 0
                && pos.getRow() <= 7 && pos.getRow() >= 0;
    }

    /**
     * this method shows us if the piece is still on his initial position or
     * not.This method will also be useful to position the pieces in the game's
     * board.
     *
     * @param color
     * @return 6 if the color is black and 1 if the color is white.
     */
    public int getInitialPawnRow(Color color) {
        return color == BLACK ? 6 : 1;
        /*int resultColor = 0;
        if (color == BLACK) {
            resultColor = 6;
        } else if (color == WHITE) {
            resultColor = 1;
        }
        return resultColor;*/
    }

    /**
     * setPiece(method) will place the piece in the position entered in pos it
     * will also throw an IllegalArgumentException if the given position isn't
     * in the board.
     *
     * @param piece
     * @param position
     */
    public void setPiece(Piece piece, Position position) {
        if (!contains(position)) {
            throw new IllegalArgumentException("the position is not on the board.");
        }
        int column = position.getColumn();
        int row = position.getRow();

        board[row][column].setPiece(piece);
    }

    /**
     * Return the piece that's in the given position (in the parameters).
     *
     * @param pos (given position).
     * @return the piece in the position (pos).
     * @throws IllegalArgumentException if the given position isn't included
     * between 0 and 7 (position that aren't in the board)
     */
    public Piece getPiece(Position pos) {
        if (!contains(pos)) {
            throw new IllegalArgumentException("the position is not on the board.");
        }
        int column = pos.getColumn();
        int row = pos.getRow();

        return board[row][column].getPiece();
    }

    /**
     * Deletes the piece at the given position.
     *
     * @param pos Position of the piece that needs to be removed.
     */
    public void dropPiece(Position pos) {
        if (!contains(pos)) {
            throw new IllegalArgumentException("the given position is not on the board.");
        }
        int column = pos.getColumn();
        int row = pos.getRow();

        board[row][column].setPiece(null); //null->supprime
    }

    /**
     * isFree is the method that checks if pos (position in the board) is
     * available.
     *
     * @param pos
     * @return true if it's available , false if it's not
     */
    public boolean isFree(Position pos) {
        if (!contains(pos)) {
            throw new IllegalArgumentException("the position is not on the board.");
        }
        int row = pos.getRow();
        int column = pos.getColumn();
        return board[row][column].isFree();

    }

    /**
     * containsOppositeColor is a method.It checks if the position (pos) is
     * occupied by the opponent (col)
     *
     * @param pos
     * @param col
     * @return true if its occupied by the opponent.
     */
    public boolean containsOppositeColor(Position pos, Color col) {
        if (!contains(pos)) {
            throw new IllegalArgumentException("the position is not on the board.");
        }
        //boolean opposed = false;

//        if (isFree(pos)) {
//            return false;
//        }
        return !isFree(pos) && col.opposite().equals(getPiece(pos).getColor());
    }

    /**
     * getPositionOccupiedBy is a method that shows us the occupied positions of
     * the Player player.
     *
     * @param player
     *
     * @return a list of all the occupied position
     */
    public List<Position> getPositionOccupiedBy(Player player) {
        List<Position> liste = new ArrayList();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (!board[i][j].isFree()) {
                    if (board[i][j].getPiece().getColor().equals(player.getColor())) {
                        liste.add(new Position(i, j));
                    }
                }
            }
        }
        return liste;
    }

    /*@Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Arrays.deepHashCode(this.board);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Board other = (Board) obj;
        return true;
    }*/
 /*
    returns the piece's position that is given in the parameters if it's on the 
    board
    @param Piece 
    @return Position
     */
    public Position getPiecePosition(Piece piece) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                Position pos = new Position(i, j);
                Piece curPiece = getPiece(pos);
                if (curPiece != null && curPiece.equals(piece)) {
                    return pos;
                }
            }
        }
        return null;
    }
//    public Position getPiecePosition(Piece piece) {
//        boolean find = false;
//        Position position = null;
//        for (int i = 0; i < board.length && !find; i++) {
//            for (int j = 0; j < board[i].length && !find; j++) {
//                Position pos = new Position(i, j);
//                if (!isFree(pos) && this.getPiece(pos).equals(piece)) {
//                    position = pos;
//                    find = true;
//                }
//            }
//        }
//        return position;
//    }

}
