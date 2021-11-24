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
} // end QueueInterface
