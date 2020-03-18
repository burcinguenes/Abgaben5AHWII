import Commands.*;

/** Diese Klasse ist der Invoker.
 * Er beinhaltet den Zugriff auf die Steuerungen für Receiver.Kaffemaschine, Licht, Musikanlage und Rolläden.
 *
 * https://www.youtube.com/watch?v=9qA5kw8dcSU
 */
public class SmartHomeApp {

    private ICommand kaffeemaschine;
    private ICommand licht;
    private ICommand musikanlage;
    private ICommand roll;

    private boolean clickKM, clickL, clickMA, clickR;





    public SmartHomeApp(){

        this.kaffeemaschine = new Command_KM();
        this.licht = new Command_L();
        this.musikanlage = new Command_MA();
        this.roll = new Command_R();

        clickKM = false;
        clickL = false;
        clickMA = false;
        clickR = false;
    }


    public void clickKM(){
        kaffeemaschine.execute();
    }

    public void clickL(){
        clickL = !clickL;
        if(clickL){ licht.execute();}
        else{ licht.unexecute();}
    }

    public void clickMA(){
        clickMA = !clickMA;
        if(clickMA){ musikanlage.execute();}
        else{ musikanlage.unexecute();}
    }

    public void clickR(){
        clickR = !clickR;
        if(clickR){ roll.execute();}
        else{ roll.unexecute();}
    }

}
