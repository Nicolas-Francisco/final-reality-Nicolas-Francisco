package com.github.cc3002.finalreality.model.character;

import com.github.cc3002.finalreality.model.controller.GameController;
import com.github.cc3002.finalreality.model.controller.observer.IEventHandler;

/**
 * This represents a character from the game.
 * A character can be controlled by the player or by the CPU (an enemy).
 *
 * @author Ignacio Slater Muñoz
 * @author Nicolás García Ríos
 */
public interface ICharacter {

  /**
   * Sets a scheduled executor to make this character (thread) wait for {@code speed / 10}
   * seconds before adding the character to the queue.
   */
  void waitTurn();

  /**
   * Returns this character's name.
   */
  String getName();

  /**
   * Returns this character's health points.
   */
  int getHP();

  /**
   * Returns this character's Defense.
   */
  int getDefense();

  /**
   * Adds this character to the turns queue.
   */
  void addToQueue();

  /**
   * the character attacks to another character.
   */
  void attackTo(ICharacter character);

  /**
   * the character is attacked by character.
   */
  void attacked(int BaseDamage);

  /**
   * Returns this character State (alive or dead)
   */
  boolean IsAlive();

  /**
   * Sets this character Hp to another value
   */
  void setHP(int health);

  /**
   * Sets this character Defense to another value
   */
  void setDefense(int defense);

  /**
   * Adds a listener to the character
   */
  void addListenerDead(IEventHandler handler);

  /**
   * Adds a listener to the character
   */
  void addListenerTurn(IEventHandler handler);

  /**
   * useTurn method. If the character is an enemy, it attacks to a random player using the controller,
   * if its not, it doesn't do anything. (We need it only for the beginTurn method in the controller,
   * using a boolean to determine if the character is an enemy or not is equal to use instanceof() method)
   */
  void useTurn(GameController controller);
}
