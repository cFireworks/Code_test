package task;

public class Consumer implements Runnable{
    Goods storage;
    public Consumer(Goods storage){
        this.storage = storage;
    }

    @Override
    public void run() {
        synchronized (storage){
            if(storage.getCount()>0)
                storage.Increment();
        }
    }
}
