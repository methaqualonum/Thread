package ru.svs.thread.Resources;

/**
 * Класс, расширяющий класс Thread, для органихации инкремента переменной i.
 */
public class Resources extends Thread {
    public volatile static int i = 0;

    @Override
    public void run() {
        for (int j = 0; j < 1_000; j++) {
            inc();
            System.out.println(i);
        }
    }

    /**
     * Данный метод увеличивает значение переменной i на 1.
     */
    public static synchronized void inc(){
        i++;

    }

    public static void main(String[] args) {
        Resources resources = new Resources();
        Resources resources2 = new Resources();

        resources.start();
        resources2.start();
    }
}
