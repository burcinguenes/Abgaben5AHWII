package Commands;

import Receiver.Licht;

public class Command_L implements ICommand {

    private Licht licht;

    public Command_L(){
        this.licht = new Licht();
    }
    @Override
    public void execute() {
        this.licht.an();
    }

    @Override
    public void unexecute() {
        this.licht.aus();

    }
}
