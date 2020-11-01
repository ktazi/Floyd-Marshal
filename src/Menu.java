import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Menu {
    /**
     * Function that executes the menu
     * @throws IOException
     */
    public static void menu () throws IOException {
        System.out.println("_____________________________________________________________");
        System.out.println("");
        System.out.println("            Projet de theorie des graphes");
        System.out.println("              L3 Groupe A, promo 2023");
        System.out.println("     Matthieu Hanania, Tristan Fiévet, Kenza Tazi");
        System.out.println();
        System.out.println("_____________________________________________________________");
        System.out.println();
        boolean repeat = true;

        File file;
        Graph.GraphBuilder gb;
        int i = 0;
        while(repeat){
            //File selection
            System.out.println();
            System.out.println("_____________________________________________________________");
            System.out.println("SELECTION D'UN GRAPHE");
            System.out.println("_____________________________________________________________");
            System.out.println("");
            System.out.print("Veuillez sélectionner un Graphe > ");
            Scanner sc = new Scanner(System.in);
            i = sc.nextInt();
            file = new File("Files/test"+i+".txt");
            while (!file.exists()){
                System.out.print("Graphe non existant. Veuillez selectionner un autre nombre >");
                sc = new Scanner(System.in);
                i = sc.nextInt();
                file = new File("Files/test"+i+".txt");
            }
            gb = new Graph.GraphBuilder();
            Graph g = gb.from_file("Files/test"+i+".txt").build();
            //Graph display
            System.out.println("Matrice d'adjacence : ");
            System.out.println();
            Misc.print_matrix_adja(g.matriceAdj);
            System.out.println();
            System.out.println("Matrice des valeurs : ");
            Misc.print_matrix_valeur(g.toMatrix());
            System.out.println();
            Result r =  FloydWarshall.fW(g.toMatrix());
            System.out.println();
            System.out.println("_____________________________________________________________");
            System.out.println("IMPRESSION DES CHEMINS");
            System.out.println("_____________________________________________________________");
            if (!(r == null))
            {
                boolean cond;
                do {
                    System.out.println();
                    int dep;
                    do {
                        sc = new Scanner(System.in);
                        System.out.print("Sommet de depart (un chiffre entre 0 et "+ (r.Chem.size() - 1) +" ) > ");
                        dep = sc.nextInt();
                    }while (dep >= r.Chem.size());
                    int arr;
                    do {
                        sc = new Scanner(System.in);
                        System.out.print("Sommet d'arrivee (un chiffre entre 0 et "+ (r.Chem.size() - 1) +" ) > ");
                        arr = sc.nextInt();
                    }while (arr >= r.Chem.size());
                    Misc.cheminPlusCourt(r.Chem, r.Wn, dep, arr);
                    String c;
                    do {
                        System.out.print("Voulez-vous tester avec un nouveau chemin ? (y-n)> ");
                        sc = new Scanner(System.in);
                        c = sc.nextLine();
                    }while (!c.equals("y") && !c.equals("n"));
                    cond = c.equals("y");
                } while (cond);
            }
            else {
                System.out.println("Presence de circuits absorbants !");
            }
            String c;
            do {
                System.out.print("Voulez-vous tester avec un nouveau graphe ? (y-n)> ");
                sc = new Scanner(System.in);
                c = sc.nextLine();
            }while (!c.equals("y") && !c.equals("n"));
            repeat = c.equals("y");
        }

    }
}
