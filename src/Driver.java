
import equippingcharacters.characters.Character;
import equippingcharacters.characters.CharacterImpl;
import equippingcharacters.items.Items;
import equippingcharacters.treasurechest.TreasureChest;
import equippingcharacters.treasurechest.TresureChestItems;

import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

/**
 * The driver class for equipping characters.
 */
public class Driver {

  /**
   * A method to predict the winner amongst two characters.
   *
   * @param character1 The character involved in the prediction.
   * @param character2 The other character involved in the prediction
   */
  public void predictWinner(Character character1, Character character2) {
    int damageCharacter1 = character2.getTotalAttackStat() - character1.getTotalDefenseStat();
    int damageCharacter2 = character1.getTotalAttackStat() - character2.getTotalDefenseStat();

    // deal with divide by zero issues.
    damageCharacter1 = damageCharacter1 == 0 || damageCharacter1 < 0 ? 1 : damageCharacter1;
    damageCharacter2 = damageCharacter2 == 0 || damageCharacter2 < 0 ? 1 : damageCharacter2;

    int roundsWonByCharacter1 = (int) Math.ceil(character1.getHitPoints() / damageCharacter2);
    int roundsWonByCharacter2 = (int) Math.ceil(character2.getHitPoints() / damageCharacter1);

    System.out.println("******************************");
    if (roundsWonByCharacter1 > roundsWonByCharacter2) {
      System.out.println("The match was won by " + character1.getName());
    } else if (roundsWonByCharacter2 > roundsWonByCharacter1) {
      System.out.println("The match was won by " + character2.getName());
    } else {
      System.out.println("This match was a draw.");
    }
    System.out.println("******************************");
  }

  /**
   * A method to dress a character randomly with 20 items from the treasure chest.
   *
   * @param treasureChest The treasure chest which contains all of the required
   *                      items.
   */
  public static void dressCharacter(Character character, TreasureChest treasureChest) {
    System.out.println(String.format("%s is picking items from the chest", character.getName()));
    int counter = 20;
    int size = treasureChest.getItemsList().size();
    // prevent going through the same item again and again.
    Set<Items> duplicates = new HashSet<>();
    Random random = new Random();
    while (counter > 0) {
      Items randomItem = treasureChest.getItemsList().get(random.nextInt(size));
      if (!duplicates.contains(randomItem)) {
        String result = character.addItem(randomItem);
        if (!result.equals("")) {
          System.out.println(result);
        }
        counter--;
      }
    }
    System.out
        .println(String.format("Character after equipping all items : %s", character.toString()));
  }

  /**
   * The main class for the project. The driver runs the predict and
   * dressCharacter method from here.
   * 
   * @param args The arguments for the main class.
   */
  public static void main(String[] args) {
    TreasureChest treasureChest = new TreasureChest(TresureChestItems.getItems());
    Driver driver = new Driver();
    Scanner scanner = new Scanner(System.in);
    char test = 'Y';
    while (test == 'Y') {
      Character bob = CharacterImpl.builder().setName("Bob").setBasicDefenseStat(15)
          .setBasicAttackStat(12).setHitPoints(500).build();
      Character alice = CharacterImpl.builder().setName("Alice").setBasicDefenseStat(25)
          .setBasicAttackStat(4).setHitPoints(500).build();
      Driver.dressCharacter(bob, treasureChest);
      Driver.dressCharacter(alice, treasureChest);
      driver.predictWinner(bob, alice);
      System.out.println("Press Y for a rematch.");
      test = scanner.next().charAt(0);
    }
  }
}