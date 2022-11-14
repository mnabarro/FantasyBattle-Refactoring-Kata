package codingdojo;

import java.util.ArrayList;
import java.util.Optional;

public class Buffs {
  private final ArrayList<Buff> buffs;

  public Buffs(Optional<Buff> firstBuff) {
    buffs = new ArrayList<>();
    firstBuff.ifPresent(this::addBuff);
  }
  public void addBuff(Buff buff) {
    buffs.add(buff);
  }

  public float getSoakModifier() {
    return (float) buffs.stream().mapToDouble(Buff::soakModifier).sum();
  }
}
