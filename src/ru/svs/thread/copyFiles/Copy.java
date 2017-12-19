package ru.svs.thread.copyFiles;

import java.io.*;

public class Copy extends Thread {
    private String adress;
    private String output;

    Copy(String adress, String output) {
        this.adress = adress;
        this.output = output;
    }

    public void run() {
        String string;
        long before = System.currentTimeMillis();
        try(BufferedReader reader = new BufferedReader(new FileReader(adress));
            BufferedWriter write = new BufferedWriter(new FileWriter(output))){
            while ((string = reader.readLine()) != null){
                write.write(string+ "\n");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Копирование: "+ (System.currentTimeMillis() - before) +" милисекунд");

    }
}
