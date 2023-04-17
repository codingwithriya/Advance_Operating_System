//Program Code with DFS
import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

 
public class Assignment_0 {
	
	private int v;
	
	void adjRead() throws IOException{
		int i,j,l,k;
		// Reading a file
		FileReader fp = new FileReader("Graph.txt"); // Graph2.txt or Graph3.txt
		/* The first line represents the no. of edges and the second line represents the no. of nodes and rest of  the lines shows the one directional connections between nodes*/
		Scanner sc=new Scanner(fp);
		Integer.parseInt(sc.nextLine());
		v=Integer.parseInt(sc.nextLine());
		
		int arr[][]=new int[v][v];
		boolean nodeCovered[]=new boolean[v];
		
		//Initializing the adjacency matrix with 0
		for(i=0;i<v;i++) {
			for(j=0;j<v;j++) {
				arr[i][j]=0;
			}
		}
		
		//Constructing the adjacency node
		while (sc.hasNextLine()) {
	        String data = sc.nextLine();
	        arr[Integer.parseInt(data.substring(0,1))][Integer.parseInt(data.substring(2,3))]=1;
	    }
		
		//Display the adjacency node
		System.out.println("The adjacency matrix is: ");
		for(i=0;i<v;i++) {
			for(j=0;j<v;j++) {
				System.out.print(" "+arr[i][j]);
			}
			System.out.println();
		}
		for(l=0;l<v;l++){
			System.out.println("\nVertices reached from "+l+" : ");
			
			//Calling DFS function
			dfs(l,nodeCovered,arr);
			System.out.println();
			k=0;
			for(i=0;i<v;i++){
				if(nodeCovered[i] == true){
					//Counting the number of vertices reached from a vertex
					k++;		
				}
			}
			
			//checking whether all the vertices are reached
			if(v-k ==0){
				System.out.println(l+" can be considered as initiator");
			}
			else {
				System.out.println(l+" can not be considered as initiator");
			}
			
			//Filling the nodeCovered array with False to
			//calculate the nodes visited from the next vertex
			Arrays.fill(nodeCovered, false); 
			
		}
		
		sc.close();
	}
	
	 void dfs(int start,boolean[] visited, int arr[][])
	    {
		 	
	        // Print the current node
	        System.out.print(start + " ");
	 
	        // Set current node as visited
	        visited[start] = true;
	 
	        // For every node of the graph
	        for (int i = 0; i < arr[start].length; i++) {
	 
	            // If some node is adjacent to the current node
	            // and it has not already been visited
	            if (arr[start][i] == 1 && (!visited[i])) {
	                dfs(i, visited,arr);
	            }
	        }
	    }
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		try{
			Assignment_0 g1=new Assignment_0();
			g1.adjRead();
			sc.close();
		}
		catch(IOException e1){
			System.out.println(e1);
		}
		
	}

}