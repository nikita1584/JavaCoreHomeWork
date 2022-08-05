package homework8;

public class Cat implements AbleToRun, AbleToJump{
    private String name;
    private int maxBarrier;
    private int maxDistance;
    private boolean isEnable;

    public Cat(String name, int maxBarrier, int maxDistance) {
        this.name = name;
        this.maxBarrier = maxBarrier;
        this.maxDistance = maxDistance;
        this.isEnable = true;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean jumpingAction(int size) {
        if(size <= maxBarrier && isEnable) {
            System.out.println("Кот " + name + " прыгает на высоту " + size + " единиц");
            return true;
        }
        else {
            System.out.println("Кот " + name + " не допрыгнул на высоту " + size + " единиц");
            this.isEnable = false;
            return false;
        }
    }

    @Override
    public boolean runningAction(int distance) {
        if(distance <= maxDistance && isEnable) {
            System.out.println("Кот " + name + " пробежал " + distance + " единиц");
            return true;
        }
        else {
            System.out.println("Кот " + name + " не смог пробежать " + distance + " единиц");
            this.isEnable = false;
            return false;
        }
    }

    @Override
    public boolean enable() {
        return isEnable;
    }

}
