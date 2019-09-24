package Main;


import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Logger {

    public static Logger instance;
    private Main.LogLevel level;
    private PrintWriter writer;


    private Logger() throws java.io.IOException
    {
        writer = new PrintWriter(new FileWriter("log.txt",true));

    }

    public static Logger getInstance() throws java.io.IOException
    {
        if(instance==null)
        {
            instance = new Logger();
        }
        return instance;
    }

    public void setLogLevel(Main.LogLevel x){   //?
        level = x;
    }



    public boolean log(String text)throws java.io.IOException{

        SimpleDateFormat a = new SimpleDateFormat("dd.mm.yyyy - HH:mm:ss ");
        Date currentTime = new Date();

        writer.println(a.format(currentTime)+"\t\t LOG \t\t"+text);
        writer.flush();
        return true;
   }

    public boolean debug(String text){

        if(level.ordinal()>1) {
            return false;
        }

        SimpleDateFormat a = new SimpleDateFormat("dd.mm.yyyy - HH:mm:ss ");
        Date currentTime = new Date();

        writer.println(a.format(currentTime)+"\t\t DEBUG \t\t"+text);
        writer.flush();
        return true;
    }

    public boolean info(String text){

        if(level.ordinal()< 1) {
            return false;
        }

        SimpleDateFormat a = new SimpleDateFormat("dd.mm.yyyy - HH:mm:ss ");
        Date currentTime = new Date();

        writer.println(a.format(currentTime)+"\t\t INFO \t\t"+text);
        writer.flush();
        return true;
    }



    public boolean warning(String text){

        if(level.ordinal()< 2) {
            return false;
        }

        SimpleDateFormat a = new SimpleDateFormat("dd.mm.yyyy - HH:mm:ss ");
        Date currentTime = new Date();

        writer.println(a.format(currentTime)+"\t\t WARNING \t\t"+text);
        writer.flush();
        return true;
    }

    public boolean error(String text){

        if(level.ordinal()< 3) {
            return false;
        }

        SimpleDateFormat a = new SimpleDateFormat("dd.mm.yyyy - HH:mm:ss ");
        Date currentTime = new Date();

        writer.println(a.format(currentTime)+"\t\t ERROR \t\t"+text);
        writer.flush();
        return true;
    }



    @Override
    public void finalize()
    {
        writer.close();
    }



}
