package homework13;

import java.util.Date;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public class Car implements Runnable {
    private static int CARS_COUNT;
    private Race race;

    private int speed;
    private String name;
    public String getName() {
        return name;
    }
    public int getSpeed() {
        return speed;
    }
    public Car(Race race, int speed) {
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
    }
    //@Override
    public void run(CyclicBarrier cb) {
        try {
            System.out.println(new Date() + " " + this.name + " готовится");
            Thread.sleep(500 + (int)(Math.random() * 800));
            System.out.println(new Date() + " " + this.name + " готов");
            cb.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i = 0; i < race.getStages().size(); i++) {
            race.getStages().get(i).go(this);
        }
    }

    @Override
    public void run() {
        ;
    }

    public static int getCarsCount() {
        return CARS_COUNT;
    }
}