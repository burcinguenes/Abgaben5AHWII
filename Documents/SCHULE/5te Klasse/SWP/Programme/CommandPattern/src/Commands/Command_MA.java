package Commands;

import Receiver.Musikanlage;

public class Command_MA implements ICommand {

    private Musikanlage musikanlage;

    public Command_MA(){
        this.musikanlage = new Musikanlage();

    }


    @Override
    public void execute() {
        musikanlage.an();
    }

    @Override
    public void unexecute() {
        musikanlage.aus();

    }
}
