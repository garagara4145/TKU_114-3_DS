import java.util.ArrayList;

public class EquipmentManager {

    public static void main(String[] args) {

        ArrayList<Equipment> equipments = new ArrayList<>();

        addEquipment(equipments, new Equipment("E01", "Laptop"));
        addEquipment(equipments, new Equipment("E02", "Projector"));
        addEquipment(equipments, new Equipment("E03", "Camera"));
        addEquipment(equipments, new Equipment("E01", "Tablet"));

        Equipment found = findEquipment(equipments, "E02");

        if (found != null) {
            found.borrow();
        }

        found = findEquipment(equipments, "E02");

        if (found != null) {
            found.returnEquipment();
        }

        Equipment first = firstAvailable(equipments);

        if (first != null) {
            System.out.println("第一台可借設備：");
            System.out.println(first);
        }

        System.out.println("\n所有設備：");
        for (Equipment equipment : equipments) {
            System.out.println(equipment);
        }
    }

    public static void addEquipment(ArrayList<Equipment> equipments, Equipment equipment) {
        if (findEquipment(equipments, equipment.getCode()) == null) {
            equipments.add(equipment);
        } else {
            System.out.println("設備代碼重複！");
        }
    }

    public static Equipment findEquipment(ArrayList<Equipment> equipments, String code) {
        for (Equipment equipment : equipments) {
            if (equipment.getCode().equalsIgnoreCase(code)) {
                return equipment;
            }
        }
        return null;
    }

    public static Equipment firstAvailable(ArrayList<Equipment> equipments) {
        for (Equipment equipment : equipments) {
            if (equipment.isAvailable()) {
                return equipment;
            }
        }
        return null;
    }
}