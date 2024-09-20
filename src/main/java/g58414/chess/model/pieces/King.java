/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g58414.chess.model.pieces;

import g58414.chess.model.Board;
import g58414.chess.model.Color;
import g58414.chess.model.Direction;
import g58414.chess.model.Position;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ayout
 */
public class King extends Piece {

    public King(Color color) {
        super(color);
    }

    @Override
    public List<Position> getPossibleMoves(Position position, Board board) {
        ArrayList<Position> possibleMoves = new ArrayList<>();

        this.nextKing(position, board, possibleMoves);

        return possibleMoves;
    }

    private void nextKing(Position position, Board board, List possibleMoves) {

        for (Direction directions1 : Direction.values()) {
            Position destination = position.next(directions1);
            if (board.contains(destination)
                    && (board.isFree(destination) || board.containsOppositeColor(destination, color))) {
                possibleMoves.add(destination);
            }
        }
    }

}
