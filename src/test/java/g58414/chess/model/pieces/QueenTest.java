/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g58414.chess.model.pieces;

import g58414.chess.model.Board;
import g58414.chess.model.Color;
import g58414.chess.model.Position;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

/**
 *
 * @author ayout
 */
public class QueenTest {

    Board board;

    public QueenTest() {
    }

    @BeforeEach
    public void setUp() {
        board = new Board();
    }

    @Test
    public void test1() {
        System.out.println("basic movement of the check");
        Position position = new Position(4, 4);
        Queen piece = new Queen(Color.WHITE);
        board.setPiece(piece, position);

        List<Position> expected = List.of(
                new Position(5, 3),
                new Position(6, 2),
                new Position(7, 1),
                new Position(5, 5),
                new Position(6, 6),
                new Position(7, 7),
                new Position(3, 3),
                new Position(2, 2),
                new Position(1, 1),
                new Position(0, 0),
                new Position(3, 5),
                new Position(2, 6),
                new Position(1, 7),
                new Position(5, 4),
                new Position(6, 4),
                new Position(7, 4),
                new Position(3, 4),
                new Position(2, 4),
                new Position(1, 4),
                new Position(0, 4),
                new Position(4, 3),
                new Position(4, 2),
                new Position(4, 1),
                new Position(4, 0),
                new Position(4, 5),
                new Position(4, 6),
                new Position(4, 7)
        );

        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);

    }

    private void assertEqualsIgnoringOrder(List<Position> expected, List<Position> actual) {
        assertEquals(expected.size(), actual.size());
        assertTrue(actual.containsAll(expected));
        assertTrue(expected.containsAll(actual));
    }

    @Test
    public void test2() {
        System.out.println("no movements are possible because they're occupied by the same player");
        Position position = new Position(4, 4);
        Queen piece = new Queen(Color.BLACK);
        board.setPiece(piece, position);
        Queen black = new Queen(Color.BLACK);
        Position pos = new Position(5, 3);
        board.setPiece(black, pos);
        Position pos1 = new Position(5, 5);
        board.setPiece(black, pos1);
        Position pos2 = new Position(3, 3);
        board.setPiece(black, pos2);
        Position pos3 = new Position(3, 5);
        board.setPiece(black, pos3);
        Position pos4 = new Position(4, 3);
        board.setPiece(black, pos4);
        Position pos5 = new Position(4, 5);
        board.setPiece(black, pos5);
        Position pos6 = new Position(5, 4);
        board.setPiece(black, pos6);
        Position pos7 = new Position(3, 4);
        board.setPiece(black, pos7);

        List<Position> expected = List.of();

        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);

    }

    @Test
    public void test3() {
        System.out.println("movements are possible because they're occupied by the opposite player");
        Position position = new Position(4, 4);
        Queen piece = new Queen(Color.BLACK);
        board.setPiece(piece, position);
        Queen white = new Queen(Color.WHITE);
        Position pos = new Position(5, 3);
        board.setPiece(white, pos);
        Position pos1 = new Position(5, 5);
        board.setPiece(white, pos1);
        Position pos2 = new Position(3, 3);
        board.setPiece(white, pos2);
        Position pos3 = new Position(3, 5);
        board.setPiece(white, pos3);
        Position pos4 = new Position(4, 3);
        board.setPiece(white, pos4);
        Position pos5 = new Position(4, 5);
        board.setPiece(white, pos5);
        Position pos6 = new Position(5, 4);
        board.setPiece(white, pos6);
        Position pos7 = new Position(3, 4);
        board.setPiece(white, pos7);

        List<Position> expected = List.of(
                new Position(5, 3),
                new Position(5, 5),
                new Position(3, 3),
                new Position(3, 5),
                new Position(4, 3),
                new Position(4, 5),
                new Position(5, 4),
                new Position(3, 4)
        );

        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);

    }

    @Test
    public void test4() {
        System.out.println("south and west movements are not possible because"
                + "the queen is on the bottom left of the board");
        Position position = new Position(0, 0);
        Queen piece = new Queen(Color.BLACK);
        board.setPiece(piece, position);

        List<Position> expected = List.of(
                new Position(1, 1),
                new Position(2, 2),
                new Position(3, 3),
                new Position(4, 4),
                new Position(5, 5),
                new Position(6, 6),
                new Position(7, 7),
                new Position(0, 1),
                new Position(0, 2),
                new Position(0, 3),
                new Position(0, 4),
                new Position(0, 5),
                new Position(0, 6),
                new Position(0, 7),
                new Position(1, 0),
                new Position(2, 0),
                new Position(3, 0),
                new Position(4, 0),
                new Position(5, 0),
                new Position(6, 0),
                new Position(7, 0)
        );

        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);

    }

    @Test
    public void test5() {
        System.out.println("east movements are not possible because"
                + "the queen is side of the board");
        Position position = new Position(5, 7);
        Queen piece = new Queen(Color.BLACK);
        board.setPiece(piece, position);

        List<Position> expected = List.of(
                new Position(7, 7),
                new Position(6, 7),
                new Position(4, 7),
                new Position(3, 7),
                new Position(2, 7),
                new Position(1, 7),
                new Position(0, 7),
                new Position(5, 0),
                new Position(5, 1),
                new Position(5, 2),
                new Position(5, 3),
                new Position(5, 4),
                new Position(5, 5),
                new Position(5, 6),
                new Position(6, 6),
                new Position(7, 5),
                new Position(4, 6),
                new Position(3, 5),
                new Position(2, 4),
                new Position(1, 3),
                new Position(0, 2)
        );

        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);

    }

}
