package main;



public interface GraphInterface<T> {

    /**
     * Creates a number of unconnected, null-labeled vertex
     */
    public void addVertices(int number);

    /**
     * Removes a vertex
     * @param vertex The index of the vertex
     */
    public void removeVertex(int vertex);

    /**
     * Return whether or not the source node has an edge to the target node
     * @param source The node which might have an edge to the target node
     * @param target The node which might have an edge from the source node
     * @return Whether the source has an edge to the target node
     */
    public boolean isEdge(int source, int target);

    /**
     * Add an edge from the source node to the target node, if one does not exist
     * @param source The node the new edge will be from
     * @param target The node the new edge will be to
     */
    public void addEdge(int source, int target);

    /**
     * Remove the edge from the source node to the target node, if one does exist
     * @param source The node the edge to be removed is from
     * @param target The node the edge to be removed is to
     */
    public void removeEdge(int source, int target);

    /**
     * Return a list of all nodes this vertex has an edge to
     * @param vertex The node to whose neighbors will be returned
     * @return A list of all of vertex's neighbors
     */
    public int[] neighbors(int vertex);
    
    /**
     * Return the label of a vertex
     * @param vertex The vertex whose label will be returned
     * @return The label of the vertex
     */
    public T getLabel(int vertex);

    /**
     * Set a vertex's label to a new label
     * @param vertex The vertex whose label will be set
     * @param newLabel The new label
     */
    public void setLabel(int vertex, T newLabel);

    /**
     * Return the number of vertices in the graph
     * @return The number of vertices in the graph
     */
    public int size();

}