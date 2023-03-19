interface Queues {
    //created to use the method that calculates completion times for both queue and priority queue

    void insert(int completionTime); //common methods for queue and priority queue
    int remove();
    boolean isEmpty();
    boolean isFull();
    int size();
}