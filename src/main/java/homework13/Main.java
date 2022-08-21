package homework13;

import java.util.Date;
import java.util.concurrent.*;

/**
 * Перенести приведенный ниже код (указан в методичке) в новый проект, где мы организуем гонки. Все участники
 * должны стартовать одновременно, несмотря на разное время подготовки. В тоннель не может одновременно заехать
 * больше половины участников (условность). Попробуйте все это синхронизировать. Первый участник, пересекший
 * финишную черту, объявляется победителем (в момент пересечения этой самой черты). Победитель должен быть только
 * один (ситуация с 0 или 2+ победителями недопустима). Когда все завершат гонку, нужно выдать объявление об
 * окончании. Можно корректировать классы (в том числе конструктор машин) и добавлять объекты классов из
 * пакета java.util.concurrent.
 * */

public class Main {
    public static final int CARS_COUNT = 4;
    public static void main(String[] args) throws InterruptedException {

        CyclicBarrier cb = new CyclicBarrier(CARS_COUNT);
        CountDownLatch cdl = new CountDownLatch(CARS_COUNT);

        System.out.println(new Date() + " " + "ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");
        Race race = new Race(new Road(60, cdl, false), new Tunnel(), new Road(40, cdl, true));
        Car[] cars = new Car[CARS_COUNT];

        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(race, 20 + (int) (Math.random() * 10));
        }

        System.out.println(new Date() + " " + "ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");
        for (int i = 0; i < cars.length; i++) {
            int finalI = i;
            new Thread(() -> {cars[finalI].run(cb);}).start();
        }
        cdl.await();
        System.out.println(new Date() + " " + "ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
        return;
    }

}
