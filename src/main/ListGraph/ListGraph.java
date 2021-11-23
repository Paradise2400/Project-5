package main.ListGraph;

import main.List.List;
import main.GraphInterface;

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
        for (int i = 0; i < number; i++) edges.add(new List<Integer>());
        return true;
    }

    /**
     * Removes a vertex
     * @param vertex The index of the vertex
     */
    public boolean removeVertex(int vertex){
        if (labels.remove(vertex) == null) return false;
        if (edges.remove(vertex) == null) return false;
        if (vertex >= edges.length()) return false;
        for (int i = 0; i < edges.length(); i++) {
            List<Integer> curList = edges.getEntry(i);
            for (int k = 0; k < curList.length(); k++) {
                if (curList.getEntry(k) == vertex) curList.remove(k);
            }
        }
        return true;
    }

    /**
     * Return whether or not the source node has an edge to the target node
     * @param source The node which might have an edge to the target node
     * @param target The node which might have an edge from the source node
     * @return Whether the source has an edge to the target node
     */
    public boolean isEdge(int source, int target){
        return edges.getEntry(source).contains(target);
    }

    /**
     * Add an edge from the source node to the target node, if one does not exist
     * @param source The node the new edge will be from
     * @param target The node the new edge will be to
     */
    public boolean addEdge(int source, int target){
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
        if (isEdge(source, target)) 
            return (edges.getEntry(source).remove(target) != null);
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
        for (int i = 0; i < retArray.length; i++) {
            //this is incredibly inefficient ////////////////// OPTIMIZE
            retArray[i] = neighbors.getEntry(i);
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
     */
    public int size(){
        return edges.length();
    }

    /**
     * toString method
     * @return A string representation of the instance
     */
    public String toString() {
        String s = "";
        for (int i = 0; i < edges.length(); i++) {
            s += "Vertex " + getLabel(i) + " has edges to ";
            s += edges.getEntry(i).getEntry(0);
            for (int k = 1; k < edges.getEntry(i).length(); k++) {
                s += ", ";
                s += getLabel(k);
                if (k == edges.getEntry(i).length() - 1) s += " and";
            }
            s += ".\n";
        }
        return s;
    }
}
