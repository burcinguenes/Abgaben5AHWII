
public class Main {

    public static void main(String[] args){
        SP_Observer observer = new SP_Observer("Burcin", 12);
        Observable observable = new Observable(11);

        observable.subscribe(observer);
        observable.setValue(15);

        //observable.unsubscribe(observer);
        observable.setValue(12);
    }
}
