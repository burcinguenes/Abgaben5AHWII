//Pizza belegen
public class StateB implements IStates {

    @Override
    public void goNext(Context c) {

        c.setState(this);
        try {
            System.out.println("Pizza belegen");
            c.isValid(true);
            c.setState(new StateC());


        }catch (Exception e){ c.isValid(false); }

    }
}
