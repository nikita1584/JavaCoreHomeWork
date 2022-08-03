package homework7;

public class Plate {

    private int food;

    public Plate(int food) {
        this.food = food;
    }

    public void decreaseFood(int foodToDecrease) {
        if(food >= foodToDecrease)
            food -= foodToDecrease;
        else
            food = 0;
    }

    public int getFood() {
        return food;
    }

    public void addFood(int newFood) {
        food += newFood;
    }

    public void printInfo() {
        System.out.println("В тарелке " + food + " единиц еды");
    }

}
