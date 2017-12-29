package ru.svs.thread.MultiRead;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Класс для создания и запуска потоков.
 */

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("/home/methaqualonum/IdeaProjects/Thread/src/ru/svs/thread/MultiRead/Result.txt", false));
        ReadAndWrite firstThread = new ReadAndWrite("/home/methaqualonum/IdeaProjects/Thread/src/ru/svs/thread/MultiRead/FirstFile.txt", writer);
        ReadAndWrite secondThread = new ReadAndWrite("/home/methaqualonum/IdeaProjects/Thread/src/ru/svs/thread/MultiRead/SecondFile.txt", writer);

        firstThread.start();
        secondThread.start();

        if (firstThread.isAlive()) {
            firstThread.join();
        }
        if (secondThread.isAlive()) {
            secondThread.join();
        }
        writer.close();
    }
}