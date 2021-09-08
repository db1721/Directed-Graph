package DirectedGraph;

/* File: Project 4 - Graph
 * Author: Dan Beck
 * Date: October 11, 2020
 * Generates a graph based on the file selected
 */

import java.util.*;

public class Graph<V> 
{
	//Starting point of the graph
	public V startingNode = null;

	//Maps the vertex name (String) to a corresponding Vertex
	Map<String, V> vertices = new HashMap<>();

	//Adjacency representation of the graph
	Map<V, ArrayList<V>> adjacencyList = new HashMap<>();

	//Track if a node/vertex is visited in the searching process
	Set<V> visited = new HashSet<>();

	//Representation utility
	ParenthesizedList hierarchy = new ParenthesizedList();
	Hierarchy parenthesizedList = new Hierarchy();

	//Tracks if the graph contains a circle
	boolean cycle;
	Set<V> discovered = new HashSet<>();

	/******************************************************************************* 
     * DESCRIPTION: Depth First Search
     * initializes the DFS with all other related attributes
     ******************************************************************************/
	public void depthFirstSearch() 
	{
		// Marking cycle flag as false
		cycle = false;
		// Starting DFS from the first node of the input data
		dfs(startingNode);
	}//end public void depthFirstSearch()

	/******************************************************************************* 
     * DESCRIPTION: DFS
     * Search in the adjacency list in Depth-First-Order
     ******************************************************************************/
	private void dfs(V node) 
	{
		// check if the node is already visited in and not completed discovering it's child yet
		// If so, a cycle has been detected
		if (discovered.contains(node)) 
		{
			cycle = true;

			// Perform DFS Actions Cycle Detected operation
			hierarchy.cycleDetected();
			parenthesizedList.cycleDetected();
			return;
		}//end if (discovered.contains(node))

		//Perform DFS Actions Vertex Add operation
		hierarchy.processVertex((Vertex) node);
		parenthesizedList.processVertex((Vertex) node);

		//Perform DFS Actions Descend Vertex operation
		hierarchy.descendVertex((Vertex) node);
		parenthesizedList.descendVertex((Vertex) node);

		//add the node to the discovery list
		discovered.add(node);

		//mark the node as visited
		visited.add(node);

		//discover all of it's child
		ArrayList<V> list = adjacencyList.get(node);
		if (list != null) 
		{
			for (V u : list)
				dfs(u);
		}//end if (list != null) 


		// Perform DFS Actions Ascend Vertex operation
		hierarchy.ascendVertex((Vertex) node);
		parenthesizedList.ascendVertex((Vertex) node);

		// this node has discovered completely and remove it from the discovered list
		discovered.remove(node);

	}//end private void dfs(V node) 

	/******************************************************************************* 
     * DESCRIPTION: Display Unreachable Classes
     * Prints all the unvisited nodes/classes
     ******************************************************************************/
	public void displayUnreachableClasses()
	{
		// Loop all over the adjacency list
		for (Map.Entry<V, ArrayList<V>> entry : adjacencyList.entrySet()) 
		{
			// for each entry check if there is any unvisited/undiscovered node/class
			if(entry.getValue().size()>0)
			{
				// if found one print it and mark it as visited to avoid double printing
				// check the node itself
				if(!visited.contains(entry.getKey()))
				{
					System.out.println("Unreachable: " + entry.getKey());
					visited.add(entry.getKey());
				}//end if(!visited.contains(entry.getKey()))

				// check all of it's adjacent nodes
				for (V vertex : entry.getValue())
				{

					if(!visited.contains(vertex))
					{
						System.out.println("Unreachable: " + vertex);
						visited.add(vertex);
					}//end if(!visited.contains(vertex))
				}//end for (V vertex : entry.getValue())
			}//end if(entry.getValue().size()>0)
		}//end for (Map.Entry<V, ArrayList<V>> entry : adjacencyList.entrySet())
	}//end public void displayUnreachableClasses()
}//end public class Graph<V> 