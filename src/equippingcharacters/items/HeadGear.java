package equippingcharacters.items;

import java.util.Objects;

/**
 * The class that represents the HeadGear the character puts on.
 */
public final class HeadGear extends AbstractItem implements DefensiveItems {
  private final int defensiveStat;

  /**
   * The constructor for the footWear --> headGear only have an offensive stat.
   *
   * @param name          The name of the item.
   * @param isCursed      Whether the item is cursed.
   * @param health        The number of usages of the item.
   * @param defensiveStat The offensive stat of the item.
   */
  public HeadGear(String name, boolean isCursed, int health, int defensiveStat) {
    super(name, isCursed, health);
    if (!isCursed && defensiveStat < 0) {
      throw new IllegalArgumentException("Stat cant be negative for an items that isn't cursed");
    }
    this.defensiveStat = isCursed && defensiveStat < 0 ? -defensiveStat : defensiveStat;
  }

  @Override
  public int getDefensiveStat() {
    return this.isCursed() && defensiveStat > 0 ? -defensiveStat : defensiveStat;
  }

  @Override
  protected boolean equalsHeadGear(HeadGear headGear) {
    return this.getName() == headGear.getName()
        && this.getDefensiveStat() == headGear.getDefensiveStat();
  }

  @Override
  public boolean equals(Object obj) {
    if (obj instanceof AbstractItem) {
      AbstractItem abstractItem = (AbstractItem) obj;
      return abstractItem.equalsHeadGear(this);
    }
    return false;
  }

  @Override
  public int compareTo(Items o) {
    if (o instanceof HeadGear) {
      HeadGear headGear = (HeadGear) o;
      if (this.defensiveStat > headGear.getDefensiveStat()) {
        return 1;
      }
      if (this.defensiveStat == headGear.getDefensiveStat()) {
        return 0;
      }
      return -1;
    }
    return 1;
  }

  @Override
  protected boolean checkTypeHeadGear(Items item) {
    return true;
  }

  @Override
  public boolean checkType(Items item) {
    if (item instanceof AbstractItem) {
      AbstractItem abstractItem = (AbstractItem) item;
      return abstractItem.checkTypeHeadGear(abstractItem);
    }
    return false;
  }

  @Override
  public String toString() {
    return String.format("HeadGear Item; Name : %s; Health %d; Cursed : %s; Defense %d",
        this.getName(), this.getItemHealth(), this.isCursed(), this.getDefensiveStat());
  }
  
  @Override
  public int hashCode() {
    return Objects.hashCode(this);
  }
}
