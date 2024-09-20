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
 * @author ayout
 */
public class Queen extends StraightMover {

    public Queen(Color color) {
        super(color, List.of(Direction.values()));
    }
}
