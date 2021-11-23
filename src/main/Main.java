package main;

import main.ListGraph.*;
import main.MatrixGraph.*;

public class Main {
    public static void main(String[] args) {
        MatrixGraph<Character> graph1 = new MatrixGraph<Character>();
        createGraph(graph1);
        ListGraph<Character> graph2 = new ListGraph<Character>();
        createGraph(graph2);
        System.out.println("Matrix Graph");
        System.out.println(graph1);
        System.out.println("List Graph");
        System.out.println(graph2);
    }

    public static void createGraph(GraphInterface<Character> emptyGraph) {
        //Create the following graph
        //Adjacency Matrix Representation
        /*              from
            A   B   C   D   E   F   G   H   I
        A   0   0   0   0   0   0   0   0   0
        B   1   0   1   0   0   0   0   0   0
        C   0   0   0   0   0   1   0   0   0
        D   1   0   0   0   0   0   0   0   0
    to  E   1   1   0   0   0   0   0   0   0
        F   0   0   0   0   1   0   0   0   1
        G   0   0   0   1   0   0   0   0   0
        H   0   0   0   0   1   1   1   0   0
        I   0   0   0   0   0   0   0   1   0
        */
        //Adjacency List Representation
        /*          from
        A | B | C | D | E | F | G | H | I
        --+---+---+---+---+---+---+---+---|
        B | E | B | G | F | C | H | I | F |
    to  D |           | H | H |           |
        E |
        */
        //set labels
        emptyGraph.setLabel(0, 'A');
        emptyGraph.setLabel(1, 'B');
        emptyGraph.setLabel(2, 'C');
        emptyGraph.setLabel(3, 'D');
        emptyGraph.setLabel(4, 'E');
        emptyGraph.setLabel(5, 'F');
        emptyGraph.setLabel(6, 'G');
        emptyGraph.setLabel(7, 'H');
        emptyGraph.setLabel(8, 'I');
        //add edges for 0 aka 'A'
        emptyGraph.addEdge(0, 1);
        emptyGraph.addEdge(0, 3);
        emptyGraph.addEdge(0, 4);
        //add edges for 1 aka 'B'
        emptyGraph.addEdge(1, 4);
        //add edges for 2 aka 'C'
        emptyGraph.addEdge(2, 1);
        //add edges for 3 aka 'D'
        emptyGraph.addEdge(3, 6);
        //add edges for 4 aka 'E'
        emptyGraph.addEdge(4, 5);
        emptyGraph.addEdge(4, 7);
        //add edges for 5 aka 'F'
        emptyGraph.addEdge(5, 2);
        emptyGraph.addEdge(5, 7);
        //add edges for 6 aka 'G'
        emptyGraph.addEdge(6, 7);
        //add edges for 7 aka 'H'
        emptyGraph.addEdge(7, 8);
        //add edges for 8 aka 'I'
        emptyGraph.addEdge(8, 5);
        //emptyGraph now has the predetermined graph represented in it
    }
}
