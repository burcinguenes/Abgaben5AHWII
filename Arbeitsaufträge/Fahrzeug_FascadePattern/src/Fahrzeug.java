public class Fahrzeug {

    private IKomponenten soundanlage;
    private IKomponenten display;
    private Pedal pedalstellung;


    public Fahrzeug(){

        this.soundanlage = new Soundanlage();
        this.display = new Display();

    }

    public void pedal(Pedal p){
        switch(p) {
            case LOW:
                setPedalstellung(p);
                soundanlage.reset();
                display.reset();
                System.out.println("Pedal: Low level");
                break;

            case MEDIUM:
                setPedalstellung(p);
                soundanlage.reset();
                display.reset();
                System.out.println("Pedal: Medium level");
                break;

            case HIGH:
                setPedalstellung(p);
                System.out.println("Pedal: High level");
                soundanlage.warn();
                display.warn();
                break;
        }
    }

    public void getPedalstellung(){
        System.out.println(this.pedalstellung);
    }

    public void setPedalstellung(Pedal p){
        this.pedalstellung = p;
    }
}
