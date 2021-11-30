package test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import main.MatrixGraph.MatrixGraph;
import main.ListGraph.ListGraph;
import main.GraphCreation;

/**
 * Testing the linked list graph and 2D array graph that were implemented
 */
public class MainTest {
    @Test
    void createMatrixGraphTest() {
        MatrixGraph<Character> graph = GraphCreation.createGivenMatrixGraph();

        //check size
        assertEquals(9, graph.size());
        
        //check labels
        assertEquals('A',graph.getLabel(0));
        assertEquals('B',graph.getLabel(1));
        assertEquals('C',graph.getLabel(2));
        assertEquals('D',graph.getLabel(3));
        assertEquals('E',graph.getLabel(4));
        assertEquals('F',graph.getLabel(5));
        assertEquals('G',graph.getLabel(6));
        assertEquals('H',graph.getLabel(7));
        assertEquals('I',graph.getLabel(8));

        //check edges
        assertTrue(graph.isEdge(0, 1));
        assertTrue(graph.isEdge(0, 3));
        assertTrue(graph.isEdge(0, 4));
        assertTrue(graph.isEdge(1, 4));
        assertTrue(graph.isEdge(2, 1));
        assertTrue(graph.isEdge(3, 6));
        assertTrue(graph.isEdge(4, 5));
        assertTrue(graph.isEdge(4, 7));
        assertTrue(graph.isEdge(5, 7));
        assertTrue(graph.isEdge(6, 7));
        assertTrue(graph.isEdge(7, 8));
        assertTrue(graph.isEdge(8, 5));
    }

    @Test
    void createListGraphTest() {
        ListGraph<Character> graph = GraphCreation.createGivenListGraph();

        //check size
        assertEquals(9, graph.size());
        
        //check labels
        assertEquals('A',graph.getLabel(0));
        assertEquals('B',graph.getLabel(1));
        assertEquals('C',graph.getLabel(2));
        assertEquals('D',graph.getLabel(3));
        assertEquals('E',graph.getLabel(4));
        assertEquals('F',graph.getLabel(5));
        assertEquals('G',graph.getLabel(6));
        assertEquals('H',graph.getLabel(7));
        assertEquals('I',graph.getLabel(8));

        //check edges
        assertTrue(graph.isEdge(0, 1));
        assertTrue(graph.isEdge(0, 3));
        assertTrue(graph.isEdge(0, 4));
        assertTrue(graph.isEdge(1, 4));
        assertTrue(graph.isEdge(2, 1));
        assertTrue(graph.isEdge(3, 6));
        assertTrue(graph.isEdge(4, 5));
        assertTrue(graph.isEdge(4, 7));
        assertTrue(graph.isEdge(5, 7));
        assertTrue(graph.isEdge(6, 7));
        assertTrue(graph.isEdge(7, 8));
        assertTrue(graph.isEdge(8, 5));
    }
}
