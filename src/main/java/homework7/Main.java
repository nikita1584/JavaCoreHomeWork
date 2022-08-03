package homework7;

/**
 * Домашнее задание
 * 1. Расширить задачу про котов и тарелки с едой.
 * 2. Сделать так, чтобы в тарелке с едой не могло получиться отрицательного количества еды
 * (например, в миске 10 еды, а кот пытается покушать 15-20).
 * 3. Каждому коту нужно добавить поле сытость (когда создаем котов, они голодны). Если коту
 * удалось покушать (хватило еды), сытость = true.
 * 4. Считаем, что если коту мало еды в тарелке, то он её просто не трогает, то есть не может быть
 * наполовину сыт (это сделано для упрощения логики программы).
 * 5. Создать массив котов и тарелку с едой, попросить всех котов покушать из этой тарелки и
 * потом вывести информацию о сытости котов в консоль.
 * 6. Добавить в тарелку метод, с помощью которого можно было бы добавлять еду в тарелку
 */


public class Main {

    public static void printFullCats(Cat[] array) {
        for (int i = 0; i < array.length; i++)
            System.out.println("Кот по имени " + array[i].getName() + (array[i].getIsFull()? " сыт":
                    " ещё не наелся"));
    }

    public static void feedCats(Cat[] array, Plate plate, int count){
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < count; j++) { // по 2 раза подходили к миске каждый
                array[i].eat(plate);
            }
        }
    }

    public static void main(String[] args) {
        Plate plate = new Plate(200);
        plate.printInfo();

        Cat []catArray = new Cat[5];
        catArray[0] = new Cat("Мурзик", 25, 76);
        catArray[1] = new Cat("gav", 7, 24);
        catArray[2] = new Cat("Барсик", 31, 60);
        catArray[3] = new Cat("Мусик", 15, 30);
        catArray[4] = new Cat("Тефтелька", 41, 79);

        feedCats(catArray, plate, 2);
        printFullCats(catArray);
        plate.printInfo();

        System.out.println("\n==== Положили 150 единиц еды ====\n");
        plate.addFood(150);

        feedCats(catArray, plate, 3);
        printFullCats(catArray);
        plate.printInfo();

    }
}
