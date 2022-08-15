package homework10;

public class Box<T extends Fruit> {
    private T[] mas;
    private double weight;

    public Box(T[] mas) {
        if(mas != null){
            this.mas = mas;
            for (int i = 0; i < mas.length; i++) {
                weight += mas[i].getWeight();
            }
        }
    }

    public boolean Compare(Box<?> comparedItem) {
        return this.weight == comparedItem.getWeight() && comparedItem != null;
    }

    public void Reduce() {
        mas = null;
        weight = 0;
    }

    public int getCount() {
        if (mas != null)
            return mas.length;
        else
            return 0;
    }

    public T[] getItems() {
        return this.mas;
    }

    public double getWeight() {
        return weight;
    }

    public boolean MoveFrom(Box<? extends T> anotherBox) {
            //I don't know how to do correct
            T[] newMas = (T[]) new Object[mas.length + anotherBox.getCount()]; // is it correct?
            mas = newMas;
            weight += anotherBox.getWeight();
            anotherBox.Reduce();
            return true;
    }
}
