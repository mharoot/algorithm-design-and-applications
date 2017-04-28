/**
 * Created by michael on 4/27/17.
 */
public class Graph {


















    class PQNode implements Comparable<PQNode>
    {
        int vertex;
        int distance;
        public PQNode( int v, int z)
        {
            vertex = v;
            distance = z;
        }

        public int compareTo(PQNode node)
        {
            return( distance - node.distance);
        }

        public String toString()
        {
            return "(" + vertex + "," + distance;
        }
    }
}
