package ru.svs.thread.copyFiles2;

import ru.svs.thread.MultiRead.ReadAndWrite;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("/home/methaqualonum/IdeaProjects/Thread/src/ru/svs/thread/copyFiles2/Result.txt", false));
        ru.svs.thread.MultiRead.ReadAndWrite firstThread = new ReadAndWrite("/home/methaqualonum/IdeaProjects/Thread/src/ru/svs/thread/copyFiles2/FirstFile.txt", writer);
        ru.svs.thread.MultiRead.ReadAndWrite secondThread = new ReadAndWrite("/home/methaqualonum/IdeaProjects/Thread/src/ru/svs/thread/copyFiles2/SecondFile.txt", writer);

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
