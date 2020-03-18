/** Einmal drücken -> execute() wird ausgeführt
 * Zweimal drücken -> unexecute() wird ausgeführt
 *
 * Außnahme Kaffemaschine, automatisch
 */
public class User {

    public static void main(String[] args){

        SmartHomeApp app = new SmartHomeApp();

        app.clickKM();
        app.clickL(); app.clickL();
        app.clickMA(); app.clickMA();
        app.clickR(); app.clickR();

    }

}
