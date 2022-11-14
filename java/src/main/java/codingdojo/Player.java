package codingdojo;

class Player extends Target {

  private final Equipment equipment;

  Player(Equipment equipment) {
    this.equipment = equipment;
  }

  Damage calculateDamage(Target target) {
    int soak = getSoak(target, getTotalDamage());
    return new Damage(Math.max(0, getTotalDamage() - soak));
  }

  private int getSoak(Target target, int totalDamage) {
    int soak = 0;
    if (target instanceof Player) {
      return getSoakPlayerInstance(totalDamage);
    } else if (target instanceof SimpleEnemy) {
      return ((SimpleEnemy) target).getSoak();
    }
    return soak;
  }

  private int getSoakPlayerInstance(int totalDamage) {
    // TODO: Not implemented yet
    //  Add friendly fire
    return totalDamage;
  }

  private int getTotalDamage() {
    return Math.round(equipment.getBaseDamage() * equipment.getDamageModifier());
  }
}
