public class NumberHistoryList {

    static IntNode head = null;

    public static void main(String[] args) {

        System.out.println("===== 空串列 =====");
        printStatus();

        addFirst(30);
        addFirst(20);
        addLast(40);
        addFirst(10);
        addLast(50);

        System.out.println("\n===== 建立完成 =====");
        printStatus();

        System.out.println("\n搜尋30：" + contains(30));
        System.out.println("搜尋99：" + contains(99));
        System.out.println("\n刪除20");
        removeValue(20);
        printStatus();
        System.out.println("\n刪除50");
        removeValue(50);
        printStatus();
        System.out.println("\n刪除100");
        removeValue(100);
        printStatus();
    }

    public static void addFirst(int value) {
        IntNode node = new IntNode(value);
        node.next = head;
        head = node;
    }

    public static void addLast(int value) {

        IntNode node = new IntNode(value);

        if (head == null) {
            head = node;
            return;
        }

        IntNode current = head;

        while (current.next != null) {
            current = current.next;
        }

        current.next = node;
    }
    public static boolean contains(int target) {

        IntNode current = head;

        while (current != null) {
            if (current.data == target)
                return true;
            current = current.next;
        }

        return false;
    }
    public static void removeValue(int target) {

        if (head == null) {
            System.out.println("空串列，無法刪除。");
            return;
        }

        if (head.data == target) {
            head = head.next;
            return;
        }

        IntNode previous = head;
        IntNode current = head.next;

        while (current != null) {

            if (current.data == target) {
                previous.next = current.next;
                return;
            }

            previous = current;
            current = current.next;
        }

        System.out.println("找不到資料：" + target);
    }
    public static int size() {

        int count = 0;

        IntNode current = head;

        while (current != null) {
            count++;
            current = current.next;
        }

        return count;
    }

    public static int sum() {

        int total = 0;

        IntNode current = head;

        while (current != null) {
            total += current.data;
            current = current.next;
        }

        return total;
    }

    public static void printList() {

        if (head == null) {
            System.out.println("null");
            return;
        }

        IntNode current = head;

        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }

        System.out.println("null");
    }
    public static void printStatus() {

        System.out.print("串列：");
        printList();

        if (head == null) {
            System.out.println("大小：0");
            System.out.println("總和：0");
            System.out.println("頂端：無");
            System.out.println("尾端：無");
            return;
        }

        IntNode current = head;

        while (current.next != null) {
            current = current.next;
        }

        System.out.println("大小：" + size());
        System.out.println("總和：" + sum());
        System.out.println("頂端：" + head.data);
        System.out.println("尾端：" + current.data);
    }
}