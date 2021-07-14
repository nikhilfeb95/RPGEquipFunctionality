package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import equippingcharacters.items.HeadGear;
import equippingcharacters.items.Items;
import equippingcharacters.treasurechest.TreasureChest;
import equippingcharacters.treasurechest.TresureChestItems;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * A test for the TreasureChest class. Here we verify if all the checks are done
 * or not.
 */
public class TreasureChestTest {
  TreasureChest treasureChest;

  /**
   * Setup the class before testing.
   */
  @Before
  public void setUp() {
    treasureChest = new TreasureChest(TresureChestItems.getItems());
  }

  /**
   * Test the constructor for treasure chest. Check if the object for it is null
   * or not.
   */
  @Test
  public void testTreasureChest() {
    assertNotNull(treasureChest);
  }

  /**
   * Testing the constructor by passing an list with less than the specified
   * number of items in the treasure chest.
   */
  @Test(expected = IllegalArgumentException.class)
  public void test() {
    List<Items> items = new ArrayList<Items>();
    items.add(new HeadGear("testGear", false, 12, 56));
    TreasureChest testChest = new TreasureChest(items);
  }

  /**
   * Test adding a item to a treasure chest.
   */
  @Test
  public void testAddItem() {
    Items headGear = new HeadGear("test", false, 12, 5);
    treasureChest.addItem(headGear);
    int expected = 45;
    assertEquals(expected, treasureChest.getItemsList().size());
  }

  /**
   * Test adding a null to a treasure chest.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testAddNull() {
    treasureChest.addItem(null);
  }
}
