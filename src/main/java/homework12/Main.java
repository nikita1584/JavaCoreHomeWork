package homework12;

/**
 * Необходимо написать два метода, которые делают следующее:
 * 1) Создают одномерный длинный массив, например:
 * static final int SIZE = 10 000 000;
 * static final int HALF = size / 2;
 * float[] arr = new float[size].
 * 2) Заполняют этот массив единицами.
 * 3) Засекают время выполнения: long a = System.currentTimeMillis().
 * 4) Проходят по всему массиву и для каждой ячейки считают новое значение по формуле:
 * arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) *
 * Math.cos(0.4f + i / 2));
 * 5) Проверяется время окончания метода System.currentTimeMillis().
 * 6) В консоль выводится время работы: System.out.println(System.currentTimeMillis() - a).
 * Отличие первого метода от второго:
 * ● Первый просто бежит по массиву и вычисляет значения.
 * ● Второй разбивает массив на два массива, в двух потоках высчитывает новые значения и
 * потом склеивает эти массивы обратно в один.
 * Пример деления одного массива на два:
 * ● System.arraycopy(arr, 0, a1, 0, h);
 * ● System.arraycopy(arr, h, a2, 0, h).
 * Пример обратной склейки:
 * ● System.arraycopy(a1, 0, arr, 0, h);
 * ● System.arraycopy(a2, 0, arr, h, h).
 *
 * currentTimeMillis()
 * a -> [a1, a2]
 * t1 -> a1, t2 -> a2
 * [a1, a2] -> a
 * currentTimeMillis()
 **/

public class Main {
    static final int SIZE = 10_000_000;
    static final int HALF = SIZE / 2;

    public static void main(String[] args) {
        float[] arr = new float[SIZE];
        for (float f: arr)
            f = 1;

        long start_time = System.currentTimeMillis();

        for (int i = 0; i < arr.length; i++)
            arr[i] = calculate(i);
            //arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));

        System.out.println("Время заполнения массива певым способом равно " + (long)(System.currentTimeMillis() -
                start_time) + " мс.");

        for (float f: arr)
            f = 1;
        float[] a1 = new float[HALF];
        float[] a2 = new float[HALF];

        start_time = System.currentTimeMillis();
        System.arraycopy(arr, 0, a1, 0, HALF);
        System.arraycopy(arr, HALF, a2, 0, HALF);

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < HALF; i++) {
                    a1[i] = calculate(i);
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < HALF; i++) {
                    a2[i] = calculate(i);
                }
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.arraycopy(a1, 0, arr, 0, HALF);
        System.arraycopy(a2, 0, arr, HALF, HALF);

        System.out.println("Время заполнения массива вторым способом равно " + (long)(System.currentTimeMillis() -
                start_time) + " мс.");
    }
    public static float calculate(int i) {
        return (float) (Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
    }
}
