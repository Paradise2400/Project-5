package main;

import java.util.*;

public class MatrixGraph<T> implements GraphInterface<T>{
    
    //edges[i][j] is true if there is an edge from node i to node j
    private boolean[][] edges;
    //labels[i] contains the label of node i
    private T[] labels;

    /**
     * Constructor which defines a graph of n unconnected, null-labeled nodes
     * @param n The number of vertices in the graph
     */
    public MatrixGraph(int n) {        
        edges = new boolean[n][n]; // All values initially false        
        labels = (T[]) new Object[n]; // All values initially null
    }

    /**
     * Creates a number of unconnected, null-labeled vertex
     */
    public boolean addVertices(int number){
        //cant remove them w/this
        if (number <= 0) return false;
        //resize array by number
        edges = Arrays.copyOf(edges, edges.length + number);
        labels = Arrays.copyOf(labels, labels.length + number);
        return true;
    }

    /**
     * Removes a vertex
     * @param vertex The index of the vertex
     */
    public boolean removeVertex(int vertex){
        //within bounds
        if (vertex < edges.length) return false;
        //remove the vertex at index vertex
        boolean[][] tempEdges = new boolean[edges.length - 1][edges.length - 1];
        T[] tempLabels = (T[]) new Object[labels.length - 1];
        int i;
        int k;
        for (i = 0; i < vertex; i++) {
            tempLabels[i] = labels[i];
            for (k = 0; k < vertex; k++) {
                tempEdges[i][k] = edges[i][k];
            }
            //skip k = vertex
            for (k = vertex + 1; k < edges.length; k++) {
                tempEdges[i][k - 1] = edges[i][k];
            }
        }
        //skip i = vertex
        for (i = vertex + 1; i < edges.length; i++) {
            tempLabels[i - 1] = labels[i];
            for (k = 0; k < vertex; k++) {
                tempEdges[i - 1][k] = edges[i][k];
            }
            //skip k = vertex
            for (k = vertex + 1; k < edges.length; k++) {
                tempEdges[i - 1][k - 1] = edges[i][k];
            }
        }
        edges = tempEdges;
        labels = tempLabels;
        return true;
    }

    /**
     * Return whether or not the source node has an edge to the target node
     * @param source The node which might have an edge to the target node
     * @param target The node which might have an edge from the source node
     * @return Whether the source has an edge to the target node
     */
    public boolean isEdge(int source, int target){
        return edges[source][target];
    }

    /**
     * Add an edge from the source node to the target node, if one does not exist
     * @param source The node the new edge will be from
     * @param target The node the new edge will be to
     * @return Whether the edge has been added
     */
    public boolean addEdge(int source, int target){
        if (source >= edges.length && target >= edges.length) return false;
        if (edges[source][target] == true) return false;
        edges[source][target] = true;
        return true;
    }

    /**
     * Remove the edge from the source node to the target node, if one does exist
     * @param source The node the edge to be removed is from
     * @param target The node the edge to be removed is to
     * @return Whether the edge has been removed
     */
    public boolean removeEdge(int source, int target){
        if (source >= edges.length && target >= edges.length) return false;
        if (edges[source][target] == false) return false;
        edges[source][target] = false;
        return true;
    }

    /**
     * Return a list of all nodes this vertex has an edge to
     * @param vertex The node to whose neighbors will be returned
     * @return A list of all of vertex's neighbors
     */
    public int[] neighbors(int vertex){
        int i; //index of edges[vertex]
        int k; //length of neighbors and then index
        int[] neighbors; //return array
        for (k = 0, i = 0; i < edges[vertex].length; i++) k++;

        neighbors = new int[k];
        for (k = 0, i = 0; i < edges[vertex].length; i++) {
            if (edges[vertex][i]) {
                neighbors[k] = i;
                k++;
            }
        }
        return neighbors;
    }
    
    /**
     * Return the label of a vertex
     * @param vertex The vertex whose label will be returned
     * @return The label of the vertex
     */
    public T getLabel(int vertex){
        return labels[vertex];
    }

    /**
     * Set a vertex's label to a new label
     * @param vertex The vertex whose label will be set
     * @param newLabel The new label
     * @return Whether the label has been set
     */
    public boolean setLabel(int vertex, T newLabel){
        if (vertex < edges.length) return false;
        labels[vertex] = newLabel;
        return true;
    }

    /**
     * Return the number of vertices in the graph
     * @return The number of vertices in the graph
     */
    public int size(){
        return labels.length;
    }

    /**
     * toString method
     * @return A string representation of the instance
     */
    public String toString() {
        String s = "";
        for (int i = 0; i < edges.length; i++) {
            s += "Vertex " + i + " has edges to ";
            s += edges[i][0];
            for (int k = 1; k < edges[i].length; k++) {
                if (edges[i][k]) {
                    s += ", ";
                    s += k;
                    if (k == edges[i].length - 1) s += " and";
                }
            }
            s += ".\n";
        }
        return s;
    }

}
