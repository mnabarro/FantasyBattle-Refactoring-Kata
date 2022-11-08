package codingdojo;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayerTest {

    // choose this one if you are familiar with mocks
    @Test
    void damageCalculationsWithMocks() {
        Stats stats = new Stats(10);
        SimpleArmor armor = new SimpleArmor(5);
        Item item = new BasicItem("",0,0);
        Item swordOnRightHand = new BasicItem("flashy sword of danger",10,1f);
        Equipment equipment = new Equipment(item, swordOnRightHand, item, item, item);
        BasicBuff buff = new BasicBuff(1,1);
        List<Buff> buffs = Arrays.asList(buff);

        SimpleEnemy target = new SimpleEnemy(armor,buffs);

        Damage damage = new Player(equipment, stats).calculateDamage(target);

        assertEquals(10, damage.getAmount());
    }
}
