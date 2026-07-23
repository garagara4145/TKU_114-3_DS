import java.util.ArrayList;

public class ContactBookSystem {

    public static void main(String[] args) {

        ArrayList<Contact> contacts = new ArrayList<>();

        addContact(contacts, new Contact("C01", "Amy", "0911222333", "amy@gmail.com"));
        addContact(contacts, new Contact("C02", "John", "0922333444", "john@gmail.com"));
        addContact(contacts, new Contact("C03", "Mary", "0933444555", "mary@gmail.com"));

        addContact(contacts, new Contact("C01", "Tom", "0900000000", "tom@gmail.com"));

        Contact found = findContact(contacts, "C02");

        if (found != null) {
            found.setPhone("0999888777");
        }

        removeContact(contacts, "C03");

        System.out.println("===== 聯絡人清單 =====");
        showAll(contacts);
    }
    public static void addContact(ArrayList<Contact> contacts, Contact contact) {

        if (contact.getName().trim().isEmpty()) {
            System.out.println("姓名不可空白！");
            return;
        }

        if (findContact(contacts, contact.getCode()) == null) {
            contacts.add(contact);
            System.out.println("新增成功！");
        } else {
            System.out.println("代碼不可重複！");
        }
    }

    public static Contact findContact(ArrayList<Contact> contacts, String code) {

        for (Contact contact : contacts) {
            if (contact.getCode().equalsIgnoreCase(code)) {
                return contact;
            }
        }

        return null;
    }

    public static boolean updatePhone(ArrayList<Contact> contacts, String code, String phone) {

        Contact found = findContact(contacts, code);

        if (found == null) {
            return false;
        }

        found.setPhone(phone);
        return true;
    }
    public static boolean removeContact(ArrayList<Contact> contacts, String code) {

        Contact found = findContact(contacts, code);

        if (found == null) {
            return false;
        }

        return contacts.remove(found);
    }
    public static void showAll(ArrayList<Contact> contacts) {

        if (contacts.isEmpty()) {
            System.out.println("沒有任何聯絡人！");
            return;
        }

        for (Contact contact : contacts) {
            System.out.println(contact);
        }
    }
}