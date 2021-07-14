package equippingcharacters.items;

/**
 * A class to get static instance of particular types. Used by the double
 * dispatch method to compare types. Required to ensure the classes belong to a
 * particular type.
 */
public final class GearTypes {

  public static HeadGear getHeadGears() {
    return new HeadGear("1", false, 4, 2);
  }

  public static FootWear getFootWears() {
    return new FootWear("1", false, 3, 3);
  }

  public static Jewelry getJewelry() {
    return new Jewelry("1", false, 3, 0, 2);
  }

  public static HandGear getHandGear() {
    return new HandGear("1", false, 3, 4, 0);
  }
}
