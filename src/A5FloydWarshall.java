import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;

public class A5FloydWarshall {
    /**
     * The Floyd-Warshall Algorigthm
     * @param matrix distance matrix of a graph
     * @return both the "matrice des intermediaire" and final Wn matrix
     */
    public static A5Result fW(ArrayList<ArrayList<A5Numbers>> matrix, BufferedWriter bw) throws IOException {
        ArrayList<ArrayList<A5Numbers>> m = new ArrayList<>();
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
        A5Misc.println(bw,"\nMatrice W0 de depart : ");
        A5Misc.println(bw,"");
        A5Misc.print_matrix_valeur(matrix, bw);
        A5Misc.println(bw,"");
        //n occurences
        for(int i = 0; i < matrix.size(); i++){
            A5Misc.println(bw,"Matrice W"+(i+1)+" :");
            A5Misc.println(bw,"");
            for(int j = 0; j < matrix.size(); j++){
                for(int k = 0; k < matrix.size(); k++){
                    if(A5Numbers.diff(matrix.get(j).get(k).min(matrix.get(j).get(i),matrix.get(i).get(k)), matrix.get(j).get(k)))
                        ch.get(j).set(k, i);
                    m.get(j).set(k, matrix.get(j).get(k).min(matrix.get(j).get(i),matrix.get(i).get(k)));
                }
            }
            for(int j = 0; j < m.size(); j++)
            {
                if (m.get(j).get(j).value() < 0)
                    return null;
            }
            A5Misc.print_matrix_valeur(m, bw);
            A5Misc.println(bw,"");
            matrix = m;
        }
        A5Misc.println(bw,"Resultat final : ");
        A5Misc.println(bw,"");
        A5Misc.print_matrix_valeur(m, bw);
        A5Result r = new A5Result(m, ch);
        return r;
    }
}
