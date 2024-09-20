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
public class KnightTest {

    Board board;

    public KnightTest() {
    }

    @BeforeEach
    public void setUp() {
        board = new Board();
    }

    @Test
    public void test1() {
        System.out.println("basic movement of the check Knight");
        Position position = new Position(4, 4);
        Knight piece = new Knight(Color.WHITE);
        board.setPiece(piece, position);

        List<Position> expected = List.of(
                new Position(6, 3),
                new Position(6, 5),
                new Position(5, 2),
                new Position(5, 6),
                new Position(3, 2),
                new Position(3, 6),
                new Position(2, 3),
                new Position(2, 5)
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
        System.out.println("No movements are possible because they're all occupied by other checks");
        Position position = new Position(4, 4);
        Knight piece = new Knight(Color.WHITE);
        board.setPiece(piece, position);
        Knight white = new Knight(Color.WHITE);
        Position position2 = new Position(6, 3);
        board.setPiece(white, position2);
        Position position3 = new Position(6, 5);
        board.setPiece(white, position3);
        Position position4 = new Position(5, 2);
        board.setPiece(white, position4);
        Position position5 = new Position(5, 6);
        board.setPiece(white, position5);
        Position position6 = new Position(3, 2);
        board.setPiece(white, position6);
        Position position7 = new Position(3, 6);
        board.setPiece(white, position7);
        Position position8 = new Position(2, 3);
        board.setPiece(white, position8);
        Position position9 = new Position(2, 5);
        board.setPiece(white, position9);

        List<Position> expected = List.of();

        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);

    }

    /*
    test à verifier
     */
    @Test
    public void test3() {
        System.out.println("Impossible moves : bottom movements are impossible because they're out of the board ");
        Position position = new Position(1, 3);
        Knight piece = new Knight(Color.WHITE);
        board.setPiece(piece, position);

        List<Position> expected = List.of(
                new Position(0, 1),
                new Position(0, 5),
                new Position(2, 1),
                new Position(2, 5),
                new Position(3, 2),
                new Position(3, 4)
        );

        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);

    }

    @Test
    public void test4() {
        System.out.println("Impossible moves : side west movements are impossible because they're out of the board ");
        Position position = new Position(4, 1);
        Knight piece = new Knight(Color.BLACK);
        board.setPiece(piece, position);

        List<Position> expected = List.of(
                new Position(2, 0),
                new Position(6, 0),
                new Position(2, 2),
                new Position(3, 3),
                new Position(5, 3),
                new Position(6, 2)
        );

        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);

    }

    @Test
    public void test5() {
        System.out.println("Impossible moves : top  movements are impossible because they're out of the board ");
        Position position = new Position(6, 4);
        Knight piece = new Knight(Color.WHITE);
        board.setPiece(piece, position);

        List<Position> expected = List.of(
                new Position(7, 2),
                new Position(7, 6),
                new Position(4, 3),
                new Position(4, 5),
                new Position(5, 6),
                new Position(5, 2)
        );

        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);

    }

    @Test
    public void test6() {
        System.out.println("Impossible moves : side east  movements are impossible because they're out of the board ");
        Position position = new Position(4, 6);
        Knight piece = new Knight(Color.BLACK);
        board.setPiece(piece, position);

        List<Position> expected = List.of(
                new Position(2, 5),
                new Position(2, 7),
                new Position(3, 4),
                new Position(5, 4),
                new Position(6, 5),
                new Position(6, 7)
        );

        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);

    }

    @Test
    public void test7() {
        System.out.println("all possibles moves with opposite color ");
        Position position = new Position(4, 4);
        Knight piece = new Knight(Color.BLACK);
        board.setPiece(piece, position);
        Knight white = new Knight(Color.WHITE);
        Position position2 = new Position(6, 3);
        board.setPiece(white, position2);
        Position position3 = new Position(6, 5);
        board.setPiece(white, position3);
        Position position4 = new Position(5, 2);
        board.setPiece(white, position4);
        Position position5 = new Position(5, 6);
        board.setPiece(white, position5);
        Position position6 = new Position(3, 2);
        board.setPiece(white, position6);
        Position position7 = new Position(3, 6);
        board.setPiece(white, position7);
        Position position8 = new Position(2, 3);
        board.setPiece(white, position8);
        Position position9 = new Position(2, 5);
        board.setPiece(white, position9);

        List<Position> expected = List.of(
                new Position(6, 3),
                new Position(6, 5),
                new Position(5, 2),
                new Position(5, 6),
                new Position(3, 2),
                new Position(3, 6),
                new Position(2, 3),
                new Position(2, 5)
        );

        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);

    }
}
