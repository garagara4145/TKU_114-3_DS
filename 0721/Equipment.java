public class Equipment {
    private String code;
    private String name;
    private boolean available;

    public Equipment(String code, String name) {
        this.code = code;
        this.name = name;
        this.available = true;
    }

    public String getCode() {
        return code;
    }

    public boolean isAvailable() {
        return available;
    }

    public void borrow() {
        if (available) {
            available = false;
        }
    }

    public void returnEquipment() {
        available = true;
    }

    @Override
    public String toString() {
        return code + " | " + name + " | " +
                (available ? "可借用" : "已借出");
    }
}