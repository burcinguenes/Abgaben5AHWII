package Commands;

import Receiver.Kaffemaschine;

/** Die Ansteuerung für eine Receiver.Kaffemaschine könnte in mehrere Command unterteilt werden, die die verschiedenen Funktionen der
 * Receiver.Kaffemaschine bedienen, zB.: Cappucino, Espresso, Milchschäumer, ...;
 * Meine Receiver.Kaffemaschine hat in diesem Fall nur eine Funktionen: Einschalten für 5 s.
 *
 */
public class Command_KM implements ICommand {

    private Kaffemaschine km;

    public Command_KM(){
        km = new Kaffemaschine();
    }


    public void execute(){
        km.ein();
    }
    public void unexecute(){}
}
