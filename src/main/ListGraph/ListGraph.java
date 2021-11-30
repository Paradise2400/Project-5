package main.ListGraph;

import main.List.List;
import main.GraphInterface;

/**
 * A class that implements a graph in th Adjacency List
 * @param <T> any inherited object from superclass Object
 */
public class ListGraph<T> implements GraphInterface<T>{

    List<List<Integer>> edges;
    List<T> labels;

    public ListGraph() {
        edges = new List<List<Integer>>();
        labels = new List<T>();
    }

    /**
     * Creates a number of unconnected, null-labeled vertex
     */
    public boolean addVertices(int number){
        for (int i = 0; i < number; i++) {
            edges.add(new List<Integer>());
            labels.add(null);
        }
        return true;
    }

    /**
     * Removes a vertex
     * @param vertex The index of the vertex
     * @return The removed vertex's label
     */
    public T removeVertex(int vertex){
        if (vertex < 0) return null;
        if (vertex >= size()) return null;
        //pop label
        T data = labels.remove(vertex);
        //remove vertex list
        edges.remove(vertex);
        //remove number from vertex list; if number is greater: decrement entry
        for (int i = 0; i < edges.length(); i++) {
            List<Integer> entry = edges.getEntry(i);
            for (int k = 0; k < entry.length(); k++) {
                int edge = entry.getEntry(k);
                if (edge == vertex) {
                    entry.remove(k);
                } else if (edge > vertex) {
                    entry.replace(k, edge - 1);
                }
            }
        }
        return data;
    }

    /**
     * Return whether or not the source node has an edge to the target node
     * @param source The node which might have an edge to the target node
     * @param target The node which might have an edge from the source node
     * @return Whether the source has an edge to the target node
     */
    public boolean isEdge(int source, int target){
        if (edges.getEntry(source) == null) return false;
        return edges.getEntry(source).contains(target);
    }

    /**
     * Add an edge from the source node to the target node, if one does not exist
     * @param source The node the new edge will be from
     * @param target The node the new edge will be to
     */
    public boolean addEdge(int source, int target){
        if (edges.getEntry(source) == null) return false;
        if (edges.getEntry(target) == null) return false;
        if (!isEdge(source, target))
            return edges.getEntry(source).add(target);
        return false;
    }   

    /**
     * Remove the edge from the source node to the target node, if one does exist
     * @param source The node the edge to be removed is from
     * @param target The node the edge to be removed is to
     */
    public boolean removeEdge(int source, int target){
        if (isEdge(source, target)) {
            List<Integer> sourceEntry = edges.getEntry(source);
            for (int i = 0; i < sourceEntry.length(); i++) {
                if (sourceEntry.getEntry(i) == target) sourceEntry.remove(i);
            }
            return true;
        }
        return false;
    }

    /**
     * Return a list of all nodes this vertex has an edge to
     * @param vertex The node to whose neighbors will be returned
     * @return A list of all of vertex's neighbors
     */
    public int[] neighbors(int vertex){
        List<Integer> neighbors = edges.getEntry(vertex);
        int[] retArray = new int[neighbors.length()];
        for (int i = neighbors.length() - 1; i >= 0; i--) {
            //this is incredibly inefficient ////////////////// OPTIMIZE
            retArray[neighbors.length() - i - 1] = neighbors.getEntry(i);
        }
        return retArray;
    }
    
    /**
     * Return the label of a vertex
     * @param vertex The vertex whose label will be returned
     * @return The label of the vertex
     */
    public T getLabel(int vertex){
        return labels.getEntry(vertex);
    }

    /**
     * Set a vertex's label to a new label
     * @param vertex The vertex whose label will be set
     * @param newLabel The new label
     */
    public boolean setLabel(int vertex, T newLabel){
        return (labels.replace(vertex, newLabel) == null);
    }

    /**
     * Return the number of vertices in the graph
     * @return The number of vertices in the graph
     * @throws Exception
     */
    public int size(){
        if (labels.length() != edges.length()) return -1;
        return labels.length();
    }

    /**
     * toString method
     * @return A string representation of the instance
     */
    public String toString() {
        String s = "";
        for (int i = 0; i < edges.length(); i++) {
            List<Integer> entry = edges.getEntry(i);
            s += "Vertex " + getLabel(i) + " has edges to ";
            if (entry.length() == 0) {
                s += "no other vertices.\n";
                continue;
            }
            for (int k = 0; k < entry.length(); k++) {
                s += "" + labels.getEntry(entry.getEntry(k));
                if (k < entry.length() - 1) s += ", ";
            }
            s += ".\n";
        }
        return s;
    }
}
