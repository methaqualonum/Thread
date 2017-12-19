package ru.svs.thread.threadDemo;

/**
 * Пример запуска нескольких потоков
 */

public class RandomRunExample extends Thread{
    public void run(){
        //Получение имени текущего потока
        System.out.println(Thread.currentThread().getName());
    }
    /**
     * Создание и запуск 10 потоков
     */
    public static void example(){
        for(int i = 0; i<10; i++){
            Thread thread = new RandomRunExample();
            thread.start();
        }
    }

}
