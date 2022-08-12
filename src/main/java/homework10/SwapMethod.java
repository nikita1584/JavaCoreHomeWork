package homework10;

public class SwapMethod <T>{

    private T buf;

    public SwapMethod(T item) {
        this.buf = item;
    }

    public boolean Swap(int i, int j, T ... mas){
        if(i >= 0 && i < mas.length && j >= 0 && j < mas.length){
            buf = mas[i];
            mas[j] = mas[i];
            mas[j] = buf;
            return true;
        }
        else
            return false;
    }
}
