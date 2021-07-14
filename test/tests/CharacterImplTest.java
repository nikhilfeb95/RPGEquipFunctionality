package tests;

import static org.junit.Assert.assertEquals;

import equippingcharacters.characters.Character;
import equippingcharacters.characters.CharacterImpl;
import equippingcharacters.items.FootWear;
import equippingcharacters.items.HandGear;
import equippingcharacters.items.HeadGear;
import equippingcharacters.items.Items;
import equippingcharacters.items.Jewelry;
import org.junit.Test;

/**
 * A class to test the Characters in the game and the equipping functionality.
 */
public class CharacterImplTest {

  Character character;

  /**
   * Setup the test class before testing it.
   */
  @org.junit.Before
  public void setUp() {
    character = CharacterImpl.builder().setName("Rogue").setBasicAttackStat(12)
        .setBasicDefenseStat(3).setHitPoints(50).build();
  }

  /**
   * Check if the constructor is functioning properly.
   */
  @Test
  public void testCharacterImpl() {
    int expected = 12;
    assertEquals(expected, character.getBasicAttackStat());
  }

  /**
   * Test the constructor when the basic attack stat is negative.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testCharacterImplWhenInvalidBasicAttack() {
    Character character1 = new CharacterImpl("Test", -12, 2, -12);
  }

  /**
   * Test the constructor when the basic defence stat is negative.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testCharacterImplWhenInvalidBasicDefense() {
    Character character1 = new CharacterImpl("Test", 12, -2, 12);
  }

  /**
   * Test the constructor when the basic defence stat is negative.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testCharacterImplWhenInvalidHitPoints() {
    Character character1 = new CharacterImpl("Test", 12, 2, -12);
  }

  /**
   * Test to add a headgear, when headgear slot is empty.
   */
  @Test
  public void testAddHeadGear() {
    character.addItem(new HeadGear("Helmet of Strength", false, 12, 200));
    String expected = "Name : Rogue, Basic attack : 12; Basic defense : 3;"
        + " Total attack : 12; Total defense : 203;"
        + " HeadGear : Helmet of Strength; FootWear : None; HandGear : " + "None; Jewelry: None.";
    assertEquals(expected, character.toString());
  }


  /**
   * A test to check if the current headGear is replaced by the better head gear.
   */
  @Test
  public void testAddBetterHeadGear() {
    character.addItem(new HeadGear("Helmet of Strength", false, 12, 200));
    HeadGear betterGear = new HeadGear("Visors of Creation", false, 15, 250);
    character.addItem(betterGear);
    String expected = "Name : Rogue, Basic attack : 12; Basic defense : 3;"
        + " Total attack : 12; Total defense : 253;"
        + " HeadGear : Visors of Creation; FootWear : None; HandGear : " + "None; Jewelry: None.";
    assertEquals(expected, character.toString());
  }

  /**
   * test to check adding a footwear works.
   */
  @Test
  public void testAddFootWear() {
    character.addItem(new FootWear("Boots of Speed", false, 12, 200));
    String expected = "Name : Rogue, Basic attack : 12; Basic defense : 3;"
        + " Total attack : 212; Total defense : 3;"
        + " HeadGear : None; FootWear : Boots of Speed; HandGear : " + "None; Jewelry: None.";
    assertEquals(expected, character.toString());
  }

  /**
   * test to check adding a duplicate footwear throws the appropriate exception.
   */
  @Test
  public void testAddDuplicateFootWear() {
    character.addItem(new FootWear("Boots of Speed", false, 12, 200));
    character.addItem(new FootWear("Boots of Speed", false, 12, 200));

    String expected = "Name : Rogue, Basic attack : 12; Basic defense : 3;"
        + " Total attack : 412; Total defense : 3;"
        + " HeadGear : None; FootWear : Boots of Speed and Speed; HandGear : "
        + "None; Jewelry: None.";
    assertEquals(expected, character.toString());
  }

  /**
   * Test to check if footwear is replaced by a better one when all slots are
   * full.
   */
  @Test
  public void testAddBetterFootWearWhenAllSlotsFull() {
    character.addItem(new FootWear("Boots of Speed", false, 12, 200));
    character.addItem(new FootWear("Sandals of vitality", false, 12, 250));

    // adding better item here
    character.addItem(new FootWear("Boots of Requiem", false, 12, 212));

    String expected = "Name : Rogue, Basic attack : 12; Basic defense : 3;"
        + " Total attack : 474; Total defense : 3;"
        + " HeadGear : None; FootWear : Sandals of vitality and Requiem; HandGear : "
        + "None; Jewelry: None.";

    assertEquals(expected, character.toString());
  }

  /**
   * test to check adding a HandGear works.
   */
  @Test
  public void testAddHandGear() {
    character.addItem(new HandGear("Gloves of Power", false, 12, 200, 0));
    String expected = "Name : Rogue, Basic attack : 12; Basic defense : 3;"
        + " Total attack : 212; Total defense : 3;"
        + " HeadGear : None; FootWear : None; HandGear : " + "Gloves of Power; Jewelry: None.";
    assertEquals(expected, character.toString());
  }

  /**
   * test to check adding a duplicate HandGear throws the appropriate exception.
   */
  @Test
  public void testAddDuplicateHandGear() {
    character.addItem(new HandGear("Gloves of Power", false, 12, 200, 0));
    character.addItem(new HandGear("Gloves of Power", false, 12, 200, 0));
    String expected = "Name : Rogue, Basic attack : 12; Basic defense : 3;"
        + " Total attack : 412; Total defense : 3;"
        + " HeadGear : None; FootWear : None; HandGear : "
        + "Gloves of Power and Power; Jewelry: None.";
    assertEquals(expected, character.toString());
  }

  /**
   * Test to check if HandGear is replaced by a better one when all slots are
   * full.
   */
  @Test
  public void testAddBetterHandGearWhenAllSlotsFull() {
    character.addItem(new HandGear("Common Gloves 1", false, 12, 10, 0));
    character.addItem(new HandGear("Common Gloves 2", false, 12, 11, 0));
    character.addItem(new HandGear("Common Gloves 3", false, 12, 12, 0));
    character.addItem(new HandGear("Common Gloves 4", false, 12, 13, 0));
    character.addItem(new HandGear("Common Gloves 5", false, 12, 14, 0));
    character.addItem(new HandGear("Common Gloves 6", false, 12, 15, 0));
    character.addItem(new HandGear("Common Gloves 7", false, 12, 16, 0));
    character.addItem(new HandGear("Common Gloves 8", false, 12, 17, 0));
    character.addItem(new HandGear("Common Gloves 9", false, 12, 18, 0));
    character.addItem(new HandGear("Common Gloves 10", false, 12, 19, 0));

    character.addItem(new HandGear("Common Gloves 11", false, 12, 15, 0));

    String expected = "Name : Rogue, Basic attack : 12; Basic defense : 3; Total attack : 162; "
        + "Total defense : 3; HeadGear : None; FootWear : None; HandGear : "
        + "Common Gloves 2, 3, 4, 5, 6, 7, 8, 9, 10 and 11; Jewelry: None.";
    assertEquals(expected, character.toString());
  }

  /**
   * test to check adding a jewelry works.
   */
  @Test
  public void testAddJewelry() {
    character.addItem(new Jewelry("Rings of Saturn", false, 12, 200, 0));
    String expected = "Name : Rogue, Basic attack : 12; Basic defense : 3;"
        + " Total attack : 212; Total defense : 3;"
        + " HeadGear : None; FootWear : None; HandGear : " + "None; Jewelry: Rings of Saturn.";
    assertEquals(expected, character.toString());
  }

  /**
   * Testing adding a null item to the character.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testAddNullItem() {
    character.addItem(null);
  }

  /**
   * Testing adding a null item to the character.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testDiscardNullItem() {
    character.discardItem(null);
  }

  /**
   * A test to check if two string and the combining functions are working
   * properly.
   */
  @Test
  public void testToString() {
    HeadGear headGear = new HeadGear("Helmet of Strength", false, 12, 200);
    character.addItem(headGear);
    FootWear footWear = new FootWear("Sandals of speed", false, 13, 100);
    character.addItem(footWear);
    FootWear footWear1 = new FootWear("Boots of health", false, 11, 90);
    character.addItem(footWear1);
    HandGear handGear = new HandGear("Gloves of Flames", true, 0, -21, 0);
    character.addItem(handGear);
    HandGear handGear1 = new HandGear("Gauntlets of death", false, 0, 12, 0);
    character.addItem(handGear1);
    HandGear handGear2 = new HandGear("Gauntlets of hope", false, 0, 100, 0);
    character.addItem(handGear2);
    String expected = "Name : Rogue, Basic attack : 12; Basic defense : 3;"
        + " Total attack : 293; Total defense : 203;"
        + " HeadGear : Helmet of Strength; FootWear : Sandals of speed and health; HandGear : "
        + "Gloves of Flames, death and hope; Jewelry: None.";
    assertEquals(expected, character.toString());
  }

  /**
   * A test to test if a HeadGear is successfully removed from a character.
   */
  @Test
  public void testDiscardHeadGear() {
    Items headGear = new HeadGear("test gear", false, 15, 5);
    character.addItem(headGear);
    character.discardItem(headGear);
    String expected = "Name : Rogue, Basic attack : 12; Basic defense : 3;"
        + " Total attack : 12; Total defense : 3;"
        + " HeadGear : None; FootWear : None; HandGear : " + "None; Jewelry: None.";
    assertEquals(expected, character.toString());
  }

  /**
   * A test to test if a HandGear is successfully removed from a character.
   */
  @Test
  public void testDiscardHandGear() {
    Items handGear = new HandGear("test gear", false, 15, 5, 0);
    character.addItem(handGear);
    character.discardItem(handGear);
    String expected = "Name : Rogue, Basic attack : 12; Basic defense : 3;"
        + " Total attack : 12; Total defense : 3;"
        + " HeadGear : None; FootWear : None; HandGear : " + "None; Jewelry: None.";
    assertEquals(expected, character.toString());
  }

  /**
   * A test to test if a jewelry is successfully removed from a character.
   */
  @Test
  public void testDiscardJewelry() {
    Items jewelry = new Jewelry("test gear", false, 15, 5, 0);
    character.addItem(jewelry);
    character.discardItem(jewelry);
    String expected = "Name : Rogue, Basic attack : 12; Basic defense : 3;"
        + " Total attack : 12; Total defense : 3;"
        + " HeadGear : None; FootWear : None; HandGear : " + "None; Jewelry: None.";
    assertEquals(expected, character.toString());
  }

  /**
   * A test to test if a jewelry is successfully removed from a character.
   */
  @Test
  public void testDiscardFootWear() {
    Items footWear = new FootWear("test gear", false, 15, 5);
    character.addItem(footWear);
    character.discardItem(footWear);
    String expected = "Name : Rogue, Basic attack : 12; Basic defense : 3;"
        + " Total attack : 12; Total defense : 3;"
        + " HeadGear : None; FootWear : None; HandGear : " + "None; Jewelry: None.";
    assertEquals(expected, character.toString());
  }

  /**
   * Test the getter for basicAttackStat.
   */
  @Test
  public void testgetBasicAttackStat() {
    int expected = 12;
    assertEquals(expected, character.getBasicAttackStat());
  }

  /**
   * Test the getter for basicDefenseStat.
   */
  @Test
  public void testgetBasicDefenseStat() {
    int expected = 3;
    assertEquals(expected, character.getBasicDefenseStat());
  }

  /**
   * Test the getter for totalAttackStat.
   */
  @Test
  public void testgetTotalAttackStat() {
    int expected = 12;
    assertEquals(expected, character.getTotalAttackStat());
  }

  /**
   * Test the getter for totalDefenseStat.
   */
  @Test
  public void testgetTotalDefenseStat() {
    int expected = 3;
    assertEquals(expected, character.getTotalDefenseStat());
  }

  /**
   * Test the getter for getName.
   */
  @Test
  public void testGetName() {
    String expected = "Rogue";
    assertEquals(expected, character.getName());
  }

  /**
   * Test the getter for getName.
   */
  @Test
  public void testGetHitPoints() {
    int expected = 50;
    assertEquals(expected, character.getHitPoints());
  }

  /**
   * Test discarding a item which the character doesn't have.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testDiscardNonExistentHeadGear() {
    character.addItem(new HeadGear("22", false, 15, 7));
    Items itemToDiscard = new HeadGear("test Gear", false, 12, 5);
    character.discardItem(itemToDiscard);
  }

  /**
   * Test discarding a item which the character doesn't have.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testDiscardNonExistentHandGear() {
    Items itemToDiscard = new HandGear("test Gear", false, 12, 5, 0);
    character.discardItem(itemToDiscard);
  }

  /**
   * Test discarding a item which the character doesn't have.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testDiscardNonExistentFootWear() {
    Items itemToDiscard = new FootWear("test Gear", false, 12, 5);
    character.discardItem(itemToDiscard);
  }

  /**
   * Test discarding a item which the character doesn't have.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testDiscardNonExistentJewelry() {
    Items itemToDiscard = new Jewelry("test Gear", false, 12, 5, 0);
    character.discardItem(itemToDiscard);
  }

  /**
   * Test trying to discard a null headgear.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testDiscardNullHeadGear() {
    character.discardItem(null);
  }

  /**
   * Test to build a character object with invalid values for the builder.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testBuilderWithInvalidValues() {
    Character test = CharacterImpl.builder().build();
  }
}