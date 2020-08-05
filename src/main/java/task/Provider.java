package task;

public class Provider implements Runnable{
    Goods storage;
    public Provider(Goods storage){
        this.storage = storage;
    }

    @Override
    public void run() {
        synchronized (storage){
            if(storage.getCount()<10)
                storage.Increment();
        }

    }
}
