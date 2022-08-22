package homework14;

import java.util.Arrays;

/**
 * 1) Написать метод, которому в качестве аргумента передается не пустой одномерный целочисленный массив.
 * Метод должен вернуть новый массив, который получен путем вытаскивания из исходного массива элементов,
 * идущих после последней четверки. Входной массив должен содержать хотя бы одну четверку, иначе в
 * методе необходимо выбросить RuntimeException. Написать набор тестов для этого метода
 * (по 3-4 варианта входных данных). Вх: [ 1 2 4 4 2 3 4 1 7 ] -> вых: [ 1 7 ].
 * 2) Написать метод, который проверяет состав массива из чисел 1 и 4. Если в нем нет хоть одной четверки или единицы,
 * то метод вернет false; Написать набор тестов для этого метода (по 3-4 варианта входных данных).
 * [ 1 1 1 4 4 1 4 4 ] -> true [ 1 1 1 1 1 1 ] -> false [ 4 4 4 4 ] -> false [ 1 4 4 1 1 4 3 ] -> false
 */

public class Main {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(IntArray.ArrayAfterLast4(new int[]{1, 2, 4, 4, 2, 3, 4, 1, 7})));
        System.out.println(IntArray.ArrayOf4and1(new int[]{1, 1, 1, 4, 4, 1, 4, 4 }));
        System.out.println(IntArray.ArrayOf4and1(new int[]{1, 1, 1, 1, 1, 1, 1, 1 }));
        System.out.println(IntArray.ArrayOf4and1(new int[]{4, 4, 4, 4, 4 }));
        System.out.println(IntArray.ArrayOf4and1(new int[]{1, 1, 1, 4, 4, 1, 4, 3 }));
    }
}
