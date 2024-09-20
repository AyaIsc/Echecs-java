/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g58414.chess.model;

import java.util.Objects;

/**
 * Class of the player
 *
 * @author ayout
 */
public class Player {

    private final Color color;

    /**
     * Constructor of the class Player that associate a the player with the
     * given color in the @param
     *
     * @param color
     */
    public Player(Color color) {
        this.color = color;
    }

    /**
     * Getter of Color that gives us access to the color of the player.
     *
     * @return
     */
    public Color getColor() {
        return color;
    }

    @Override
    public String toString() {
        return "Player" + color;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.color);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Player other = (Player) obj;
        if (this.color != other.color) {
            return false;
        }
        return true;
    }

}
