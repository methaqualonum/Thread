package ru.svs.thread.DownloadMusic;

/**
 * Класс для запуска скачивания
 */
public class Demo {
    private static final String IN_FILE_TXT = "/home/methaqualonum/IdeaProjects/Thread/src/ru/svs/thread/DownloadMusic/inFIle.txt";
    private static final String OUT_FILE_TXT = "/home/methaqualonum/IdeaProjects/Thread/src/ru/svs/thread/DownloadMusic/outFile.txt";
    private static final String PATH_TO_MUSIC = "/home/methaqualonum/IdeaProjects/Thread/src/ru/svs/thread/DownloadMusic/music/";

    public static void main(String[] args) throws InterruptedException {
        Download music = new Download (IN_FILE_TXT,OUT_FILE_TXT,PATH_TO_MUSIC);
        music.start();
        music.join();
    }
}


