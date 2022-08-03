package homework7;

public class Cat {

    private final String name;
    private final int appetite;
    private boolean isFull;
    private int isFullThreshold;
    public int foodInCat;

    public Cat(String name, int appetite, int isFullThreshold) {
        this.name = name;
        this.appetite = appetite;
        this.isFull = false;
        this.isFullThreshold = isFullThreshold;
        this.foodInCat = 0;
    }

    public void eat(Plate plate) {
        if(appetite <= plate.getFood()) {
            plate.decreaseFood(appetite);
            foodInCat += appetite;
            if(foodInCat >= isFullThreshold)
                isFull = true;
        }
    }

    public String getName() {
        return name;
    }

    public boolean getIsFull() {
        return isFull;
    }
}
