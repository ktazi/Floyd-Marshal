import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;

public class FloydWarshall {
    /**
     * The Floyd-Warshall Algorigthm
     * @param matrix distance matrix of a graph
     * @return both the "matrice des intermediaire" and final Wn matrix
     */
    public static Result fW(ArrayList<ArrayList<Numbers>> matrix, BufferedWriter bw) throws IOException {
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
        Misc.println(bw,"\nMatrice de valeur: ");
        Misc.print_matrix_valeur(matrix, bw);
        Misc.println(bw,"\nMatrice W0 de depart : ");
        Misc.println(bw,"");
        Misc.print_matrix_valeur(matrix, bw);
        Misc.println(bw,"");
        //n occurences
        for(int i = 0; i < matrix.size(); i++){
            Misc.println(bw,"Matrice W"+(i+1)+" :");
            Misc.println(bw,"");
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
            Misc.print_matrix_valeur(m, bw);
            Misc.println(bw,"");
            matrix = m;
        }
        Misc.println(bw,"Resultat final : ");
        Misc.println(bw,"");
        Misc.print_matrix_valeur(m, bw);
        Result r = new Result(m, ch);
        return r;
    }
}
