/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g58414.chess.controller;

import g58414.chess.model.Model;
import g58414.chess.model.Position;
import g58414.chess.view.View;
import g58414.chess.view.View;
import g58414.chess.model.Move;
import g58414.chess.model.Game;
import java.util.List;
import g58414.chess.model.Board;
import g58414.chess.model.Player;
import java.util.Random;

/**
 *
 * @author g58414
 */
public class AutoPlayController {

    private final Model model;
    private final View view;
   /* private final Position origin;
    private final Position destination;
    private Player currentPlayer;*/

    public AutoPlayController(Model model, View view/*Position origin, Position destination*/) {
        this.model = model;
        this.view = view;
        /*this.origin = origin;
        this.destination = destination;*/
    }

    public void play() {

        //boolean gameIsOver = false;
        view.displayTitle();
        model.start();

        while (!model.isGameOver()) {

            view.displayBoard();
            view.displayPlayer();
            //
            //prendre element au hasard dans liste getAllVlidMoves();
            List<Position> validsMoves = model.getAllValidMoves();
            
            Random randomizer = new Random();
            Position randomOri = validsMoves.get(randomizer.nextInt(validsMoves.size()));
            Position randomDest = validsMoves.get(randomizer.nextInt(validsMoves.size()));
            
            Position origin = randomOri;
            Position destination = randomDest;
            
            System.out.println("Execution du nouveau mouvement");
            while (!model.isValidMove(origin, destination)) {
                
                view.displayError("le programme va generer un autre mouvement !");
               //appeler getvalidmoves et prendre une des positions
            }
            model.movePiecePosition(origin, destination);
            /*int max = 7;
            int min = 0;

            int range = max - min + 1;
            int rand1 = (int) (Math.random() * range) + min;
            int rand2 = (int) (Math.random() * range) + min;

            origin = new Position(rand1, rand2);
            destination = new Position(rand1, rand2);
            */
        }
        switch (model.getState()) {
            case STALE_MATE:
                view.displayStaleMat();
                break;
            case CHECK:
                view.displayCheck();
                break;
            case CHECK_MATE:
                view.displayMat();
                break;
            default:
        }

        view.displayWinner();
        //afficher le board pour voir
        //get all valid moves , selectionner un element au hsard et l'executer.
    }

    //public List<Position> getAllValidMoves(); à utiliser 
    /*private Position newMoves(origin ,   
        this.destination ){
        List<Position> validsMoves = model.getAllValidMoves();

        int max = 7;
        int min = 0;

        int range = max - min + 1;
        int rand1 = (int) (Math.random() * range) + min;
        int rand2 = (int) (Math.random() * range) + min;

        origin = new Position(rand1, rand2);
        destination = new Position(rand1, rand2);
        for (Position present : validsMoves) {
            if (present.contains(origin) && present.contains(destination) == true) {
                return origin && destination;
            }
        }
        return origin && destination;
    }*/
    //AutoPlayChess execute sur utoplaycontroller
    //try {thread.sleep(500);} catch(InterruptedException e ) {} //500 millisecndes
}
