import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;

public class L3_A5_FloydWarshall {
    /**
     * The Floyd-Warshall Algorigthm
     * @param matrix distance matrix of a graph
     * @return both the "matrice des intermediaire" and final Wn matrix
     */
    public static L3_A5_Result fW(ArrayList<ArrayList<L3_A5_Numbers>> matrix, BufferedWriter bw) throws IOException {
        ArrayList<ArrayList<L3_A5_Numbers>> m = new ArrayList<>();
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
        L3_A5_Misc.println(bw,"\nMatrice W0 de depart : ");
        L3_A5_Misc.println(bw,"");
        L3_A5_Misc.print_matrix_valeur(matrix, bw);
        L3_A5_Misc.println(bw,"");
        //n occurences
        for(int i = 0; i < matrix.size(); i++){
            L3_A5_Misc.println(bw,"Matrice W"+(i+1)+" :");
            L3_A5_Misc.println(bw,"");
            for(int j = 0; j < matrix.size(); j++){
                for(int k = 0; k < matrix.size(); k++){
                    if(L3_A5_Numbers.diff(matrix.get(j).get(k).min(matrix.get(j).get(i),matrix.get(i).get(k)), matrix.get(j).get(k)))
                        ch.get(j).set(k, i);
                    m.get(j).set(k, matrix.get(j).get(k).min(matrix.get(j).get(i),matrix.get(i).get(k)));
                }
            }
            for(int j = 0; j < m.size(); j++)
            {
                if (m.get(j).get(j).value() < 0)
                    return null;
            }
            L3_A5_Misc.print_matrix_valeur(m, bw);
            L3_A5_Misc.println(bw,"");
            matrix = m;
        }
        L3_A5_Misc.println(bw,"Resultat final : ");
        L3_A5_Misc.println(bw,"");
        L3_A5_Misc.print_matrix_valeur(m, bw);
        L3_A5_Misc.print_matrix_adja(ch, bw);
        L3_A5_Result r = new L3_A5_Result(m, ch);
        return r;
    }
}
