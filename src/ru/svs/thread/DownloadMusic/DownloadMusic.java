package ru.svs.thread.DownloadMusic;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

/**
 * Класс для скачивания музыки
 */
public class DownloadMusic extends Thread {
    private String address;
    private String file;

    public DownloadMusic(String address, String file) {
        this.address = address;
        this.file = file;
    }

    @Override
    public void run() {
        try {
            URL url = new URL(address);
            ReadableByteChannel byteChannel = Channels.newChannel(url.openStream());
            FileOutputStream stream = new FileOutputStream(file);
            stream.getChannel().transferFrom(byteChannel, 0, Long.MAX_VALUE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

