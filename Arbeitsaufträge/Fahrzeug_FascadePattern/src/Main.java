enum Pedal {
    LOW,
    MEDIUM,
    HIGH
}

public class Main {
    public static void main(String[] args) {
    Fahrzeug auto = new Fahrzeug();
    auto.pedal(Pedal.LOW);
    auto.pedal(Pedal.HIGH);
}
}
