//Pizzateig und Tomatensoße herstellen
public class StateA implements IStates {

    @Override
    public void goNext(Context c) {

        c.setState(this);
        try {
            System.out.println("Pizzateig und Tomatensoße herstellen");
            c.isValid(true);
            c.setState(new StateB());

        }catch (Exception e){ c.isValid(false); }

    }
}
