import java.util.ArrayList;

public class Misc {

    public static boolean isInteger(String s){
        try
        {
            int i = Integer.parseInt(s);
            return true;
        }
        catch (NumberFormatException e)
        {
            return false;
        }
    }

    public static void print_matrix(ArrayList<ArrayList<Numbers>> m){
        for(ArrayList<Numbers> a : m)
        {
            for(Numbers n : a){
                n.print();
                System.out.print(" ");
            }
            System.out.println("");
        }
    }


}
