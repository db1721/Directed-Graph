package DirectedGraph;

/* File: Project 4 - DFS Actions
 * Author: Dan Beck
 * Date: October 11, 2020
 * creates the interface for DFS actions
 */

public interface DFSActions<V> 
{
	public void processVertex(V vertex);

	public void descendVertex(V vertex);

	public void ascendVertex(V vertex);

	public void cycleDetected();
}//end public interface DFSActions<V> 
