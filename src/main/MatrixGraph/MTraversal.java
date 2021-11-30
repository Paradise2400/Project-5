package main.MatrixGraph;

import main.ListGraph.QueueInterface;
import main.ListGraph.ArrayQueue;
import main.ListGraph.EmptyQueueException;
import main.ListGraph.StackInterface;
import main.ListGraph.ResizableArrayStack;
import main.List.List;

/**
 * Class that does Breadth First Traversal and Depth First traversal using 2 Dimensional Boolean Array
 */
public class MTraversal {
    /**
     * 
     * @param graph of type MatrixGraph that incorporates the Adjacency Matrix in a 2 dimensional boolean array
     * @return ArrayQueue holding the characters in order of the depthFirst traversal.
     */
    public static QueueInterface<Character> depthFirst(MatrixGraph<Character> graph){
        //Create Queue (holds labels),Stack (holds vertices) and Visited list (holds vertices)
        QueueInterface<Character> traversalOrder = new ArrayQueue<Character>();
        StackInterface<Integer> vertexStack = new ResizableArrayStack<>(300);
        List<Integer> visited = new List<>();
        //Get label for starting place and push to stack and queue
        char originVertex = graph.getLabel(0);
        vertexStack.push(0);
        traversalOrder.enqueue(originVertex);
        int[] neighbors;

        while(!vertexStack.isEmpty()){
            //Get top of the vertexStack and add it to visited
            int topVertex = vertexStack.peek();
            visited.add(topVertex);
            neighbors = graph.neighbors(topVertex);
            int min = 0;
            //If no more neighbors, pop the stack
            if(neighbors.length == 0)
                vertexStack.pop();
            else {
                //Assign a minimum that isn't visited
                if (!visited.contains(neighbors[0]))
                    min = neighbors[0];
                else {
                    for (int i = 0; i < neighbors.length; i++){
                        if (!visited.contains(neighbors[i])){
                            min = neighbors[i];
                            break;
                        }
                    }
                }
                //Find the smallest of the neighbors that isn't visited
                for (int i = 1; i < neighbors.length; i++) {
                    if (neighbors[i] < min)
                        if (!visited.contains(neighbors[i]))
                            min = neighbors[i];
                }
                //If min isn't visited then add it to the stack and queue, else pop it
                if (!visited.contains(min)){
                    vertexStack.push(min);
                    traversalOrder.enqueue(graph.getLabel(min));
                }
                else
                    vertexStack.pop();
            }
        }
        return traversalOrder;
    }

    /**
     *
     * @param graph of type MatrixGraph that incorporates the Adjacency Matrix in a 2 dimensional boolean array
     * @return ArrayQueue holding the characters in order of the breadthFirst traversal.
     */
    public static QueueInterface<Character> breadthFirst(MatrixGraph<Character> graph) throws EmptyQueueException{
        
        QueueInterface<Character> traversalOrder = new ArrayQueue<Character>(); //Stores the BreadthFirst Traversal order
        QueueInterface<Integer> vertexQueue = new ArrayQueue<>(300); //VertexQueue to store the vertices of which its neighbors need to be found. 
        List<Integer> visited = new List<>(); //Stores the vertices that have been visited. Need to keep track so that the traversal order is a unique queue. 

        char originVertex = graph.getLabel(0); //Obtaining the origin vertex, pre-defined to be the first entry in the graph.
        vertexQueue.enqueue(0); //Adding the origin vertex to the queue to start finding its neighbors.
        traversalOrder.enqueue(originVertex); //Adds the first vertex to the queue i.e. starting point (in map)
        int[] neighbors; //Stores the neighbors of a vertex. 

        while(!vertexQueue.isEmpty())
        {
            int frontVertex = vertexQueue.dequeue(); //BFS done in FIFO so analyzes the neighbors of the first neighbor of the vertex to be added to traversalOrder
            neighbors = graph.neighbors(frontVertex); //Finds the neighbors of the vertex.
            if(neighbors.length != 0)
            {
                for(int i=0; i<neighbors.length; i++) //iterating through the neighbors of the vertex
                {
                    if(!visited.contains(neighbors[i])) //Only if the vertex has not been visited do we proceed.
                    {
                        visited.add(neighbors[i]); //This vertex has now been visited.
                        vertexQueue.enqueue(neighbors[i]); //Adding to vertexQueue so that it can be dequeued later and add its unique neighbots to the traversalOrder
                        traversalOrder.enqueue(graph.getLabel(neighbors[i])); //Adds the unique vertex to the traversalOrder, using getLabel to get the character
                    }
                }
            }
        }

        return traversalOrder;
    }

}
