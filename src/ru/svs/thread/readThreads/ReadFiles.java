package ru.svs.thread.readThreads;

import java.io.*;

public class ReadFiles extends Thread{
    private String adress;
    private static volatile BufferedWriter bufferedWriter;
    //Конструктор

    public ReadFiles(String adress) {
        this.adress = adress;
    }

    public static void main(String[] args) throws IOException, InterruptedException {

        ReadFiles oneThread = new ReadFiles("/home/methaqualonum/IdeaProjects/Thread/src/ru/svs/thread/readThreads/first.txt");
        ReadFiles twoThread = new ReadFiles("/home/methaqualonum/IdeaProjects/Thread/src/ru/svs/thread/readThreads/second.txt");
        bufferedWriter = new BufferedWriter(new FileWriter("/home/methaqualonum/IdeaProjects/Thread/src/ru/svs/thread/readThreads/output.txt"));
        oneThread.start();
        twoThread.start();

        if(oneThread.isAlive()){
            oneThread.join();
        }
        if (twoThread.isAlive()){
            twoThread.join();
        }
        bufferedWriter.close();


    }

    /**
     * Метод считывает строку и сохраняет в переменную n
     * до тех пор, пока файл не станет пустым
     */
    public void run(){
        String n;
        try(BufferedReader one = new BufferedReader(new FileReader(adress)))
        {
            while ((n = one.readLine())!=null){
                write(n+"\n");
            }

        } catch (IOException e){
        }

    }

    /**
     * Метод записи строк в файл
     * @param  n - строка
     */
    public static synchronized void write(String n) throws IOException{
        bufferedWriter.write(n);
    }
}