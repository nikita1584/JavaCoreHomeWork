package homework6;

public class Cat extends Animal{
    private static int catCount = 0;

    public Cat(String name) {
        super.setName(name);
        super.setRunEnable(true);
        super.setSwimEnable(false);
        super.setMaxRunDistance(200);
        super.setMaxSwimDistance(0);
        catCount++;
    }

    public static int getCatCount(){
        return catCount;
    }

    @Override
    public String doRunning(int distance){
        if(distance <= super.getMaxRunDistance() && distance > 0)
            return "Кот " + super.getName() + " пробегает " + distance + " метров.";
        else
            return "Коты не в состоянии пробежать " + distance + " метров.";
    }

    @Override
    public String doSwimming(int distance){
        return "Кот " + super.getName() + " не поплыл, потому что коты не умеют плавать.";
    }
}
