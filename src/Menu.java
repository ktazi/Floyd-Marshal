import java.io.*;
import java.util.Scanner;

public class Menu {
    /**
     * Function that executes the menu
     * @throws IOException
     */
    public static void menu (File file) throws IOException {
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));
        Misc.println(wr,"_____________________________________________________________");
        Misc.println(wr,"");
        Misc.println(wr,"            Projet de theorie des graphes");
        Misc.println(wr,"              L3 Groupe A, promo 2023");
        Misc.println(wr,"     Matthieu Hanania, Tristan Fiévet, Kenza Tazi");
        Misc.println(wr,"");
        Misc.println(wr,"_____________________________________________________________");
        Misc.println(wr,"");
        boolean repeat = true;

        Graph.GraphBuilder gb;
        int i = 0;
        while(repeat){
            //File selection
            Misc.println(wr,"");
            Misc.println(wr,"_____________________________________________________________");
            Misc.println(wr,"SELECTION D'UN GRAPHE");
            Misc.println(wr,"_____________________________________________________________");
            Misc.println(wr,"");
            Misc.print(wr,"Veuillez sélectionner un Graphe > ");
            Scanner sc = new Scanner(System.in);
            i = sc.nextInt();
            wr.write(Integer.toString(i));
            wr.newLine();
            file = new File("Files/test"+i+".txt");
            while (!file.exists()){
                Misc.println(wr,"Graphe non existant. Veuillez selectionner un autre nombre >");
                sc = new Scanner(System.in);
                i = sc.nextInt();
                wr.write(Integer.toString(i));
                wr.newLine();
                file = new File("Files/test"+i+".txt");
            }
            gb = new Graph.GraphBuilder();
            Graph g = gb.from_file("Files/test"+i+".txt").build();
            //Graph display
            Misc.println(wr,"Matrice d'adjacence : ");
            Misc.println(wr,"");
            Misc.print_matrix_adja(g.matriceAdj, wr);
            Misc.println(wr,"");
            Misc.println(wr,"Matrice des valeurs : ");
            Misc.print_matrix_valeur(g.toMatrix(), wr);
            Misc.println(wr,"");
            Result r =  FloydWarshall.fW(g.toMatrix(), wr);
            Misc.println(wr,"");
            if (r == null) {
                Misc.println(wr,"Presence de circuits absorbants !");
            }
            else {

                Misc.println(wr,"_____________________________________________________________");
                Misc.println(wr,"IMPRESSION DES CHEMINS");
                Misc.println(wr,"_____________________________________________________________");

                boolean cond;
                do {
                    Misc.println(wr,"");
                    int dep;
                    do {
                        sc = new Scanner(System.in);
                        Misc.print(wr,"Sommet de depart (un chiffre entre 0 et "+ (r.Chem.size() - 1) +" ) > ");
                        dep = sc.nextInt();
                        wr.write(Integer.toString(dep));
                        wr.newLine();
                    }while (dep >= r.Chem.size());
                    int arr;
                    do {
                        sc = new Scanner(System.in);
                        Misc.print(wr,"Sommet d'arrivee (un chiffre entre 0 et "+ (r.Chem.size() - 1) +" ) > ");
                        arr = sc.nextInt();
                        wr.write(Integer.toString(arr));
                        wr.newLine();
                    }while (arr >= r.Chem.size());
                    Misc.cheminPlusCourt(r.Chem, r.Wn, dep, arr, wr);
                    String c;
                    do {
                        Misc.print(wr,"Voulez-vous tester avec un nouveau chemin ? (y-n)> ");
                        sc = new Scanner(System.in);
                        c = sc.nextLine();
                        wr.write(c);
                        wr.newLine();
                    }while (!c.equals("y") && !c.equals("n"));
                    cond = c.equals("y");
                } while (cond);

            }


            String c;
            do {
                Misc.print(wr, "Voulez-vous tester avec un nouveau graphe ? (y-n)> ");
                sc = new Scanner(System.in);
                c = sc.nextLine();
                wr.write(c);
                wr.newLine();
            }while (!c.equals("y") && !c.equals("n"));
            repeat = c.equals("y");
        }
        wr.close();
    }
}
