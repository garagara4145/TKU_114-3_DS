public class PlaylistSystem {

    public static void main(String[] args) {

        PlaylistLinkedList list = new PlaylistLinkedList();

        System.out.println(" 空播放清單");
        list.playList();

        list.addSong("01", "a");
        list.addSong("02", "b");
        list.addSong("03", "c");
        list.addSong("04", "d");

        System.out.println("\n建立播放清單");
        list.playList();

        System.out.println("\n 新增重複歌曲");
        list.addSong("02", "重複歌曲");

        System.out.println("\n搜尋歌曲");

        PlaylistNode song = list.searchSong("S003");

        if (song != null) {
            System.out.println("找到：" + song.songName);
        } else {
            System.out.println("找不到");
        }

        song = list.searchSong("000");

        if (song != null) {
            System.out.println("找到：" + song.songName);
        } else {
            System.out.println("找不到");
        }
        System.out.println("\n 刪除第一首");
        list.removeSong("01");
        list.playList();
        System.out.println("\n刪除最後一首");
        list.removeSong("04");
        list.playList();

        System.out.println("\n刪除不存在歌曲");
        list.removeSong("000");
    }
}