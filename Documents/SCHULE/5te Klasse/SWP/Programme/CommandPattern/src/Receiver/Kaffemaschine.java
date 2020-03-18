package Receiver;

/**
 * Diese Klasse dient als Receiver für alle Commands, die zur Ansteuerung der Kaffem. dienen.
 * Sie beinhaltet die Funktionen der Receiver.Kaffemaschine, die vom Command ausgeführt werden.
 */
public class Kaffemaschine {

    private boolean ein;

    public Kaffemaschine(){
        ein = false;
    }

    /**action-Methode */
    public void ein(){

        for (int i=1;i<6;i++){
            System.out.print(i+" ... ");
            this.ein = true;
        }

        this.ein = false;
        System.out.println("  Kaffe fertig!");

    }
}
