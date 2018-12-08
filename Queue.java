package p2p;

//Class: Queue implements 
//Interface: QueueADT 
//Array-based implementation 

public class Queue<T> implements QueueADT<T> { 
    private int maxQueueSize; 
    private int count; 
    private int queueFront; 
    private int queueRear; 
    private T[] list;  //Array of references to the objects that store queue elements
    
    //Default constructor 
    public Queue() { 
        maxQueueSize = 100; 
        queueFront = 0; 
        queueRear = maxQueueSize - 1; 
        count = 0; 
        list = (T[]) new Object[maxQueueSize]; 
    }

    //Alternate constructor 
    public Queue(int queueSize) { 
        if (queueSize <= 0) { 
            System.err.println("The size must be positive."); 
            System.err.println("Creating an array with size 100."); 
            maxQueueSize = 100; 
        } 
        else 
            maxQueueSize = queueSize; 
        queueFront = 0; 
        queueRear = maxQueueSize - 1; 
        count = 0; 
        list = (T[]) new Object[maxQueueSize]; 
    }

    public void initializeQueue()  { 
        for (int i = queueFront; i < queueRear; i = (i + 1) % maxQueueSize) 
            list[i] = null; 
        queueFront = 0; 
        queueRear = maxQueueSize - 1; 
        count = 0; 
    }

    public boolean isEmpty()  { 
        return (count == 0); 
    }

    public boolean isFullQueue() { 
        return (count == maxQueueSize); 
    }

    public T first(){ //throws QueueUnderflowException  { 
        if (isEmpty()) 
            return null;
        return (T) list[queueFront]; 
    }

    public T back() throws QueueUnderflowException { 
        if (isEmpty()) 
            throw new QueueUnderflowException(); 
        return (T) list[queueRear]; 
    }

    public void enqueue(T newItem) { 
        if (isFullQueue()) 
            System.err.println("Cannot enqueue in a full queue!"); 
        else { 
            queueRear = (queueRear + 1) % maxQueueSize; // circular array 
            count++; 
            list[queueRear] = newItem; 
        } 
    }

    public T dequeue() { 
        if (isEmpty()) 
            return null; 
        T ret = (T) list[queueRear];
        count--; 
        list[queueFront] = null; 
        queueFront = (queueFront + 1) % maxQueueSize; // circular array 
        return ret;
    } 

    private static class QueueUnderflowException extends Exception {
        public QueueUnderflowException() {
        }
    }

    public int size(){
        return count;
    }
}