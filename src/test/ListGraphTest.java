package test;

import main.ListGraph.ListGraph;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Testing methods of list that were created
 */
public class ListGraphTest {
    
    /*
    Constructor tests
    Only one case
    //size() should return 0 (if size() is broken, this acts like it is broken)
    //getLabel(0) should return null
    //no edges
     */
    @Test
    void constructorTest() {
        ListGraph<Boolean> graph = new ListGraph<Boolean>();
        //edges = List<List<Integer>>
        //      edges.firstNode = null   (after addVertices firstNode is another list)
        //      edges.length = 0
        //labels = List<Boolean>
        assertNull(graph.getLabel(0));
        assertFalse(graph.isEdge(0,1));
        assertEquals(0, graph.size());
    }

    /*
    ListGraph.addVertices() test
    add 0
    add 1
    add many
    size() should return the number added (if size() is broken, this acts like it is broken)
    getLabel(each) should return null
    no edges
    */
    @Test
    void addVertexTest1() {
        ListGraph<Boolean> graph = new ListGraph<Boolean>();
        int add = 0;
        graph.addVertices(add);
        assertEquals(add, graph.size());
        for (int i = 0; i < add; i++) {
            assertNull(graph.getLabel(i));
            for (int k = 0; k < add; k++) {
                assertFalse(graph.isEdge(i, k));
            }
        }
    }
    @Test
    void addVertexTest2() {
        ListGraph<Boolean> graph = new ListGraph<Boolean>();
        int add = 1;
        graph.addVertices(add);
        assertEquals(add, graph.size());
        for (int i = 0; i < add; i++) {
            assertNull(graph.getLabel(i));
            for (int k = 0; k < add; k++) {
                assertFalse(graph.isEdge(i, k));
            }
        }
    }
    @Test
    void addVertexTest3() {
        ListGraph<Boolean> graph = new ListGraph<Boolean>();
        int add = 4;
        graph.addVertices(add);
        assertEquals(add, graph.size());
        for (int i = 0; i < add; i++) {
            assertNull(graph.getLabel(i));
            for (int k = 0; k < add; k++) {
                assertFalse(graph.isEdge(i, k));
            }
        }
    }

    /*
    Base graph for further tests
    A through D are nodes
    A to A, B, C    0 to 0, 1, 2
    B to C          1 to 2
    C to D          2 to 3
    D to A          3 to 0
    total edges: 8
    */
    //Matrix Representation
    /*
    1   0   0   1
    1   0   0   0
    1   1   0   0
    0   0   1   0
    */
    ListGraph<String> createTestGraph() {
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

    //Build test
    @Test
    void buildTest() {
        ListGraph<String> graph = createTestGraph();
        //check that it is all right
        //check size == 4
        assertEquals(4, graph.size());
        //4 label checks
        assertEquals("A", graph.getLabel(0));
        assertEquals("B", graph.getLabel(1));
        assertEquals("C", graph.getLabel(2));
        assertEquals("D", graph.getLabel(3));
        //16 edge checks
        assertTrue(graph.isEdge(0,0)); assertFalse(graph.isEdge(1,0)); assertFalse(graph.isEdge(2,0)); assertTrue(graph.isEdge(3,0)); 
        assertTrue(graph.isEdge(0,1)); assertFalse(graph.isEdge(1,1)); assertFalse(graph.isEdge(2,1)); assertFalse(graph.isEdge(3,1)); 
        assertTrue(graph.isEdge(0,2)); assertTrue(graph.isEdge(1,2)); assertFalse(graph.isEdge(2,2)); assertFalse(graph.isEdge(3,2)); 
        assertFalse(graph.isEdge(0,3)); assertFalse(graph.isEdge(1,3)); assertTrue(graph.isEdge(2,3)); assertFalse(graph.isEdge(3,3)); 
    }

    /*
    ListGraph.removeVertex() test
    remove a negative
    remove a non existent vertex
    remove a middle vertex
    remove the first
    remove the last
    remove one then the index of the former last one
    remove two that work
    remove all
    */
    @Test
    void removeVertexTest1() {
        ListGraph<String> graph = createTestGraph();
        //attempt removal, should be false
        assertNull(graph.removeVertex(-5));
        //check size == 4
        assertEquals(4, graph.size());
        //4 label checks
        assertEquals("A", graph.getLabel(0));
        assertEquals("B", graph.getLabel(1));
        assertEquals("C", graph.getLabel(2));
        assertEquals("D", graph.getLabel(3));
        //16 edge checks
        assertTrue(graph.isEdge(0,0)); assertFalse(graph.isEdge(1,0)); assertFalse(graph.isEdge(2,0)); assertTrue(graph.isEdge(3,0)); 
        assertTrue(graph.isEdge(0,1)); assertFalse(graph.isEdge(1,1)); assertFalse(graph.isEdge(2,1)); assertFalse(graph.isEdge(3,1)); 
        assertTrue(graph.isEdge(0,2)); assertTrue(graph.isEdge(1,2)); assertFalse(graph.isEdge(2,2)); assertFalse(graph.isEdge(3,2)); 
        assertFalse(graph.isEdge(0,3)); assertFalse(graph.isEdge(1,3)); assertTrue(graph.isEdge(2,3)); assertFalse(graph.isEdge(3,3)); 
    }
    @Test
    void removeVertexTest2() {
        ListGraph<String> graph = createTestGraph();
        //attempt removal, should be false
        assertNull(graph.removeVertex(5));
        //check size == 4
        assertEquals(4, graph.size());
        //4 label checks
        assertEquals("A", graph.getLabel(0));
        assertEquals("B", graph.getLabel(1));
        assertEquals("C", graph.getLabel(2));
        assertEquals("D", graph.getLabel(3));
        //16 edge checks
        assertTrue(graph.isEdge(0,0)); assertFalse(graph.isEdge(1,0)); assertFalse(graph.isEdge(2,0)); assertTrue(graph.isEdge(3,0)); 
        assertTrue(graph.isEdge(0,1)); assertFalse(graph.isEdge(1,1)); assertFalse(graph.isEdge(2,1)); assertFalse(graph.isEdge(3,1)); 
        assertTrue(graph.isEdge(0,2)); assertTrue(graph.isEdge(1,2)); assertFalse(graph.isEdge(2,2)); assertFalse(graph.isEdge(3,2)); 
        assertFalse(graph.isEdge(0,3)); assertFalse(graph.isEdge(1,3)); assertTrue(graph.isEdge(2,3)); assertFalse(graph.isEdge(3,3)); 
    }
    @Test
    void removeVertexTest3() {
        ListGraph<String> graph = createTestGraph();
        //attempt removal, should be true
        assertEquals("C", graph.removeVertex(2));
        //check size == 3
        assertEquals(3, graph.size());
        //4 label checks
        assertEquals("A", graph.getLabel(0));
        assertEquals("B", graph.getLabel(1));
        assertNull(graph.getLabel(3));
        assertEquals("D", graph.getLabel(2));
        //16 edge checks
        assertTrue(graph.isEdge(0,0)); assertFalse(graph.isEdge(1,0)); assertTrue(graph.isEdge(2,0)); 
        assertTrue(graph.isEdge(0,1)); assertFalse(graph.isEdge(1,1)); assertFalse(graph.isEdge(2,1));  
        assertFalse(graph.isEdge(0,2)); 
        assertFalse(graph.isEdge(1,2)); 
        assertFalse(graph.isEdge(2,2)); 
    }
    @Test
    void removeVertexTest4() {
        ListGraph<String> graph = createTestGraph();
        //attempt removal, should be true
        assertEquals("A", graph.removeVertex(0));
        //check size == 3
        assertEquals(3, graph.size());
        //4 label checks
        assertNull(graph.getLabel(3));
        assertEquals("B", graph.getLabel(0));
        assertEquals("C", graph.getLabel(1));
        assertEquals("D", graph.getLabel(2));
        //16 edge checks
        assertFalse(graph.isEdge(0,0)); 
        assertFalse(graph.isEdge(1,0)); 
        assertFalse(graph.isEdge(2,0)); 
        assertTrue(graph.isEdge(0,1)); assertFalse(graph.isEdge(1,1)); assertFalse(graph.isEdge(2,1)); 
        assertFalse(graph.isEdge(0,2)); assertTrue(graph.isEdge(1,2)); assertFalse(graph.isEdge(2,2)); 
    }
    @Test
    void removeVertexTest5() {
        ListGraph<String> graph = createTestGraph();
        //attempt removal, should be true
        assertEquals("D", graph.removeVertex(3));
        //check size == 3
        assertEquals(3, graph.size());
        //4 label checks
        assertEquals("A", graph.getLabel(0));
        assertEquals("B", graph.getLabel(1));
        assertEquals("C", graph.getLabel(2));
        assertNull(graph.getLabel(3));
        //16 edge checks
        assertTrue(graph.isEdge(0,0)); assertFalse(graph.isEdge(1,0)); assertFalse(graph.isEdge(2,0));
        assertTrue(graph.isEdge(0,1)); assertFalse(graph.isEdge(1,1)); assertFalse(graph.isEdge(2,1));
        assertTrue(graph.isEdge(0,2)); assertTrue(graph.isEdge(1,2)); assertFalse(graph.isEdge(2,2));
    }
    @Test
    void removeVertexTest6() {
        ListGraph<String> graph = createTestGraph();
        //attempt removal, should be true then false
        assertEquals("D", graph.removeVertex(3));
        assertNull(graph.removeVertex(3));
        //check size == 3
        assertEquals(3, graph.size());
        //4 label checks
        assertEquals("A", graph.getLabel(0));
        assertEquals("B", graph.getLabel(1));
        assertEquals("C", graph.getLabel(2));
        //16 edge checks
        assertTrue(graph.isEdge(0,0)); assertFalse(graph.isEdge(1,0)); assertFalse(graph.isEdge(2,0)); 
        assertTrue(graph.isEdge(0,1)); assertFalse(graph.isEdge(1,1)); assertFalse(graph.isEdge(2,1)); 
        assertTrue(graph.isEdge(0,2)); assertTrue(graph.isEdge(1,2)); assertFalse(graph.isEdge(2,2)); 
    }
    @Test
    void removeVertexTest7() {
        ListGraph<String> graph = createTestGraph();
        //attempt removal, should be true and true
        assertEquals("A", graph.removeVertex(0));
        assertEquals("B", graph.removeVertex(0));
        //check size == 2
        assertEquals(2, graph.size());
        //4 label checks
        assertNull(graph.getLabel(2));
        assertNull(graph.getLabel(3));
        assertEquals("C", graph.getLabel(0));
        assertEquals("D", graph.getLabel(1));
        //16 edge checks
        assertFalse(graph.isEdge(0,0)); 
        assertFalse(graph.isEdge(1,0)); 
        assertTrue(graph.isEdge(0,1)); assertFalse(graph.isEdge(1,1)); 
    }
    @Test
    void removeVertexTest8() {
        ListGraph<String> graph = createTestGraph();
        //attempt removal, should be true 4 times
        assertEquals("A", graph.removeVertex(0));
        assertEquals("B", graph.removeVertex(0));
        assertEquals("C", graph.removeVertex(0));
        assertEquals("D", graph.removeVertex(0));
        //check size == 0
        assertEquals(0, graph.size());
        //4 label checks
        assertNull(graph.getLabel(0));
        assertNull(graph.getLabel(1));
        assertNull(graph.getLabel(2));
        assertNull(graph.getLabel(3));
        //no edges
    }

    /*
    ListGraph.isEdge() test
    just checking the createTestGraph graph
    */
    @Test
    void isEdgeTest() {
        ListGraph<String> graph = createTestGraph();
        assertTrue(graph.isEdge(0,0)); assertFalse(graph.isEdge(1,0)); assertFalse(graph.isEdge(2,0)); assertTrue(graph.isEdge(3,0)); 
        assertTrue(graph.isEdge(0,1)); assertFalse(graph.isEdge(1,1)); assertFalse(graph.isEdge(2,1)); assertFalse(graph.isEdge(3,1)); 
        assertTrue(graph.isEdge(0,2)); assertTrue(graph.isEdge(1,2)); assertFalse(graph.isEdge(2,2)); assertFalse(graph.isEdge(3,2)); 
        assertFalse(graph.isEdge(0,3)); assertFalse(graph.isEdge(1,3)); assertTrue(graph.isEdge(2,3)); assertFalse(graph.isEdge(3,3)); 
    }

    /*
    ListGraph.addEdge() test
    both existent
    both existent, but already an edge
    1 existent 1 not
    neither
    */
    @Test
    void addEdgeTest1() {
        ListGraph<String> graph = createTestGraph();
        //add edge between 0 and 3
        assertTrue(graph.addEdge(0, 3));
        //16 edge checks
        assertTrue(graph.isEdge(0,0)); assertFalse(graph.isEdge(1,0)); assertFalse(graph.isEdge(2,0)); assertTrue(graph.isEdge(3,0)); 
        assertTrue(graph.isEdge(0,1)); assertFalse(graph.isEdge(1,1)); assertFalse(graph.isEdge(2,1)); assertFalse(graph.isEdge(3,1)); 
        assertTrue(graph.isEdge(0,2)); assertTrue(graph.isEdge(1,2)); assertFalse(graph.isEdge(2,2)); assertFalse(graph.isEdge(3,2)); 
        assertTrue(graph.isEdge(0,3)); assertFalse(graph.isEdge(1,3)); assertTrue(graph.isEdge(2,3)); assertFalse(graph.isEdge(3,3)); 
    }
    @Test
    void addEdgeTest2() {
        ListGraph<String> graph = createTestGraph();
        //add edge between 0 and non vertex
        assertFalse(graph.addEdge(0, 0));
        //16 edge checks
        assertTrue(graph.isEdge(0,0)); assertFalse(graph.isEdge(1,0)); assertFalse(graph.isEdge(2,0)); assertTrue(graph.isEdge(3,0)); 
        assertTrue(graph.isEdge(0,1)); assertFalse(graph.isEdge(1,1)); assertFalse(graph.isEdge(2,1)); assertFalse(graph.isEdge(3,1)); 
        assertTrue(graph.isEdge(0,2)); assertTrue(graph.isEdge(1,2)); assertFalse(graph.isEdge(2,2)); assertFalse(graph.isEdge(3,2)); 
        assertFalse(graph.isEdge(0,3)); assertFalse(graph.isEdge(1,3)); assertTrue(graph.isEdge(2,3)); assertFalse(graph.isEdge(3,3)); 
    }
    @Test
    void addEdgeTest3() {
        ListGraph<String> graph = createTestGraph();
        //add edge between 0 and non vertex
        assertFalse(graph.addEdge(0, 7));
        //16 edge checks
        assertTrue(graph.isEdge(0,0)); assertFalse(graph.isEdge(1,0)); assertFalse(graph.isEdge(2,0)); assertTrue(graph.isEdge(3,0)); 
        assertTrue(graph.isEdge(0,1)); assertFalse(graph.isEdge(1,1)); assertFalse(graph.isEdge(2,1)); assertFalse(graph.isEdge(3,1)); 
        assertTrue(graph.isEdge(0,2)); assertTrue(graph.isEdge(1,2)); assertFalse(graph.isEdge(2,2)); assertFalse(graph.isEdge(3,2)); 
        assertFalse(graph.isEdge(0,3)); assertFalse(graph.isEdge(1,3)); assertTrue(graph.isEdge(2,3)); assertFalse(graph.isEdge(3,3)); 
    }
    @Test
    void addEdgeTest4() {
        ListGraph<String> graph = createTestGraph();
        //add edge between two non vertices
        assertFalse(graph.addEdge(-1, 7));
        //16 edge checks
        assertTrue(graph.isEdge(0,0)); assertFalse(graph.isEdge(1,0)); assertFalse(graph.isEdge(2,0)); assertTrue(graph.isEdge(3,0)); 
        assertTrue(graph.isEdge(0,1)); assertFalse(graph.isEdge(1,1)); assertFalse(graph.isEdge(2,1)); assertFalse(graph.isEdge(3,1)); 
        assertTrue(graph.isEdge(0,2)); assertTrue(graph.isEdge(1,2)); assertFalse(graph.isEdge(2,2)); assertFalse(graph.isEdge(3,2)); 
        assertFalse(graph.isEdge(0,3)); assertFalse(graph.isEdge(1,3)); assertTrue(graph.isEdge(2,3)); assertFalse(graph.isEdge(3,3)); 
    }

    /*
    ListGraph.removeEdge() test
    remove an existent edge
    try to remove a non-edge
    try to remove from one nonexistent vertex
    try to remove from two nonexistent vertices
    */
    @Test
    void removeEdgeTest1() {
        ListGraph<String> graph = createTestGraph();
        assertTrue(graph.removeEdge(0, 0));
        //16 edge checks
        assertFalse(graph.isEdge(0,0)); 
        assertFalse(graph.isEdge(1,0)); assertFalse(graph.isEdge(2,0)); assertTrue(graph.isEdge(3,0)); 
        assertTrue(graph.isEdge(0,1)); assertFalse(graph.isEdge(1,1)); assertFalse(graph.isEdge(2,1)); assertFalse(graph.isEdge(3,1)); 
        assertTrue(graph.isEdge(0,2)); assertTrue(graph.isEdge(1,2)); assertFalse(graph.isEdge(2,2)); assertFalse(graph.isEdge(3,2)); 
        assertFalse(graph.isEdge(0,3)); assertFalse(graph.isEdge(1,3)); assertTrue(graph.isEdge(2,3)); assertFalse(graph.isEdge(3,3)); 
    }
    @Test
    void removeEdgeTest2() {
        ListGraph<String> graph = createTestGraph();
        assertFalse(graph.removeEdge(1, 0));
        //16 edge checks
        assertTrue(graph.isEdge(0,0)); assertFalse(graph.isEdge(1,0)); assertFalse(graph.isEdge(2,0)); assertTrue(graph.isEdge(3,0)); 
        assertTrue(graph.isEdge(0,1)); assertFalse(graph.isEdge(1,1)); assertFalse(graph.isEdge(2,1)); assertFalse(graph.isEdge(3,1)); 
        assertTrue(graph.isEdge(0,2)); assertTrue(graph.isEdge(1,2)); assertFalse(graph.isEdge(2,2)); assertFalse(graph.isEdge(3,2)); 
        assertFalse(graph.isEdge(0,3)); assertFalse(graph.isEdge(1,3)); assertTrue(graph.isEdge(2,3)); assertFalse(graph.isEdge(3,3)); 
    }
    @Test
    void removeEdgeTest3() {
        ListGraph<String> graph = createTestGraph();
        assertFalse(graph.removeEdge(0, -2));
        //16 edge checks
        assertTrue(graph.isEdge(0,0)); assertFalse(graph.isEdge(1,0)); assertFalse(graph.isEdge(2,0)); assertTrue(graph.isEdge(3,0)); 
        assertTrue(graph.isEdge(0,1)); assertFalse(graph.isEdge(1,1)); assertFalse(graph.isEdge(2,1)); assertFalse(graph.isEdge(3,1)); 
        assertTrue(graph.isEdge(0,2)); assertTrue(graph.isEdge(1,2)); assertFalse(graph.isEdge(2,2)); assertFalse(graph.isEdge(3,2)); 
        assertFalse(graph.isEdge(0,3)); assertFalse(graph.isEdge(1,3)); assertTrue(graph.isEdge(2,3)); assertFalse(graph.isEdge(3,3)); 
    }
    @Test
    void removeEdgeTest4() {
        ListGraph<String> graph = createTestGraph();
        assertFalse(graph.removeEdge(82, -2));
        //16 edge checks
        assertTrue(graph.isEdge(0,0)); assertFalse(graph.isEdge(1,0)); assertFalse(graph.isEdge(2,0)); assertTrue(graph.isEdge(3,0)); 
        assertTrue(graph.isEdge(0,1)); assertFalse(graph.isEdge(1,1)); assertFalse(graph.isEdge(2,1)); assertFalse(graph.isEdge(3,1)); 
        assertTrue(graph.isEdge(0,2)); assertTrue(graph.isEdge(1,2)); assertFalse(graph.isEdge(2,2)); assertFalse(graph.isEdge(3,2)); 
        assertFalse(graph.isEdge(0,3)); assertFalse(graph.isEdge(1,3)); assertTrue(graph.isEdge(2,3)); assertFalse(graph.isEdge(3,3)); 
    }

    /*
    ListGraph.neighbors() test
    checks if each list for each vertex is correct
    A -> A, B, C
    B -> C
    C -> D
    D -> A
    */
    @Test
    void neighborsTest() {
        ListGraph<String> graph = createTestGraph();
        int[] expectedArray = new int[] {0, 1, 2};
        assertArrayEquals(expectedArray, graph.neighbors(0));
        expectedArray = new int[] {2};
        assertArrayEquals(expectedArray, graph.neighbors(1));
        expectedArray = new int[] {3};
        assertArrayEquals(expectedArray, graph.neighbors(2));
        expectedArray = new int[] {0};
        assertArrayEquals(expectedArray, graph.neighbors(3));
    }

    /*
    ListGraph.getLabel() test
    1 checks labels are there
    2 checks non-vertices
    */
    @Test
    void getLabelTest1() {
        ListGraph<String> graph = createTestGraph();
        //4 label checks
        assertEquals("A", graph.getLabel(0));
        assertEquals("B", graph.getLabel(1));
        assertEquals("C", graph.getLabel(2));
        assertEquals("D", graph.getLabel(3));
    }
    @Test
    void getLabelTest2() {
        ListGraph<String> graph = createTestGraph();
        //4 label checks
        assertNull(graph.getLabel(4));
    }

    /*
    ListGraph.setLabel() test
    1 checks setting each label
    2 checks setting non existent vertices
    */
    @Test
    void setLabelTest1() {
        ListGraph<String> graph = createTestGraph();

        graph.setLabel(0, "A as in Apple");
        graph.setLabel(1, "B as in Boy");
        graph.setLabel(2, "C as in Cat");
        graph.setLabel(3, "D as in Dog");

        assertEquals("A as in Apple", graph.getLabel(0));
        assertEquals("B as in Boy", graph.getLabel(1));
        assertEquals("C as in Cat", graph.getLabel(2));
        assertEquals("D as in Dog", graph.getLabel(3));
    }
    @Test
    void setLabelTest2() {
        ListGraph<String> graph = createTestGraph();

        graph.setLabel(-1, "A as in Apple");
        graph.setLabel(-2, "B as in Boy");
        graph.setLabel(5, "C as in Cat");
        graph.setLabel(12, "D as in Dog");

        assertEquals("A", graph.getLabel(0));
        assertEquals("B", graph.getLabel(1));
        assertEquals("C", graph.getLabel(2));
        assertEquals("D", graph.getLabel(3));

    }

    /*
    ListGraph.size() test
    test an empty graph and filled graph
    */
    @Test
    void sizeTest1() {
        ListGraph<String> graph = createTestGraph();
        assertEquals(4, graph.size());
    }
    @Test
    void sizeTest2() {
        ListGraph<String> graph = new ListGraph<String>();
        assertEquals(0, graph.size());
    }
}
