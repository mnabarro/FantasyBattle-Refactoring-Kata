package codingdojo;

public class SimpleEnemy extends Target {

  private final Armor armor;
  private final Buffs buffs;

  public SimpleEnemy(Armor armor, Buffs buffs) {
    this.armor = armor;
    this.buffs = buffs;
  }

  int getSoak() {
    return Math.round(armor.getDamageSoak() * ((buffs.getSoakModifier()) + 1f));
  }
}
