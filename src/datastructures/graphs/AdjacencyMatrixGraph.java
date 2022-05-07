package datastructures.graphs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Implementation of Undirected Weighted Adjacency Matrix Graph.
 */
public class AdjacencyMatrixGraph {
    
    public int[][] graph;
    public int size;

    /**
     * AdjacencyMatrixGraph Constructor.
     * 
     * @param size the size of the graph.
     */
    public AdjacencyMatrixGraph(int size) {
        this.size = size;
        graph = new int[size][size];
    }

    /**
     * Inserts an edge to the graph.
     * 
     * @param from the first index of the edge.
     * @param to the other index of the edge.
     * @param weight the weight of the edge.
     * @throws IndexOutOfBoundsException if the indices are out of bounds.
     */
    public void addEdge(int from, int to, int weight) {
        try {
            graph[from][to] = weight;
            graph[to][from] = weight;
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    /**
     * Removes an edge from the graph.
     * 
     * @param from the first vertex of the edge.
     * @param to the other vertex of the edge.
     * @throws IndexOutOfBoundsException if the indices are out of bounds.
     */
    public void removeEdge(int from , int to) {
        try {
            graph[from][to] = 0;
            graph[to][from] = 0;
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    /**
     * Gets the weight of an edge.
     * 
     * @param from the first vertex of the edge.
     * @param to the other vertex of the edge.
     * @return the weight of the edge.
     * @throws IndexOutOfBoundsException if the edge does not exist.
     */
    public int getWeight(int from, int to) {
        try {
            return graph[from][to];
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Error: " + e.getMessage());
            return 0;
        }
    }

    /**
     * Displays all vertices using Depth first search traversal of the graph.
     * 
     * @param root the starting vertex to traverse the graph.
     */
    public void dfs(int root) {
        Stack<Integer> s = new Stack<>();
        boolean[] v = new boolean[graph.length];
        for (int i = 0; i < v.length; i++) {
            v[i] = false;
        }
        s.add(root);
        v[root] = true;
        while (!s.isEmpty()) {
            int curr = s.pop();
            System.out.print(curr + " ");
            for (int i =  graph.length-1; i >= 0; i--) {
                if (graph[curr][i] != 0 && v[i] == false) {
                    s.add(i);
                    v[i] = true;
                }
            }
        }
        System.out.println();
    }
    
   /**
    * Displays all vertices using Breadth first search traversal of the graph.
    *
    * @param root the starting vertex to traverse the graph.
    */
    public void bfs(int root) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] v = new boolean[graph.length];
        for (int i = 0; i < v.length; i++) {
            v[i] = false;
        }
        q.add(root);
        v[root] = true;
        while (!q.isEmpty()) {
            int curr = q.poll();
            System.out.print(curr + " ");
            for (int i = 0; i < graph.length; i++) {
                if (graph[curr][i] != 0 && v[i] == false) {
                    q.add(i);
                    v[i] = true;
                }
            }
        }
        System.out.println();
    }
    
    /**
     * Displays the graph.
     * 
     */
    public void printGraph() {
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph.length; j++) {
                System.out.printf("%5d", graph[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        AdjacencyMatrixGraph g = new AdjacencyMatrixGraph(10);
        g.addEdge(0, 2,7);
        g.addEdge(0, 1, 4);
        g.addEdge(0, 4, 3);
        g.addEdge(1, 5, 3);
        g.addEdge(5, 6, 3);
        g.addEdge(5, 7, 3);
        g.addEdge(7, 3, 3);

        g.bfs(0);
        g.dfs(5);

        g.printGraph();
    }

}
