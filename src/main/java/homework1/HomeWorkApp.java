package homework1;

import java.util.Random;

public class HomeWorkApp {
    public static void main(String[] args) {
        printThreeWords();
        checkSumSign();
        printColor();
        compareNumbers();
    }

    static void printThreeWords(){
        System.out.println("Orange\nBanana\nApple");
    }

    static void checkSumSign(){
        int a = 256, b = -255;
        if(a + b >= 0)
            System.out.println("Сумма положительная");
        else
            System.out.println("Сумма отрицательная");
    }

    static void compareNumbers(){
        int a = 1024, b = 1024;
        if(a >= b)
            System.out.println("a >= b");
        else
            System.out.println("a < b");
    }

    static void printColor(){
        Random random = new Random();
        int value = random.nextInt(-200, 201);
        if (value <= 0)
            System.out.println("Красный");
        else if (value <= 100)
            System.out.println("Желтый");
        else
            System.out.println("Зелёный");
    }
}
