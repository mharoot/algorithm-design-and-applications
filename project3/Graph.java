import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.PriorityQueue;

/*******************************************************************************
 * Created by michael on 4/27/17.
 */
public class Graph
{
private ArrayList<EdgeNode> []   adjList ;
private int nVertices;
private int  nEdges;
private int totalEdgeWeight;


public Graph ( String inputFileName)  { // creates Graph from data in file 
	this(5);
	ArrayList<ArrayList<Integer>> edges = null;

	try {
		edges = getFileContent(inputFileName);
		
	} catch (IOException e) {
		e.printStackTrace();
	}
	
	for (int i = 0; i < edges.size(); i++) {
		ArrayList<Integer> vertexData = edges.get(i);
		int vertex   = vertexData.get(0);
		int neighbor = vertexData.get(1);
		int weight   = vertexData.get(2); 
		addEdge(vertex, neighbor, weight);
	}
	

	
}

public Graph(int n) { // Creates a  Graph with n vertices and 0 edges
	nVertices = n;
	adjList = new ArrayList[nVertices];
	for (int i = 0; i < nVertices; i++) {
		adjList[i] = new ArrayList<EdgeNode>();
	}
}


public void addEdge(int i, int j, int weight) {  // adds an edge to the graph
	adjList[i].add(new EdgeNode(i, j, weight));
	adjList[j].add(new EdgeNode(j, i, weight)); // this is an undirected graph
	nEdges++;
	totalEdgeWeight+=weight;
	
}

public void printGraph()  { 
	// prints nVertices, nEdges, and adjacency lists and total edge weight
	
	System.out.println("Graph: nVertices = "+nVertices+" nEdges = "+nEdges
			+" totalEdgeWeight = "+totalEdgeWeight+"\nAdjacency Lists");
	
	int n = adjList.length;
	for (int i = 0; i < n; i++) 
	{
		ArrayList<EdgeNode> edges = adjList[i];

		int m = edges.size();
		
		for (int j = 0; j < m; j++) {
			if (j == 0) System.out.print("v= " + edges.get(j).vertex1 + " [");
			
			System.out.print(edges.get(j).toString());
			String endStr = j == m - 1 ? "]\n" : ", ";
			System.out.print(endStr);
		}
		
	}
	
}

public int get_nVertices(){return nVertices;}
public int get_nEdges() {return nEdges;  }
public int get_TotalWeightOfEdges() {return totalEdgeWeight; } 

public Graph dfsTraversal ( int start)  {  
	Graph graph = null;
/* Use recursion by calling a recursive dfs method. Visit all nodes. If graph is
 * not connected you will need to call dfs more than once to visit all nodes.
 * Print the following information gleaned from the dfs traversal
 * Print nodes in order visited
 * Connected?    ____
 * NumberOfComponents?   _____
 * Has a cycle?   _______
 * If the graph is connected, return the spanning tree from the dfs traversal.
 * Otherwise, return null. 
*/
	
	return graph;
}


/**
 * 
 * @param start = using this instance of an undirected weighted graph G with 
 * nonnegative edge weights, and a distinguished vertex v of G
 * 
 * 	Output: mPriorityQueue = a priority queue, A label, D[u], for each vertex u of G, such that
 *  D[u] is the distance from v to u in G
 */
public void   dijkstraShortestPaths (int start ) {

	// Let a priority queue, Q, contain all the vertices of G using the D labels as keys
	PriorityQueue<PQNode> Q = new PriorityQueue<PQNode>();
	int []D = new int [nVertices];
	for (int u = 0; u < nVertices; u++) {
		D[u] = (u != start) ? Integer.MAX_VALUE : 0;
	}
	

	
	
	// initially pull start vertex v into Q
	Q.add(new PQNode(start,D[start]));
	
	while (!Q.isEmpty()) {
		// pull a new vertex u into the cloud
		PQNode u = Q.remove(); // problem how do i know im removing min?
		for (EdgeNode z : adjList[u.vertex]) { // for each vertex z adjacent to u such that z is in Q do
			// perform the relaxation procedure on edge (u, z)
			int weightFromUtoZ = z.weight;
			if (D[u.vertex] + weightFromUtoZ < D[z.vertex2] ) {
				D[z.vertex2] = D[u.vertex] + weightFromUtoZ;
				Q.add(new PQNode(z.vertex2, D[z.vertex2]));
			}
			
		}
	}
	
	/*
	 * Use the Java PriorityQueue<PQNode>   class. Use PQNode class below. The Java 
	 * PriorityQueue class has no updateKey method. For our problem, just add a new 
	 * updated  node to the priority queue. This will work for Dijkstra's algorithm 
	 * since the new node has a smaller priority than the node you want to update.
	 */
	for (int i = 0; i < 5; i++)
	System.out.println(D[i]);


	
	
} 

public Graph  kruskalMST()   {
	Graph mst = null;
/* Implement Kruskal algorithm from text or class.
 * You may assume that the graph is connected.
 * You may sort the edges or use a priority queue.
 * Use clusters. 
 * Print the edges of the MST found and its total weight
 * Return the minimum spanning tree as a Graph  
*/
	return mst;
 }



/*
 *----------------------------GRAPH UTILITY FUNCTIONS---------------------------
 */

/**
 * 
 * @param str = line read as a string from a text
 * @return ArrayList of size 3, 
 * where position ( 0 = vertex, 1 = connected vertex, 2 = weight )
 */
private static ArrayList<Integer> findIntegersInString(String str) {
	char[] charArr = str.toCharArray();
	int n = charArr.length;
	char ch;
	String num = "";
	ArrayList<Integer> integers = new ArrayList<Integer>();

	for (int i = 0; i < n; i++) {
		ch = charArr[i];
	    if (ch != ' ') {
	    	num += ch;
	    } else if (ch == ' ' && num.length() > 0) {
	    	// finished scanning a number so convert to integer
	    	integers.add(Integer.valueOf(num));
	    	num = "";
	    }
	}
	
	// if we still have a last number not processed add it
	if (num.length() > 0 && Integer.valueOf(num) > 0 ) {
		integers.add(Integer.valueOf(num));
	}
	
	return integers;
}

private static File getFile(String filename) {
	File file = null;
    String dir = System.getProperty("user.dir");
	file = new File(dir, filename);
	file = file.exists() ? file : new File(filename);
    return file;
}

/**
 * 
 * @param filename
 * @return an ArrayList of ArrayLists
 * @throws IOException
 */
private static ArrayList<ArrayList<Integer>> getFileContent(String filename) 
throws IOException 
{
    //Read text from file
    BufferedReader br = new BufferedReader(getFileReader(filename));
    String line;

    ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
    while ((line = br.readLine()) != null) {
        list.add(findIntegersInString(line));
    }
    br.close();
    return list;
}

private static FileReader getFileReader(String filename) 
	throws FileNotFoundException { return new FileReader(getFile(filename));}

/*
 *------------------------END OF GRAPH UTILITY FUNCTIONS------------------------
 */











class  EdgeNode  implements Comparable<EdgeNode>
{
	int vertex1;
	int vertex2;
	int weight;
	public EdgeNode ( int v1, int v2, int w)
	{ vertex1 = v1; vertex2 = v2; weight = w;}
	
	public int  compareTo( EdgeNode node)
	{ return weight - node.weight;}
	
	public String toString() { 
		String s = "(";
		s = s + vertex1 + "," +vertex2 + ","  + weight + ")";
		return s;
	}
}



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

} // end of graph class
