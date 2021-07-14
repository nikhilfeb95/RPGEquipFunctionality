package equippingcharacters.items;

/**
 * An abstract class representing items which have both an offensive and a
 * defensive stat.
 */
public abstract class AbstractBothStats extends AbstractItem
    implements OffensiveItem, DefensiveItems {
  private final int offensiveStat;
  private final int defensiveStat;

  /**
   * The constructor for items which have both the offensive and the defensive
   * stat.
   *
   * @param name          The name of the item.
   * @param isCursed      The status of the item.
   * @param health        The health of the item.
   * @param offensiveStat The offensive stat of the item.
   * @param defensiveStat The defensive stat of the item.
   */
  protected AbstractBothStats(String name, boolean isCursed, int health, int offensiveStat,
      int defensiveStat) {
    super(name, isCursed, health);

    if (!isCursed && (offensiveStat < 0 || defensiveStat < 0)) {
      throw new IllegalArgumentException("Invalid stats for un-cursed item");
    }
    if (offensiveStat > 0 && defensiveStat > 0) {
      throw new IllegalArgumentException("Items can have either attack or defense stat.");
    }
    this.offensiveStat = isCursed && offensiveStat > 0 ? -offensiveStat : offensiveStat;
    this.defensiveStat = isCursed && defensiveStat > 0 ? -defensiveStat : defensiveStat;
  }

  @Override
  public int getOffensiveStat() {
    return this.isCursed() && offensiveStat > 0 ? -offensiveStat : offensiveStat;
  }

  @Override
  public int getDefensiveStat() {
    return this.isCursed() && defensiveStat > 0 ? -defensiveStat : defensiveStat;
  }

  @Override
  public int compareTo(Items o) {
    // A compareTo for both of these types as they share both functionality.
    if (o instanceof AbstractBothStats) {
      AbstractBothStats item = (AbstractBothStats) o;
      // Preference given to items whose offensive stats are greater.
      if (this.getOffensiveStat() > item.getOffensiveStat()) {
        return 1;
      } else if (this.getOffensiveStat() < item.getOffensiveStat()) {
        return -1;
      } else if (this.getDefensiveStat() > item.getDefensiveStat()) {
        return 1;
      } else if (this.getDefensiveStat() < item.getDefensiveStat()) {
        return -1;
      }
      return 0;
    }
    return 1;
  }
}
