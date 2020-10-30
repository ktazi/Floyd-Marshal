import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    //<Numero du noeud, map liant un arc (départ, arrivée) a sa valeur
    public static void main(String[] args) throws IOException {
        Graph.GraphBuilder gb = new Graph.GraphBuilder();
        
        System.out.println("Bonjour, quel graphe voulez-vous annalyser ?");
        
        Scanner sc = new Scanner(System.in);
	    int i = sc.nextInt();
	    
	    File file = new File("Files/test"+i+".txt");
	    
	    if(file.exists()) {
	    	Graph g = gb.from_file("Files/test"+i+".txt").build();
	    	ArrayList<ArrayList<Numbers>> mat = g.toMatrix();
	    	
	    	System.out.println("matrice Adja");
	    	Misc.print_matrix_adja2(g.matriceAdj);
	    	
	        mat = FloydWarshall.fW(mat);
	    	
	    }
	    else {
	    	System.out.println("fichier n'existe pas t moch");
	    }

    }

}
