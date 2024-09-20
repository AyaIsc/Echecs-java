/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g58414.chess.model;

/**
 * @author g58414 This class is for the board's game's position
 */
public class Position {

    private final int row;
    private final int column;

    /* This constrctor uses row and colomn (two integers) to indicate the position. */
    public Position(int row, int column) {
        this.row = row;
        this.column = column;
    }

    /* Getter for row */
    public int getRow() {
        return row;
    }

    /* Getter for colomn*/
    public int getColumn() {
        return column;
    }

    /*
    this method will return the new Position resulted by
    moving the check in a given direction
     */
    public Position next(Direction dir) {
        return new Position(row + dir.getDeltaRow(), column + dir.getDeltaColumn());
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + this.row;
        hash = 19 * hash + this.column;
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
        final Position other = (Position) obj;
        if (this.row != other.row) {
            return false;
        }
        if (this.column != other.column) {
            return false;
        }
        return true;
    }
}
