public class TaskLinkedList {

    private TaskNode head;

    public void addFirst(String code, String description) {

        TaskNode node = new TaskNode(code, description);

        node.next = head;
        head = node;
    }

    public void addLast(String code, String description) {

        TaskNode node = new TaskNode(code, description);

        if (head == null) {
            head = node;
            return;
        }

        TaskNode current = head;

        while (current.next != null) {
            current = current.next;
        }

        current.next = node;
    }

    public void completeTask(String code) {

        TaskNode current = head;

        while (current != null) {

            if (current.taskCode.equals(code)) {
                current.completed = true;
                System.out.println("工作完成：" + code);
                return;
            }

            current = current.next;
        }

        System.out.println("找不到工作：" + code);
    }

    public void removeCompletedTasks() {

        while (head != null && head.completed) {
            head = head.next;
        }

        if (head == null)
            return;

        TaskNode previous = head;
        TaskNode current = head.next;

        while (current != null) {

            if (current.completed) {

                previous.next = current.next;
                current = previous.next;

            } else {

                previous = current;
                current = current.next;
            }
        }
    }

    public void showPendingTasks() {

        if (head == null) {
            System.out.println("工作清單為空！");
            return;
        }

        TaskNode current = head;

        boolean found = false;

        while (current != null) {

            if (!current.completed) {

                System.out.println(current.taskCode + " - " + current.description);

                found = true;
            }

            current = current.next;
        }

        if (!found) {
            System.out.println("沒有未完成工作。");
        }
    }

    public void showAllTasks() {

        if (head == null) {
            System.out.println("工作清單為空！");
            return;
        }

        TaskNode current = head;

        while (current != null) {

            System.out.println(
                    current.taskCode + " - "
                            + current.description + " ("
                            + (current.completed ? "已完成" : "未完成") + ")");

            current = current.next;
        }
    }

    public int totalTasks() {

        int count = 0;

        TaskNode current = head;

        while (current != null) {
            count++;
            current = current.next;
        }

        return count;
    }

    public int pendingTasks() {

        int count = 0;

        TaskNode current = head;

        while (current != null) {

            if (!current.completed)
                count++;

            current = current.next;
        }

        return count;
    }
}