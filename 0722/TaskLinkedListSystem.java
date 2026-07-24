public class TaskLinkedListSystem {

    public static void main(String[] args) {

        TaskLinkedList list = new TaskLinkedList();

        System.out.println("空工作清單");
        list.showAllTasks();

        // 緊急工作
        list.addFirst("01", "修復伺服器");
        list.addFirst("02", "處理客戶問題");

        // 一般工作
        list.addLast("03", "完成報告");
        list.addLast("04", "更新網站");
        list.addLast("05", "資料備份");

        System.out.println("\n全部工作");
        list.showAllTasks();

        // 完成工作
        System.out.println("\n完成工作");
        list.completeTask("03");
        list.completeTask("05");
        list.completeTask("000");

        System.out.println("\n全部工作");
        list.showAllTasks();

        System.out.println("\n未完成工作");
        list.showPendingTasks();

        System.out.println("\n工作總數：" + list.totalTasks());
        System.out.println("未完成數：" + list.pendingTasks());

        System.out.println("\n刪除已完成工作");
        list.removeCompletedTasks();
        list.showAllTasks();

        System.out.println("\n工作總數：" + list.totalTasks());
        System.out.println("未完成數：" + list.pendingTasks());
    }
}