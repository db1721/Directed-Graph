package DirectedGraph;

/* File: Project 4 - Directed Graph
 * Author: Dan Beck
 * Date: October 11, 2020
 * builds the directed graph from the graph information
 */

import java.util.ArrayList;

public class DirectedGraph extends Graph<Vertex> 
{
	/******************************************************************************* 
     * DESCRIPTION: Add Edge 
     * creates a directed edge and add it to the graph
     * u Node have a edge from (source node)
     * v Node have a edge to (destination node)
     ******************************************************************************/
	public void addEdge(String u, String v) 
	{
		// Check if th source node already has some connected edges
		ArrayList<Vertex> list = adjacencyList.get(getVertex(u));


		// if already not in the Adjacency list
		// Map it to a new Vertex and initialize
		if (list == null) 
		{
			list = new ArrayList<>();
		}//end if (list == null) 

		// add a edge to source to destination
		list.add(getVertex(v));

		// update the adjacency list
		adjacencyList.put(getVertex(u), list);

	}//end public void addEdge(String u, String v) 

	/******************************************************************************* 
     * DESCRIPTION: getVertex 
     * checks if a node is already mapped to a vertex
     * u node(String) to be mapped
     * returns the mapped correspond vertex of the node
     ******************************************************************************/
	public Vertex getVertex(String u) 
	{
		// if this node(String) showed up for the first time
		// map it to a correspond vertex
		if (!vertices.containsKey(u)) 
		{
			vertices.put(u, new Vertex(u));
		}//end if (!vertices.containsKey(u))

		return vertices.get(u);
	}//end public Vertex getVertex(String u) 
}//end public class DirectedGraph extends Graph<Vertex>