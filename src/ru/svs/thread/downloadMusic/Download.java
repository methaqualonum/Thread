package ru.svs.thread.downloadMusic;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

public class Download extends Thread {
    private String urlStr;
    private String file;

    public Download(String url, String file) {
        this.urlStr = url;
        this.file = file;
    }

    @Override
    public void run() {

        URL url = null;
        try {
            url = new URL(urlStr);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        ReadableByteChannel byteChannel = null;
        try {
            byteChannel = Channels.newChannel(url.openStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        FileOutputStream stream = null;
        try {
            stream = new FileOutputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            stream.getChannel().transferFrom(byteChannel, 0, Long.MAX_VALUE);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            stream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            byteChannel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
