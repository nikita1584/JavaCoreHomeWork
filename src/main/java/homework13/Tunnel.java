package homework13;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class Tunnel extends Stage {
    private ExecutorService executorService;
    private Semaphore semaphore;
    public Tunnel() {
        this.length = 80;
        executorService = Executors.newFixedThreadPool(4);//Car.getCarsCount(); - illegal argument? why?
        semaphore = new Semaphore(2);//Car.getCarsCount() / 2 - why not working? '2' - is working!
        this.description = "Тоннель " + length + " метров";
    }
    @Override
    public void go(Car c) {
        this.executorService.execute(() -> {
            try {
                this.semaphore.acquire();
                System.out.println(new Date() + " " + c.getName() + " готовится к этапу(ждет): " +
                        description);
                System.out.println(new Date() + " " + c.getName() + " начал этап: " + description);
                Thread.sleep(length / c.getSpeed() * 1000);
            }
            catch (InterruptedException e){
                throw new RuntimeException(e);
            }
            finally {
                System.out.println(new Date() + " " + c.getName() + " закончил этап: " +
                        description);
                this.semaphore.release();
            }
        });
    }
}

