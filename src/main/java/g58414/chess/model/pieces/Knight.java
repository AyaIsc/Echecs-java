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
public class Knight extends Piece {

    public Knight(Color color) {
        super(color);
    }

    @Override
    public List<Position> getPossibleMoves(Position position, Board board) {
        ArrayList<Position> possibleMoves = new ArrayList<>();

        this.nextPlusTwoEast(position, board, possibleMoves);
        this.nextPlusTwoNorth(position, board, possibleMoves);
        this.nextPlusTwoSouth(position, board, possibleMoves);
        this.nextPlusTwoWest(position, board, possibleMoves);

        return possibleMoves;
    }

    private void nextPlusTwoEast(Position position, Board board, List possibleMoves) {
        Position nextEast1 = position.next(Direction.E);
        Position nextEast2 = nextEast1.next(Direction.E);

        Direction[] directions = {Direction.N, Direction.S};

        for (Direction directions1 : directions) {
            Position destination = nextEast2.next(directions1);
            if (board.contains(destination)) {
                if (board.isFree(destination) || board.containsOppositeColor(destination, color)) {
                    possibleMoves.add(destination);
                }

            }

        }
    }

    /*
    la bonne west côtés de fin
     */
    private void nextPlusTwoWest(Position position, Board board, List possibleMoves) {
        Position nextWest1 = position.next(Direction.W);
        Position nextWest2 = nextWest1.next(Direction.W);

        Direction[] directions = {Direction.N, Direction.S};

        for (Direction directions1 : directions) {
            Position destination = nextWest2.next(directions1);
            if (board.contains(destination)) {
                if (board.isFree(destination) || board.containsOppositeColor(destination, color)) {
                    possibleMoves.add(destination);
                }

            }

        }
    }

    /*
    sides du bas
     */
    private void nextPlusTwoSouth(Position position, Board board, List possibleMoves) {
        Position nextSouth1 = position.next(Direction.S);
        Position nextSouth2 = nextSouth1.next(Direction.S);

        Direction[] directions = {Direction.E, Direction.W};

        for (Direction directions1 : directions) {
            Position destination = nextSouth2.next(directions1);
            if (board.contains(destination)) {
                if (board.isFree(destination) || board.containsOppositeColor(destination, color)) {
                    possibleMoves.add(destination);
                }

            }

        }
    }

    private void nextPlusTwoNorth(Position position, Board board, List possibleMoves) {
        Position nextNorth1 = position.next(Direction.N);
        Position nextNorth2 = nextNorth1.next(Direction.N);
        /*avance de 2 vers N*/

        Direction[] directions = {Direction.E, Direction.W};

        for (Direction directions1 : directions) {
            Position destination = nextNorth2.next(directions1);
            if (board.contains(destination)) {
                if (board.isFree(destination) || board.containsOppositeColor(destination, color)) {
                    possibleMoves.add(destination);
                }

            }

        }
    }
}
