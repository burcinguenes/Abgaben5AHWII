package Receiver;

public class Musikanlage {
    private boolean ein;

    public Musikanlage(){
        this.ein = false;
    }

    public void an(){
        ein = true;
        System.out.println("Musikanlage an!");

    }

    public void aus(){
        ein = false;
        System.out.println("Musikanlage aus!");

    }

}
