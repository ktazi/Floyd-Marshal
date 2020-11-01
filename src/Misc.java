import java.util.ArrayList;

public class Misc {
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
    public static void print_matrix_adja(ArrayList<ArrayList<Integer>> m){
        int max = 0;
        for (ArrayList<Integer> tab : m){
            for (Integer i : tab){
                max = Math.max(max, i.toString().length());
            }
        }
        max = Math.max(max, Integer.toString(m.size()).length());
        //display of the name of the columns
        for (int j = 0; j < max; j++)
            System.out.print(' ');
        System.out.print("  ");
        for (int i = 0; i < m.size();i++){
            if (Integer.toString(i).length() < max)
            {
                for (int j = 0; j < max - Integer.toString(i).length(); j++)
                    System.out.print(' ');
            }
            System.out.print(i);
            System.out.print(' ');
        }
        System.out.println("");
        for (int j = 0; j < max; j++)
            System.out.print(' ');
        System.out.print("  ");
        for (int i = 0; i < m.size();i++){
                for (int j = 0; j <= max; j++)
                    System.out.print('_');
        }
        System.out.println();
        int it = 0;
        for (ArrayList<Integer> tab : m){
            //display of the name of the row
            System.out.print(it);
            if (Integer.toString(it).length() < max)
            {
                for (int j = 0; j < max - Integer.toString(it).length(); j++)
                    System.out.print(' ');
            }
            System.out.print(' ');
            System.out.print('|');

            it++;
            for (Integer i : tab){
                if (i.toString().length() < max)
                {
                    for (int j = 0; j < max - i.toString().length(); j++)
                        System.out.print(' ');
                }
                System.out.print(i);
                System.out.print(' ');
            }
            System.out.println();
        }
    }
    /**
     * A function that prints on the terminal a matrix containing numbers
     * @param m the matrix
     */
    public static void print_matrix_valeur(ArrayList<ArrayList<Numbers>> m) {
        int max = 0;
        for (ArrayList<Numbers> tab : m) {
            for (Numbers i : tab) {
                max = Math.max(max, i.toString().length());
            }
        }
        max = Math.max(max, Integer.toString(m.size()).length());
        //display of the name of the columns
        for (int j = 0; j < max; j++)
            System.out.print(' ');
        System.out.print("  ");
        for (int i = 0; i < m.size(); i++) {
            if (Integer.toString(i).length() < max) {
                for (int j = 0; j < max - Integer.toString(i).length(); j++)
                    System.out.print(' ');
            }
            System.out.print(i);
            System.out.print(' ');
        }
        System.out.println("");
        for (int j = 0; j < max; j++)
            System.out.print(' ');
        System.out.print("  ");
        for (int i = 0; i < m.size(); i++) {
            for (int j = 0; j <= max; j++)
                System.out.print('_');
        }
        System.out.println();
        int it = 0;
        for (ArrayList<Numbers> tab : m) {
            //display of the name of the row
            System.out.print(it);
            if (Integer.toString(it).length() < max) {
                for (int j = 0; j < max - Integer.toString(it).length(); j++)
                    System.out.print(' ');
            }
            System.out.print(' ');
            System.out.print('|');

            it++;
            for (Numbers i : tab) {
                if (i.toString().length() < max) {
                    for (int j = 0; j < max - i.toString().length(); j++)
                        System.out.print(' ');
                }
                System.out.print(i);
                System.out.print(' ');
            }
            System.out.println("");
        }
    }

    /**
     * A function that computes the smallest path between 2 vertices given the result matrix from Floyd-Warshall
     * @param ch the "matrice des intermediaires"
     * @param n the matrix of distance
     * @param dep the first vertex
     * @param arr the last vertex
     */
    public static void cheminPlusCourt(ArrayList<ArrayList<Integer>> ch,ArrayList<ArrayList<Numbers>> n,  int dep, int arr){
        if (n.get(dep).get(arr).isInfinite())
            System.out.println("ce n'est pas possible d'aller de "+ dep + " a " + arr);
        else {
            System.out.print("Le chemin le plus cours pour aller de "+ dep + " a " + arr+ " est : ");
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
                    System.out.print(d + " ");
                }
                System.out.println("");
            }
        }
}
