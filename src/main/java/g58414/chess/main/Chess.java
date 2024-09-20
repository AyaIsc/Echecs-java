/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g58414.chess.main;

import g58414.chess.controller.Controller;
import g58414.chess.controller.AutoPlayController;
import g58414.chess.model.Game;
import g58414.chess.model.Model;
import g58414.chess.view.TextView;

/**
 *
 * @author ayout
 */
public class Chess {

    public static void main(String[] args) {
        Model game = new Game();
        //Controller controller = new Controller(game, new TextView(game));
        AutoPlayController controller2 = new AutoPlayController(game, new TextView(game));
        controller2.play();
    }

}
