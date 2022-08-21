package homework13;

import java.util.Date;
import java.util.concurrent.CountDownLatch;

public class Road extends Stage {
    private CountDownLatch cdl;
    private boolean isFinish;
    public Road(int length,  CountDownLatch cdl, boolean isFinish) {
        this.length = length;
        this.description = "Дорога " + length + " метров";
        this.cdl = cdl;
        this.isFinish = isFinish;
    }
    @Override
    public void go(Car c) {
        try {
            System.out.println(new Date() + " " + c.getName() + " начал этап: " + description);
            Thread.sleep(length / c.getSpeed() * 1000);
            System.out.println(new Date() + " " + c.getName() + " закончил этап: " + description);
            if(isFinish) {
                cdl.countDown();
                if(cdl.getCount() == Car.getCarsCount() - 1)
                    System.out.println("Участник " + c.getName() + " финишировал первым! Поздравляем!");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

