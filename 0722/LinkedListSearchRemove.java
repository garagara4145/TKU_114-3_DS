public class LinkedListSearchRemove {

    public static void main(String[] args) {

        IntNode head = null;

        System.out.println("空串列測試：");
        printList(head);

        head = new IntNode(10);
        head.next = new IntNode(20);
        head.next.next = new IntNode(30);
        head.next.next.next = new IntNode(40);

        System.out.println("\n原始串列：");
        printList(head);

        System.out.println("\n搜尋20：" + contains(head, 20));
        System.out.println("搜尋50：" + contains(head, 50));

        System.out.println("\n刪除 Head (10)");
        head = removeValue(head, 10);
        printList(head);

        System.out.println("\n刪除中間節點 (30)");
        head = removeValue(head, 30);
        printList(head);

        System.out.println("\n刪除最後節點 (40)");
        head = removeValue(head, 40);
        printList(head);

        System.out.println("\n刪除不存在資料 (99)");
        head = removeValue(head, 99);
        printList(head);
    }

    public static boolean contains(IntNode head, int target) {
        IntNode current = head;

        while (current != null) {
            if (current.data == target) {
                return true;
            }
            current = current.next;
        }

        return false;
    }

    public static IntNode removeValue(IntNode head, int target) {

        if (head == null) {
            System.out.println("空串列，無法刪除！");
            return null;
        }
        if (head.data == target) {
            return head.next;
        }

        IntNode previous = head;
        IntNode current = head.next;

        while (current != null) {
            if (current.data == target) {
                previous.next = current.next;
                return head;
            }

            previous = current;
            current = current.next;
        }

        System.out.println("找不到資料：" + target);
        return head;
    }
    public static void printList(IntNode head) {

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
}