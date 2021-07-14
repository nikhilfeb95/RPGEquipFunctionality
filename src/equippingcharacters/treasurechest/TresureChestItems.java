package equippingcharacters.treasurechest;

import equippingcharacters.items.FootWear;
import equippingcharacters.items.HandGear;
import equippingcharacters.items.HeadGear;
import equippingcharacters.items.Items;
import equippingcharacters.items.Jewelry;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * A helper class to populate the TreasureChest.
 */
public final class TresureChestItems {

  /**
   * A method to add a list of items to a treasure chest.
   *
   * @return A list of items.
   */
  public static List<Items> getItems() {
    List<Items> itemsList = new ArrayList<Items>();
    HeadGear headGear1 = new HeadGear("helmets of Frost", false, 12, 25);
    itemsList.add(headGear1);
    HeadGear headGear2 = new HeadGear("Visors of vision", false, 11, 105);
    itemsList.add(headGear2);
    HeadGear headGear3 = new HeadGear("Cape of doom", true, 0, -25);
    itemsList.add(headGear3);
    HeadGear headGear4 = new HeadGear("Helmets of Wrath", false, 14, 90);
    itemsList.add(headGear4);

    HandGear handGear1 = new HandGear("Rings of Saturn", false, 12, 15, 0);
    itemsList.add(handGear1);
    HandGear handGear2 = new HandGear("Rings of Strength", false, 13, 12, 0);
    itemsList.add(handGear2);
    HandGear handGear3 = new HandGear("Rings of Flames", false, 4, 20, 0);
    itemsList.add(handGear3);
    HandGear handGear4 = new HandGear("Rings of Madness", false, 18, 72, 0);
    itemsList.add(handGear4);
    HandGear handGear5 = new HandGear("Rings of Lightening", false, 13, 25, 0);
    itemsList.add(handGear5);
    HandGear handGear6 = new HandGear("Gloves of Speed", false, 12, 16, 0);
    itemsList.add(handGear6);
    HandGear handGear7 = new HandGear("Gloves of Flames", false, 9, 19, 0);
    itemsList.add(handGear7);
    HandGear handGear8 = new HandGear("Gloves of Lightening", false, 4, 21, 0);
    itemsList.add(handGear8);
    HandGear handGear9 = new HandGear("Gloves of Doom", false, 8, 0, 3);
    itemsList.add(handGear9);
    HandGear handGear10 = new HandGear("Gauntlets of Mordor", false, 7, 0, 17);
    itemsList.add(handGear10);
    HandGear handGear11 = new HandGear("Rings of Truth", false, 12, 0, 16);
    itemsList.add(handGear11);
    HandGear handGear12 = new HandGear("Gauntlets of Poise", false, 5, 0, 19);
    itemsList.add(handGear12);
    HandGear handGear13 = new HandGear("Gauntlets of death", true, 0, 0, 23);
    itemsList.add(handGear13);
    HandGear handGear14 = new HandGear("Gauntlets of Ice", false, 12, 0, 55);
    itemsList.add(handGear14);
    HandGear handGear15 = new HandGear("Rings of Light", false, 12, 0, 24);
    itemsList.add(handGear15);
    HandGear handGear16 = new HandGear("Rings of Heft", false, 12, 0, 21);
    itemsList.add(handGear16);

    Jewelry jewelry1 = new Jewelry("Jewels of Venus", false, 12, 42, 0);
    itemsList.add(jewelry1);
    Jewelry jewelry2 = new Jewelry("Jade of Strength", false, 13, 37, 0);
    itemsList.add(jewelry2);
    Jewelry jewelry3 = new Jewelry("Ruby of Flames", false, 4, 19, 0);
    itemsList.add(jewelry3);
    Jewelry jewelry4 = new Jewelry("Opal of Madness", false, 18, 22, 0);
    itemsList.add(jewelry4);
    Jewelry jewelry5 = new Jewelry("Diamond of Lightening", false, 13, 19, 0);
    itemsList.add(jewelry5);
    Jewelry jewelry6 = new Jewelry("Necklace of Speed", false, 12, 28, 0);
    itemsList.add(jewelry6);
    Jewelry jewelry7 = new Jewelry("Crimson Crystal of Cytorrak", false, 9, 41, 0);
    itemsList.add(jewelry7);
    Jewelry jewelry8 = new Jewelry("Talisman of Muur", false, 4, 16, 0);
    itemsList.add(jewelry8);
    Jewelry jewelry9 = new Jewelry("Diamond of Almandine", false, 8, 0, 3);
    itemsList.add(jewelry9);
    Jewelry jewelry10 = new Jewelry("Gold of Smaug", false, 7, 0, 25);
    itemsList.add(jewelry10);
    Jewelry jewelry11 = new Jewelry("Jewels of Lannisters", false, 12, 0, 15);
    itemsList.add(jewelry11);
    Jewelry jewelry12 = new Jewelry("Bracelets of Tyrells", false, 5, 0, 14);
    itemsList.add(jewelry12);
    Jewelry jewelry13 = new Jewelry("Stone of Agate", true, 0, 0, 34);
    itemsList.add(jewelry13);
    Jewelry jewelry14 = new Jewelry("Gauntlets of Ice", false, 12, 0, 55);
    itemsList.add(jewelry14);
    Jewelry jewelry15 = new Jewelry("Rings of Light", false, 12, 0, 16);
    itemsList.add(jewelry15);
    Jewelry jewelry16 = new Jewelry("Rings of Heft", false, 12, 0, 19);
    itemsList.add(jewelry16);

    FootWear footWear = new FootWear("Boots of Venus", false, 12, 25);
    itemsList.add(footWear);
    footWear = new FootWear("Sandals of Strength", false, 13, 45);
    itemsList.add(footWear);
    footWear = new FootWear("Sneakers of Flames", false, 4, 78);
    itemsList.add(footWear);
    footWear = new FootWear("HoverBoard of Madness", false, 18, 15);
    itemsList.add(footWear);
    footWear = new FootWear("Boots of Lightening", false, 13, 90);
    itemsList.add(footWear);
    footWear = new FootWear("Sandals of Speed", false, 12, 16);
    itemsList.add(footWear);
    footWear = new FootWear("Sneakers of Cytorrak", false, 9, 13);
    itemsList.add(footWear);
    footWear = new FootWear("HoverBoard of Muur", false, 4, 9);
    itemsList.add(footWear);

    return itemsList.stream().collect(Collectors.toList());
  }
}
