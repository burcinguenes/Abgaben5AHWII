package Commands;

import Receiver.Rolläden;

public class Command_R implements ICommand {

    private Rolläden rolläden;

    public Command_R(){
        this.rolläden = new Rolläden();

    }

    @Override
    public void execute() {
        rolläden.runter();
    }

    @Override
    public void unexecute() {
        rolläden.hoch();
    }
}
