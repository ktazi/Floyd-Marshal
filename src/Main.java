import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Date d = new Date();
        File trace = new File("traces/traces_"+d.toString()+".txt");
        if (trace.createNewFile()){
            Menu.menu(trace);
        }
        else {
            System.out.println("Error : trace file cannot be created (there must be a trace folder at root of project)");
        }
    }

}
