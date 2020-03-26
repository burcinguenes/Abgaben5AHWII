public class Soundanlage implements IKomponenten{

    private int lautstärke; // zwischen 0-100; standardmäßig auf 30

    public Soundanlage(){
        this.lautstärke = 30;
    }
    public void reset(){
        setLautstärke(30);
        System.out.println("~ Radio ~");

    }

    public void warn(){
        setLautstärke(100);
        System.out.println("PIIIIEEEEEEEEP");
    }

    public int getLautstärke() {
        return lautstärke;
    }

    public void setLautstärke(int lautstärke) {
        this.lautstärke = lautstärke;
    }

}
