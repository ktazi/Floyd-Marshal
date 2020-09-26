import java.util.ArrayList;

public class FloydWarshall {
    public static ArrayList<ArrayList<Numbers>> fW(ArrayList<ArrayList<Numbers>> matrix) {
        ArrayList<ArrayList<Numbers>> m = new ArrayList<>();
        //initializing list
        for(int i = 0; i < matrix.size(); i++) {
            m.add(new ArrayList<>());
            for(int j = 0; j < matrix.size(); j++){
                m.get(i).add(null);
            }
        }
        System.out.println("Matrice W0 de départ : ");
        System.out.println();
        Misc.print_matrix(matrix);
        System.out.println();
        //n occurences
        for(int i = 0; i < matrix.size(); i++){
            System.out.println("Matrice W"+(i+1)+" :");
            System.out.println();
            for(int j = 0; j < matrix.size(); j++){
                for(int k = 0; k < matrix.size(); k++){
                    m.get(j).set(k, matrix.get(j).get(k).min(matrix.get(j).get(i),matrix.get(i).get(k)));
                }
            }
            Misc.print_matrix(m);
            System.out.println();
            matrix = m;
        }
        System.out.println("Résultat final : ");
        System.out.println();
        Misc.print_matrix(m);
        System.out.println();
        return m;
    }
}
