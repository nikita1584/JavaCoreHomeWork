package homework9;

/**
 * 1 Напишите метод, на вход которого подаётся двумерный строковый массив размером 4х4. При
 * подаче массива другого размера необходимо бросить исключение MyArraySizeException.
 * 2 Далее метод должен пройтись по всем элементам массива, преобразовать в int и
 * просуммировать. Если в каком-то элементе массива преобразование не удалось (например, в
 * ячейке лежит символ или текст вместо числа), должно быть брошено исключение
 * MyArrayDataException с детализацией, в какой именно ячейке лежат неверные данные.
 * 3 В методе main() вызвать полученный метод, обработать возможные исключения
 * MyArraySizeException и MyArrayDataException и вывести результат расчета.
 * */

public class Main {
    public static void main(String[] args) {
        String [][] strArrayOk = {{"1","2","3","4"},
                                {"3","2","478","123"},
                                {"1","3","3","23"},
                                {"0","434","3","4"}};

        String [][] strArrayData = {{"1","2","3","4"},
                {"3","2","bad","123"},
                {"1","3","3","23"},
                {"0","434","3","4"}};

        String [][] strArrayLen = {{"1","2","3","4"},
                {"3","2","bad","123"},
                {"1","3","3","23"},
                {"1","3","3","23"},
                {"0","434","3","4"}};

        try {
            System.out.println("Сумма элементов массива равна " + sumArray(strArrayOk));
        }
        catch (MyArraySizeException e) {
            System.out.println(e.getMessage());
        }
        catch (MyArrayDataException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("=============");

        try {
            System.out.println("Сумма элементов массива равна " + sumArray(strArrayData));
        }
        catch (MyArraySizeException e) {
            System.out.println(e.getMessage());
        }
        catch (MyArrayDataException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("=============");

        try {
            System.out.println("Сумма элементов массива равна " + sumArray(strArrayLen));
        }
        catch (MyArraySizeException e) {
            System.out.println(e.getMessage());
        }
        catch (MyArrayDataException e) {
            System.out.println(e.getMessage());
        }

    }
    public static int sumArray(String[][] mas) throws MyArraySizeException, MyArrayDataException {
        int sum = 0;
        if(mas.length != 4 || mas[0].length != 4)
            throw new MyArraySizeException("Размерность массива " + mas.length + "x" + mas[0].length +
                    " вместо обязательного размера 4х4");

        for(int i = 0; i < mas.length; i++)
        {
            for(int j = 0; j < mas[i].length; j++)
            {
                try {
                    sum += Integer.parseInt(mas[i][j]);
                }
                catch (NumberFormatException e) {
                    throw new MyArrayDataException("Ошибка преобразования элемента " + mas[i][j] + " в строке [" +
                            Integer.toString(i + 1) + "] столбце [" +
                            Integer.toString(j + 1) + "]"  + " в число");
                }
            }
        }
        return sum;
    }
}
