/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g58414.chess.model;

import g58414.chess.model.pieces.Piece;
import static g58414.chess.model.Color.BLACK;
import static g58414.chess.model.Color.WHITE;
import g58414.chess.model.pieces.Bishop;
import g58414.chess.model.pieces.King;
import g58414.chess.model.pieces.Knight;
import java.util.List;
import g58414.chess.model.pieces.Pawn;
import g58414.chess.model.pieces.Queen;
import g58414.chess.model.pieces.Rook;
import java.util.ArrayList;

/**
 *
 * @author ayout
 */
public class Game implements Model {

    private final Board board;
    private final Player white;
    private final Player black;
    private Player currentPlayer;
    private final King whiteKing;
    private final King blackKing;
    private GameState state;

    /**
     * constructor of our method that creates a Black Player , a White Player
     * and a new empty board for the game.
     */
    public Game() {
        board = new Board();
        white = new Player(WHITE);
        black = new Player(BLACK);
        blackKing = new King(BLACK);
        whiteKing = new King(WHITE);
        state = GameState.PLAY;
    }

    @Override
    public void start() {
        Pawn blackPawn = new Pawn(BLACK);
        Pawn whitePawn = new Pawn(WHITE);

        Knight blackKnight = new Knight(BLACK);
        Knight whiteKnight = new Knight(WHITE);

        Queen blackQueen = new Queen(BLACK);
        Queen whiteQueen = new Queen(WHITE);

        Rook blackRook = new Rook(BLACK);
        Rook whiteRook = new Rook(WHITE);

        Bishop blackBishop = new Bishop(BLACK);
        Bishop whiteBishop = new Bishop(WHITE);

        currentPlayer = white;

        // a verif 
        for (int i = 0; i <= 7; i++) { //board length
            board.setPiece(blackPawn, new Position(6, i));
        }
        for (int i = 0; i <= 7; i++) {
            board.setPiece(whitePawn, new Position(1, i));
        }

        board.setPiece(blackRook, new Position(7, 0));
        board.setPiece(blackRook, new Position(7, 7));

        board.setPiece(blackKnight, new Position(7, 1));
        board.setPiece(blackKnight, new Position(7, 6));

        board.setPiece(blackBishop, new Position(7, 2));
        board.setPiece(blackBishop, new Position(7, 5));

        board.setPiece(blackQueen, new Position(7, 3));
        board.setPiece(blackKing, new Position(7, 4));

        board.setPiece(whiteRook, new Position(0, 0));
        board.setPiece(whiteRook, new Position(0, 7));

        board.setPiece(whiteKnight, new Position(0, 1));
        board.setPiece(whiteKnight, new Position(0, 6));

        board.setPiece(whiteBishop, new Position(0, 2));
        board.setPiece(whiteBishop, new Position(0, 5));

        board.setPiece(whiteQueen, new Position(0, 3));
        board.setPiece(whiteKing, new Position(0, 4));

    }

    /**
     * Get the piece of the board located on a given position
     *
     * @param pos the position
     * @throws IllegalArgumentException pos is not located on the board.
     * @return the piece located at P
     */
    @Override
    public Piece getPiece(Position pos) {
        /*if(!board.contains(pos)){ //verif pour static de contains dcp
            throw new IllegalArgumentException("pos is not located on the board");
        }*/ // throw new IllegalArgument se trouve directement dans la methode getPiece. 
        return board.getPiece(pos);
    }

    /**
     * Getter for the current player.
     *
     * @return the current player.
     */
    @Override
    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    /**
     * Getter for the second player.
     *
     * @return the player that is waiting
     */
    @Override
    public Player getOppositePlayer() {
        if (currentPlayer.equals(black)) {
            return white;
        }
        return black;
    }

    /**
     * Check if the square at the given position is occupied by a piece of the
     * current player.
     *
     * @param pos the position
     * @return true if the position is occupied by a piece of the current
     * player, false otherwise.
     * @throws IllegalArgumentException if the position is not located on the
     * board.
     */
    @Override
    public boolean isCurrentPlayerPosition(Position pos) {
        if (!board.contains(pos)) {
            throw new IllegalArgumentException("the Position isn't on the board"); //va afficher pourquoi pas valide car relié
        }
        //+ court ?
        /*boolean isCurrentPlayerPosition = true;
        if (board.getPiece(pos) == null) {
            isCurrentPlayerPosition = false;
        }
        if (currentPlayer.equals(black)) {
            if (board.containsOppositeColor(pos, BLACK)) {
                isCurrentPlayerPosition = false;
            }
        }
        if (currentPlayer.equals(white)) {
            if (board.containsOppositeColor(pos, WHITE)) {
                isCurrentPlayerPosition = false;
            }
        }*/
        return !board.containsOppositeColor(pos, currentPlayer.getColor())
                && !board.isFree(pos);
    }

    /**
     * Moves a piece from one position of the chess board to another one. If the
     * game is not over, change the current player.
     *
     * @param oldPos the current position
     * @param newPos the new position of the board where to put the piece
     * @throws IllegalArgumentException if 1) oldPos or newPos are not located
     * on the board, or 2) oldPos does not contain a piece, or 3) the piece does
     * not belong to the current player, or 4) the move is not valid for the
     * piece located at position oldPos
     */
    @Override
    public void movePiecePosition(Position oldPos, Position newPos) {
        // TODO UTILISER ISVALIDMOVE
        if (!isValidMove(oldPos, newPos)) {
            throw new IllegalArgumentException("the move is not valid ! ");
        }
//        if (!board.contains(newPos) || !board.contains(oldPos)) {
//            throw new IllegalArgumentException("oldPos or newPos are not located on the board");
//        }
//        if (board.isFree(oldPos)) {
//            throw new IllegalArgumentException("oldPos does not contain a piece");
//        }
//        if (!isCurrentPlayerPosition(oldPos)) {
//            throw new IllegalArgumentException("the piece does not belong to the current player");
//        }
//        if (!(getPossibleMoves(oldPos)).contains(newPos)) {
//            throw new IllegalArgumentException("the move is not valid for the piece located at position oldPos");
//        }
        board.setPiece(board.getPiece(oldPos), newPos); //corection erreur de main (expetions sans avoir initaliser)
        board.dropPiece(oldPos);
        //plus aucun move valid de l'adversaire = chackmate
        //si echec prend le joueur opposé && qu'il a plus de moves dispo = check et mat!!
        if (echec(this.getOppositePlayer()) && !stillMoves(getOppositePlayer())) {
            state = GameState.CHECK_MATE;
        } else if (echec(getOppositePlayer()) && stillMoves(getOppositePlayer())) {
            //king est en danger ( echec ) et qu'il ya encore des mov dispo
            state = GameState.CHECK;
        } else if (!echec(getOppositePlayer()) && !stillMoves(getOppositePlayer())) {
            state = GameState.STALE_MATE;
        } else {
            state = GameState.PLAY;
        }
        currentPlayer = getOppositePlayer();

    }

    /**
     * Check if the game is over or not
     *
     * @return true if the game is over, false otherwise.
     */
    @Override

    public boolean isGameOver() {
        //boolean gameOver = true;
        List<Position> partie = board.getPositionOccupiedBy(currentPlayer);
//        if (partie.isEmpty()) { //si liste vide = finS
//            return true; //si vide s'arrete direct
//        }
        for (Position pos : partie) {
            if (!getPossibleMoves(pos).isEmpty()) {
                return false;
            }
        }
        return true;
//        for (int i = 0; i < partie.size(); i++) {
//            if (!(this.getPossibleMoves(partie.get(i)).isEmpty())) {
//                gameOver = false;
//            }
//        }
//        
//        return gameOver;
    }

    /**
     * Get the possible moves for the piece located at the specified position.
     *
     * @param position the position of the piece
     * @return the list of admissible positions.
     */
    @Override
    public List<Position> getPossibleMoves(Position position) {
        return board.getPiece(position).getPossibleMoves(position, board);

//        List<Position> move = new ArrayList();
//        move.addAll(board.getPiece(position).getPossibleMoves(position, board)); //ds la classe piece où il ya cette methode
//        return move;
    }

    //pour test Game
    Board getBoard() {
        return board;
    }

    /**
     * getter for GameState
     *
     * @return game's state
     */
    @Override
    public GameState getState() {
        return state;
    }

    /**
     * checks if the move oldPos to newPos is valid
     *
     * @param oldPos
     * @param newPos
     * @return true if it's valid , false otherwise.
     */
    @Override
    public boolean isValidMove(Position oldPos, Position newPos) {
        // Est-ce qu'on peut supposer que oldPos est une position du joueur courant ?
        /*if (board.isFree(oldPos)) {
            throw new IllegalArgumentException("the inital position doesn't contain any piece");
        }*/
        if (!isCurrentPlayerPosition(oldPos)) {
            throw new IllegalArgumentException("The initial position does not belong to the current player.");
        }
        if (!board.getPiece(oldPos).getPossibleMoves(oldPos, board).contains(newPos)) { //prend oldpps , mouvement possible de oldpos , voit si c'est dispo avec newpos
            throw new IllegalArgumentException("the new position is not a possible move");
        }
        boolean valid = true;
        Player player = board.getPiece(oldPos).getColor() == BLACK ? black : white;
        Piece back = getPiece(newPos); //piece a bouger pr la pos

        board.setPiece(getPiece(oldPos), newPos); //la bouger
        board.dropPiece(oldPos);//perdre oldpos

        valid = echec(player);

        /*valid = !(board.getPositionOccupiedBy(black).contains(newPos)
                && getCapturePositions(white).contains(board.getPiecePosition(blackKing)));

        valid = !(board.getPositionOccupiedBy(white).contains(newPos)
                && getCapturePositions(black).contains(board.getPiecePosition(whiteKing)));*/
        board.setPiece(getPiece(newPos), oldPos);
        board.setPiece(back, newPos);

        return valid;

    }
// cette methode lle a toute les position que le joueur peut capturer

    /**
     * establishes all the positions where a player can capture another piece
     *
     * @param player
     * @return
     */
    private List<Position> getCapturePositions(Player player) {
        List<Position> capturePositions = new ArrayList();
        List<Position> occupiedPositions = board.getPositionOccupiedBy(player);

        for (int i = 0; i < occupiedPositions.size(); i++) {
            capturePositions.addAll(
                    board.getPiece(occupiedPositions.get(i)).getCapturePosition(occupiedPositions.get(i), board));
        }
        return capturePositions;
    }

    /**
     * Inform us if a player has its king in the capture positions of the
     * opponent with a boolean.
     *
     * @param player
     * @return true if it is false if it's not.
     */
    private boolean echec(Player player) {
        King playerKing = player.getColor() == BLACK ? blackKing : whiteKing;
        Player oppositePlayer = player.getColor().opposite() == BLACK ? black : white;
        return getCapturePositions(oppositePlayer).contains(board.getPiecePosition(playerKing));
    }

    private boolean stillMoves(Player player) {
        //prend tt les position qu'occupe le player
        List<Position> occup = board.getPositionOccupiedBy(player);

        Piece back;
        //parcours liste de places occupées par le joueur opposé
        for (Position occupied : occup) {
            //parcours les moves possibles de occupied (ocupied = parcours de occup)
            for (Position destination : getPossibleMoves(occupied)) {
                if (isValidMove(occupied, destination)) {
                    return true;
                }
                /*//back = prend piece de moves possible des pieces qui occupent le plateau
                back = getPiece(destination);
                //piece prise et la position : pos occupé , et ses possibles moves 
                board.setPiece(getPiece(occupied), destination);
                //ca bouge
                board.dropPiece(occupied);
                boolean echec = echec(player);
                //prend pieces de la destination( aka possible moves de pieces),et occupied = poss moves du player
                board.setPiece(getPiece(destination), occupied);
                //ensuite destination = possmoves des pieces qui occupent la place et la destination
                board.setPiece(back, destination);
                //si c'est pas un echec alors clean
                if (!echec) {
                    return true;
                }*/
            }

        }
        return false;
    }
    /**
     * retourne tout les mouvements valides du joueur courant.
     * @return 
     */
    public List<Position> getAllValidMoves(){
        //prene all position , mouvement possible , is valid si oui on ajoute
        List<Position> occup = board.getPositionOccupiedBy(currentPlayer); //je recupere l'ensemble de position du joueur courant
        List<Position> valids = new ArrayList<>();
        
        for(Position poss : occup ){
            for( Position destination : getPossibleMoves(poss)){ //connaitree les destinations
                if(isValidMove(poss, destination)==true){
                    valids.add(destination);
                }
            }
        }
        return valids;
    }
}
