package codingdojo;
import java.util.List;

public class SimpleEnemy extends Target {

    private final Armor armor;
    private final List<Buff> buffs;

    public SimpleEnemy(Armor armor, List<Buff> buffs) {
        this.armor = armor;
        this.buffs = buffs;
    }

    int getSoak() {
        return Math.round(getArmorDamageSoak() * ((getSoakModifier()) + 1f));
    }
    private int getArmorDamageSoak() {
        return this.armor.getDamageSoak();
    }

    private float getSoakModifier() {
        return (float) this.buffs.stream().mapToDouble(Buff::soakModifier).sum();
    }
}
