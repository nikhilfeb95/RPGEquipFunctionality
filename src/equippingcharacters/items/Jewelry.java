package equippingcharacters.items;

import java.util.Objects;

/**
 * The class which represents the Jewelries which the characters use.
 */
public final class Jewelry extends AbstractBothStats {

  /**
   * The constructor for the hand gears.
   *
   * @param name          The name of the handgear.
   * @param isCursed      Whether the handgear is cursed or not.
   * @param health        The health if the item.
   * @param offensiveStat The offensive stat of the item.
   * @param defensiveStat The defensive stat of the item.
   */
  public Jewelry(String name, boolean isCursed, int health, int offensiveStat, int defensiveStat) {
    // No checks here as all the necessary checks are done by the super constructor.
    super(name, isCursed, health, offensiveStat, defensiveStat);
  }

  @Override
  protected boolean equalsJewelry(Jewelry jewelry) {
    return this.getName() == jewelry.getName()
        && this.getOffensiveStat() == jewelry.getOffensiveStat()
        && this.getDefensiveStat() == jewelry.getDefensiveStat();
  }

  @Override
  public boolean equals(Object obj) {
    if (obj instanceof AbstractItem) {
      AbstractItem abstractItem = (AbstractItem) obj;
      return abstractItem.equalsJewelry(this);
    }
    return false;
  }

  @Override
  protected boolean checkTypeJewelry(Items item) {
    return true;
  }

  @Override
  public boolean checkType(Items item) {
    if (item instanceof AbstractItem) {
      AbstractItem abstractItem = (AbstractItem) item;
      return abstractItem.checkTypeJewelry(abstractItem);
    }
    return false;
  }

  @Override
  public String toString() {
    return String.format(
        "Jewelry Item; Name : %s; Health %d; Cursed : %s; Attack : %d;" + "Defense %d",
        this.getName(), this.getItemHealth(), this.isCursed(), this.getOffensiveStat(),
        this.getDefensiveStat());
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(this);
  }
  
}
