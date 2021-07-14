package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import equippingcharacters.items.FootWear;
import equippingcharacters.items.HandGear;
import equippingcharacters.items.HeadGear;
import equippingcharacters.items.Items;
import equippingcharacters.items.Jewelry;
import org.junit.Before;
import org.junit.Test;

/**
 * A class representing all the tests for the Items and the classes which
 * implement it.
 */
public class ItemsTest {
  private Items headGear;
  private Items handGear;
  private Items footWear;
  private Items jewelry;

  /**
   * Setup the test classes with appropriate.
   */
  @Before
  public void setup() {
    headGear = new HeadGear("Common helmets", false, 12, 120);
    handGear = new HandGear("Common gloves", true, 0, 112, 0);
    footWear = new FootWear("Common boots", false, 13, 13);
    jewelry = new Jewelry("Ring of Fortune", false, 5, 0, 100);
  }

  /**
   * Test that the constructors are working properly.
   */
  @Test
  public void testItems() {
    assertEquals("Common helmets", headGear.getName());
    assertEquals("Common gloves", handGear.getName());
    assertEquals("Common boots", footWear.getName());
    assertEquals("Ring of Fortune", jewelry.getName());

  }

  /**
   * Test that the constructors throws the exception when the attack stat is
   * negative and item is not cursed.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testItemsInvalidAttackStat() {
    HandGear test = new HandGear("Common gloves", false, 15, -4, 0);
  }

  /**
   * Test that the constructors are working properly when the defence stat is
   * negative and item is not cursed.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testItemsInvalidDefenceStat() {
    HeadGear test = new HeadGear("Common helmets", false, 12, -120);
  }

  /**
   * Test that the constructors throws an exception when both stats are set. An
   * item can only have one stat.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testItemsBothStatsSet() {
    Jewelry test = new Jewelry("Ring of power", false, 20, 3, 4);
  }

  /**
   * Test the items when they're cursed.
   */
  @Test
  public void testItemsWhenCursed() {
    int expected = -112;
    HandGear handGearToTest = (HandGear)handGear;
    assertEquals(expected, handGearToTest.getOffensiveStat());
  }

  /**
   * Test if it fetches the correct name or not.
   */
  @Test
  public void getName() {
    String expected = "Common helmets";
    assertEquals(expected, headGear.getName());
  }

  /**
   * Testing the getter for offensive stat.
   */
  @Test
  public void getOffensiveStat() {
    int expected = 13;
    FootWear footWearToTest = (FootWear)footWear;
    assertEquals(expected, footWearToTest.getOffensiveStat());
  }

  /**
   * Testing getter for defensive stat.
   */
  @Test
  public void getDefensiveStat() {
    int expected = 120;
    HeadGear headGearToTest = (HeadGear)headGear;
    assertEquals(expected, headGearToTest.getDefensiveStat());
  }

  /**
   * Testing the getter for Item health.
   */
  @Test
  public void getItemHealth() {
    int expected = 12;
    assertEquals(expected, headGear.getItemHealth());
  }

  /**
   * Test if item is cursed.
   */
  @Test
  public void isCursed() {
    assertTrue(handGear.isCursed());
  }

  /**
   * Check if the item becomes cursed or not after over-usage.
   */
  @Test
  public void checkItemBecomesAfterHealthZero() {
    // TODO : Write a method which will be overridden by the subclasses
    HeadGear test = new HeadGear("Helmets of Health", false, 1, 15);
    test.useItem();
    int expected = -15;
    assertTrue(test.isCursed());
  }

  /**
   * Test is equals works for the same object with equal values.
   */
  @Test
  public void checkItemEqualsJewelerySameObject() {
    Items item = new Jewelry("test1", false, 12, 5, 0);
    Items item2 = new Jewelry("test1", false, 12, 5, 0);
    assertTrue(item.equals(item2));
  }

  /**
   * Test is equals works for the different object.
   */
  @Test
  public void checkItemNotEqualsJewelerySameObject() {
    Items item = new Jewelry("test1", false, 12, 5, 0);
    Items item2 = new HeadGear("test1", false, 12, 5);
    assertFalse(item.equals(item2));
  }

  /**
   * Test is equals works for the same object with equal values.
   */
  @Test
  public void checkItemEqualsHeadGearSameObject() {
    Items item = new HeadGear("test1", false, 12, 5);
    Items item2 = new HeadGear("test1", false, 12, 5);
    assertTrue(item.equals(item2));
  }

  /**
   * Test is equals works for the different object.
   */
  @Test
  public void checkItemNotEqualsHeadGearSameObject() {
    Items item2 = new Jewelry("test1", false, 12, 5, 0);
    Items item = new HeadGear("test1", false, 12, 5);
    assertFalse(item.equals(item2));
  }

  /**
   * Test is equals works for the same object with equal values.
   */
  @Test
  public void checkItemEqualsHandGearSameObject() {
    Items item = new HandGear("test1", false, 12, 5, 0);
    Items item2 = new HandGear("test1", false, 12, 5, 0);
    assertTrue(item.equals(item2));
  }

  /**
   * Test is equals works for the different object.
   */
  @Test
  public void checkItemNotEqualsHandGearSameObject() {
    Items item2 = new Jewelry("test1", false, 12, 5, 0);
    Items item = new HandGear("test1", false, 12, 4, 0);
    assertFalse(item.equals(item2));
  }

  /**
   * Test is equals works for the same object with equal values.
   */
  @Test
  public void checkItemEqualsFootWearSameObject() {
    Items item = new FootWear("test1", false, 12, 5);
    Items item2 = new FootWear("test1", false, 12, 5);
    assertTrue(item.equals(item2));
  }

  /**
   * Test is equals works for the different object.
   */
  @Test
  public void checkItemNotEqualsFootWearSameObject() {
    Items item2 = new Jewelry("test1", false, 12, 5, 0);
    Items item = new FootWear("test1", false, 12, 5);
    assertFalse(item.equals(item2));
  }

  /**
   * A test to compare jewelry which have the same defensive stat.
   */
  @Test
  public void compareJewelrySameDefense() {
    int expected = 0;
    Items item = new Jewelry("test1", false, 12, 0, 12);
    Items item2 = new Jewelry("test2", false, 12, 0, 12);
    assertEquals(expected, item.compareTo(item2));
  }

  /**
   * A test to compare jewelry which have the same defensive stat.
   */
  @Test
  public void compareFootWearSameStats() {
    int expected = 0;
    Items item = new FootWear("test1", false, 12, 1);
    Items item2 = new FootWear("test2", false, 12, 1);
    assertEquals(expected, item.compareTo(item2));
  }

  /**
   * A test for the toString for handgear.
   */
  @Test
  public void testToStringHandGear() {
    String expected = "HandGear Item; Name : Common gloves; Health 0;"
        + " Cursed : true; Attack : -112;Defense 0";
    assertEquals(expected, handGear.toString());
  }

  /**
   * A test for the toString for jewelry.
   */
  @Test
  public void testToStringJewelry() {
    String expected = "Jewelry Item; Name : Ring of Fortune; Health 5;"
        + " Cursed : false; Attack : 0;Defense 100";
    assertEquals(expected, jewelry.toString());
  }

  /**
   * A test for the toString for headGear.
   */
  @Test
  public void testToStringHeadGear() {
    String expected = "HeadGear Item; Name : Common helmets;"
        + " Health 12; Cursed : false; Defense 120";
    assertEquals(expected, headGear.toString());
  }

  /**
   * A test for the toString for Jewelry.
   */
  @Test
  public void testToStringFootWear() {
    String expected = "FootWear Item; Name : Common boots; Health 13;"
        + " Cursed : false; Attack 13";
    assertEquals(expected, footWear.toString());
  }
}