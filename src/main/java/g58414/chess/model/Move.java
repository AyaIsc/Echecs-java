/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g58414.chess.model;

/**
 *
 * @author g58414
 */
public class Move {
   private final Position origin;
   private final Position destination;

    public Move(Position origin, Position destination) {
        this.origin = origin;
        this.destination = destination;
    }
   
   @Override
    public String toString() {
        return "Move{" + "origin=" + origin + ", destination=" + destination + '}';
    }

    public Position getOrigin() {
        return origin;
    }

    public Position getDestination() {
        return destination;
    }
   
}
