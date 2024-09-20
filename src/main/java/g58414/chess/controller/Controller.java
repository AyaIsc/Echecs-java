/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g58414.chess.controller;

import g58414.chess.model.GameState;
import g58414.chess.model.Model;
import g58414.chess.model.Position;
import g58414.chess.view.View;

/**
 *
 * @author ayout
 */
public class Controller {

    private final Model model;
    private final View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public void play() {

        //boolean gameIsOver = false;
        view.displayTitle();
        model.start();

        while (!model.isGameOver()) {
            /*
                1) Afficher le plateau de jeu et inviter le joueur courant à jouer,
                2)Demander une position de départ et d'arrivée,
                3)Jouer le coup (après avoir vérifier sa validité)
                4)Vérifier si le jeu est terminé, et mettre gameIsOver à jour
             */

            //affiche le plateau du jeu
            view.displayBoard();
            view.displayPlayer();

            //invite joueur à jouer
            System.out.println(">>>Enter the check you want to move (number&Letter)<<<");
            Position position1 = view.askPosition(); //position de départ

            while (!model.isCurrentPlayerPosition(position1)) {
                view.displayError("!the check you want to move is'nt yours!");
                position1 = view.askPosition();
            }

            System.out.println(">>>Where do you want to play your check<<<");
            Position positionNext = view.askPosition(); //position d'arrivée

            //checker la validité du mouvement qd position1 peux pas ecraser posnext
            while (!model.getPossibleMoves(position1).contains(positionNext)) {
                view.displayError(">>>this move is not allowed<<<");
                /*while (!model.isCurrentPlayerPosition(position1)) {
                    System.out.println(">>>this check is not yours , try again <<<");
                    position1 = view.askPosition();
                }*/
                System.out.println(">>>Which check do you want to move?<<<");
                position1 = view.askPosition();
                System.out.println(">>>Where do you want to place it ?<<<");
                positionNext = view.askPosition();
            }

            //jouer le coup aprés avoir vérifié sa validité.
            while (!model.isValidMove(position1, positionNext)) {
                view.displayError(">>>this movement will put you in a situation of CHECK<<<");

                System.out.println(">>>Which check do you want to move?<<<");
                position1 = view.askPosition();

                //tant que spotion du curretn player dans pos1 (pos entrée a bouger) n'est pas la sienne
                while (!model.isCurrentPlayerPosition(position1)) {
                    System.out.println(">>>this check is not yours , try again <<<");
                    position1 = view.askPosition();
                }
                System.out.println(">>>Where do you want to place it ?<<<");
                positionNext = view.askPosition();

            }
            model.movePiecePosition(position1, positionNext);

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

    }

    /*private void gameState(){
        switch(model.getState()){
            case STALE_MATE : view.displayStaleMat();
            break;
            case CHECK : view.displayCheck();
            break;
            case CHECK_MATE : view.displayMat();
            break;
            default:
        }
    } */
    //gameIsOver = model.isGameOver();

    /*try{
                model.movePiecePosition(position1, position2);
            }catch(IllegalArgumentException L){
                view.displayError(L.getMessage());
                position1 = view.askPosition();
                position2=view.askPosition();
                model.movePiecePosition(position1, position2);
            }
            gameIsOver = model.isGameOver();*/
}
