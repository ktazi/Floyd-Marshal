import java.io.File;
import java.io.IOException;
import java.util.Date;

public class A5Main {
    public static void main(String[] args) throws IOException {
        Date d = new Date();
        File trace = new File("traces/A5traces_"+d.toString()+".txt");
        if (trace.createNewFile()){
            A5Menu.menu(trace);
        }
        else {
            System.out.println("Error : trace file cannot be created (there must be a trace folder at root of project)");
        }
    }

}
