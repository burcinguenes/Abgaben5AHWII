package Receiver;

public class Rolläden {

    private boolean runter;

    public Rolläden(){
        this.runter = false;
    }

    public void runter(){
        runter = true;
        System.out.println("Rolläden runter!");

    }

    public void hoch(){
        runter = false;
        System.out.println("Rolläden hoch!");

    }
}
