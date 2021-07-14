package equippingcharacters.items;

import java.util.Objects;

/**
 * A class which represents the footwear of the character.
 */
public final class FootWear extends AbstractItem implements OffensiveItem {
  private final int offensiveStat;

  /**
   * The constructor for the footWear --> footwears only have an offensive stat.
   *
   * @param name          The name of the item.
   * @param isCursed      Whether the item is cursed.
   * @param health        The number of usages of the item.
   * @param offensiveStat The offensive stat of the item.
   */
  public FootWear(String name, boolean isCursed, int health, int offensiveStat) {
    super(name, isCursed, health);
    this.offensiveStat = offensiveStat;
  }

  @Override
  public int getOffensiveStat() {

    return this.isCursed() && this.offensiveStat > 0 ? -this.offensiveStat : offensiveStat;
  }

  @Override
  protected boolean equalsFootWear(FootWear footWear) {
    return this.getName() == footWear.getName()
        && this.getOffensiveStat() == footWear.getOffensiveStat();
  }

  @Override
  public boolean equals(Object obj) {
    if (obj instanceof AbstractItem) {
      AbstractItem abstractItem = (AbstractItem) obj;
      return abstractItem.equalsFootWear(this);
    }
    return false;
  }

  @Override
  public int compareTo(Items o) {
    if (o instanceof FootWear) {
      FootWear footWear = (FootWear) o;
      if (this.offensiveStat > footWear.offensiveStat) {
        return 1;
      }
      if (this.offensiveStat == footWear.offensiveStat) {
        return 0;
      }
      return -1;
    }
    return 1;
  }

  @Override
  protected boolean checkTypeFootWear(Items item) {
    return true;
  }

  @Override
  public boolean checkType(Items item) {
    if (item instanceof AbstractItem) {
      AbstractItem abstractItem = (AbstractItem) item;
      return abstractItem.checkTypeFootWear(abstractItem);
    }
    return false;
  }

  @Override
  public String toString() {
    return String.format("FootWear Item; Name : %s; Health %d; Cursed : %s; Attack %d",
        this.getName(), this.getItemHealth(), this.isCursed(), this.getOffensiveStat());
  }
  
  @Override
  public int hashCode() {
    return Objects.hashCode(this);
  }
}
