package ru.svs.thread.copyFiles;

public class Start {
    public static void main(String[] args) throws InterruptedException {
        long before = System.currentTimeMillis();
        Copy one = new Copy("/home/methaqualonum/IdeaProjects/Thread/src/ru/svs/thread/copyFiles/file.txt",
                "/home/methaqualonum/IdeaProjects/Thread/src/ru/svs/thread/copyFiles/firstOutput.txt");
        one.start();

        if(one.isAlive()){
            one.join();
        }
        System.out.println("Выполнение первого: "+(System.currentTimeMillis() - before) + " милисекунд");

        long beforeOne = System.currentTimeMillis();
        Copy two = new Copy("/home/methaqualonum/IdeaProjects/Thread/src/ru/svs/thread/copyFiles/file.txt",
                "/home/methaqualonum/IdeaProjects/Thread/src/ru/svs/thread/copyFiles/secondOutput.txt");
        two.start();
        if(two.isAlive()){
            two.join();
        }
        System.out.println("Выполнение второго: "+(System.currentTimeMillis() - beforeOne) + " милисекунд");


    }
}
