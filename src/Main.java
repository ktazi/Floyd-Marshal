import java.io.IOException;
import java.util.ArrayList;

public class Main {
    //<Numero du noeud, map liant un arc (départ, arrivée) a sa valeur
    public static void main(String[] args) throws IOException {
        Graph.GraphBuilder gb = new Graph.GraphBuilder();
        Graph g = gb.from_file("Files/test.txt").build();
        ArrayList<ArrayList<Numbers>> mat = g.toMatrix();
        mat = FloydWarshall.fW(mat);

    }

}
