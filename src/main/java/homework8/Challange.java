package homework8;

public class Challange {
    private Treadmill t1, t2, t3;
    private Barrier b1, b2;

    public Challange() {
        t1 = new Treadmill(180);
        t2 = new Treadmill(200);
        t3 = new Treadmill(1000);
        b1 = new Barrier(3);
        b2 = new Barrier(5);
    }

    public void getChellange(AbleToRun r, AbleToJump j) {
        System.out.println("===== Первый этап =====");
        t1.run(r);
        b1.jump(j);
        System.out.println("===== Второй этап =====");
        t2.run(r);
        b2.jump(j);
        System.out.println("===== Третий этап =====");
        t3.run(r);
    }
    /*
    public boolean isFinised(AbleToRun r, AbleToJump j) {
        if(r.enable() && j.enable())
            System.out.println();
    }
*/
}
