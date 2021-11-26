package test;

import main.ListGraph.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import main.GraphCreation;


public class ListGraphTraversalTest {
    @Test
    void LTravesalTest() throws EmptyQueueException {
        ListGraph<Character> graph = GraphCreation.createGivenListGraph();
        QueueInterface<Character> result = LTraversal.depthFirst(graph);
        QueueInterface<Character> test = new ArrayQueue<>();
        test.enqueue('A');
        test.enqueue('B');
        test.enqueue('E');
        test.enqueue('F');
        test.enqueue('C');
        test.enqueue('H');
        test.enqueue('I');
        test.enqueue('D');
        test.enqueue('G');
        //Order for both should be ABEFCHIDG
        //Dequeue each to see if they match values
        //Test for A
        assertEquals(test.dequeue(), result.dequeue());
        //Test for B
        assertEquals(test.dequeue(), result.dequeue());
        //Test for E
        assertEquals(test.dequeue(), result.dequeue());
        //Test for F
        assertEquals(test.dequeue(), result.dequeue());
        //Test for C
        assertEquals(test.dequeue(), result.dequeue());
        //Test for H
        assertEquals(test.dequeue(), result.dequeue());
        //Test for I
        assertEquals(test.dequeue(), result.dequeue());
        //Test for D
        assertEquals(test.dequeue(), result.dequeue());
        //Test for F
        assertEquals(test.dequeue(), result.dequeue());
    }

}

