import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;

public class L3_A5_Misc {
    public static void println(BufferedWriter bw, String s) throws IOException {
        System.out.println(s);
        bw.write(s);
        bw.newLine();
    }
    public static void print(BufferedWriter bw, String s) throws IOException {
        System.out.print(s);
        bw.write(s);
    }

    /**
     * Function that returns whether a String is an Integer
     * @param s the string
     * @return whether s is an integer
     */
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

    /**
     * A function that prints on the terminal a matrix containing integers
     * @param m the matrix
     */
    public static void print_matrix_adja(ArrayList<ArrayList<Integer>> m, BufferedWriter bw) throws IOException {
        int max = 0;
        for (ArrayList<Integer> tab : m){
            for (Integer i : tab){
                max = Math.max(max, i.toString().length());
            }
        }
        max = Math.max(max, Integer.toString(m.size()).length());
        //display of the name of the columns
        for (int j = 0; j < max; j++)
            L3_A5_Misc.print(bw," ");
        L3_A5_Misc.print(bw,"  ");
        for (int i = 0; i < m.size();i++){
            if (Integer.toString(i).length() < max)
            {
                for (int j = 0; j < max - Integer.toString(i).length(); j++)
                    L3_A5_Misc.print(bw," ");
            }
            L3_A5_Misc.print(bw,Integer.toString(i));
            L3_A5_Misc.print(bw," ");
        }
        L3_A5_Misc.println(bw,"");
        for (int j = 0; j < max; j++)
            L3_A5_Misc.print(bw," ");
        L3_A5_Misc.print(bw,"  ");
        for (int i = 0; i < m.size();i++){
                for (int j = 0; j <= max; j++)
                    L3_A5_Misc.print(bw,"_");
        }
        L3_A5_Misc.println(bw, "");
        int it = 0;
        for (ArrayList<Integer> tab : m){
            //display of the name of the row
            L3_A5_Misc.print(bw, Integer.toString(it));
            if (Integer.toString(it).length() < max)
            {
                for (int j = 0; j < max - Integer.toString(it).length(); j++)
                    L3_A5_Misc.print(bw," ");
            }
            L3_A5_Misc.print(bw," ");
            L3_A5_Misc.print(bw,"|");
            it++;
            for (Integer i : tab){
                if (i.toString().length() < max)
                {
                    for (int j = 0; j < max - i.toString().length(); j++)
                        L3_A5_Misc.print(bw," ");
                }
                L3_A5_Misc.print(bw, Integer.toString(i));
                L3_A5_Misc.print(bw," " );
            }
            L3_A5_Misc.println(bw,"");
        }
    }
    /**
     * A function that prints on the terminal a matrix containing numbers
     * @param m the matrix
     */
    public static void print_matrix_valeur(ArrayList<ArrayList<L3_A5_Numbers>> m, BufferedWriter bw) throws IOException {
        int max = 0;
        for (ArrayList<L3_A5_Numbers> tab : m) {
            for (L3_A5_Numbers i : tab) {
                max = Math.max(max, i.toString().length());
            }
        }
        max = Math.max(max, Integer.toString(m.size()).length());
        //display of the name of the columns
        for (int j = 0; j < max; j++)
            L3_A5_Misc.print(bw," ");
        L3_A5_Misc.print(bw,"  ");
        for (int i = 0; i < m.size(); i++) {
            if (Integer.toString(i).length() < max) {
                for (int j = 0; j < max - Integer.toString(i).length(); j++)
                    L3_A5_Misc.print(bw," ");
            }
            L3_A5_Misc.print(bw, Integer.toString(i));
            L3_A5_Misc.print(bw," ");
        }
        L3_A5_Misc.println(bw,"");
        for (int j = 0; j < max; j++)
            L3_A5_Misc.print(bw," ");
        L3_A5_Misc.print(bw," ");
        for (int i = 0; i < m.size(); i++) {
            for (int j = 0; j <= max; j++)
                L3_A5_Misc.print(bw, "_");
        }
        L3_A5_Misc.println(bw,"");
        int it = 0;
        for (ArrayList<L3_A5_Numbers> tab : m) {
            //display of the name of the row
            L3_A5_Misc.print(bw,Integer.toString(it));
            if (Integer.toString(it).length() < max) {
                for (int j = 0; j < max - Integer.toString(it).length(); j++)
                    L3_A5_Misc.print(bw," ");
            }
            L3_A5_Misc.print(bw," ");
            L3_A5_Misc.print(bw,"|");

            it++;
            for (L3_A5_Numbers i : tab) {
                if (i.toString().length() < max) {
                    for (int j = 0; j < max - i.toString().length(); j++)
                        L3_A5_Misc.print(bw," ");
                }
                L3_A5_Misc.print(bw,i.toString());
                L3_A5_Misc.print(bw," ");
            }
            L3_A5_Misc.println(bw,"");
        }
    }

    /**
     * A function that computes the smallest path between 2 vertices given the result matrix from Floyd-Warshall
     * @param ch the "matrice des intermediaires"
     * @param n the matrix of distance
     * @param dep the first vertex
     * @param arr the last vertex
     */
    public static void cheminPlusCourt(ArrayList<ArrayList<Integer>> ch, ArrayList<ArrayList<L3_A5_Numbers>> n, int dep, int arr, BufferedWriter bw) throws IOException {
        if (n.get(dep).get(arr).isInfinite())
            L3_A5_Misc.println(bw,"ce n'est pas possible d'aller de "+ dep + " a " + arr);
        else {
            L3_A5_Misc.print(bw,"Le chemin le plus cours pour aller de "+ dep + " a " + arr+ " est : ");
                ArrayList<Integer> list = new ArrayList<>();
                list.add(dep);
                list.add(arr);
                int i = 0;
                while (i + 1 < list.size())
                {
                    if (ch.get(list.get(i)).get(list.get(i+1)) == -1)
                        i++;
                    else
                    {
                        list.add(i+1,ch.get(list.get(i)).get(list.get(i+1)));
                    }
                }
                for (Integer d : list){
                    L3_A5_Misc.print(bw,d + " ");
                }
            L3_A5_Misc.println(bw,"");
            }
        }
}
