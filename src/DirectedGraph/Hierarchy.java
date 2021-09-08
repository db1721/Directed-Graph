package DirectedGraph;

/* File: Project 4 - Hierarchy
 * Author: Dan Beck
 * Date: October 11, 2020
 * Generates the hierarchy string
 */

import java.util.LinkedList;
import java.util.Queue;

public class Hierarchy implements DFSActions<Vertex> 
{
	Queue<String> res = new LinkedList<>();

	/******************************************************************************* 
     * DESCRIPTION: processVertex
     * adds vertex to the string
     ******************************************************************************/
	@Override
	public void processVertex(Vertex vertex) 
	{
		res.add(vertex.toString());
	}//end public void processVertex(Vertex vertex) 

	/******************************************************************************* 
     * DESCRIPTION: descendVertex
     * adds opening parentheses
     ******************************************************************************/
	@Override
	public void descendVertex(Vertex vertex) 
	{
		res.add("(");
	}//end public void descendVertex(Vertex vertex) 

	/******************************************************************************* 
     * DESCRIPTION: ascendVertex
     * adds closing parentheses
     ******************************************************************************/
	@Override
	public void ascendVertex(Vertex vertex) 
	{
		res.add(")");

	}//end public void ascendVertex(Vertex vertex) 

	/******************************************************************************* 
     * DESCRIPTION: cycleDetected
     * adds asterisk when cycle is detected
     ******************************************************************************/
	@Override
	public void cycleDetected() 
	{
		res.add("*");
	}//end public void cycleDetected() 
	
	/******************************************************************************* 
     * DESCRIPTION: toString
     * generates the hierarchy list
     ******************************************************************************/
	@Override
	public String toString() 
	{

		String build = "";

		int size = 0;

		while (res.size() > 0) 
		{
			String makeString = res.peek();
			res.remove();

			if (makeString == "(") 
			{
				if (res.peek() == ")") 
				{
					res.remove();
					continue;
				}//end if (res.peek() == ")") 
				else if (res.peek() == "*") 
				{
					build += res.peek() + " ";
					res.remove();
					res.remove();
					continue;
				}//end else if (res.peek() == "*")
			}//end if (makeString == "(")

			if(makeString=="(")
			{
				size++;
			}//end if(makeString=="(")
			else if(makeString==")")
			{
				--size;
			}//end else if(makeString==")")
			
			if(makeString=="(" || makeString==")")
			{
				continue;
			}//end if(makeString=="(" || makeString==")")
			
			if(makeString!="*")
			{
				build += "\n";
			}//end if(makeString!="*")
			for (int i = 0; i < size; i++) 
			{
				build += "\t";
			}//end for (int i = 0; i < size; i++)

			build += makeString + " " ;

		}//end while (res.size() > 0)
		
		build += "\n";
		return build;
		
	}//end public String toString() 
}//end public class Hierarchy implements DFSActions<Vertex> 