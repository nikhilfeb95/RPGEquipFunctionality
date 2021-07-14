package equippingcharacters.items;

/**
 * An interface which represents the item which a character equips in a game.
 */
public interface Items extends Comparable<Items> {

  /**
   * Get the name of the item.
   *
   * @return Get the name of the current time.
   */
  public String getName();

  /**
   * Get the health/usages of the item. If usage reaches 0 then item becomes
   * cursed.
   *
   * @return The current health of the item.
   */
  public int getItemHealth();

  /**
   * Get if the item is cursed or not.
   *
   * @return A true/false value that represents whether the item is cursed or not.
   */
  public boolean isCursed();

  /**
   * A method to check type of items.
   * 
   * @param item The item to be checked with.
   * @return a boolean type to check if they belong to a type.
   */
  public boolean checkType(Items item);
}