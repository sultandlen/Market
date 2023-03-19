public class PriorityQueue implements Queues { //implemented from Queues
    // array that removes items in ascending order
    private int maxSize;
    private int[] priorityQueue;
    private int nItems;

    public PriorityQueue(int maxSize) { // constructor that takes one parameter
        this.maxSize = maxSize;
        this.priorityQueue = new int[maxSize];
        this.nItems = 0;
    }

    public void insert(int completionTime){ // put item at rear of priority queue
        if (nItems != maxSize){ // if the queue is not full;
            priorityQueue[nItems] = completionTime; //increment rear and insert
            nItems++; // one more item
        }
        else{
            System.out.println("The queue is full!");
        }
    }

    public int remove(){ // remove minimum item
        int min = -1;
        int index = 0;
        int removed = priorityQueue[0];
        for(int i = 0; i < nItems; i++){
            if(min == -1){
                min = priorityQueue[0];
            }
            else if(priorityQueue[i] < min){ // searching for the minimum item
                min = priorityQueue[i];
                removed = priorityQueue[i];
                index = i; //index of the minimum item
            }
        }

        for (int j = index; j < nItems - 1; j++){ //shifting all elements that are after minimum item to front of queue
            priorityQueue[j] = priorityQueue[j + 1];
        }

        nItems--; // one less item
        return removed;
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
