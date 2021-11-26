package main.ListGraph;
/**
   An interface for the ADT queue.   
   @author Frank M. Carrano
   @author Timothy M. Henry
   @version 5.0
*/
public interface QueueInterface<T>
{
  /** Adds a new entry to the back of this queue.
      @param newEntry  An object to be added. */
  public void enqueue(T newEntry);

  /** Detects whether this queue is empty.
   @return  True if the queue is empty, or false otherwise. */
  public boolean isEmpty();

  /** Removes and returns the entry at the front of this queue.
   @return  The object at the front of the queue.*/
  public T dequeue() throws EmptyQueueException;
} // end QueueInterface
