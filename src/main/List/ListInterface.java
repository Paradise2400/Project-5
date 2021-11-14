package main.List;

public interface ListInterface<T> {

    /**
     * Returns the length of the list
     * @return The length of the list
     */
    public int length();

    /**
     * Returns whether the length of the list is 0
     * @return Whether the list is empty
     */
    public boolean isEmpty();

    /**
     * Adds a new entry T at the end of the list
     * @param newEntry The new entry
     */
    public void add(T newEntry);

    /**
     * Add a new entry T at position newPosition
     * @param newPosition
     * @param newEntry
     */
    public void add(int newPosition, T newEntry);

    /**
     * Removes and returns the entry at givenPosition
     * @param givenPosition The position of the entry to be removed
     * @return The removed entry
     */
    public T remove(int givenPosition);

    /**
     * Replace the value at the given position with a new value
     * @param givenPosition The given position of the entry to be replaced
     * @param newEntry The new entry for the given position
     * @return The replaced entry
     */
    public T replace(int givenPosition, T newEntry);

    /**
     * Clears the list of entries
     */
    public void clear();

    /**
     * Returns the value of the entry
     * @param givenPosition The position of the entry requested
     * @return The entry requested
     */
    public T getEntry(int givenPosition);

    /**
     * Checks the list to see if it contains T as an entry
     * @param anEntry The entry checked for
     * @return If the entry exists in the list
     */
    public boolean contains(T anEntry);

    /**
     * Returns the list as an array
     * @return The list as an array
     */
    public T[] toArray();
}
