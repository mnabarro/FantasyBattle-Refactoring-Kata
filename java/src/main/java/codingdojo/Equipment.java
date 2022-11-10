package codingdojo;


class Equipment {
    // TODO add a ring item that may be equipped
    //  that may also add damage modifier
    private final Item leftHand;
    private final Item rightHand;
    private final Item head;
    private final Item feet;
    private final Item chest;

    private final Stats stats;


    Equipment(Item leftHand, Item rightHand, Item head, Item feet, Item chest, Stats stats) {
        this.leftHand = leftHand;
        this.rightHand = rightHand;
        this.head = head;
        this.feet = feet;
        this.chest = chest;
        this.stats = stats;
    }

    int getBaseDamage() {

        return leftHand.getBaseDamage() +
          rightHand.getBaseDamage() +
          head.getBaseDamage() +
          feet.getBaseDamage() +
          chest.getBaseDamage();
    }
    float getDamageModifier() {

        return leftHand.getDamageModifier() +
          rightHand.getDamageModifier() +
          head.getDamageModifier() +
          feet.getDamageModifier() +
          chest.getDamageModifier() +
          stats.getStrengthModifier();
    }
}
