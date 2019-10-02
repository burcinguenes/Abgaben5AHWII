public interface IObserver {

    int interestValue=0;
    String name = "";

    public void update(int value);
    public int getInterestValue();

    //public void setInterestValue(int interestVal);

}
