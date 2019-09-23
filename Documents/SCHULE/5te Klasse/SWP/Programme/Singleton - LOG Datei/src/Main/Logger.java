package Main;


import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;

import java.sql.Timestamp;



public class Logger {

    public static Logger instance;
    private Main.LogLevel LogLevel;

    PrintWriter writer;
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");


    private Logger() throws java.io.IOException
    {
        writer = new PrintWriter(new FileWriter("the-file-name.txt",true));

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
        this.LogLevel = x;
    }



    public boolean log(String text){

        writer.println("LOG "+text);
        writer.flush();
        return true;
   }
    public boolean debug(String text){

        Timestamp timestamp = new Timestamp(System.currentTimeMillis());

        if(LogLevel.ordinal()>1) {
            return false;
        }

        System.out.println(sdf.format(timestamp));
        writer.println("DEBUG "+text);
        writer.flush();

        return true;
    }
    public boolean info(String text){

        if(LogLevel.ordinal()< 1) {
            return false;
        }

        writer.println("INFO "+text);
        writer.flush();

        return true;
    }



    public boolean warning(String text){

        if(LogLevel.ordinal()< 2) {
            return false;
        }
        writer.println("WARNING "+text);
        writer.flush();

        return true;
    }

    public boolean error(String text){

        if(LogLevel.ordinal()< 3) {
            return false;
        }
        writer.println("ERROR "+text);
        writer.flush();

        return true;
    }



    @Override
    public void finalize()
    {
        writer.close();
    }



}
