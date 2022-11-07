package codingdojo;


class Player extends Target {
    private final Inventory inventory;
    private final Stats stats;

    Player(Inventory inventory, Stats stats) {
        this.inventory = inventory;
        this.stats = stats;
    }

    Damage calculateDamage(Target target) {
        int totalDamage = getTotalDamage();
        int soak = getSoak(target, totalDamage);
        return new Damage(Math.max(0, totalDamage - soak));
    }

    private int getSoak(Target target, int totalDamage) {
        int soak = 0;
        if (target instanceof Player) {
            // TODO: Not implemented yet
            //  Add friendly fire
            soak = totalDamage;
        } else if (target instanceof SimpleEnemy) {
            SimpleEnemy simpleEnemy = (SimpleEnemy) target;
            soak = Math.round(
                simpleEnemy.getArmor().getDamageSoak() *
                (
                    ((float) simpleEnemy.getBuffs()
                        .stream()
                        .mapToDouble(Buff::soakModifier)
                        .sum()) +
                    1f
                )
            );
        }
        return soak;
    }

    private int getTotalDamage() {
        int baseDamage = getBaseDamage();
        float damageModifier = getDamageModifier();
        return Math.round(baseDamage * damageModifier);
    }

    private float getDamageModifier() {
        Equipment equipment = this.inventory.getEquipment();
        float strengthModifier = stats.getStrength() * 0.1f;
        return strengthModifier + equipment.getDamageModifier();

    }

    private int getBaseDamage() {
        Equipment equipment = this.inventory.getEquipment();
        return equipment.getBaseDamage();
    }
}
