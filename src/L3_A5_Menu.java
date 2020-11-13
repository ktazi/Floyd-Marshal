import java.io.*;
import java.util.Scanner;

public class L3_A5_Menu {
    /**
     * Function that executes the menu
     * @throws IOException
     */
    public static void menu (File file) throws IOException {
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));
        L3_A5_Misc.println(wr,"_____________________________________________________________");
        L3_A5_Misc.println(wr,"");
        L3_A5_Misc.println(wr,"            Projet de theorie des graphes");
        L3_A5_Misc.println(wr,"              L3 Groupe A, promo 2023");
        L3_A5_Misc.println(wr,"     Matthieu Hanania, Tristan Fiévet, Kenza Tazi");
        L3_A5_Misc.println(wr,"");
        L3_A5_Misc.println(wr,"_____________________________________________________________");
        L3_A5_Misc.println(wr,"");
        boolean repeat = true;

        L3_A5_Graph.GraphBuilder gb;
        int i = 0;
        while(repeat){
            //File selection
            L3_A5_Misc.println(wr,"");
            L3_A5_Misc.println(wr,"_____________________________________________________________");
            L3_A5_Misc.println(wr,"SELECTION D'UN GRAPHE");
            L3_A5_Misc.println(wr,"_____________________________________________________________");
            L3_A5_Misc.println(wr,"");
            L3_A5_Misc.print(wr,"Veuillez sélectionner un Graphe > ");
            Scanner sc = new Scanner(System.in);
            i = sc.nextInt();
            wr.write(Integer.toString(i));
            wr.newLine();
            file = new File("L3-A5-graphe"+i+".txt");
            while (!file.exists()){
                L3_A5_Misc.println(wr,"Graphe non existant. Veuillez selectionner un autre nombre >");
                sc = new Scanner(System.in);
                i = sc.nextInt();
                wr.write(Integer.toString(i));
                wr.newLine();
                file = new File("L3-A5-graphe"+i+".txt");
            }
            gb = new L3_A5_Graph.GraphBuilder();
            L3_A5_Graph g = gb.from_file("L3-A5-graphe"+i+".txt").build();
            //Graph display
            L3_A5_Misc.println(wr,"Matrice d'adjacence : ");
            L3_A5_Misc.println(wr,"");
            L3_A5_Misc.print_matrix_adja(g.matriceAdj, wr);
            L3_A5_Misc.println(wr,"");
            L3_A5_Misc.println(wr,"Matrice des valeurs : ");
            L3_A5_Misc.print_matrix_valeur(g.toMatrix(), wr);
            L3_A5_Misc.println(wr,"");
            L3_A5_Result r =  L3_A5_FloydWarshall.fW(g.toMatrix(), wr);
            L3_A5_Misc.println(wr,"");
            if (r == null) {
                L3_A5_Misc.println(wr,"Presence de circuits absorbants !");
            }
            else {

                L3_A5_Misc.println(wr,"_____________________________________________________________");
                L3_A5_Misc.println(wr,"IMPRESSION DES CHEMINS");
                L3_A5_Misc.println(wr,"_____________________________________________________________");

                boolean cond;
                do {
                    L3_A5_Misc.println(wr,"");
                    int dep;
                    do {
                        sc = new Scanner(System.in);
                        L3_A5_Misc.print(wr,"Sommet de depart (un chiffre entre 0 et "+ (r.Chem.size() - 1) +" ) > ");
                        dep = sc.nextInt();
                        wr.write(Integer.toString(dep));
                        wr.newLine();
                    }while (dep >= r.Chem.size());
                    int arr;
                    do {
                        sc = new Scanner(System.in);
                        L3_A5_Misc.print(wr,"Sommet d'arrivee (un chiffre entre 0 et "+ (r.Chem.size() - 1) +" ) > ");
                        arr = sc.nextInt();
                        wr.write(Integer.toString(arr));
                        wr.newLine();
                    }while (arr >= r.Chem.size());
                    L3_A5_Misc.cheminPlusCourt(r.Chem, r.Wn, dep, arr, wr);
                    String c;
                    do {
                        L3_A5_Misc.print(wr,"Voulez-vous tester avec un nouveau chemin ? (y-n)> ");
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
                L3_A5_Misc.print(wr, "Voulez-vous tester avec un nouveau graphe ? (y-n)> ");
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
