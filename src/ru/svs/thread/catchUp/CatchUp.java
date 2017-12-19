package ru.svs.thread.catchUp;

/**
 * Класс для запуска двух потоков.
 */

public class CatchUp {
    public static void main(String[] args) {

        Player pl1 = new Player("Вадим", 10, 1);
        Player pl2 = new Player("Дима", 1, 10);
        pl1.start();
        pl2.start();
    }
}
