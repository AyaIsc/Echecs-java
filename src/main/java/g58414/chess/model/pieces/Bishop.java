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
public class Bishop extends StraightMover {

    public Bishop(Color color) {
        super(color,
                List.of(Direction.NE, Direction.NW, Direction.SE, Direction.SW));
    }

}
