import java.io.*;
import java.util.Scanner;

public class A5Menu {
    /**
     * Function that executes the menu
     * @throws IOException
     */
    public static void menu (File file) throws IOException {
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));
        A5Misc.println(wr,"_____________________________________________________________");
        A5Misc.println(wr,"");
        A5Misc.println(wr,"            Projet de theorie des graphes");
        A5Misc.println(wr,"              L3 Groupe A, promo 2023");
        A5Misc.println(wr,"     Matthieu Hanania, Tristan Fiévet, Kenza Tazi");
        A5Misc.println(wr,"");
        A5Misc.println(wr,"_____________________________________________________________");
        A5Misc.println(wr,"");
        boolean repeat = true;

        A5Graph.GraphBuilder gb;
        int i = 0;
        while(repeat){
            //File selection
            A5Misc.println(wr,"");
            A5Misc.println(wr,"_____________________________________________________________");
            A5Misc.println(wr,"SELECTION D'UN GRAPHE");
            A5Misc.println(wr,"_____________________________________________________________");
            A5Misc.println(wr,"");
            A5Misc.print(wr,"Veuillez sélectionner un Graphe > ");
            Scanner sc = new Scanner(System.in);
            i = sc.nextInt();
            wr.write(Integer.toString(i));
            wr.newLine();
            file = new File("Files/A5test"+i+".txt");
            while (!file.exists()){
                A5Misc.println(wr,"Graphe non existant. Veuillez selectionner un autre nombre >");
                sc = new Scanner(System.in);
                i = sc.nextInt();
                wr.write(Integer.toString(i));
                wr.newLine();
                file = new File("Files/A5test"+i+".txt");
            }
            gb = new A5Graph.GraphBuilder();
            A5Graph g = gb.from_file("Files/A5test"+i+".txt").build();
            //Graph display
            A5Misc.println(wr,"Matrice d'adjacence : ");
            A5Misc.println(wr,"");
            A5Misc.print_matrix_adja(g.matriceAdj, wr);
            A5Misc.println(wr,"");
            A5Misc.println(wr,"Matrice des valeurs : ");
            A5Misc.print_matrix_valeur(g.toMatrix(), wr);
            A5Misc.println(wr,"");
            A5Result r =  A5FloydWarshall.fW(g.toMatrix(), wr);
            A5Misc.println(wr,"");
            if (r == null) {
                A5Misc.println(wr,"Presence de circuits absorbants !");
            }
            else {

                A5Misc.println(wr,"_____________________________________________________________");
                A5Misc.println(wr,"IMPRESSION DES CHEMINS");
                A5Misc.println(wr,"_____________________________________________________________");

                boolean cond;
                do {
                    A5Misc.println(wr,"");
                    int dep;
                    do {
                        sc = new Scanner(System.in);
                        A5Misc.print(wr,"Sommet de depart (un chiffre entre 0 et "+ (r.Chem.size() - 1) +" ) > ");
                        dep = sc.nextInt();
                        wr.write(Integer.toString(dep));
                        wr.newLine();
                    }while (dep >= r.Chem.size());
                    int arr;
                    do {
                        sc = new Scanner(System.in);
                        A5Misc.print(wr,"Sommet d'arrivee (un chiffre entre 0 et "+ (r.Chem.size() - 1) +" ) > ");
                        arr = sc.nextInt();
                        wr.write(Integer.toString(arr));
                        wr.newLine();
                    }while (arr >= r.Chem.size());
                    A5Misc.cheminPlusCourt(r.Chem, r.Wn, dep, arr, wr);
                    String c;
                    do {
                        A5Misc.print(wr,"Voulez-vous tester avec un nouveau chemin ? (y-n)> ");
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
                A5Misc.print(wr, "Voulez-vous tester avec un nouveau graphe ? (y-n)> ");
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
