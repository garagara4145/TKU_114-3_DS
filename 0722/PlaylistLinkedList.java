public class PlaylistLinkedList {

    private PlaylistNode head;
    public void addSong(String songId, String songName) {
        if (searchSong(songId) != null) {
            System.out.println("歌曲代碼重複：" + songId);
            return;
        }

        PlaylistNode newNode = new PlaylistNode(songId, songName);

        if (head == null) {
            head = newNode;
            return;
        }

        PlaylistNode current = head;

        while (current.next != null) {
            current = current.next;
        }

        current.next = newNode;
    }

    public PlaylistNode searchSong(String songId) {

        PlaylistNode current = head;

        while (current != null) {

            if (current.songId.equals(songId)) {
                return current;
            }

            current = current.next;
        }

        return null;
    }
    public void removeSong(String songId) {

        if (head == null) {
            System.out.println("播放清單為空！");
            return;
        }
        if (head.songId.equals(songId)) {
            head = head.next;
            System.out.println("已刪除：" + songId);
            return;
        }

        PlaylistNode previous = head;
        PlaylistNode current = head.next;

        while (current != null) {

            if (current.songId.equals(songId)) {

                previous.next = current.next;
                System.out.println("已刪除：" + songId);
                return;
            }

            previous = current;
            current = current.next;
        }

        System.out.println("找不到歌曲：" + songId);
    }

    public void playList() {

        if (head == null) {
            System.out.println("播放清單為空！");
            return;
        }

        PlaylistNode current = head;

        while (current != null) {

            System.out.println(current.songId + " - " + current.songName);

            current = current.next;
        }
    }
}