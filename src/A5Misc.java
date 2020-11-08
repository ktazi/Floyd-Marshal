import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;

public class A5Misc {
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
            A5Misc.print(bw," ");
        A5Misc.print(bw,"  ");
        for (int i = 0; i < m.size();i++){
            if (Integer.toString(i).length() < max)
            {
                for (int j = 0; j < max - Integer.toString(i).length(); j++)
                    A5Misc.print(bw," ");
            }
            A5Misc.print(bw,Integer.toString(i));
            A5Misc.print(bw," ");
        }
        A5Misc.println(bw,"");
        for (int j = 0; j < max; j++)
            A5Misc.print(bw," ");
        A5Misc.print(bw,"  ");
        for (int i = 0; i < m.size();i++){
                for (int j = 0; j <= max; j++)
                    A5Misc.print(bw,"_");
        }
        A5Misc.println(bw, "");
        int it = 0;
        for (ArrayList<Integer> tab : m){
            //display of the name of the row
            A5Misc.print(bw, Integer.toString(it));
            if (Integer.toString(it).length() < max)
            {
                for (int j = 0; j < max - Integer.toString(it).length(); j++)
                    A5Misc.print(bw," ");
            }
            A5Misc.print(bw," ");
            A5Misc.print(bw,"|");
            it++;
            for (Integer i : tab){
                if (i.toString().length() < max)
                {
                    for (int j = 0; j < max - i.toString().length(); j++)
                        A5Misc.print(bw," ");
                }
                A5Misc.print(bw, Integer.toString(i));
                A5Misc.print(bw," " );
            }
            A5Misc.println(bw,"");
        }
    }
    /**
     * A function that prints on the terminal a matrix containing numbers
     * @param m the matrix
     */
    public static void print_matrix_valeur(ArrayList<ArrayList<A5Numbers>> m, BufferedWriter bw) throws IOException {
        int max = 0;
        for (ArrayList<A5Numbers> tab : m) {
            for (A5Numbers i : tab) {
                max = Math.max(max, i.toString().length());
            }
        }
        max = Math.max(max, Integer.toString(m.size()).length());
        //display of the name of the columns
        for (int j = 0; j < max; j++)
            A5Misc.print(bw," ");
        A5Misc.print(bw,"  ");
        for (int i = 0; i < m.size(); i++) {
            if (Integer.toString(i).length() < max) {
                for (int j = 0; j < max - Integer.toString(i).length(); j++)
                    A5Misc.print(bw," ");
            }
            A5Misc.print(bw, Integer.toString(i));
            A5Misc.print(bw," ");
        }
        A5Misc.println(bw,"");
        for (int j = 0; j < max; j++)
            A5Misc.print(bw," ");
        A5Misc.print(bw," ");
        for (int i = 0; i < m.size(); i++) {
            for (int j = 0; j <= max; j++)
                A5Misc.print(bw, "_");
        }
        A5Misc.println(bw,"");
        int it = 0;
        for (ArrayList<A5Numbers> tab : m) {
            //display of the name of the row
            A5Misc.print(bw,Integer.toString(it));
            if (Integer.toString(it).length() < max) {
                for (int j = 0; j < max - Integer.toString(it).length(); j++)
                    A5Misc.print(bw," ");
            }
            A5Misc.print(bw," ");
            A5Misc.print(bw,"|");

            it++;
            for (A5Numbers i : tab) {
                if (i.toString().length() < max) {
                    for (int j = 0; j < max - i.toString().length(); j++)
                        A5Misc.print(bw," ");
                }
                A5Misc.print(bw,i.toString());
                A5Misc.print(bw," ");
            }
            A5Misc.println(bw,"");
        }
    }

    /**
     * A function that computes the smallest path between 2 vertices given the result matrix from Floyd-Warshall
     * @param ch the "matrice des intermediaires"
     * @param n the matrix of distance
     * @param dep the first vertex
     * @param arr the last vertex
     */
    public static void cheminPlusCourt(ArrayList<ArrayList<Integer>> ch, ArrayList<ArrayList<A5Numbers>> n, int dep, int arr, BufferedWriter bw) throws IOException {
        if (n.get(dep).get(arr).isInfinite())
            A5Misc.println(bw,"ce n'est pas possible d'aller de "+ dep + " a " + arr);
        else {
            A5Misc.print(bw,"Le chemin le plus cours pour aller de "+ dep + " a " + arr+ " est : ");
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
                    A5Misc.print(bw,d + " ");
                }
            A5Misc.println(bw,"");
            }
        }
}
