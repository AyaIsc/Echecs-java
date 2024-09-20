/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g58414.chess.model;

import g58414.chess.model.pieces.Piece;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import g58414.chess.model.pieces.Pawn;

/**
 *
 * @author g58414
 */
public class PieceTest {

    Board board;

    public PieceTest() {
    }

    @BeforeEach
    public void setUp() {
        board = new Board();
    }

    @Test
    public void testGetPossibleMovesP() {
        Position position = new Position(1, 1);
        Piece piece = new Pawn(Color.WHITE);
        board.setPiece(piece, position);

        List<Position> expected = List.of(
                new Position(2, 1),
                new Position(3, 1)
        );

        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);
    }

    /**
     * ******* A vous d'écrire les autres cas. Veuillez faire attention à avoir
     * un plan de test complet (comme précisé dans l'énoncé)
     ***********
     */
    /*
     *      Permet de tester si deux listes de positions sont identiques à l'ordre
     *      des éléments prêts. Cette méthode est appelée
     *      par les méthodes de test.
     */
    private void assertEqualsIgnoringOrder(List<Position> expected, List<Position> actual) {
        assertEquals(expected.size(), actual.size());
        assertTrue(actual.containsAll(expected));
        assertTrue(expected.containsAll(actual));
    }

    /*debut test personnels*/

    @Test
    public void testGetPossibleMoves1() {
        System.out.println("Black check in his inital case + with two free cases infront");

        Position position = new Position(6, 1);
        Piece piece = new Pawn(Color.BLACK);
        board.setPiece(piece, position);

        List<Position> expected = List.of(
                new Position(5, 1),
                new Position(4, 1)
        );

        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);
    }

    @Test
    public void testGetPossibleMoves2W() {
        System.out.println("test to kill 1 white check with 1 black check");

        Piece piece = new Pawn(Color.WHITE);
        Position position = new Position(3, 1);

        board.setPiece(piece, position);

        Piece piece2 = new Pawn(Color.BLACK);
        Position position2 = new Position(4, 2);

        board.setPiece(piece2, position2);

        List<Position> expected = List.of(
                /*new Position(4,4), //avancer 
                new Position(4,5),//tuer
                 */
                new Position(4, 1),
                new Position(4, 2)
        );

        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);
    }

    @Test
    public void testGetPossibleMoves2B() {
        System.out.println("test2 to kill 1 black check with 1 white check");
        Piece piece = new Pawn(Color.WHITE);
        Position position = new Position(3, 6);

        board.setPiece(piece, position);

        Piece piece2 = new Pawn(Color.BLACK);
        Position position2 = new Position(4, 5);

        board.setPiece(piece2, position2);

        List<Position> expected = List.of(
                new Position(4, 6),
                new Position(4, 5)
        );

        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);
    }

    @Test
    public void testGetPossibleMoves3W() {
        System.out.println("3 checks , 2 black checks , 1 black check takes the white one");

        Piece piece = new Pawn(Color.BLACK);
        Position position = new Position(3, 4);

        Board board = new Board();

        board.setPiece(piece, position);

        Piece piece2 = new Pawn(Color.BLACK);
        Position position2 = new Position(2, 3);

        board.setPiece(piece2, position2);

        Piece piece3 = new Pawn(Color.WHITE);
        Position position3 = new Position(2, 5);

        board.setPiece(piece3, position3);

        List<Position> expected = List.of(
                new Position(2, 4),
                new Position(2, 5)
        );

        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);
    }

    @Test
    public void testGetPossibleMoves3B() {
        System.out.println("3 checks , 2 white checks , 1 white check takes the black one");
        //nextPlusOnetest 2 whites , 1 white take the black 

        Piece piece = new Pawn(Color.WHITE);
        Position position = new Position(3, 2);

        board.setPiece(piece, position);

        Piece piece2 = new Pawn(Color.WHITE);
        Position position2 = new Position(3, 4);

        board.setPiece(piece2, position2);

        Piece piece3 = new Pawn(Color.BLACK);
        Position position3 = new Position(4, 3);

        board.setPiece(piece3, position3);

        List<Position> expected = List.of(
                new Position(4, 2),
                new Position(4, 3)
        );

        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);
    }

    @Test
    public void testGetPossibleMoves4W() {
        System.out.println("test white check and black check , both can't move foward because they're facing each other");

        Piece piece = new Pawn(Color.WHITE);
        Position position = new Position(2, 4);

        board.setPiece(piece, position);

        Piece piece2 = new Pawn(Color.BLACK);
        Position position2 = new Position(3, 4);

        board.setPiece(piece2, position2);

        List<Position> expected = List.of();

        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);
    }

    @Test
    public void testGetPossibleMoves5B() {
        System.out.println("test with 5 checks (4 whites & 1 black) the black check takes one white check");
        Piece piece = new Pawn(Color.WHITE);
        Position position = new Position(5, 2);

        board.setPiece(piece, position);

        Piece piece2 = new Pawn(Color.WHITE);
        Position position2 = new Position(3, 2);

        board.setPiece(piece2, position2);

        Piece piece3 = new Pawn(Color.WHITE);
        Position position3 = new Position(5, 4);

        board.setPiece(piece3, position3);

        Piece piece4 = new Pawn(Color.WHITE);
        Position position4 = new Position(3, 4);

        board.setPiece(piece4, position4);

        Piece piece5 = new Pawn(Color.BLACK);
        Position position5 = new Position(4, 3);

        board.setPiece(piece5, position5);

        List<Position> expected = List.of(
                new Position(3, 2),
                new Position(3, 4),
                new Position(3, 3)
        );

        List<Position> positions = piece5.getPossibleMoves(position5, board);

        assertEqualsIgnoringOrder(expected, positions);
    }

    @Test
    public void testGetPossibleMoves5W() {
        System.out.println("test with 5 checks (1 whites & 4 black) , one black check takes the white check in the middle");
        Piece piece = new Pawn(Color.WHITE);
        Position position = new Position(3, 5);

        board.setPiece(piece, position);

        Piece piece2 = new Pawn(Color.BLACK);
        Position position2 = new Position(4, 4);

        board.setPiece(piece2, position2);

        Piece piece3 = new Pawn(Color.BLACK);
        Position position3 = new Position(4, 6);

        board.setPiece(piece3, position3);

        Piece piece4 = new Pawn(Color.BLACK);
        Position position4 = new Position(2, 4);

        board.setPiece(piece4, position4);

        Piece piece5 = new Pawn(Color.BLACK);
        Position position5 = new Position(2, 6);

        board.setPiece(piece5, position5);

        List<Position> expected = List.of(
                new Position(4, 4),
                new Position(4, 6),
                new Position(4, 5)
        );

        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);
    }

    @Test
    public void testGetPossibleMoves7W() {
        System.out.println("test for a white check to test that he can't move foward twice "
                + "because it's not placed in his initial row");

        Piece piece = new Pawn(Color.BLACK);
        Position position = new Position(4, 3);

        board.setPiece(piece, position);

        Piece piece2 = new Pawn(Color.WHITE);
        Position position2 = new Position(3, 4);

        board.setPiece(piece2, position2);

        Piece piece3 = new Pawn(Color.BLACK);
        Position position3 = new Position(4, 5);

        board.setPiece(piece3, position3);

        List<Position> expected = List.of(
                new Position(4, 3),
                new Position(4, 4),
                new Position(4, 5)
        );

        List<Position> positions = piece2.getPossibleMoves(position2, board);

        assertEqualsIgnoringOrder(expected, positions);

    }

    @Test
    public void testGetPossibleMoves8W() {
        System.out.println("test for the white check at the very firt row , move twice foward.");

        Piece piece = new Pawn(Color.WHITE);
        Position position = new Position(1, 4);

        board.setPiece(piece, position);

        List<Position> expected = List.of(
                new Position(2, 4),
                new Position(3, 4)
        );

        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);
    }

    @Test
    public void testGetPossibleMoves8B() {
        System.out.println("test for the black check at it's very firt row , move twice foward.");

        Piece piece = new Pawn(Color.BLACK);
        Position position = new Position(6, 4);

        board.setPiece(piece, position);

        List<Position> expected = List.of(
                new Position(5, 4),
                new Position(4, 4)
        );

        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);
    }

}
