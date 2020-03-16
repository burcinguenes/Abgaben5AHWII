//Pizza in den Ofen
public class StateC implements IStates {

    @Override
    public void goNext(Context c) {

        c.setState(this);

        try {
            System.out.println("Pizza in den Ofen");
            c.isValid(true);
            c.setState(new StateD());


        }catch (Exception e){ c.isValid(false); }

    }
}
