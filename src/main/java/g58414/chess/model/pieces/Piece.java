/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g58414.chess.model.pieces;

import g58414.chess.model.Board;
import g58414.chess.model.Color;
import g58414.chess.model.Position;
import java.util.Objects;
import java.util.List;

/**
 *
 * @author ayout Class of one of the pieces of the game.
 */
public abstract class Piece {

    final Color color;

    /*
    Constructor of the class Color, it gives the 
    piece the color in the parameter.
    @param color
     */
    Piece(Color color) {
        this.color = color;
    }

    /*
    Getter for the attribute Color. 
    Gives us the acces to the color.
    @param Color
    @return color;
     */
    public Color getColor() {
        return color;
    }
//    /**
//     * Method that help us to shorten our next methods by associating the two color
//     * directly with their directions
//     * @param color (Black , White);
//     * @return The direction of each two color
//     */

    /*private Direction colorDirection(Color color) {
        return color == WHITE ? Direction.N : Direction.S;
    }*/

    public abstract List<Position> getPossibleMoves(Position position, Board board);/* {
        ArrayList<Position> possibleMoves = new ArrayList<>(); //verif

        this.nextPlusOne(position, board, possibleMoves);
        this.nextPlusTwo(position, board, possibleMoves);
        this.diag(position, board, possibleMoves);
        
        return possibleMoves;
    }*/

//    /**
//     * This method is used to move our check to the north (for the white checks)
//     * and to the south (for the black checks), we need to know if the next box
//     * is empty before moving our check.
//     *
//     * @param position to move the position to the north
//     * @param board
//     * @return
//     */
    /*private void nextPlusOne(Position position, Board board, List possibleMoves) { //private car methode ajouté par moi mm
        Position next = position.next(colorDirection(color));
        if (board.contains(next) && board.isFree(next)) { // si position libre au nord pr blanc
            possibleMoves.add(next);
        }
    }*/
//    /**
//     * This private method is used to move twice to the North(White)/South(black) for every beginning of the game
//     * 
//     * @param position
//     * @param board
//     * @param possibleMoves 
//     */
    /*private void nextPlusTwo(Position position , Board board , List possibleMoves){
        Direction dir = colorDirection(color);
        Position next = position.next(dir);
        Position next2 = next.next(dir);
        
        if(board.contains(next2) && board.isFree(next2) && board.getInitialPawnRow(color) == position.getRow()){ // get initialpawnrow a la position initiale pr chauqe couleur et est comparé avec getrow pr être sur
            possibleMoves.add(next2);
        }
    }*/
//    /**
//     * This private method is used to move the check in a diagonal position once
//     * it captured one of the opponent's checks.
//     * @param position
//     * @param board
//     * @param possibleMoves 
//     */
    /*private void diag(Position position, Board board , List possibleMoves){
        Position nextVert = position.next(colorDirection(color));
        Direction[] directions = {Direction.W, Direction.E};
        for (Direction dir : directions) { 
            Position destination = nextVert.next(dir);
            if(board.contains(destination) && !board.isFree(destination) && board.containsOppositeColor(destination, color) ){
                possibleMoves.add(destination);
            }
        }
    }*/

    public List<Position> getCapturePosition(Position position, Board board) {
        return this.getPossibleMoves(position, board);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.color);
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
        final Piece other = (Piece) obj;
        if (this.color != other.color) {
            return false;
        }
        return true;
    }

}
