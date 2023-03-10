/*
Robert Khalulyan
Project 3
12/04/2022
 */
public class TestGraph {
   public static void main(String[] args)  {
   	// TODO Auto-generated method stub
      String[] vertices = {"Seattle", "San Francisco", "Los Angeles",
         		      "Denver", "Kansas City", "Chicago", "Boston", "New York",
         		      "Atlanta", "Miami", "Dallas", "Houston"};
   
      int[][] edges = {
         		      {0, 1, 807}, {0, 3, 1331}, {0, 5, 2097},
         		      {1, 0, 807}, {1, 2, 381}, {1, 3, 1267},
         		      {2, 1, 381}, {2, 3, 1015}, {2, 4, 1663}, {2, 10, 1435},
         		      {3, 0, 1331}, {3, 1, 1267}, {3, 2, 1015}, {3, 4, 599},
			          {3, 5, 1003},
         		      {4, 2, 1663}, {4, 3, 599}, {4, 5, 533}, {4, 7, 1260},
			          {4, 8, 864}, {4, 10, 496},
         		      {5, 0, 2097}, {5, 3, 1003}, {5, 4, 533}, 
			          {5, 6, 983}, {5, 7, 787},
         		      {6, 5, 983}, {6, 7, 214},
         		      {7, 4, 1260}, {7, 5, 787}, {7, 6, 214}, {7, 8, 888},
         		      {8, 4, 864}, {8, 7, 888}, {8, 9, 661},
			          {8, 10, 781}, {8, 11, 810},
         		      {9, 8, 661}, {9, 11, 1187},
         		      {10, 2, 1435}, {10, 4, 496}, {10, 8, 781}, {10, 11, 239},
         		      {11, 8, 810}, {11, 9, 1187}, {11, 10, 239}
         		    };
      Graph<String> graph = new Graph<>(vertices,edges);
      System.out.println("*********Printing the Graph*************");
	  graph.printGraph();
	  System.out.println("*********DFS*************");
      graph.dfs("Chicago");
      System.out.println("*********BFS*************");
      graph.bfs("Chicago");
      Integer[] vertices2 = {0,1,2,3,4,5,6};
      int[][] edges2 = {{0,1,6},{0,5,5},
         			{1,0,6},{1,2,10},{1,5,8},{1,6,7},
         			{2,1,10},{2,3,18},{2,4,10},{2,6,5},
         			{3,2,18}, {3,4,8},
         			{4,2,10}, {4,3,8}, {4,5,12}, {4,6,7},
         			{5,0,5}, {5,1,8}, {5,4,12}, {5,6,7},
         			{6,1,7}, {6,2,5}, {6,4,7},{6,5,7}
         	};
   			
      Graph<Integer> graph2 = new Graph<>(vertices2,edges2);
      System.out.println("*********Printing the Graph*************");
      graph.printGraph();
      System.out.println("*********kruskalMST*************");
      graph.kruskalMST();
      System.out.println("*********shortestPath*************");
      graph.shortestPath("Seattle","Miami");
      System.out.println("*********shortestPath*************");
      graph2.shortestPath(0, 3);
      
      
      
   }
}
		
