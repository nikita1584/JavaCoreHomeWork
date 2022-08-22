package homework14;

public class IntArray {
    public static int[] ArrayAfterLast4(int[] arr){
        int size = 0;
        for (int i = arr.length - 1; i >= 0; i--, size++) {
            if(arr[i] == 4){

                break;
            }
        }
        System.out.println(size);
        if(size == 0 || size == arr.length) {
            throw new RuntimeException("Не найдено ни одной четвёрки");
            //return null;
        }
        int []result = new int[size];
        for (int i = 0; i < result.length; i++) {
            result[i] = arr[arr.length - size];
            size--;
        }
        return result;
    }

    public static boolean ArrayOf4and1(int []arr) {
        boolean was4 = false;
        boolean was1 = false;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1)
                was1 = true;
            else if (arr[i] == 4)
                was4 = true;
            else
                return false;
        }
        return was1 && was4;
    }
}
