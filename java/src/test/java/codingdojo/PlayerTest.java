package codingdojo;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayerTest {

  Stats stats;
  SimpleArmor armor;
  Item notUsedItem;
  BasicBuff buff;
  List<Buff> buffs;
  SimpleEnemy target;

  @BeforeEach
  void setup() {
    stats = new Stats(10);
    armor = new SimpleArmor(5);
    notUsedItem = new BasicItem("", 0, 0);
    buff = new BasicBuff(1, 1);
    buffs = List.of(buff);
    target = new SimpleEnemy(armor, buffs);
  }

  @Test
  void calculateDamageProducedByWithFlashySwordOfDanger() {
    Item swordOnRightHand = new BasicItem("flashy sword of danger", 10, 1f);
    Equipment equipment = new Equipment(notUsedItem, swordOnRightHand, notUsedItem, notUsedItem, notUsedItem);

    Damage damage = new Player(equipment, stats).calculateDamage(target);

    assertEquals(10, damage.getAmount());
  }
}
