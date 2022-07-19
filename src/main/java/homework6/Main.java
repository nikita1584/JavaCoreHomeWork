package homework6;

import homework5.Employee;

public class Main {
    public static void main(String[] args) {
        Cat[]catArray = new Cat[3];
        Dog[]dogArray = new Dog[2];
        catArray[0] = new Cat("Барсик");
        catArray[1] = new Cat("Мусик");
        catArray[2] = new Cat("Тефтелька");
        dogArray[0] = new Dog("Бобик");
        dogArray[1] = new Dog("Шарик");

        System.out.println(catArray[0].doRunning(159));
        System.out.println(catArray[1].doRunning(100));
        System.out.println(catArray[2].doRunning(212));
        System.out.println(catArray[0].doSwimming(2));

        System.out.println(dogArray[0].doRunning(123));
        System.out.println(dogArray[1].doRunning(501));
        System.out.println(dogArray[0].doSwimming(56));
        System.out.println(dogArray[1].doSwimming(8));

        System.out.println("Всего животных: " + Animal.getAnimalCount() + ", кошек: " + Cat.getCatCount()
            + " собак: " + Dog.getDogCount());
    }
}
