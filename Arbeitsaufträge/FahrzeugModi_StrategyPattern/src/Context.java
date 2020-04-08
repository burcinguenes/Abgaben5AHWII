public class Context {

    private Modi sportmodus;
    private Modi standardmodus;

    private float geschwindigkeit;
    private int kW;
    private boolean isTurbo;


    public Context(){
        sportmodus = new Sportmodus();
        standardmodus = new Standardmodus();
    }

    private void executeSportmodus(){
        sportmodus.gangwechsel();
    }
    private void executeStandardmodus(){
        standardmodus.gangwechsel();
    }


    public void setGeschwindigkeit(float g){
        this.geschwindigkeit = g;

        if(this.geschwindigkeit>=120){
            System.out.println("Höherer Geschwindigkeitsbereich erreicht");
            executeSportmodus();
        }else{
            System.out.println("Unterer Geschwindigkeitsbereich erreicht");
            executeStandardmodus();
        }
    }
    public void setKW(int kw){
        this.kW = kw;

        if(this.kW>=50){
            System.out.println("Höherer Leistungsbereich erreicht");
            executeSportmodus();
        }else{
            System.out.println("Unterer Leistungsbereich erreicht");
            executeStandardmodus();
        }
    }

    public void setTurbo(boolean t){
        this.isTurbo = t;
        if(this.isTurbo){
            System.out.println("Turbogeladen");
            executeSportmodus();
        }else{
            System.out.println("Nicht Turbogeladen");
            executeStandardmodus();
        }
    }


}
