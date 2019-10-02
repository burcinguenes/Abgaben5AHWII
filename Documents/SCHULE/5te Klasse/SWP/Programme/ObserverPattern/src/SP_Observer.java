public class SP_Observer implements IObserver {

    private String name;
    private int interestValue;

    public SP_Observer(String name, int interestVal){

        setName(name);
        setInterestValue(interestVal);
    }

    public void update(int val) {
        System.out.println("\nHey "+this.name+" Observable has updated its value: "+val);

    }

    public int getInterestValue()
    {
        return interestValue;
    }

    public void setInterestValue(int interestVal)
    {
        interestValue = interestVal;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return this.name;
    }

}
