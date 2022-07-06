public class HomeWorkApp {
    public static void main(String[] args) {
        printThreeWords();
        checkSumSign();
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
}
