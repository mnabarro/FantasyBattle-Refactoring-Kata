package codingdojo;


class Player extends Target {

  private final Equipment equipment;
  private final Stats stats;

  Player(Inventory inventory, Stats stats) {
    this.equipment = inventory.getEquipment();
    this.stats = stats;
  }

  Damage calculateDamage(Target target) {
    int totalDamage = getTotalDamage(this.equipment);
    int soak = getSoak(target, totalDamage);
    return new Damage(Math.max(0, totalDamage - soak));
  }

  private int getSoak(Target target, int totalDamage) {
    int soak = 0;
    if (target instanceof Player) {
      soak = getSoakPlayerInstance(totalDamage);
    } else if (target instanceof SimpleEnemy) {
      soak = getSoakSimpleEnemy((SimpleEnemy) target);
    }
    return soak;
  }

  private int getSoakPlayerInstance(int totalDamage) {
    // TODO: Not implemented yet
    //  Add friendly fire
    return totalDamage;
  }

  private int getSoakSimpleEnemy(SimpleEnemy target) {
    int soak;
    soak = Math.round(
      target.getArmor().getDamageSoak() * (((float) target.getBuffs().stream().mapToDouble(Buff::soakModifier).sum()) + 1f));
    return soak;
  }

  private int getTotalDamage(Equipment equipment) {
    int baseDamage = getBaseDamage(equipment);
    float damageModifier = getDamageModifier(equipment);
    return Math.round(baseDamage * damageModifier);
  }

  private float getDamageModifier(Equipment equipment) {
    float strengthModifier = stats.getStrength() * 0.1f;
    return strengthModifier + equipment.getDamageModifier();

  }

  private int getBaseDamage(Equipment equipment) {
    return equipment.getBaseDamage();
  }
}
