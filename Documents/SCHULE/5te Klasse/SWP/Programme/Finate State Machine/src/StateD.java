//Pizza an den Kunden
public class StateD implements IStates {

    @Override
    public void goNext(Context c) {

        c.setState(this);

        try {
            System.out.println("Pizza an den Kunden");
            c.isValid(true);
            c.setState(new StateA());
            System.out.println(c.count+". PIZZA FERTIG"); c.count++;


        }catch (Exception e){ c.isValid(false); }

    }
}
