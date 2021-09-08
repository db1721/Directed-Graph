package DirectedGraph;

import java.util.LinkedList;
import java.util.Queue;

public class ParenthesizedList implements DFSActions<Vertex> 
{
	// This class maintain a Queue to trace orders of the nodes and their dependent nodes
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
	}//end public void descendVertex(Vertex vertex) 

	/******************************************************************************* 
     * DESCRIPTION: cycleDetected
     * adds asterisk when cycle is detected
     ******************************************************************************/
	@Override
	public void cycleDetected() 
	{
		res.add("*");
	}//end public void descendVertex(Vertex vertex) 

	/******************************************************************************* 
     * DESCRIPTION: toString
     * generates the parenthesized list
     ******************************************************************************/
	@Override
	public String toString() 
	{
		String build = "";
		build += "( ";
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
			
			build += makeString + " ";
			
		}//end while (res.size() > 0) 

		build += ")\n";
		return build;
	}//end public String toString() 
}//end public class ParenthesizedList implements DFSActions<Vertex> 