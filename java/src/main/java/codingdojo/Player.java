package codingdojo;

class Player extends Target {

  private final Equipment equipment;

  Player(Equipment equipment) {
    this.equipment = equipment;
  }

  Damage calculateDamage(Target target) {
    int totalDamage = getTotalDamage(equipment);
    int soak = getSoak(target, totalDamage);
    return new Damage(Math.max(0, totalDamage - soak));
  }

  private int getSoak(Target target, int totalDamage) {
    int soak = 0;
    if (target instanceof Player) {
      soak = getSoakPlayerInstance(totalDamage);
    } else if (target instanceof SimpleEnemy) {
      soak = ((SimpleEnemy) target).getSoak();
    }
    return soak;
  }

  private int getSoakPlayerInstance(int totalDamage) {
    // TODO: Not implemented yet
    //  Add friendly fire
    return totalDamage;
  }

  private int getTotalDamage(Equipment equipment) {
    int baseDamage = getBaseDamage(equipment);
    float damageModifier = getDamageModifier(equipment);
    return Math.round(baseDamage * damageModifier);
  }

  private float getDamageModifier(Equipment equipment) {
    return equipment.getDamageModifier();
  }

  private int getBaseDamage(Equipment equipment) {
    return equipment.getBaseDamage();
  }
}
