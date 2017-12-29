package ru.svs.thread.DownloadMusic;

import java.io.*;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * Класс для поиска ссылок.
 */
public class Download extends Thread {

    private String source;
    private String record;
    private String path;

    public Download(String source, String record, String path) {
        this.source = source;
        this.record = record;
        this.path = path;
    }

    public void run() {
        String Url, result;
        try (BufferedReader inFile = new BufferedReader(new FileReader(source))) {
            while ((Url = inFile.readLine()) != null) {
                URL url = new URL(Url);
                try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(url.openStream()))) {
                    result = bufferedReader.lines().collect(Collectors.joining("\n"));
                    searchUrl(result);
                }
            }
            download();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void searchUrl(String page) {
        try (BufferedWriter outFile = new BufferedWriter(new FileWriter(record, true))) {
            Pattern email_pattern = Pattern.compile("\\s*(?<=data-url\\s?=\\s?\")[^>]*/*(?=\")");
            Matcher matcher = email_pattern.matcher(page);
            for (int i = 0; matcher.find() && i < 2; i++) {
                outFile.write(matcher.group() + "\r\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void download() {
        try (BufferedReader musicFile = new BufferedReader(new FileReader(record))) {
            String music;
            for (int count = 0; (music = musicFile.readLine()) != null; count++) {
                DownloadMusic downloadMusic = new DownloadMusic(music, path + String.valueOf(count) + ".mp3");
                downloadMusic.start();
                downloadMusic.join();
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
