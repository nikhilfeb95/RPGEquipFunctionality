package equippingcharacters.items;

/**
 * An interface which represents all the defensive items.
 */
public interface OffensiveItem extends Items {
  /**
   * Get the offensive stat of the item.
   *
   * @return the offensive stat of the item.
   */
  public int getOffensiveStat();
}
