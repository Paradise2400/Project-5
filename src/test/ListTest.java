package test;

import main.List.List;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ListTest {

    /*
    Constructor tests 
    no array constructor (default)
    empty array with array constructor
    filled array with array constructor
    */
    @Test
    void testConstructor1() {
        List<Boolean> testList = new List<Boolean>();
        //first node = null
        //length = 0
        assertEquals(0, testList.length());
        assertNull(testList.getEntry(0));
        assertNull(testList.getEntry(1));
    }
    @Test
    void testConstructor2() {
        List<Boolean> testList = new List<Boolean>(new Boolean[] {});
        //first node = null
        //length = 0
        assertEquals(0, testList.length());
        assertNull(testList.getEntry(0));
        assertNull(testList.getEntry(1));
    }
    @Test 
    void testConstructor3() {
        List<Boolean> testList = new List<Boolean>(new Boolean[] {true, false, true, false});
        //first node = (true | (false | (true | (false | null)))) aka (true | node2)
        //length = 4
        assertEquals(4, testList.length());
        assertEquals(true, testList.getEntry(0));
        assertEquals(false, testList.getEntry(1));
        assertEquals(true, testList.getEntry(2));
        assertEquals(false, testList.getEntry(3));
        assertNull(testList.getEntry(4));
    }

    /*
    List.lenghth() tests
    0 in list (0)
    1 in list (1)
    10 in list (10)
    */
    @Test
    void testLength1() {
        List<Boolean> testList = new List<Boolean>();
        assertEquals(0, testList.length());
    }
    @Test
    void testLength2() {
        List<Boolean> testList = new List<Boolean>(new Boolean[] {true});
        assertEquals(1, testList.length());
    }
    @Test
    void testLength3() {
        List<Boolean> testList = new List<Boolean>(new Boolean[] {true, false, true, false, true, true, false, true, false, true});
        assertEquals(10, testList.length());
    }

    /*
    List.isEmpty() tests
    0 in list (true)
    1 in list (false)
    4 in list (false)
    */
    @Test
    void testIsEmpty1() {
        List<Boolean> testList = new List<Boolean>();
        assertTrue(testList.isEmpty());
    }
    @Test
    void testIsEmpty2() {
        List<Boolean> testList = new List<Boolean>(new Boolean[] {true});
        assertFalse(testList.isEmpty());
    }
    @Test
    void testIsEmpty3() {
        List<Boolean> testList = new List<Boolean>(new Boolean[] {true, true, false, true});
        assertFalse(testList.isEmpty());
    }

    /*
    List.add(T newEntry) tests
    Should always be true
    State of list should change
    */
    @Test
    void testAdd() {
        List<Boolean> testList = new List<Boolean>();
        assertTrue(testList.add(true));
    }

    /*
    List.add(int position, T newEntry) tests
    test five cases on lists of 5 elements
    position < 0
    position = 0
    0 < position < length
    position = length
    position > length
    */
    @Test
    void testPositionalAdd1() {
        List<Boolean> testList = new List<Boolean>(new Boolean[] {false, false, false, false, false});
        assertFalse(testList.add(-1, true));
    }
    @Test
    void testPositionalAdd2() {
        List<Boolean> testList = new List<Boolean>(new Boolean[] {false, false, false, false, false});
        assertTrue(testList.add(0, true));
    }
    @Test
    void testPositionalAdd3() {
        List<Boolean> testList = new List<Boolean>(new Boolean[] {false, false, false, false, false});
        assertTrue(testList.add(1, true));
    }
    @Test
    void testPositionalAdd4() {
        List<Boolean> testList = new List<Boolean>(new Boolean[] {false, false, false, false, false});
        assertTrue(testList.add(testList.length(), true));
    }
    @Test
    void testPositionalAdd5() {
        List<Boolean> testList = new List<Boolean>(new Boolean[] {false, false, false, false, false});
        assertFalse(testList.add(testList.length() + 1, true));
    }

    /*
    List.remove(int givenPosition) tests
    test four cases on lists of 5 elements
    position < 0
    position = 0
    0 < position < length
    position => length
    */
    @Test
    void testRemove1() {
        List<Boolean> testList = new List<Boolean>(new Boolean[] {false, false, false, false, false});
        assertNull(testList.remove(-1));
    }
    @Test
    void testRemove2() {
        List<Boolean> testList = new List<Boolean>(new Boolean[] {true, false, true, false, true});
        assertEquals(true, testList.remove(0));
    }
    @Test
    void testRemove3() {
        List<Boolean> testList = new List<Boolean>(new Boolean[] {true, false, true, false, true});
        assertEquals(true, testList.remove(2));
    }
    @Test
    void testRemove4() {
        List<Boolean> testList = new List<Boolean>(new Boolean[] {false, false, false, false, false});
        assertNull(testList.remove(testList.length()  + 3));
    }

    /*
    List.replace(int position, T newEntry)
    position < 0
    position = 0
    0 < position < length
    position >= length
    */
    @Test
    void testReplace1() {
        List<Boolean> testList = new List<Boolean>(new Boolean[] {false, false, false, false, false});
        assertNull(testList.replace(-1, true));
    }
    @Test
    void testReplace2() {
        List<Boolean> testList = new List<Boolean>(new Boolean[] {false, false, false, false, false});
        assertEquals(false, testList.replace(0, true));
    }
    @Test
    void testReplace3() {
        List<Boolean> testList = new List<Boolean>(new Boolean[] {false, false, false, false, false});
        assertEquals(false, testList.replace(2, true));
    }
    @Test
    void testReplace4() {
        List<Boolean> testList = new List<Boolean>(new Boolean[] {false, false, false, false, false});
        assertNull(testList.replace(testList.length() + 1, true));
    }

    /*
    List.clear()
    length = 0
    length > 0
     */
    @Test
    void testClear1() {
        List<Boolean> testList = new List<Boolean>();
        assertFalse(testList.clear());
    }
    @Test
    void testClear2() {
        List<Boolean> testList = new List<Boolean>(new Boolean[] {true, true, true});
        assertTrue(testList.clear());
    }

    /*
    List.getEntry(int position)
    on {0, 1, 2, 3, 4}
    just getting all of them
     */
    @Test
    void testGetEntry1() {
        List<Integer> testList = new List<Integer>(new Integer[] {0, 1, 2, 3, 4});
        assertEquals(0, testList.getEntry(0));
    }
    @Test
    void testGetEntry2() {
        List<Integer> testList = new List<Integer>(new Integer[] {0, 1, 2, 3, 4});
        assertEquals(1, testList.getEntry(1));
    }
    @Test
    void testGetEntry3() {
        List<Integer> testList = new List<Integer>(new Integer[] {0, 1, 2, 3, 4});
        assertEquals(2, testList.getEntry(2));
    }
    @Test
    void testGetEntry4() {
        List<Integer> testList = new List<Integer>(new Integer[] {0, 1, 2, 3, 4});
        assertEquals(3, testList.getEntry(3));
    }
    @Test
    void testGetEntry5() {
        List<Integer> testList = new List<Integer>(new Integer[] {0, 1, 2, 3, 4});
        assertEquals(4, testList.getEntry(4));
    }

    /*
    List.getEntry(int position)
    on {0, 1, 2}
    just getting all of them plus -1 and 3
     */
    @Test
    void testContains1() {
        List<Integer> testList = new List<Integer>(new Integer[] {0, 1, 2});
        assertTrue(testList.contains(0));
    }
    @Test
    void testContains2() {
        List<Integer> testList = new List<Integer>(new Integer[] {0, 1, 2});
        assertTrue(testList.contains(1));
    }
    @Test
    void testContains3() {
        List<Integer> testList = new List<Integer>(new Integer[] {0, 1, 2});
        assertTrue(testList.contains(2));
    }
    @Test
    void testContains4() {
        List<Integer> testList = new List<Integer>(new Integer[] {0, 1, 2});
        assertFalse(testList.contains(-1));
    }
    @Test
    void testContains5() {
        List<Integer> testList = new List<Integer>(new Integer[] {0, 1, 2});
        assertFalse(testList.contains(3));
    }
}
