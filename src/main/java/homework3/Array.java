package homework3;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class Array {
    private static final int ARRAY_SIZE = 10;

    public static void main(String[] args) {
        Task1();
        Task2();
        Task3();
        Task4();
        Task5(12, 7);
        Task6();
        if(Task7()) // checkBalance
            System.out.println("Array is balanced");
        else
            System.out.println("Array is not balanced");
        int []intArr = new int[] {3, 5, 6, 1};
        Task8(intArr, -2);
    }

    private static void Task8(int []intArr, int n){
        System.out.println("=== Task 8 ===");
        int shiftValue = n % intArr.length;
        int intTmp, newIndex;
        System.out.println(Arrays.toString(intArr));

        if(shiftValue == 0){
            System.out.println(Arrays.toString(intArr));
            return;
        } else if (n > 0) {
            n = intArr.length - n;
        } else if (n < 0) {
            n = -n;
        }

        //bad deci
        for (int k = 0; k < n; k++) {
            newIndex = 1;
            for (int i = 0; newIndex < intArr.length; i++, newIndex++) {
                intTmp = intArr[i];
                intArr[i] = intArr[newIndex];
                intArr[newIndex] = intTmp;
            }
        }
        System.out.println(Arrays.toString(intArr));
    }
    private static boolean Task7() {
        System.out.println("=== Task 6, checkBalance ===");
        int []intArr = new int[] {2, 2, 2, 1, 2, 2, 10, 1};
        int bound = 1, lSum, rSum;
        for (; bound < intArr.length; bound++){
            lSum = 0;
            rSum = 0;
            for(int l = 0; l < bound; l++)
                lSum += intArr[l];
            for(int r = bound; r < intArr.length; r++)
                rSum += intArr[r];
            if(lSum == rSum)
                return true;
        }
        return false;
    }

    private static void Task6() {
        System.out.println("=== Task 6 ===");
        int []intArr = new int[ARRAY_SIZE];
        int minIndex = 0, maxIndex = 0;
        for (int i = 0; i < intArr.length; i++)
            intArr[i] = ThreadLocalRandom.current().nextInt(21);
        System.out.println(Arrays.toString(intArr));

        for (int i = 0; i < intArr.length; i++) {
            if(intArr[i] < intArr[minIndex])
                minIndex = i;
            if(intArr[i] > intArr[maxIndex])
                maxIndex = i;
        }
        System.out.println("Minimal element in array is " + intArr[minIndex] +
                ", Maximum element in array is " + intArr[maxIndex]);
    }

    private static int[] Task5(int len, int initValue) {
        System.out.println("=== Task 5 ===");
        int []intArray = new int[len];
        for (int i = 0; i < intArray.length; i++)
            intArray[i] = initValue;
        return intArray;
    }

    private static void Task4() {
        System.out.println("=== Task 4 ===");
        int [][]intMatrix = new int[ARRAY_SIZE][ARRAY_SIZE];
        String result;
        for (int i = 0; i < ARRAY_SIZE; i++) {
            for (int j = 0; j < ARRAY_SIZE; j++) {
                if ((i == j) || (i == ARRAY_SIZE - 1 - j))
                    intMatrix[i][j] = 1;
                System.out.print(intMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void Task3() {
        System.out.println("=== Task 3 ===");
        int []intArr = new int[] { 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 };
        System.out.println(Arrays.toString(intArr));
        for (int i = 0; i < intArr.length; i++)
            intArr[i] = intArr[i] < 6 ? intArr[i] * 2 : intArr[i];
        System.out.println(Arrays.toString(intArr));
    }

    private static void Task2() {
        System.out.println("=== Task 2 ===");
        int []intArr = new int[100];
        for (int i = 0; i < intArr.length; i++)
            intArr[i] = i + 1;
    }

    static void Task1() {
        System.out.println("=== Task 1 ===");
        int []intArr = new int[ARRAY_SIZE];
        for (int i = 0; i < intArr.length; i++)
            intArr[i] = ThreadLocalRandom.current().nextInt(2);
        System.out.println(Arrays.toString(intArr));

        for (int i = 0; i < intArr.length; i++)
            intArr[i] = (intArr[i] == 1)? 0 : 1;
        System.out.println(Arrays.toString(intArr));
    }

}
