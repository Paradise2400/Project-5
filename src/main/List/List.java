package main.List;

import java.util.ArrayList;

public class List<T> {

    Node<T> firstNode;
    int length;

    public List() {
        firstNode = null;
        length = 0;
    }

    public List(T[] array) {
        //go backwards because privateAdd() and add() add to front
        firstNode = null;
        length = array.length;
        for (int i = length - 1; i >= 0; i--) {
            privateAdd(array[i]);
        }
    }

    /**
     * Returns the length of the list
     * @return The length of the list
     */
    public int length(){
        return length;
    }

    /**
     * Returns whether the length of the list is 0
     * @return Whether the list is empty
     */
    public boolean isEmpty(){
        return length == 0;
    }

    /**
     * Adds a new entry T at the beginning of the list
     * @param newEntry The new entry
     */
    public boolean add(T newEntry){
        length++;
        return privateAdd(newEntry);
    }

    /**
     * Adds a new entry T at the beginning of the list without iterating length, used in public add method and constructor
     * @param newEntry The new entry
     */
    private boolean privateAdd(T newEntry){
        firstNode = new Node<T>(newEntry, firstNode);
        return true;
    }

    /**
     * Add a new entry T at position newPosition
     * @param newPosition Position of the new entry
     * @param newEntry The new entry
     */
    public boolean add(int newPosition, T newEntry){
        if (newPosition > length) return false;
        if (newPosition < 0) return false;
        Node<T> posNode = firstNode;
        if (newPosition == length) {
            //iterate to last node, make last.next
            for (int i = 0; i < newPosition - 1; i++) posNode = posNode.next;
            posNode.next = new Node<T>(newEntry, null);
            length++;
        } else {
            for (int i = 0; i < newPosition; i++) posNode = posNode.next;
            posNode = new Node<T>(newEntry, posNode);
            length++;
        }
        length++;
        return true;
    }

    /**
     * Removes and returns the entry at givenPosition
     * @param givenPosition The position of the entry to be removed
     * @return The removed entry
     */
    public T remove(int givenPosition){
        if (givenPosition >= length) return null;
        if (givenPosition < 0) return null;
        Node<T> posNode = firstNode;
        for (int i = 0; i < givenPosition; i++) posNode = posNode.next;
        T retData = posNode.data;
        posNode = posNode.next;
        return retData;
    }

    /**
     * Replace the value at the given position with a new value
     * @param givenPosition The given position of the entry to be replaced
     * @param newEntry The new entry for the given position
     * @return The replaced entry
     */
    public T replace(int givenPosition, T newEntry){
        if (givenPosition >= length) return null;
        if (givenPosition < 0) return null;
        Node<T> posNode = firstNode;
        for (int i = 0; i < givenPosition; i++) posNode = posNode.next;
        T retData = posNode.data;
        posNode.data = newEntry;
        return retData;
    }

    /**
     * Clears the list of entries
     */
    public boolean clear(){
        if (firstNode == null) return false;
        //leave it for the gc
        firstNode = null;
        return true;
    }

    /**
     * Returns the value of the entry
     * @param givenPosition The position of the entry requested
     * @return The entry requested
     */
    public T getEntry(int givenPosition){
        if (givenPosition >= length) return null;
        if (givenPosition < 0) return null;
        Node<T> posNode = firstNode;
        for (int i = 0; i < givenPosition; i++) posNode = posNode.next;
        return posNode.data;
    }

    /**
     * Checks the list to see if it contains T as an entry
     * @param anEntry The entry checked for
     * @return If the entry exists in the list
     */
    public boolean contains(T anEntry){
        Node<T> curNode = firstNode;
        for (int i = 0; i < length; i++) {
            if (curNode.data == anEntry) return true;
            curNode = curNode.next;
        }
        return false;
    }

    public String toString() {
        return "[" + firstNode + "]";
    }
    
    private class Node<G>{
        G data;
        Node<G> next;
        public Node(G data, Node<G> next) {
            this.data = data;
            this.next = next;
        }
        public String toString() {
            if (next == null) {
                return "" + data;
            } else {
                return data + ", " + next;
            }
        }
    }
}
