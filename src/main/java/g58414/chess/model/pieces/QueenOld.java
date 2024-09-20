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
public class QueenOld extends Piece {

    public QueenOld(Color color) {
        super(color);
    }
//    
//    @Override
//    public List<Position> getPossibleMoves(Position position, Board board) {
//        ArrayList<Position> possibleMoves = new ArrayList<>();
//        
//        this.queenDiag(position, board, possibleMoves);
//        this.queenDir(position, board, possibleMoves);
//        
//        return possibleMoves;
//    }

    @Override
    public List<Position> getPossibleMoves(Position position, Board board) {
        ArrayList<Position> possibleMoves = new ArrayList<>();

        Direction[] directions = Direction.values();

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

    private void queenDiag(Position position, Board board, List possibleMoves) {

        Direction[] directions = {Direction.NE, Direction.NW, Direction.SE, Direction.SW};
        for (Direction directions1 : directions) {
            Position destination = position.next(directions1);
            while (board.contains(destination) && board.isFree(destination)) {
                destination = destination.next(directions1);
                possibleMoves.add(destination);
            }
            if (board.contains(destination) && board.containsOppositeColor(position, color)) {
                possibleMoves.add(destination);
            }
        }
    }

    private void queenDir(Position position, Board board, List possibleMoves) {

        Direction[] directions = {Direction.N, Direction.S, Direction.E, Direction.W};
        for (Direction directions1 : directions) {
            Position destination = position.next(directions1);
            while (board.contains(destination) && board.isFree(destination)) {
                destination = destination.next(directions1);
                possibleMoves.add(destination);
            }
            if (board.containsOppositeColor(position, color)) {
                possibleMoves.add(destination);
            }
        }
    }

}
