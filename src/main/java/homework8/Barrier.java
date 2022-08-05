package homework8;

public class Barrier {
    int size;

    public Barrier(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public void jump(AbleToJump j) {
        j.jumpingAction(this.size);
    }
}
