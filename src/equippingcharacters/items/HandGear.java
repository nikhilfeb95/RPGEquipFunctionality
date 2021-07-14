package equippingcharacters.items;

import java.util.Objects;

/**
 * A class which represents the hand gears.
 */
public final class HandGear extends AbstractBothStats {

  /**
   * The constructor for the hand gears.
   *
   * @param name          The name of the handgear.
   * @param isCursed      Whether the handgear is cursed or not.
   * @param health        The health if the item.
   * @param offensiveStat The offensive stat of the item.
   * @param defensiveStat The defensive stat of the item.
   */
  public HandGear(String name, boolean isCursed, int health, int offensiveStat, int defensiveStat) {
    // No checks here as all the necessary checks are done by the super constructor.
    super(name, isCursed, health, offensiveStat, defensiveStat);
  }

  @Override
  protected boolean equalsHandGear(HandGear handGear) {
    return this.getName() == handGear.getName()
        && this.getOffensiveStat() == handGear.getOffensiveStat()
        && this.getDefensiveStat() == handGear.getDefensiveStat();
  }

  @Override
  public boolean equals(Object obj) {
    if (obj instanceof AbstractItem) {
      AbstractItem abstractItem = (AbstractItem) obj;
      return abstractItem.equalsHandGear(this);
    }
    return false;
  }

  @Override
  protected boolean checkTypeHandGear(Items item) {
    return true;
  }

  @Override
  public boolean checkType(Items item) {
    if (item instanceof AbstractItem) {
      AbstractItem abstractItem = (AbstractItem) item;
      return abstractItem.checkTypeHandGear(abstractItem);
    }
    return false;
  }
  
  @Override
  public String toString() {
    return String.format(
        "HandGear Item; Name : %s; Health %d; Cursed : %s; Attack : %d;" + "Defense %d",
        this.getName(), this.getItemHealth(), this.isCursed(), this.getOffensiveStat(),
        this.getDefensiveStat());
  }
  
  @Override
  public int hashCode() {
    return Objects.hashCode(this);
  }
}
