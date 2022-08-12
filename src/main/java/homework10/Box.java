package homework10;

public class Box<T> {
    private T[] mas;
    private double weight;

    public Box(T[] mas) {
        this.mas = mas;

        // how can I do this?
        /*
        for (int i = 0; i < mas.length; i++) {
            mas[i] = new T();
        }
        */

        if(mas[0] instanceof Orange) // is it a bad practice? but how?
            weight = mas.length * 1.5;
        else if (mas[0] instanceof Apple)
            weight = mas.length;
        else
            weight = 0;
    }

    public boolean Compare(Box comparedItem) {
        return this.weight == comparedItem.getWeight();
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

    public boolean Move(Box anotherBox) {
        if((anotherBox.getItems()[0] instanceof GoldenApple && mas[0] instanceof Apple) ||
                (anotherBox.getItems().getClass() == mas.getClass())) {
            T[] newMas = (T[]) new Object[mas.length + anotherBox.getCount()]; // is it correct?
            mas = newMas;
            weight += anotherBox.getWeight();
            anotherBox.Reduce();
            return true;
        }
        else
            return false;
    }
}
