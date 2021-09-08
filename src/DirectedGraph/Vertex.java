package DirectedGraph;

/* File: Project 4 - Vertex
 * Author: Dan Beck
 * Date: October 11, 2020
 * Sets the vertex
 */

public class Vertex 
{
	private String name;

	public Vertex(String name) 
	{
		this.name = name;
	}//end public Vertex(String name)

	@Override
	public String toString() 
	{
		return name;
	}//end public String toString()
}//end public class Vertex