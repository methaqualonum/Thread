package ru.svs.thread.downloadMusic;

import java.io.*;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;


public class DownloadMusic extends Thread {

    private static final String IN_FILE_TXT = "/home/methaqualonum/IdeaProjects/Thread/src/ru/svs/thread/downloadMusic/inFile.txt";
    private static final String OUT_FILE_TXT = "/home/methaqualonum/IdeaProjects/Thread/src/ru/svs/thread/downloadMusic/outFile.txt";
    private static final String PATH_TO_MUSIC = "/home/methaqualonum/IdeaProjects/Thread/src/ru/svs/thread/downloadMusic/music/";

    @Override
    public void run() {
        try (BufferedReader musicFile = new BufferedReader(new FileReader(OUT_FILE_TXT))) {
            String music;
            int count = 0;
            try {
                while ((music = musicFile.readLine()) != null) {
                    new Download(music, PATH_TO_MUSIC + String.valueOf(count) + ".mp3").start();
                    count++;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String Url;
        String result;
        try (BufferedReader inFile = new BufferedReader(new FileReader(IN_FILE_TXT));
             BufferedWriter outFile = new BufferedWriter(new FileWriter(OUT_FILE_TXT))) {
            while ((Url = inFile.readLine()) != null) {
                URL url = new URL(Url);

                try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(url.openStream()))) {
                    while ((result = bufferedReader.lines().collect(Collectors.joining("\n"))) != null) {

                        Pattern email_pattern = Pattern.compile("\\s*(?<=data-url\\s?=\\s?\")[^>]*\\/*(?=\")");
                        Matcher matcher = email_pattern.matcher(result);
                        while (matcher.find()) {
                            outFile.write(matcher.group() + "\r\n");
                        }
                        break;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        DownloadMusic music = new DownloadMusic();
        music.start();
    }

}

