package com.github.cc3002.finalreality.model.character.player;

import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.weapon.IWeapon;
import org.jetbrains.annotations.NotNull;
import java.util.Objects;
import java.util.concurrent.BlockingQueue;

/**
 * A class that holds all the information of a thief class.
 *
 * @author Ignacio Slater Muñoz
 * @author Nicolás García Ríos
 */

public class Thief extends AbstractPlayerCharacter {

    /**
     * Creates a new player.
     *
     * @param name
     *     the player's name
     * @param turnsQueue
     *     the queue with the player waiting for their turn
     * @param hp
     *     the player's health points
     * @param defense
     *     the character's defense
     */
    public Thief(@NotNull String name,
                 @NotNull BlockingQueue<ICharacter> turnsQueue,
                 @NotNull int hp,
                 @NotNull int defense) {
        super(name, turnsQueue, hp, defense);
    }

    /**
     * equips weapon to the player Using Double Dispatch.
     */
    @Override
    public void equip(IWeapon weapon){
        if (this.IsAlive()){
            weapon.equipToThief(this);
        }
    }

    /**
     * getStringClass() returns the name of its class in a String form. This method was created for the GUI only
     */
    public String getStringClass(){
        return "Thief";
    }

    /**
     * both methods equals() and hashcode() are different depending of the type of character and
     * the type of Character, hence this methods cannot be used with inheritance
     */
    @Override
    public int hashCode() {
        return Objects.hash(getName(), getHP(), getDefense());
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Thief)) {
            return false;
        }
        final Thief that = (Thief) o;
        return getName() == that.getName() &&
                getHP() == that.getHP() &&
                getDefense() == that.getDefense();
    }
}
