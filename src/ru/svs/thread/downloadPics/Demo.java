package ru.svs.thread.downloadPics;

import ru.svs.thread.DownloadMusic.Download;

public class Demo {

    private static final String IN_FILE_TXT = "/home/methaqualonum/IdeaProjects/Thread/src/ru/svs/thread/downloadPics/inFile.txt";
    private static final String OUT_FILE_TXT = "/home/methaqualonum/IdeaProjects/Thread/src/ru/svs/thread/downloadPics/outFile.txt";
    private static final String PATH_TO_PICS = "/home/methaqualonum/IdeaProjects/Thread/src/ru/svs/thread/downloadPics/pics/";

    public static void main(String[] args) throws InterruptedException {
        ru.svs.thread.DownloadMusic.Download pics = new Download(IN_FILE_TXT,OUT_FILE_TXT,PATH_TO_PICS);
        pics.start();
        pics.join();
    }
}
