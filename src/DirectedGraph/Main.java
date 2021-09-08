package DirectedGraph;

/* File: Project 4 - Main Class
 * Author: Dan Beck
 * Date: October 10, 2020
 * Purpose: Executes the program. Scans a selected file and generates the ouput
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class Main 
{
	static DirectedGraph graph = new DirectedGraph();
	
	/******************************************************************************* 
     * DESCRIPTION: extract from file 
     * Allows user to select file
     * Evaluates the lines from file
     ******************************************************************************/
    public void extractFromFile() 
    {
        //Allows user to select file and reads lines from the file
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.dir")));
        int status = fileChooser.showOpenDialog(null);
        
        if (status == JFileChooser.APPROVE_OPTION) 
        {
            File file = fileChooser.getSelectedFile();
            try 
            {
            	//scans each line. Creates one expression from each line
                Scanner scan = new Scanner(file);
                if (file.isFile()) 
                {
                	//loop to create the list
                    while (scan.hasNextLine()) 
                    {
                    	String edgeString = scan.nextLine();
                    	String[] edge = edgeString.split(" ");
                    	
                    	// Marks the first node of the graph
                    	// DFS starts from this node
                    	if (graph.startingNode == null)
                    	{
                    	graph.startingNode = graph.getVertex(edge[0]);
                    	}

                    	// add edges to the Directed graph
                    	// First node of the Line - All other nodes
                    	for (int i = 1; i < edge.length; i++) 
                    	{
                    	graph.addEdge(edge[0], edge[i]);
                    	}
                    }//end while (scan.hasNextLine()) 
                }// if (file.isFile())
                scan.close();
            }//end try
            catch (NoSuchElementException nse) 
            {
                JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), "The selected file is empty!");
            }//end catch (NoSuchElementException nse)
            catch (FileNotFoundException fnf) 
            {
                JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), "File can not be found!");
            }//end catch (FileNotFoundException fnf)
        }//end if (status == JFileChooser.APPROVE_OPTION)
    }//end public static void extractFromFile()
    
    /******************************************************************************* 
     * DESCRIPTION: Main
     * Initializes main
     * Starts Depth First Search
     * Allows results to be displayed
     ******************************************************************************/
    public static void main(String[] args) 
	{
		// Initializing Main Class
		new Main().extractFromFile();

		// Starting Depth First Search Utility to complete the DFS
		graph.depthFirstSearch();
		
		// Display Parenthesized List after processing the vertices
		System.out.print("Hierarchy: ");
		System.out.println(graph.parenthesizedList.toString());

		// Display Hierarchy after processing the vertices
		System.out.println("Parenthesized List: ");
		System.out.println(graph.hierarchy.toString());

		// Display all the nodes that remained unreachable in the searching process
		graph.displayUnreachableClasses();
	}//end main
}//end public class Main 
