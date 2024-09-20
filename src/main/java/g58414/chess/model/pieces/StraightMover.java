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
 * @author g58414
 */
public abstract class StraightMover extends Piece { //aurait pu le mettre dans piece

    protected final List<Direction> directions;

    public StraightMover(Color color, List<Direction> directions) {
        super(color);
        this.directions = directions;
    }

    @Override
    public List<Position> getPossibleMoves(Position position, Board board) {
        ArrayList<Position> possibleMoves = new ArrayList<>();

        for (Direction direction : directions) {
            Position destination = position.next(direction);
            while (board.contains(destination) && board.isFree(destination)) {
                possibleMoves.add(destination);
                destination = destination.next(direction);
            }
            if (board.contains(destination)
                    && board.containsOppositeColor(destination, color)) {
                possibleMoves.add(destination);
            }
        }

        return possibleMoves;
    }
}
