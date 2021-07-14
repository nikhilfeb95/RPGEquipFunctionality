package equippingcharacters.treasurechest;

import equippingcharacters.items.GearTypes;
import equippingcharacters.items.Items;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * A class which represents the treasure chest from where the characters draw
 * out their equipment from.
 */
public final class TreasureChest {
  List<Items> itemsList;

  /**
   * A constructor for the treasure chest where we enter the List of items.
   * 
   * @param itemsList The list of items to be passed.
   */
  public TreasureChest(List<Items> itemsList) {
    if (itemsList == null) {
      throw new IllegalArgumentException("Can't pass null values to the constructor");
    }
    if (verifyTreasureChest(itemsList)) {
      this.itemsList = itemsList;
      return;
    }
    throw new IllegalArgumentException("Your treasure chest is not valid");
  }

  /**
   * Get the list of items from the treasure chest.
   * 
   * @return The list of items.
   */
  public List<Items> getItemsList() {
    // sending a copy of the original list.
    return this.itemsList.stream().collect(Collectors.toList());
  }

  /**
   * Add the item to the treasure chest.
   * 
   * @param item The item from the treasure chest.
   */
  public void addItem(Items item) {
    if (item != null) {
      this.itemsList.add(item);
      return;
    }
    throw new IllegalArgumentException("Do not enter null values");
  }

  /**
   * Verify if the treasure chest is valid or not.
   *
   * @return A true value indicates that the treasure chest passed is valid.
   */
  private boolean verifyTreasureChest(List<Items> items) {
    Map<String, Integer> typeCounts = new HashMap<>();
    typeCounts.put("HeadGear", 0);
    typeCounts.put("HandGear", 0);
    typeCounts.put("FootWear", 0);
    typeCounts.put("Jewelry", 0);

    for (Items item : items) {
      if (GearTypes.getHeadGears().checkType(item)) {
        typeCounts.put("HeadGear", typeCounts.get("HeadGear") + 1);
      }
      if (GearTypes.getFootWears().checkType(item)) {
        typeCounts.put("FootWear", typeCounts.get("FootWear") + 1);
      }
      if (GearTypes.getHandGear().checkType(item)) {
        typeCounts.put("HandGear", typeCounts.get("HandGear") + 1);
      }
      if (GearTypes.getJewelry().checkType(item)) {
        typeCounts.put("Jewelry", typeCounts.get("Jewelry") + 1);
      }
    }

    return (typeCounts.get("HeadGear") >= 4 || typeCounts.get("HandGear") >= 15
        || typeCounts.get("FootWear") >= 8 || typeCounts.get("Jewelry") >= 15); 
  }
}
