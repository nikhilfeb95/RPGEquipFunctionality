package equippingcharacters.items;

/**
 * An abstract class where all the common methods and fields for all kinds of weapons are
 * stored.
 */
public abstract class AbstractItem implements Items {
  private final String name;
  private boolean isCursed;
  private int health;

  /**
   * A constructor for the abstract item class.
   * 
   * @param name     The name of the character.
   * @param isCursed Whether the item is cursed or not.
   * @param health   The health of the character.
   */
  protected AbstractItem(String name, boolean isCursed, int health) {
    this.name = name;
    this.isCursed = isCursed;
    if (isCursed && health > 0) {
      throw new IllegalArgumentException("A cursed item cannot have positive health");
    }
    this.health = health;
  }

  @Override
  public String getName() {
    return this.name;
  }

  @Override
  public int getItemHealth() {
    return this.health;
  }

  @Override
  public boolean isCursed() {
    return this.isCursed;
  }

  /**
   * Reduce the number of usages of a particular item after use.
   */
  public void useItem() {
    if (health > 0) {
      this.health--;
    }
    // turn the item into a cursed one after
    if (health == 0 && !isCursed) {
      isCursed = true;
    }
  }

  /**
   * Double dispatching equals for the HeadGear.
   *
   * @param headGear A parameter of type HeadGear.
   * @return A true value if equal else false.
   */
  protected boolean equalsHeadGear(HeadGear headGear) {
    return false;
  }

  /**
   * Double dispatching equals for the HandGear.
   *
   * @param handGear A parameter of type HeadGear.
   * @return A true value if equal else false.
   */
  protected boolean equalsHandGear(HandGear handGear) {
    return false;
  }

  /**
   * Double dispatching equals for the FootWear.
   *
   * @param footWear A parameter of type FootWear.
   * @return A true value if equal else false.
   */
  protected boolean equalsFootWear(FootWear footWear) {
    return false;
  }

  /**
   * Double dispatching equals for the Jewelry.
   *
   * @param jewelry A parameter of type Jewelry.
   * @return A true value if equal else false.
   */
  protected boolean equalsJewelry(Jewelry jewelry) {
    return false;
  }

  /**
   * Double dispatching checkType for headGear.
   *
   * @return A true indicates same type.
   */
  protected boolean checkTypeHeadGear(Items item) {
    return false;
  }

  /**
   * Double dispatching checkType for handGear.
   *
   * @return A true indicates same type.
   */
  protected boolean checkTypeHandGear(Items item) {
    return false;
  }

  /**
   * Double dispatching checkType for footWear.
   *
   * @return A true indicates same type.
   */
  protected boolean checkTypeFootWear(Items item) {
    return false;
  }

  /**
   * Double dispatching checkType for jewelry.
   *
   * @return A true indicates same type.
   */
  protected boolean checkTypeJewelry(Items item) {
    return false;
  }
}
