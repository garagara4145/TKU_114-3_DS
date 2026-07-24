public class LinkedListReverse {

    public static void main(String[] args) {

        IntNode head = null;

        System.out.println("空串列：");
        printList(head);

        head = reverse(head);

        System.out.println("反轉後：");
        printList(head);

        head = new IntNode(10);

        System.out.println("\n單一節點：");
        printList(head);

        head = reverse(head);

        System.out.println("反轉後：");
        printList(head);
        head = new IntNode(10);
        head.next = new IntNode(20);
        head.next.next = new IntNode(30);
        head.next.next.next = new IntNode(40);

        System.out.println("\n多節點：");
        printList(head);

        head = reverse(head);

        System.out.println("反轉後：");
        printList(head);
    }
    public static IntNode reverse(IntNode head) {

        IntNode previous = null;
        IntNode current = head;

        while (current != null) {

            IntNode nextNode = current.next;

            current.next = previous;

            previous = current;

            current = nextNode;
        }

        return previous;
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