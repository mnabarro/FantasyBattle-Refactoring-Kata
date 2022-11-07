package codingdojo;

public class Inventory {
    private final Equipment equipment;

    public Inventory(Equipment equipment) {
        this.equipment = equipment;
    }

    Equipment getEquipment() {
        return equipment;
    }
}
