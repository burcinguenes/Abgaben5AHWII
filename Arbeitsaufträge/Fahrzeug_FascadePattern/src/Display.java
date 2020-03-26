public class Display implements IKomponenten {

    private String displaytext;
    private String textfarbe;

    public Display(){
        this.displaytext = "Alles süper.";
        this.textfarbe = "SCHWARZ";
    }
    public void reset(){
        setDisplaytext("Alles süper.");
        setTextfarbe("SCHWARZ");
        System.out.println(displaytext);
    }
    public void warn(){
        setTextfarbe("ROT");
        setDisplaytext("HOPPLA, fahr mal langsamer abi!! ._.");
        System.out.println(displaytext);
    }

    public String getDisplaytext() {
        return displaytext;
    }

    public void setDisplaytext(String displaytext) {
        this.displaytext = displaytext;
    }

    public String getTextfarbe() {
        return textfarbe;
    }

    public void setTextfarbe(String textfarbe) {
        this.textfarbe = textfarbe;
    }
}
