package ru.svs.thread.catchUp;


public class Player extends Thread {
    private String name;
    private int onePriority;
    private int twoPriority;

    public Player (String name, int onePriority, int twoPriority){
        this.name = name;
        this.onePriority = onePriority;
        this.twoPriority = twoPriority;

    }
    public Player() {
        this("Player",10,1);
    }

    public void run() {
        Thread thread = Thread.currentThread();
        thread.setPriority(onePriority);
        for (int i = 0; i < 200; i++) {
            try {
                sleep(10);
            } catch (InterruptedException e) {
            }
            System.out.println(name);
            if (i == 100) {
                thread.setPriority(twoPriority);
            }
        }
    }



}