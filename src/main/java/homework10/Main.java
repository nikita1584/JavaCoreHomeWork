package homework10;

/**
 * 1. Написать метод, который меняет два элемента массива местами (массив может быть любого
 * ссылочного типа);
 * 2. Задача:
 * a. Даны классы Fruit, Apple extends Fruit, Orange extends Fruit;
 * a.* Создать класс GoldenApple extends Apple и подумать, как изменится метод из пункта f
 * b. Класс Box, в который можно складывать фрукты. Коробки условно сортируются по типу
 * фрукта, поэтому в одну коробку нельзя сложить и яблоки, и апельсины;
 * c. Для хранения фруктов внутри коробки можно использовать массив
 * d. Сделать метод getWeight(), который высчитывает вес коробки, зная вес одного фрукта
 * и их количество: вес яблока – 1.0f, апельсина – 1.5f (единицы измерения не важны);
 * e. Внутри класса Box сделать метод compare(), который позволяет сравнить текущую
 * коробку с той, которую подадут в compare() в качестве параметра. true – если их массы
 * равны, false в противоположном случае. Можно сравнивать коробки с яблоками и
 * апельсинами;
 * f. Написать метод, который позволяет пересыпать фрукты из текущей коробки в другую.
 * Помним про сортировку фруктов: нельзя яблоки высыпать в коробку с апельсинами.
 * Соответственно, в текущей коробке фруктов не остается, а в другую перекидываются
 * объекты, которые были в первой;
 **/

public class Main {
    public static void main(String[] args) {
        Apple []apples1 = new Apple[15];
        Apple []apples2 = new Apple[20];
        Apple []apples3 = new Apple[20];
        GoldenApple []goldenApples1 = new GoldenApple[5];
        GoldenApple []goldenApples2 = new GoldenApple[7];
        Orange []oranges1 = new Orange[15];
        Orange []oranges2 = new Orange[10];

        for (int i = 0; i < apples1.length; i++) {
            apples1[i] = new Apple();
        }
        for (int i = 0; i < apples2.length; i++) {
            apples2[i] = new Apple();
        }
        for (int i = 0; i < apples3.length; i++) {
            apples3[i] = new Apple();
        }
        for (int i = 0; i < oranges1.length; i++) {
            oranges1[i] = new Orange();
        }
        for (int i = 0; i < oranges2.length; i++) {
            oranges2[i] = new Orange();
        }
        for (int i = 0; i < goldenApples1.length; i++) {
            goldenApples1[i] = new GoldenApple();
        }
        for (int i = 0; i < goldenApples2.length; i++) {
            goldenApples2[i] = new GoldenApple();
        }

        Box<Apple> appleBox1 = new Box<>(apples1);
        Box<Apple> appleBox2 = new Box<>(apples2);
        Box<Apple> appleBox3 = new Box<>(apples3);
        Box<GoldenApple> goldenAppleBox1 = new Box<>(goldenApples1);
        Box<GoldenApple> goldenAppleBox2 = new Box<>(goldenApples2);

        Box<Orange> orangeBox1 = new Box<>(oranges1);
        Box<Orange> orangeBox2 = new Box<>(oranges2);

        if (appleBox1.Compare(appleBox2))
            System.out.println("Коробки c яблоками 1 и 2 одинаково весят");
        else
            System.out.println("Коробки c яблоками имеют разный вес");

        if (appleBox2.Compare(appleBox3))
            System.out.println("Коробки c яблоками 2 и 3 одинаково весят");
        else
            System.out.println("Коробки c яблоками имеют разный вес");

        if (orangeBox2.Compare(appleBox1))
            System.out.println("Коробки c апельсинами 2 и яблоками 1 одинаково весят");
        else
            System.out.println("Коробки c яблоками и апельсинами имеют разный вес");

        System.out.println("");
        System.out.println("В коробке с апельсинами 1 лежит " + orangeBox1.getCount() + " апельсинов, вес "
                + orangeBox1.getWeight());
        System.out.println("В коробке с апельсинами 2 лежит " + orangeBox2.getCount() + " апельсинов, вес "
                + orangeBox2.getWeight());

        System.out.println("Пересыпаем все апельсины и коробки 1 в 2");
        orangeBox2.MoveFrom(orangeBox1);
        System.out.println("В коробке с апельсинами 1 лежит " + orangeBox1.getCount() + " апельсинов, вес "
                + orangeBox1.getWeight());
        System.out.println("В коробке с апельсинами 2 лежит " + orangeBox2.getCount() + " апельсинов, вес "
                + orangeBox2.getWeight());

        System.out.println("В коробке с яблоками 1 лежит " + appleBox1.getCount() + " яблоками, вес "
                + appleBox1.getWeight());
        System.out.println("В коробке с золотыми яблоками 2 лежит " + goldenAppleBox1.getCount() + " яблок, вес "
                + goldenAppleBox1.getWeight());

        System.out.println("Пересыпаем все золотые яблоки в коробку с яблоками 1");

        if(appleBox1.MoveFrom(goldenAppleBox1)){
            System.out.println("В коробке с яблоками 1 лежит " + appleBox1.getCount() + " яблоками, вес "
                    + appleBox1.getWeight());
            System.out.println("В коробке с золотыми яблоками 2 лежит " + goldenAppleBox1.getCount() +
                    " апельсинов, вес " + goldenAppleBox1.getWeight());
        }
        else
            System.out.println("Пересыпать золотые яблоки в коробку с обычными не удалось");

        System.out.println("В коробке с яблоками 3 лежит " + appleBox3.getCount() + " яблоками, вес "
                + appleBox3.getWeight());
        System.out.println("В коробке с золотыми яблоками 2 лежит " + goldenAppleBox2.getCount() + " яблок, вес "
                + goldenAppleBox2.getWeight());

        System.out.println("Пересыпаем все яблоки 3 в коробку с золотыми яблоками 2");

        /*
        // error
        if(goldenAppleBox2.MoveFrom(appleBox3)){
            System.out.println("В коробке с яблоками 3 лежит " + appleBox3.getCount() + " яблоками, вес "
                    + appleBox3.getWeight());
            System.out.println("В коробке с золотыми яблоками 2 лежит " + goldenAppleBox2.getCount() +
                    " апельсинов, вес " + goldenAppleBox2.getWeight());
        }
        else
            System.out.println("Пересыпать яблоки в коробку с золотыми не удалось");
        */
    }

    public <T>boolean Swap(int i, int j, T ... mas){
        if(i >= 0 && i < mas.length && j >= 0 && j < mas.length && mas != null) {
            T buf;
            buf = mas[i];
            mas[j] = mas[i];
            mas[j] = buf;
            return true;
        }
        else
            return false;
    }

}
