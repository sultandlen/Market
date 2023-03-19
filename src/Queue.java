public class Queue implements Queues{ //implemented from Queues
    private int maxSize; //size of queue
    private int[] queue;
    private int rear;
    private int nItems;

    public Queue(int maxSize) { //constructor that takes one parameter
        this.maxSize = maxSize;
        this.queue = new int[maxSize];
        this.rear = -1;
        this.nItems = 0;
    }

    public void insert (int completionTime){ // put item at rear of queue
        if(nItems != maxSize){ // if the queue is not full;
            queue[++rear] = completionTime; //increment rear and insert
            nItems++; // one more item
        }else{
            System.out.println("The queue is full!");
        }
    }

    public int remove(){ // take item from front of queue
        int removed = queue[0];
        for (int i = 1; i < nItems; i++){
            queue[i - 1] = queue[i]; // shifting all elements to front of queue
        }
        nItems--; // one less item
        return removed;
    }

    public int peek(){ // peek at front of queue
        return queue[0];
    }

    public boolean isEmpty(){ // true if queue is empty
        return (nItems == 0);
    }

    public boolean isFull(){ // true if queue is full
        return (nItems == maxSize);
    }

    public int size(){ // number of items in queue
        return nItems;
    }
}
