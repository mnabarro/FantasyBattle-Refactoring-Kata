package codingdojo;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PlayerTest {

    // choose this one if you are familiar with mocks
    @Test
    void damageCalculationsWithMocks() {
        Stats stats = new Stats(0);
        SimpleArmor armor = new SimpleArmor(5);
        Item item = new BasicItem("",0,0);
        Item swordOnRightHand = new BasicItem("flashy sword of danger",10,1f);
        Equipment equipment = new Equipment(item, swordOnRightHand, item, item, item);
        Inventory inventory = new Inventory(equipment);
        SimpleEnemy target = mock(SimpleEnemy.class);

        when(target.getArmor()).thenReturn(armor);

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
