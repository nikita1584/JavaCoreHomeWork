package homework6;

public abstract class Animal {
    protected String name;
    protected boolean swimEnable;
    protected boolean runEnable;
    protected int maxRunDistance;
    protected int maxSwimDistance;
    private static int animalCount = 0;

    public Animal(){
        animalCount++;
    }

    public static int getAnimalCount(){
        return animalCount;
    }

    protected void setSwimEnable(boolean swimEnable){
        this.swimEnable = swimEnable;
    }

    protected void setRunEnable(boolean runEnable){
        this.runEnable = runEnable;
    }

    protected void setName(String name){
        this.name = name;
    }

    protected String getName(){
        return name;
    }

    protected void setMaxRunDistance(int maxRunDistance){
        this.maxRunDistance = maxRunDistance;
    }

    protected int getMaxRunDistance(){
        return maxRunDistance;
    }

    protected void setMaxSwimDistance(int maxSwimDistance){
        this.maxSwimDistance = maxSwimDistance;
    }

    protected int getMaxSwimDistance(){
        return maxSwimDistance;
    }

    public String doRunning(int distance){
        return null;
    }

    public String doSwimming(int distance){
        return null;
    }
}
