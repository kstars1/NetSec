package p2p;

public interface QueueADT<T>
{
   //  Adds one element to the rear of the queue
   public void enqueue (T element);

   //  Removes and returns the element at the front of the queue
   public T dequeue();

   //  Returns without removing the element at the front of the queue
   public T first();
   
   //  Returns true if the queue contains no elements
   public boolean isEmpty();

   //  Returns a string representation of the queue
   public String toString();
}
