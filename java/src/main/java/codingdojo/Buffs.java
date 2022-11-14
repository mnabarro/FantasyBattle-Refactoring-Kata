package codingdojo;

import java.util.Arrays;
import java.util.List;

public class Buffs {
  private final List<Buff> buffs;

  public Buffs() {
    buffs = Arrays.asList();
  }
  public void addBuff(Buff buff) {
    buffs.add(buff);
  }

  public float getSoakModifier() {
    return (float) buffs.stream().mapToDouble(Buff::soakModifier).sum();
  }
}
