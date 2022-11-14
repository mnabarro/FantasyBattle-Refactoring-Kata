package codingdojo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PlayerTest {

  Stats stats;
  SimpleArmor armor;
  Item notUsedItem;
  BasicBuff buff;
  Buffs buffs;
  SimpleEnemy target;

  @BeforeEach
  void setup() {
    armor = new SimpleArmor(5);
    notUsedItem = new BasicItem("not used item", 0, 0);
    buff = new BasicBuff(1, 1);
    buffs = new Buffs(Optional.of(buff));
    target = new SimpleEnemy(armor, buffs);
  }

  @Test
  void calculateDamageWithFlashySwordOfDanger() {
    stats = new Stats(5);
    Item swordOnRightHand = new BasicItem("flashy sword of danger", 10, 1f);
    Equipment equipment = new Equipment(notUsedItem, swordOnRightHand, notUsedItem, notUsedItem, notUsedItem, stats);

    Damage damage = new Player(equipment).calculateDamage(target);

    assertEquals(5, damage.getAmount());
  }

  @Test
  void calculateDamageWithExcalibur() {
    stats = new Stats(3);
    Item swordOnRightHand = new BasicItem("Excalibur", 20, 1.5f);
    Equipment equipment = new Equipment(notUsedItem, swordOnRightHand, notUsedItem, notUsedItem, notUsedItem, stats);

    Damage damage = new Player(equipment).calculateDamage(target);

    assertEquals(26, damage.getAmount());
  }
}
