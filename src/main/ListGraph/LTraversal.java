package main.ListGraph;

import main.List.List;

public class LTraversal {
    public QueueInterface<Character> depthFirst(ListGraph<Character> graph){
        //Create Queue (holds labels),Stack (holds vertices) and Visited list (holds vertices)
        QueueInterface<Character> traversalOrder = new LinkedQueue<Character>();
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
}
