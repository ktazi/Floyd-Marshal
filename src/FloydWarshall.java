import java.util.ArrayList;

public class FloydWarshall {
    /**
     * The Floyd-Warshall Algorigthm
     * @param matrix distance matrix of a graph
     * @return both the "matrice des intermediaire" and final Wn matrix
     */
    public static Result fW(ArrayList<ArrayList<Numbers>> matrix) {
        ArrayList<ArrayList<Numbers>> m = new ArrayList<>();
        //initializing list
        for(int i = 0; i < matrix.size(); i++) {
            m.add(new ArrayList<>());
            for(int j = 0; j < matrix.size(); j++){
                m.get(i).add(null);
            }
        }
        ArrayList<ArrayList<Integer>> ch = new ArrayList<>();
        //initializing list of mid ...
        for(int i = 0; i < matrix.size(); i++) {
            ch.add(new ArrayList<>());
            for(int j = 0; j < matrix.size(); j++){
                ch.get(i).add(-1);
            }
        }
        System.out.println("\nMatrice de valeur: ");
        Misc.print_matrix_valeur(matrix);
        System.out.println("\nMatrice W0 de depart : ");
        System.out.println();
        Misc.print_matrix_valeur(matrix);
        System.out.println();
        //n occurences
        for(int i = 0; i < matrix.size(); i++){
            System.out.println("Matrice W"+(i+1)+" :");
            System.out.println();
            for(int j = 0; j < matrix.size(); j++){
                for(int k = 0; k < matrix.size(); k++){
                    if(Numbers.diff(matrix.get(j).get(k).min(matrix.get(j).get(i),matrix.get(i).get(k)), matrix.get(j).get(k)))
                        ch.get(j).set(k, i);
                    m.get(j).set(k, matrix.get(j).get(k).min(matrix.get(j).get(i),matrix.get(i).get(k)));
                }
            }
            for(int j = 0; j < m.size(); j++)
            {
                if (m.get(j).get(j).value() < 0)
                    return null;
            }
            Misc.print_matrix_valeur(m);
            System.out.println();
            matrix = m;
        }
        System.out.println("Resultat final : ");
        System.out.println();
        Misc.print_matrix_valeur(m);
        Result r = new Result(m, ch);
        return r;
    }
}
