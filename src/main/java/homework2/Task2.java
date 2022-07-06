package homework2;

import java.util.Random;

public class Task2 {
    public static void main(String[] args) {
        Random random = new Random();
        isNumberFrom10To20(random.nextInt(0,20), random.nextInt(0, 20));
        printNumberSign(random.nextInt(-100, 101));
        isNumberNegative(random.nextInt(-100, 101));
        printStringNTimes("Code is working!", random.nextInt(1, 11));
        isLeapYear(random.nextInt(0, 1601));
    }

    static boolean isNumberFrom10To20(int a, int b){
        return (a + b >= 10) && (a + b <= 20);
    }

    static void printNumberSign(int n){
        if(n < 0)
            System.out.println("Число отрицательное");
        else
            System.out.println("Число положительное");
    }

    static boolean isNumberNegative(int n){
        if(n < 0)
            return true;
        else
            return false;
    }

    static void printStringNTimes(String s, int n){
        for (int i = 0; i < n; i++)
            System.out.println(s);
    }

    static boolean isLeapYear(int n){
        if(n % 400 == 0)
            return true;
        else if(n % 100 == 0)
            return false;
        else if(n % 4 == 0)
            return true;
        else
            return false;
    }
}
