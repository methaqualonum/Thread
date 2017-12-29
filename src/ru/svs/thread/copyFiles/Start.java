package ru.svs.thread.copyFiles;

public class Start {
    private static final String FILE_TXT = "/home/methaqualonum/IdeaProjects/Thread/src/ru/svs/thread/copyFiles/file.txt";
    private static final String FIRST_OUTPUT_TXT = "/home/methaqualonum/IdeaProjects/Thread/src/ru/svs/thread/copyFiles/firstOutput.txt";
    private static final String SECOND_OUTPUT_TXT = "/home/methaqualonum/IdeaProjects/Thread/src/ru/svs/thread/copyFiles/secondOutput.txt";

    public static void main(String[] args) throws InterruptedException {
        long before = System.currentTimeMillis();
        Copy one = new Copy(FILE_TXT, FIRST_OUTPUT_TXT);
        one.start();

        if(one.isAlive()){
            one.join();
        }
        System.out.println("Выполнение первого: "+(System.currentTimeMillis() - before) + " милисекунд");

        long beforeOne = System.currentTimeMillis();
        Copy two = new Copy(FILE_TXT, SECOND_OUTPUT_TXT);
        two.start();
        if(two.isAlive()){
            two.join();
        }
        System.out.println("Выполнение второго: "+(System.currentTimeMillis() - beforeOne) + " милисекунд");


    }
}
