/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g58414.chess.model.pieces;

import g58414.chess.model.Board;
import g58414.chess.model.Color;
import static g58414.chess.model.Color.WHITE;
import g58414.chess.model.Direction;
import g58414.chess.model.Position;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ayout
 */
public class Pawn extends Piece {

    public Pawn(Color color) {
        super(color);
    }

    @Override
    public List<Position> getPossibleMoves(Position position, Board board) {
        ArrayList<Position> possibleMoves = new ArrayList<>(); //verif

        this.nextPlusOne(position, board, possibleMoves);
        this.nextPlusTwo(position, board, possibleMoves);
        this.diag(position, board, possibleMoves);

        return possibleMoves;
    }

    private Direction colorDirection(Color color) {
        return color == WHITE ? Direction.N : Direction.S;
    }

    private void nextPlusOne(Position position, Board board, List possibleMoves) { //private car methode ajouté par moi mm
        Position next = position.next(colorDirection(color));
        if (board.contains(next) && board.isFree(next)) { // si position libre au nord pr blanc
            possibleMoves.add(next);
        }
    }

    private void nextPlusTwo(Position position, Board board, List possibleMoves) {
        Direction dir = colorDirection(color);
        Position next = position.next(dir);
        Position next2 = next.next(dir);

        if (board.contains(next2) && board.isFree(next2) && board.getInitialPawnRow(color) == position.getRow()) { // get initialpawnrow a la position initiale pr chauqe couleur et est comparé avec getrow pr être sur
            possibleMoves.add(next2);
        }
    }

    private void diag(Position position, Board board, List possibleMoves) {
        Position nextVert = position.next(colorDirection(color));
        Direction[] directions = {Direction.W, Direction.E};
        for (Direction dir : directions) {
            Position destination = nextVert.next(dir);
            if (board.contains(destination) && !board.isFree(destination) && board.containsOppositeColor(destination, color)) {
                possibleMoves.add(destination);
            }
        }
    }

    public List<Position> getCapturePosition(Position position, Board board) {
        List<Position> capture = new ArrayList();

        this.diag(position, board, capture);

        return capture;
    }

}
