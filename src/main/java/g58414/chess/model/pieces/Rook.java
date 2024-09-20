/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g58414.chess.model.pieces;

import g58414.chess.model.Color;
import g58414.chess.model.Direction;
import java.util.List;

/**
 *
 * @author g58414
 */
public class Rook extends StraightMover {

    public Rook(Color color) {
        super(color,
                List.of(Direction.N, Direction.S, Direction.E, Direction.W)
        );
    }

}
