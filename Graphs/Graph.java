/*
Robert Khalulyan
Project 3
12/04/2022
 */
import java.util.*;
import java.io.*;

public class Graph<V> {

	private List<V> vertices = new ArrayList<>();
	private List<List<Edge>> neighbors = new ArrayList<>(); // Adjacency lists

	private V EdgeToVertex(Edge e)
	{
		return vertices.get(e.v);
	}

	public Graph(V[] vertices, int[][] edges) {
		this.vertices = new ArrayList<>(Arrays.asList(vertices));
		createGraph(this.vertices, edges);
	}

	public void createGraph(List<V> vertices, int[][] edges) {
		for (int i = 0; i < vertices.size(); ++i)
			neighbors.add(new ArrayList<Edge>());

		for (int i = 0; i < edges.length; ++i) {
			neighbors.get(edges[i][0]).add(new WeightedEdge(edges[i][0], edges[i][1], edges[i][2]));
		}

	}

	public void dfs(V startVertex) {
		Stack<V> vertices = new Stack<V>();
		List<V> visited = new ArrayList<V>();
		vertices.push(startVertex);
		visited.add(startVertex);
		while(!vertices.isEmpty())
		{
			V cur = vertices.pop();
			if(!visited.contains(cur)) visited.add(cur);
			for(int i = neighbors.get(getEdgeNum(cur)).size() - 1; i >= 0; i--){

				Edge edge = neighbors.get(getEdgeNum(cur)).get(i);
				if(!visited.contains(EdgeToVertex(edge)))
					vertices.push(EdgeToVertex(edge));
			}
		}
		System.out.println(visited.toString());
	}


	private int getEdgeNum(V vertex){
		for(int i = 0; i < vertices.size(); i++)
		{
			if(vertex == vertices.get(i))
				return i;
		}
		return -1;
	}
	public void bfs(V startVertex) {
		Deque<V> vertices = new ArrayDeque<V>();
		List<V> visited = new ArrayList<V>();
		vertices.add(startVertex);
		visited.add(startVertex);

		while(!vertices.isEmpty()){
			V cur = vertices.poll();
			for(Edge e : neighbors.get(getEdgeNum(cur)))
			{
				if(!visited.contains(EdgeToVertex(e)))
				{
					vertices.add(EdgeToVertex(e));
					visited.add(EdgeToVertex(e));
				}
			}
		}
		System.out.println(visited.toString());
	}

	public void kruskalMST() {
		// TODO

	}

	public void shortestPath(V startVertex, V endVertex) {
		// TODO
	      
	}

	public void printGraph() {
		for (int i = 0; i < vertices.size(); ++i) {
			System.out.print(vertices.get(i) + ":");
			System.out.println(neighbors.get(i));
		}
	}
}
