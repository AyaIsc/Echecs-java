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
public class KingTest {

    Board board;

    public KingTest() {
    }

    @BeforeEach
    public void setUp() {
        board = new Board();
    }

    private void assertEqualsIgnoringOrder(List<Position> expected, List<Position> actual) {
        assertEquals(expected.size(), actual.size());
        assertTrue(actual.containsAll(expected));
        assertTrue(expected.containsAll(actual));
    }

    @Test
    public void test1() {
        System.out.println("basic movements");

        Position position = new Position(4, 5);
        King piece = new King(Color.BLACK);
        board.setPiece(piece, position);

        List<Position> expected = List.of(
                new Position(4, 4),
                new Position(4, 6),
                new Position(3, 4),
                new Position(3, 6),
                new Position(5, 4),
                new Position(5, 6),
                new Position(5, 5),
                new Position(3, 5)
        );

        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);

    }

    @Test
    public void test2() {
        System.out.println("No movements are possible because they're all occupied by other checks");
        Position position = new Position(4, 5);
        King piece = new King(Color.WHITE);
        board.setPiece(piece, position);
        King white = new King(Color.WHITE);
        Position position2 = new Position(4, 4);
        board.setPiece(white, position2);
        Position position3 = new Position(4, 6);
        board.setPiece(white, position3);
        Position position4 = new Position(3, 4);
        board.setPiece(white, position4);
        Position position5 = new Position(3, 5);
        board.setPiece(white, position5);
        Position position6 = new Position(3, 6);
        board.setPiece(white, position6);
        Position position7 = new Position(5, 4);
        board.setPiece(white, position7);
        Position position8 = new Position(5, 5);
        board.setPiece(white, position8);
        Position position9 = new Position(5, 6);
        board.setPiece(white, position9);

        List<Position> expected = List.of();

        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);

    }

    @Test
    public void test3() {
        System.out.println("impossible moves : bottom South is out of the board");

        Position position = new Position(0, 5);
        King piece = new King(Color.BLACK);
        board.setPiece(piece, position);

        List<Position> expected = List.of(
                new Position(1, 5),
                new Position(1, 6),
                new Position(1, 4),
                new Position(0, 4),
                new Position(0, 6)
        );

        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);

    }

    @Test
    public void test4() {
        System.out.println("impossible moves : top North is out of the board");

        Position position = new Position(7, 5);
        King piece = new King(Color.BLACK);
        board.setPiece(piece, position);

        List<Position> expected = List.of(
                new Position(6, 5),
                new Position(6, 6),
                new Position(6, 4),
                new Position(7, 4),
                new Position(7, 6)
        );

        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);

    }

    @Test
    public void test5() {
        System.out.println("impossible moves : side West is out of the board");

        Position position = new Position(2, 0);
        King piece = new King(Color.BLACK);
        board.setPiece(piece, position);

        List<Position> expected = List.of(
                new Position(3, 0),
                new Position(3, 1),
                new Position(2, 1),
                new Position(1, 0),
                new Position(1, 1)
        );

        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);

    }

    @Test
    public void test6() {
        System.out.println("impossible moves : side East is out of the board");

        Position position = new Position(2, 7);
        King piece = new King(Color.BLACK);
        board.setPiece(piece, position);

        List<Position> expected = List.of(
                new Position(2, 6),
                new Position(3, 6),
                new Position(3, 7),
                new Position(1, 7),
                new Position(1, 6)
        );

        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);

    }

    @Test
    public void test7() {
        System.out.println("possible moves : all of them are occupied by opposite checks");
        Position position = new Position(4, 5);
        King piece = new King(Color.BLACK);
        board.setPiece(piece, position);
        King white = new King(Color.WHITE);
        Position position2 = new Position(4, 4);
        board.setPiece(white, position2);
        Position position3 = new Position(4, 6);
        board.setPiece(white, position3);
        Position position4 = new Position(3, 4);
        board.setPiece(white, position4);
        Position position5 = new Position(3, 5);
        board.setPiece(white, position5);
        Position position6 = new Position(3, 6);
        board.setPiece(white, position6);
        Position position7 = new Position(5, 4);
        board.setPiece(white, position7);
        Position position8 = new Position(5, 5);
        board.setPiece(white, position8);
        Position position9 = new Position(5, 6);
        board.setPiece(white, position9);

        List<Position> expected = List.of(
                new Position(4, 4),
                new Position(4, 6),
                new Position(3, 4),
                new Position(3, 6),
                new Position(5, 4),
                new Position(5, 6),
                new Position(5, 5),
                new Position(3, 5)
        );
        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);

    }
}
