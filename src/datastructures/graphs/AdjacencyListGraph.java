package datastructures.graphs;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Queue;

/**
 * Implementation of unweighted undirected adjacency list graph.
 */
public class AdjacencyListGraph <T> {

    /* store vertex and corresponding edges */
    HashMap<T, HashSet<T>> vertices; 
    /* to check visited vertices dfs and bfs traversal */
    Map<T, Boolean> visited;
    private int numOfEdges;

    /**
     * AdjacencyListGraph constructors 
     */
    public AdjacencyListGraph() {
        vertices = new HashMap<>();
        visited = new HashMap<>();
        numOfEdges = 0;
    }

    /**
     * adds undirected edge to the graph
     * @param vertex1 the first vertex of the edge
     * @param vertex2 the second vertex of the edge
     */
    public void addEdge(T vertex1, T vertex2) {
        // insert first vertex
        if (vertices.containsKey(vertex1)) {
            HashSet<T> newVertex = vertices.get(vertex1);
            newVertex.add(vertex2);
            vertices.put(vertex1, newVertex);
        } else {
            HashSet<T> adjVertex = new HashSet<>(Arrays.asList(vertex2));
            vertices.put(vertex1, adjVertex);
        }
        // insert second vertex
        if (vertices.containsKey(vertex2)) {
            HashSet<T> newVertex = vertices.get(vertex2);
            newVertex.add(vertex1);
            vertices.put(vertex2, newVertex);
        } else {
            HashSet<T> adjVertex = new HashSet<>(Arrays.asList(vertex1));
            vertices.put(vertex2, adjVertex);
        }
        visited.put(vertex1, false);
        visited.put(vertex2, false);
        numOfEdges++;
    }

    /**
     * removes an edge from the graph given two vertices
     * @param vertex1 the first vertex of the edge to be removed
     * @param vertex2 the second vertex of the edge to be removed
     */
    public void removeEdge(int vertex1, int vertex2) {
        // remove first vertex and second vertex
        HashSet<T> firstVertexAdjacent;
        HashSet<T> secondVertexAdjacent;
        if (vertices.containsKey(vertex1) && vertices.containsKey(vertex2)) {
            firstVertexAdjacent = vertices.get(vertex1);
            secondVertexAdjacent = vertices.get(vertex2);
            if (firstVertexAdjacent.contains(vertex2)) {
                firstVertexAdjacent.remove(vertex2);
            }
            if (secondVertexAdjacent.contains(vertex1)) {
                secondVertexAdjacent.remove(vertex1);
            }
            numOfEdges--;
        }
    }

    /**
     * adds vertex to the graph
     * @param vertex the vertex to be inserted
     */
    public void addVertex(T vertex) {
        vertices.put(vertex, null);
    }

    /**
     * removed a vertex from the graph
     * @param vertex the vertex to be removed 
     */
    public void removeVertex(T vertex) {
        if (vertices.containsKey(vertex)) {
            vertices.forEach((key, set) -> {
                set.remove(vertex);
            });
        }
        vertices.remove(vertex);
    }

    /**
     * displays all vertices using dfs algorithm
     * @param vertex the starting vertex to traverse the graph
     */
    public void depthFirstSearch(T vertex) {
        if (vertices.containsKey(vertex)) {
            visited.put(vertex, true);
            System.out.print(vertex+" ");
            HashSet<T> currSet = vertices.get(vertex);
            for (T v : currSet) {
                if (!visited.get(v)) {
                    depthFirstSearch(v);
                }
            }
        } else {
            System.out.println("CANNOT TRAVERSE VERTEX DOES NOT EXISTS!");
            return;
        }
    }

    /**
     * display all vertices using bfs algorithms
     * @param vertex the starting vertex to traverse the graph
     */
    public void breadthFirstSearch(T vertex) {
        Queue<T> q = new ArrayDeque<T>();
        if (vertices.containsKey(vertex)) {
            q.add(vertex);
            visited.put(vertex, true);
            while (!q.isEmpty()) {
                T v = q.remove();
                System.out.print(v+" ");
                for (T i : vertices.get(v)) {
                    if (!visited.get(i)) {
                        q.add(i);
                        visited.put(i, true);
                    }
                }
            }
        } else {
            System.out.println("CANNOT TRAVERSE VERTEX DOES NOT EXISTS!");
            return;
        }
    }
    
    /**
     * checks if a vertex exists in the graph 
     * @param vertex the vertex to be checked for existence
     * @return true if vertex exist : false if vertex DNE
     */
    public boolean vertexExists(int vertex) {
        return vertices.containsKey(vertex);
    }

    /**
     * returns the number of edges in the graph
     * @return the number of edges in the graph
     */
    public int getNumOfEdges() {
        return numOfEdges;
    }

    /**
     * returns the number of vertices in the graph
     * @return the number of vertices in the graph
     */
    public int getNumOfVertices() {
        return vertices.size();
    }

    /**
     * displays the adjacency list representation of the graph
     */
    public void printGraph() {
        vertices.forEach((key, set) -> {
            System.out.println(key+" -> "+set);
        });
    }

    /**
     * checks if there is any vertices in the graph
     * @return true if no vertex found : false if there exist a vertex
     */
    public boolean isEmpty() {
        return vertices.size() == 0;
    }

    public static void main(String[] args) {
        AdjacencyListGraph<Integer> g = new AdjacencyListGraph<Integer>();
        g.addEdge(2, 1);
        g.addEdge(2, 3);
        g.addEdge(5, 2);
        g.addEdge(5, 6);
        g.addEdge(3, 6);

        g.printGraph();
        g.depthFirstSearch(5);
        g.removeVertex(3);
        System.out.println();
        g.printGraph();
    }
}
