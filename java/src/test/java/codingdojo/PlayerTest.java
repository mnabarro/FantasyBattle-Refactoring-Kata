package codingdojo;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PlayerTest {

    // choose this one if you are familiar with mocks
    @Disabled("Test is not finished yet")
    @Test
    void damageCalculationsWithMocks() {
        Inventory inventory = mock(Inventory.class);
        Stats stats = mock(Stats.class);
        SimpleEnemy target = mock(SimpleEnemy.class);
        SimpleArmor armor = mock(SimpleArmor.class);
        Item item = new BasicItem("",0,0);
        Item swordOnRightHand = new BasicItem("flashy sword of danger",10,1f);
        Equipment equipment = new Equipment(item, swordOnRightHand, item, item, item);

        when(inventory.getEquipment()).thenReturn(equipment);
        when(stats.getStrength()).thenReturn(0);
        when(target.getArmor()).thenReturn(armor);
        when(armor.getDamageSoak()).thenReturn(5);

        Damage damage = new Player(inventory, stats).calculateDamage(target);

        assertEquals(5, damage.getAmount());
    }

    // choose this one if you are not familiar with mocks
    @Disabled("Test is not finished yet")
    @Test
    void damageCalculations() {
        Inventory inventory = new Inventory(null);
        Stats stats = new Stats(0);
        SimpleEnemy target = new SimpleEnemy(null, null);
        Damage damage = new Player(inventory, stats).calculateDamage(target);
        assertEquals(10, damage.getAmount());
    }
}
