package main.ListGraph;
public class Traversal {
    public QueueInterface<Character> depthFirst(ListGraph<Character> graph){
    QueueInterface<Character> traversalOrder = new LinkedQueue<Character>();
    StackInterface<Character> vertexStack = new ResizableArrayStack<>(300);
    String visited[];
    char originVertex = graph.getLabel(0);
    vertexStack.push(originVertex);
    traversalOrder.enqueue(originVertex);
    while(!vertexStack.isEmpty()){

    }
    }
}
