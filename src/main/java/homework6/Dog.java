package homework6;

public class Dog extends Animal{
    private static int dogCount = 0;

    public Dog(String name) {
        super.setName(name);
        super.setRunEnable(true);
        super.setSwimEnable(true);
        super.setMaxRunDistance(500);
        super.setMaxSwimDistance(10);
        dogCount++;
    }

    public static int getDogCount(){
        return dogCount;
    }

    @Override
    public String doRunning(int distance){
        if(distance <= super.getMaxRunDistance() && distance > 0)
            return "Собака " + super.getName() + " пробегает " + distance + " метров.";
        else
            return "Собаки не в состоянии пробежать " + distance + " метров.";
    }

    @Override
    public String doSwimming(int distance){
        if(distance <= super.getMaxSwimDistance() && distance > 0)
            return "Собака " + super.getName() + " проплывает " + distance + " метров.";
        else
            return "Собаки не в состоянии проплыть " + distance + " метров.";
    }
}
