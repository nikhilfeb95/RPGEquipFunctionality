package equippingcharacters.characters;

import equippingcharacters.items.FootWear;
import equippingcharacters.items.GearTypes;
import equippingcharacters.items.HandGear;
import equippingcharacters.items.HeadGear;
import equippingcharacters.items.Items;
import equippingcharacters.items.Jewelry;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


/**
 * The class which implements the character interface. It takes in the basic
 * attack, defense stat and the hp of the character.
 */
public class CharacterImpl implements Character {
  // Why are none of the stats final? Usually in an RPG game the characters basic
  // stats grow as we progress through the game.
  private final String name;
  private int basicAttackStat;
  private int basicDefenceStat;
  private int totalAttackStat;
  private int totalDefenseStat;

  // Store the four kind of items the character can store.
  Items headGear;
  List<Items> footWears;
  List<Items> handGears;
  List<Items> jewelries;
  // Not final as hitPoints of a character changes with progress in the game.
  private int hitPoints;

  /**
   * The constructor for the implementation of the character class.
   *
   * @param basicAttackStat  The basic attack stat of the character.
   * @param basicDefenceStat The basic defense stat of the character.
   * @param hitPoints        The total hitpoints the character has.
   */
  public CharacterImpl(String name, int basicAttackStat, int basicDefenceStat, int hitPoints) {
    if (basicAttackStat < 0 || basicDefenceStat < 0 || hitPoints < 0) {
      throw new IllegalArgumentException("The stats cannot be negative");
    }
    this.name = name;
    this.basicAttackStat = basicAttackStat;
    this.basicDefenceStat = basicDefenceStat;
    this.hitPoints = hitPoints;
    // Initialize all the lists and the total values.
    this.totalAttackStat = basicAttackStat;
    this.totalDefenseStat = basicDefenceStat;
    footWears = new ArrayList<Items>();
    handGears = new ArrayList<Items>();
    jewelries = new ArrayList<Items>();
  }

  /**
   * A static method to get the static builder to build the object for
   * CharacterImpl.
   * 
   * @return A CharacterBuilder object.
   */
  public static CharacterBuilder builder() {
    return new CharacterBuilder();
  }

  @Override
  public int getTotalAttackStat() {
    return this.totalAttackStat;
  }

  @Override
  public int getTotalDefenseStat() {
    return this.totalDefenseStat;
  }

  @Override
  public int getBasicAttackStat() {
    return this.basicAttackStat;
  }

  @Override
  public int getBasicDefenseStat() {
    return this.totalDefenseStat;
  }

  @Override
  public int getHitPoints() {
    return this.hitPoints;
  }

  @Override
  public String getName() {
    return this.name;
  }

  @Override
  public String addItem(Items item) {
    if (item == null) {
      throw new IllegalArgumentException("null not allowed");
    }
    if (GearTypes.getHeadGears().checkType(item)) {
      HeadGear itemToAdd = (HeadGear) item;
      return addHeadGear(itemToAdd);
    }

    if (GearTypes.getHandGear().checkType(item)) {
      HandGear itemToAdd = (HandGear) item;
      return addHandGear(itemToAdd);
    }

    if (GearTypes.getFootWears().checkType(item)) {
      FootWear itemToAdd = (FootWear) item;
      return addFootWear(itemToAdd);
    }

    if (GearTypes.getJewelry().checkType(item)) {
      Jewelry itemToAdd = (Jewelry) item;
      return addJewelry(itemToAdd);
    }
    throw new IllegalArgumentException("Item should be in one of the subtypes");
  }

  @Override
  public void discardItem(Items item) {
    if (item == null) {
      throw new IllegalArgumentException("null not allowed");
    }
    if (GearTypes.getHeadGears().checkType(item)) {
      HeadGear itemToDiscard = (HeadGear) item;
      if (this.headGear.equals(itemToDiscard)) {
        discardHeadGear();
        return;
      } else {
        throw new IllegalArgumentException("A non-existent item cannot be removed.");
      }
    }

    if (GearTypes.getHandGear().checkType(item)) {
      HandGear itemToDiscard = (HandGear) item;
      discardHandGear(itemToDiscard);
      return;
    }

    if (GearTypes.getFootWears().checkType(item)) {
      FootWear itemToDiscard = (FootWear) item;
      discardFootWear(itemToDiscard);
      return;
    }

    if (GearTypes.getJewelry().checkType(item)) {
      Jewelry itemToDiscard = (Jewelry) item;
      discardJewelry(itemToDiscard);
      return;
    }
  }

  /**
   * A helper class which combines similar items into a gramatically correct
   * sentence.
   *
   * @param items The list of items to be combined.
   * @return A string with the combined items.
   */
  private String combineItems(List<? extends Items> items) {
    // base condition for the method.
    if (items.size() == 0) {
      return "None";
    }
    StringBuilder stringBuilder = new StringBuilder();
    boolean flag = false;
    int counter = 0;
    for (Items item : items) {
      if (!flag) {
        stringBuilder.append(item.getName());
        flag = true;
        counter++;
        continue;
      }
      String[] words = item.getName().split(" ");
      if (counter == items.size() - 1) {
        stringBuilder.append(String.format(" and %s", words[words.length - 1]));
        break;
      }
      stringBuilder.append(String.format(", %s", words[words.length - 1]));
      counter++;
    }
    return stringBuilder.toString();
  }

  /**
   * A private helper method to add a headgear. It will only be added if its
   * better than the item it currently holds.
   *
   * @param headGear The headgear to be added.
   */
  private String addHeadGear(HeadGear headGear) {
    // check if the headGear slot is empty or not.
    if (this.headGear == null) {
      this.headGear = headGear;
      // Add stats of the item to the total stats.
      changeStat(0, headGear.getDefensiveStat());
      return "";
    }

    // Discard the item and make necessary changes to the character stats.
    if (this.headGear.compareTo(headGear) != 1) {
      final String discardedInfo = noteDiscardedAndPickedItems(this.headGear.getName(),
          headGear.getName());
      discardHeadGear();
      this.headGear = headGear;
      changeStat(0, headGear.getDefensiveStat());
      return discardedInfo;
    }
    return "";
  }

  /**
   * A private helper to add a footWear. It will replace the item which is the
   * worst in the list.
   *
   * @param footWear The footwear to be added.
   */
  private String addFootWear(FootWear footWear) {
    // if the character has less than the limit then don't add.
    if (this.footWears.size() < 2) {
      this.footWears.add(footWear);
      changeStat(footWear.getOffensiveStat(), 0);
      return "";
    }

    // Replace if the current item is better than the worst item the character
    // holds.
    // Sort items to get the worst one of the list.
    footWears.sort(null);
    Optional<Items> items = this.footWears.stream().findFirst();
    FootWear item = (FootWear) items.get();
    if (item.compareTo(footWear) != 1) {
      final String discardedInfo = noteDiscardedAndPickedItems(item.getName(), footWear.getName());
      discardFootWear(item);
      this.footWears.add(footWear);
      changeStat(footWear.getOffensiveStat(), 0);
      return discardedInfo;
    }
    return "";
  }

  /**
   * A private helper to add a handGear. It will replace the item which is the
   * worst in the list.
   *
   * @param handGear The handGear to be added to the list.
   */
  private String addHandGear(HandGear handGear) {
    if (this.handGears.size() < 10) {
      this.handGears.add(handGear);
      changeStat(handGear.getOffensiveStat(), handGear.getDefensiveStat());
      return "";
    }

    // Replace if the current item is better than the worst item the character
    // holds.
    handGears.sort(null);
    Optional<Items> items = this.handGears.stream().findFirst();
    HandGear item = (HandGear) items.get();
    if (item.compareTo(handGear) != 1) {
      final String discardedInfo = noteDiscardedAndPickedItems(item.getName(), handGear.getName());
      discardHandGear(item);
      this.handGears.add(handGear);
      changeStat(handGear.getOffensiveStat(), handGear.getDefensiveStat());
      return discardedInfo;
    }
    return "";
  }

  /**
   * A private helper to add a handGear. As we can have unlimited jewelry we'll
   * just add it to the list.
   *
   * @param jewelry The jewelry to eb added to the list.
   */
  private String addJewelry(Jewelry jewelry) {
    this.jewelries.add(jewelry);
    changeStat(jewelry.getOffensiveStat(), jewelry.getDefensiveStat());
    return "";
  }

  /**
   * A private helper method to discard a headgear. Remove the buffs/nerfs
   * provided by the currently held headGear.
   */
  private void discardHeadGear() {
    if (this.headGear != null) {
      HeadGear gearToRemove = (HeadGear) headGear;
      changeStat(0, -gearToRemove.getDefensiveStat());
      this.headGear = null;
      return;
    }
    throw new IllegalArgumentException("Removing a non-existent item from the character");
  }

  /**
   * A private helper to add a footWear. It will replace the item which is the
   * worst in the list.
   *
   * @param footWear The footwear to be discarded.
   */
  private void discardFootWear(FootWear footWear) {
    if (this.footWears.contains(footWear)) {
      changeStat(-footWear.getOffensiveStat(), 0);
      this.footWears.remove(footWear);
      return;
    }
    throw new IllegalArgumentException("Removing a non-existent item from the character");
  }

  /**
   * A private helper to add a handGear. It will replace the item which is the
   * worst in the list.
   *
   * @param handGear The handGear to be added to the list.
   */
  private void discardHandGear(HandGear handGear) {
    if (this.handGears.contains(handGear)) {
      changeStat(-handGear.getOffensiveStat(), -handGear.getDefensiveStat());
      this.handGears.remove(handGear);
      return;
    }
    throw new IllegalArgumentException("Removing a non-existent item from the character");
  }

  /**
   * A private helper to add a handGear. As we can have unlimited jewelry we'll
   * just add it to the list.
   *
   * @param jewelry The jewelry to eb added to the list.
   */
  private void discardJewelry(Jewelry jewelry) {
    // check if the item is present in the set before discarding.

    if (this.jewelries.contains(jewelry)) {
      changeStat(-jewelry.getOffensiveStat(), -jewelry.getDefensiveStat());
      this.jewelries.remove(jewelry);
      return;
    }
    throw new IllegalArgumentException("Removing a non-existent item from the character");
  }

  /**
   * A helper method to prevent code duplication while changing an
   * offensive/defensive stat.
   *
   * @param offensiveStat The offensive stat.
   * @param defensiveStat The defensive stat.
   */
  private void changeStat(int offensiveStat, int defensiveStat) {
    this.totalAttackStat += offensiveStat;
    this.totalDefenseStat += defensiveStat;
  }

  /**
   * A private helper method which notes which item was picked and discarded.
   *
   * @param discarded The item that was discarded.
   * @param picked    The item that was picked.
   * @return A string which has the item discarded and picked.
   */
  private String noteDiscardedAndPickedItems(String discarded, String picked) {
    return String.format("Item discarded : %s, Item picked : %s", discarded, picked);
  }

  @Override
  public String toString() {
    return String.format(
        "Name : %s, Basic attack : %d; Basic defense : %d; Total attack : %d; Total defense : %d;"
            + " HeadGear : %s; FootWear : %s; HandGear : %s; Jewelry: %s.",
        this.name, this.basicAttackStat, this.basicDefenceStat, this.totalAttackStat,
        this.totalDefenseStat, headGear == null ? "None" : headGear.getName(),
        combineItems(this.footWears), combineItems(this.handGears), combineItems(this.jewelries));
  }

  /**
   * A builder class for the character class which helps build the character
   * class.
   */
  public static class CharacterBuilder {
    private String name;
    private int basicAttackStat;
    private int basicDefenceStat;
    private int hitPoints;

    /**
     * A constructor for the builder class for CharacterImpl class.
     */
    public CharacterBuilder() {
      this.name = "";
      this.basicAttackStat = 0;
      this.basicDefenceStat = 0;
      this.hitPoints = 0;
    }

    /**
     * Set the name of the Character.
     * 
     * @param name The name of the character.
     * @return A CharacterBuilder object.
     */
    public CharacterBuilder setName(String name) {
      this.name = name;
      return this;
    }

    /**
     * Set the basic attack stat of the character.
     * 
     * @param basicAttackStat The basic attack of the character.
     * @return A CharacterBuilder object.
     */
    public CharacterBuilder setBasicAttackStat(int basicAttackStat) {
      this.basicAttackStat = basicAttackStat;
      return this;
    }

    /**
     * Set the basicDefensive stat of the character.
     * 
     * @param basicDefenceStat The basic defensive stat for the character.
     * @return A CharacterBuilder object.
     */
    public CharacterBuilder setBasicDefenseStat(int basicDefenceStat) {
      this.basicDefenceStat = basicDefenceStat;
      return this;
    }

    /**
     * Set the hit points for a character.
     * 
     * @param hitPoints The hitpoints for the character.
     * @return A CharacterBuilder object.
     */
    public CharacterBuilder setHitPoints(int hitPoints) {
      this.hitPoints = hitPoints;
      return this;
    }

    /**
     * Builder for Characterimpl.
     * 
     * @return A CharacterImpl object.
     */
    public CharacterImpl build() {
      if (basicDefenceStat < 0 || basicAttackStat < 0 || hitPoints < 0) {
        throw new IllegalArgumentException("Invalid values set");
      }
      if (name.equals("")) {
        throw new IllegalArgumentException("Empty character names not allowed");
      }
      return new CharacterImpl(this.name, this.basicAttackStat, this.basicDefenceStat,
          this.hitPoints);
    }
  }
}
