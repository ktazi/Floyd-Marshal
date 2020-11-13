import java.io.File;
import java.io.IOException;
import java.util.Date;

public class L3_A5_Main {
    public static void main(String[] args) throws IOException {
        Date d = new Date();
        File trace = new File("L3-A5-traces_"+d.toString()+".txt");
        if (trace.createNewFile()){
            L3_A5_Menu.menu(trace);
        }
        else {
            System.out.println("Error : trace file cannot be created (there must be a trace folder at root of project)");
        }
    }

}
