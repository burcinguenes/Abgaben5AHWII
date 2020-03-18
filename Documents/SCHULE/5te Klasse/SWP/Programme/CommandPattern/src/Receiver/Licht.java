package Receiver;

public class Licht {

    private boolean ein;

    public Licht(){
        this.ein = false;
    }

    public void an(){
        ein = true;
        System.out.println("Licht an!");

    }

    public void aus(){
        ein = false;
        System.out.println("Licht aus!");
    }

}
