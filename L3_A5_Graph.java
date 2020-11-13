import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class L3_A5_Graph {

	private HashMap<Integer, HashMap<Integer, Integer>> graph;
	public ArrayList<ArrayList<Integer>> matriceAdj;

    /**
     * Constructor of a graph
     * @param g, the hashmap that contains the graph
     */
    public L3_A5_Graph(HashMap<Integer, HashMap<Integer, Integer>> g) {
        this.graph = g;
        
         matriceAdj = new ArrayList<>();
        for(int i  = 0; i < graph.size(); i++) {
            matriceAdj.add(new ArrayList<>());
            for(int j = 0; j < graph.size(); j++)
                matriceAdj.get(i).add(0);
        }
        for (Map.Entry<Integer, HashMap<Integer, Integer>> e1 : graph.entrySet()){ //key = noeud dep
            for(Map.Entry<Integer, Integer> e2 : e1.getValue().entrySet()) { //key = noeud arr
                matriceAdj.get(e1.getKey()).set(e2.getKey(), 1);
            }
        }
    }

    /**
     * Function that converts the HashMap in distance matrix
     * @return the distance matrix
     */
    public ArrayList <ArrayList<L3_A5_Numbers>> toMatrix(){
        ArrayList<ArrayList<L3_A5_Numbers>> l = new ArrayList<>();
        for(int i  = 0; i < graph.size(); i++) {
            l.add(new ArrayList<>());
            for(int j = 0; j < graph.size(); j++)
                l.get(i).add(i == j ? new L3_A5_Numbers(false, 0) :null);
        }
        for (Map.Entry<Integer, HashMap<Integer, Integer>> e1 : graph.entrySet()){ //key = noeud dep
            for(Map.Entry<Integer, Integer> e2 : e1.getValue().entrySet()) { //key = noeud arr
                l.get(e1.getKey()).set(e2.getKey(), new L3_A5_Numbers(false, e2.getValue()));
            }
        }
        for(int i = 0; i < graph.size(); i++){
            for(int j = 0; j < graph.size(); j++){
                if(l.get(i).get(j) == null)
                    l.get(i).set(j, new L3_A5_Numbers(true, 0));
            }
        }
        return l;
    }

    public static class GraphBuilder
    {
        HashMap<Integer, HashMap<Integer, Integer>> graph;

        /**
         * Function constructor. Initializes parameter with an empty hashmap
         */

        public GraphBuilder(){
            this.graph = new HashMap<>();
        }

        /**
         * Builds a graph from a file
         * @param path
         * @return the builder
         * @throws FileNotFoundException Path not found
         */

        GraphBuilder from_file(String path) throws IOException {
            BufferedReader reader = new BufferedReader(new FileReader(path));
            /* Read the size of the graph */
            String ln = reader.readLine();
            if (ln == null)
                throw new IllegalArgumentException("Fichier non réglementaire : la premiere ligne ne doit pas etre vide l:1");
            if(!L3_A5_Misc.isInteger(ln)){
                throw new IllegalArgumentException("Fichier non réglementaire : Le nombre de noeuds n'est pas un chiffre de type entier l:1");
            }
            int taille = Integer.parseInt(ln);
            if(taille < 0)
                throw new IllegalArgumentException("Fichier non réglementaire : Le nombre de noeuds n'est pas un chiffre positif l:1");

            for(int i = 0; i < taille; i++)
                graph.put(i, new HashMap<>());

            /* Read the number of edges */
            ln = reader.readLine();
            if (ln == null)
                throw new IllegalArgumentException("Fichier non réglementaire : la seconde ligne ne doit pas etre vide l:2");
            if(!L3_A5_Misc.isInteger(ln))
                throw new IllegalArgumentException("Fichier non réglementaire : Le nombre d'arcs n'est pas un chiffre de type entier l:2");
            int arcs = Integer.parseInt(ln);
            if (arcs < 0)
                throw new IllegalArgumentException("Fichier non réglementaire : Le nombre d'arcs n'est pas un chiffre positif l:2");
            /* Read the edges */
            for (int i = 0; i < arcs; i++){
                ln = reader.readLine();
                if(ln == null)
                    throw new IllegalArgumentException("Fichier non réglementaire : Trop peu d'arcs décrits l:" + (i+3));
                String[] data = ln.split(" ");
                if (data.length != 3)
                    throw new IllegalArgumentException("Fichier non réglementaire : Pas le bon nombre d'arguments pour décrire un arc. Attendu 3, dans le fichier " + data.length + " l:"+ (i+3));
                for(int j = 0; j < 2; j++)
                {
                    if(!L3_A5_Misc.isInteger(data[j]))
                        throw new IllegalArgumentException("Fichier non réglementaire : Le nom du noeud n°"+(j + 1)+" n'est pas un chiffre de type entier l:" + (i+3));
                    int temp = Integer.parseInt(data[j]);
                    if (temp < 0)
                        throw new IllegalArgumentException("Fichier non réglementaire : Le nom du noeud n°"+(j + 1)+" n'est pas un chiffre positif l:" + (i+3));
                    if (temp >= taille)
                        throw new IllegalArgumentException("Fichier non réglementaire : Le nom du noeud n°"+(j + 1)+" n'existe pas l:"+(i+3));
                }
                if(!L3_A5_Misc.isInteger(data[2]))
                    throw new IllegalArgumentException("Fichier non réglementaire : Le poids de l'arc n'est pas un chiffre de type entier l:" + (i+3));
                if(graph.get(Integer.parseInt(data[0])).containsKey(Integer.parseInt(data[1])))
                    throw new IllegalArgumentException("Fichier non réglementaire : L'arc décrit dans cette ligne est un doublon l:"+ (i+3));
                graph.get(Integer.parseInt(data[0])).put(Integer.parseInt(data[1]),Integer.parseInt(data[2]));
            }
            return this;
        }
        
        L3_A5_Graph build()
        {
            return new L3_A5_Graph(this.graph);
        }

    }

}
