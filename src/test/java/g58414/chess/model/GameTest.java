/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g58414.chess.model;

import g58414.chess.model.pieces.Piece;
import static g58414.chess.model.Color.WHITE;
import static g58414.chess.model.Color.BLACK;
import g58414.chess.model.pieces.King;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import g58414.chess.model.pieces.Pawn;
import g58414.chess.model.pieces.Queen;
import org.junit.jupiter.api.BeforeEach;

/**
 *
 * @author g58414
 */
public class GameTest {

    Board board;

    @BeforeEach     // ExÃ©cutÃ©e avant chaque test
    public void setUp() {
        board = new Board();
    }

    public GameTest() {
    }

    /**
     * Test of start method, of class Game.
     */
    @Test
    public void testStart() {
        System.out.println("start");
        Game game = new Game();
        game.start();

        Game instance = new Game();
        instance.start();
    }

    /**
     * Test of getPiece method, of class Game.
     */
    @Test
    public void testGetPiece1() {
        System.out.println("test normal pour la methode getPiece"
                + "qui initialise les rangs de pions");
        Game instance = new Game();
        instance.start();

        Position pos = new Position(1, 2);

        Piece expResult = new Pawn(WHITE);
        Piece result = instance.getPiece(pos);
        assertEquals(expResult, result);
    }

    @Test
    public void testGetPiece2() {
        System.out.println("test normal pour la methode getPiece"
                + "qui initialise les rangs de pions");
        Game instance = new Game();
        instance.start();

        Position pos = new Position(6, 2);

        Piece expResult = new Pawn(BLACK);
        Piece result = instance.getPiece(pos);
        assertEquals(expResult, result);
    }

    /**
     * Test of getCurrentPlayer method, of class Game.
     */
    @Test
    public void testGetCurrentPlayer() {
        System.out.println("test pour methode getCurrentPlayer");

        Game instance = new Game();
        instance.start();

        Player expResult = new Player(WHITE);

        Player result = instance.getCurrentPlayer();
        assertEquals(expResult, result);
    }

    /**
     * Test of getOppositePlayer method, of class Game.
     */
    @Test
    public void testGetOppositePlayer() {
        System.out.println("test pour la methode getOppositePlayer ");

        Game instance = new Game();
        instance.start();

        Player expResult = new Player(BLACK);

        Player result = instance.getOppositePlayer();
        assertEquals(expResult, result);
    }

    /**
     * Test of isCurrentPlayerPosition method, of class Game.
     */
    @Test
    public void testIsCurrentPlayerPosition() {
        System.out.println("test pour la methode isCurrentPlayerPosition");

        Game instance = new Game();
        instance.start();

        Position pos = new Position(1, 4);

        boolean expResult = true;
        boolean result = instance.isCurrentPlayerPosition(pos);
        assertEquals(expResult, result);
    }

    /**
     * Test of isCurrentPlayerPosition method, of class Game.
     */
    @Test
    public void testIsCurrentPlayerPosition2() {
        System.out.println("test pour la methode isCurrentPlayerPosition "
                + "pour le throw new Illegal argument");

        Game instance = new Game();
        instance.start();
        assertThrows(IllegalArgumentException.class, () -> {
            Position pos = new Position(9, 23);
            instance.getPiece(pos);
        });
        //Position pos = new Position(9,4);
        //assertThrows(IllegalArgumentException.class,() -> new Position(9,4));
        //boolean expResult = true;
        //boolean result = instance.isCurrentPlayerPosition(pos);
        //assertEquals(expResult, result);
    }

    /**
     * Test of movePiecePosition method, of class Game.
     */
    @Test
    public void testMovePiecePosition() {
        System.out.println("test pour la methode movePiecePosition qui ne sont pas dans le board");
        //Position oldPos = null;
        //Position newPos = null;

        Game instance = new Game();
        instance.start();
        assertThrows(IllegalArgumentException.class, () -> {
            Position oldPos = new Position(12, 4);
            instance.getPiece(oldPos);
            Position newPos = new Position(34, 3);
            instance.getPiece(newPos);
        });

        //instance.movePiecePosition(oldPos, newPos);
    }
//   @Test
//   public void testGameOver1(){
//       System.out.println("test for the method GameOver when there's no more white checks");
//       Game game = new Game(); //white checks
//       game.start(); //initalise
//       game.getBoard().dropPiece(new Position(1, 0));
//       game.getBoard().dropPiece(new Position(1, 1));
//       game.getBoard().dropPiece(new Position(1, 2));
//       game.getBoard().dropPiece(new Position(1, 3));
//       game.getBoard().dropPiece(new Position(1, 4));
//       game.getBoard().dropPiece(new Position(1, 5));
//       game.getBoard().dropPiece(new Position(1, 6));
//       game.getBoard().dropPiece(new Position(1, 7));
//       
//       boolean expResult = true;
//       boolean result = game.isGameOver();
//       assertEquals(expResult, result);
//   
//   }

    @Test
    public void testIsGameOver2() {
        System.out.println("test for the method game over when it's false");
        Game game = new Game();
        game.start();
        boolean expResult = false;
        boolean result = game.isGameOver();
        assertEquals(expResult, result);
    }

    @Test
    public void testCheckMate() {
        System.out.println("test pour echec et mat : aucun coup valide ");
        Game game = new Game();
        game.start();

        game.movePiecePosition(new Position(1, 6), new Position(3, 6));
        game.movePiecePosition(new Position(6, 4), new Position(4, 4));
        game.movePiecePosition(new Position(1, 5), new Position(2, 5));

        game.movePiecePosition(new Position(7, 3), new Position(3, 7)); //Queen Black
        TestUtils.displayBoard(game);

        GameState expResult = GameState.CHECK_MATE;
        GameState result = game.getState();
        assertEquals(expResult, result);
    }

    @Test
    public void testEchecEchec() {
        System.out.println("test de  joueurs en échec / échec");
        Game game = new Game();
        game.start();

        game.movePiecePosition(new Position(1, 4), new Position(3, 4)); //w

        game.movePiecePosition(new Position(6, 2), new Position(4, 2)); //b

        game.movePiecePosition(new Position(0, 6), new Position(2, 5)); // White Knight

        game.movePiecePosition(new Position(6, 3), new Position(5, 3)); //b

        game.movePiecePosition(new Position(0, 5), new Position(4, 1)); //Bischop White
        //TestUtils.displayBoard(game);

        GameState expResult = GameState.CHECK;
        GameState result = game.getState();
        assertEquals(expResult, result);

    }

    @Test
    public void testMatPat() {
        System.out.println("test pour mat/pat");
        Game game = new Game();
        game.start();

        Board board = game.getBoard();
        for (int i = 0; i <= 7; i++) {
            for (int row : List.of(0, 1, 6, 7)) {
                board.dropPiece(new Position(row, i));
            }

        }

        //TestUtils.displayBoard(game);
        Piece KingB = new King(BLACK); //b
        board.setPiece(KingB, new Position(7, 0));

        Piece QueenW = new Queen(WHITE);
        board.setPiece(QueenW, new Position(5, 1));

        Piece KingW = new King(WHITE);
        board.setPiece(KingW, new Position(3, 2));
        game.movePiecePosition(new Position(3, 2), new Position(4, 2));

        GameState expResult = GameState.STALE_MATE;
        GameState result = game.getState();
        assertEquals(expResult, result);

    }

}
