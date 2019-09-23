package Main;
import java.io.*;
import java.util.Date;

public class Main {

    public enum LogLevel
    {
        DEBUG,
        INFO,
        WARNING,
        ERROR
    }

    public static void main(String[] args) throws IOException
    {

        PrintWriter writer;
        Date date = new Date();

        /*try
        {
            writer = new PrintWriter(new FileWriter("the-file-name.txt",true));
            writer.println("The first line");
            writer.println("The second line");
            writer.flush();
            writer.close();

        } catch (FileNotFoundException | UnsupportedEncodingException e)
        {
            e.printStackTrace();
        }*/

        //old
        Logger.getInstance().log("program initialized");
        Logger.getInstance().log("Person created");

        //improved
        Logger.getInstance().setLogLevel(LogLevel.INFO);
        Logger.getInstance().info("program initialized");
        Logger.getInstance().debug("Person created");
        Logger.getInstance().warning("Person created");
        Logger.getInstance().error("Person created");


    }

}
