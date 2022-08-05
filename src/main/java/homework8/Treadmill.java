package homework8;

public class Treadmill {
    private int distance;

    public Treadmill(int distance) {
        this.distance = distance;
    }

    public int getDistance() {
        return distance;
    }

    public void run(AbleToRun r) {
        r.runningAction(this.distance);
    }
}
