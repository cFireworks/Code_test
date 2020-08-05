package task;

public class Goods {
    private int count;
    public Goods(){
        count = 0;
    }

    void Increment(){
        count++;
    }
    void Decrement(){
        count--;
    }
    int getCount(){
        return count;
    }
}
