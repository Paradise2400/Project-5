package main;

import main.ListGraph.*;
import main.MatrixGraph.*;
import main.List.*;

public class Main {
    public static void main(String[] args) {
        ListGraph<String> graph = createTestGraph();
        //attempt removal, should be true
        System.out.println(graph);
        graph.removeEdge(0, 0);
        System.out.println(graph);
    }

    static ListGraph<String> createTestGraph() {
        ListGraph<String> graph = new ListGraph<String>();
        graph.addVertices(4);
        //set labels
        graph.setLabel(0, "A");
        graph.setLabel(1, "B");
        graph.setLabel(2, "C");
        graph.setLabel(3, "D");
        //set edges
        graph.addEdge(0, 0);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 0);
        return graph;
    }
}
