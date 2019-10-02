import java.util.ArrayList;

public class Observable {

    private  ArrayList <IObserver> observers;
    private int value;

    public Observable(int val){

        this.value = val;
        observers = new ArrayList<IObserver>();
    }

    private void notifyAllObservers()
    {
        if(observers.size()>0){
            for (int i=0;i<=observers.size()-1; i++)
            {
                if(observers.get(i).getInterestValue()<=this.value){
                    observers.get(i).update(this.value);
                }


            }
        }
    }

    public void setValue(int val)
    {
        this.value = val;
        notifyAllObservers();
    }

    public void subscribe(IObserver obs){
        this.observers.add(obs);
    }

    public void unsubscribe(IObserver obs){
        observers.remove(obs);
    }

}
