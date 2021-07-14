package equippingcharacters.characters;

import equippingcharacters.items.Items;

/**
 * An interface that represents the character to be equipped in the game.
 */
public interface Character {

  /**
   * A method that returns the total attack strength of the character i.e basic
   * attack + total buffs/nerfs provided by the items.
   *
   * @return An int value representing the total attack strength of the character.
   */
  public int getTotalAttackStat();

  /**
   * A method that returns the total defensive strength of the character i.e basic
   * attack + total buffs/nerfs provided by the items.
   *
   * @return An int value representing the total defensive strength of the
   *         character.
   */
  public int getTotalDefenseStat();

  /**
   * A method that gets the basic attack strength of the character.
   *
   * @return An int value representing the basic attack strength of the character.
   */
  public int getBasicAttackStat();

  /**
   * A method that gets the basic defensive strength of the character.
   *
   * @return An int value representing the basic defensive strength of the
   *         character.
   */
  public int getBasicDefenseStat();

  /**
   * Add an item that the character can use.
   *
   * @param item The item to equip the character with.
   * @return A String value which represents the item being added to the
   *         character.
   */
  public String addItem(Items item);

  /**
   * Remove an item from a character.
   *
   * @param item A item to be discarded by the character.
   * 
   */
  public void discardItem(Items item);

  /**
   * Get the hit points of the character.
   *
   * @return An integer value representing the HP of the character.
   */
  public int getHitPoints();

  /**
   * Get the name of the character.
   *
   * @return A string which has the name of the character.
   */
  public String getName();
}
