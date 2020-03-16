public class Context {

    private IStates state;
    private boolean validation;

    public Integer count;

    public Context(){
        this.state = new StateA();
        validation=true;
        count=1;

    }

    public void setState(IStates s){

        if(validation==true){
            this.state = s;
        }else{
            System.out.println("Step is not valid.");
        }
    }

    public void advance(){
        state.goNext(this);
    }

    public boolean isValid(boolean v){

        this.validation = v;
        return this.validation;
    }
}
