public class BuildLinkedList {

    public static void main(String[] args) {

        IntNode head = null;
        if (head == null) {
            System.out.println("目前為空串列");
        }

        IntNode node1 = new IntNode(10);
        IntNode node2 = new IntNode(20);
        IntNode node3 = new IntNode(30);
        IntNode node4 = new IntNode(40);

        head = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        System.out.println("鏈結串列內容：");

        IntNode current = head;
        int count = 0;
        int sum = 0;

        while (current != null) {
            System.out.print(current.data + " -> ");
            count++;
            sum += current.data;
            current = current.next;
        }
        System.out.println("null");
        System.out.println("節點數：" + count);
        System.out.println("總和：" + sum);

        int target = 30;
        if (contains(head, target)) {
            System.out.println("找到資料：" + target);
        } else {
            System.out.println("找不到資料：" + target);
        }

        target = 50;
        if (contains(head, target)) {
            System.out.println("找到資料：" + target);
        } else {
            System.out.println("找不到資料：" + target);
        }
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
}