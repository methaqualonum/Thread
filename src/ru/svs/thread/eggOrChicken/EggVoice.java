package ru.svs.thread.eggOrChicken;

public class EggVoice extends Thread {
    @Override
    public void run()
    {
        for(int i = 0; i < 5; i++)
        {
            try{
                sleep(100);		//Приостанавливает поток на 1 секунду
            }catch(InterruptedException e){}

            System.out.println("яйцо!");
        }
        //Слово «яйцо» сказано 5 раз
    }
}
