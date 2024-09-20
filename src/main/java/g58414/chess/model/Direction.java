/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g58414.chess.model;

/**
 *
 * @author g58414 This enumeration is used for all the possible direction used
 * in the game. The positions are : North-West(NW),North(N),North-East(NE),
 * West(W),East(E),South-West(SW),South(S) and South-East(SE). However the
 * direction W & E will not be used , a check doesn't move horizontally.
 */
public enum Direction {
    NW(1, -1),
    N(1, 0),
    NE(1, 1),
    W(0, -1),
    E(0, 1),
    SW(-1, -1),
    S(-1, 0),
    SE(-1, 1);

    private final int deltaRow;
    /* final = peut pas modif*/
    private final int deltaColumn;

    /*constructor for the direction of checks
    @param deltaR for the vertical direction,
    @param deltaC for the horizontal placement*/
    Direction(int deltaR, int deltaC) {
        this.deltaRow = deltaR;
        this.deltaColumn = deltaC;
    }

    /*Getter of DeltaRow
    @return deltaRow value*/
    public int getDeltaRow() {
        return deltaRow;
    }

    /*Getter of DeltaColumn
    @return deltaColumn value*/
    public int getDeltaColumn() {
        return deltaColumn;
    }
}
