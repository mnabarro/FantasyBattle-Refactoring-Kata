package codingdojo;


class Equipment {
    // TODO add a ring item that may be equipped
    //  that may also add damage modifier
    private final Item leftHand;
    private final Item rightHand;
    private final Item head;
    private final Item feet;
    private final Item chest;

    Equipment(Item leftHand, Item rightHand, Item head, Item feet, Item chest) {
        this.leftHand = leftHand;
        this.rightHand = rightHand;
        this.head = head;
        this.feet = feet;
        this.chest = chest;
    }

    int getBaseDamage() {

        return this.leftHand.getBaseDamage() +
          this.rightHand.getBaseDamage() +
          this.head.getBaseDamage() +
          this.feet.getBaseDamage() +
          this.chest.getBaseDamage();
    }
    float getDamageModifier() {

        return this.leftHand.getDamageModifier() +
          this.rightHand.getDamageModifier() +
          this.head.getDamageModifier() +
          this.feet.getDamageModifier() +
          this.chest.getDamageModifier();
    }
}
