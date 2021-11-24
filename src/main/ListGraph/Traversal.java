package main.ListGraph;

import main.List.List;

public class Traversal {
    public QueueInterface<Character> depthFirst(ListGraph<Character> graph){
        QueueInterface<Character> traversalOrder = new LinkedQueue<Character>();
        StackInterface<Character> vertexStack = new ResizableArrayStack<>(300);
        List<Character> visited = new List<>();
        char originVertex = graph.getLabel(0);
        vertexStack.push(originVertex);
        traversalOrder.enqueue(originVertex);
        int[] neighbors = graph.neighbors(0);
        while(!vertexStack.isEmpty()){
            char topVertex = vertexStack.peek();
            visited.add(topVertex);
            int min = 0;
            if(neighbors.length == 0)
                vertexStack.pop();
            else {
                if (!visited.contains(graph.getLabel(neighbors[0])))
                    min = neighbors[0];
                else {
                    for (int i = 0; i < neighbors.length; i++) {
                        if (!visited.contains(graph.getLabel(neighbors[i]))) {
                            min = neighbors[i];
                            break;
                        }
                    }
                }
                for (int i = 1; i < neighbors.length; i++) {
                    if (neighbors[i] < min)
                        if (!visited.contains(graph.getLabel(neighbors[i])))
                            min = neighbors[i];
                }
                if (!visited.contains(graph.getLabel(min))) {
                    neighbors = graph.neighbors(min);
                    vertexStack.push(graph.getLabel(min));
                    traversalOrder.enqueue(graph.getLabel(min));
                } else
                    vertexStack.pop();
            }
            }
        return traversalOrder;
        }
}
